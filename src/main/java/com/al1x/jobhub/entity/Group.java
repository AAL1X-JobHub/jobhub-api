package com.al1x.jobhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"group\"")
public class Group {
    @Id
    @Column(name = "id_group", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;

    @Column(name = "members_count", nullable = false)
    private Integer membersCount;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate = false;

}