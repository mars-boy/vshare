package com.marsboy.vshare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.marsboy.vshare.model.Role;
import com.marsboy.vshare.model.User;
import com.marsboy.vshare.service.VideoService;

@Controller
public class UserController {

	@Autowired
	private VideoService videoService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("1");
		User userExists = videoService.getUserByUsername(user.getUsername());
		System.out.println("2");
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			System.out.println("In save");
			System.out.println("user data ::"+user.getUsername()+" password :: "+user.getPassword());
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive((byte) 1);
			Role role = new Role((byte)1,"ADMIN");
			user.setRole(role);
			videoService.saveOrUpdate(user);
			System.out.println("failed");
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView goToHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
