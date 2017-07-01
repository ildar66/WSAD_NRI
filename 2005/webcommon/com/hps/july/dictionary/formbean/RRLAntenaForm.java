package com.hps.july.dictionary.formbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.commonbean.*;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import java.util.*;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import org.apache.struts.action.*;

/**
 * Форма редактирования оборудования РРЛС
 */
public class RRLAntenaForm extends ResourceForm {
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal freqdevlowk = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(6, 2);
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal freqdevhighk = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(6, 2);
	private java.lang.String mkkrrecomm;
	private java.lang.String protocolnum;
	private StringAndSqlDateProperty protocoldate = new StringAndSqlDateProperty();
	private com.hps.july.jdbcpersistence.lib.StringAndInteger freqdevlowlog10 = new com.hps.july.jdbcpersistence.lib.StringAndInteger();
	private com.hps.july.jdbcpersistence.lib.StringAndInteger freqdevhighlog10 = new com.hps.july.jdbcpersistence.lib.StringAndInteger();
private int rrlantid;
	private java.util.LinkedList paramslist;
	private java.util.LinkedList speedparamslist;
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 17:11:54)
 */
public RRLAntenaForm() {
	fuse();
}
private void fuse(){
	setBoxable(Boolean.FALSE);
	setComplectpart(Boolean.FALSE);
}
/**
 * Метод вызывается после добавления/изменения основной записи.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {

		/*
		// После добавления новой записи - перейдем в режим редактирования
		if ("Add".equalsIgnoreCase(getAction())) {
			setAction("Edit");
			throw new ValidationException();
		}
		*/
		/*
		if(forward == mapping.findForward("success")) {
			if("Delete".equals(antenaForm.getAction())) {
				forward = mapping.findForward("successondelete");
			} else if ("Add".equals(antenaForm.getAction())) {
				StringBuffer path = new StringBuffer(forward.getPath());
				int parameterstart = 0;
				parameterstart = path.toString().indexOf("?");
				if(parameterstart > 0) {
					path = new StringBuffer(path.substring(0, parameterstart));
				}
				path.append("?action=Edit&resource=");
				path.append(antenaForm.getResource());
				forward.setPath(path.toString());
		*/
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	//System.out.println("constructBean");
	RRLAntennaResourceAccessBean bean = new RRLAntennaResourceAccessBean(
		getResource(),
		getName(), 
		getModel(), 
		getNotes(),
		getComplect(), 
		getCountpolicy(),
		getBoxable(), 
		getPriceable(), 
		getComplectpart(),
		getActive(), 
		getResourcesubtype(),
		getFreqdevlowk(),
		getFreqdevhighlog10(),
		new java.math.BigDecimal(0),
		0, 
	    getMkkrrecomm(), 
	    getProtocolnum(), 
		getProtocoldate());
	return bean;
	//return null;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2004 17:07:34)
 * @return java.lang.Object
 * @param object java.lang.Object
 */
public Object constructDiamParamsBean(Object object) {
	if(object == null) {
		return null;
	}
	if(!(object instanceof CDBCResultSet)){
		return object;
	}
	CDBCResultSet resultset = (CDBCResultSet)object;
	LinkedList paramsList = new LinkedList();
	Iterator iter = resultset.listIterator();
	while(iter.hasNext()) {
		Object o = iter.next();
		if(o instanceof CDBCRowObject) {
			CDBCRowObject rowObject = (CDBCRowObject)o;
			RRLResourceParamsValueFrm valueObject = new RRLResourceParamsValueFrm();
			valueObject.setRrlantid(rowObject.getColumn("rrlantid").asString());
			valueObject.setResource(rowObject.getColumn("resource").asString());
			valueObject.setAntdiam(rowObject.getColumn("antdiam").asString());
			valueObject.setAmplifkoeff(rowObject.getColumn("amplifkoeff").asString());
			valueObject.setDnangleh(rowObject.getColumn("dnangleh").asString());
			valueObject.setDnanglew(rowObject.getColumn("dnanglew").asString());
			paramsList.add(valueObject);
		} // end of if(o instanceof CDBCRowObject)
	} // end of while(iter.hasNext())
	return paramsList;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2004 17:13:51)
 * @return java.lang.Object
 * @param object java.lang.Object
 */
