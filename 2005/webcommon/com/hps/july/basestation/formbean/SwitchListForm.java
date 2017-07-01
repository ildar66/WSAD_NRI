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
 * Форма списка коммутаторов
 */
public class SwitchListForm
	extends EquipmentListForm
{
public SwitchListForm() {
	super();
	setLastVisited(true);
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2003 16:24:06)
 * @return java.lang.String
 */
public String actionName() {
	return "ShowSwitchList.do";
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 18:34:04)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.basestation.valueobject.SwitchObject";
}
public java.lang.Object[] getFilterParams() {
    RegionsSelector rs = getRegionsSelector();
    try {
		return new Object[] {
			new Boolean(rs.isAllNetzones()), rs.getNetzonecodes(),
			new Boolean(rs.isAllRegions()), rs.getRegioncodes(),
			new Boolean(rs.isAllSuperregions()), rs.getSuperregioncodes(),
			getSearchBy(),
			getSearchString(),
			getEquipmentState(),
			"2", // getPlanstate(),
			getIsAdmin(),
			getUsername()
		};
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        //DebugSupport.printlnTest("request="+request);
        return null;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findSwitchList";
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 18:32:37)
 * @return int
 */
public int getState() {
	return APPStates.SwitchListForm;
}
}
