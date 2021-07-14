package com.blck.springdemo.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blck.springdemo.dto.InvitationTokenDto;
import com.blck.springdemo.mapper.InvitationTokenDtoMapper;
import com.blck.springdemo.service.InvitationTokenService;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/user/invitation-tokens")
public class InvitationTokenController {

    private final InvitationTokenService invitationTokenService;
    private final InvitationTokenDtoMapper invitationTokenDtoMapper;
    
    public InvitationTokenController(InvitationTokenService invitationTokenService, InvitationTokenDtoMapper invitationTokenDtoMapper) {
        this.invitationTokenService = invitationTokenService;
        this.invitationTokenDtoMapper = invitationTokenDtoMapper;
       
    }

    @GetMapping("")
    public List<InvitationTokenDto> all() {
        return invitationTokenService.all().stream().map(invitationTokenDtoMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public InvitationTokenDto getOne(@PathVariable Long id) {
        return invitationTokenDtoMapper.toDto(invitationTokenService.getOne(id));
    }


    @PostMapping("")
    public InvitationTokenDto create(@RequestBody InvitationTokenDto invitationTokenDto) {
        var invitationToken = invitationTokenService.createInvitation(invitationTokenDto.getCompanyId(), invitationTokenDto.getEmail());
        return invitationTokenDtoMapper.toDto(invitationToken);
    }

    @PutMapping("/{id}")
    public InvitationTokenDto update(@PathVariable Long id, @RequestBody InvitationTokenDto invitationTokenDto) {
        return invitationTokenDtoMapper.toDto(invitationTokenService.updateInvitation(id, invitationTokenDtoMapper.toBusinessObject(invitationTokenDto)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<InvitationTokenDto> delete(@PathVariable Long id) {
        invitationTokenService.deleteInvitation(id);
        return ResponseEntity.noContent().build();
    }

}
