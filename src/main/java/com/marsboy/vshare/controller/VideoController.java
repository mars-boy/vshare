package com.marsboy.vshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.marsboy.vshare.service.VideoService;

@Controller
public class VideoController {
	
	@Autowired
	private VideoService videoService;
}
