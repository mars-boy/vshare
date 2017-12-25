package com.marsboy.vshare.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marsboy.vshare.dao.RoleDAO;
import com.marsboy.vshare.model.Role;

@Repository
@Transactional
public class RoleDAOImpl extends AbstractDesignDaoImpl<Role, Byte> implements RoleDAO {

	public RoleDAOImpl() {
		super(Role.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Role findByRole(String roleName) {
		Query query = getCurrentSession().createQuery("from Role where rolename=:rolename");
		query.setString("rolename",roleName);
		List<Role> roleList = query.list();
		if(roleList.size()>0) {
			return roleList.get(0);
		}
		return null;
	}

}
