/*
 * Created on 01.02.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import java.sql.Date;
import java.util.Enumeration;
import java.util.Vector;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.objects.CDBCUserRequestsObject;
import com.hps.july.web.util.BrowseForm;
import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.web.util.StringAndSqlDateProperty;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserRequestListForm extends BrowseForm {
	private Boolean byrequesttype;
	private Boolean byfilialtype;
	private Boolean byfilial;
	private Boolean byregion;
	private Boolean byworker;
	private Boolean bymodule;
	private Boolean bystatus;
	private Boolean byrfc;
	
	private StringAndSqlDateProperty finddate_from = new StringAndSqlDateProperty();
	private StringAndSqlDateProperty finddate_to = new StringAndSqlDateProperty();
	
	private int requesttype;
	private int filialtype;
	private int regionid;
	private int supregid;
	private int worker;
	private int module;
	private String status = "";
	
	private String rfc = "";
	//
	private String workername;
	private String workertitle;

	
	public UserRequestListForm(){
		this.setFinderMethodName("findRequestsConditional");
		setLastVisited(true);
		java.util.Date now = new java.util.Date();
		finddate_from.setSqlDate(new Date(now.getTime()));
		finddate_to.setSqlDate(new Date(now.getTime()));
		setByrequesttype(Boolean.FALSE);
		setByfilialtype(Boolean.FALSE);
		setByfilial(Boolean.FALSE);
		setByregion(Boolean.FALSE);
		setByworker(Boolean.FALSE);
		setBymodule(Boolean.FALSE);
		setBystatus(Boolean.FALSE);
		setByrfc(Boolean.FALSE);
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] {
			finddate_from.getSqlDate(),
			finddate_to.getSqlDate(),
			getByrequesttype(),
			new Integer(getRequesttype()),
			getByfilialtype(),
			new Integer(getFilialtype()),
			getByfilial(),
			new Integer(getRegionid()),
			getByregion(),
			new Integer(getSupregid()),
			getByworker(),
			new Integer(getWorker()),
			getBymodule(),
			new Integer(getModule()),
			getBystatus(),
			getStatus(),
			getByrfc(),
			getRfc()
		};
	}
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		roles.add("developer");
		return roles;
	}
	public void setFinddate_from(java.sql.Date newFinddate_from){
		finddate_from.setSqlDate(newFinddate_from);
	}
	public java.sql.Date getFinddate_from(){
		return finddate_from.getSqlDate();
	}
	public void setFinddate_fromFrm(String newFinddate_from){
		finddate_from.setString(newFinddate_from);
	}
	public String getFinddate_fromFrm(){
		return finddate_from.getString();
	}
	public void setFinddate_to(java.sql.Date newFinddate_to){
		finddate_to.setSqlDate(newFinddate_to);
	}
	public java.sql.Date getFinddate_to(){
		return finddate_to.getSqlDate();
	}
	public void setFinddate_toFrm(String newFinddate_to){
		finddate_to.setString(newFinddate_to);
	}
	public String getFinddate_toFrm(){
		return finddate_to.getString();
	}
	public void setRequesttype(int newRequesttype){
		requesttype = newRequesttype;
	}
	public int getRequesttype(){
		return requesttype;
	}
	public void setFilialtype(int newFilialtype){
		filialtype = newFilialtype;
	}
	public int getFilialtype(){
		return filialtype;
	}
	public void setRegionid(int newRegionid){
		regionid = newRegionid;
	}
	public int getRegionid(){
		return regionid;
	}
	public void setSupregid(int newSupregid){
		supregid = newSupregid;
	}
	public int getSupregid(){
		return supregid;
	}
	public void setWorker(int newWorker){
		worker = newWorker;
	}
	public int getWorker(){
		return worker;
	}
	public void setModule(int newModule){
		module = newModule;
	}
	public int getModule(){
		return module;
	}
	public void setStatus(String newStatus){
		status = newStatus;
	}
	public String getStatus(){
		return status;
	}
	public void setRfc(String newRfc){
		rfc = newRfc;
	}
	public String getRfc(){
		return rfc;
	}
	public void setByrequesttype(Boolean newByrequesttype){
		byrequesttype = newByrequesttype;
	}
	public Boolean getByrequesttype(){
		return byrequesttype;
	}
	public void setByfilialtype(Boolean newByfilialtype){
		byfilialtype = newByfilialtype;
	}
	public Boolean getByfilialtype(){
		return byfilialtype;
	}
	public void setByfilial(Boolean newByfilial){
		byfilial = newByfilial;
	}
	public Boolean getByfilial(){
		return byfilial;
	}
	public void setByregion(Boolean newByregion){
		byregion = newByregion;
	}
	public Boolean getByregion(){
		return byregion;
	}
	public void setByworker(Boolean newByworker){
		byworker = newByworker;
	}
	public Boolean getByworker(){
		return byworker;
	}
	public void setBymodule(Boolean newBymodule){
		bymodule = newBymodule;
	}
	public Boolean getBymodule(){
		return bymodule;
	}
	public void setBystatus(Boolean newBystatus){
		bystatus = newBystatus;
	}
	public Boolean getBystatus(){
		return bystatus;
	}
	public void setByrfc(Boolean newByrfc){
		byrfc = newByrfc;
	}
	public Boolean getByrfc(){
		return byrfc;
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
	public Enumeration getStatuses(){
		Vector v = new Vector();
		v.add("A"); v.add("Ожидает рассмотрения");
		v.add("B"); v.add("Рассмотрено");
		return v.elements();
	}
}