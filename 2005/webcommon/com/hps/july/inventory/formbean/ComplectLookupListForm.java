package com.hps.july.inventory.formbean;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.constants.Applications;
import com.hps.july.web.util.ParamsParser;
import com.hps.july.inventory.*;

/**
 * Форма выбора функционального комплекта на позиции
 */
public class ComplectLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
	private int position;
	private String positionname;
	private String posid;
public ComplectLookupListForm() {
	this.setFinderMethodName( "findPositionEquipment" );
	position = 0;
}
public static String getBeenetListString(String equstr) {
	Integer equipment = null;
	try {
		equipment = new Integer(Integer.parseInt(equstr));
	} catch(Exception e) {
	}
	
	if(equipment == null) return "";
	com.hps.july.cdbc.lib.CDBCResultSet rs = (new com.hps.july.cdbc.objects.CDBCBeenetObject()).findEquipmentBeeNets(equipment,new Integer(1));
	
	java.util.Iterator it = rs.listIterator();
	String result = "";
	while(it.hasNext()) {
		com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)it.next();
		if(ro.getColumn("beenetid").asObject() != null) {
			result += org.apache.struts.util.ResponseUtils.filter(ro.getColumn("beenetid").asString());
			if(it.hasNext()) {
				result += ", ";
			}
		}
	}
	return result;
}
public static String getBeenetListStringBR(String equstr) {
	Integer equipment = null;
	try {
		equipment = new Integer(Integer.parseInt(equstr));
	} catch(Exception e) {
	}
	
	if(equipment == null) return "";
	com.hps.july.cdbc.lib.CDBCResultSet rs = (new com.hps.july.cdbc.objects.CDBCBeenetObject()).findEquipmentBeeNets(equipment,new Integer(1));
	
	java.util.Iterator it = rs.listIterator();
	String result = "";
	while(it.hasNext()) {
		com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)it.next();
		if(ro.getColumn("beenetid").asObject() != null) {
			result += org.apache.struts.util.ResponseUtils.filter(ro.getColumn("beenetid").asString());
			if(it.hasNext()) {
				result += ", ";
				result += "<BR>";
			}
		}
	}
	return result;
}
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.persistence.EquipmentSetAccessBean";
	return "com.hps.july.cdbc.objects.CDBCEquipmentObject";
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(position), new Integer(1) };
}
public static String[] getOtv(String equstr)
{
	String[] result = { "", "" };
	Integer equipment = null;
	try {
		equipment = new Integer(Integer.parseInt(equstr));
	} catch(Exception e) {
	}
	
	if(equipment == null) return result;
	com.hps.july.cdbc.lib.CDBCResultSet rs = (new com.hps.july.cdbc.objects.CDBCComlinesObject()).findOtvEquipment(equipment);
	
	java.util.Iterator it = rs.listIterator();
	while(it.hasNext()) {
		com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)it.next();
		if(ro.getColumn("beenetid").asObject() != null) {
			result[0] += org.apache.struts.util.ResponseUtils.filter(ro.getColumn("beenetid").asString());
			if(it.hasNext()) {
				result[0] += ", ";
				result[0] += "<BR>";
			}
		}
		if(ro.getColumn("otvetka").asObject() != null) {
			if(ro.getColumn("eid").asObject() != null) {
				String eid = ro.getColumn("eid").asString();
				result[1] += getBeenetListString(eid);
			}
			result[1] += " "+org.apache.struts.util.ResponseUtils.filter(ro.getColumn("otvetka").asString());
			if(it.hasNext()) {
				result[1] += ", ";
				result[1] += "<BR>";
			}
		}
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 10:09:09)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:07:49)
 * @return int
 */
public int getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:07:49)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws java.io.IOException, ServletException
{
  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.EQSETLOOKUP );
  	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 10:09:09)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:07:49)
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:07:49)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(org.apache.struts.action.ActionErrors errors)
	throws Exception
{
	try {
		PositionAccessBean bean = new PositionAccessBean();
		bean.setInitKey_storageplace(getPosition());
		bean.refreshCopyHelper();

		setPosid("");
		if (bean.getGsmid() != null)
			setPosid("D" + bean.getGsmid() + " ");
		if (bean.getDampsid() != null)
			setPosid(getPosid() + "A" + bean.getDampsid());

		setPositionname(bean.getName());
		if ((bean.getDampsname() != null) && (bean.getDampsname().length() > 0) )
			setPositionname(getPositionname() + " / " + bean.getDampsname());
	} catch (Exception e) {
		setPosition(0);
		setPosid("");
		setPositionname("");
	}
}
}
