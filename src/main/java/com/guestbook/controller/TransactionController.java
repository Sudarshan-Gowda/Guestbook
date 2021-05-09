package com.guestbook.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guestbook.constants.ActionType;
import com.guestbook.constants.Constants;
import com.guestbook.dto.PostsDto;
import com.guestbook.dto.UserDto;
import com.guestbook.security.config.UserService;
import com.guestbook.service.ITransactionService;
import com.guestbook.service.UtilService;

@Controller
public class TransactionController {

	// Static Attributes
	/////////////////////
	private static Logger log = LogManager.getLogger(TransactionController.class);

	// Attributes
	///////////////
	@Autowired
	private UtilService utilService;

	@Autowired
	private UserService userService;

	@Autowired
	private ITransactionService postService;

	// RequestMapping Methods
	//////////////////////////
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String registerUser(ModelMap model) {
		log.debug("registerUser() API calling");
		model.put("user", new UserDto());
		return "register";
	}

	/**
	 * @param model
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(Model model, UserDto user, BindingResult result) {
		log.debug("registerUser- Post API Starts");
		try {
			if (result.hasErrors())
				return "redirect:/";

			UserDto userDto = userService.createUser(user);
			if (userDto != null)
				model.addAttribute("statusMsg", "Succcessfull Added");

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("user", new UserDto());
			log.error("registerUser", e);
			return "register";
		}

		return "redirect:/";
	}

	/**
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) throws Exception {
		log.debug("showWelcomePage() API starts");
		model.put("principal", utilService.getPrincipal());
		model.put("posts", postService.getAllPosts());
		return "dashboard";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/createPost", method = RequestMethod.GET)
	public String createPostsGet(ModelMap model) {
		log.debug("createPostsGet() API starts");
		model.put("post", new PostsDto());
		model.put("principal", utilService.getPrincipal());
		return "post";
	}

	/**
	 * @param model
	 * @param post
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/createPost", method = RequestMethod.POST)
	public String createPosts(Model model, PostsDto post, BindingResult result) throws Exception {
		log.debug("createPosts() API starts");

		if (result.hasErrors())
			return "post";

		PostsDto postDto = postService.createPost(post);
		if (postDto != null)
			model.addAttribute("statusMsg", "Succcessfull Added");

		return "redirect:/dashboard";
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updatePost", method = RequestMethod.GET)
	public String showUpdatePosts(@RequestParam long id, ModelMap model) throws Exception {
		log.debug("showUpdatePosts() API Starts");
		PostsDto post = postService.getPostsById(id);
		model.put("post", post);
		model.addAttribute(Constants.ACTION_TYPE, ActionType.UPDATE.getKey());
		return "post";
	}

	/**
	 * @param model
	 * @param todo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
	public String updatePosts(ModelMap model, PostsDto todo, BindingResult result) throws Exception {
		log.debug("updatePosts() API Starts");
		if (result.hasErrors()) {
			return "todo";
		}

		postService.updatePosts(todo);
		return "redirect:/dashboard";
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletePost", method = RequestMethod.GET)
	public String deletePost(@RequestParam Long id) {
		log.debug("deletePost() API Starts");
		postService.deletePost(id);
		return "redirect:/dashboard";
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/viewPost", method = RequestMethod.GET)
	public String viewPost(@RequestParam Long id, ModelMap model) throws Exception {
		log.debug("viewPost() API Starts");
		PostsDto post = postService.getPostsById(id);
		model.put("post", post);
		model.addAttribute(Constants.ACTION_TYPE, ActionType.VIEW.getKey());
		model.addAttribute(Constants.DISABLED, Boolean.TRUE);
		return "post";
	}

	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/approvePost", method = RequestMethod.GET)
	public String approvePost(@RequestParam Long id) throws Exception {
		log.debug("approvePost() API Starts");
		postService.approvePost(id);
		return "redirect:/dashboard";
	}

}
