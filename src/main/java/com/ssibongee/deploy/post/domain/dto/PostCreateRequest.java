package com.ssibongee.deploy.post.domain.dto;

import com.ssibongee.deploy.post.domain.entity.Post;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequest {

    private String title;

    private String author;

    private String content;

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .author(this.author)
                .content(this.content)
                .build();
    }
}
