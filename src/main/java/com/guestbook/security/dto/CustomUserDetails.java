package com.guestbook.security.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.guestbook.entity.User;

public class CustomUserDetails implements UserDetails {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = 3772483533602208207L;

	// Attributes
	//////////////////
	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	/**
	 * @param user
	 */
	public CustomUserDetails(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.isActive();
		String collect2 = user.getRoles().stream().map(k -> k.getRoleName()).collect(Collectors.joining(","));
		this.authorities = Arrays.stream(collect2.split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	// Properties
	/////////////////
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}
}