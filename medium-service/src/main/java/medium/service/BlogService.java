package medium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import medium.model.Blog;
import medium.model.User;
import medium.repository.BlogRepository;

public class BlogService {
	@Autowired
	private BlogRepository blogRepoitory;

	public void createBlog(Blog blog) {	
		blogRepoitory.createBlog(blog);
		System.out.println("createBlog :: " + blog.getTitle());
	}

	public List<Blog> getBlogs() {
		return blogRepoitory.getBlogs();

	}

	public void printBlogs(List<Blog> blogsList) {
		getBlogs().forEach(blog -> System.out.println(blog));
	}
	
	public void removeBlog(Blog blog) {
		blogRepoitory.removeBlog(blog);
	}
	
	public List<Blog> getAllByUserName(User user){	
		return getBlogs().stream()
		.filter(realty -> realty.getUser().getEmail().equals(user.getEmail()))
		.toList();		
	}
}
