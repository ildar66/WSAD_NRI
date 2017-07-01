package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Workers
 * Model - provides data to the visual form
 * + applet data transfer logic
 * @author dima
 *
 */
public class WorkerDataModel implements Serializable, AbstractDataModel
{
	//static final long serialVersionUID = 9009817436211052065L;
	
	private List workers;
	private String searchParam;
	
	public WorkerDataModel() {
		workers = new ArrayList();
		searchParam = "";
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(WorkerDataModel dm) {
		this.workers = dm.workers;
	}
	
	/**
	 * Склады
	 * @return
	 */
	public List getWorkers() {
		return workers;
	}
	public void setWorkers(ArrayList aworkers) {
		workers = aworkers;
	}
	
	
	
	public String getLoadURL() {
		return null;
	}
	
	public String getSaveURL() {
		return null;
	}
	
	public String getPostURL() {
		return "/inventory/LoadWorkers";
	}

	public void writeData(ObjectOutputStream out) throws IOException {
		this.setWorkers(new ArrayList());
		out.writeObject(this);
	}
	
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
		WorkerDataModel dm = (WorkerDataModel)in.readObject();
		assignObject(dm);
	}
	
	/**
	 * @return
	 */
	public String getSearchParam() {
		return searchParam;
	}

	/**
	 * @param string
	 */
	public void setSearchParam(String string) {
		searchParam = string;
	}

}
