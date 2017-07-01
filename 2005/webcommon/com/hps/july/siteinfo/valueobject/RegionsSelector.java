package com.hps.july.siteinfo.valueobject;

import com.hps.july.cdbc.objects.CDBCRegionsObject;
import org.apache.struts.util.*;

/**
 * Класс-контейнер содержащий модели визуальных элементов
 * используемых в фильтре по регионам.
 *
 * Используется в формах как проперть только для чтения.
 * Вместе с включаемой JSP regionsselector.jsp позволяет включать в форму фильтр по регионам
 */
public class RegionsSelector {
	private boolean allSuperregions;
	private boolean allRegions;
	private boolean allNetzones;
	private Integer[] superregioncodes;
	private Integer[] regioncodes;
	private Integer[] netzonecodes;
public RegionsSelector() {
	super();
	netzonecodes = null; //new Integer[] { new Integer(1) };
	regioncodes = null; //new Integer[] { new Integer(1) };
	superregioncodes = null; //new Integer[] { new Integer(1) };
}
public RegionsSelector(String username, boolean admin) {
	this();
}
public static RegionsSelector findRegionsSelector(javax.servlet.jsp.PageContext pageContext)
	throws javax.servlet.jsp.JspException
{
	String regionsSelectorProperty = "regionsSelector";
	String regionsSelectorName = org.apache.struts.taglib.html.Constants.BEAN_KEY;
	Object o = pageContext.findAttribute("regionsSelectorProperty");
	if(o != null) {
		regionsSelectorProperty = String.valueOf(o);
	} 
	o = pageContext.findAttribute("regionsSelectorName");
	if(o != null) {
		regionsSelectorName = String.valueOf(o);
	}
	RegionsSelector rs = (RegionsSelector)RequestUtils.lookup(pageContext, regionsSelectorName, regionsSelectorProperty, null);
	return rs;
}
public java.lang.Integer[] getNetzonecodes() {
	if(netzonecodes != null) {
		return netzonecodes;
	} else {
		return new Integer[] {};
	}
}
public java.lang.Integer[] getRegioncodes() {
	if(regioncodes != null) {
		return regioncodes;
	} else {
		return new Integer[] {};
	}
}
/**
 * 
 * @return java.lang.Integer[]
 */
public java.lang.Integer[] getSuperregioncodes() {
	if(superregioncodes != null) {
		return superregioncodes;
	} else {
		return new Integer[] {};
	}
}
/**
 * 
 * @return boolean
 */
public boolean isAllNetzones() {
	return allNetzones;
}
/**
 * 
 * @return boolean
 */
public boolean isAllRegions() {
	return allRegions;
}
/**
 * 
 * @return boolean
 */
public boolean isAllSuperregions() {
	return allSuperregions;
}
/**
 * 
 * @param newAllNetzones boolean
 */
public void setAllNetzones(boolean newAllNetzones) {
	allNetzones = newAllNetzones;
}
/**
 * 
 * @param newAllRegions boolean
 */
public void setAllRegions(boolean newAllRegions) {
	allRegions = newAllRegions;
}
/**
 * 
 * @param newAllSuperregions boolean
 */
public void setAllSuperregions(boolean newAllSuperregions) {
	allSuperregions = newAllSuperregions;
}
/**
 * 
 * @param newNetzonecodes java.lang.Integer[]
 */
public void setNetzonecodes(java.lang.Integer[] newNetzonecodes) {
	netzonecodes = newNetzonecodes;
}
/**
 * 
 * @param newRegioncodes java.lang.Integer[]
 */
public void setRegioncodes(java.lang.Integer[] newRegioncodes) {
	regioncodes = newRegioncodes;
}
/**
 * 
 * @param newSuperregioncodes java.lang.Integer[]
 */
public void setSuperregioncodes(java.lang.Integer[] newSuperregioncodes) {
	superregioncodes = newSuperregioncodes;
}
}
