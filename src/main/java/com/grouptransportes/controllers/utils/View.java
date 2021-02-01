package com.grouptransportes.controllers.utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class View implements Serializable {
	private static final long serialVersionUID = 1L;

	private JSONObject erros;
	private Boolean isCleanForm;
	private String formName;
	private JSONArray alertas;
	private Boolean isMsgAlertas;
	private Boolean isReloadGrid;
	private String gridName;
	private Boolean isSetAttribute;
	private JSONArray attributes;
	
	@SuppressWarnings("unchecked")
	public String jsonResponse() {
		JSONObject response = new JSONObject();
		for (Field field : this.getClass().getSuperclass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				
				String fieldName = field.getName();
				Object fieldValue = field.get(this);
				Object value = fieldValue != null && !fieldValue.equals("") ?  fieldValue : null;
				response.put(fieldName, value);
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return response != null ? response.toJSONString() : null;
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject setObject(String name, Object value) {
		JSONObject obj = new JSONObject();
		obj.put(name, value);
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public void showMessagesAlert(String mensage) {
		this.isMsgAlertas = true;
		if (this.alertas == null || (this.alertas != null && this.alertas.size() <= 0)) {
			this.alertas = new JSONArray();
		}
		
		this.alertas.add(setObject("msg", mensage));
		
	}
	
	@SuppressWarnings("unchecked")
	public void showMessagesAlert(List<String> mensagens) {
		this.isMsgAlertas = true;
		if (this.alertas == null || (this.alertas != null && this.alertas.size() <= 0)) {
			this.alertas = new JSONArray();
		}
		
		for (String msg : mensagens) {
			this.alertas.add(setObject("msg", msg));
		}
	}

	public void refreshGrid(String gridID) {
		this.isReloadGrid = true;
		this.gridName = gridID;
		setObject("isReloadGrid", "true");
		setObject("gridName", gridID);
	}
	
	public void cleanform(String formId) {
		this.isCleanForm = true;
		this.formName = formId;
		setObject("isCleanForm", "true");
		setObject("formName", formId);
	}
	
	@SuppressWarnings("unchecked")
	public void setElementValue(String elementId, Object value) {
		this.isSetAttribute = true;
		if (this.attributes == null || (this.attributes != null && this.attributes.size() <= 0)) {
			this.attributes = new JSONArray();
		}
		JSONObject params = new JSONObject();
		params.put("name", elementId);
		params.put("value", value);
		this.attributes.add(params);
	}
	
	public JSONObject getErros() {
		return erros;
	}

	public void setErros(JSONObject erros) {
		this.erros = erros;
	}

	public JSONArray getAlertas() {
		return alertas;
	}

	public void setAlertas(JSONArray alertas) {
		this.alertas = alertas;
	}

	public Boolean getIsMsgAlertas() {
		return isMsgAlertas;
	}

	public void setIsMsgAlertas(Boolean isMsgAlertas) {
		this.isMsgAlertas = isMsgAlertas;
	}

	public Boolean getIsCleanForm() {
		return isCleanForm;
	}

	public void setIsCleanForm(Boolean isCleanForm) {
		this.isCleanForm = isCleanForm;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public Boolean getIsReloadGrid() {
		return isReloadGrid;
	}

	public void setIsReloadGrid(Boolean isReloadGrid) {
		this.isReloadGrid = isReloadGrid;
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	public Boolean getIsSetAttribute() {
		return isSetAttribute;
	}

	public void setIsSetAttribute(Boolean isSetAttribute) {
		this.isSetAttribute = isSetAttribute;
	}

	public JSONArray getAttributes() {
		return attributes;
	}

	public void setAttributes(JSONArray attributes) {
		this.attributes = attributes;
	}
	
	
	
}
