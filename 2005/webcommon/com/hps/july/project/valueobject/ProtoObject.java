package com.hps.july.project.valueobject;

import com.hps.july.persistence.*;
import java.util.*;

/**
 * Объект-wrapper для типового события
 * Creation date: (23.05.2003 10:23:28)
 * @author: Dmitry Dneprov
 */
public class ProtoObject {
	private com.hps.july.persistence.ProtoActionAccessBean proto;
	private java.lang.String respname;
	private int position;
	private com.hps.july.persistence.ProjectActionTypeAccessBean projectactiontype;
/**
 * ProtoObject constructor comment.
 */
public ProtoObject() {
	super();
	position = 0;
	respname = "";
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 10:38:32)
 * @return int
 */
public int getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:09:06)
 * @return com.hps.july.persistence.ProjectActionTypeAccessBean
 */
public com.hps.july.persistence.ProjectActionTypeAccessBean getProjectactiontype() {
	return projectactiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 10:24:13)
 * @return com.hps.july.persistence.ProtoActionAccessBean
 */
public com.hps.july.persistence.ProtoActionAccessBean getProto() {
	return proto;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 10:25:02)
 * @return java.lang.String
 */
public java.lang.String getRespname() {
	return respname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 10:38:32)
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:09:06)
 * @param newProjectactiontype com.hps.july.persistence.ProjectActionTypeAccessBean
 */
public void setProjectactiontype(com.hps.july.persistence.ProjectActionTypeAccessBean newProjectactiontype) {
	projectactiontype = newProjectactiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 10:24:13)
 * @param newProto com.hps.july.persistence.ProtoActionAccessBean
 */
public void setProto(ProtoActionAccessBean newProto) {
	proto = newProto;

	try {
		setProjectactiontype(newProto.getProjectActionType());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
		
	
	// Determine responsible
	try {
		PositionResponsibleWorkersAccessBean resp = new PositionResponsibleWorkersAccessBean();
		resp.setInitKey_position_storageplace(new Integer(getPosition()));
		resp.setInitKey_type_responsibilityType(new Integer(newProto.getProjectActionType().getResponsibilitytype().getResponsibilityType()));
		resp.refreshCopyHelper();
		setRespname(resp.getWorker().getMan().getLastname());
	} catch (Exception e) {
		setRespname("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 10:25:02)
 * @param newRespname java.lang.String
 */
public void setRespname(java.lang.String newRespname) {
	respname = newRespname;
}
}
