/*
 * Created on 09.01.2007
 */
package com.hps.july.dictionary.formbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCDictionaryObject;
import com.hps.july.dictionary.valueobject.CurBaseStationComplect_VO;
import com.hps.july.web.util.EditForm;

/**
 * @author irogachev
 */
public class ShowConfBaseStationForm extends CommonConfigCtrlForm {

	private String searchActiveParameValue = ACTIVE_SEARCH_VALUE;
	private String searchManufParameValue;
	private List manufList = new ArrayList();
	private String searchStandParameValue;
	private List standList = new ArrayList();
	private String isStandPrepareProcess = FALSE_STR;
	private List curBaseStationComplectList = new ArrayList();
	private String isBaseStationCurComplectPrepareProcess = FALSE_STR;
	private String curComplectSelectedID = BEGIN_ID_INDEX;
	private String curComplectOldRowClassName;
	
	private boolean nostand;
	/*
	<html:hidden property="curComplectSelectedID"/>
	<html:hidden property="curComplectOldRowClassName"/>
	*/

	public int getState() {
		return com.hps.july.dictionary.APPStates.CONF_BASE_STATION_LIST;
	}

	public ShowConfBaseStationForm() {
		super();
		prepareManufList();
		prepareStandList();
	}
	
	/**
	 * Подготавливаем список шкафов для параметра активности и производителя
	 */
	public void prepareStandList() {
		ArrayList locStandList = new ArrayList();
		CDBCResultSet standListRS = CDBCDictionaryObject.findStandModelList(getSearchActiveParameValue(), 
									getSearchManufParameValue());
		Iterator it = standListRS.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			OptionEntry oe = new OptionEntry();
			oe.setKey(ro.getColumn("resource").asString());
			oe.setValue(ro.getColumn("model").asString());
			locStandList.add(oe);
		}	
		setStandList(locStandList);
		//
		if (locStandList.size() > 0) {
			OptionEntry oe = (OptionEntry)locStandList.get(0);
			setSearchStandParameValue(oe.getKey());
			setNostand(false);
		} else {
			setNostand(true);
			setSearchStandParameValue(BEGIN_ID_INDEX);
		}
		prepareBaseStationCurComplectList();
	}
	
	public void setNostand(boolean newNostand){
		nostand = newNostand;
	}
	public boolean getNostand(){
		return nostand;
	}

	/**
	 * @return
	 */
	public String getSearchActiveParameValue() {
		return searchActiveParameValue;
	}

	/**
	 * @param string
	 */
	public void setSearchActiveParameValue(String string) {
		searchActiveParameValue = string;
	}

	/**
	 * @return
	 */
	public String getSearchManufParameValue() {
		return searchManufParameValue;
	}

	/**
	 * @param string
	 */
	public void setSearchManufParameValue(String string) {
		searchManufParameValue = string;
	}

	/**
	 * @return
	 */
	public List getManufList() {
		return manufList;
	}

	/**
	 * @param list
	 */
	public void setManufList(List list) {
		manufList = list;
	}

	public void prepareManufList() {
		ArrayList manufList = new ArrayList();
		CDBCResultSet manufListRS = CDBCDictionaryObject.findManufList();
		Iterator it = manufListRS.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			OptionEntry oe = new OptionEntry();
			oe.setKey(ro.getColumn("organization").asString());
			oe.setValue(ro.getColumn("shortname").asString());
			manufList.add(oe);
		}	
		//
		if (manufList.size() > 0) {
			String theKey = ((OptionEntry)manufList.get(0)).getKey(); 
			setSearchManufParameValue(theKey);
		}
		setManufList(manufList);
	}
	
	/**
	 * @return
	 */
	public String getSearchStandParameValue() {
		return searchStandParameValue;
	}

	/**
	 * @param string
	 */
	public void setSearchStandParameValue(String string) {
		searchStandParameValue = string;
	}

	/**
	 * @return
	 */
	public List getStandList() {
		return standList;
	}

	/**
	 * @param list
	 */
	public void setStandList(List list) {
		standList = list;
	}

	/**
	 * @return
	 */
	public String getIsStandPrepareProcess() {
		return isStandPrepareProcess;
	}

	/**
	 * @param string
	 */
	public void setIsStandPrepareProcess(String string) {
		isStandPrepareProcess = string;
	}

	/**
	 * @return
	 */
	public List getCurBaseStationComplectList() {
		return curBaseStationComplectList;
	}

	/**
	 * @param list
	 */
	public void setCurBaseStationComplectList(List list) {
		curBaseStationComplectList = list;
	}

	/**
	 * @return
	 */
	public String getIsBaseStationCurComplectPrepareProcess() {
		return isBaseStationCurComplectPrepareProcess;
	}

	public void setIsBaseStationCurComplectPrepareProcess(String string) {
		isBaseStationCurComplectPrepareProcess = string;
	}

	public void prepareBaseStationCurComplectList() {
		ArrayList locBaseStationCurComplectList = new ArrayList();
		CDBCResultSet locBaseStationCurComplectRS = 
				CDBCDictionaryObject.findBaseStationCurComplectList( 
									getSearchStandParameValue());
		Iterator it = locBaseStationCurComplectRS.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			CurBaseStationComplect_VO curBaseStationComplect_VO = 
				new CurBaseStationComplect_VO();
			curBaseStationComplect_VO.setId(ro.getColumn("id").asString());	
			curBaseStationComplect_VO.setConftype(ro.getColumn("К").asString());	
			curBaseStationComplect_VO.setSect_a(ro.getColumn("A").asString());	
			curBaseStationComplect_VO.setSect_b(ro.getColumn("B").asString());	
			curBaseStationComplect_VO.setSect_c(ro.getColumn("C").asString());	
			curBaseStationComplect_VO.setSect_d(ro.getColumn("D").asString());	
			curBaseStationComplect_VO.setSect_e(ro.getColumn("E").asString());	
			curBaseStationComplect_VO.setSect_f(ro.getColumn("F").asString());	
			curBaseStationComplect_VO.setSect_g(ro.getColumn("G").asString());	
			curBaseStationComplect_VO.setSect_h(ro.getColumn("H").asString());
			curBaseStationComplect_VO.setVoltage(ro.getColumn("voltage").asString());	
			curBaseStationComplect_VO.setNfsitem_id(ro.getColumn("nfsCode").asString());	
			curBaseStationComplect_VO.setNfsitem_Name(ro.getColumn("nfsName").asString());	
			curBaseStationComplect_VO.setNfsId(ro.getColumn("nfsId").asString());
			curBaseStationComplect_VO.setCodenri(ro.getColumn("codenri").asString());
			curBaseStationComplect_VO.setSect_o900(ro.getColumn("o900").asString());
			curBaseStationComplect_VO.setSect_o1800(ro.getColumn("o1800").asString());
			//
			locBaseStationCurComplectList.add(curBaseStationComplect_VO);
		}	
		setCurBaseStationComplectList(locBaseStationCurComplectList);
	}

	/**
	 * @return
	 */
	public String getCurComplectOldRowClassName() {
		return curComplectOldRowClassName;
	}

	/**
	 * @return
	 */
	public String getCurComplectSelectedID() {
		return curComplectSelectedID;
	}

	/**
	 * @param string
	 */
	public void setCurComplectOldRowClassName(String string) {
		curComplectOldRowClassName = string;
	}

	/**
	 * @param string
	 */
	public void setCurComplectSelectedID(String string) {
		curComplectSelectedID = string;
	}

}
