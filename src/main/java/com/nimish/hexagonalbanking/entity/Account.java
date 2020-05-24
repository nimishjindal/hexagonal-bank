package com.nimish.hexagonalbanking.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Date dob;
    private Double balance = 0d;

    public Account(String name, Date dob){
        this.name = name;
        this.dob = dob;
    }

}
