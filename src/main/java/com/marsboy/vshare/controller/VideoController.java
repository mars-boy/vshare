package com.marsboy.vshare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.marsboy.vshare.service.VideoService;

@Controller
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@RequestMapping(value="/uploadpage",method=RequestMethod.GET)
	public ModelAndView goToUploadPage(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("upload");
		System.out.println("User name session attribute :: "+httpSession.getValue("UserName"));
		return modelAndView;
	}
}
