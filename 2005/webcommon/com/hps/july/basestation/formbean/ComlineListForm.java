package com.hps.july.basestation.formbean;

import com.hps.july.siteinfo.valueobject.*;
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
 * Форма списка линий связи
 */
public class ComlineListForm extends EquipmentListForm {
    public final static String SEARCHBY_GSMNUMBER="gsmnumber";
    public final static String SEARCHBY_DAMPSNUMBER="dampsnumber";
    public final static String SEARCHBY_HOPSNAME = "hopsname";
    public final static String SEARCHBY_BEENETID = "beenet";

    private String comlinestate;
public ComlineListForm() {
	super();
	setLastVisited(true);
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 16:22:59)
 * @return java.lang.String
 */
public String actionName() {
	return "ShowComlineList.do";
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCComlinesObject";
//	return "com.hps.july.basestation.valueobject.ComlineObject";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComlinestate() {
	return comlinestate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    try {
		return new Object[] {
			new Boolean(getRegionsSelector().isAllNetzones()),
			getRegionsSelector().getNetzonecodes(),
			new Boolean(getRegionsSelector().isAllRegions()),
			getRegionsSelector().getRegioncodes(),
			new Boolean(getRegionsSelector().isAllSuperregions()),
			getRegionsSelector().getSuperregioncodes(),
			getSearchBy(),
			getSearchString(),
			(comlinestate != null)?comlinestate:"",
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
	return "findComlineList";
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 18:32:37)
 * @return int
 */
public int getState() {
	return APPStates.ComlineListForm;
}
/**
 * 
 * @param newComlinestate java.lang.String
 */
public void setComlinestate(java.lang.String newComlinestate) {
	comlinestate = newComlinestate;
}
}
