package io.github.newpzp.blog.domain.mapper;
import io.github.newpzp.blog.domain.entity.PortfolioItem;

import org.apache.ibatis.annotations.Mapper;

import com.mybatisflex.core.BaseMapper;

@Mapper
public interface PortfolioItemMapper extends BaseMapper<PortfolioItem>{
    
}
