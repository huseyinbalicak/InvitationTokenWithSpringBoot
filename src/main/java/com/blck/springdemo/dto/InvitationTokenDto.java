package com.blck.springdemo.dto;
import java.time.LocalDateTime;
import com.blck.springdemo.model.InvitationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvitationTokenDto extends IdentifiableDto {

    private String token;
    private InvitationStatus status;
    private LocalDateTime createDateTime;
    private LocalDateTime expireDateTime;
    private LocalDateTime statusDateTime;
    private String email;
    private Long companyId;
    


	public InvitationTokenDto() {
        // default constructor
    }

    public InvitationTokenDto(Long id) {
        this.id = id;
    }

}
