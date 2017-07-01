package com.hps.july.basestation.formbean;

import com.hps.july.siteinfo.valueobject.RegionsSelector;
import com.hps.july.persistence.*;
import com.hps.july.basestation.*;
import java.util.*;
import com.hps.july.basestation.valueobject.*;

/**
 * Форма списка контроллеров базовой станции
 */
public class ControllerBaseStationsList extends BaseStationListForm {
	private String positionname;
	private String regionname;
	private String zonename;
	private String address;
	private String controllername;
/**
 * ControllerBaseStationsList constructor comment.
 */
public ControllerBaseStationsList() {
	RegionsSelector s = getRegionsSelector();
	s.setAllNetzones(true);
	s.setAllRegions(true);
	s.setAllSuperregions(true);
	setStationType(SEARCH_ALL);
	setSearchBy(SEARCH_ALL);
	setSearchString("");
	setIsAllSwitches(Boolean.TRUE);
	setIsAllControllers(Boolean.FALSE);
	setEquipmentState("*");
//	setEquipmentPlanstate(SEARCH_ALL);
	setOnair(SEARCH_ALL);
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 16:22:59)
 * @return java.lang.String
 */
public String actionName(){
	return "ShowControllerBaseStationsList.do";
	}
public void fillFilter() {
	try {
		System.out.println("getContrNumber() = " + getContrNumber());
		ControllerAccessBean controllerBean = getController();
		setControllername(controllerBean.getName() + ", " + controllerBean.getNumber());

		PositionAccessBean posBean = controllerBean.getPosition();
		
		positionname = PositionModel.getPositionFullName(controllerBean.getPosition());

		setRegionname(posBean.getRegion().getRegname());
		setZonename(posBean.getNetZone().getName());
		setAddress(posBean.getAddress());
//		setPlanstate(posBean.getPlanstate());
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @return java.lang.String
 */
public java.lang.String getControllername() {
	return controllername;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @return java.lang.String
 */
public java.lang.String getRegionname() {
	return regionname;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 18:32:37)
 * @return int
 */
public int getState() {
	return APPStates.CONTROLLER_CONNECTED_BS;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @return java.lang.String
 */
public java.lang.String getZonename() {
	return zonename;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @param newControllername java.lang.String
 */
public void setControllername(java.lang.String newControllername) {
	controllername = newControllername;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @param newRegionname java.lang.String
 */
public void setRegionname(java.lang.String newRegionname) {
	regionname = newRegionname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2003 15:22:35)
 * @param newZonename java.lang.String
 */
public void setZonename(java.lang.String newZonename) {
	zonename = newZonename;
}
}
