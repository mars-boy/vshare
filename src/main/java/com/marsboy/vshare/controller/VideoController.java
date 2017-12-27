package com.marsboy.vshare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class VideoController {
	
	
	@RequestMapping(value="/uploadpage",method=RequestMethod.GET)
	public ModelAndView goToUploadPage(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("upload");
		return modelAndView;
	}
}
