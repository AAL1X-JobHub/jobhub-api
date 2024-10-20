package com.al1x.jobhub.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", referencedColumnName = "id",nullable = false)
    private Group group;

    @Column(name = "join_date", nullable = false)
    private LocalDate joinDate;

    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin = false;
}