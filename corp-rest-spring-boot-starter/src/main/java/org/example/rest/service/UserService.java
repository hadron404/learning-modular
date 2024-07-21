package org.example.rest.service;

import org.example.rest.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserFeignClient userFeignClient;

	@Autowired
	public UserService(UserFeignClient userFeignClient) {
		this.userFeignClient = userFeignClient;
	}

	public User getUserById(User.ID id) {
		return userFeignClient.getUserById(id.value());
	}
}
