package com.hps.july.inventory.formbean;

import java.math.BigDecimal;
import javax.ejb.ObjectNotFoundException;
import com.hps.july.inventory.sessionbean.*;
import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;

/**
 * Форма редактирования позиции акта монтажа АФС типа "делитель" с кабелем.
 * Creation date: (10.03.2005 17:16:26)
 * @author: Dmitry Dneprov
 */
public class AfsDPositionForm extends AfsPositionForm {
	private java.lang.Integer cableres;
	private StringAndBigDecimalProperty cablelen = new StringAndBigDecimalProperty();
/**
 * AfsDPositionForm constructor comment.
 */
public AfsDPositionForm() {
	super();
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.afterUpdate(bean,request);
	AfsMountPosAccessBean cp = new AfsMountPosAccessBean();
	if(cableres != null) {
		Enumeration en = cp.findChildrenByParent(getDocpos());
		if(en.hasMoreElements()) {
			try {
				while(en.hasMoreElements()) {
					AfsMountPosAccessBean e = (AfsMountPosAccessBean)en.nextElement();
//System.out.println("AFS.D:UpdateCable");
					updateCable(e);
				}
			} catch(Exception e) {
				e.printStackTrace(System.out);
				throw new UpdateValidationException("error.afsposd.updatecable");
			}
		} else {
			try {
//System.out.println("AFS.D:CreateCable");
				createCable();
			} catch(Exception e) {
				e.printStackTrace(System.out);
				throw new UpdateValidationException("error.afsposd.createcable");
			}
		}
	} else {
//System.out.println("AFS.D:DeleteCable");
		deleteCable();
	}
}
public void beforeDelete(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception 
{
	super.beforeDelete(bean,request);
	try {
		deleteCable();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.afsposd.deletecable");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.beforeUpdate(bean,request);
	AfsMountPosAccessBean p = (AfsMountPosAccessBean)bean;
	p.setDocpostype("E");
}
public void createCable()
	throws Exception
{
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	int cablepos = keyGen.getNextKey("tables.docpositions");
	AfsMountPosAccessBean cp = new AfsMountPosAccessBean(
		cablepos,
		getCableres(),
		getOwnercode(),
		getDocId(),
		getOrder(),
		getCablelenBD(),
		new BigDecimal(0.0), // Price
		getSourceBoxed(),
		getResultBoxed(),
		getSourceBroken(),
		getResultBroken(),
		getSourceClosed(),
		getResultClosed()
	);
	cp.setDocpostype("C");
	cp.setLen_cable(getCablelenBD());
	cp.setParentdocpos(getDocpos());
	cp.setParty("");
	cp.commitCopyHelper();
}
public void deleteCable()
	throws Exception
{
	AfsMountPosAccessBean cp = new AfsMountPosAccessBean();
	Enumeration en = cp.findChildrenByParent(getDocpos());
	while(en.hasMoreElements()) {
		AfsMountPosAccessBean e = (AfsMountPosAccessBean)en.nextElement();
		e.getEJBRef().remove();
	}
}
public java.lang.String getCablelen() {
	return cablelen.getString();
}
public BigDecimal getCablelenBD() {
	return cablelen.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2005 17:51:33)
 * @return java.lang.Integer
 */
public java.lang.Integer getCableres() {
	return cableres;
}
public java.util.Enumeration getCableTypes()
	throws Exception
{
	java.util.Vector vec = new java.util.Vector();
	CableResourceAccessBeanTable table = new CableResourceAccessBeanTable();
    table.setCableResourceAccessBean(
        new CableResourceAccessBean().findByQBE4(
            Boolean.FALSE,
            new Integer(0),
            Boolean.FALSE,
            new Integer(0),
            new Integer(1)));

    for (int i = 0; i <table.numberOfRows() ; i++) {
		vec.addElement(new CableResourceObject(table.getCableResourceAccessBean(i)));
	}

    return vec.elements();
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITAFSDPOS;
}
/**
 * Метод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.loadRecord(request);
	// Найдем кабель для делителя
	CDBCDocuments cdo = new CDBCDocuments();
	CDBCResultSet rs = cdo.listAfsMountCableItems(getDocpos());
	java.util.Iterator it = rs.listIterator();
	if (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		setCableres((Integer)ro.getColumn("resource").asObject());
		setCablelen(ro.getColumn("qty").asString());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2005 17:52:03)
 * @param newCablelen java.lang.String
 */
public void setCablelen(java.lang.String newCablelen) {
	cablelen.setString(newCablelen);
}
/**
 * Insert the method's description here.
 * Creation date: (10.03.2005 17:51:33)
 * @param newCableres java.lang.Integer
 */
public void setCableres(java.lang.Integer newCableres) {
	cableres = newCableres;
}
public void updateCable(AfsMountPosAccessBean cp)
	throws Exception
{
	if(getCableres() == null) {
		return;
	}
	if(!"C".equals(cp.getDocpostype())) {
		return;
	}
	
	ResourceAccessBean res = new ResourceAccessBean();
	res.setInitKey_resource(getCableres().intValue());
	res.refreshCopyHelper();

	cp.setResource((Resource)res.getEJBRef());
	cp.setLen_cable(getCablelenBD());

	cp.commitCopyHelper();
}
public void validateValues(ActionErrors errors) throws Exception 
{
	super.validateValues(errors);
	
	if(cableres != null) {
		try {
			ResourceAccessBean res = new ResourceAccessBean();
			res.setInitKey_resource(cableres.intValue());
			res.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.afsposd.cableres"));
		}
		if(cablelen.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.afsposd.cablelen.empty"));
		} else if(!cablelen.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.afsposd.cablelen.invalid"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.afsposd.cableres.empty"));
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
