package jj.spring.test;

import jj.spring.test.service.OrderService;

public class OrderController {
	
	public String form(){
		return "./order/orderform";
	}
	
	
	public String submit(OrderService orderService) {
		return "./order/orderview";
	}
}
