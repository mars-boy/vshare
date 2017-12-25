package com.marsboy.vshare.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marsboy.vshare.dao.UserDAO;
import com.marsboy.vshare.model.Role;
import com.marsboy.vshare.model.User;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDesignDaoImpl<User,Long> implements UserDAO {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserDaoImpl() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUsername(String userName) {
		System.out.println("bombed");
		Query query = getCurrentSession().createQuery("from User where username=:username");
		System.out.println("shit");
		query.setString("username",userName);
		List<User> userList = query.list();
		if(userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}
}
