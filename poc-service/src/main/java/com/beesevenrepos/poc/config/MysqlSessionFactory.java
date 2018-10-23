package com.beesevenrepos.poc.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description:
 * @Auther: chenmingjian
 * @Date: 18-10-22 18:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Configuration
@MapperScan(basePackages = {"com.beesevenrepos.poc.dao"})
public class MysqlSessionFactory {

    @Resource(name = "mysqlDataSource")
    private DataSource mysqlDataSource;

    @Value("${mysql.jdbc.mapper}")
    private String mapper;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        try {
            sqlSessionFactoryBean.setDataSource(mysqlDataSource);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            sqlSessionFactoryBean.setTypeAliasesPackage("com.beesevenrepos.poc.entry");
            sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));
            sqlSessionFactoryBean.setFailFast(true);
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapper));
        } catch (Exception e) {
           log.error("数据库连接异常：" + e);
        }

        return sqlSessionFactoryBean.getObject();
    }


}
