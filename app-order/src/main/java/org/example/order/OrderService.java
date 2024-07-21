package org.example.order;

import org.example.rest.User;
import org.example.rest.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private final UserFeignClient userFeignClient;

	@Autowired
	public OrderService(UserFeignClient userFeignClient) {
		this.userFeignClient = userFeignClient;
	}

	public User getUserById(User.ID id) {
		return userFeignClient.getUserById(id.value());
	}
}
