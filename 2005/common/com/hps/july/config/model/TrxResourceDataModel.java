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
public class TrxResourceDataModel implements Serializable, AbstractDataModel
{
	
	public final static String SEARCH_BY_MODEL = "T";
	public final static String SEARCH_BY_MANUF = "M";
	public final static String SEARCH_BY_NFSCODE = "C";
	
	private ArrayList resources;
	private StringSelectorVO searchby;
	private String searchparam;
	
	public TrxResourceDataModel() {
		resources = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(TrxResourceDataModel dm) {
		this.resources = dm.resources;
	}
	
	public String getLoadURL() {
		return null;
	}
	
	public String getSaveURL() {
		return null;
	}
	
	public String getPostURL() {
		return "/inventory/LoadTrxResources";
	}

	public void writeData(ObjectOutputStream out) throws IOException {
		out.writeObject(this);
	}
	
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
		TrxResourceDataModel dm = (TrxResourceDataModel)in.readObject();
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
	public StringSelectorVO getSearchby() {
		return searchby;
	}

	/**
	 * @return
	 */
	public String getSearchparam() {
		return searchparam;
	}

	/**
	 * @param selectorVO
	 */
	public void setSearchby(StringSelectorVO selectorVO) {
		searchby = selectorVO;
	}

	/**
	 * @param string
	 */
	public void setSearchparam(String string) {
		searchparam = string;
	}

}
