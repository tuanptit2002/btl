package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.Entity.EmailDetails;

public interface EmailService {

    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
