package com.hps.july.inventory.formbean;

import java.io.Serializable;

import com.hps.july.inventory.valueobject.Resource;

/**
 * @author dimitry
 * Created 17.04.2006
 */
public class MountActDocPositionBean implements Serializable {
	private static final long serialVersionUID = 1L;

//	public static String SERIAL_STOCK_TAKING_TYPE = "S";
//	public static String QUANTITY_STOCK_TAKING_TYPE = "B";
	
	private Integer id;
	private int index;
	
	private Resource resource = new Resource();

	private Integer resourceId;
	private Integer categoryId;
	private Integer parentId;
	
	// тип учета
//	private String stockTakingType;
	
	// серийный учет: 
	/**
	 * Заводской номер
	 */
	private String worksNumber;
	private boolean worksNumberExist = false;
	
	/**
	 * Инвентарный номер 
	 */
	private String inventoryNumber;
	private boolean inventoryNumberExist = false;
	
	/**
	 * Инвентарный номер подразделения
	 */
	private String subdivisionInventoryNumber;
	private boolean subdivisionInventoryNumberExist = false;

	// количественный учет
	/**
	 * Количество
	 */
	private Integer quantity = new Integer(1);

	private MountActDocPositionListBean childrens = new MountActDocPositionListBean(this);
	private MountActDocPositionBean parent;
	
	public MountActDocPositionBean(){
		childrens.setParent(this);
	}
		
	public MountActDocPositionListBean getDocPositions() {
		return getChildrens();
	}

	public void setDocPositions(MountActDocPositionListBean docPositions) {
		setChildrens(docPositions);
	}

	public MountActDocPositionBean getDocPosition(int index) {
		return getChildrens().get(index);
	}	
	
	public MountActDocPositionListBean getChildrens() {
		return childrens;
	}

	public void setChildrens(MountActDocPositionListBean childrens) {
		this.childrens = childrens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

//	public String getStockTakingType() {
//		return stockTakingType;
//	}
//
//	public void setStockTakingType(String stockTakingType) {
//		this.stockTakingType = stockTakingType;
//	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		if (resource != null) setResourceId(resource.getId());
		this.resource = resource;
	}

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

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getSubdivisionInventoryNumber() {
		return subdivisionInventoryNumber;
	}

	public void setSubdivisionInventoryNumber(String subdivisionInventoryNumber) {
		this.subdivisionInventoryNumber = subdivisionInventoryNumber;
	}

	public String getWorksNumber() {
		return worksNumber;
	}

	public void setWorksNumber(String worksNumber) {
		this.worksNumber = worksNumber;
	}
	
	public boolean isInventoryNumberExist() {
		return inventoryNumberExist;
	}

	public void setInventoryNumberExist(boolean inventoryNumberExist) {
		this.inventoryNumberExist = inventoryNumberExist;
	}

	public boolean isSubdivisionInventoryNumberExist() {
		return subdivisionInventoryNumberExist;
	}

	public void setSubdivisionInventoryNumberExist(
			boolean subdivisionInventoryNumberExist) {
		this.subdivisionInventoryNumberExist = subdivisionInventoryNumberExist;
	}

	public boolean isWorksNumberExist() {
		return worksNumberExist;
	}

	public void setWorksNumberExist(boolean worksNumberExist) {
		this.worksNumberExist = worksNumberExist;
	}

	public String toString() {
		return this.getClass().getName() + ": [id=" + getId() + ",index=" + getIndex() + ",resourceId=" + getResourceId() + ",categoryId=" + getCategoryId() + "]";
	}

	public MountActDocPositionBean getParent() {
		return parent;
	}

	public void setParent(MountActDocPositionBean parent) {
		this.parent = parent;
		setParentId(parent != null ? parent.getId() : null);
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	
	
}
