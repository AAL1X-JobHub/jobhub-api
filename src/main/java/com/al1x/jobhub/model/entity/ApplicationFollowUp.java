package com.al1x.jobhub.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "application_follow_ups")
public class ApplicationFollowUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDate lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_phase_id", referencedColumnName = "id", nullable = false)
    private JobPhase jobPhase;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", referencedColumnName = "id",nullable = false)
    private Application application;
}