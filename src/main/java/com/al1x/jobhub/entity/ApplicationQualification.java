package com.al1x.jobhub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "application_qualification")
public class ApplicationQualification {
    @Id
    @Column(name = "qualification_id", nullable = false)
    private Integer id;

    @Column(name = "level", nullable = false)
    private Integer level;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_follow_up_id_follow_application", nullable = false)
    private ApplicationFollowUp applicationFollowUpIdFollowApplication;

}