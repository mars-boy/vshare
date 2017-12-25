package com.marsboy.vshare.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marsboy.vshare.model.User;

@Repository
@Transactional
public interface UserDAO extends AbstractDesignDao<User,Long>{
	User getUserByUsername(String userName);
}
