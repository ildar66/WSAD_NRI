/*
 * Created on 12.01.2007
 */
package com.hps.july.dictionary.formbean;

import java.util.Iterator;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCDictionaryObject;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.valueobject.CurBaseStationComplect_VO;
import com.hps.july.web.util.EditForm;

/**
 * @author irogachev
 */
public class EditBaseStationConfForm extends EditForm {

	private String id;
	private String codenri;
	private String a;
	private String b;
	
	private String c;
	private String d;
	private String e;
	private String f;
	
	private String g;
	private String h;
	private String nfsitem_id;
	private String nfsitem_Name;
	private String nfsId;
	
	private String conftype;
	private String voltage;
	
	private String sect_o900;
	private String sect_o1800; 

	private String isSave = FALSE_STR;

	private String errorMsg;
	
	private String isLoadFromDB = FALSE_STR;
	
	public int getApplication() {
		return Applications.DICTIONARY;
	}

	public int getState() {
		int returnState = com.hps.july.dictionary.APPStates.BASE_STATION_CONF_FORM;
		return returnState;
	}

	/**
	 * @return
	 */
	public String getCodenri() {
		return codenri;
	}

	/**
	 * @return
	 */
	public String getConftype() {
		return conftype;
	}

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getNfsitem_id() {
		return nfsitem_id;
	}

	/**
	 * @return
	 */
	public String getNfsitem_Name() {
		/*
		String outStr = "";
		CDBCResultSet nameRS = CDBCDictionaryObject.getNfsName(getNfsId());
		Iterator it = nameRS.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			outStr = ro.getColumn("name").asString();
			System.out.println("### getNfsitem_Name from DB = " + outStr);
		}
		return outStr;
		*/
		return nfsitem_Name;
	}

	/**
	 * @return
	 */
	public String getA() {
		return a;
	}

	/**
	 * @return
	 */
	public String getB() {
		return b;
	}

	/**
	 * @return
	 */
	public String getC() {
		return c;
	}

	/**
	 * @return
	 */
	public String getD() {
		return d;
	}

	/**
	 * @return
	 */
	public String getE() {
		return e;
	}

	/**
	 * @return
	 */
	public String getF() {
		return f;
	}

	/**
	 * @return
	 */
	public String getG() {
		return g;
	}

	/**
	 * @return
	 */
	public String getH() {
		return h;
	}

	/**
	 * @return
	 */
	public String getVoltage() {
		// System.out.println("### getVoltage = " + voltage);
		return voltage;
	}

	/**
	 * @param string
	 */
	public void setCodenri(String string) {
		codenri = string;
	}

	/**
	 * @param string
	 */
	public void setConftype(String string) {
		conftype = string;
	}

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setNfsitem_id(String string) {
		nfsitem_id = string;
	}

	/**
	 * @param string
	 */
	public void setNfsitem_Name(String string) {
		nfsitem_Name = string;
	}

	/**
	 * @param string
	 */
	public void setA(String string) {
		a = string;
	}

	/**
	 * @param string
	 */
	public void setB(String string) {
		b = string;
	}

	/**
	 * @param string
	 */
	public void setC(String string) {
		c = string;
	}

	/**
	 * @param string
	 */
	public void setD(String string) {
		d = string;
	}

	/**
	 * @param string
	 */
	public void setE(String string) {
		e = string;
	} 

	/**
	 * @param string
	 */
	public void setF(String string) {
		f = string;
	}

	/**
	 * @param string
	 */
	public void setG(String string) {
		g = string;
	}

	/**
	 * @param string
	 */
	public void setH(String string) {
		h = string;
	}

	/**
	 * @param string
	 */
	public void setVoltage(String inVoltage) {
		// System.out.println("### setVoltage = " + string);
		voltage = inVoltage;
	}

	/**
	 * @return
	 */
	public String getIsSave() {
		return isSave;
	}

	/**
	 * @param string
	 */
	public void setIsSave(String string) {
		isSave = string;
	}

	/**
	 * @return
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param string
	 */
	public void setErrorMsg(String string) {
		errorMsg = string;
	}

	/**
	 * @return
	 */
	public String getNfsId() {
		// System.out.println("### getNfsId = " + nfsId);
		return nfsId;
	}

	/**
	 * @param string
	 */
	public void setNfsId(String string) {
		// System.out.println("### setNfsId = " + string);
		nfsId = string;
	}

	public String getSect_o900() {
		return sect_o900;
	}
	public void setSect_o900(String newSect_o900) {
		sect_o900 = newSect_o900;
	}
	public String getSect_o1800() {
		return sect_o1800;
	}
	public void setSect_o1800(String newSect_o1800) {
		sect_o1800 = newSect_o1800;
	}

	/**
	 * @return
	 */
	public String getIsLoadFromDB() {
		return isLoadFromDB;
	}

	/**
	 * @param string
	 */
	public void setIsLoadFromDB(String string) {
		isLoadFromDB = string;
	}

	/**
	 * Берем данные из базы
	 */
	public void loadFromDB() {
		CDBCResultSet locBaseStationCurComplectRS = 
				CDBCDictionaryObject.findBaseStationCurComplect(getId());
		Iterator it = locBaseStationCurComplectRS.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			setConftype(ro.getColumn("К").asString());	
			setA(ro.getColumn("A").asString());	
			setB(ro.getColumn("B").asString());	
			setC(ro.getColumn("C").asString());	
			setD(ro.getColumn("D").asString());	
			setE(ro.getColumn("E").asString());	
			setF(ro.getColumn("F").asString());	
			setG(ro.getColumn("G").asString());	
			setH(ro.getColumn("H").asString());
			setVoltage(ro.getColumn("voltage").asString());	
			setNfsitem_id(ro.getColumn("nfsCode").asString());	
			setNfsitem_Name(ro.getColumn("nfsName").asString());	
			setNfsId(ro.getColumn("nfsId").asString());
			setCodenri(ro.getColumn("codenri").asString());
			//
			setVoltage(CurBaseStationComplect_VO.getIntQ(getVoltage()));
			setSect_o900(ro.getColumn("o900").asString());
			setSect_o1800(ro.getColumn("o1800").asString());
		}	
	}

}
