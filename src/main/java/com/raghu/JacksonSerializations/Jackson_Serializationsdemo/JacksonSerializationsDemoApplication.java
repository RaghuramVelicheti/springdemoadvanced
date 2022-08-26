package com.raghu.JacksonSerializations.Jackson_Serializationsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, value = ExcludeComponentAnnotation.class))
public class JacksonSerializationsDemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(JacksonSerializationsDemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JacksonSerializationsDemoApplication.class, args);
	}

}
