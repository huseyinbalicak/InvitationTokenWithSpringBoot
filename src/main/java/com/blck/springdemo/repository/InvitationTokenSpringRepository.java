package com.blck.springdemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.blck.springdemo.po.CompanyPo;
import com.blck.springdemo.po.InvitationTokenPo;

public interface InvitationTokenSpringRepository extends JpaRepository<InvitationTokenPo, Long> {

    InvitationTokenPo getByCompanyAndEmail(CompanyPo companyPo, String email);

    InvitationTokenPo getByToken(String token);
}
