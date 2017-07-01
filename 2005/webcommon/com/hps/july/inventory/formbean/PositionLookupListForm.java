package com.hps.july.inventory.formbean;

import com.hps.july.basestation.valueobject.*;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.siteinfo.valueobject.*;
 
/**
 * Форма выбора позиции
 */
public class PositionLookupListForm
	extends com.hps.july.siteinfo.formbean.PositionListForm
{
/**
 * PositionLookupListForm constructor comment.
 */
public PositionLookupListForm() {
	super();
	RegionsSelector s = getRegionsSelector();
	s.setAllSuperregions(true);
	s.setAllRegions(true);
	s.setAllNetzones(true);
	setLastVisited(false);
//	setPlanstate("2");
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAddRoles() {
	java.util.ArrayList roles = super.getAddRoles();
	roles.add("AllAuthenticated");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = super.getEditRoles();
	roles.add("AllAuthenticated");
	return roles;
}
public java.lang.String getFinderMethodName() {
	return "findPositionsLookup";
}
}
