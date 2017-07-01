/*
 * Created on 19.01.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.valueobject;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AdminRegionHistory {

	/**
	 * 
	 */
	public AdminRegionHistory() {
		super();
	}
	private java.lang.String sortBy;
	private java.lang.Boolean isName;
	private java.lang.String name;
	private java.lang.Boolean isParentRegID;
	private java.lang.Integer parentRegID;
	private java.lang.String title;

	/**
	 * @return
	 */
	public java.lang.Boolean getIsName() {
		return isName;
	}

	/**
	 * @return
	 */
	public java.lang.Boolean getIsParentRegID() {
		return isParentRegID;
	}

	/**
	 * @return
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getParentRegID() {
		return parentRegID;
	}

	/**
	 * @return
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}

	/**
	 * @param boolean1
	 */
	public void setIsName(java.lang.Boolean boolean1) {
		isName = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setIsParentRegID(java.lang.Boolean boolean1) {
		isParentRegID = boolean1;
	}

	/**
	 * @param string
	 */
	public void setName(java.lang.String string) {
		name = string;
	}

	/**
	 * @param integer
	 */
	public void setParentRegID(java.lang.Integer integer) {
		parentRegID = integer;
	}

	/**
	 * @param string
	 */
	public void setSortBy(java.lang.String string) {
		sortBy = string;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof AdminRegionHistory)) {
			return false;
		}
		AdminRegionHistory anAdminRegionHistory = (AdminRegionHistory) anObject;
		return anAdminRegionHistory.getParentRegID().equals(getParentRegID());
	}
	/**
	 * @return
	 */
	public java.lang.String getTitle() {
		return title;
	}

	/**
	 * @param string
	 */
	public void setTitle(java.lang.String string) {
		title = string;
	}

}
