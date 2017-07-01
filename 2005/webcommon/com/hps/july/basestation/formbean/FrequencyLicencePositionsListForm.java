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
 * Форма списка частотных разрешений
 */
public class FrequencyLicencePositionsListForm
	extends com.hps.july.web.util.BrowseForm
{
	private Integer freqpermid;
	private String filenumber;
	private Integer positioncount;
    private String filter;

    private Boolean selectall;
    private int[] selectedpos;

    private int order = 5;

    private String orderno_val;
    private String haveplan_val;
    private String addaction;
    private String showOrderLetter;
public FrequencyLicencePositionsListForm() {
	super();
	filter = "*";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAddaction() {
	return addaction;
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCSitedocsObject";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFilenumber() {
	return filenumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFilter() {
	return filter;
}
public Object[] getFilterParams() {
	return new Object[] {
		(freqpermid != null)?freqpermid:new Integer(-1),
		(filter != null)?filter:"",
		getOrder()
	};
}
public java.lang.String getFinderMethodName() {
	return "findFrequencyLicencePositions";
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getFreqpermid() {
	return freqpermid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHaveplan_val() {
	return haveplan_val;
}
public Boolean getIsAdmin() {
	return Boolean.TRUE;
}
public Integer getOrder() {
	try {
		order = Integer.parseInt(super.getFinderMethodName());
		return new Integer(order);
	} catch(Exception e) {
		return new Integer(order);
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrderno_val() {
	return orderno_val;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPositioncount() {
	return positioncount;
}
public String getResourcesList(Object freqpermid) {
TimeCounter tc = new TimeCounter("Resources List");
	String r = "";
	if(freqpermid != null && freqpermid instanceof Integer) {
		CDBCResultSet rs = (new CDBCSitedocsObject()).findFrequencyLicenceEquipment((Integer)freqpermid);
		Iterator it = rs.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			r += ro.getColumn("model").asString();
			if(it.hasNext()) {
				r += ", ";
			}
		}
	}
tc.finish(" finish ");
	return r;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSelectall() {
	return selectall;
}
/**
 * 
 * @return int[]
 */
public int[] getSelectedpos() {
	return selectedpos;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getShowOrderLetter() {
	return showOrderLetter;
}
public int getState() {
	return com.hps.july.basestation.APPStates.FREQLICENCE_LIST;
}
public void processHaveplan()
	throws Exception
{
	System.out.println("SET HAVEPLAN '"+haveplan_val+"'");
	if(selectedpos != null) {
		for(int i = 0; i < selectedpos.length; i++) {
			System.out.println("SP["+i+"]:"+selectedpos[i]);
		}
		CDBCSitedocsObject sdo = new CDBCSitedocsObject();
		sdo.updateFrequencyLicencePositionsHaveplan(getHaveplan_val(),selectedpos);
	}
	System.out.println();
}
public void processOrderno()
	throws Exception
{
	System.out.println("SET ORDER NO '"+orderno_val+"'");
	if(selectedpos != null) {
		for(int i = 0; i < selectedpos.length; i++) {
			System.out.println("SP["+i+"]:"+selectedpos[i]);
		}
		CDBCSitedocsObject sdo = new CDBCSitedocsObject();
		sdo.updateFrequencyLicencePositionsOrderno(getOrderno_val(),selectedpos);
	}
	System.out.println();
}
/**
 * 
 * @param newAddaction java.lang.String
 */
public void setAddaction(java.lang.String newAddaction) {
	addaction = newAddaction;
}
/**
 * 
 * @param newFilenumber java.lang.String
 */
public void setFilenumber(java.lang.String newFilenumber) {
	filenumber = newFilenumber;
}
/**
 * 
 * @param newFilter java.lang.String
 */
public void setFilter(java.lang.String newFilter) {
	filter = newFilter;
}
/**
 * 
 * @param newFreqpermid java.lang.Integer
 */
public void setFreqpermid(java.lang.Integer newFreqpermid) {
	freqpermid = newFreqpermid;
}
/**
 * 
 * @param newHaveplan_val java.lang.String
 */
public void setHaveplan_val(java.lang.String newHaveplan_val) {
	haveplan_val = newHaveplan_val;
}
/**
 * 
 * @param newOrderno_val java.lang.String
 */
public void setOrderno_val(java.lang.String newOrderno_val) {
	orderno_val = newOrderno_val;
}
/**
 * 
 * @param newPositioncount java.lang.Integer
 */
public void setPositioncount(java.lang.Integer newPositioncount) {
	positioncount = newPositioncount;
}
/**
 * 
 * @param newSelectall java.lang.Boolean
 */
public void setSelectall(java.lang.Boolean newSelectall) {
	selectall = newSelectall;
}
/**
 * 
 * @param newSelectedpos int[]
 */
public void setSelectedpos(int[] newSelectedpos) {
	selectedpos = newSelectedpos;
}
/**
 * 
 * @param newShowOrderLetter java.lang.String
 */
public void setShowOrderLetter(java.lang.String newShowOrderLetter) {
	showOrderLetter = newShowOrderLetter;
}
public void validateValues(org.apache.struts.action.ActionErrors errors)
	throws Exception
{
	if(freqpermid != null) {
		CDBCSitedocsObject sdo = new CDBCSitedocsObject();
		com.hps.july.persistence2.FreqPermissionAccessBean fpa = new com.hps.july.persistence2.FreqPermissionAccessBean();
		fpa.setInitKey_freqpermid(freqpermid.intValue());
		fpa.refreshCopyHelper();
		filenumber = String.valueOf(fpa.getFilenumber());
		positioncount = new Integer(sdo.findFrequencyLicencePositionsCount(freqpermid,filter));
	}

	if(addaction != null && !"".equals(addaction.trim())) {
		if("O".equals(addaction)) {
			// check orderno here
			processOrderno();
		} else if("H".equals(addaction)) {
			// check haveplan
			String a = getHaveplan_val();
			if(!"".equals(a) && !"A".equals(a) && !"B".equals(a) && !"C".equals(a) && !"D".equals(a)) {
				// add error
			} else {
				processHaveplan();
			}
		}
	}
	

	if (!errors.empty())
		throw new ValidationException();
}
}
