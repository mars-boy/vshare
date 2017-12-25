package com.marsboy.vshare.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marsboy.vshare.model.Role;

@Repository
@Transactional
public interface RoleDAO extends AbstractDesignDao<Role, Byte>{
	Role findByRole(String roleName);
}
