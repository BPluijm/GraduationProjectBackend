package com.graduation.backend.model;

import javax.persistence.*;

public abstract class User {
    @Id
    @GeneratedValue
    @JoinColumn(name = "users-id")
    private Long id;

    private String username
    private String password;
}
