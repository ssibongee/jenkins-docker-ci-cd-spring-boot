package com.ssibongee.deploy.post.service;

import com.ssibongee.deploy.post.domain.dto.PostCreateRequest;
import com.ssibongee.deploy.post.domain.dto.PostResponse;
import com.ssibongee.deploy.post.domain.dto.PostUpdateRequest;

public interface PostService {

    public Long save(PostCreateRequest request);

    public Long update(Long postId, PostUpdateRequest request);

    public PostResponse findById(Long postId);

    public Long delete(Long postId);
}
