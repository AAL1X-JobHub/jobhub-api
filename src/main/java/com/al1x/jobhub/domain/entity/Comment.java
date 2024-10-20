package com.al1x.jobhub.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "members_id", referencedColumnName = "id", nullable = false)
    private Member members;

    @Column(name = "content", nullable = false, length = Integer.MAX_VALUE)
    private String content;

    @Column(name = "posted_date", nullable = false)
    private LocalDate postedDate;

    @Column(name = "likes_count", nullable = false)
    private Integer likesCount;
}