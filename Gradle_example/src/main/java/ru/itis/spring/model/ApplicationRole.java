package ru.itis.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplicationRole {
    @Id
    private String role;
}
