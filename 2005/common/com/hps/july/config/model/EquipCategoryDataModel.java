package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Equipment categories
 * Model - provides data to the visual form
 * + applet data transfer logic
 * @author dima
 *
 */
public class EquipCategoryDataModel implements Serializable, AbstractDataModel
{
	private ArrayList equipcategories;
	private HashMap childequipcategories;
	
	public EquipCategoryDataModel() {
		equipcategories = new ArrayList();
		childequipcategories = new HashMap();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(EquipCategoryDataModel dm) {
		this.equipcategories = dm.equipcategories;
		this.childequipcategories = dm.childequipcategories;
	}
	
	public String getLoadURL() {
		return "/inventory/LoadEquipCategories";
	}
	
	public String getSaveURL() {
		return null;
	}
	
	public String getPostURL() {
		return null;
	}

	public void writeData(ObjectOutputStream out) throws IOException {
		out.writeObject(this);
	}
	
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
		EquipCategoryDataModel dm = (EquipCategoryDataModel)in.readObject();
		assignObject(dm);
	}
	
	/**
	 * @return
	 */
	public ArrayList getEquipcategories() {
		return equipcategories;
	}

	/**
	 * @param list
	 */
	public void setEquipcategories(ArrayList list) {
		equipcategories = list;
	}

	/**
	 * @return
	 */
	public HashMap getChildequipcategories() {
		return childequipcategories;
	}

	/**
	 * @param map
	 */
	public void setChildequipcategories(HashMap map) {
		childequipcategories = map;
	}

}
