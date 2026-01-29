
package com.social.instagram.common.event;

public class PostCreatedEvent {
    private Long postId;
    private Long userId;

    public PostCreatedEvent(Long postId, Long userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public Long getPostId() { return postId; }
    public Long getUserId() { return userId; }
}
