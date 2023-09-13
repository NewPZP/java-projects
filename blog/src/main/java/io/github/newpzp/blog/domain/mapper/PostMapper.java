package io.github.newpzp.blog.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.mybatisflex.core.BaseMapper;
import io.github.newpzp.blog.domain.entity.Post;

@Mapper
public interface PostMapper extends BaseMapper<Post>{
    
}
