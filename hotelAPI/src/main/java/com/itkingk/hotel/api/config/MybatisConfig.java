package com.itkingk.hotel.api.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kingk
 * @date 2020/4/19 0:42
 */
@Configuration
@MapperScan({"com.itkingk.hotel.api.mbg.mapper"})
public class MybatisConfig {
}
