package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.payload.PostModel;

public interface PostService {
	
	PostModel createPost(PostModel postDto);

    List<PostModel> getAllPosts();

    PostModel getPostById(long id);

    PostModel updatePost(PostModel postDto, long id);

    void deletePostById(long id);

}