public Object constructSpeedParamsBean(Object object) {
	if(object == null) {
		return null;
	}
	if(!(object instanceof CDBCResultSet)){
		return object;
	}
	CDBCResultSet resultset = (CDBCResultSet)object;
	LinkedList paramsList = new LinkedList();
	Iterator iter = resultset.listIterator();
	while(iter.hasNext()) {
		Object o = iter.next();
		if(o instanceof CDBCRowObject) {
			CDBCRowObject rowObject = (CDBCRowObject)o;
			RRLResourceSpeedParamsValueFrm valueObject = new RRLResourceSpeedParamsValueFrm();
			valueObject.setRrlspeedid(rowObject.getColumn("rrlspeedid").asString());
			valueObject.setResource(rowObject.getColumn("resource").asString());
			valueObject.setStreamspeed(rowObject.getColumn("streamspeed").asString());
			valueObject.setRadiationclass(rowObject.getColumn("radiationclass").asString());
			valueObject.setRecvsensitivity(rowObject.getColumn("recvsensitivity").asString());
			paramsList.add(valueObject);
		} // end of if(o instanceof CDBCRowObject)
	} // end of while(iter.hasNext())
	return paramsList;
}
//Метод для вычисления полей перед отображением.

public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	try {
		RRLAntennaResourceAccessBean rr = (RRLAntennaResourceAccessBean)bean;
		setResourcesubtype(rr.getSubtype_resourcesubtype().intValue());
		if(rr.getManufid() != null) {
			setManufid(rr.getManufid());
			setManufacturername(CDBCResourcesObject.getManufnameByManufid(rr.getManufid()));
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:27:29)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCResourcesObject";
}
// gets bean for showing on RRLResourceForm.jsp

public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {
	//System.out.println("getDataBean()!");
    RRLAntennaResourceAccessBean bean = new RRLAntennaResourceAccessBean();
    bean.setInitKey_resource(getResource());
    //System.out.println("getResource() = " + getResource());
    //this.initRecord(request);
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2004 12:49:08)
 * @return java.util.ArrayList
 */
public ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList(2);
		roles.add("administrator");
		roles.add("dictResAdmin");
		roles.add("dictResOperator");
		return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 11:53:44)
 * @return java.lang.Object[]
 */
public Object[] getFilterParams() {
	return new Object[] {
		new Integer(getResource())};
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:12:21)
 * @return java.lang.String
 */
public String getFinderMethodName() {
	return "findRRLResourcesParamsList";
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:26:01)
 * @return java.lang.String
 */
public String getFinderMethodNameForSpeedParams() {
	return "findRRLResourcesSpeedParamsList";
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:30:43)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getFreqdevhighk() {
	return freqdevhighk.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:31:02)
 * @return java.lang.String
 */
public java.lang.String getFreqdevhighkFrm() {
	return freqdevhighk.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:56:20)
 * @return int
 */
public int getFreqdevhighlog10() {
	return freqdevhighlog10.getInt();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:56:34)
 * @return java.lang.String
 */
public java.lang.String getFreqdevhighlog10Frm() {
	return freqdevhighlog10.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:11:38)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getFreqdevlowk() {
	return freqdevlowk.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:24:56)
 * @return java.lang.String
 */
public java.lang.String getFreqdevlowkFrm() {
	return freqdevlowk.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:47:57)
 * @return int
 */
public int getFreqdevlowlog10() {
	return freqdevlowlog10.getInt();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:48:25)
 * @return java.lang.String
 */
public java.lang.String getFreqdevlowlog10Frm() {
	return freqdevlowlog10.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:35:27)
 * @return java.lang.String
 */
public java.lang.String getMkkrrecomm() {
	return mkkrrecomm;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2004 16:07:55)
 * @return java.util.LinkedList
 */
public java.util.LinkedList getParamslist() {
	return paramslist;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:36:34)
 * @return java.sql.Date
 */
