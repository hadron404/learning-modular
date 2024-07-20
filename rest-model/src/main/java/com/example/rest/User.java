package com.example.rest;

public record User(UserId id, String name) {
	public record UserId(Long value) {
	}
}
