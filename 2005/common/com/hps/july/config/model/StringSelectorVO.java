/*
 * Created on 15.09.2006
 *
 * Объект - для combobox-ов выбора вариантов
 *   name - то, что светится пользователю,
 *   value - то, что пишется в БД
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * @author dima
 *
 */
public class StringSelectorVO implements Serializable, Comparable {

	private String value;
	private String name;

	public StringSelectorVO(String avalue, String aname) {
		super();
		value = avalue;
		name = aname;
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		StringSelectorVO other = (StringSelectorVO)otherObject;
		
		if (value == null) {
			if (other.value == null)
				return true;
			else 
				return false;
		} else {
			if (other.value == null)
				return false;
		}
		
		return value.equals(other.value);
	}
	
	public int hashCode() {
		return value.hashCode();
	}
	
	public int compareTo(Object other) {
		return name.compareTo(((StringSelectorVO)other).name);
	}

	public String toString() {
		return name;
	}
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getValue() {
		if ( (value != null) && (value.trim().length() == 0) )
			return null;
		return value;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param string
	 */
	public void setValue(String string) {
		value = string;
	}

}
