/*
 * Created on 28.11.2006
 */
package com.hps.july.dictionary.formbean;

import java.util.Iterator;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCDictionaryObject;
import com.hps.july.constants.Applications;
import com.hps.july.web.util.EditForm;

/**
 * @author irogachev
 */
public class EditConfPowerSourcesForm extends EditForm {

	private String complectCode;
	private String nfsId;
	private String nfsCode;
	private String nfsName;
	private String complectName;
	private String power;
	private String isSave = ConfPowerSourcesForm.FALSE_STR;
	private String errorMsg = "";
	private String isLoadFromDB = ConfPowerSourcesForm.FALSE_STR;
	private String complectTypeCode;

	public int getApplication() {
		return Applications.DICTIONARY;
	}

	public int getState() {
		int returnState = com.hps.july.dictionary.APPStates.CONF_POWER_SOURCES_FORM;
		return returnState;
	}

	/**
	 * @return
	 */
	public String getComplectCode() {
		return complectCode;
	}

	/**
	 * @return
	 */
	public String getComplectName() {
		return complectName;
	}

	/**
	 * @return
	 */
	public String getNfsCode() {
		return nfsCode;
	}

	/**
	 * @return
	 */
	public String getNfsName() {
		return nfsName;
	}

	/**
	 * @return
	 */
	public String getPower() {
		return power;
	}

	/**
	 * @param string
	 */
	public void setComplectCode(String string) {
		complectCode = string;
	}

	/**
	 * @param string
	 */
	public void setComplectName(String string) {
		complectName = string;
	}

	/**
	 * @param string
	 */
	public void setNfsCode(String string) {
		nfsCode = string;
	}

	/**
	 * @param string
	 */
	public void setNfsName(String string) {
		nfsName = string;
	}

	/**
	 * @param string
	 */
	public void setPower(String string) {
		power = string;
	}

	/**
	 * @return
	 */
	public String getNfsId() {
		return nfsId;
	}

	/**
	 * @param string
	 */
	public void setNfsId(String string) {
		nfsId = string;
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
	 *	Загружаем форму из базы в начале работы
	 */
	public void loadFromDB() {
		CDBCResultSet curComplectRS = CDBCDictionaryObject.findConfigPowerSources(2, getComplectCode(), getComplectTypeCode());
		// популируем в бин
		Iterator it = curComplectRS.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			setNfsCode(ro.getColumn("nfsCode").asString());
			setComplectName(ro.getColumn("complectName").asString());
			setPower(ro.getColumn("power").asString());
			setNfsName(ro.getColumn("nfsName").asString());
			setNfsId(ro.getColumn("nfsId").asString());
		}	
	}

	/**
	 * @return
	 */
	public String getComplectTypeCode() {
		return complectTypeCode;
	}

	/**
	 * @param string
	 */
	public void setComplectTypeCode(String string) {
		complectTypeCode = string;
	}

}
