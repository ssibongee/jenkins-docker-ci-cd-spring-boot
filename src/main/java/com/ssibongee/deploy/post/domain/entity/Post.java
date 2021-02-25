package com.ssibongee.deploy.post.domain.entity;

import com.ssibongee.deploy.post.domain.dto.PostUpdateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    private String title;

    private String author;

    @Lob
    private String content;

    @Column(name = "IS_REMOVED")
    private Boolean removed = false;

    @Builder
    public Post(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public long update(PostUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        return this.getId();
    }

    public long remove() {
        this.removed = true;
        return this.getId();
    }
}
