package com.blck.springdemo.po;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "company")
public class CompanyPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String uuid;
    private String slug;
    private String taxNumber;

	public CompanyPo() {
        // default constructor
    }

    public CompanyPo(Long id) {
        this.id = id;
    }
}
