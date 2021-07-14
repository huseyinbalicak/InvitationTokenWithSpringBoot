package com.blck.springdemo.service;
import com.blck.springdemo.exception.AppRuntimeException;
import com.blck.springdemo.model.Company;
import com.blck.springdemo.model.InvitationStatus;
import com.blck.springdemo.model.InvitationToken;
import com.blck.springdemo.model.Mail;
import com.blck.springdemo.repository.InvitationTokenRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class InvitationTokenService {

    private final InvitationTokenRepository invitationTokenRepository;
    private final EmailSenderService emailSenderService;


    public InvitationTokenService(InvitationTokenRepository invitationTokenRepository, EmailSenderService emailSenderService) {
        this.invitationTokenRepository = invitationTokenRepository;
        this.emailSenderService = emailSenderService;
    }


    public InvitationToken getOne(Long id) {
        return invitationTokenRepository.getOne(id);
    }

    public List<InvitationToken> all() {
        return invitationTokenRepository.all();
    }

    public InvitationToken createInvitation(Long companyId, String email) {

        var invitationToken = invitationTokenRepository.getByCompanyEmail(companyId, email);
        if (invitationToken == null) {
            invitationToken = new InvitationToken();
            invitationToken.setCompany(new Company(companyId));
            invitationToken.setToken(UUID.randomUUID().toString());
            invitationToken.setEmail(email);
            invitationToken.setCreateDateTime(LocalDateTime.now());
            invitationToken.setExpireDateTime(LocalDateTime.now().plusDays(7));
            invitationToken.setStatusDateTime(LocalDateTime.now());
            invitationToken.setStatus(InvitationStatus.PENDING);
            invitationToken = invitationTokenRepository.save(invitationToken);
        } else {
            invitationToken.setToken(UUID.randomUUID().toString());
            invitationToken.setStatusDateTime(LocalDateTime.now());
            invitationToken.setStatus(InvitationStatus.PENDING);
            invitationToken.setExpireDateTime(LocalDateTime.now().plusDays(7));
            invitationToken = invitationTokenRepository.save(invitationToken);
        }

        sendInvitationMail(email, invitationToken.getToken());

        return invitationToken;
    }

    public void deleteInvitation(Long id)
    {
        var invitationToken = invitationTokenRepository.getOne(id);

        if (invitationToken.getExpireDateTime().isBefore(LocalDateTime.now())) {
            invitationTokenRepository.deleteById(id);
        }
    }

    public void sendInvitationMail(String email, String token) {
        var invitationUrl = "http://localhost:8080/api/invitation/accept?token=" + token;
        var subject = "An invitation link has been sent to you to start as an provider in our company.";

        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "MehmetBerber!");
        properties.put("location", "Belgium");
        properties.put("invitationUrl", invitationUrl);

        var mail = Mail.builder()
                .from("huseyin@test.com")
                .to(email)
                .htmlTemplate(new Mail.HtmlTemplate("invitation", properties))
                .subject(subject)
                .build();

        emailSenderService.sendEmail(mail);
    }


    public InvitationToken updateInvitation(Long id, InvitationToken invitationToken) {
        InvitationToken existing = invitationTokenRepository.getOne(id);
        if (invitationToken.getId().compareTo(existing.getId()) != 0) {
            throw new AppRuntimeException("not.found");
        }

        existing.setCompany(new Company(invitationToken.getCompany().getId()));
        existing.setEmail(invitationToken.getEmail());

        existing.setCreateDateTime(LocalDateTime.now());

        existing.setToken(UUID.randomUUID().toString());
        existing.setStatusDateTime(LocalDateTime.now());
        existing.setStatus(InvitationStatus.PENDING);
        existing.setExpireDateTime(LocalDateTime.now().plusDays(7));

        return invitationTokenRepository.save(existing);
    }
}
