package com.al1x.jobhub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id_company", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_company", nullable = false)
    private User user;

    @Column(name = "company_name", nullable = false, length = 50)
    private String companyName;

    @Column(name = "website", nullable = false, length = 50)
    private String website;

    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

}