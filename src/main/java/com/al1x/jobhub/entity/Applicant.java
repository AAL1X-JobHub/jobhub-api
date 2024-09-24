package com.al1x.jobhub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @Column(name = "id_applicant", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_applicant", nullable = false)
    private User user;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "degree", nullable = false, length = 50)
    private String degree;

    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "college", nullable = false, length = 50)
    private String college;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

}