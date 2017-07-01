package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Controllers
 * Model - provides data to the visual form
 * + applet data transfer logic
 * @author dima
 *
 */
public class ControllerDataModel implements Serializable, AbstractDataModel
{
	private List controllers;
	
	public ControllerDataModel() {
		controllers = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(ControllerDataModel dm) {
		this.controllers = dm.controllers;
	}
	
	/**
	 * Склады
	 * @return
	 */
	public List getControllers() {
		return controllers;
	}
	public void setControllers(List acontrollers) {
		controllers = acontrollers;
	}
	
	
	
	public String getLoadURL() {
		return "/inventory/LoadControllers";
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
		ControllerDataModel dm = (ControllerDataModel)in.readObject();
		assignObject(dm);
	}
	
}
