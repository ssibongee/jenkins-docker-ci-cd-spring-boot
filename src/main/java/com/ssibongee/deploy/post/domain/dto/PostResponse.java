package com.ssibongee.deploy.post.domain.dto;

import com.ssibongee.deploy.post.domain.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostResponse {

    public Long id;

    private String title;

    private String author;

    private String content;

    private LocalDateTime createdTime;

    private LocalDateTime modifiedTime;

    @Builder
    public PostResponse(Long id, String title, String author, String content,
                        LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(post.getAuthor())
                .content(post.getContent())
                .createdTime(post.getCreatedTime())
                .modifiedTime(post.getModifiedTime())
                .build();
    }
}
