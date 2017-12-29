package com.marsboy.vshare.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "vshare")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long userid;
	private Role role;
	private String username;
	private String password;
	private byte active;
	private Set<Video> videos = new HashSet<Video>(0);

	public User() {
	}

	public User(Role role, String username, String password, byte active) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public User(Role role, String username, String password, byte active, Set<Video> videos) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.active = active;
		this.videos = videos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "userid", unique = true, nullable = false)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "active", nullable = false)
	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}

}
