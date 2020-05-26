package com.example.demo.model;

public class Renter {

	private Long id;

	private Long idUser;

	public Renter() {

	}

	public Renter(UserModel user) {
		super();
	}



	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

}
