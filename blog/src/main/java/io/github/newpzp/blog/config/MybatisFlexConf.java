package io.github.newpzp.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;

import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.keygen.KeyGenerators;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;

@AutoConfiguration
@MapperScan("io.github.newpzp.blog.domain.mapper")
public class MybatisFlexConf implements MyBatisFlexCustomizer{

    @Override
    public void customize(FlexGlobalConfig flexGlobalConfig) {
       
        FlexGlobalConfig.KeyConfig keyConfig = new FlexGlobalConfig.KeyConfig();
        keyConfig.setKeyType(KeyType.Generator);
        keyConfig.setValue(KeyGenerators.flexId);
        flexGlobalConfig.setKeyConfig(keyConfig);
    }
    
}
