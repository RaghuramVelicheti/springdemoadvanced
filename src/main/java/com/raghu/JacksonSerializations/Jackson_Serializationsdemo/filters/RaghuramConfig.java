package com.raghu.JacksonSerializations.Jackson_Serializationsdemo.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RaghuramConfig implements WebMvcConfigurer {

	@Bean
	String getString() {
		return "";
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new CustomInterceptor());
	}

}
