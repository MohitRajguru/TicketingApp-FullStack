package com.pro.fts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.fts.entity.User;
import com.pro.fts.exception.DuplicateUserIdException;
import com.pro.fts.exception.InternalServerErrorException;
import com.pro.fts.exception.InvalidUserException;
import com.pro.fts.service.RegistrationService;

@RestController
@CrossOrigin("*")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/registeruser")
	public User resgisterUser(@RequestBody User user) throws DuplicateUserIdException {
		String tempUserId = user.getUserId();

		if (tempUserId != null && !"".equals(tempUserId)) {
			User userObj = registrationService.fetchUserByUserId(tempUserId);
			if (userObj != null) {
				throw new DuplicateUserIdException(tempUserId + " already exists");

			}
		}

		User userObj = null;
		userObj = registrationService.saveUser(user);
		return userObj;
	}

	@PostMapping(path = "/login")
	public User loginUser(@RequestBody User user) throws InternalServerErrorException {
		String tempUserId = user.getUserId();
		String tempPassword = user.getPassword();
		User userObj = null;
		if (tempUserId != null && tempPassword != null) {
			userObj = registrationService.fetchByUserIdAndPassword(tempUserId, tempPassword);

		}
		if (userObj == null) {
			throw new InvalidUserException("Bad Credentials");
		}
		return userObj;
	}

}
