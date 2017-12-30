package com.marsboy.vshare.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginError(@RequestParam(value = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView();
		if(error!=null) {
			modelAndView.addObject("error", "Invalid username or password");
		}
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
		User userExists = videoService.getUserByUsername(user.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("username", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive((byte) 1);
			Role role = new Role((byte)1,"ADMIN");
			user.setRole(role);
			videoService.saveOrUpdate(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView goToHome(HttpSession httpSession) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		httpSession.setAttribute("UserName",auth.getName());
		return modelAndView;
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView goLogOut(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("came here");
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(httpServletRequest,httpServletResponse, auth);
	    }
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("login");
		modelAndView.addObject("logoutstatus", "Logout successful");
		SecurityContextHolder.getContext().setAuthentication(null);
		httpSession.invalidate();
		SecurityContextHolder.clearContext();
		removeCookies(httpServletRequest);
		return modelAndView;
	}
	
	public static void removeCookies(HttpServletRequest httpServletRequest) {
		Cookie[] cookies = httpServletRequest.getCookies();
		if(cookies != null && cookies.length > 0 ) {
			for(int i = 0; i < cookies.length;i++) {
				cookies[i].setMaxAge(0);
			}
		}
	}
	@RequestMapping(value="/access-denied",method=RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("access-denied");
		return modelAndView;
	}
	@RequestMapping(value = "/error",method=RequestMethod.POST)
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		return modelAndView;
	}
}