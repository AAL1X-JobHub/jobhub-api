package com.al1x.jobhub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "application")
public class Application {
    @Id
    @Column(name = "id_application", nullable = false)
    private Integer id;

    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

}