public java.sql.Date getProtocoldate() {
	return protocoldate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 18:21:22)
 * @return int
 */
public String getProtocoldateFrm() {
	return protocoldate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:35:57)
 * @return java.lang.String
 */
public java.lang.String getProtocolnum() {
	return protocolnum;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 12:12:12)
 * @return int
 */
public int getRrlantid() {
	return rrlantid;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2004 16:08:33)
 * @return java.util.LinkedList
 */
public java.util.LinkedList getSpeedparamslist() {
	return speedparamslist;
}
	public int getState() {
		return com.hps.july.dictionary.APPStates.RRLANTRESOURCE_EDIT;
	}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2004 16:11:47)
 * @param request javax.servlet.http.HttpServletRequest
 * @exception java.lang.Exception The exception description.
 */
public void initCollections(HttpServletRequest request) throws java.lang.Exception {
	if((getResource() != 0) && (!"Add".equals(getAction()))) {
		setParamslist(this.prepareDiamParamsList());
		setSpeedparamslist(this.prepareSpeedParamsList());
	} else {
		setParamslist(new LinkedList());
		setSpeedparamslist(new LinkedList());
	}
	request.setAttribute("paramslist", getParamslist());
	request.setAttribute("speedparamslist", getSpeedparamslist());
}
/**
 * Инициализация полей в режиме добавления записи.
 */

public void initRecord(javax.servlet.http.HttpServletRequest request)
{
		//super.initRecord(request);
		setName("Комплект оборудования РРЛ");
		ResourcesCommonListForm frm = (ResourcesCommonListForm)request.getSession().getAttribute("ResourcesCommonListForm");
	setResourcesubtype(com.hps.july.util.AppUtils.getNamedValueInt("Dict_SIMPLERES"));
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	try{
		setResource(keyGen.getNextKey("tables.resources"));
	}
	catch (Exception e){
	}
}

/**
 * Insert the method's description here.
 * Creation date: (09.08.2004 17:02:48)
 * @exception java.lang.Exception The exception description.
 */
public LinkedList prepareDiamParamsList() throws java.lang.Exception {
	CDBCResourcesObject resourceObject = new CDBCResourcesObject();
	CDBCResultSet resultSet = resourceObject.findRRLResourcesParamsList(new Integer(getResource()));
	LinkedList rrlParamsList = (LinkedList)constructDiamParamsBean(resultSet);
	return rrlParamsList;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2004 17:12:00)
 * @return java.util.LinkedList
 * @exception java.lang.Exception The exception description.
 */
public LinkedList prepareSpeedParamsList() throws java.lang.Exception {
	CDBCResourcesObject resourceObject = new CDBCResourcesObject();
	CDBCResultSet resultSet = resourceObject.findRRLResourcesSpeedParamsList(new Integer(getResource()));
	LinkedList rrlSpeedParamsList = (LinkedList)constructSpeedParamsBean(resultSet);
//	request.setAttribute("speedparamslist", rrlSpeedParamsList);
//	if("Delete".equals(rrlAntenaForm.getAction()))
//		request.getSession().setAttribute("speedparamslist", rrlSpeedParamsList);// try to move it into request
	return rrlSpeedParamsList;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:30:43)
 * @param newFreqdevhighk java.math.BigDecimal
 */
public void setFreqdevhighk(java.math.BigDecimal newFreqdevhighk) {
	freqdevhighk.setBigDecimal(newFreqdevhighk);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:31:02)
 * @param newFreqdevhighkFrm java.lang.String
 */
