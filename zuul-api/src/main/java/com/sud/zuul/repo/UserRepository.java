package com.sud.zuul.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sud.zuul.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);
}
