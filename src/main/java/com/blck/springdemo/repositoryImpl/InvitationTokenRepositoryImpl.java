package com.blck.springdemo.repositoryImpl;



import java.util.List;
import java.util.stream.Collectors;

import com.blck.springdemo.mapper.InvitationTokenMapper;
import com.blck.springdemo.model.InvitationToken;
import com.blck.springdemo.po.CompanyPo;
import com.blck.springdemo.po.InvitationTokenPo;
import com.blck.springdemo.repository.InvitationTokenRepository;
import com.blck.springdemo.repository.InvitationTokenSpringRepository;

public class InvitationTokenRepositoryImpl implements InvitationTokenRepository {

    private final InvitationTokenMapper invitationTokenMapper;
    private final InvitationTokenSpringRepository invitationTokenSpringRepository;

    public InvitationTokenRepositoryImpl(InvitationTokenSpringRepository invitationTokenSpringRepository, InvitationTokenMapper invitationTokenMapper) {
        this.invitationTokenMapper = invitationTokenMapper;
        this.invitationTokenSpringRepository = invitationTokenSpringRepository;
    }

    @Override
    public InvitationToken getOne(Long id) {
        return invitationTokenMapper.toBusinessObject(invitationTokenSpringRepository.getOne(id));
    }

    @Override
    public InvitationToken save(InvitationToken data) {
        InvitationTokenPo invitationTokenPo;
        if (data.getId() == null) {
            invitationTokenPo = invitationTokenMapper.toPersistentCreateObject(data);
        } else {
            var existing = invitationTokenSpringRepository.getOne(data.getId());
            invitationTokenPo = invitationTokenMapper.toPersistentUpdateObject(data, existing);
        }

        return invitationTokenMapper.toBusinessObject(invitationTokenSpringRepository.save(invitationTokenPo));
    }

    @Override
    public void deleteById(Long id) {
        invitationTokenSpringRepository.deleteById(id);
    }

    @Override
    public InvitationToken getByCompanyEmail(Long companyId, String email) {
        var invitationTokenPo = invitationTokenSpringRepository.getByCompanyAndEmail(new CompanyPo(companyId), email);
        if (invitationTokenPo != null) {
            return invitationTokenMapper.toBusinessObject(invitationTokenPo);
        }

        return null;
    }

    @Override
    public InvitationToken getByInvitationToken(String invitationToken) {
        var invitationTokenPo = invitationTokenSpringRepository.getByToken(invitationToken);
        if (invitationTokenPo != null) {
            return invitationTokenMapper.toBusinessObject(invitationTokenPo);
        }

        return null;
    }

    @Override
    public List<InvitationToken> all() {
        return invitationTokenSpringRepository.findAll().stream().map(invitationTokenMapper::toBusinessObject).collect(Collectors.toList());

    }
}
