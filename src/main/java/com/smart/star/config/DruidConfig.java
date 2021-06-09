package com.smart.star.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yjw
 * @Description TODO
 * @createTime 2021/6/9
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    //将配hi文件中所有spring.datasource开头的配置绑定到DataSource
    public DataSource dataSource () {
        return new DruidDataSource();
    }

}
