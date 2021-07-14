package com.blck.springdemo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdentifiableDto {
    protected Long id;

	public IdentifiableDto() {
        // default constructor
    }

    public IdentifiableDto(Long id) {
        this.id = id;
    }

}
