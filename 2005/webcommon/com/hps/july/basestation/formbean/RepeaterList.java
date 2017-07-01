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
 * Форма списка репитеров
 */
public class RepeaterList
	extends EquipmentListForm
{
	private java.lang.String stationType;
public RepeaterList()
{
	super();
	setLastVisited(true);
}
public String actionName() {
	return "ShowRepeaterList.do";
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCEquipmentObject";
//	return "com.hps.july.basestation.valueobject.RepeaterObject";
}
public java.lang.Object[] getFilterParams() {
    RegionsSelector rs = getRegionsSelector();
	try {
		return new Object[] {
			new Boolean(rs.isAllNetzones()), rs.getNetzonecodes(),
			new Boolean(rs.isAllRegions()), rs.getRegioncodes(),
			new Boolean(rs.isAllSuperregions()), rs.getSuperregioncodes(),
			getStationType(),
			getSearchBy(), getSearchString(),
			getEquipmentState(),
			getIsAdmin(), getUsername(),
			new Integer(1)
		};
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		return null;
	}
}
public java.lang.String getFinderMethodName() {
	return "listRepeaters";
}
public int getState() {
	return APPStates.REPEATER_LIST;
}
public java.lang.String getStationType() {
	return stationType == null ? BaseStationObject.TYPE_SEARCH_GSM : stationType;
}
public void setStationType(java.lang.String newStationType) {
	stationType = newStationType;
}
}
