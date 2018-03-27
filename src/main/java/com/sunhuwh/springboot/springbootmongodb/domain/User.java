package com.sunhuwh.springboot.springbootmongodb.domain;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	private long id;
	
	private String username;
	private Integer age;
	
	public User(Long id, String username, Integer age) {
		this.id = id;
		this.username = username;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
