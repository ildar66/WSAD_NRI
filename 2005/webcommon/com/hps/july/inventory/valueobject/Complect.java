package com.hps.july.inventory.valueobject;

import java.io.Serializable;

/**
 * @author dimitry
 * Created 20.04.2006
 */
public class Complect implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
