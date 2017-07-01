package com.hps.july.basestation.formbean;

import javax.servlet.http.*;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Ѕазова€ форма списка оборудовани€ на позиции
 */
public abstract class EquipmentListForm
	extends com.hps.july.web.util.BrowseForm
	implements Checks, SearchConstants
{
	private RegionsSelector regionsSelector = new RegionsSelector();
    private int order;
    private String searchBy;
    private java.lang.String searchString="";
    private String equipmentState=EQUIPMENT_STATE_WORK_W;
	private String posstate = "PE";
	private boolean isAllMap;
    private int[] checkEquipment= new int[0];
	public int state;
	private String username;
	private boolean admin;
public EquipmentListForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 16:22:59)
 * @return java.lang.String
 */
public abstract String actionName();
public String getBrowseBeanName() {
	return super.getBrowseBeanName();
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 11:49:23)
 * @return int[]
 */
public int[] getCheckEquipment() {
	return checkEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 16:49:27)
 * @return java.lang.String
 */
public java.lang.String getEquipmentState() {
	return equipmentState;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByQBE";
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 13:03:50)
 * @return java.lang.Boolean
 */
public Boolean getIsAdmin() {
	return Boolean.TRUE;
	//return new Boolean(request.isUserInRole("administrator"));
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2003 18:36:22)
 * @return int
 */
public Integer getOrder() {
    try {
        order = Integer.parseInt(super.getFinderMethodName());
    } catch (Exception e) {
    }
    return new Integer(order);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosstate() {
	return posstate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 7:40:13)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getRegions() {
	return new Vector().elements();
}
/**
 * 
 * @return com.hps.july.siteinfo.valueobject.RegionsSelector
 */
public com.hps.july.siteinfo.valueobject.RegionsSelector getRegionsSelector() {
	return regionsSelector;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:23)
 * @return java.lang.String
 */
public java.lang.String getSearchBy() {
	return searchBy==null?BaseStationObject.SEARCH_ALL:searchBy;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:40)
 * @return java.lang.String
 */
public java.lang.String getSearchString() {
	return searchString==null?"":searchString;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 12:40:14)
 * @return int
 */
public int getState() {
	return state;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getUsername() {
	return username;
}
/**
 * 
 * @return boolean
 */
public boolean isAdmin() {
	return admin;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 16:45:52)
 * @return boolean
 */
public boolean isIsAllMap() {
	return isAllMap;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 12:23:07)
 * @return java.lang.String
 */
public String mapUrl() {
    return "/PositionOnmap.do?from=/basestation/"
        + actionName()
        + "&imageFromCache=false&"
        + AppConstants.APP_HOME
        + "="
        + Applications.BASESTATION
        + "&"
        + AppConstants.APP_STATE
        + "="
        + getState();
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 17:49:43)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void prepare(javax.servlet.http.HttpServletRequest request)   {
	admin = request.isUserInRole("administrator");
	username = request.getRemoteUser();

	//clear checks only then search
	if (request.getParameterValues("checkEquipment") == null&&request.getParameter("searchBy")!=null) {
		checkEquipment = new int[0];	
	}
}
/**
 * 
 * @param newAdmin boolean
 */
public void setAdmin(boolean newAdmin) {
	admin = newAdmin;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 11:49:23)
 * @param newCheckEquipment int[]
 */
public void setCheckEquipment(int[] newCheckEquipment) {
	DebugSupport.printlnTest("!!!!!!!setCheckEquipment newCheckEquipment.length="+newCheckEquipment.length);
	checkEquipment = newCheckEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 16:49:27)
 * @param newEquipmentState java.lang.String
 */
public void setEquipmentState(java.lang.String newEquipmentState) {
	equipmentState = newEquipmentState;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 16:45:52)
 * @param newIsAllMap boolean
 */
public void setIsAllMap(boolean newIsAllMap) {
	isAllMap = newIsAllMap;
}
/**
 * 
 * @param newPosstate java.lang.String
 */
public void setPosstate(java.lang.String newPosstate) {
	posstate = newPosstate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:23)
 * @param newSearchBy java.lang.String
 */
public void setSearchBy(java.lang.String newSearchBy) {
	searchBy = newSearchBy;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:40)
 * @param newSearchString java.lang.String
 */
public void setSearchString(java.lang.String newSearchString) {
	searchString = newSearchString;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 12:40:14)
 * @param newState int
 */
public void setState(int newState) {
	state = newState;
}
/**
 * 
 * @param newUsername java.lang.String
 */
public void setUsername(java.lang.String newUsername) {
	username = newUsername;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(org.apache.struts.action.ActionErrors errors)
    throws Exception {
	    /*
    DebugSupport.printlnTest(
        "EquipmentListForm validateValues searchBy="
            + searchBy
            + " searchString="
            + searchString);
       */     
    if (searchBy != null && searchBy.equals(SearchConstants.SEARCHBY_NUMBER)) {
        try {

            Integer.parseInt(searchString);
        } catch (Exception e) {
            //DebugSupport.printlnTest("EquipmentListForm validateValues add error");

            errors.add(
                ActionErrors.GLOBAL_ERROR,
                new ActionError("error.search.number"));
        }
    }
if (!errors.empty())
        throw new ValidationException();
}
}
