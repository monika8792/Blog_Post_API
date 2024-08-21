package com.springboot.blog.payload;

import lombok.Data;

@Data
public class LoginModel {
	private String usernameOrEmail;
	private String password;
}
