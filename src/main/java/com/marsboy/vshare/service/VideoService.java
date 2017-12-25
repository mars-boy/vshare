package com.marsboy.vshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marsboy.vshare.dao.RoleDAO;
import com.marsboy.vshare.dao.UserDAO;
import com.marsboy.vshare.model.User;

@Service
@Transactional
public class VideoService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	
	public User getUserByUsername(String userName) {
		return userDAO.getUserByUsername(userName);
	}
	
	public void saveOrUpdate(User user) {
		userDAO.saveOrupdate(user);
	}
}
