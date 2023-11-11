package com.qing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.qing.mapper")
@EnableScheduling
public class QingBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(QingBlogApplication.class,args);
    }
}
