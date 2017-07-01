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
public class ApartmentDataModel implements Serializable, AbstractDataModel
{
	//static final long serialVersionUID = 9009817436211052065L;
	
	private List apartments;
	private transient Integer position;
	
	public ApartmentDataModel() {
		apartments = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(ApartmentDataModel dm) {
		this.apartments = dm.apartments;
	}
	
	/**
	 * Производители шкафов
	 * @return
	 */
	public List getApartments() {
		return apartments;
	}
	public void setApartments(List aapartments) {
		apartments = aapartments;
	}
	
	
	
	public String getLoadURL() {
		return "/inventory/LoadApartments?position=" + getPosition();
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
		ApartmentDataModel dm = (ApartmentDataModel)in.readObject();
		assignObject(dm);
	}
	
	/**
	 * @return
	 */
	public Integer getPosition() {
		return position;
	}

	/**
	 * @param integer
	 */
	public void setPosition(Integer integer) {
		position = integer;
	}

}
