package io.github.newpzp.blog.service;

import java.util.List;

import com.mybatisflex.core.paginate.Page;

import io.github.newpzp.blog.domain.dto.CreatePostDTO;
import io.github.newpzp.blog.domain.dto.PostDetailsDTO;
import io.github.newpzp.blog.domain.dto.QueryPostDTO;
import io.github.newpzp.blog.domain.dto.UpdatePostDTO;

public interface PostService {
    PostDetailsDTO getPostById(Long id);
    List<PostDetailsDTO> getPosts(QueryPostDTO queryPostDTO);
    Page<PostDetailsDTO> getPostsByPage(QueryPostDTO queryPostDTO);
    boolean createPost(CreatePostDTO createPostDTO);
    boolean updatePost(UpdatePostDTO updatePostDTO);
    boolean deletePost(Long id);
}
