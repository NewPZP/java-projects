package io.github.newpzp.blog.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;

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

import static io.github.newpzp.blog.domain.entity.table.PostTagTableDef.POST_TAG;
import static io.github.newpzp.blog.domain.entity.table.TagTableDef.TAG;


@Service("postService")
public class PostServiceImpl implements PostService{
    
    @Autowired
    private  PostMapper postMapper;

    @Autowired
    private  TagMapper tagMapper;

    @Autowired
    private  PostTagMapper postTagMapper;

    @Autowired
    private  CategoryMapper categoryMapper;


    @Override
    public PostDetailsDTO getPostById(Long id){
        Post post = postMapper.selectOneById(id);
        List<PostTag> postTags = postTagMapper.selectListByQuery(new QueryWrapper().where(POST_TAG.POST_ID.eq(id)));
        List<Integer> tagIds = postTags.stream().map(p -> p.getTagId()).collect(Collectors.toList());
        List<Tag> tags = tagMapper.selectListByIds(tagIds);
        List<String> tagNames = tags.stream().map(t -> t.getName()).collect(Collectors.toList());

        String categoryName = categoryMapper.selectOneById(post.getCategoryId()).getName();

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
        if(createPostDTO.getTagNames()==null || createPostDTO.getTagNames().size() <= 0){
            return true;
        }
        for(String tagName:createPostDTO.getTagNames()){
            if(tagMapper.selectCountByQuery(new QueryWrapper().where(TAG.NAME.eq(tagName))) == 0)
                tagMapper.insert(Tag.builder().name(tagName).build());
        }
        List<Tag> tags = tagMapper.selectListByQuery(new QueryWrapper().where(TAG.NAME.in(createPostDTO.getTagNames()))); 
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
        postMapper.update(post,true);
        if(updatePostDTO.getTagNames().size() <= 0){
            return true;
        }

        for(String tagName:updatePostDTO.getTagNames()){
            if(tagMapper.selectCountByQuery(new QueryWrapper().where(TAG.NAME.eq(tagName))) == 0)
                tagMapper.insert(Tag.builder().name(tagName).build());
        }
        List<Tag> tags = tagMapper.selectListByQuery(new QueryWrapper().where(TAG.NAME.in(updatePostDTO.getTagNames()))); 
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
    public Page<PostDetailsDTO> getPosts(QueryPostDTO queryPostDTO) {
        Page<Post> postPage = new Page<>(queryPostDTO.getCurrent(), queryPostDTO.getOffset());
     

        
        return null;
    }


}
