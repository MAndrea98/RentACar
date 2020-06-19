package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="username", nullable = false, unique = true)
	private String username;

	@Column(name="password", nullable = false)
	private String password;

	@Column(name="uloga", nullable = false)
	private UserType uloga;

	@ElementCollection(targetClass=UserType.class)
    @Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults to ORDINAL.
    @CollectionTable(name="user_permissions")
    @Column(name="permission") // Column name in user_permissions
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
