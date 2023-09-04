package io.github.newpzp.blog.service;

import java.util.List;

import io.github.newpzp.blog.domain.dto.PostDTO;

public interface PostService {
    PostDTO getPostById(Long id);
    List<PostDTO> getPostsByTag(String tagName);
    List<PostDTO> getPostsByCategory(String categoryName);
    List<PostDTO> searchPosts(String keyword);
    List<PostDTO> recentPost(String userId, Integer limit);
    PostDTO createPost(PostDTO postDTO);
    PostDTO updatePost(PostDTO postDTO);
    boolean deletePost(Long id);
}
