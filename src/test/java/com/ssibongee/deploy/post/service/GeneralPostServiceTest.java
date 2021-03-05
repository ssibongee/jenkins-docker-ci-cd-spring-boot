package com.ssibongee.deploy.post.service;

import com.ssibongee.deploy.post.domain.PostRepository;
import com.ssibongee.deploy.post.domain.dto.PostCreateRequest;
import com.ssibongee.deploy.post.domain.dto.PostResponse;
import com.ssibongee.deploy.post.domain.dto.PostUpdateRequest;
import com.ssibongee.deploy.post.domain.entity.Post;
import com.ssibongee.deploy.post.exception.PostNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GeneralPostServiceTest {

    @InjectMocks
    private GeneralPostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    @DisplayName("새로운 게시물이 성공적으로 등록되면 등록된 게시물의 ID를 반환한다.")
    void successToCreatePost() {
        PostCreateRequest postCreateRequest = new PostCreateRequest("title", "author", "content");
        Post post = mock(Post.class);

        when(postRepository.save(any())).thenReturn(post);
        when(post.getId()).thenReturn(1L);

        assertThat(postService.save(postCreateRequest)).isEqualTo(1L);
    }

    @Test
    @DisplayName("해당 ID를 가진 게시물이 존재할 경우 성공적으로 PostResponse 객체를 반환한다.")
    void successToFindPost() {
        Post post = mock(Post.class);
        PostResponse postResponse = mock(PostResponse.class);
        when(postRepository.findPostById(1L)).thenReturn(Optional.of(post));
        when(post.getId()).thenReturn(1L);
        when(post.getTitle()).thenReturn("title");
        when(post.getContent()).thenReturn("content");

        when(postResponse.getId()).thenReturn(1L);
        when(postResponse.getTitle()).thenReturn("title");
        when(postResponse.getContent()).thenReturn("content");

        assertThat(postService.findById(1L)).isNotNull();
        assertThat(post.getId()).isEqualTo(postResponse.getId());
        assertThat(post.getTitle()).isEqualTo(postResponse.getTitle());
        assertThat(post.getContent()).isEqualTo(postResponse.getContent());

    }

    @Test
    @DisplayName("해당 ID를 가진 게시물이 존재하지 않을 경우 PostNotFoundException을 발생시킨다.")
    void isNotExistPost() {
        when(postRepository.findPostById(1L)).thenThrow(PostNotFoundException.class);

        assertThrows(PostNotFoundException.class, () -> postService.findById(2L));
    }

    @Test
    @DisplayName("성공적으로 업데이트를 수행할 경우 'title'과 'content'가 변경되고 게시글의 ID를 반환한다")
    void successToUpdate() {
        Post post = mock(Post.class);
        PostUpdateRequest postUpdateRequest = new PostUpdateRequest("title", "content");

        when(postRepository.findPostById(1L)).thenReturn(Optional.of(post));
        when(post.getId()).thenReturn(1L);
        when(post.getTitle()).thenReturn("title");
        when(post.getContent()).thenReturn("content");

        assertThat(postService.update(1L, postUpdateRequest)).isEqualTo(1L);
        assertThat(post.getTitle()).isEqualTo(postUpdateRequest.getTitle());
        assertThat(post.getContent()).isEqualTo(postUpdateRequest.getContent());
    }

    @Test
    @DisplayName("성공적으로 게시글을 삭제할 경우 'removed'가 true가 되고 게시글의 ID를 반환한다.")
    void successToRemove() {
        Post post = mock(Post.class);

        when(postRepository.findPostById(1L)).thenReturn(Optional.of(post));
        when(post.remove()).thenReturn(1L);
        when(post.getRemoved()).thenReturn(true);

        assertThat(postService.delete(1L)).isEqualTo(1L);
        assertThat(post.getRemoved()).isEqualTo(true);
    }

}
