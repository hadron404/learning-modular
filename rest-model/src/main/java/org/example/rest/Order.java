package org.example.rest;

public record Order(ID id, String name) {
	public record ID(Long value) {
	}
}
