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
public class BSStandResourceDataModel implements Serializable, AbstractDataModel
{
	//static final long serialVersionUID = 9009817436211052065L;
	
	//private HashMap allresources;
	private Integer curmanuf;
	private ArrayList resources;
	
	public BSStandResourceDataModel() {
		//allresources = new HashMap();
		resources = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(BSStandResourceDataModel dm) {
		this.resources = dm.resources;
	}
	
	public String getLoadURL() {
		return "/inventory/LoadBSResources?manuf=" + curmanuf;
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
		BSStandResourceDataModel dm = (BSStandResourceDataModel)in.readObject();
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
	public Integer getCurmanuf() {
		return curmanuf;
	}

	/**
	 * @param integer
	 */
	public void setCurmanuf(Integer integer) {
		curmanuf = integer;
	}

}
