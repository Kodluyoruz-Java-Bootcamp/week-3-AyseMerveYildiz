package medium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import medium.model.User;

import medium.repository.UserRepository;

public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {			
		userRepository.createUser(user);
		
	}
	public List<User> getAllUser() {	
		return userRepository.findAllUsers();
	}
}
