package com.blck.springdemo.mapper;



import java.sql.Timestamp;

import com.blck.springdemo.model.Company;
import com.blck.springdemo.model.InvitationToken;
import com.blck.springdemo.po.CompanyPo;
import com.blck.springdemo.po.InvitationTokenPo;

public class InvitationTokenMapper {
    public InvitationToken toBusinessObject(InvitationTokenPo persistentObject) {
        var invitationToken = new InvitationToken();
        invitationToken.setId(persistentObject.getId());
        invitationToken.setToken(persistentObject.getToken());
        invitationToken.setStatus(persistentObject.getStatus());
        invitationToken.setCreateDateTime(new Timestamp(persistentObject.getCreateDateTime().getTime()).toLocalDateTime());
        invitationToken.setExpireDateTime(new Timestamp(persistentObject.getExpireDateTime().getTime()).toLocalDateTime());
        invitationToken.setStatusDateTime(new Timestamp(persistentObject.getStatusDateTime().getTime()).toLocalDateTime());
        invitationToken.setEmail(persistentObject.getEmail());
        invitationToken.setCompany(new Company(persistentObject.getCompany().getId()));
        return invitationToken;
    }

    public InvitationTokenPo toPersistentCreateObject(InvitationToken businessObject) {
        return getInvitationTokenPo(businessObject, new InvitationTokenPo());
    }

    public InvitationTokenPo toPersistentUpdateObject(InvitationToken businessObject, InvitationTokenPo persistentObject) {
        return getInvitationTokenPo(businessObject, persistentObject);
    }

    private InvitationTokenPo getInvitationTokenPo(InvitationToken invitationToken, InvitationTokenPo invitationTokenPo) {
        invitationTokenPo.setToken(invitationToken.getToken());
        invitationTokenPo.setStatus(invitationToken.getStatus());
        invitationTokenPo.setCreateDateTime(Timestamp.valueOf(invitationToken.getCreateDateTime()));
        invitationTokenPo.setExpireDateTime(Timestamp.valueOf(invitationToken.getExpireDateTime()));
        invitationTokenPo.setStatusDateTime(Timestamp.valueOf(invitationToken.getStatusDateTime()));
        invitationTokenPo.setEmail(invitationToken.getEmail());
        invitationTokenPo.setCompany(new CompanyPo(invitationToken.getCompany().getId()));
        return invitationTokenPo;
    }
}
