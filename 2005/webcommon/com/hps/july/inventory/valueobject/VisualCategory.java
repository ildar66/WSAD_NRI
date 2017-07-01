package com.hps.july.inventory.valueobject;

import java.io.Serializable;
import java.util.List;

/**
 * @author dimitry
 * Created 26.04.2006
 */
public class VisualCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	private List resources;

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

	public List getResources() {
		return resources;
	}

	public void setResources(List resources) {
		this.resources = resources;
	}  
}
