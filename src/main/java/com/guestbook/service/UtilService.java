package com.guestbook.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.guestbook.entity.User;
import com.guestbook.security.config.UserService;
import com.guestbook.security.dto.Principal;

@Component
public class UtilService {

	// Static Attributes
	/////////////////////
	private static Logger log = LogManager.getLogger(UtilService.class);

	@Autowired
	private UserService userService;

	public Principal getPrincipal() {

		log.debug("getPrincipal() function call");

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			UserDetails details = ((UserDetails) principal);
			List<String> collect = details.getAuthorities().stream().map(i -> i.getAuthority())
					.collect(Collectors.toList());

			return new Principal(details.getUsername(), collect);
		}
		return null;
	}

	public User getLoggerInUser() throws Exception {
		log.debug("getLoggerInUser() function call");
		Principal principal = Optional.ofNullable(getPrincipal()).orElseThrow(() -> new Exception("User not found"));
		return userService.findUserByUsername(principal.getUserName());
	}

}
