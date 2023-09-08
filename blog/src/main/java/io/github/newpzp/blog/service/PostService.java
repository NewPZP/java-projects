package io.github.newpzp.blog.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.github.newpzp.blog.domain.dto.CreatePostDTO;
import io.github.newpzp.blog.domain.dto.PostDetailsDTO;
import io.github.newpzp.blog.domain.dto.QueryPostDTO;
import io.github.newpzp.blog.domain.dto.UpdatePostDTO;

public interface PostService {
    PostDetailsDTO getPostById(Long id);
    Page<PostDetailsDTO> getPostsByTag(QueryPostDTO queryPostDTO);
    Page<PostDetailsDTO> getPostsByCategory(QueryPostDTO queryPostDTO);
    Page<PostDetailsDTO> searchPosts(QueryPostDTO queryPostDTO);
    Page<PostDetailsDTO> recentPost(QueryPostDTO queryPostDTO);
    boolean createPost(CreatePostDTO createPostDTO);
    boolean updatePost(UpdatePostDTO updatePostDTO);
    boolean deletePost(Long id);
}
