/*
 * Created on 01.12.2006
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
public class EditPowerResourceForm extends CommonConfigCtrlForm {

	private String resourceSet;
    private String nriCode;
	private String resourceName;
	private String model;
	private String quantity;
	private String isSave = FALSE_STR;
	private String errorMsg = "";
	private String isLoadFromDB = FALSE_STR;
	private String unit_name = "";
					
	public int getApplication() {
		return Applications.DICTIONARY;
	}

	public int getState() {
		int returnState = com.hps.july.dictionary.APPStates.EDIT_POWER_RESOURCE_FORM;
		return returnState;
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
	public String getNriCode() {
		return nriCode;
	}

	/**
	 * @return
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @return
	 */
	public String getResourceName() {
		return resourceName;
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
	public void setNriCode(String string) {
		nriCode = string;
	}

	/**
	 * @param string
	 */
	public void setQuantity(String string) {
		quantity = string;
	}

	/**
	 * @param string
	 */
	public void setResourceName(String string) {
		resourceName = string;
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
	public String getResourceSet() {
		return resourceSet;
	}

	/**
	 * @param string
	 */
	public void setResourceSet(String string) {
		resourceSet = string;
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
	 * Загрузка из базы
	 */
	public void loadFromDB() {
		CDBCResultSet curStructRS = CDBCDictionaryObject.findCurCmplStruct(getResourceSet(), getNriCode());
		// популируем в бин
		Iterator it = curStructRS.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			setResourceName(ro.getColumn("resourceName").asString());
			setModel(ro.getColumn("model").asString());
			// System.out.println("### isUnitInt() = "+isUnitInt());
			setQuantity(getIntegerString(ro.getColumn("quantity").asString(), isUnitInt()));
			setUnit_name(ro.getColumn("unit_name").asString());
			// setQuantity(ro.getColumn("quantity").asString());
			// Double budDouble = new Double(getQuantity());
			// setQuantity(new Integer(budDouble.intValue()).toString());
		}	
	}

	/**
	 * @return
	 */
	public String getUnit_name() {
		return unit_name;
	}

	/**
	 * @param string
	 */
	public void setUnit_name(String string) {
		unit_name = string;
	}

}
