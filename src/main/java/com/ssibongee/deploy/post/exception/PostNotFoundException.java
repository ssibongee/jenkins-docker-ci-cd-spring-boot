package com.ssibongee.deploy.post.exception;

public class PostNotFoundException extends RuntimeException {

    private static final String POST_NOT_EXIST = "해당 게시물이 존재하지 않습니다.";

    public PostNotFoundException() {
        super(POST_NOT_EXIST);
    }

    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
