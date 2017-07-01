package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Workers
 * Model - provides data to the visual form
 * + applet data transfer logic
 * @author dima
 *
 */
public class OrganizationDataModel implements Serializable, AbstractDataModel
{
	//static final long serialVersionUID = 9009817436211052065L;
	
	private ArrayList organizations;
	private String searchParam;
	
	public OrganizationDataModel() {
		organizations = new ArrayList();
		searchParam = "";
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(OrganizationDataModel dm) {
		this.organizations = dm.organizations;
	}
	
	/**
	 * Организации
	 * @return
	 */
	public ArrayList getOrganizations() {
		return organizations;
	}
	public void setOrganizations(ArrayList aorganizations) {
		organizations = aorganizations;
	}
	
	
	
	public String getLoadURL() {
		return null;
	}
	
	public String getSaveURL() {
		return null;
	}
	
	public String getPostURL() {
		return "/inventory/LoadOrganizations";
	}

	public void writeData(ObjectOutputStream out) throws IOException {
		this.setOrganizations(new ArrayList());
		out.writeObject(this);
	}
	
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
		OrganizationDataModel dm = (OrganizationDataModel)in.readObject();
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
