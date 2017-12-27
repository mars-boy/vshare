package com.marsboy.vshare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.marsboy.vshare.model.User;

public class AppDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public User getUser(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery("from user where username=:username and active = 1");
		query.setString("username",userName);
		List<User> userList = query.list();
		if(userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}
}
