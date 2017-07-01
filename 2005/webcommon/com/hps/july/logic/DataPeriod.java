package com.hps.july.logic;

import com.hps.july.web.util.*;
/**
 * Описывает период дат и, например, утилитно используется Struts form-beans.
 * Creation date: (24.01.2005 14:21:19)
 * @author: Shafigullin Ildar
 */
public class DataPeriod {
	private StringAndSqlDateProperty fromDate = null;
	private StringAndSqlDateProperty toDate = null;
	/**
	 * QueryPeriod constructor comment.
	 */
	public DataPeriod() {
		super();
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		toDate = new StringAndSqlDateProperty();
		toDate.setSqlDate(date);
		fromDate = new StringAndSqlDateProperty();
		fromDate.setSqlDate(date);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2005 14:29:06)
	 */
	public java.sql.Date getFromDate() {
		return fromDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2005 14:29:15)
	 */
	public String getFromDateFrm() {
		return fromDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2005 14:28:36)
	 */
	public java.sql.Date getToDate() {
		return toDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2005 14:28:14)
	 */
	public String getToDateFrm() {
		return toDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2005 14:32:41)
	 */
	public void setFromDate(java.sql.Date newFromDate) {
		fromDate.setSqlDate(newFromDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2005 14:31:35)
	 */
	public void setFromDateFrm(String newFromDate) {
		fromDate.setString(newFromDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2005 14:33:09)
	 */
	public void setToDate(java.sql.Date newToDate) {
		toDate.setSqlDate(newToDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2005 14:33:40)
	 */
	public void setToDateFrm(String newToDate) {
		toDate.setString(newToDate);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object otherObject) {
		// a quick test to see if the objects are identical
		if (this == otherObject)
			return true;

		// must return false if the explicit parameter is null
		if (otherObject == null)
			return false;

		// if the classes don't match, they can't be equal
		if (getClass() != otherObject.getClass())
			return false;

		// now we know otherObject is a non-null DataPeriod
		DataPeriod other = (DataPeriod) otherObject;

		// test whether the fields have identical values
		return fromDate.getSqlDate().equals(other.fromDate.getSqlDate()) && toDate.getSqlDate().equals(other.toDate.getSqlDate());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return 7 * fromDate.getSqlDate().hashCode() + 11 * toDate.getSqlDate().hashCode();
	}

}
