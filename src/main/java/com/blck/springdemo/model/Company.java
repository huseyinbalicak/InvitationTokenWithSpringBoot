package com.blck.springdemo.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {

    private Long id;
    private String name;
    private String uuid;
    private String slug;
    private String taxNumber;

	public Company() {
        // default constructor
    }

    public Company(Long id) {
        this.id = id;
    }

}
