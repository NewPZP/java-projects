package io.github.newpzp.blog.domain.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mybatisflex.core.BaseMapper;
import io.github.newpzp.blog.domain.entity.Tag;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    
}
