package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;

@Controller
public class OrderController {
	
	@GetMapping("/order")
	public ModelAndView index() {
		ModelAndView view=new ModelAndView();
		view.addObject("message", "Hello World!");
		view.setViewName("index");
		return view;
	}
	
	@PostMapping("/order")
	public ModelAndView index(User user) {
		System.out.println(user.toString());
		ModelAndView view=new ModelAndView();
		view.addObject("message", user.toString());
		view.setViewName("index");
		return view;
	}
}
