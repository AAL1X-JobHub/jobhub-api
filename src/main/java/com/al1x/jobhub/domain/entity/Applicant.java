package com.al1x.jobhub.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.spi.SourceGetter;

@Getter
@Setter
@Entity
@Table(name = "applicants")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
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

    @Column(name = "curriculum_path", nullable = false, length = 255)
    private String curriculumPath;

    @Column(name = "experience", nullable = false, length = Integer.MAX_VALUE)
    private String experience;

    @Column(name = "education", nullable = false, length = Integer.MAX_VALUE)
    private String education;

    public Applicant() {}

    public Applicant(Integer id) {
        this.id = id;
    }
}
