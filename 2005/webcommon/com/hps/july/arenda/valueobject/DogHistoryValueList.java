/*
 * Created on 14.11.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.util.ArrayList;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DogHistoryValueList {
	private Integer mainContract = null;
	private ArrayList dogHistoryList = null;

	/**
	 * 
	 */
	public DogHistoryValueList(Integer aMainContract, ArrayList aDogHistoryList) {
		super();
		mainContract = aMainContract;
		dogHistoryList = aDogHistoryList;
	}

	/**
	 * @return
	 */
	public ArrayList getDogHistoryList() {
		return dogHistoryList;
	}

	/**
	 * @return
	 */
	public Integer getMainContract() {
		return mainContract;
	}

}
