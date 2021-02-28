package com.ssibongee.deploy.post.controller;

import com.ssibongee.deploy.post.domain.dto.PostCreateRequest;
import com.ssibongee.deploy.post.domain.dto.PostResponse;
import com.ssibongee.deploy.post.domain.dto.PostUpdateRequest;
import com.ssibongee.deploy.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostApiController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public String findById(@PathVariable Long postId) {
        return String.valueOf(postId);
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody PostCreateRequest request) {
        return ResponseEntity.ok(postService.save(request));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Long> update(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        return ResponseEntity.ok(postService.update(postId, request));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Long> delete(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.delete(postId));
    }

}
