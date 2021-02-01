package com.grouptransportes.exception;

public class EntidadeJaExistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	private String codigo;
	
	public EntidadeJaExistenteException() {
		super();
	}
	
	public EntidadeJaExistenteException(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
}
