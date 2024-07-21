package org.example.app.user;

import org.example.rest.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@RestController
	public static class Controller {

		@GetMapping("/{id}")
		public ResponseEntity<User> get(@PathVariable Long id) {
			return ResponseEntity.ok(new User(new User.ID(1L), "周强"));
		}
	}
}
