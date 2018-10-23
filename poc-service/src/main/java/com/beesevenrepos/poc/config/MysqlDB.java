package com.beesevenrepos.poc.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description:
 * @Auther: chenmingjian
 * @Date: 18-10-22 18:35
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "mysql")
public class MysqlDB {

    private String driver;
    private String url;
    private String username;
    private String password;
    private int initialSize;
    private int maxActive;
    private int maxIdel;
    private long maxWait;

    @Bean("mysqlDataSource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            log.info("mysql启动：" + driver);
            druidDataSource.setDriverClassName(driver);
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setInitialSize(initialSize);
            druidDataSource.setMaxActive(maxActive);
            druidDataSource.setMaxWait(maxWait);
//            druidDataSource.setMaxIdle(maxIdel);
        }catch (Exception e){
            log.error("mysql数据库连接异常：" + e);
        }

        return druidDataSource;
    }




}
