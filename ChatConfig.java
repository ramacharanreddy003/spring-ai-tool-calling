package com.jsp.ai.config;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.jsp.ai.tools.OrderTools;

@Configuration
public class ChatConfig {

	@Bean
	public ChatClient getchatClient(org.springframework.ai.chat.model.ChatModel chatModel, OrderTools orderTools) {
		return ChatClient.builder(chatModel).defaultTools(orderTools).defaultSystem(
				"you are an ai assist for my ecomerce application use find order status when user ask for status of the order and provides the order id "
						+ " use create order when user ask for create order  and provide product name,price,order id use process GetPost when user ask to get the posts if productname, orderid, price not provided ask yourself you can ask normal questions")
				.build();

	}

	@Bean
	public WebClient getwebClient() {
		return WebClient.builder().build();
	}
}
