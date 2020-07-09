package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="username", nullable = false)
	private String username;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="uloga", nullable = false)
	private UserType uloga;
	
	@JsonIgnore
	@OneToMany(mappedBy="reciever", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Message> inbox = new ArrayList<Message>();
	
	@JsonIgnore
	@OneToMany(mappedBy="sender", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Message> outbox = new ArrayList<Message>();
	
	@JsonIgnore
	@ElementCollection(targetClass=UserType.class)
    @Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults to ORDINAL.
    @CollectionTable(name="user_permissions")
    @Column(name="permission") // Column name in user_permissions
	private Set<Permissions> permissions = new HashSet<Permissions>();
	
	public UserModel() {
		
	}

	public UserModel(String username, String password, UserType uloga, List<Message> inbox, List<Message> outbox,
			Set<Permissions> permissions) {
		super();
		this.username = username;
		this.password = password;
		this.uloga = uloga;
		this.inbox = inbox;
		this.outbox = outbox;
		this.permissions = permissions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public UserType getUloga() {
		return uloga;
	}

	public void setUloga(UserType uloga) {
		this.uloga = uloga;
	}

	public List<Message> getInbox() {
		return inbox;
	}

	public void setInbox(List<Message> inbox) {
		this.inbox = inbox;
	}

	public List<Message> getOutbox() {
		return outbox;
	}

	public void setOutbox(List<Message> outbox) {
		this.outbox = outbox;
	}

	public Set<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", uloga=" + uloga
				+ ", inbox=" + inbox + ", outbox=" + outbox + ", permissions=" + permissions + "]";
	}
	
	
	
}
