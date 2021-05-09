package com.guestbook.service;

import java.util.List;

import com.guestbook.dto.PostsDto;

public interface ITransactionService {

	List<PostsDto> getAllPosts() throws Exception;

	PostsDto createPost(PostsDto post) throws Exception;

	PostsDto getPostsById(Long id) throws Exception;

	void updatePosts(PostsDto post) throws Exception;

	void deletePost(Long id);

	void approvePost(Long id) throws Exception;

}
