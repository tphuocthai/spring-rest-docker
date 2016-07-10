package com.tphuocthai.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Application configuration
 * Created by tphuocthai on 7/9/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tphuocthai.rest")
public class WebConfig {
}
