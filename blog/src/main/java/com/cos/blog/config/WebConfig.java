package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

// 웹점.xml 오버라이딩 한거랑 같다
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Value("${file.path}")
	private String fileRealPath;
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		// 파일 경로 인식하게 하기
		registry.addResourceHandler("/media/**")
		.addResourceLocations("file:///"+fileRealPath)
		.setCachePeriod(3600)
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
	}
		
}
