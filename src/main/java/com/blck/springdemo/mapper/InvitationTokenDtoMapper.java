package com.blck.springdemo.mapper;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import com.blck.springdemo.dto.InvitationTokenDto;
import com.blck.springdemo.model.Company;
import com.blck.springdemo.model.InvitationToken;
@AllArgsConstructor
@Component
public class InvitationTokenDtoMapper implements Mapper<InvitationToken, InvitationTokenDto> {
    @Override
    public InvitationTokenDto toDto(InvitationToken invitationToken) {
        var invitationTokenDto = new InvitationTokenDto();
        invitationTokenDto.setId(invitationToken.getId());
        invitationTokenDto.setToken(invitationToken.getToken());
        invitationTokenDto.setStatus(invitationToken.getStatus());
        invitationTokenDto.setCreateDateTime(invitationToken.getCreateDateTime());
        invitationTokenDto.setExpireDateTime(invitationToken.getExpireDateTime());
        invitationTokenDto.setStatusDateTime(invitationToken.getStatusDateTime());
        invitationTokenDto.setEmail(invitationToken.getEmail());
        invitationTokenDto.setCompanyId(invitationToken.getCompany().getId());

        return invitationTokenDto;
    }

    @Override
    public InvitationToken toBusinessObject(InvitationTokenDto invitationTokenDto) {
        var invitationToken = new InvitationToken();
        invitationToken.setId(invitationTokenDto.getId());
        invitationToken.setToken(invitationTokenDto.getToken());
        invitationToken.setStatus(invitationTokenDto.getStatus());
        invitationToken.setCreateDateTime(invitationTokenDto.getCreateDateTime());
        invitationToken.setExpireDateTime(invitationTokenDto.getExpireDateTime());
        invitationToken.setStatusDateTime(invitationTokenDto.getStatusDateTime());
        invitationToken.setEmail(invitationTokenDto.getEmail());
        invitationToken.setCompany(new Company(invitationTokenDto.getCompanyId()));

        return invitationToken;
    }
}
