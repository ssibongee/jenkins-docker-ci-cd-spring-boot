package com.ssibongee.deploy.post.service;

import com.ssibongee.deploy.post.domain.PostRepository;
import com.ssibongee.deploy.post.domain.dto.PostCreateRequest;
import com.ssibongee.deploy.post.domain.dto.PostResponse;
import com.ssibongee.deploy.post.domain.dto.PostUpdateRequest;
import com.ssibongee.deploy.post.domain.entity.Post;
import com.ssibongee.deploy.post.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GeneralPostService implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional
    public Long save(PostCreateRequest request) {
        return postRepository.save(request.toEntity()).getId();
    }

    @Override
    @Transactional
    public Long update(Long postId, PostUpdateRequest request) {
        Post post = postRepository.findPostById(postId).orElseThrow(PostNotFoundException::new);
        return post.getId();
    }

    @Override
    public PostResponse findById(Long postId) {
        return PostResponse.of(postRepository.findPostById(postId).orElseThrow(PostNotFoundException::new));
    }

    @Override
    @Transactional
    public Long delete(Long postId) {
        return postRepository.findPostById(postId).orElseThrow(PostNotFoundException::new).remove();
    }


}
