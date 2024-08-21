package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.payload.CommentModel;

public interface CommentService {

	CommentModel createComment(long postId, CommentModel commentDto);

	List<CommentModel> getCommentsByPostId(long postId);

	CommentModel getCommentById(Long postId, Long commentId);

	CommentModel updateComment(Long postId, long commentId, CommentModel commentRequest);

	void deleteComment(Long postId, Long commentId);
}
