package com.grouptransportes.utils;

import java.util.Collection;

public abstract class Utilities {

	/**
	 * Checks whether object is null or empty
	 * @param value [Class, String, Long, Integer, Double, Boolean, BigDecimal] 
	 * @return
	 */
	public static boolean isNullOrEmpty (Object value) {
		if (value != null && value.getClass().equals(String.class)) {
			return String.valueOf(value).isEmpty();
		} else {
			return value == null;
		}
	}
	
	/**
	 * Checks whether object is null or empty
	 * @param value [Collections] 
	 * @return
	 */
	public static boolean isNullOrEmpty (Collection<Object> value) {
		if (value != null && value.getClass().equals(Collection.class)) {
			return value.size() <= 0;
		} else {
			return value == null;
		}
	}
	
	/**
	 * Checks whether object is null or empty
	 * @param value [Array] 
	 * @return
	 */
	public static boolean isNullOrEmpty (Object[] value) {
		if (value != null && value.getClass().equals(Object[].class)) {
			return value.length <= 0;
		} else {
			return value == null;
		}
	}
	
}
