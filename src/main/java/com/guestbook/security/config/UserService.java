package com.guestbook.security.config;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.guestbook.dto.UserDto;
import com.guestbook.entity.Role;
import com.guestbook.entity.User;
import com.guestbook.repo.UserRepository;
import com.guestbook.security.dto.CustomUserDetails;

@Service
@Transactional
public class UserService implements UserDetailsService {

	// Static Attributes
	/////////////////////
	private static Logger log = LogManager.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	/**
	 *
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		log.debug("loadUserByUsername() function starts");
		Optional<User> user = userRepository.findByUserName(userName);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

		log.debug("loadUserByUsername() function ends");

		return user.map(CustomUserDetails::new).get();
	}

	/**
	 * @param userName
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public User findUserByUsername(String userName) throws UsernameNotFoundException {
		log.debug("findUserByUsername() function call");

		return userRepository.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
	}

	/**
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public UserDto createUser(UserDto user) throws Exception {
		log.debug("createUser() function call starts");

		Optional<User> userOpt = userRepository.findByUserName(user.getUserName());
		if (userOpt.isPresent())
			throw new Exception("Record already exists! Please try different User name");

		User entity = new User();
		entity.setUserName(user.getUserName());
		entity.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		entity.setActive(Boolean.TRUE);
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(2L));
		entity.setRoles(roles);
		User save = userRepository.saveAndFlush(entity);
		BeanUtils.copyProperties(save, user);
		log.debug("createUser() function call ends");

		return user;
	}
}