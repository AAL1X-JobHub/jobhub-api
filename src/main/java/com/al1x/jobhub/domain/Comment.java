package com.al1x.jobhub.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id_comment", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "members_id", nullable = false)
    private Member members;

    @Column(name = "content", nullable = false, length = Integer.MAX_VALUE)
    private String content;

    @Column(name = "posted_date", nullable = false)
    private Integer postedDate;

    @Column(name = "likes_count", nullable = false)
    private Integer likesCount;

}