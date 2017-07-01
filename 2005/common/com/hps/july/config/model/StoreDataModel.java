package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Manufacturers of BS stands
 * Model - provides data to the visual form
 * + applet data transfer logic
 * @author dima
 *
 */
public class StoreDataModel implements Serializable, AbstractDataModel
{
	//static final long serialVersionUID = 9009817436211052065L;
	
	private ArrayList stores;
	
	public StoreDataModel() {
		stores = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(StoreDataModel dm) {
		this.stores = dm.stores;
	}
	
	/**
	 * Склады
	 * @return
	 */
	public ArrayList getStores() {
		return stores;
	}
	public void setStores(ArrayList astores) {
		stores = astores;
	}
	
	
	
	public String getLoadURL() {
		return "/inventory/LoadStores";
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
		StoreDataModel dm = (StoreDataModel)in.readObject();
		assignObject(dm);
	}
	
}
