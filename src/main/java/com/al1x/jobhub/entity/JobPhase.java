package com.al1x.jobhub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "job_phase")
public class JobPhase {
    @Id
    @Column(name = "id_phase", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id_job", nullable = false)
    private Job jobIdJob;

}