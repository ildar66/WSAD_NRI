package com.hps.july.dictionary.formbean;

import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.commonbean.*;
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
 * ‘орма дл€ параметров ррл антенн, завис€щих от диаметра антенны.
 */
public class RRLDiamParamForm extends ResourceForm {
	private StringAndBigDecimal antdiam = new StringAndBigDecimal(2, 1);
	private StringAndBigDecimal amplifkoeff = new StringAndBigDecimal(4, 1);
	private StringAndBigDecimal dnangleh = new StringAndBigDecimal(3, 1);
	private StringAndBigDecimal dnanglew = new StringAndBigDecimal(3, 1);
	private int rrlantid;
	private StringAndInteger resource = new StringAndInteger();
/**
 * RRLDiamParamForm constructor comment.
 */
public RRLDiamParamForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:44:01)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public AbstractEntityAccessBean constructBean(HttpServletRequest request) throws Exception {

	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setRrlantid(keyGen.getNextKey("tables.rrlantparams"));
	//System.out.println("resource = " + getResource());
	RRLAntParamsAccessBean bean = new RRLAntParamsAccessBean (
		getRrlantid(), getResource(),
		getAntdiam(), getAmplifkoeff(),
		getDnangleh(), getDnanglew());
	return bean;
}
/**
 * ћетод ищет значени€ antdiam дл€ данного ресурса из таблицы rrlantparams
 * и возвращает в виде коллекции
 * Creation date: (06.08.2004 13:17:37)
 * @return java.util.LinkedList
 * @exception java.lang.Exception The exception description.
 */
public HashMap findUsedAntdiams() throws java.lang.Exception {
	com.hps.july.cdbc.objects.CDBCResourcesObject resourceObj = new com.hps.july.cdbc.objects.CDBCResourcesObject();
	com.hps.july.cdbc.lib.CDBCResultSet resultset = null;
	resultset =  resourceObj.findRRLResourcesParamsAntdiams(new Integer(getResource()));
	if(resultset == null)
		return null;
	HashMap antdiamsMap = new HashMap();
	Iterator iter = resultset.listIterator();
	while(iter.hasNext()) {
		Object o = iter.next();
		if(o instanceof CDBCRowObject) {
			CDBCRowObject rowObject = (CDBCRowObject)o;
			StringAndBigDecimal antdiam = new StringAndBigDecimal(2, 1);
			antdiam.setString(rowObject.getColumn("antdiam").asString());
			StringAndInteger rrlantid = new StringAndInteger();
			rrlantid.setString(rowObject.getColumn("rrlantid").asString());
			antdiamsMap.put(rrlantid, antdiam);
		}
	}
	return antdiamsMap;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:36:02)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAmplifkoeff() {
	return amplifkoeff.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:36:19)
 * @return java.lang.String
 */
public java.lang.String getAmplifkoeffFrm() {
	return amplifkoeff.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:32:54)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAntdiam() {
	return antdiam.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:33:23)
 * @return java.lang.String
 */
public java.lang.String getAntdiamFrm() {
	return antdiam.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:27:29)
 * @return java.lang.String
 */
public String getAntdiamsFinderMethodName() {
	return "findRRLResourcesParamsAntdiams";
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:27:29)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCResourcesObject";
}
/**
 * «агружает бин дл€ редактировани€ и удалени€.
 * Creation date: (15.07.2004 18:04:11)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
    RRLAntParamsAccessBean bean = new RRLAntParamsAccessBean();
    bean.setInitKey_rrlantid(getRrlantid());
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:38:37)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnangleh() {
	return dnangleh.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:38:57)
 * @return java.lang.String
 */
public java.lang.String getDnanglehFrm() {
	return dnangleh.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:41:10)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnanglew() {
	return dnanglew.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:41:26)
 * @return java.lang.String
 */
public java.lang.String getDnanglewFrm() {
	return dnanglew.getString();
}
public Object[] getFilterParams() {
	return new Object[] {
		new Integer(getResource())};
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2004 15:11:58)
 * @return int
 */
public int getResource() {
	return resource.getInt();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2004 15:12:17)
 * @return java.lang.String
 */
