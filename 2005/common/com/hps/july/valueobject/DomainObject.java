package com.hps.july.valueobject;

import java.sql.*;
/**
 * Ѕазовый класс дл€ VO.
 * Creation date: (07.11.2005 13:36:57)
 * @author: Shafigullin Ildar
 */
public class DomainObject {
    private boolean isGhost = false;//flag призрака(VO с частичными данными).

    private Timestamp created;
    private java.lang.Integer createdBy;
    private java.sql.Timestamp modified;
    private java.lang.Integer modifiedBy;
/**
 * DomainObject constructor comment.
 */
public DomainObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getCreated() {
	return created;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @return java.lang.Integer
 */
public java.lang.Integer getCreatedBy() {
	return createdBy;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getModified() {
	return modified;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @return java.lang.Integer
 */
public java.lang.Integer getModifiedBy() {
	return modifiedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @return boolean
 */
public boolean isIsGhost() {
	return isGhost;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @param newCreated java.sql.Timestamp
 */
public void setCreated(java.sql.Timestamp newCreated) {
	created = newCreated;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @param newCreatedBy java.lang.Integer
 */
public void setCreatedBy(java.lang.Integer newCreatedBy) {
	createdBy = newCreatedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @param newIsGhost boolean
 */
public void setIsGhost(boolean newIsGhost) {
	isGhost = newIsGhost;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @param newModified java.sql.Timestamp
 */
public void setModified(java.sql.Timestamp newModified) {
	modified = newModified;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:39:30)
 * @param newModifiedBy java.lang.Integer
 */
public void setModifiedBy(java.lang.Integer newModifiedBy) {
	modifiedBy = newModifiedBy;
}
}
