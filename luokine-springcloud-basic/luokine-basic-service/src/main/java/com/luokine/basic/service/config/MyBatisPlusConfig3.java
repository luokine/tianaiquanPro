package com.luokine.basic.service.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: tiantziquan
 * @create: 2019-10-22 14:50
 */
@Configuration
public class MyBatisPlusConfig3 {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        return paginationInterceptor;
    }

}
