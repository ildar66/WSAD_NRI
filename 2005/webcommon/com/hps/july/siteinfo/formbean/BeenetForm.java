package com.hps.july.siteinfo.formbean;

import com.hps.july.siteinfo.valueobject.BeenetCategoryVO;
import com.hps.july.persistence2.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма редактирвоания номера BeeNet и включения оборудования
 */
public class BeenetForm 
	extends com.hps.july.web.util.EditForm 
{
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;

	private String beenetid;
	private StringAndIntegerProperty categid = new StringAndIntegerProperty();

	private int[] equipment;
public BeenetForm() {
}
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBeenetid() {
	return beenetid;
}
public Integer getCategid() {
	return categid.getInteger();
}
public Iterator getCategories() {
	CDBCResultSet rs = (new CDBCBeenetObject()).findBeeNetCategories();
	ListIterator lit = rs.listIterator();
	LinkedList a = new LinkedList();
	while(lit.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)lit.next();
		Object o = ro.getColumn("categid").asObject();
		int categid = 0;
		if(o != null && o instanceof Number) {
			a.add(new BeenetCategoryVO(((Number)o).intValue(),ro.getColumn("categname").asString()));
		}
	}
	return a.iterator();
}
public int[] getEquArray() {
	if(equipment == null) {
//		System.out.println("EQUIPM[] is null");
		return null;
	} else {
		ArrayList l = new ArrayList();
		for(int i = 0; i < equipment.length; i++) {
			if(equipment[i] > 0) {
				l.add(new Integer(equipment[i]));
			}
//			System.out.println("EQUIPM["+i+"] = "+equipment[i]);
		}
		int[] r = new int[l.size()];
		for(int i = 0; i < l.size(); i++) {
			r[i] = ((Integer)l.get(i)).intValue();
//			System.out.println("EQUR["+i+"] = "+r[i]);
		}
		
		return r;
	}
}
public int[] getEquipment() {
	return equipment;
}
public Iterator getEquipmentList() {
	CDBCResultSet rs = (new CDBCEquipmentObject()).findPositionComEquipment(new Integer(storageplace),new Integer(1));
	return rs.listIterator();
}
public static String getOtherBeenets(String equ, String beenet) {
	try {
		return (new CDBCBeenetObject()).findOtherBeenetsString(new Integer(Integer.parseInt(equ)),beenet);
	} catch(Exception e) {
		return "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 11:57:51)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 11:57:37)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
public int getState() {
	return com.hps.july.siteinfo.APPStates.EDITBEENET;
}
public int getStorageplace() {
	return storageplace;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	try {
		PositionAccessBean pos = new PositionAccessBean();
		pos.setInitKey_storageplace(storageplace);
		pos.refreshCopyHelper();
		posname = com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(pos);
	} catch(Exception e) {
		e.printStackTrace(System.out);
		posname = "? ["+storageplace+"]";
	}
}
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	BeenetObjectAccessBean bo = new BeenetObjectAccessBean();
	bo.setInitKey_beenetid(beenetid);
	bo.refreshCopyHelper();
	categid.setInteger(new Integer(bo.getCategid()));

	storageplace = bo.getPosition();
	PositionAccessBean pos = new PositionAccessBean();
	pos.setInitKey_storageplace(storageplace);
	pos.refreshCopyHelper();
	posname = com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(pos);

	// Загрузка связей с оборудованием
	try {
		ArrayList links = new ArrayList();
		Enumeration en = (new Beenet2EquipmentAccessBean()).findByBeenetid(beenetid);
		Beenet2EquipmentAccessBean b = null;
		while(en.hasMoreElements()) {
			b = (Beenet2EquipmentAccessBean)en.nextElement();
			links.add(new Integer(b.getEquipment()));
		}
		equipment = new int[links.size()];
System.out.println("EQU2BEENET:"+links.size());
		for(int i=0; i < links.size(); i++) {
			equipment[i] = ((Integer)links.get(i)).intValue();
System.out.println("EQU2BEENET["+i+"]:"+equipment[i]);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	try {
		BeenetFacadeAccessBean bf = new BeenetFacadeAccessBean();
		bf.deleteBeenet(beenetid);
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.beenet.cantdelete");
	}

	return null;
}
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	try {
		BeenetFacadeAccessBean bf = new BeenetFacadeAccessBean();
		bf.createBeenet(beenetid, categid.getInteger().intValue(), storageplace, getEquArray());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.beenet.cantcreate");
	}

	return null;
}
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	try {
		BeenetFacadeAccessBean bf = new BeenetFacadeAccessBean();
		bf.updateBeenet(beenetid, categid.getInteger().intValue(), getEquArray());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.beenet.cantupdate");
	}

	return null;
}
/**
 * 
 * @param newBeenetid java.lang.String
 */
public void setBeenetid(java.lang.String newBeenetid) {
	beenetid = newBeenetid;
}
public void setCategid(Integer newCategid) {
	categid.setInteger(newCategid);
}
public void setEquipment(int[] newequ) {
	equipment = newequ;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 11:57:51)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 11:57:37)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if(beenetid == null || "".equals(beenetid)) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.beenet.beenetid.empty"));
	} else if(beenetid.length() > 8) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.beenet.beenetid.length"));
	} else {
		if("Add".equals(getAction())) {
			try {
				BeenetObjectAccessBean bo = new BeenetObjectAccessBean();
				bo.setInitKey_beenetid(beenetid);
				bo.refreshCopyHelper();
				errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.beenet.duplicate"));
			} catch(Exception e) {
			}
		}
	}

	if(categid.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.beenet.categid.empty"));
	} else if(!categid.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.beenet.categid.invalid"));
	} else {
		try {
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.beenet.categid.absent"));
		}
	}
	
	try {
		PositionAccessBean pos = new PositionAccessBean();
		pos.setInitKey_storageplace(storageplace);
		pos.refreshCopyHelper();
		posname = com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(pos);
	} catch(Exception e) {
		e.printStackTrace(System.out);
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.beenet.position"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
