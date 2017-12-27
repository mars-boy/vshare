package com.marsboy.vshare.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marsboy.vshare.dao.UserDAO;
import com.marsboy.vshare.model.User;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDesignDaoImpl<User,Long> implements UserDAO {

	public UserDaoImpl() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUsername(String userName) {
		Query query = getCurrentSession().createQuery("from User where username=:username");
		query.setString("username",userName);
		List<User> userList = query.list();
		if(userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}
}
