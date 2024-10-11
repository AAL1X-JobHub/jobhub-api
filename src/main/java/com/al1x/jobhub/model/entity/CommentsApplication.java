package com.al1x.jobhub.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "comments_applications")
public class CommentsApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_create", nullable = false)
    private LocalDate dateCreate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @Column(name = "comment", nullable = false, length = Integer.MAX_VALUE)
    private String comment;

    @Column(name = "author", nullable = false, length = 50)
    private String author;
}