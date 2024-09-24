package com.al1x.jobhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role", nullable = false, length = 50)
    private String role;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "date_create", nullable = false)
    private LocalDate dateCreate;

    @Column(name = "active_account", nullable = false)
    private Boolean activeAccount = false;

}