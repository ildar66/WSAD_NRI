/*
 * Created on 04.07.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.inventory.valueobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class StandVO extends BSEquipCommonVO {
	
	private List types;
	private String curTypeId;
	private String number;
	private List transList;
	/*
	// значения полей
	private Boolean isOmni900;
	private Boolean is900E;
	private Boolean is900F;
	private Boolean is900G;
	private Boolean is900H;
	private Boolean isOmni1800;
	private Boolean is1800A;
	private Boolean is1800B;
	private Boolean is1800C;
	private Boolean is1800D;
	// для "закрытия" полей (disable)
	private boolean disableOmni900;
	private boolean disable900E;
	private boolean disable900F;
	private boolean disable900G;
	private boolean disable900H;
	private boolean disableOmni1800;
	private boolean disable1800A;
	private boolean disable1800B;
	private boolean disable1800C;
	private boolean disable1800D;
	*/

	public StandVO() {
		super();
		types = new ArrayList();
		curTypeId = "";
		number = "";
		transList = new ArrayList();
	}

	/**
	 * @return
	 */
	public String getCurTypeId() {
		return curTypeId;
	}


	/**
	 * @return
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @return
	 */
	public List getTypes() {
		return types;
	}

	/**
	 * @param integer
	 */
	public void setCurTypeId(String string) {
		curTypeId = string;
	}

	/**
	 * @param string
	 */
	public void setNumber(String string) {
		number = string;
	}

	/**
	 * @param list
	 */
	public void setTypes(List list) {
		types = list;
	}

	/**
	 * @return
	 */
	public List getTransList() {
		return transList;
	}

	/**
	 * @param list
	 */
	public void setTransList(List list) {
		transList = list;
	}

	public int getTransQuant() {
		int outInt = 0;
		if (transList != null) {
			outInt = transList.size(); 
		}
		return outInt;
	}

}
