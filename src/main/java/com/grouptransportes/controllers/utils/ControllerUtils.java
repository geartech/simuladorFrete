package com.grouptransportes.controllers.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.grouptransportes.exception.DadosRequestException;
import com.grouptransportes.utils.Utilities;


public class ControllerUtils {
	
	public void validaDados(String... msg) throws DadosRequestException {
		List<String> errors = new ArrayList<String>();
		
		if (msg.length >= 0) {
			for (int x = 0; x < msg.length; x++) {
				if (!Utilities.isNullOrEmpty(msg[x])) {
					errors.add(msg[x]);
				} 
			}
		}
		
		if (errors.size() > 0) {
			throw new DadosRequestException(errors);
		}
	}
	
	@SuppressWarnings("unchecked")
	public String jsonViewGrid(List<?> list) {
		JSONObject jsonListObj = new JSONObject();
		jsonListObj.put("data", list);
		return jsonListObj.toString();
	}
	
}
