package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.basestation.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;
 
/**
 * Форма списка базовых станций
 */
public class BaseStationListForm
	extends EquipmentListForm
{
//	private RegionsSelector regionsSelector = new RegionsSelector();

	private java.lang.String stationType;
	private java.lang.String searchBy;
	private java.lang.String searchString;

	private java.lang.Boolean isAllControllers=Boolean.TRUE;
	private int controllerId;
	private StringAndInteger contrNumber=new StringAndInteger();
	private java.lang.String contrname;
	private java.lang.String contrposname;

	private Boolean isAllSwitches=Boolean.TRUE;
	private int switchId;
	private StringAndInteger switchNumber= new StringAndInteger();
	private String switchname;

	private String onair;

	private java.lang.String showOnmap;
	private Integer order = new Integer(1);
public BaseStationListForm() {
	super();
	setLastVisited(true);
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 16:22:59)
 * @return java.lang.String
 */
public String actionName(){
	return "ShowBaseStationList.do";
	}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 18:12:54)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
//    return "com.hps.july.basestation.valueobject.BaseStationObject";
	return "com.hps.july.cdbc.objects.CDBCEquipmentObject";
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:49:43)
 * @return java.lang.String
 */
public java.lang.String getContrname() {
	return contrname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:57:53)
 * @return java.lang.Integer
 */
public java.lang.Integer getContrNumber() throws Exception{
    

        return contrNumber==null?null:contrNumber.getInteger();
   
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:15)
 * @return java.lang.String
 */
