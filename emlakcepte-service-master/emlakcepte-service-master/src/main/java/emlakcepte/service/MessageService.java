package emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.model.Message;

import emlakcepte.repository.MessageRepository;


@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepo;
	
	public List<Message> getAll() {
		return messageRepo.findAll();
	}
	
	public void createMessage(Message message) {
		
		System.out.println(" " + messageRepo.toString());
	
		messageRepo.createMessage(message);
		System.out.println(message);
	}

}
