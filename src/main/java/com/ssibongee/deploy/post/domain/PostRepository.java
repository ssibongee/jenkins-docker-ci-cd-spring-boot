package com.ssibongee.deploy.post.domain;

import com.ssibongee.deploy.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p where p.id = :postId AND p.removed = false")
    public Optional<Post> findPostById(@Param("postId") long postId);
}
