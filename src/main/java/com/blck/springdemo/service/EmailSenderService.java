package com.blck.springdemo.service;
import com.blck.springdemo.model.Mail;



public interface EmailSenderService {

    void sendEmail(Mail mail);

}
