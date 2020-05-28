package com.nimish.hexagonalbanking.infrastructure.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue
    private long id;
    private String origin;

    public Flight(String origin){
        this.origin = origin;
    }

}
