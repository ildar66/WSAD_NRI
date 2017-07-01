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
 * ‘орма дл€ характеристик антенн ррл, завис€щих о скорости потока
 */
public class RRLSpeedParamForm extends ResourceForm {
	private StringAndInteger resource = new StringAndInteger();
	private int rrlspeedid;
	private java.lang.String streamspeed;
	private java.lang.String radiationclass;
private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal recvsensitivity = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(4, 1);
/**
 * RRLSpeedParamForm constructor comment.
 */
public RRLSpeedParamForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2004 10:57:01)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 * @exception java.lang.Exception The exception description.
 */
public AbstractEntityAccessBean constructBean(HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setRrlspeedid(keyGen.getNextKey("tables.rrlspeedparams"));
	RRLSpeedParamsAccessBean bean = new RRLSpeedParamsAccessBean (
		getRrlspeedid(),
		getResource(),
		getStreamspeed(),
		getRadiationclass(),
		getRecvsensitivity());
	return bean;
}
/**
 * ћетод ищет значени€ streamspeed дл€ данного ресурса из таблицы rrlspeedparams
 * и возвращает в виде коллекции
 * Creation date: (06.08.2004 14:02:23)
 * @return java.util.LinkedList
 * @exception java.lang.Exception The exception description.
 */
public HashMap findUsedStreamspeeds() throws java.lang.Exception {
	com.hps.july.cdbc.objects.CDBCResourcesObject resourceObj = new com.hps.july.cdbc.objects.CDBCResourcesObject();
	com.hps.july.cdbc.lib.CDBCResultSet resultset = null;
	resultset =  resourceObj.findRRLResourcesSpeedParamsStreamspeeds(new Integer(getResource()));
	if(resultset == null)
		return null;
	HashMap streamspeedMap = new HashMap();
	java.util.Iterator iter = resultset.listIterator();
	while(iter.hasNext()) {
		Object o = iter.next();
		if(o instanceof CDBCRowObject) {
			CDBCRowObject rowObject = (CDBCRowObject)o;
			String streamspeed = rowObject.getColumn("streamspeed").asString();
			StringAndInteger rrlspeedid = new StringAndInteger();
			rrlspeedid.setString(rowObject.getColumn("rrlspeedid").asString());
			streamspeedMap.put(rrlspeedid, streamspeed);
		} // end of if(o instanceof CDBCRowObject)
	} // end of while(iter.hasNext())
	return streamspeedMap;
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
	RRLSpeedParamsAccessBean bean = new RRLSpeedParamsAccessBean();
    bean.setInitKey_rrlspeedid(getRrlspeedid());
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:12:54)
 * 
 */
public Object[] getFilterParams() {
	return new Object[] {
		new Integer(getResource())};
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:13:18)
 * @return java.lang.String
 */
public java.lang.String getRadiationclass() {
	return radiationclass;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:14:00)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRecvsensitivity() {
	return recvsensitivity.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:14:19)
 * @return java.lang.String
 */
public java.lang.String getRecvsensitivityFrm() {
	return recvsensitivity.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:08:50)
 * @return int
 */
public int getResource() {
	return resource.getInt();
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:09:37)
 * @return java.lang.String
 */
public java.lang.String getResourceFrm() {
	return resource.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:12:12)
 * @return int
 */
public int getRrlspeedid() {
	return rrlspeedid;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:23:09)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.RRLANTRESOURCE_SPEEDPARAM_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:12:54)
 * @return java.lang.String
 */
public java.lang.String getStreamspeed() {
	return streamspeed;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:27:29)
 * @return java.lang.String
 */
public String getStremspeedFinderMethodName() {
	return "findRRLResourcesSpeedParamsStreamspeeds";
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2004 15:15:13)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(HttpServletRequest request) {
	
}
/**
 * ћетод возвращает true, если данное значение streamspeed может быть использовано.
 * ¬озвращает false, если такое значение streamspeed дл€ этого ресурса уже
 * использовано и не этой записью.
 * Creation date: (06.08.2004 13:57:37)
 * @return boolean
 * @exception java.lang.Exception The exception description.
 */
public boolean isSuchStreamspeedUsed() throws java.lang.Exception {
	//System.out.println("!!! new = " + getStreamspeed() + "!");
	//System.out.println("!!! new id = " + getRrlspeedid());
	HashMap usedStreamspeeds = this.findUsedStreamspeeds();
	Set rrlspeedids = usedStreamspeeds.keySet();
	Iterator iter = rrlspeedids.iterator();
	while(iter.hasNext()) {
		Object rrlspeedid = iter.next();
		String usedStreamspeed = (String)usedStreamspeeds.get(rrlspeedid);
		//System.out.println("!!! used = " + usedStreamspeed + "!");
		if((getStreamspeed().trim()).equals(usedStreamspeed.trim())) {
			StringAndInteger oldrrlspeedid = (StringAndInteger)rrlspeedid;
			//System.out.println("!!!! oldid = " + oldrrlspeedid.getString() + "!");
			if(getRrlspeedid() != oldrrlspeedid.getInt())
				return true;
		}
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:13:18)
 * @param newRadiationclass java.lang.String
 */
public void setRadiationclass(java.lang.String newRadiationclass) {
	radiationclass = newRadiationclass;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:14:00)
 * @param newRecvsensitivity java.math.BigDecimal
 */
public void setRecvsensitivity(java.math.BigDecimal newRecvsensitivity) {
	recvsensitivity.setBigDecimal(newRecvsensitivity);
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:14:19)
 * @param newRecvsensitivityFrm java.lang.String
 */
public void setRecvsensitivityFrm(java.lang.String newRecvsensitivityFrm) {
	recvsensitivity.setString(newRecvsensitivityFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:08:50)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource.setInt(newResource);
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:09:37)
 * @param newResourceFrm java.lang.String
 */
public void setResourceFrm(java.lang.String newResourceFrm) {
	resource.setString(newResourceFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:12:12)
 * @param newRrlspeedid int
 */
public void setRrlspeedid(int newRrlspeedid) {
	rrlspeedid = newRrlspeedid;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:12:54)
 * @param newStreamspeed java.lang.String
 */
public void setStreamspeed(java.lang.String newStreamspeed) {
	streamspeed = newStreamspeed;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 17:24:49)
 * @param errors org.apache.struts.action.ActionErrors
 * @exception java.lang.Exception The exception description.
 */
public void validateValues(ActionErrors errors) throws java.lang.Exception {
	if(getStreamspeed() != null)
		setStreamspeed(getStreamspeed().trim());
	if((getStreamspeed() == null) || (getStreamspeed().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.rrlantresource.streamspeed"));
	}
	if(getRadiationclass() != null)
		setRadiationclass(getRadiationclass().trim());
	if((getRadiationclass() == null) || (getRadiationclass().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.rrlantresource.radiationclass"));
	}
	validateNumberValue(errors, recvsensitivity, "rrlantresource.recvsensitivity");
	if(errors.empty()) {
		if(this.isSuchStreamspeedUsed()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rrlantresource.speed.streamspeedused"));
		}
	}
	if (!errors.empty())
		throw new ValidationException();
}
}
