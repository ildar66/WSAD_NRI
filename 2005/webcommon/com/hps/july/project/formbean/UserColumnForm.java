package com.hps.july.project.formbean;

import org.apache.struts.action.ActionErrors;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.ValidationException;
import com.hps.july.project.*;
import com.hps.july.project.valueobject.*;
import java.util.*;

/**
 * ‘орма редактировани€ пользовательской колонки.
 * Creation date: (09.06.2003 10:15:43)
 * @author: Dmitry Dneprov
 */
public class UserColumnForm extends com.hps.july.web.util.EditForm {
	private int prjtypecode;
	private java.lang.String prjtypename;
	private int divcode;
	private java.lang.String divname;
	private java.lang.String colname;
	private int divcolid;
	private int aftercol;
	private Vector protoactions;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception 
	{
        javax.naming.Context ctx = new  javax.naming.InitialContext();
        javax.transaction.UserTransaction t1 =
            (javax.transaction.UserTransaction) ctx.lookup("jta/usertransaction");

        try {
            t1.begin();
			// Clear all user column values - before deleting column
			ProjectDivColumnsAccessBean column = (ProjectDivColumnsAccessBean)bean;
			Enumeration en = new ProjectDivColValAccessBean().findProjectDivColValsByProjectDivColumn((ProjectDivColumnsKey) column.getEJBRef().getPrimaryKey());
			while (en.hasMoreElements()) {
				((ProjectDivColValAccessBean)en.nextElement()).getEJBRef().remove();
				//((ProjectDivColVal)(javax.rmi.PortableRemoteObject.narrow(en.nextElement(), ProjectDivColVal.class))).remove();
			}
            t1.commit();
        } catch (Exception e) {
	        e.printStackTrace(System.out);
            t1.rollback();
            throw new com.hps.july.web.util.UpdateValidationException("error.referenced");
        }
	}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:15:43)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
	setDivcolid(keygen.getNextKey("tables.projectdivcolumns"));

	ProjectDivColumnsAccessBean bean = new ProjectDivColumnsAccessBean(getDivcolid(), getPrjtypecode(), 
		getDivcode(), getColname(), getAftercol() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	initFields();
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:49:04)
 * @return int
 */
public int getAftercol() {
	return aftercol;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:15:43)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.PROJECT;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:25:17)
 * @return java.lang.String
 */
public java.lang.String getColname() {
	return colname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:15:43)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ProjectDivColumnsAccessBean bean = new ProjectDivColumnsAccessBean();
	bean.setInitKey_divcolid(getDivcolid());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:23:25)
 * @return int
 */
public int getDivcode() {
	return divcode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:48:27)
 * @return int
 */
public int getDivcolid() {
	return divcolid;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:23:44)
 * @return java.lang.String
 */
public java.lang.String getDivname() {
	return divname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:22:43)
 * @return int
 */
public int getPrjtypecode() {
	return prjtypecode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:23:04)
 * @return java.lang.String
 */
public java.lang.String getPrjtypename() {
	return prjtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 12:25:43)
 * @return java.util.Enumeration
 */
public Vector getProtoactions() {
	return protoactions;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:15:43)
 * @return int
 */
public int getState() {
	return com.hps.july.project.APPStates.EDITUSRCOL;
}
/**
 * Initializing collections.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	protoactions = new Vector();
	Enumeration en = new ProtoActionAccessBean().findByProjecttypeOrderByOrderAsc(new Integer(getPrjtypecode()));
	
	protoactions.add(new ColumnOrderObject(0, getServlet().getResources().getMessage("label.usercol.before")));
	while (en.hasMoreElements()) {
		ProtoActionAccessBean pab = (ProtoActionAccessBean)en.nextElement();
		protoactions.add(new ColumnOrderObject(pab.getProjectaction(), pab.getProjectActionType().getName()));
	}
}
/**
 * Lookup names.
 * Creation date: (09.06.2003 11:24:01)
 */
private void initFields() {
	try {
		DivisionAccessBean dab = new DivisionAccessBean();
		dab.setInitKey_division(getDivcode());
		dab.refreshCopyHelper();
		setDivname(dab.getName());
	} catch (Exception e) {
		setDivname("");
	}
	try {
		ProjectTypeAccessBean pab = new ProjectTypeAccessBean();
		pab.setInitKey_projecttype(getPrjtypecode());
		pab.refreshCopyHelper();
		setPrjtypename(pab.getName());
	} catch (Exception e) {
		setPrjtypename("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	initFields();
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:49:04)
 * @param newAftercol int
 */
public void setAftercol(int newAftercol) {
	aftercol = newAftercol;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:25:17)
 * @param newColname java.lang.String
 */
public void setColname(java.lang.String newColname) {
	colname = newColname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:23:25)
 * @param newDivcode int
 */
public void setDivcode(int newDivcode) {
	divcode = newDivcode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:48:27)
 * @param newDivcolid int
 */
public void setDivcolid(int newDivcolid) {
	divcolid = newDivcolid;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:23:44)
 * @param newDivname java.lang.String
 */
public void setDivname(java.lang.String newDivname) {
	divname = newDivname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:22:43)
 * @param newPrjtypecode int
 */
public void setPrjtypecode(int newPrjtypecode) {
	prjtypecode = newPrjtypecode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 10:23:04)
 * @param newPrjtypename java.lang.String
 */
public void setPrjtypename(java.lang.String newPrjtypename) {
	prjtypename = newPrjtypename;
}
/**
 * Validating form values.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	
	if ((getColname() == null) || (getColname().trim().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.usercol.name"));
	  
	if (!errors.empty())
		throw new ValidationException();
}
}
