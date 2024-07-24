package org.example.web.response;

public record CustomizeResponseEntity<T>(int code, String message, T data) {
	public static <T> CustomizeResponseEntity<T> ok(T data) {
		return new CustomizeResponseEntity<>(0, "成功", data);
	}

	public static <T> CustomizeResponseEntity<T> ok() {
		return CustomizeResponseEntity.ok(null);
	}
}
