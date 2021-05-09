package com.guestbook.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guestbook.dto.PostsDto;
import com.guestbook.entity.Posts;
import com.guestbook.entity.User;
import com.guestbook.repo.PostsRepository;

@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService {

	// Static Attributes
	/////////////////////
	private static Logger log = LogManager.getLogger(TransactionServiceImpl.class);

	// Attributes
	/////////////
	@Autowired
	private PostsRepository postsRepo;

	@Autowired
	private UtilService utilService;

	// Interface Methods
	//////////////////////
	@Override
	public List<PostsDto> getAllPosts() throws Exception {
		log.debug("getAllPosts() API Starts");

		User loggerInUser = utilService.getLoggerInUser();
		if (null == loggerInUser)
			throw new Exception("User session not found");

		List<Posts> findAll = null;
		if (loggerInUser.getRoles().stream().filter(i -> i.getRoleName().contains("ADMIN")).findAny().isPresent())
			findAll = postsRepo.findAll();
		else
			findAll = postsRepo.findAllPostsByUserId(loggerInUser.getUserId());

		List<PostsDto> postsDto = new ArrayList<>();
		findAll.stream().forEach(post -> {
			PostsDto postDto = new PostsDto();
			BeanUtils.copyProperties(post, postDto);

			if (post.getPostType().equals("IMAGE")) {

				byte[] encode = java.util.Base64.getEncoder().encode(post.getImage());
				try {
					postDto.setImageBytesInstr(new String(encode, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

			}

			postsDto.add(postDto);

		});

		log.debug("getAllPosts() API Ends");

		return postsDto;
	}

	@Override
	public PostsDto createPost(PostsDto post) throws Exception {
		log.debug("createPost() API Starts");

		Posts entity = new Posts();
		BeanUtils.copyProperties(post, entity);
		entity.setIsApproved(Boolean.FALSE);
		entity.setUser(utilService.getLoggerInUser());
		if (post.getPostType().equals("IMAGE")) {
			entity.setImageName(post.getImage().getName());
			entity.setImage(post.getImage().getBytes());
		}

		Posts save = postsRepo.save(entity);
		BeanUtils.copyProperties(save, post);
		log.debug("createPost() API Ends");

		return post;
	}

	@Override
	public PostsDto getPostsById(Long id) throws Exception {

		log.debug("getPostsById() API Starts");

		Posts post = postsRepo.findById(id)
				.orElseThrow(() -> new Exception("Record Not Found Exception for id: " + id));

		PostsDto dto = new PostsDto();
		BeanUtils.copyProperties(post, dto);

		if (post.getPostType().equals("IMAGE")) {

			byte[] encode = java.util.Base64.getEncoder().encode(post.getImage());
			try {
				dto.setImageBytesInstr(new String(encode, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}

		log.debug("getPostsById() API Ends");
		return dto;
	}

	@Override
	public void updatePosts(PostsDto post) throws Exception {

		log.debug("updatePosts() API Starts");

		Posts entity = postsRepo.findById(post.getPostId())
				.orElseThrow(() -> new Exception("Record Not Found Exception for id: " + post.getPostId()));

		if (post.getPostType().equals("IMAGE")) {
			entity.setImageName(post.getImage().getName());
			entity.setImage(post.getImage().getBytes());
			entity.setPostType("IMAGE");
		} else {
			entity.setPostDescription(post.getPostDescription());
			entity.setPostType("TEXT");
			entity.setImage(null);
		}

		postsRepo.save(entity);
		log.debug("updatePosts() API Ends");

	}

	@Override
	public void deletePost(Long id) {
		log.debug("deletePost() API Starts");
		postsRepo.deleteById(id);
		log.debug("deletePost() API Ends");

	}

	@Override
	public void approvePost(Long id) throws Exception {
		log.debug("approvePost() API Starts");
		Posts post = postsRepo.findById(id)
				.orElseThrow(() -> new Exception("Record Not Found Exception for id: " + id));

		post.setIsApproved(Boolean.TRUE);
		postsRepo.save(post);
		log.debug("approvePost() API Ends");

	}

}
