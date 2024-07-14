package com.example.spcourse.test.Domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Integer id;
    private String name;
    private String address;

    private String email;
}
