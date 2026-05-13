package com.cfs.Payment_Gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String name, String course, double amount)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("Payment Successful - " + course);
        mailMessage.setText(
                "Hi " + name + ",\n\n" +

                        "🎉 Congratulations! Your payment was successful.\n\n" +

                        "You are now officially enrolled in the course: " + course + ".\n\n" +

                        "We’re excited to have you on board and can’t wait to see you in our live sessions.\n" +
                        "Get ready to learn, grow, and achieve your goals with us!\n\n" +

                        "If you have any questions or need assistance, feel free to reply to this email.\n\n" +

                        "Best regards"
        );

        javaMailSender.send(mailMessage);
    }
}
