package jj.spring.test.service;

import java.util.List;

import jj.spring.test.model.OrderCommand;

public class OrderService {
	private List<OrderCommand> list;

	public List<OrderCommand> getList() {
		return list;
	}

	public void setList(List<OrderCommand> list) {
		this.list = list;
	}
	
}
