package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Model - provides data to the visual form
 * + applet data transfer logic
 * @author dima
 *
 */
public class AntennaResourceDataModel implements Serializable, AbstractDataModel
{
	
	private ArrayList resources;
	private String band;
	private String polarization;
	private String model;
	
	public AntennaResourceDataModel() {
		resources = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(AntennaResourceDataModel dm) {
		this.resources = dm.resources;
	}
	
	public String getLoadURL() {
		return null;
	}
	
	public String getSaveURL() {
		return null;
	}
	
	public String getPostURL() {
		return "/inventory/LoadAntennaResources";
	}

	public void writeData(ObjectOutputStream out) throws IOException {
		out.writeObject(this);
	}
	
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
		AntennaResourceDataModel dm = (AntennaResourceDataModel)in.readObject();
		assignObject(dm);
	}
	
	
	/**
	 * @return
	 */
	public ArrayList getResources() {
		return (ArrayList)resources.clone();
	}

	/**
	 * @param list
	 */
	public void setResources(ArrayList list) {
		resources = list;
	}


	/**
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return
	 */
	public String getPolarization() {
		return polarization;
	}

	/**
	 * @param string
	 */
	public void setModel(String string) {
		model = string;
	}

	/**
	 * @param string
	 */
	public void setPolarization(String string) {
		polarization = string;
	}

	/**
	 * @return
	 */
	public String getBand() {
		return band;
	}

	/**
	 * @param string
	 */
	public void setBand(String string) {
		band = string;
	}

}
