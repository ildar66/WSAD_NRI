/*
 * Created on 05.12.2006
 *
 * "Фактические данные по договорам Аренды" TO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.util.ArrayList;

/**
 * @author IShaffigulin
 *
 * "Фактические данные по договорам Аренды" TO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FactsLeaseTO {
	private Integer docID;
	private String docNumber;
	private java.sql.Date docDate;	
	private java.lang.String gsmId;
	private java.lang.String dampsId;
	private java.lang.String name;
	private Integer docCurrency;
	private ArrayList statuses;
	/**
	 * 
	 */
	public FactsLeaseTO(Integer id) {
		super();
		setDocID(id);
	}

	/**
	 * @return
	 */
	public java.lang.String getDampsId() {
		return dampsId;
	}

	/**
	 * @return
	 */
	public java.sql.Date getDocDate() {
		return docDate;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @return
	 */
	public java.lang.String getGsmId() {
		return gsmId;
	}

	/**
	 * @return
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * @param string
	 */
	public void setDampsId(java.lang.String string) {
		dampsId = string;
	}

	/**
	 * @param date
	 */
	public void setDocDate(java.sql.Date date) {
		docDate = date;
	}

	/**
	 * @param string
	 */
	public void setDocNumber(String string) {
		docNumber = string;
	}

	/**
	 * @param string
	 */
	public void setGsmId(java.lang.String string) {
		gsmId = string;
	}

	/**
	 * @param string
	 */
	public void setName(java.lang.String string) {
		name = string;
	}

	/**
	 * @return
	 */
	public Integer getDocID() {
		return docID;
	}

	/**
	 * @param integer
	 */
	private void setDocID(Integer integer) {
		docID = integer;
	}

	/**
	 * @return
	 */
	public Integer getDocCurrency() {
		return docCurrency;
	}

	/**
	 * @param integer
	 */
	public void setDocCurrency(Integer integer) {
		docCurrency = integer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "FactsLeaseTO docID= "+ docID + "; docNumber= " + docNumber + "; docDate= " + docDate + "; docCurrency= " + docCurrency;
	}

	/**
	 * @return
	 */
	public ArrayList getStatuses() {
		return statuses;
	}

	/**
	 * @param list
	 */
	public void setStatuses(ArrayList list) {
		statuses = list;
	}

}
