package com.hps.july.arenda.valueobject;

import java.sql.*;
/**
 * ТИПЫ разрешений.
 * Creation date: (04.05.2005 17:21:54)
 * @author: Shafigullin Ildar
 */
public class LicenciesOnPos_VO {
    private java.lang.Integer idLicence;
    private java.lang.Integer position;
    /**
     -- ТИПЫ разрешений:
    			1-ФАС               
    			2-РУЦР              
    			3-Аэро-граж         
    			4-Аэро-воен в\ч     
    			5-ГПС               
    			6-ГАСН              
    			7-СЭС       
    			8-Аэро в\ч            
    			9-ТУ                
        		10-Акт Землеотвода  
    			11-Дело кадастра    
    			12-Договор имущества
    */
    private java.lang.Integer typeLicence;
    private Date dateLicence;
    private Timestamp created;
    private java.lang.Integer createdBy;
	private java.sql.Timestamp modified;
	private java.lang.Integer modifiedBy;
	private java.lang.String createdName;
	private java.lang.String modifiedName;
	private java.lang.String noteLicence;
/**
 * LicenciesOnPos_VO constructor comment.
 */
public LicenciesOnPos_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 13:57:34)
 * @param idLicence java.lang.Integer
 */
public LicenciesOnPos_VO(Integer idLicence) {
    super();
    this.idLicence = idLicence;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:33:32)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getCreated() {
	return created;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:34:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getCreatedBy() {
	return createdBy;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 16:41:20)
 * @return java.lang.String
 */
public java.lang.String getCreatedName() {
	return createdName;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:32:56)
 * @return java.sql.Date
 */
public java.sql.Date getDateLicence() {
	return dateLicence;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:23:45)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdLicence() {
	return idLicence;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:39:46)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getModified() {
	return modified;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:40:29)
 * @return java.lang.Integer
 */
public java.lang.Integer getModifiedBy() {
	return modifiedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 16:41:55)
 * @return java.lang.String
 */
public java.lang.String getModifiedName() {
	return modifiedName;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 13:58:25)
 * @return java.lang.String
 */
public java.lang.String getNoteLicence() {
	return noteLicence;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:32:00)
 * @return java.lang.Integer
 */
public java.lang.Integer getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:32:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getTypeLicence() {
	return typeLicence;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:33:32)
 * @param newCreated java.sql.Timestamp
 */
public void setCreated(java.sql.Timestamp newCreated) {
	created = newCreated;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:34:37)
 * @param newCreatedBy java.lang.Integer
 */
public void setCreatedBy(java.lang.Integer newCreatedBy) {
	createdBy = newCreatedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 16:41:20)
 * @param newCreatedName java.lang.String
 */
public void setCreatedName(java.lang.String newCreatedName) {
	createdName = newCreatedName;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:32:56)
 * @param newDatelicence java.sql.Date
 */
public void setDateLicence(java.sql.Date newDateLicence) {
	dateLicence = newDateLicence;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:23:45)
 * @param newIdLicence java.lang.Integer
 */
public void setIdLicence(java.lang.Integer newIdLicence) {
	idLicence = newIdLicence;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:39:46)
 * @param newModified java.sql.Timestamp
 */
public void setModified(java.sql.Timestamp newModified) {
	modified = newModified;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:40:29)
 * @param newModifiedBy java.lang.Integer
 */
public void setModifiedBy(java.lang.Integer newModifiedBy) {
	modifiedBy = newModifiedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 16:41:55)
 * @param newModifierName java.lang.String
 */
public void setModifiedName(java.lang.String newModifiedName) {
	modifiedName = newModifiedName;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 13:58:25)
 * @param newNoteLicence java.lang.String
 */
public void setNoteLicence(java.lang.String newNoteLicence) {
	noteLicence = newNoteLicence;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:32:00)
 * @param newPosition java.lang.Integer
 */
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 17:32:25)
 * @param newTypeLicence java.lang.Integer
 */
public void setTypeLicence(java.lang.Integer newTypeLicence) {
	typeLicence = newTypeLicence;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	// This implementation forwards the message to super. You may replace or supplement this.
	return super.toString();
}
}