public void setFreqdevhighkFrm(java.lang.String newFreqdevhighkFrm) {
	freqdevhighk.setString(newFreqdevhighkFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:56:20)
 * @param newFreqdevhighlog10 int
 */
public void setFreqdevhighlog10(int newFreqdevhighlog10) {
	freqdevhighlog10.setInt(newFreqdevhighlog10);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:56:34)
 * @param newFreqdevhighlog10Frm java.lang.String
 */
public void setFreqdevhighlog10Frm(java.lang.String newFreqdevhighlog10Frm) {
	freqdevhighlog10.setString(newFreqdevhighlog10Frm);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:11:38)
 * @param newFreqdevlowk java.math.BigDecimal
 */
public void setFreqdevlowk(java.math.BigDecimal newFreqdevlowk) {
	freqdevlowk.setBigDecimal(newFreqdevlowk);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:24:56)
 * @param newFreqdevlowkFrm java.lang.String
 */
public void setFreqdevlowkFrm(java.lang.String newFreqdevlowkFrm) {
	freqdevlowk.setString(newFreqdevlowkFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:47:57)
 * @param newFreqdevlowlog10 int
 */
public void setFreqdevlowlog10(int newFreqdevlowlog10) {
	freqdevlowlog10.setInt(newFreqdevlowlog10);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:48:25)
 * @param newFreqdevlowlog10Frm java.lang.String
 */
public void setFreqdevlowlog10Frm(java.lang.String newFreqdevlowlog10Frm) {
	freqdevlowlog10.setString(newFreqdevlowlog10Frm);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:35:27)
 * @param newMkkrrecomm java.lang.String
 */
public void setMkkrrecomm(java.lang.String newMkkrrecomm) {
	mkkrrecomm = newMkkrrecomm;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2004 16:07:55)
 * @param newParamslist java.util.LinkedList
 */
public void setParamslist(java.util.LinkedList newParamslist) {
	paramslist = newParamslist;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:36:34)
 * @param newProtocoldate java.sql.Date
 */
public void setProtocoldate(java.sql.Date newProtocoldate) {
	System.out.println("date1 = " + newProtocoldate);
	protocoldate.setSqlDate(newProtocoldate);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 18:21:22)
 * @param newProtocoldateFrm int
 */
public void setProtocoldateFrm(String newProtocoldateFrm) {
	System.out.println("date1 = " + newProtocoldateFrm);
	protocoldate.setString(newProtocoldateFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 10:35:57)
 * @param newProtocolnum java.lang.String
 */
public void setProtocolnum(java.lang.String newProtocolnum) {
	protocolnum = newProtocolnum;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 12:12:12)
 * @param newRrlantid int
 */
public void setRrlantid(int newRrlantid) {
	rrlantid = newRrlantid;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2004 16:08:33)
 * @param newSpeedparamslist java.util.LinkedList
 */
public void setSpeedparamslist(java.util.LinkedList newSpeedparamslist) {
	speedparamslist = newSpeedparamslist;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 12:34:07)
 * @param errors org.apache.struts.action.ActionErrors
 * @param actionErrorKeyPart java.lang.String
 */
public void validateNumberValue(ActionErrors errors, TwainProperty parameter, String keyPart) {
	if(!parameter.isEmpty()) {
		if(!parameter.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.rrlantresource." + keyPart));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.rrlantresource." + keyPart));
	}
}
public void validateValues(ActionErrors errors) throws Exception 
{
	//System.out.println(" VALIDATING VALUES");
	
	boolean haveErrorsInSuperValidate = false;
	try {
		super.validateValues(errors);
	} catch (ValidationException e) {
		haveErrorsInSuperValidate = true;
	}

	if(!freqdevlowk.isEmpty()) {
		if(!freqdevlowk.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.rrlantresource.freqdevlowk"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.rrlantresource.freqdevlowk"));
	}

	if(!freqdevlowlog10.isEmpty()) {
		if(!freqdevlowlog10.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.rrlantresource.freqdevlowlog10"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.rrlantresource.freqdevlowlog10"));
	}

	if(getMkkrrecomm() != null)
		setMkkrrecomm(getMkkrrecomm().trim());
	if((getMkkrrecomm() == null) || (getMkkrrecomm().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.rrlantresource.mkkrrecomm"));
	}

	if(getProtocolnum() != null)
		setProtocolnum(getProtocolnum().trim());
	if((getProtocolnum() == null) || (getProtocolnum().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.rrlantresource.protocolnum"));
	}
	if (!errors.empty() || haveErrorsInSuperValidate)
		throw new ValidationException();

}
}
