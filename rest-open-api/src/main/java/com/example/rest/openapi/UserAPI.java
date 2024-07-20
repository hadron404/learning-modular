package com.example.rest.openapi;

import com.example.rest.User;

public interface UserAPI {

	User getUserById(User.UserId userId);
}
