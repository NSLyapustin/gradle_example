package ru.itis.spring.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ApplicationUser {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String username;

    @Column
    private  String password;
}