public java.lang.String getContrNumberFrm() {
    try {
        return contrNumber.getString();
    } catch (Exception e) {
        return null;
    }
}
public ControllerAccessBean getController()
	throws Exception
{
	ControllerAccessBean res = null;
	if (getContrNumber() != null) {
		try {
			res = ControllerModel.getFromIdAndNumber(getControllerId(), getContrNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setContrParams(res);
	}
	return res;
}
/**
 * 
 * @return int
 */
public int getControllerId() {
	return controllerId;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 10:52:22)
 * @return java.lang.String
 */
public java.lang.String getContrposname() {
	return contrposname;
}
public java.lang.Object[] getFilterParams() {
    Integer contr;
    try {
        contr = new Integer(getControllerId());
    } catch (Exception e) {
        contr = new Integer(0);
    }
    Integer switch_;
    try {
        switch_ = new Integer(getSwitchId());
    } catch (Exception e) {
        switch_ = new Integer(0);
    }

	Boolean isControllerSearch = (getIsAllControllers() != null)?getIsAllControllers():Boolean.FALSE;
	if(BaseStationObject.TYPE_SEARCH_DAMPS.equals(stationType)) {
		isControllerSearch = Boolean.TRUE;
	}

	try {
		return new Object[] {
			new Boolean(getRegionsSelector().isAllNetzones()), //getIsAllNetZones(),
			getRegionsSelector().getNetzonecodes(), /*Integer[] netZones,*/
			getStationType(), /*String type,*/
			new Boolean(getRegionsSelector().isAllRegions()), //getIsAllRegions(), /*Boolean isAllRegions,*/
			getRegionsSelector().getRegioncodes(), /*Integer[] regions,*/
			new Boolean(getRegionsSelector().isAllSuperregions()), //getIsAllSupregs(), /*Boolean isAllSupregs,*/
			getRegionsSelector().getSuperregioncodes(),//getSupregcodes(), /*Integer[] supregs,*/
			getSearchBy(), /*String searchBy,*/
			getSearchString(), /*String searchValue,*/
			(getIsAllSwitches() != null)?getIsAllSwitches():Boolean.FALSE, /*Boolean isAllSwitches,*/
			switch_, /*Integer switcH,*/
			isControllerSearch, /*Boolean isAllControllers,*/
            contr, /*Integer controller,*/
			getIsAllStates(), // Boolean isAllStates
			getEquipmentState(), /*String state,*/
			"*", /*String equipmentState,*/
            getOnair(), /*String onair,*/
            new Boolean(isAdmin()),/*Boolean isAdmin,*/
            getUsername(),/*String*/
            getOrder()
		};
	} catch (Exception e) {
		DebugSupport.printlnError(e, "getFilterParams", this);
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
//	return "findByQBE";
	return "findBaseStations";
}
/**
 * Insert the method's description here.
 * Creation date: (07.03.2003 19:49:15)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAllControllers() {
	return isAllControllers==null?Boolean.TRUE:isAllControllers;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 23:08:54)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAllStates() {
	if(getEquipmentState() != null && "*".equals(getEquipmentState())) {
		return Boolean.TRUE;
	} else {
		return Boolean.FALSE;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.03.2003 19:46:47)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAllSwitches() {
	return isAllSwitches==null?Boolean.TRUE:isAllSwitches;
}
/**
 * Insert the method's description here.
 * Creation date: (07.03.2003 20:23:29)
 * @return java.lang.String
 */
public java.lang.String getOnair() {
	return onair==null?BaseStationObject.SEARCH_ALL:onair;
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2003 22:19:22)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2002 15:13:26)
 * @return java.lang.String
 */
public java.lang.String getShowOnmap() {
	return showOnmap;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 21:07:04)
 * @return int
 */
public int getState() {
	return APPStates.BS_LIST;
}
/**
 * Insert the method's description here.
 * Creation date: (07.03.2003 19:40:02)
 * @return java.lang.String
 */
public java.lang.String getStationType() {
	return stationType==null?BaseStationObject.TYPE_SEARCH_GSM:stationType;
}
public SwitchAccessBean getSwitch() throws Exception {
	SwitchAccessBean res = null;
    if (getSwitchNumber() != null) {
		setSwitchname("");
		try {
			res = SwitchModel.getFromIdAndNumber(getSwitchId(), getSwitchNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSwitchParams(res);
    }
    return res;
}
/**
 * 
 * @return int
 */
public int getSwitchId() {
	return switchId;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSwitchname() {
	return switchname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getSwitchNumber() {
    try {
        return switchNumber.getInteger();
    } catch (Exception e) {
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:54)
 * @return java.lang.String
 */
public java.lang.String getSwitchNumberFrm() {
    try {
        return switchNumber.getString();
    } catch (Exception e) {
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 15:49:43)
 * @param newContrname java.lang.String
 */
public void setContrname(java.lang.String newContrname) {
	contrname = newContrname;
}
public void setContrNumber(Integer newContrNumber) {
	contrNumber.setInteger(newContrNumber);
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:15)
 * @param newContrNumberFrm java.lang.String
 */
public void setContrNumberFrm(java.lang.String newContrNumberFrm) {
	contrNumber.setString(newContrNumberFrm);
}
/**
 * 
 * @param newControllerId int
 */
public void setControllerId(int newControllerId) {
	controllerId = newControllerId;
}
public ControllerAccessBean setContrParams(ControllerAccessBean bean)
	throws Exception
{
	if(bean != null) {
		setContrname(bean.getName());
		setContrposname(PositionModel.getPositionFullName(bean.getPosition()));
		setControllerId(bean.getStorageplace());
		setContrNumber(new Integer(bean.getNumber()));
	} else {
		setContrname("");
		setContrposname("");
		setControllerId(0);
		setContrNumberFrm("");
	}
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 10:52:22)
 * @param newContrposname java.lang.String
 */
public void setContrposname(java.lang.String newContrposname) {
	contrposname = newContrposname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @param newFinderMethodName java.lang.String
 */
public void setFinderMethodName(java.lang.String newFinderMethodName) {

    //DebugSupport.printlnTest("!!!!!!!setFinderMethodName started arg="+newFinderMethodName);

    //super.setFinderMethodName(newFinderMethodName);

    try {
        order = new Integer(Integer.parseInt(newFinderMethodName));
    } catch (NumberFormatException e) {
    }
    //DebugSupport.printlnTest("!!!!!!!setFinderMethodName finished super.getFinderMethodName()="+super.getFinderMethodName());

}
/**
 * Insert the method's description here.
 * Creation date: (07.03.2003 19:49:15)
 * @param newIsAllControllers java.lang.Boolean
 */
public void setIsAllControllers(java.lang.Boolean newIsAllControllers) {
	isAllControllers = newIsAllControllers;
}
/**
 * Insert the method's description here.
 * Creation date: (07.03.2003 19:46:47)
 * @param newIsAllSwitches java.lang.Boolean
 */
public void setIsAllSwitches(java.lang.Boolean newIsAllSwitches) {
	isAllSwitches = newIsAllSwitches;
}
/**
 * Insert the method's description here.
 * Creation date: (07.03.2003 20:23:29)
 * @param newOnair java.lang.String
 */
public void setOnair(java.lang.String newOnair) {
	onair = newOnair;
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2003 22:19:22)
 * @param newOrder java.lang.Integer
 */
public void setOrder(java.lang.Integer newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2002 15:13:26)
 * @param newShowOnmap java.lang.String
 */
public void setShowOnmap(java.lang.String newShowOnmap) {
	showOnmap = newShowOnmap;
}
/**
 * Insert the method's description here.
 * Creation date: (07.03.2003 19:40:02)
 * @param newStationType java.lang.String
 */
public void setStationType(java.lang.String newStationType) {
	stationType = newStationType;
}
/**
 * 
 * @param newSwitchId int
 */
public void setSwitchId(int newSwitchId) {
	switchId = newSwitchId;
}
/**
 * 
 * @param newSwitchname java.lang.String
 */
public void setSwitchname(java.lang.String newSwitchname) {
	switchname = newSwitchname;
}
public void setSwitchNumber(Integer newSwitchNumber) {
	switchNumber.setInteger(newSwitchNumber);
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:58:54)
 * @param newSwitchNumberFrm java.lang.String
 */
public void setSwitchNumberFrm(java.lang.String newSwitchNumberFrm) {
	switchNumber.setString(newSwitchNumberFrm);
}
public void setSwitchParams(SwitchAccessBean bean)
	throws Exception
{
	if(bean != null) {
		setSwitchname(PositionModel.getPositionFullName(bean.getPosition()));
		setSwitchId(bean.getStorageplace());
		setSwitchNumber(new Integer(bean.getNumber()));
	} else {
		setSwitchname("");
		setSwitchId(0);
		setSwitchNumberFrm("");
	}
}
public void validateValues(ActionErrors errors) throws Exception {
	try {
		super.validateValues(errors);
	} catch (ValidationException ev) {
	}

	if(stationType != null && BaseStationObject.TYPE_SEARCH_GSM.equals(stationType)) {
		try {
			if (!isAllControllers.booleanValue()) {
				if (contrNumber.isOkAndNotEmpty()) {
					getController();
				} else {
					throw new Exception();
				}
			}
		} catch (Exception ex) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.controller"));
		}
	}

	try {
		if (!isAllSwitches.booleanValue()) {
			if (switchNumber.isOkAndNotEmpty()) {
				getSwitch();
			} else {
				throw new Exception();
			}
		}
	} catch (Exception ex) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.basestation.switch"));
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
