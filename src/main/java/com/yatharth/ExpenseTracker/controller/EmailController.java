package com.yatharth.ExpenseTracker.controller;

import com.yatharth.ExpenseTracker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(
            @RequestParam String email
    ) {

        emailService.sendReport(email);

        return "Email Sent Successfully";
    }
}