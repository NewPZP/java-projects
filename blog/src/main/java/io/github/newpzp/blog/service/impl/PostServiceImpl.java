package io.github.newpzp.blog.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.github.newpzp.blog.domain.dto.CreatePostDTO;
import io.github.newpzp.blog.domain.dto.PostDetailsDTO;
import io.github.newpzp.blog.domain.dto.QueryPostDTO;
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
    public boolean createPost(CreatePostDTO createPostDTO){
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
            return true;
        }
        for(String tagName:createPostDTO.getTagNames()){
            if(tagMapper.selectCount(new QueryWrapper<Tag>().eq("name", tagName)) == 0)
                tagMapper.insert(Tag.builder().name(tagName).build());
        }
        List<Tag> tags = tagMapper.selectList(new QueryWrapper<Tag>().in("name", createPostDTO.getTagNames())); 
        if(tags.size()>0){
            for(Tag tag:tags){
                PostTag postTag = PostTag.builder()
                        .postId(post.getId())
                        .tagId(tag.getId())
                        .build();
                postTagMapper.insert(postTag);
            }
        }      
        return true;
    }

    @Override
    public boolean updatePost(UpdatePostDTO updatePostDTO){
        Post post = Post.builder()
                        .title(updatePostDTO.getTitle())
                        .content(updatePostDTO.getContent())
                        .categoryId(updatePostDTO.getCategoryId())
                        .build();
        postMapper.updateById(post);
        if(updatePostDTO.getTagNames().size() <= 0){
            return true;
        }

        for(String tagName:updatePostDTO.getTagNames()){
            if(tagMapper.selectCount(new QueryWrapper<Tag>().eq("name", tagName)) == 0)
                tagMapper.insert(Tag.builder().name(tagName).build());
        }
        List<Tag> tags = tagMapper.selectList(new QueryWrapper<Tag>().in("name", updatePostDTO.getTagNames())); 
        if(tags.size()>0){
            for(Tag tag:tags){
                PostTag postTag = PostTag.builder()
                        .postId(post.getId())
                        .tagId(tag.getId())
                        .build();
                postTagMapper.insert(postTag);
            }
        }      
        return true;
    }
    @Override
    public boolean deletePost(Long id){
        
        int rows = postMapper.deleteById(id);
        return rows>0;
    }

    @Override
    public Page<PostDetailsDTO> getPostsByTag(QueryPostDTO queryPostDTO) {
        Page<Post> postPage = new Page<>(queryPostDTO.getCurrent(), queryPostDTO.getOffset());
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                    .like(Objects.nonNull(queryPostDTO.getSearchTxt()), Post::getTitle, queryPostDTO.getSearchTxt())
                    //.like(Objects.nonNull(queryPostDTO.getSearchTxt()), Post::getContent, queryPostDTO.getSearchTxt())
                    .ge(Objects.nonNull(queryPostDTO.getCreatedStart()), Post::getCreatedAt, queryPostDTO.getCreatedStart())
                    .le(Objects.nonNull(queryPostDTO.getCreatedEnd()), Post::getCreatedAt, queryPostDTO.getCreatedEnd())
                    ;

        postPage = postMapper.selectPage(postPage, queryWrapper);
        
        return null;
    }

    @Override
    public Page<PostDetailsDTO> getPostsByCategory(QueryPostDTO queryPostDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostsByCategory'");
    }

    @Override
    public Page<PostDetailsDTO> searchPosts(QueryPostDTO queryPostDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPosts'");
    }

    @Override
    public Page<PostDetailsDTO> recentPost(QueryPostDTO queryPostDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recentPost'");
    }

    public List<PostDetailsDTO> convertToDTOList(List<Post> posts) {
       return null;
    }
}
