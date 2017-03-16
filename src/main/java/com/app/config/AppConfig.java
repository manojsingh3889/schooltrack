package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.app.role.task.worker.ParentBuilder;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.app")
public class AppConfig {
	
	@Bean(name="ParentBuilder")
	public ParentBuilder getParentBuilder(){
		return new ParentBuilder();
	}
}