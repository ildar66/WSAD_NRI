package com.hps.july.web.util;

import java.util.List;

/**
 * @author dimitry
 * Created 26.04.2006
 */
public class ValidateUtils {

	public static boolean isNull(Object value){
		return value == null;
	}
	
	public static boolean isEmpty(Object value){
		if (isNull(value)) return true;
		if (value instanceof String &&
				((String)value).length() == 0) return true;
			
		return false;
	}
	

	public static boolean isInteger(String value) {
		if (isNull(value)) return false;
		try {
			Integer.parseInt(value);
			return true;
		} catch( NumberFormatException e ) {
			return false;
		}
	}

	public static boolean isContains(Object[] objects, Object object) {
		if (object == null) return false;
		if (objects == null) throw new IllegalArgumentException("Argument List of objects can not be null");
		
		for (int i=0; i<objects.length; i++){
			if (objects[i] != null && objects[i].equals(object)) return true;
		}
		return false;
	}

	public static boolean isContains(List objects, Object object){
		if (object == null) return false;
		if (objects == null) throw new IllegalArgumentException("Argument List of objects can not be null");

		return objects.contains(object);
	}
	
	public static void main(String[] args) {
		
		System.out.println(isContains(new String[] {"F","S","M"}, "E"));
		
		
	}
	
	
}
