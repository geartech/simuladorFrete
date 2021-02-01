package com.grouptransportes.exception;

import java.util.List;

public class DadosRequestException extends Exception {
	private static final long serialVersionUID = 1L;

	private List<String> response;

	public DadosRequestException(List<String> response) {
		super();
		this.response = response;
	}
	
	public List<String> getResponse() {
		return response;
	}
}
