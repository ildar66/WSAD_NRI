package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Ѕазовый класс дл€ формы списка строк актов замены
 * —одержит пол€ общие дл€ всех актов замены
 * информаци€ из этих полей показываетс€ в заголовке формы
 */
public abstract class AbstractChangePositionListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndIntegerProperty document;
	private String blanknumber;
	private int blankindex;
	private java.sql.Date blankdate;
	private String ownername;
	private java.lang.Boolean readonly;
	private String acttype;
public AbstractChangePositionListForm() {
	document = new StringAndIntegerProperty();
	blanknumber = null;
	blankindex = 0;
	blankdate = new java.sql.Date((new java.util.Date()).getTime());
	ownername = null;
	readonly = Boolean.FALSE;
	this.setFinderMethodName( "findChangeActPositionByChangeAct" );
	acttype = "C";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getActtype() {
	return acttype;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 16:05:27)
 * @return java.sql.Date
 */
public java.sql.Date getBlankdate() {
	return blankdate;
}
/**
 * 
 * @return int
 */
public int getBlankindex() {
	return blankindex;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
public Integer getDocument() {
	return document.getInteger();
}
public String getDocumentstr() {
	return document.getString();
}
public java.lang.Object[] getFilterParams() {
	if(document.getInteger() != null) {
		return new Object[] {
			new DocumentKey(document.getInteger().intValue())
		};
	} else {
		return new Object[] {
			new DocumentKey(0)
		};
	}
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 10:41:56)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getReadonly() {
	return readonly;
}
/**
 * 
 * @param newActtype java.lang.String
 */
public void setActtype(java.lang.String newActtype) {
	acttype = newActtype;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 16:05:27)
 * @param newBlankdate java.sql.Date
 */
public void setBlankdate(java.sql.Date newBlankdate) {
	blankdate = newBlankdate;
}
/**
 * 
 * @param newBlankindex int
 */
public void setBlankindex(int newBlankindex) {
	blankindex = newBlankindex;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
public void setDocument(Integer newDocument)
{
	document.setInteger(newDocument);
}
public void setDocumentstr(String newDate)
{
	document.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 10:41:56)
 * @param newReadonly java.lang.Boolean
 */
public void setReadonly(java.lang.Boolean newReadonly) {
	readonly = newReadonly;
}
}
