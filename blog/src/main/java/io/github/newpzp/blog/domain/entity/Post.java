package io.github.newpzp.blog.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private Long id;
    private Long userId;
    private Long categoryId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User user;
    private Category category;
    private List<Comment> comments;
    private List<Tag> tags;
    
    // Getters, Setters, Constructors
}
