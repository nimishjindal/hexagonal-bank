package com.nimish.hexagonalbanking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Flight {

    @Id
    @GeneratedValue
    private long id;
    private String origin;

}
