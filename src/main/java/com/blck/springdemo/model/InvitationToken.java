package com.blck.springdemo.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class InvitationToken {

    private Long id;
    private String token;
    private InvitationStatus status;
    private LocalDateTime createDateTime;
    private LocalDateTime expireDateTime;
    private LocalDateTime statusDateTime;
    private String email;
    private Company company;

	public InvitationToken() {
        // default constructor
    }

    public InvitationToken(Long id) {
        this.id = id;
    }
}
