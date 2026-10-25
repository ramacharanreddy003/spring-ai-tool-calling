package com.jsp.ai.tools;

import java.math.BigInteger;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.ai.Entity.OrderEntity;
import com.jsp.ai.Service.Order_Service;


@Component
public class OrderTools {
	@Autowired
	private Order_Service orderService;
	
	@Tool(description="Get the status of an order when"+"user provides order id")
	public String findOrderStatus(@ToolParam(description="id of the order")BigInteger orderid)
	{
		return orderService.processorderstatus(orderid);
	}
	
	@Tool(description = "Create a new order"+"call this method only when user provides"+"product name,priceand orderId")
	public void createorder(@ToolParam(description = "name of product")  String productname, @ToolParam(description = "price of the product") Long price,
			 @ToolParam(description = "id of the order") BigInteger orderId)
	{
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setOrderid(orderId);
		orderEntity.setPrice(price);
		orderEntity.setProductname(productname);
		orderEntity.setOrderstatus("PENDING");
		orderService.processCreateOrder(orderEntity);
		
	}
//	public void  cancelorder(@ToolParam BigInteger orderId)
//	{
//		orderService.cancelorder(orderId);
//	}

	@Tool(description="Get post details")
	public String processGetPost() {
		return orderService.processGetPost();
	}
	
}
