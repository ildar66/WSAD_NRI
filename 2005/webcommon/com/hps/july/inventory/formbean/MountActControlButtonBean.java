package com.hps.july.inventory.formbean;

import java.io.Serializable;

/**
 * @author dimitry
 * Created 17.04.2006
 */
public class MountActControlButtonBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer resourceId;
	private Integer categoryId;
	private String parentPath;
	private Integer positionIndex;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public String getParentPath() {
		return parentPath;
	}
	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}
	public Integer getPositionIndex() {
		return positionIndex;
	}
	public void setPositionIndex(Integer positionIndex) {
		this.positionIndex = positionIndex;
	}
}
