package emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.Message;

import emlakcepte.service.MessageService;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@GetMapping
	public List<Message> getAll(){
		return messageService.getAll();
	}
	@PostMapping
	public ResponseEntity<Message> create(@RequestBody Message message) {
		System.out.println("message" + message);
		messageService.createMessage(message);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	

}
