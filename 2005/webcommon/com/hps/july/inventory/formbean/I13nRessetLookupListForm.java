package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма выбора набора оборудования для инвентаризации
 */
public class I13nRessetLookupListForm extends com.hps.july.web.util.BrowseForm {
	private int document;
	private String blanknumber;
	private int blankindex;	
	private StringAndSqlDateProperty blankdate;
	private String ownername;
public I13nRessetLookupListForm() {
	this.setFinderMethodName( "findI13nActResourceSetByI13nAct" );
//	this.setFinderMethodName( "findResourcesByQBE" );
//	searchtype = "C";
	blankdate = new StringAndSqlDateProperty();
	blanknumber = "";
}
public java.sql.Date getBlankdate() {
	return blankdate.getSqlDate();
}
public String getBlankdatestr() {
	return blankdate.getString();
}
/**
 * 
 * @return int
 */
public int getBlankindex() {
	return blankindex;
}
public java.lang.String getBlanknumber() {
	return blanknumber;
}
public int getDocument() {
	return document;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		new DocumentKey(document)
	};
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 20:07:40)
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
public void setBlankdate(java.sql.Date newDate)
{
	blankdate.setSqlDate(newDate);
}
public void setBlankdatestr(String newDate)
{
	blankdate.setString(newDate);
}
/**
 * 
 * @param newBlankindex int
 */
public void setBlankindex(int newBlankindex) {
	blankindex = newBlankindex;
}
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
public void setDocument(int newDocument)
{
	document = newDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 20:07:40)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
}
