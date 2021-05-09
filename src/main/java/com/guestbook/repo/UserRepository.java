package com.guestbook.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guestbook.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}