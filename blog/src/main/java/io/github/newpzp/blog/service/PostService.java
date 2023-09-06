package io.github.newpzp.blog.service;

import java.util.List;

import io.github.newpzp.blog.domain.dto.CreatePostDTO;
import io.github.newpzp.blog.domain.dto.PostDetailsDTO;
import io.github.newpzp.blog.domain.dto.UpdatePostDTO;

public interface PostService {
    PostDetailsDTO getPostById(Long id);
    List<PostDetailsDTO> getPostsByTag(String tagName);
    List<PostDetailsDTO> getPostsByCategory(String categoryName);
    List<PostDetailsDTO> searchPosts(String keyword);
    List<PostDetailsDTO> recentPost(Integer limit);
    PostDetailsDTO createPost(CreatePostDTO createPostDTO);
    PostDetailsDTO updatePost(UpdatePostDTO updatePostDTO);
    boolean deletePost(Long id);
}
