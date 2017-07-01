package com.hps.july.inventory.valueobject;

import java.io.Serializable;
import java.util.List;

/**
 * @author dimitry
 * Created 06.04.2006
 */
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private boolean IBPType;
	
	private Integer visualCategoryId;
	private VisualCategory visualCategory;
	
//	private Integer parentId;
//	private Category parent;
	
	private List childrens;
	
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
	public List getChildrens() {
		return childrens;
	}
	public void setChildrens(List childrens) {
		this.childrens = childrens;
	}
	public boolean isIBPType() {
		return IBPType;
	}
	public void setIBPType(boolean type) {
		IBPType = type;
	}
	public VisualCategory getVisualCategory() {
		return visualCategory;
	}
	public void setVisualCategory(VisualCategory visualCategory) {
		this.visualCategory = visualCategory;
		setVisualCategoryId(visualCategory != null ? visualCategory.getId() : null);
	}
	public Integer getVisualCategoryId() {
		return visualCategoryId;
	}
	public void setVisualCategoryId(Integer visualCategoryId) {
		this.visualCategoryId = visualCategoryId;
	}
}
