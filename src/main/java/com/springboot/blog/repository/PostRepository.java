package com.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
