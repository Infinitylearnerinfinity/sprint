package com.batch2.onlineshopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.batch2.onlineshopping.entity.User;
import com.batch2.onlineshopping.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUserDetails(User user) {

		if (user.getPassword().equals(user.getConfirmPassword())) {
			String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(encryptedPassword);
			User user1=userRepository.save(user);
			user1.setPassword(null);
			return user1;
		}
		return null;

	}

	@Override
	public User updateUser(User user, int id) {

		if (user.getPassword().equals(user.getConfirmPassword())) {
			String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(encryptedPassword);
			user.setId(id);
			User user1 = userRepository.save(user);
			user1.setPassword(null);
			return user1;
		}
		return null;

	}
	@Override
	public Optional<User> getUserDetails(int id) {

		Optional<User> user = userRepository.findById(id);
		user.get().setPassword(null);
		return user;
	}

	@Override
	public String deleteUser(int id) {
		if (userRepository.existsById(id)) {

			userRepository.deleteById(id);

			return "User deleted successfuly";
		}
		return "User can't find";
	}
	@Override
	public String login(User user) {
		User user1 = userRepository.findByUsername(user.getUsername());
		if(user1.getPassword().equals(user.getPassword())) {
			return "Successfuly logged in";
		}
		return "Enter valid username and password.";
	}
	
}
