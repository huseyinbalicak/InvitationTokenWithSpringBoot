package com.blck.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.spring5.SpringTemplateEngine;
import com.blck.springdemo.mapper.InvitationTokenMapper;
import com.blck.springdemo.repository.InvitationTokenRepository;
import com.blck.springdemo.repository.InvitationTokenSpringRepository;
import com.blck.springdemo.repositoryImpl.EmailSenderServiceImpl;
import com.blck.springdemo.repositoryImpl.InvitationTokenRepositoryImpl;
import com.blck.springdemo.service.EmailSenderService;
import com.blck.springdemo.service.InvitationTokenService;
@Configuration
public class AppConfig {
	@Bean
    public InvitationTokenService invitationTokenService(InvitationTokenRepository invitationTokenRepository, EmailSenderService emailSenderService) {
        return new InvitationTokenService(invitationTokenRepository, emailSenderService);
    }

    @Bean
    public InvitationTokenMapper invitationTokenMapper() {
        return new InvitationTokenMapper();
    }
    
    @Bean
    public EmailSenderService emailSenderService(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
        return new EmailSenderServiceImpl(javaMailSender, templateEngine);
    }
    @Bean
    public InvitationTokenRepository invitationTokenRepository(
            InvitationTokenSpringRepository invitationTokenSpringRepository, InvitationTokenMapper invitationTokenMapper) {
        return new InvitationTokenRepositoryImpl(invitationTokenSpringRepository, invitationTokenMapper);
    }


}
