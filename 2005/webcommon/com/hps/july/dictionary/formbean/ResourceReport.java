/*
 * Created on 04.06.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import java.util.Enumeration;
import java.util.Vector;

import org.apache.struts.action.ActionErrors;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.persistence.OrganizationAccessBean;
import com.hps.july.web.util.BrowseForm;
import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.web.util.ValidationException;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * 
 * Форма отчета о ресурсах
 */
public class ResourceReport extends BrowseForm{
	
	private Boolean isname;
	private String name="";
	private Boolean ismanuf;
	private StringAndIntegerProperty manuf = new StringAndIntegerProperty();
	private String manufname="";
	private Boolean ismodel;
	private String model="";
	private Boolean ismanucode;
	private String manucode="";
	private Boolean isnfscode;
	private String nfscode="";
	private Boolean isnricode;
	private String nricode="";
	private String showtype="";
	private Boolean initialsort;
	
	private int sortmode;

	public ResourceReport(){
		this.setFinderMethodName("3");
		setLastVisited(true);
		setShowtype("Y");
		setIsmanucode(Boolean.FALSE);
		setIsmanuf(Boolean.FALSE);
		setIsmodel(Boolean.TRUE);
		setIsname(Boolean.FALSE);
		setIsnfscode(Boolean.FALSE);
		setIsnricode(Boolean.FALSE);
		setInitialsort(Boolean.TRUE);
	}
	
	public Object[] getFilterParams() {
		Boolean initsort = getInitialsort();
		setInitialsort(Boolean.FALSE);
		return new Object[] {
			getIsname(), getName(),
			getIsmanuf(), (getManuf()!=null) ? getManuf() : new Integer(0),
			getIsmodel(), getModel(),
			getIsmanucode(), getManucode(),
			getIsnfscode(), getNfscode(),
			getIsnricode(), getNricode(),
			getShowtype(),
			new Integer(getSortmode()),
			initsort
		};
	}
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		roles.add("developer");
		roles.add("dictResAdmin");
		roles.add("dictResOperator");
		return roles;
	}

	public Boolean getInitialsort(){
		return initialsort;
	}
	public void setInitialsort(Boolean newInitialsort){
		initialsort = newInitialsort;
	}
	
	
	public int getSortmode() {
		return sortmode;
	}
	public void setSortmode(int newSortmode) {
		sortmode = newSortmode;
	}
	public Boolean getIsname(){
		return isname;
	}
	public void setIsname(Boolean newIsname){
		isname = newIsname;
	}
	public String getName(){
		return name;
	}
	public void setName(String newName){
		name = newName;
	}
	public Boolean getIsmanuf(){
		return ismanuf;
	}
	public void setIsmanuf(Boolean newIsmanuf){
		ismanuf = newIsmanuf;
	}
	public Integer getManuf(){
		return manuf.getInteger();	
	}
	public void setManuf(Integer newManuf){
		manuf.setInteger(newManuf);
	}
	public String getManufFrm(){
		return manuf.getString();
	}
	public void setManufFrm(String newManuf){
		manuf.setString(newManuf);
	}
	public String getManufname(){
		return manufname;
	}
	public void setManufname(String newManufname){
		manufname = newManufname;		
	}
	public Boolean getIsmodel(){
		return ismodel;
	}
	public void setIsmodel(Boolean newIsmodel){
		ismodel = newIsmodel;
	}
	public String getModel(){
		return model;	
	}
	public void setModel(String newModel){
		model = newModel;
	}
	public Boolean getIsmanucode(){
		return ismanucode;
	}
	public void setIsmanucode(Boolean newIsmanucode){
		ismanucode = newIsmanucode;
	}
	public String getManucode(){
		return manucode;
	}
	public void setManucode(String newManucode){
		manucode = newManucode;
	}
	public Boolean getIsnfscode(){
		return isnfscode;
	}
	public void setIsnfscode(Boolean newIsnfscode){
		isnfscode = newIsnfscode;
	}
	public String getNfscode(){
		return nfscode;
	}
	public void setNfscode(String newNfscode){
		nfscode = newNfscode;
	}
	public Boolean getIsnricode(){
		return isnricode;
	}
	public void setIsnricode(Boolean newIsnricode){
		isnricode = newIsnricode;
	}
	public String getNricode(){
		return nricode;
	}
	public void setNricode(String newNricode){
		nricode = newNricode;
	}
	public String getShowtype(){
		return showtype;
	}
	public void setShowtype(String newShowtype){
		showtype = newShowtype;
	}
	public CDBCResultSet getResClasses(){
		return CDBCResourcesObject.findAllResourceclasses2();
	}	
	public void validateValues(ActionErrors errors)
		throws ValidationException
	{
		setManufname(CDBCResourcesObject.getManufnameByManufid(getManuf()));
	}	
	public void setFinderMethodName(java.lang.String newFinderMethodName) {
		try {
			setSortmode(Integer.parseInt(newFinderMethodName));
		} catch(Exception e) {
		}
	}
	public java.lang.String getFinderMethodName() {
		return "buildResourceReport";
	}	
}