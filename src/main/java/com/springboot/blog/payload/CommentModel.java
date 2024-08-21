package com.springboot.blog.payload;

import lombok.Data;

@Data
public class CommentModel {
	private long id;
	private String text;
	private String author;
	private String timeStamp;
}