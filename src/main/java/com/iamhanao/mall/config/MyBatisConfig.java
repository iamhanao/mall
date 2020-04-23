package com.iamhanao.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.iamhanao.mall.mbg.mapper", "com.iamhanao.mall.dao"})
public class MyBatisConfig {
}
