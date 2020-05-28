package com.nimish.hexagonalbanking.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dob;
    private Double balance = 0d;

    public Account(String name, Date dob){
        this.name = name;
        this.dob = dob;
    }

    public Account(){
        this.name = "Some error";
        this.dob = null;
    }

}
