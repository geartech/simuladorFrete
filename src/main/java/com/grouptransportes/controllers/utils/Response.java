package com.grouptransportes.controllers.utils;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {

	private T data;
	private String msg;
	private List<String> errors;
	
}
