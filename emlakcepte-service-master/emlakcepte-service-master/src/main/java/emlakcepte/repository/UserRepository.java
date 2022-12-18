package emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import emlakcepte.model.User;

@Component
public class UserRepository {
	
	private static List<User> userList = new ArrayList<>();
	private static List<User> searchList = new ArrayList<>();

	public void createUser(User user) {	
		userList.add(user);
	}
	
	public List<User> findAllUsers() {	
		return userList;
	}
	public List<User> findAllSearches() {	
		return searchList;
	}
	public void saveSearch(User search) {	
		userList.add(search);
	}


}
