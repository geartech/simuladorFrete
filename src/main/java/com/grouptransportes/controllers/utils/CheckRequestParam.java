package com.grouptransportes.controllers.utils;

import com.grouptransportes.utils.Utilities;

public class CheckRequestParam {

	private String label;
	private Object value;
	private String error;
	
	public CheckRequestParam (String label) {
		this.label = label;
	}
	
	public CheckRequestParam require(Object value) {
		if (Utilities.isNullOrEmpty(value)) {
			this.error = "Valor '"+ this.label + "' precisa ser informado!";
		} else {
			this.value = value;
		}
		return this;
	}
	
	public CheckRequestParam maxLength(int maxLength) {
		if (isNotHasError()) {
			
			if (this.value.getClass().equals(String.class)) {
				if (String.valueOf(this.value).length() > maxLength) {
					this.error = "Valor com tamanho excedido! Tamanho máx: "+ maxLength;
				}
			}
			
		}
		return this;
	}
	
	public String build() {
		return this.error;
	}
	
	private boolean isNotHasError() {
		return this.error == null;
	} 
	
}
