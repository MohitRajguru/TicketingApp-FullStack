package com.pro.fts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.fts.entity.User;
import com.pro.fts.repository.RegistrationRepo;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User fetchUserByUserId(String userId) {
		return repo.findByUserId(userId);
	}

	public User fetchByUserIdAndPassword(String userId, String password) {
		return repo.findByUserIdAndPassword(userId, password);
	}
}
