package com.guestbook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.guestbook.entity.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {

	@Query("select o from Posts o where o.user.userId = :userId")
	public List<Posts> findAllPostsByUserId(@Param("userId") Long userId);

}
