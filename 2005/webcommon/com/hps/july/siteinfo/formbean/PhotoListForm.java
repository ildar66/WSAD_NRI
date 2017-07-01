package com.hps.july.siteinfo.formbean;

import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.cdbc.lib.*;
/**
 * Форма списка фотографий
 */
public class PhotoListForm extends com.hps.july.web.util.BrowseForm {
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;
	private java.lang.Boolean isPhotographer;
	public StringAndIntegerProperty photographerId;
	private String photographerName;
	private java.lang.String dateFrm1;
	private java.lang.String dateFrm2;
	private java.lang.Boolean isDate;
	private int[] photoid;
	private boolean preview = true;
	private com.hps.july.cdbc.lib.CDBCResultSet groupNames = new com.hps.july.cdbc.lib.CDBCResultSet();
	private java.lang.String groupName = null;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public PhotoListForm() {
	this.setFinderMethodName( "findPhoto" );
	storageplace = 0;
	posname = "";
	isPhotographer = new Boolean(true);
	photographerId = new StringAndIntegerProperty();
	photographerId.setInteger(new Integer(0));
	photographerName = "";
	dateFrm1 = "";
	dateFrm2 = "";
	isDate = new Boolean(true);
	photoid = new int[0];
	}
private java.sql.Date getDate(String dateFrm){

	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("dd.MM.yyyy");
	try{
        if ((dateFrm == null) || (dateFrm.length() == 0)) 
	      return new java.sql.Date(System.currentTimeMillis());
        else 
	        return new java.sql.Date(df.parse(dateFrm).getTime());
	}catch(java.text.ParseException ex){
		isDate = new Boolean(false);
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 17:14:50)
 * @return java.lang.String
 */
public java.lang.String getDateFrm1() {
	return dateFrm1;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 17:16:03)
 * @return java.lang.String
 */
public java.lang.String getDateFrm2() {
	return dateFrm2;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	roles.add("siteExploitor");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	//return new Object[] { new com.hps.july.persistence.StoragePlaceKey(storageplace) };
	Boolean tempDate, tempPhotographer;
	if(isDate.booleanValue())	tempDate = new Boolean(false);
	else tempDate = new Boolean(true);
	
	if(isPhotographer.booleanValue()) tempPhotographer = new Boolean(false);
	else if(!isPhotographer.booleanValue() && photographerId.getInteger() != null && 
		photographerId.getInteger().intValue()>0)
		tempPhotographer = new Boolean(true);
	else tempPhotographer = new Boolean(false);

	if(groupName == null) groupName = "";
	Object[]obj = new Object[] { new Integer(storageplace),
		tempDate, getDate(dateFrm1), getDate(dateFrm2), 
		tempPhotographer, getPhotographerId(), this.groupName};
	return obj;
}
/**
 * Insert the method's description here.
 * Creation date: (22.03.2005 14:31:10)
 * @return java.lang.String
 */
public java.lang.String getGroupName() {
	return groupName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.03.2005 14:22:45)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public com.hps.july.cdbc.lib.CDBCResultSet getGroupNames() {
	return groupNames;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 17:17:09)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDate() {
	return isDate;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 16:30:04)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsPhotographer() {
	return isPhotographer;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 16:33:19)
 * @return java.lang.Integer
 */
public java.lang.Integer getPhotographerId() {
	if(photographerId.getInteger() == null)
	return new Integer(0);
	else
	return photographerId.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 16:37:06)
 * @return java.lang.String
 */
public java.lang.String getPhotographerName() {
	return photographerName;
}
/**
 * Insert the method's description here.
 * Creation date: (31.07.2003 18:42:55)
 * @return int[]
 */
public int[] getPhotoid() {
	return photoid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:05:40)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:14)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request,
    	HttpServletResponse response) throws IOException, javax.servlet.ServletException {
	    	
	    this.groupNames = new CDBCResultSet();
		try{
		    this.groupNames.executeQuery(com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_SELECT_UNIQUE_GROUP, new Object [] { new Integer(getStorageplace()) });
		}catch(Exception e1) {}
	    	
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.03.2005 10:29:40)
 * @return boolean
 */
public boolean isPreview() {
	return preview;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 17:14:50)
 * @param newDateFrm1 java.lang.String
 */
public void setDateFrm1(java.lang.String newDateFrm1) {
	dateFrm1 = newDateFrm1;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 17:16:03)
 * @param newDateFrm2 java.lang.String
 */
public void setDateFrm2(java.lang.String newDateFrm2) {
	dateFrm2 = newDateFrm2;
}
/**
 * Insert the method's description here.
 * Creation date: (22.03.2005 14:31:10)
 * @param newGroupName java.lang.String
 */
public void setGroupName(java.lang.String newGroupName) {
	groupName = newGroupName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.03.2005 14:22:45)
 * @param newGroupNames com.hps.july.cdbc.lib.CDBCResultSet
 */
public void setGroupNames(com.hps.july.cdbc.lib.CDBCResultSet newGroupNames) {
	groupNames = newGroupNames;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 17:17:09)
 * @param newIsDate java.lang.Boolean
 */
public void setIsDate(java.lang.Boolean newIsDate) {
	isDate = newIsDate;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 16:30:04)
 * @param newIsPhotographer java.lang.Boolean
 */
public void setIsPhotographer(java.lang.Boolean newIsPhotographer) {
	isPhotographer = newIsPhotographer;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 16:33:19)
 * @param newPhotographerId java.lang.Integer
 */
public void setPhotographerId(java.lang.Integer newPhotographerId) {
	photographerId.setInteger(newPhotographerId);
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2002 16:37:06)
 * @param newPhotographerName java.lang.String
 */
public void setPhotographerName(java.lang.String newPhotographerName) {
	photographerName = newPhotographerName;
}
/**
 * Insert the method's description here.
 * Creation date: (31.07.2003 18:42:55)
 * @param newPhotoid int[]
 */
public void setPhotoid(int[] newPhotoid) {
	photoid = newPhotoid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:05:40)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.03.2005 10:29:40)
 * @param newPreview boolean
 */
public void setPreview(boolean newPreview) {
	preview = newPreview;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:14)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
