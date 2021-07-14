package com.blck.springdemo.po;
import com.blck.springdemo.model.InvitationStatus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.sql.Timestamp;

@Getter
@Setter
@Entity(name = "invitation_token")
public class InvitationTokenPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @Enumerated(EnumType.STRING)
    private InvitationStatus status;
    private Timestamp createDateTime;
    private Timestamp expireDateTime;
    private Timestamp statusDateTime;
    private String email;
    @OneToOne(fetch = FetchType.LAZY)
    private CompanyPo company;


	public InvitationTokenPo() {
        // default constructor
    }

    public InvitationTokenPo(Long id) {
        this.id = id;
    }


}
