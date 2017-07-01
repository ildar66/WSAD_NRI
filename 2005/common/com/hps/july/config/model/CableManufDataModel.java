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
public class CableManufDataModel implements Serializable, AbstractDataModel
{
	private ArrayList manufacturers;
	
	public CableManufDataModel() {
		manufacturers = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(CableManufDataModel dm) {
		this.manufacturers = dm.manufacturers;
	}
	
	/**
	 * Производители шкафов
	 * @return
	 */
	public ArrayList getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(ArrayList amanufacturers) {
		manufacturers = amanufacturers;
	}
	
	
	
	public String getLoadURL() {
		return "/inventory/LoadCableManuf";
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
		CableManufDataModel dm = (CableManufDataModel)in.readObject();
		assignObject(dm);
	}
	
}
