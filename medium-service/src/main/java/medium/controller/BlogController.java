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

import medium.model.Blog;
import medium.model.User;
import medium.service.BlogService;

@RestController
@RequestMapping(value = "/blogs")
public class BlogController {
	@Autowired
	private BlogService blogService;

	@GetMapping
	public List<Blog> getAllBlogs() {
		System.out.println("getAllBlogs - blogService :: " + blogService);
		return blogService.getBlogs();
	}

	@PostMapping
	public ResponseEntity<Blog> create(@RequestBody Blog blog) {
		blogService.createBlog(blog);
		System.out.println("create - blogService :: " + blogService);
		return new ResponseEntity<>(blog, HttpStatus.CREATED);
	}

}
