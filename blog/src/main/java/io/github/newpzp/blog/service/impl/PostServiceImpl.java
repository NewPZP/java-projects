package io.github.newpzp.blog.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.newpzp.blog.domain.dto.CreatePostDTO;
import io.github.newpzp.blog.domain.dto.PostDetailsDTO;
import io.github.newpzp.blog.domain.dto.UpdatePostDTO;
import io.github.newpzp.blog.domain.entity.Post;
import io.github.newpzp.blog.domain.entity.PostTag;
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
    public PostDetailsDTO getPostById(Long id){
        Post post = postMapper.selectById(id);
        List<PostTag> postTags = postTagMapper.selectList(new QueryWrapper<PostTag>().eq("post_id", post.getId()));
        List<Integer> tagIds = postTags.stream().map(p -> p.getTagId()).collect(Collectors.toList());
        List<Tag> tags = tagMapper.selectBatchIds(tagIds);
        List<String> tagNames = tags.stream().map(t -> t.getName()).collect(Collectors.toList());

        String categoryName = categoryMapper.selectById(post.getCategoryId()).getName();

        PostDetailsDTO postDTO = PostDetailsDTO.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .categoryName(categoryName)
                .tagNames(tagNames)
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
        return postDTO;
    }

    @Override
    public PostDetailsDTO createPost(CreatePostDTO createPostDTO){
        Post post = Post.builder()
                        .title(createPostDTO.getTitle())
                        .content(createPostDTO.getContent())
                        .categoryId(createPostDTO.getCategoryId())
                        .userId(0L)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();
        postMapper.insert(post);
        //TODO: 添加事务处理
        //处理标签
        if(createPostDTO.getTagNames().size() <= 0){
            return getPostById(post.getId());
        }
        List<Tag> tags = tagMapper.selectList(new QueryWrapper<Tag>().in("name", createPostDTO.getTagNames()));       
        List<PostTag> postTag = postTagMapper.selectList(new QueryWrapper<PostTag>().eq("post_id", post.getId()));

        return getPostById(post.getId());
    }

    @Override
    public PostDetailsDTO updatePost(UpdatePostDTO updatePostDTO){
        Post post = Post.builder()
                        .build();
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
    public List<PostDetailsDTO> getPostsByTag(String tagName) {

      
        Tag tag = tagMapper.selectOne(new QueryWrapper<Tag>().eq("name", tagName));
        List<PostTag> postTags = postTagMapper.selectList(new QueryWrapper<PostTag>().eq("tag_id", tag.getId()));
        List<Long> postIds = postTags.stream().map(PostTag::getPostId).collect(Collectors.toList());
        List<Post> posts = postMapper.selectBatchIds(postIds);
        // postTags = postTagMapper.selectList(new QueryWrapper<PostTag>().in("post_id", postIds));
        // String categoryName = categoryMapper.se

        return this.convertToDTOList(posts);
    }

    @Override
    public List<PostDetailsDTO> getPostsByCategory(String categoryName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostsByCategory'");
    }

    @Override
    public List<PostDetailsDTO> searchPosts(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPosts'");
    }

    @Override
    public List<PostDetailsDTO> recentPost(Integer limit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recentPost'");
    }

    public List<PostDetailsDTO> convertToDTOList(List<Post> posts) {
       return null;
    }
}
