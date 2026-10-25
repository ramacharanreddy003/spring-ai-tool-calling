package com.jsp.ai.Service;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ai.Entity.OrderEntity;
import com.jsp.ai.repository.OrderRepository;


import org.springframework.web.reactive.function.client.WebClient;

@Service
public class Order_Service {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	WebClient webClient;
	
	public String processCreateOrder(OrderEntity entity)
	{
		orderRepository.save(entity);
		return "order created successfully";
	}
	public String processorderstatus(BigInteger orderId)
	{
		Optional<OrderEntity> optional=orderRepository.findById(orderId);
		OrderEntity orderEntity=optional.get();
		return orderEntity.getOrderstatus();
	}
	
//	public void cancelorder(BigInteger orderId)
//	{
//		Optional<OrderEntity> optional=orderRepository.findById(orderId);
//		if(optional.isPresent())
//		{
//			OrderEntity entity=optional.get();
//		}
//	}
	
	public String processGetPost() {
		return webClient.get().uri("https://jsonplaceholder.typicode.com/posts/").retrieve().bodyToMono(String.class).block();
	}

	
	
}
