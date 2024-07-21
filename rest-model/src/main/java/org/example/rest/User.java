package org.example.rest;

public record User(ID id, String name) {
	public record ID(Long value) {
	}
}
