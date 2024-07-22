package org.example.application.domain;

public record User(ID id, String name) {
	public record ID(Long value) {
	}
}
