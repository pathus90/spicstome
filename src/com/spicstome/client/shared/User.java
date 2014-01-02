package com.spicstome.client.shared;

import java.io.Serializable;
import java.util.Date;

import com.spicstome.client.dto.UserDTO;

public abstract class User implements Serializable {
	
	private static final long serialVersionUID = 3555772168779223497L;
	
	private Long id;
	private Date subscriptionDate;
	private String login;
	private String password;
	private Image image;
	
	public User() {		
	}
	
	public User(Long id)	{
		this.id = id;
	}
	
	public User(UserDTO userDTO) {
		id = userDTO.getId();
		subscriptionDate = userDTO.getSubscriptionDate();
		login = userDTO.getLogin();
		password = userDTO.getPassword();
		image = new Image(userDTO.getImage());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ ", image=" + image + "]";
	}
}
