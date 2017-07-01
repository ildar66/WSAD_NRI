/*
 * Created on 01.02.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ListIterator;
import java.util.Vector;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCUserRequestsObject;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.dictionary.valueobject.PeopleRow;
import com.hps.july.persistence2.UserRequestsAccessBean;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.web.util.StringAndSqlDateProperty;
import com.hps.july.web.util.ValidationException;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserRequestForm extends EditForm {
	public static final int TYPE_FILIAL = 1;
	public static final int TYPE_REGION = 2;
	public static final int TYPE_HQ = 3;
	
	private int request;
	private StringAndSqlDateProperty datetimein = new StringAndSqlDateProperty();
	private int requesttype;
	private int filialtype;
	private StringAndIntegerProperty regionid = new StringAndIntegerProperty();
	private StringAndIntegerProperty supregid = new StringAndIntegerProperty();
	private int worker;
	private int module;
	private java.lang.String description;
	private java.lang.String status;
	private java.lang.String rfcnum;
	//
	private String workername;
	private String workertitle;
		

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.DICTIONARY;
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.dictionary.APPStates.EDIT_USERREQUEST;
	}
	
	public CDBCResultSet getRequestTypes(){  
		return CDBCUserRequestsObject.findRequestTypes();
	}
	public CDBCResultSet getFilialTypes(){
		return CDBCUserRequestsObject.findFilialTypes();
	}
	public CDBCResultSet getNriModules(){
		return CDBCUserRequestsObject.findNRIModules();
	}
	public CDBCResultSet getFilials(){
		return CDBCUserRequestsObject.findFilials();
	}
	public CDBCResultSet getRegions(){
		return CDBCUserRequestsObject.findRegions();
	}
	
	public Enumeration getStatuses(){
		Vector v = new Vector();
		v.add("A"); v.add("Ожидает рассмотрения");
		v.add("B"); v.add("Рассмотрено");
		return v.elements();
	}
	

	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		UserRequestsAccessBean bean = new UserRequestsAccessBean(
			getRequest(),
			getDatetimein(),
			getRequesttype(),
			getFilialtype(),
			getWorker(),
			getModule(),
			getDescription(),
			getStatus()			
		);
		return bean;
	}
	
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		UserRequestsAccessBean bean = new UserRequestsAccessBean();
		bean.setInitKey_request( getRequest() );
		return bean;
	}
	
	public void initRecord(javax.servlet.http.HttpServletRequest request){
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		try{
			setRequest(keyGen.getNextKey("tables.userrequests"));
		}
		catch (Exception e){
		}
	}	
		
	public int getRequest(){
		return request;
	}
	public java.sql.Date getDatetimein(){
		return datetimein.getSqlDate();
	}
	public String getDatetimeinFrm(){
		return datetimein.getString();
	}
	public int getRequesttype(){
		return requesttype;
	}
	public int getFilialtype(){
		return filialtype;
	}
	public Integer getRegionid(){
		return regionid.getInteger();
	}
	public Integer getSupregid(){
		return supregid.getInteger();
	}
	public String getRegionidFrm(){
		return regionid.getString();
	}
	public String getSupregidFrm(){
		return supregid.getString();
	}
	public int getWorker(){
		return worker;
	}
	public int getModule(){
		return module;
	}
	public String getDescription(){
		return description;
	}
	public String getStatus(){
		return status;
	}
	public String getRfcnum(){
		return rfcnum;
	}
	
	public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
		super.fillRecord(bean);
		setWorkername(CDBCUserRequestsObject.findMan(new Integer(getWorker()))[0]);
		setWorkertitle(CDBCUserRequestsObject.findMan(new Integer(getWorker()))[1]);
	}

	public void setRequest(int newRequest){
		request = newRequest;
	}
	public void setDatetimein(java.sql.Date newDatetimein){
		datetimein.setSqlDate(newDatetimein);
	}
	public void setDatetimeinFrm(String newDatetimein){
		datetimein.setString(newDatetimein);
	}
	public void setRequesttype(int newRequesttype){
		requesttype = newRequesttype;
	}
	public void setFilialtype(int newFilialtype){
		filialtype = newFilialtype;
	}
	public void setRegionid(Integer newRegionid){
		regionid.setInteger(newRegionid);
	}
	public void setSupregid(Integer newSupregid){
		supregid.setInteger(newSupregid);
	}
	public void setRegionidFrm(String newRegionid){
		regionid.setString(newRegionid);
	}
	public void setSupregidFrm(String newSupregid){
		supregid.setString(newSupregid);
	}
	public void setWorker(int newWorker){
		worker = newWorker;
	}
	public void setModule(int newModule){
		module = newModule;
	}
	public void setDescription(String newDescription){
		description = newDescription;
	}
	public void setStatus(String newStatus){
		status = newStatus;
	}
	public void setRfcnum(String newRfcnum){
		rfcnum = newRfcnum;
	}	
	////////////////////////
	public String getWorkername(){
		return workername;
	}
	public String getWorkertitle(){
		return workertitle;
	}
	public void setWorkername(String newWorkername){
		workername = newWorkername;
	}
	public void setWorkertitle(String newWorkertitle){
		workertitle = newWorkertitle;
	}
	////////////////////////
	public void validateValues(ActionErrors errors) throws Exception 
	{
		super.validateValues(errors);
		if(worker==0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.man.empty"));
		}
		if(description.length()==0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.description.empty"));
		}
		if (!errors.empty())
			throw new ValidationException();
	}
}
