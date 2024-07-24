package org.example.web;

import org.example.web.response.CustomizeResponseBodyAdvice;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = WebProperties.class)
@Configuration
@ConditionalOnClass(WebProperties.class)
public class WebAutoConfiguration {

	@Bean
	@ConditionalOnProperty(prefix = "web.response", name = "enabled", havingValue = "true")
	public CustomizeResponseBodyAdvice customizeResponseBodyAdvice() {
		return new CustomizeResponseBodyAdvice();
	}

}
