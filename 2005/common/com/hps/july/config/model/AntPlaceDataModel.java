package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Manufacturers of BS stands
 * Model - provides data to the visual form
 * + applet data transfer logic
 * @author dima
 *
 */
public class AntPlaceDataModel implements Serializable, AbstractDataModel
{
	//static final long serialVersionUID = 9009817436211052065L;
	
	private List antplaces;
	
	public AntPlaceDataModel() {
		antplaces = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(AntPlaceDataModel dm) {
		this.antplaces = dm.antplaces;
	}
	
	/**
	 * Производители шкафов
	 * @return
	 */
	public List getAntPlaces() {
		return antplaces;
	}
	public void setAntPlaces(List aantplaces) {
		antplaces = aantplaces;
	}
	
	
	
	public String getLoadURL() {
		return "/inventory/LoadAntPlaces";
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
		AntPlaceDataModel dm = (AntPlaceDataModel)in.readObject();
		assignObject(dm);
	}
	
}
