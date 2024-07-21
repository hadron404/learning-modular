package org.example.order;

import org.example.rest.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	private OrderService orderService;


	@Test
	void name() {
		orderService.getUserById(new User.ID(1L));
	}
}
