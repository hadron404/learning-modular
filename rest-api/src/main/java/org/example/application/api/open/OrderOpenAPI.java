package org.example.application.api.open;

import org.example.application.domain.Order;

public interface OrderOpenAPI {
	Order getOrderById(Long ID);
}
