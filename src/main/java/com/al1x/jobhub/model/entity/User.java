package com.al1x.jobhub.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Applicant applicant;
}