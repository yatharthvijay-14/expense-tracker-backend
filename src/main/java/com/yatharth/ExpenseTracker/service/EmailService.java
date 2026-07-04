package com.yatharth.ExpenseTracker.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.yatharth.ExpenseTracker.model.Expense;
import com.yatharth.ExpenseTracker.repository.ExpenseRepository;

import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ExpenseRepository expenseRepository;

    public void sendReport(String toEmail) {

        try {

            String pdfPath = "expense-report.pdf";

            Document document = new Document();

            PdfWriter.getInstance(
                    document,
                    new FileOutputStream(pdfPath)
            );

            document.open();

            document.add(
                    new Paragraph("Expense Tracker Report")
            );

            document.add(new Paragraph(" "));

            List<Expense> expenses =
                    expenseRepository.findAll();

            for (Expense expense : expenses) {

                document.add(
                        new Paragraph(
                                expense.getTitle()
                                        + " | ₹"
                                        + expense.getAmount()
                                        + " | "
                                        + expense.getCategory()
                                        + " | "
                                        + expense.getExpenseDate()
                        )
                );
            }

            document.close();

            MimeMessage message =
                    mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(
                            message,
                            true
                    );

            helper.setTo(toEmail);

            helper.setSubject(
                    "Expense Tracker Report"
            );

            helper.setText(
                    "Please find attached your expense report."
            );

            FileSystemResource file =
                    new FileSystemResource(
                            new File(pdfPath)
                    );

            helper.addAttachment(
                    "expense-report.pdf",
                    file
            );

            mailSender.send(message);

        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "Failed to send email"
            );
        }
    }
}