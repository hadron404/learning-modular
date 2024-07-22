package org.example.rest.application;

import org.example.application.domain.User;
import org.example.rest.feignclient.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApp {
	private final UserClient userClient;

	@Autowired
	public UserApp(UserClient userClient) {
		this.userClient = userClient;
	}

	public User getUserById(User.ID id) {
		return userClient.getUserById(id.value());
	}
}
