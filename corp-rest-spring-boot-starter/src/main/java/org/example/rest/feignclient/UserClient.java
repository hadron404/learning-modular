package org.example.rest.feignclient;


import org.example.application.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user-client")
public interface UserClient {
	@GetMapping("/{id}")
	User getUserById(@PathVariable("id") Long ID);
}
