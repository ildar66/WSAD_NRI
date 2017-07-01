package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;

/**
 * Форма выбора типов оборудования попадающих в отчёт "Наличие оборудования"
 * При показе форма принимает код вида оборудования
 */
public class Report1rstLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
	private int resourcetype;
	private java.lang.String resourcetypename;
	private int resourcesubtype;
//	private int[] selectedSubtypes;
	private Boolean rtchecked;
	private java.util.Hashtable allSubtypes;
public Report1rstLookupListForm() {
	this.setFinderMethodName( "findResourceSubTypeByResourcetype" );
	resourcetype = 0;
//	selectedSubtypes = new int[0];
	allSubtypes = new java.util.Hashtable();
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { new ResourceTypeKey(resourcetype) };
}
public int getResourcesubtype() {
	return resourcesubtype;
}
public int getResourcetype() {
	return resourcetype;
}
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
public String getResultString() {
	String result = "";
	int[] items;
	boolean comma = false;
	java.util.Enumeration e = allSubtypes.keys();
	if(e.hasMoreElements()) {
		items = (int[])allSubtypes.get((Integer)e.nextElement());
		if(items.length > 1) {
			for(int i = 0; i < items.length - 1; i++) {
				if(items[i] > 0) {
					if(comma) result += ",";
					result += String.valueOf(items[i]);
					comma = true;
				}
			}
		}
	}
	return result;
}
public String getResultString(String promptName) {
	String result = "";
	int[] items;
	boolean comma = false;
	java.util.Enumeration e = allSubtypes.keys();
	if(e.hasMoreElements()) {
		items = (int[])allSubtypes.get((Integer)e.nextElement());
		if(items.length > 1) {
			for(int i = 0; i < items.length - 1; i++) {
				if(items[i] > 0) {
					if(comma) result += "&";
					result += promptName + "=" +String.valueOf(items[i]);
					comma = true;
				}
			}
		}
	}
	return result;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getRtchecked() {
	return rtchecked;
}
public int[] getSelectedSubtypes() {
	try {
		return (int[])allSubtypes.get(new Integer(resourcetype));
	} catch(Exception e) {
		return new int[0];
	}
}
public void setResourcesubtype(int newResourcesubtype) {
	resourcesubtype = newResourcesubtype;
}
public void setResourcetype(int newResourcetype) {
	resourcetype = newResourcetype;
}
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
/**
 * 
 * @param newRtchecked java.lang.Boolean
 */
public void setRtchecked(java.lang.Boolean newRtchecked) {
	rtchecked = newRtchecked;
}
public void setSelectedSubtypes(int[] newSelectedSubtypes) {
	allSubtypes.put(new Integer(resourcetype),newSelectedSubtypes);
}
}
