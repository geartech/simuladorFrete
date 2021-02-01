package com.grouptransportes.controllers.utils;

import java.io.Serializable;

public class UserRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private final String userName;
	
	public UserRequest() {    
		this.userName = "GENERIC_USER";
	}	
	
	public String getUserName() {
		return userName;
	}
	
}
