package medium.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import medium.model.User;
@Component
public class UserRepository {
	private static List<User> userList = new ArrayList<User>();

	public void createUser(User user) {
		userList.add(user);
	}
	public List<User> findAllUsers() {	
		return userList;
	}
	
	/*public void createFollowingUser(User user) {
		userList.add(user);
	}*/


}
