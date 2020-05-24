package com.eccsm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@Column
	private String password;

	@Column(name="email", unique = true)
	private String email;

	@Column
	private String role;

	@Column
	private String rank;

	@Column
	private String forgotPasswordToken;

	@Column
	private Date forgotPasswordTokenExpires;

	public User() {
	}

	public User(String name, String password, String email, String role, String rank, String forgotPasswordToken,
			Date forgotPasswordTokenExpires) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
		this.rank = rank;
		this.forgotPasswordToken = forgotPasswordToken;
		this.forgotPasswordTokenExpires = forgotPasswordTokenExpires;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getForgotPasswordToken() {
		return forgotPasswordToken;
	}

	public void setForgotPasswordToken(String forgotPasswordToken) {
		this.forgotPasswordToken = forgotPasswordToken;
	}

	public Date getForgotPasswordTokenExpires() {
		return forgotPasswordTokenExpires;
	}

	public void setForgotPasswordTokenExpires(Date forgotPasswordTokenExpires) {
		this.forgotPasswordTokenExpires = forgotPasswordTokenExpires;
	}

}
