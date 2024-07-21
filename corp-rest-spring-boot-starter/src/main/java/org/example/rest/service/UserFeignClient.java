package org.example.rest.service;


import org.example.rest.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user-service", url = "http://localhost", path = "/user")
public interface UserFeignClient {
	@GetMapping("/{id}")
	User getUserById(@PathVariable("id") Long ID);
}
