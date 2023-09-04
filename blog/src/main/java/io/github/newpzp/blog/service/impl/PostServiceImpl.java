package io.github.newpzp.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.newpzp.blog.domain.dto.PostDTO;
import io.github.newpzp.blog.domain.entity.Post;
import io.github.newpzp.blog.domain.entity.Tag;
import io.github.newpzp.blog.domain.mapper.CategoryMapper;
import io.github.newpzp.blog.domain.mapper.PostMapper;
import io.github.newpzp.blog.domain.mapper.PostTagMapper;
import io.github.newpzp.blog.domain.mapper.TagMapper;
import io.github.newpzp.blog.service.PostService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostServiceImpl implements PostService{
    
    @Autowired
    private final PostMapper postMapper;

    @Autowired
    private final TagMapper tagMapper;

    @Autowired
    private final PostTagMapper postTagMapper;

    @Autowired
    private final CategoryMapper categoryMapper;

    @Override
    public PostDTO getPostById(Long id){
        PostDTO postDTO = new PostDTO();
        Post post = postMapper.selectById(id);

        return postDTO;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO){
        Post post = new Post();

        //TODO
        postMapper.insert(post);
        return getPostById(post.getId());
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO){
        Post post = new Post();
        //TODO
        postMapper.updateById(post);
        return getPostById(post.getId());
    }
    @Override
    public boolean deletePost(Long id){
        
        int rows = postMapper.deleteById(id);
        return rows>0;
    }

    @Override
    public List<PostDTO> getPostsByTag(String tagName) {
      
        Tag tag = tagMapper.selectOne(new QueryWrapper<Tag>().eq("name", tagName));
        

        throw new UnsupportedOperationException("Unimplemented method 'getPostsByTag'");
    }

    @Override
    public List<PostDTO> getPostsByCategory(String categoryName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostsByCategory'");
    }

    @Override
    public List<PostDTO> searchPosts(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPosts'");
    }

    @Override
    public List<PostDTO> recentPost(String userId, Integer limit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recentPost'");
    }

}
