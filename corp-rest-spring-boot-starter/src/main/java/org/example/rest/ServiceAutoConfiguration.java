package org.example.rest;

import feign.Feign;
import feign.codec.Decoder;
import org.example.rest.service.UserFeignClient;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@EnableConfigurationProperties(value = ServiceProperties.class)
@Configuration
public class ServiceAutoConfiguration {

	private final ServiceProperties user;

	public ServiceAutoConfiguration(ServiceProperties user) {
		this.user = user;
	}

	@Bean
	public Decoder feignDecoder() {
		return new SpringDecoder(() -> new HttpMessageConverters(new MappingJackson2HttpMessageConverter()));
	}

	@Bean
	public UserFeignClient userFeignClient() {
		return Feign.builder()
			.contract(new SpringMvcContract())
			.decoder(feignDecoder())
			// 其他必要的配置
			.target(UserFeignClient.class, user.getUser().getHost());
	}
}
