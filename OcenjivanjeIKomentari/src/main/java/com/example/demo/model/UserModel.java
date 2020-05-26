package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;



public class UserModel {

	private Long id;

	private String username;

	private String password;

	private UserType uloga;

	private Set<Permissions> permissions = new HashSet<Permissions>();

	public UserModel() {

	}

	public UserModel(String username, String password, UserType uloga,
			Set<Permissions> permissions) {
		super();
		this.username = username;
		this.password = password;
		this.uloga = uloga;
		this.permissions = permissions;
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

	public UserType getUloga() {
		return uloga;
	}

	public void setUloga(UserType uloga) {
		this.uloga = uloga;
	}

	public Set<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}


}
