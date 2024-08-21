package com.springboot.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payload.CommentModel;
import com.springboot.blog.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentModel> createComment(@PathVariable(value = "postId") long postId,
			@RequestBody CommentModel commentDto) {
		return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
	}

	@GetMapping("/posts/{postId}/comments")
	public List<CommentModel> getCommentsByPostId(@PathVariable(value = "postId") Long postId) {
		return commentService.getCommentsByPostId(postId);
	}

	@GetMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<CommentModel> getCommentById(@PathVariable(value = "postId") Long postId,
			@PathVariable(value = "id") Long commentId) {
		CommentModel commentDto = commentService.getCommentById(postId, commentId);
		return new ResponseEntity<>(commentDto, HttpStatus.OK);
	}

	@PutMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<CommentModel> updateComment(@PathVariable(value = "postId") Long postId,
			@PathVariable(value = "id") Long commentId, @RequestBody CommentModel commentDto) {
		CommentModel updatedComment = commentService.updateComment(postId, commentId, commentDto);
		return new ResponseEntity<>(updatedComment, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<Map<String, String>> deleteComment(@PathVariable(value = "postId") Long postId,
			@PathVariable(value = "id") Long commentId) {
		commentService.deleteComment(postId, commentId);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Comment deleted are successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
