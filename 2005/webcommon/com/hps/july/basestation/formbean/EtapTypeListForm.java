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

import com.hps.july.basestation.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Базовая форма списка типов этапов получения частотного разрешения
 */
public class EtapTypeListForm
	extends com.hps.july.web.util.BrowseForm
{
	private boolean all;
	private String etapname;
public EtapTypeListForm() {
	super();
	all = true;
	setLastVisited(true);
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCSitedocsObject";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEtapname() {
	return etapname;
}
public Object[] getFilterParams() {
	return new Object[] {
		new Boolean(!all), etapname != null ? etapname : "",
		getOrder()
	};
}
public java.lang.String getFinderMethodName() {
	return "findEtapTypes";
}
public Integer getOrder() {
	return new Integer(1);
}
public int getState() {
	return com.hps.july.basestation.APPStates.FREQLICENCE_LIST;
}
/**
 * 
 * @return boolean
 */
public boolean isAll() {
	return all;
}
/**
 * 
 * @param newAll boolean
 */
public void setAll(boolean newAll) {
	all = newAll;
}
/**
 * 
 * @param newEtapname java.lang.String
 */
public void setEtapname(java.lang.String newEtapname) {
	etapname = newEtapname;
}
public void validateValues(org.apache.struts.action.ActionErrors errors)
	throws Exception
{
	if (!errors.empty())
		throw new ValidationException();
}
}
