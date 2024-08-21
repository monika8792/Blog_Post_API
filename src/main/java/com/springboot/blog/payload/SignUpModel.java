package com.springboot.blog.payload;

import lombok.Data;

@Data
public class SignUpModel {
	private String name;
	private String username;
	private String email;
	private String password;
}