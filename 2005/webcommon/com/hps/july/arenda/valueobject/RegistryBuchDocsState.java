/*
 * Created on 25.12.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RegistryBuchDocsState {
	private String name;
	private String value;
	/**флаги состояния:(см. AbstractRegistryBuchDocsStateFactory)
	public final static String PREPARATION = "1"; //подготовка описи
	public final static String SEND_PURCHASER = "4"; //отправлена закупщику
	public final static String EDIT_PURCHASER = "5"; //обрабатывается закупщиком
	public final static String SEND_ACCOUNTANT = "2"; //отправлена бухгалтеру
	public final static String EDIT_ACCOUNTANT = "6"; //обрабатывается бухгалтером
	public final static String ACCEPTED_ACCOUNTANT = "3"; //принято бухгалт.
	public final static String SEND_INITIATOR = "7"; //передан инициатору.
	public final static String ACCEPTED_INITIATOR = "8"; //принята инициатором.	
	*/
	/**
	 * 
	 * @param aName
	 * @param aValue
	 */

	public RegistryBuchDocsState(String aName, String aValue) {
		super();
		name = aName;
		value = aValue;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name;
	}

}
