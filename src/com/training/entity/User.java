package com.training.entity;

import java.util.Date;

/**
 * 
 * @author ri
 * 用户表对应实体类
 *
 */
public class User {
	private Integer id;
	private String username;
	private String password;
	private Date createdTime;
	private Date modifiedTime;

	public User() {
		super();
	}

	public User(Integer id, String username, String password, Date createdTime, Date modifiedTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
