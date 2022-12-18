package medium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medium.model.User;
import medium.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping
	public List<User> getAll() {
		System.out.println("getAll - userService :: " + service);
		return service.getAllUser();
	}

	@PostMapping
	// @ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<User> create(@RequestBody User user) {

		service.createUser(user);

		System.out.println("create - userService :: " + service);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}
