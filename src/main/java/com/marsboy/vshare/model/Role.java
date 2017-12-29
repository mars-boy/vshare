package com.marsboy.vshare.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", catalog = "vshare")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private byte roleid;
	private String rolename;
	private Set<User> users = new HashSet<User>(0);
	private Set<User> users_1 = new HashSet<User>(0);

	public Role() {
	}

	public Role(byte roleid, String rolename) {
		this.roleid = roleid;
		this.rolename = rolename;
	}

	public Role(byte roleid, String rolename, Set<User> users, Set<User> users_1) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.users = users;
		this.users_1 = users_1;
	}

	@Id

	@Column(name = "roleid", unique = true, nullable = false)
	public byte getRoleid() {
		return this.roleid;
	}

	public void setRoleid(byte roleid) {
		this.roleid = roleid;
	}

	@Column(name = "rolename", nullable = false)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers_1() {
		return this.users_1;
	}

	public void setUsers_1(Set<User> users_1) {
		this.users_1 = users_1;
	}

}
