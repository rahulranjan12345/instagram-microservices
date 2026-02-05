package com.social.instagram.post.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String caption;
    private String imageUrl;

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getCaption() { return caption; }
    public String getImageUrl() { return imageUrl; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setCaption(String caption) { this.caption = caption; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
