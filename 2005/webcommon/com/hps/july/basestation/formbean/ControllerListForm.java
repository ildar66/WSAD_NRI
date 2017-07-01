package com.hps.july.basestation.formbean;

import com.hps.july.siteinfo.valueobject.RegionsSelector;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.DebugSupport;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.basestation.*;

/**
 * Форма списка контроллеров
 */
public class ControllerListForm extends EquipmentListForm {
	private boolean isSwitch;
	private StringAndIntegerProperty switchcode = new StringAndIntegerProperty();
	private java.lang.String switchname;
	private int switchId;
public ControllerListForm() {
	super();
	setLastVisited(true);
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 16:22:59)
 * @return java.lang.String
 */
public String actionName() {
	return "ShowControllerList.do";
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 18:34:04)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.basestation.valueobject.ControllerObject";
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    /*
	Boolean isAllNetZones, Integer[] netZones,
	Boolean isAllRegions, Integer[] regions,
	Boolean isAllSupregs, Integer[] supregs,
	String searchBy, String searchValue,
	Boolean isSwitch, Integer switchcode,
	String state, String planState,
	Boolean isAdmin,
	String login
    */
    RegionsSelector rs = getRegionsSelector();
    try {
        return new Object[] {
			new Boolean(rs.isAllNetzones()), rs.getNetzonecodes(),
			new Boolean(rs.isAllRegions()), rs.getRegioncodes(),
			new Boolean(rs.isAllSuperregions()), rs.getSuperregioncodes(),
            getSearchBy(), getSearchString(),
            new Boolean(getIsSwitch()), new Integer(getSwitchId()),
            getEquipmentState(),
            POSITION_PLANSTATE_Fact,
            getIsAdmin(),
            getUsername()
		};
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findControllerList";
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2003 12:49:52)
 * @return boolean
 */
public boolean getIsSwitch() {
	return isSwitch;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 12:42:44)
 */
public int getState() {
    return APPStates.CONTROLLER_LIST;

}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2003 12:50:48)
 * @return java.lang.Integer
 */
public java.lang.Integer getSwitchcode() {
	return switchcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2003 12:50:48)
 * @return java.lang.Integer
 */
public String getSwitchcodeFrm() {
	return switchcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2003 12:59:28)
 * @return int
 */
public int getSwitchId() {
	return switchId;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2003 12:51:33)
 * @return java.lang.String
 */
public java.lang.String getSwitchname() {
	return switchname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2003 12:49:52)
 * @param newIsSwitch boolean
 */
public void setIsSwitch(boolean newIsSwitch) {
	isSwitch = newIsSwitch;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2003 12:50:48)
 * @param newSwitchcode java.lang.Integer
 */
public void setSwitchcode(java.lang.Integer newSwitchcode) {
	switchcode.setInteger(newSwitchcode);
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2003 12:50:48)
 * @param newSwitchcode java.lang.Integer
 */
public void setSwitchcodeFrm(String newSwitchcode) {
	switchcode.setString(newSwitchcode);
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2003 12:59:28)
 * @param newSwitchId int
 */
public void setSwitchId(int newSwitchId) {
	switchId = newSwitchId;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2003 12:51:33)
 * @param newSwitchname java.lang.String
 */
public void setSwitchname(java.lang.String newSwitchname) {
	switchname = newSwitchname;
}
}
