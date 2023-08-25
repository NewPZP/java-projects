package io.github.newpzp.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("io.github.newpzp.blog.domain.mapper")
public class MybatisConf {
    
}
