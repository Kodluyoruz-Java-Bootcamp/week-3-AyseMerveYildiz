package emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import emlakcepte.model.Message;



@Repository
public class MessageRepository {
	private static List<Message> messageList = new ArrayList<>();
	
	
	public List<Message> findAll() {
		return messageList;
	}


	public void createMessage(Message message) {
		messageList.add(message);
		
	}

}
