package com.blck.springdemo.repository;
import com.blck.springdemo.model.InvitationToken;

public interface InvitationTokenRepository extends NormalRepository<InvitationToken> {

    InvitationToken getByCompanyEmail(Long companyId, String email);
    InvitationToken getByInvitationToken(String invitationToken);

}
