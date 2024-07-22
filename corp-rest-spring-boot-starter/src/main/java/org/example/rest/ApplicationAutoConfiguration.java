package org.example.rest;

import feign.Feign;
import feign.codec.Decoder;
import org.example.rest.feignclient.OrderClient;
import org.example.rest.application.OrderApp;
import org.example.rest.feignclient.UserClient;
import org.example.rest.application.UserApp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@EnableConfigurationProperties(value = ApplicationProperties.class)
@Configuration
@ConditionalOnClass(ApplicationProperties.class)
public class ApplicationAutoConfiguration {

	private final ApplicationProperties services;

	public ApplicationAutoConfiguration(ApplicationProperties services) {
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

	@Bean
	@ConditionalOnProperty(prefix = "application.user", name = {"host", "path"})
	public UserApp userService() {
		return new UserApp(
			builder()
				// 其他必要的配置
				.target(UserClient.class, services.getUser().toURL())
		);
	}

	@Bean
	@ConditionalOnProperty(prefix = "application.order", name = {"host", "path"})
	public OrderApp orderService() {
		return new OrderApp(
			builder()
				// 其他必要的配置
				.target(OrderClient.class, services.getOrder().toURL())
		);
	}

}
