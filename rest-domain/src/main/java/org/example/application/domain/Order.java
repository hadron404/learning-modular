package org.example.application.domain;

public record Order(ID id, String name) {
	public record ID(Long value) {
	}
}
