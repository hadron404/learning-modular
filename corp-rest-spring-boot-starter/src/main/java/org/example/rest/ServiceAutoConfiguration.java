package org.example.rest;

import feign.Feign;
import feign.codec.Decoder;
import org.example.rest.service.OrderFeignClient;
import org.example.rest.service.OrderService;
import org.example.rest.service.UserFeignClient;
import org.example.rest.service.UserService;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@EnableConfigurationProperties(value = ServiceProperties.class)
//  todo 根据服务配置的属性来动态加载bean
@Configuration
public class ServiceAutoConfiguration {

	private final ServiceProperties services;

	public ServiceAutoConfiguration(ServiceProperties services) {
		this.services = services;
	}

	@Bean
	public Decoder feignDecoder() {
		return new SpringDecoder(() -> new HttpMessageConverters(new MappingJackson2HttpMessageConverter()));
	}

	private Feign.Builder builder() {
		return Feign.builder()
			.contract(new SpringMvcContract())
			.decoder(feignDecoder());
	}

	// @Bean
	public UserFeignClient userFeignClient() {
		return builder()
			// 其他必要的配置
			.target(UserFeignClient.class, services.getUser().toURL())
			;
	}

	@Bean
	public UserService userService() {
		return new UserService(userFeignClient());
	}


	public OrderFeignClient orderFeignClient() {
		return builder()
			// 其他必要的配置
			.target(OrderFeignClient.class, services.getOrder().toURL());
	}

	@Bean
	public OrderService orderService() {
		return new OrderService(orderFeignClient());
	}

}
