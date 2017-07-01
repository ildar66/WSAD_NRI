package com.hps.july.sitedoc.formbean;

import com.hps.july.trailcom.beans.*;
import javax.servlet.http.*;
import com.hps.july.persistence.*;
import org.apache.struts.util.MessageResources;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.constants.Applications;
import java.util.*;
import com.hps.july.apptags.*;
import com.hps.july.sitedoc.valueobject.*;

/**
 * Форма списка документов
 */
public class SiteDocListForm extends com.hps.july.web.util.BrowseForm {
	private String searchBy;
	
	private String objectType;
    private String objectId;
    private DocObjectDef objectDef;
    private String appHome;
    private int appState;
    private int order = 1;
	private int stateFrom;
public SiteDocListForm() {
	super();
}
public java.lang.String getAddress() {
	return objectDef.getAddress();
}
public java.lang.String getAppHome() {
	return appHome;
}
public int getAppState() {
    if (Integer.parseInt(getAppHome()) == Applications.BASESTATION) {
        if (getObjectType().equals("BaseStation")) {
            return com.hps.july.basestation.APPStates.BS_LIST;
        } else if (getObjectType().equals("Switch")) {
            return com.hps.july.basestation.APPStates.SwitchListForm;
        }
    }
    return 0;
}
public java.lang.Object[] getFilterParams() {
	try {
		String fn = "E";
		if (objectDef.isPosition()) {
			fn = "P";
		} else if (objectDef.isProject()) {
			fn = "R";
		} else if (objectDef.isProjectAction()) {
			fn = "A";
		} else if (objectDef.isComline()) {
			fn = "H";
		} else if("P".equals(getSearchBy())) {
			fn = "P";
		}
		
		System.out.println("SEARCH BY:"+getSearchBy());
		if(getSearchBy() == null) {
			setSearchBy("");
		}
		String id = "";
		if (isEquipment() && "P".equals(getSearchBy())) {
			id = ""+objectDef.getPositionId();
		} else {
			id=getObjectId();
		}
		try {
			order = Integer.parseInt(super.getFinderMethodName());
		} catch (Exception e) {
		}
		Object[] obj =
			new Object[] {
				fn,
				new Integer(Integer.parseInt(id)),
				new Integer(order)
			};
		DebugSupport.printlnTest("getFilterParams() FN="+ fn +" objId=" + obj[0] + " order=" + new Integer(order));
		return obj;
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		return null;
	}
}
public java.lang.String getFinderMethodName() {
	return "findSitedocByObject";
}
public HopEquipmentValue getHopA() {
	return objectDef.getHopA();
}
public HopEquipmentValue getHopB() {
	return objectDef.getHopB();
}
public java.lang.Integer getHopId() {
	return objectDef.getHopId();
}
public java.lang.String getNetzoneName() {
	return objectDef.getNetzoneName();
}
/**
 * 
 * @return com.hps.july.sitedoc.valueobject.DocObjectDef
 */
public com.hps.july.sitedoc.valueobject.DocObjectDef getObjectDef() {
	return objectDef;
}
public java.lang.String getObjectId() {
	return objectId;
}
public java.lang.String getObjectMenuKey() {
	return objectDef.getObjectMenuKey();
}
public java.lang.String getObjectName() {
	return objectDef.getObjectName();
}
public java.lang.String getObjectType() {
	return objectType;
}
public java.lang.String getObjectUrl() {
	return objectDef.getObjectUrl();
}
public java.lang.Integer getPositionId() {
	return objectDef.getPositionId();
}
public java.lang.String getPositionName() {
	return objectDef.getPositionName();
}
public java.lang.String getProjectActionName() {
	return objectDef.getProjectActionName();
}
public java.lang.Integer getProjectId() {
	return objectDef.getProjectId();
}
public java.lang.String getProjectName() {
	return objectDef.getProjectName();
}
public String getRegionName() {
	return objectDef.getRegionName();
}
public java.lang.String getSearchBy() {
	if(searchBy == null) {
		searchBy = "";
	}
	return searchBy;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2003 22:12:39)
 * @return int
 */
public int getStateFrom() {
	return stateFrom;
}
public int getStorageplace() throws Exception{
	int storageplace = 0;
	try {
		if (getObjectType().equals("ProjectAction") || getObjectType().equals("Project")) {
			storageplace = objectDef.getProjectId().intValue();
		} else {
			storageplace = Integer.parseInt(getObjectId());
		}
		return storageplace;
	} catch(Exception e) {
		new DebugSupport().printlnError(e);
		throw e;
    }
}
public void initObjectDef(javax.servlet.ServletContext app, HttpSession session) {
	int objId = 0;
	try {
		objId = Integer.parseInt(getObjectId());
	} catch(Exception e) {
	}
	objectDef = DocObjectDef.getDef(app,session,getObjectType(),objId,getAppHome());
}
public boolean isEquipment() {
	return objectDef.isEquipment();
/*
    return !getObjectType().equals("Position")
        && !getObjectType().equals("Project")
        && !getObjectType().equals("ProjectAction")
        && !getObjectType().equals("Comline");
        */
}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2003 22:46:12)
 * @param newAppHome java.lang.String
 */
public void setAppHome(java.lang.String newAppHome) {
	appHome = newAppHome;
}
public void setHopA(HopEquipmentValue newHopA) {
	objectDef.setHopA(newHopA);
}
public void setHopB(HopEquipmentValue newHopB) {
	objectDef.setHopB(newHopB);
}
public void setHopId(Integer newHopId) {
	objectDef.setHopId(newHopId);
}
/**
 * 
 * @param newObjectDef com.hps.july.sitedoc.valueobject.DocObjectDef
 */
public void setObjectDef(com.hps.july.sitedoc.valueobject.DocObjectDef newObjectDef) {
	objectDef = newObjectDef;
}
public void setObjectId(java.lang.String newObjectId) {
	objectId = newObjectId;
}
public void setObjectMenuKey(String newObjectMenuKey) {
	objectDef.setObjectMenuKey(newObjectMenuKey);
}
public void setObjectType(java.lang.String newObjectType) {
	objectType = newObjectType;
}
public void setPositionId(Integer newPositionId) {
	objectDef.setPositionId(newPositionId);
}
public void setProjectActionName(String newProjectActionName) {
	objectDef.setProjectActionName(newProjectActionName);
}
public void setProjectId(Integer newProjectId) {
	objectDef.setProjectId(newProjectId);
}
public void setProjectName(String newProjectName) {
	objectDef.setProjectName(newProjectName);
}
public void setSearchBy(java.lang.String newSearchBy) {
	searchBy = newSearchBy;
}
public void setStateFrom(int newStateFrom) {
	stateFrom = newStateFrom;
}
}
