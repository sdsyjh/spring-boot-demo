package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Order;
import com.example.demo.model.User;

@Controller
public class HelloController {

	@RequestMapping("/user")
	@ResponseBody
	public User getUser(HttpServletResponse response) {
		response.setContentType("text/html");
		User user=new User();
		user.setId(1);
		user.setName("zhangsan");
		for(int i=1;i<=10;i++) {
			Order order=new Order();
			order.setId(i);
			order.setName("name"+i);
			order.setAddress("address"+i);
			user.getOrders().add(order);
		}
		return user;
	}
	
	@RequestMapping(value = "/user2")
	public void getUser2(HttpServletResponse response) throws IOException {
		///response.setContentType("application/json");
		response.setContentType("text/html");
		response.getWriter().println("{\"id\":1,\"name\":\"zhangsan\",\"orders\":[{\"id\":1,\"name\":\"name1\",\"address\":\"address1\"},{\"id\":2,\"name\":\"name2\",\"address\":\"address2\"},{\"id\":3,\"name\":\"name3\",\"address\":\"address3\"},{\"id\":4,\"name\":\"name4\",\"address\":\"address4\"},{\"id\":5,\"name\":\"name5\",\"address\":\"address5\"},{\"id\":6,\"name\":\"name6\",\"address\":\"address6\"},{\"id\":7,\"name\":\"name7\",\"address\":\"address7\"},{\"id\":8,\"name\":\"name8\",\"address\":\"address8\"},{\"id\":9,\"name\":\"name9\",\"address\":\"address9\"},{\"id\":10,\"name\":\"name10\",\"address\":\"address10\"}]}");
	}
}