public java.lang.String getResourceFrm() {
	return resource.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 17:08:03)
 * @return int
 */
public int getRrlantid() {
	return rrlantid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 18:19:21)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.RRLANTRESOURCE_PARAM_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2004 15:15:13)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(HttpServletRequest request) {
}
/**
 * ћетод возвращает true, если данное значение antdiam может быть использовано.
 * ¬озвращает false, если такое значение antdiam дл€ этого ресурса уже
 * использовано и не этой записью.
 * Creation date: (06.08.2004 12:23:53)
 * @return boolean
 * @exception java.lang.Exception The exception description.
 */
public boolean isSuchAntdiamUsed() throws java.lang.Exception {
	HashMap usedAntdiams = this.findUsedAntdiams();
	System.out.println("!!!! new = " + getAntdiam());

	Set rrlantids = usedAntdiams.keySet();
	Iterator iter = rrlantids.iterator();
	while(iter.hasNext()) {
		Object rrlantid = iter.next();
		StringAndBigDecimal usedAntdiam = (StringAndBigDecimal)usedAntdiams.get(rrlantid);
		if(getAntdiam().doubleValue() == usedAntdiam.getBigDecimal().doubleValue()) {
			StringAndInteger oldrrlantid = (StringAndInteger)rrlantid;
			if(getRrlantid() != oldrrlantid.getInt())
				return true;
		}
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:36:02)
 * @param newAmplifkoeff java.math.BigDecimal
 */
public void setAmplifkoeff(java.math.BigDecimal newAmplifkoeff) {
	amplifkoeff.setBigDecimal(newAmplifkoeff);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:36:19)
 * @param newAmplifkoeffFrm java.lang.String
 */
public void setAmplifkoeffFrm(java.lang.String newAmplifkoeffFrm) {
	amplifkoeff.setString(newAmplifkoeffFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:32:54)
 * @param newAntdiam java.math.BigDecimal
 */
public void setAntdiam(java.math.BigDecimal newAntdiam) {
	antdiam.setBigDecimal(newAntdiam);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:33:23)
 * @param newAntdiamFrm java.lang.String
 */
public void setAntdiamFrm(java.lang.String newAntdiamFrm) {
	antdiam.setString(newAntdiamFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:38:37)
 * @param newDnangleh java.math.BigDecimal
 */
public void setDnangleh(java.math.BigDecimal newDnangleh) {
	dnangleh.setBigDecimal(newDnangleh);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:38:57)
 * @param newDnanglehFrm java.lang.String
 */
public void setDnanglehFrm(java.lang.String newDnanglehFrm) {
	dnangleh.setString(newDnanglehFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:41:10)
 * @param newDnanglew java.math.BigDecimal
 */
public void setDnanglew(java.math.BigDecimal newDnanglew) {
	dnanglew.setBigDecimal(newDnanglew);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:41:26)
 * @param newDnanglewFrm java.lang.String
 */
public void setDnanglewFrm(java.lang.String newDnanglewFrm) {
	dnanglew.setString(newDnanglewFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2004 15:11:58)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource.setInt(newResource);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2004 15:12:17)
 * @param newResourceFrm java.lang.String
 */
public void setResourceFrm(java.lang.String newResourceFrm) {
	resource.setString(newResourceFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 17:08:03)
 * @param newRrlantid int
 */
public void setRrlantid(int newRrlantid) {
	rrlantid = newRrlantid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 18:09:09)
 * @param errors org.apache.struts.action.ActionErrors
 * @exception java.lang.Exception The exception description.
 */
public void validateValues(ActionErrors errors) throws java.lang.Exception {
	validateNumberValue(errors, antdiam, "rrlantresource.params.antdiam");
	validateNumberValue(errors, amplifkoeff, "rrlantresource.params.amplifkoeff");
	validateNumberValue(errors, dnangleh, "rrlantresource.params.dnangleh");
	validateNumberValue(errors, dnanglew, "rrlantresource.params.dnanglew");
	if(errors.empty()) {
		if(this.isSuchAntdiamUsed()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlantresource.params.antdiamused"));
			System.out.println("Error added");
		}
	}
	if (!errors.empty())
		throw new ValidationException();
}
}
