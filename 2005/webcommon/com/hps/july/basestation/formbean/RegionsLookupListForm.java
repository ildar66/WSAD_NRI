package com.hps.july.basestation.formbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import javax.servlet.http.*;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import org.apache.struts.util.*;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Форма (лукап) выбора регионов для решения ГКРЧ с множественным выбором.
 */
public class RegionsLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
	private boolean allSuperregions;
	private int superregion = 1;
	
	private String username;
	private boolean admin;

	private Integer order = new Integer(4);
public RegionsLookupListForm() {
	super();
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCRegionsObject";
}
public Object[] getFilterParams() {
//findRegions(Boolean useSuperregions, Integer[] superregions, String username, boolean admin)
	return new Object[] {
		new Boolean(!allSuperregions),
		new Integer(getSuperregion()),
		getUsername(),
		new Boolean(isAdmin())
	};
}
public java.lang.String getFinderMethodName() {
	return "findRegionsLookup";
}
public Boolean getIsAdmin() {
	return Boolean.TRUE;
}
public Integer getOrder() {
	try {
		Integer o = new Integer(Integer.parseInt(super.getFinderMethodName()));
		order = o;
	} catch(Exception e) {
	}
	return order;
}
public int getState() {
	return com.hps.july.basestation.APPStates.REGIONS_LOOKUP;
}
public int getSuperregion() {
	return superregion;
}
public Enumeration getSuperRegions()
{
	try {
	    SuperRegionAccessBeanTable table = new SuperRegionAccessBeanTable();
	    table.setSuperRegionAccessBean(
	        new SuperRegionAccessBean().findAllOrderByCodeAsc());

	    if (superregion == 0) {
		    if(table.numberOfRows() > 0) {
		        superregion = table.getSuperRegionAccessBean(0).getSupregid();
		    }
	    }

	    return table.rows();
	} catch(Exception e) {
		Vector v = new Vector();
		return v.elements();
	}
}
public String getUsername() {
	return username;
}
public boolean isAdmin() {
	return admin;
}
public boolean isAllSuperregions() {
	return allSuperregions;
}
public void setAllSuperregions(boolean newAllSuperregions) {
	allSuperregions = newAllSuperregions;
}
public void setRequestData(HttpServletRequest request)
{
	admin = request.isUserInRole("administrator");
	username = request.getRemoteUser();
}
public void setSuperregion(int newSuperregion) {
	superregion = newSuperregion;
}
public void validateValues(org.apache.struts.action.ActionErrors errors)
	throws Exception
{
	if (!errors.empty())
		throw new ValidationException();
}
}
