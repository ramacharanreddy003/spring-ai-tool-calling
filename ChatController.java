package com.jsp.ai.Contoller;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ai.dto.ChatRequest;

@RestController
public class ChatContoller {

	@Autowired
	ChatClient chatClient;

	@PostMapping(value = "/ask")
	public String chat(@RequestBody ChatRequest chatRequest) {
		return chatClient.prompt().user(chatRequest.getMessage()).call().content();
	}
	
	@GetMapping("/test")
	public String test() {
	    return "Tool Calling Application is working!";
	}
}
