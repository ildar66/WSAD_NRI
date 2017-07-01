package com.hps.july.inventory.formbean;

import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;

/**
 * Форма ввода и редактирования серии штрих кодов
 */
public class BarForm
	extends com.hps.july.web.util.EditForm
{
	private int serid;
	private java.lang.String serprefix;
	private java.lang.String serstart;
	private java.lang.String serend;
	private StringAndSqlDateProperty serdate;
	private int wrkcode;
	private java.lang.String wrkname;
	private java.lang.String sercount;
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:48:56)
 */
public BarForm() {
	serdate = new StringAndSqlDateProperty();
	serprefix = "";
	serstart = "";
	serend = "";
	serid = 0;
	wrkcode = 0;
	wrkname = "";
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {
		if ("Edit".equalsIgnoreCase(getAction()))
			throw new UpdateValidationException("error.invalid.ser.noupdate");
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) 
  throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setSerid(keyGen.getNextKey("tables.invnumbers"));
	setSerdate(new java.sql.Date(new java.util.Date().getTime()));
    InventoryNumbersAccessBean bean = new InventoryNumbersAccessBean(getSerid(),
	    getSerdate(), getSerend(), getSerprefix(), getSerstart(), new Integer(getWrkcode()) );  
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	int startnum = 0;
	int endnum = 0;
	
	StringAndIntegerProperty anum = new StringAndIntegerProperty();
	anum.setString(getSerstart());
	startnum = anum.getInteger().intValue();
	
	anum.setString(getSerend());
	endnum = anum.getInteger().intValue();
	
	setSercount(new Integer(endnum-startnum).toString());
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	InventoryNumbersAccessBean bean = new InventoryNumbersAccessBean();
	bean.setInitKey_serid( getSerid() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2002 12:21:47)
 * @return java.lang.String
 */
public java.lang.String getSercount() {
	return sercount;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:47:47)
 * @return java.sql.Date
 */
public java.sql.Date getSerdate() {
	return serdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:48:04)
 * @return java.lang.String
 */
public java.lang.String getSerdateFrm() {
	return serdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:44:14)
 * @return java.lang.String
 */
public java.lang.String getSerend() {
	return serend;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:43:14)
 * @return int
 */
public int getSerid() {
	return serid;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:43:38)
 * @return java.lang.String
 */
public java.lang.String getSerprefix() {
	return serprefix;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:43:56)
 * @return java.lang.String
 */
public java.lang.String getSerstart() {
	return serstart;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.EDITBAR;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 12:53:09)
 * @return int
 */
public int getWrkcode() {
	return wrkcode;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 12:53:27)
 * @return java.lang.String
 */
public java.lang.String getWrkname() {
	return wrkname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	try {
		//String role = request.getUserPrincipal().getName();
		String role = "dima";  // Debug only !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		PeopleAccessBean bean = (new OperatorAccessBean()).findByLogin( role ).getMan();
		// Check if we have workers - select first worker
		WorkerAccessBean wrk = new WorkerAccessBean();
		Enumeration en = wrk.findWorkersByMan(new PeopleKey(bean.getMan()));
		if (en.hasMoreElements()) {
			WorkerAccessBean wrkb = (WorkerAccessBean)javax.rmi.PortableRemoteObject.narrow(en.nextElement(), WorkerAccessBean.class);
			setWrkcode(wrkb.getWorker());
			setWrkname(wrkb.getMan().getFullName());
		} else {
			setWrkcode(0);
			setWrkname("");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	setSerdate(new java.sql.Date(new java.util.Date().getTime()));
	setSercount("100");
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2002 12:21:47)
 * @param newSercount java.lang.String
 */
public void setSercount(java.lang.String newSercount) {
	sercount = newSercount;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:47:47)
 * @param newSerdate java.sql.Date
 */
public void setSerdate(java.sql.Date newSerdate) {
	serdate.setSqlDate(newSerdate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:48:04)
 * @param newSerdateFrm java.lang.String
 */
public void setSerdateFrm(java.lang.String newSerdateFrm) {
	serdate.setString(newSerdateFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:44:14)
 * @param newSerend java.lang.String
 */
public void setSerend(java.lang.String newSerend) {
	serend = newSerend;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:43:14)
 * @param newSerid int
 */
public void setSerid(int newSerid) {
	serid = newSerid;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:43:38)
 * @param newSerprefix java.lang.String
 */
public void setSerprefix(java.lang.String newSerprefix) {
	serprefix = newSerprefix;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 11:43:56)
 * @param newSerstart java.lang.String
 */
public void setSerstart(java.lang.String newSerstart) {
	serstart = newSerstart;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 12:53:27)
 * @param newWrkname java.lang.String
 */
public void setSerworker(WorkerAccessBean newSerworker) throws Exception {
	if (newSerworker != null) {
		setWrkcode(newSerworker.getWorker());
		setWrkname(newSerworker.getMan().getFullName());
	} else {
		setWrkcode(0);
		setWrkname("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 12:53:09)
 * @param newWrkcode int
 */
public void setWrkcode(int newWrkcode) {
	wrkcode = newWrkcode;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 12:53:27)
 * @param newWrkname java.lang.String
 */
public void setWrkname(java.lang.String newWrkname) {
	wrkname = newWrkname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	int startnum = 0;
	int endnum = 0;
	
	if ((getSerprefix() == null) || (getSerprefix().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.ser.fser"));
	else if (getSerprefix().length() != 3)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ser.fser"));
	  
	StringAndIntegerProperty anum = new StringAndIntegerProperty();
	anum.setString(getSerstart());
	if (anum.isEmpty())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.ser.fstart"));
	else if (!anum.isOk() || anum.getString().length() > 8)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ser.fstart"));
	else
		startnum = anum.getInteger().intValue();
	
	anum.setString(getSerend());
	if (anum.isEmpty())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.ser.fend"));
	else if (!anum.isOk() || anum.getString().length() > 8)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ser.fend"));
	else
		endnum = anum.getInteger().intValue();

	if (startnum > endnum)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ser.fsize"));
	   
	if (errors.empty()) {
		// Update start/end to be 8 numbers
		int i;
		String sstart = "000000000" + getSerstart();
		i = sstart.length()-8;
		setSerstart(sstart.substring(i));
		String send = "000000000" + getSerend();
		i = send.length()-8;
		setSerend(send.substring(i));

		// Check for intersecting intervals

		InventoryNumbersAccessBean bean = new InventoryNumbersAccessBean();
		Enumeration en = bean.findOrderBySerstartAsc();
		while (en.hasMoreElements()) {
			InventoryNumbersAccessBean abean = (InventoryNumbersAccessBean)en.nextElement();
			// Check if any end lies within our interval or any our end lies within existing interval
			if (abean.getSerprefix().compareTo(getSerprefix()) == 0)
				if ( (abean.getSerstart().compareTo(getSerstart()) >= 0 && abean.getSerstart().compareTo(getSerend()) <= 0) ||
					 (abean.getSerend().compareTo(getSerstart()) >= 0 && abean.getSerend().compareTo(getSerend()) <= 0) ||
					 (getSerstart().compareTo(abean.getSerstart()) >= 0 && getSerstart().compareTo(abean.getSerend()) <= 0) ||
					 (getSerend().compareTo(abean.getSerstart()) >= 0 && getSerend().compareTo(abean.getSerend()) <= 0) ) {
						 
				  		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ser.intersect"));
				  		break;
				}
		}

		// Check for presence in cards
		StorageCardAccessBean crd = new StorageCardAccessBean();
		Enumeration sers = crd.findBySerie(getSerprefix() + getSerstart(), getSerprefix() + getSerend());
		if (sers.hasMoreElements())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ser.exists"));
		sers = crd.findByPartie(getSerprefix() + getSerstart(), getSerprefix() + getSerend());
		if (sers.hasMoreElements())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ser.pexists"));
	}
	
	if (!errors.empty())
		throw new ValidationException();

}
}
