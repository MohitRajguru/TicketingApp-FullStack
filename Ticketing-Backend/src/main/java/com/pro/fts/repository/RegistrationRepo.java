package com.pro.fts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.fts.entity.User;

public interface RegistrationRepo extends JpaRepository<User, Integer> {

	public User findByUserId(String userId);

	public User findByUserIdAndPassword(String userId, String password);

}