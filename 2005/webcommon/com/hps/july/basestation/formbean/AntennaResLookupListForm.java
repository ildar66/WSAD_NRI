package com.hps.july.basestation.formbean;

import java.util.Vector;
import java.util.Enumeration;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма выбора оборудования антенны
 */
public class AntennaResLookupListForm
	extends BrowseForm
{
	private static int[] RANGES = { 800, 900, 1800, 2000 };
	private java.lang.String polar = "*";
	private java.lang.String show = "Y";
	private java.lang.String searchby = "n";
	private java.lang.String searchstring = "*";
	private Boolean[] ranges;
	private Boolean allranges;

	private StringAndInteger resourcetype=new StringAndInteger();
	private StringAndInteger resourcesubtype=new StringAndInteger();
	private String resourcetypename;
	private String resourcesubtypename;
	private Boolean isAllResourcetypes=Boolean.TRUE;
	private Boolean isAllResourcesubtypes=Boolean.TRUE;
	public AntennaResLookupListForm() {
		super();
		allranges = Boolean.TRUE;
		ranges = new Boolean[4];
		for(int i = 0; i < 4; i++) {
			ranges[i] = Boolean.FALSE;
		}
		polar = "*";
		show = "Y";
		searchby = "0";
		searchstring = "";
		setFinderMethodName("findResourceByBrowse1");
	}
public Integer[] createRangesFilter() {
	int i;
	Integer[] rng;
System.out.println("CreateRanges Filter");
	if(!allranges.booleanValue()) {
		Vector v = new Vector(4);
		for(i = 0; i < 4; i++) {
			if(ranges[i].booleanValue()) {
System.out.println("ADD RANGE:"+RANGES[i]);
				v.add(new Integer(RANGES[i]));
			}
		}
		rng = new Integer[v.size()];
		for(i = 0; i < rng.length; i++) {
			rng[i] = (Integer)v.get(i);
		}
	} else {
		rng = new Integer[4];
		for(i = 0; i < 4; i++ ) {
System.out.println("ADD RANGE:"+RANGES[i]);
			rng[i] = new Integer(RANGES[i]);
		}
	}
	return rng;
}
public java.lang.Boolean getAllranges() {
	return allranges;
}
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList(2);
		roles.add("administrator");
		roles.add("dictResAdmin");
		return roles;
	}
	public java.lang.Object[] getFilterParams() {
System.out.println("GetFilter Params");
		Boolean ismodel = ("1".equals(searchby))?Boolean.TRUE:Boolean.FALSE;
		Boolean ismanu = ("2".equals(searchby))?Boolean.TRUE:Boolean.FALSE;
		if(searchstring == null) {
			searchstring = "";
		}
		Integer[] ra = createRangesFilter();
		if(ra != null) {
			for(int i = 0; i < ra.length; i++) {
System.out.println("RANGES["+i+"]:"+ra[i]);
			}
		} else {
System.out.println("RANGES IS NULL.");
		}
		return new Object[] {
			new Boolean(!getIsAllResourcetypes().booleanValue()), getResourcetype(),
			new Boolean(!getIsAllResourcesubtypes().booleanValue()), getResourcesubtype(),
			ra, polar, show,
			ismodel, searchstring,
			ismanu, searchstring,
			new Integer(1)
		};
	}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2003 22:56:06)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAllResourcesubtypes() {
	return isAllResourcesubtypes;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2003 22:56:06)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAllResourcetypes() {
	return isAllResourcetypes;
}
public java.lang.String getPolar() {
	return polar;
}
public Enumeration getPolars() {
	Vector v = new Vector();
	v.add("*"); v.add("*");
	v.add("V"); v.add("Вертикальная");
	v.add("C"); v.add("Кросс");
	return v.elements();
}
public java.lang.Boolean getRanges(int index) {
	return ranges[index];
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @return java.lang.String
 */
public Integer getResourcesubtype() {
	return resourcesubtype.getInteger()==null?new Integer(0):resourcesubtype.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @return java.lang.String
 */
public java.lang.String getResourcesubtypeFrm() {
	return resourcesubtype.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @return java.lang.String
 */
public java.lang.String getResourcesubtypename() {
	return resourcesubtypename!=null?resourcesubtypename:"";
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @return java.lang.String
 */
public Integer getResourcetype() {
	return resourcetype.getInteger()==null?new Integer(0):resourcetype.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @return java.lang.String
 */
public java.lang.String getResourcetypeFrm() {
	return resourcetype.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @return java.lang.String
 */
public java.lang.String getResourcetypename() {
	return resourcetypename!=null?resourcetypename:"";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSearchby() {
	return searchby;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSearchstring() {
	return searchstring;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getShow() {
	return show;
}
/**
 * 
 * @param newAllranges java.lang.Boolean
 */
public void setAllranges(java.lang.Boolean newAllranges) {
	allranges = newAllranges;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2003 22:56:06)
 * @param newIsAllResourcesubtypes java.lang.Boolean
 */
public void setIsAllResourcesubtypes(java.lang.Boolean newIsAllResourcesubtypes) {
	isAllResourcesubtypes = newIsAllResourcesubtypes;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2003 22:56:06)
 * @param newIsAllResourcetypes java.lang.Boolean
 */
public void setIsAllResourcetypes(java.lang.Boolean newIsAllResourcetypes) {
	isAllResourcetypes = newIsAllResourcetypes;
}
/**
 * 
 * @param newPolar java.lang.String
 */
public void setPolar(java.lang.String newPolar) {
	polar = newPolar;
}
public void setRanges(int index,java.lang.Boolean newBoolean) {
	ranges[index] = newBoolean;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @param newResourcesubtypename java.lang.String
 */
public void setResourcesubtypeFrm(java.lang.String val)  {
	resourcesubtype.setString(val);
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @param newResourcesubtypename java.lang.String
 */
public void setResourcesubtypename(java.lang.String newResourcesubtypename) {
	resourcesubtypename = newResourcesubtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @param newResourcesubtypename java.lang.String
 */
public void setResourcetype(Integer val)  {
	resourcetype.setInteger(val);
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @param newResourcesubtypename java.lang.String
 */
public void setResourcetypeFrm(java.lang.String val)  {
	resourcetype.setString(val);
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 14:43:23)
 * @param newResourcetypename java.lang.String
 */
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
/**
 * 
 * @param newSearchby java.lang.String
 */
public void setSearchby(java.lang.String newSearchby) {
	searchby = newSearchby;
}
/**
 * 
 * @param newSearchstring java.lang.String
 */
public void setSearchstring(java.lang.String newSearchstring) {
	searchstring = newSearchstring;
}
/**
 * 
 * @param newShow java.lang.String
 */
public void setShow(java.lang.String newShow) {
	show = newShow;
}
}
