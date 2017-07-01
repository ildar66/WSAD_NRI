package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Data model, used in basestation find request
 * @author dima
 *
 */
public class FindBaseStationDataModel implements Serializable, AbstractDataModel
{
	private ArrayList basestations;
	private String searchBy;
	private String searchParam;
	private BaseStationVO selectedBS;
	private String operator;
	private boolean needWriteAccess;
	
	
	
	public FindBaseStationDataModel() {
		basestations = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(FindBaseStationDataModel dm) {
		this.basestations = dm.basestations;
	}
	
	
	
	public String getLoadURL() {
		return null;
	}
	
	public String getSaveURL() {
		return null;
	}
	
	public String getPostURL() {
		return "/inventory/FindBaseStation";
	}

	public void writeData(ObjectOutputStream out) throws IOException {
		out.writeObject(this);
	}
	
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
		FindBaseStationDataModel dm = (FindBaseStationDataModel)in.readObject();
		assignObject(dm);
	}
	
	/**
	 * @return
	 */
	public ArrayList getBasestations() {
		return basestations;
	}

	/**
	 * @return
	 */
	public String getSearchBy() {
		return searchBy;
	}

	/**
	 * @return
	 */
	public String getSearchParam() {
		return searchParam;
	}

	/**
	 * @param list
	 */
	public void setBasestations(ArrayList list) {
		basestations = list;
	}

	/**
	 * @param string
	 */
	public void setSearchBy(String string) {
		searchBy = string;
	}

	/**
	 * @param string
	 */
	public void setSearchParam(String string) {
		searchParam = string;
	}

	/**
	 * @return
	 */
	public BaseStationVO getSelectedBS() {
		return selectedBS;
	}

	/**
	 * @param stationVO
	 */
	public void setSelectedBS(BaseStationVO stationVO) {
		selectedBS = stationVO;
	}
	
	public boolean isNeedWriteAccess() {
		return needWriteAccess;
	}
	
	public void setNeedWriteAccess(boolean needWriteAccess) {
		this.needWriteAccess = needWriteAccess;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String integer) {
		operator = integer;
	}

}
