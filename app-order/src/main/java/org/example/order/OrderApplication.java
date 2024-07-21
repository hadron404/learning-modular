package org.example.order;

import org.example.rest.EnableServiceCommunication;
import org.example.rest.User;
import org.example.rest.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableServiceCommunication
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@RestController
	public static class Controller {

		private final UserFeignClient userFeignClient;

		@Autowired
		public Controller(UserFeignClient userFeignClient) {
			this.userFeignClient = userFeignClient;
		}

		public User getUserById(User.ID id) {
			return userFeignClient.getUserById(id.value());
		}

		@GetMapping("/{id}")
		public ResponseEntity<User> get(@PathVariable Long id) {
			return ResponseEntity.ok(this.getUserById(new User.ID(id)));
		}
	}
}
