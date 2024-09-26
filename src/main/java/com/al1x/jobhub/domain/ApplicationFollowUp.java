package com.al1x.jobhub.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "application_follow_up")
public class ApplicationFollowUp {
    @Id
    @Column(name = "id_follow_application", nullable = false)
    private Integer id;

    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDate lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_phase_id_phase", nullable = false)
    private JobPhase jobPhaseIdPhase;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

}