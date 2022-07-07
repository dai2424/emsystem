package com.jit.emsystemapi.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@MapperScan("com.jit.emsystemapi.dao.mapper")
public class MybatisPlusConfig {

}
