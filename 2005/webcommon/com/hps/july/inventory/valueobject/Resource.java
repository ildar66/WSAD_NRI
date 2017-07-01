package com.hps.july.inventory.valueobject;

import java.io.Serializable;
import java.util.List;

/**
 * @author dimitry
 * Created 10.04.2006
 */
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	public static String SERIAL_STOCK_TAKING_TYPE = "S";
	public static String QUANTITY_STOCK_TAKING_TYPE = "B";

	private Integer id;
	private String modelName;

	private String stockTakingType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getStockTakingType() {
		return stockTakingType;
	}
	public void setStockTakingType(String stockTakingType) {
		this.stockTakingType = stockTakingType;
	}
	
	public boolean isSerialStockTakingType(){
		return getStockTakingType().equals(SERIAL_STOCK_TAKING_TYPE);
	}
	
	public boolean isQuantityStockTakingType(){
		return getStockTakingType().equals(QUANTITY_STOCK_TAKING_TYPE);
	}
	
}
