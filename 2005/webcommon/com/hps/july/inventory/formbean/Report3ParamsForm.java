package com.hps.july.inventory.formbean;

import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма параметров отчёта "Оборудование, контракты и поставки"
 */
public class Report3ParamsForm extends ReportForm {
	private Boolean alltype;
	private StringAndIntegerProperty restype;
	private String restypename;
	private Boolean allsbtype;
	private StringAndIntegerProperty ressbtype;
	private String ressbtypename;

	private int baseagreement;
	private int supplyact;
	private String supplynum;
	private String supplyname;
	private String account;
	
	private String statetype;
	private StringAndSqlDateProperty stateDate;

	private String searchon;
	private Boolean group;
	private Boolean showAgregated;
	private Boolean showContract;
	private Boolean showOnmap;

	private String baseagreementname;
public Report3ParamsForm() {
	alltype = Boolean.TRUE;
	restype = new StringAndIntegerProperty();
	restypename = "";
	allsbtype = Boolean.TRUE;
	ressbtype = new StringAndIntegerProperty();
	ressbtypename = "";

	baseagreement = 0;
	supplyact = 0;
	account = "";
	
	statetype = "C";
	stateDate = new StringAndSqlDateProperty();

	searchon = "1";
	group = Boolean.FALSE;
	showAgregated = Boolean.FALSE;
	showContract = Boolean.FALSE;
	showOnmap = Boolean.FALSE;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAccount() {
	return account;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getAllsbtype() {
	return allsbtype;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getAlltype() {
	return alltype;
}
/**
 * 
 * @return int
 */
public int getBaseagreement() {
	return baseagreement;
}
public java.lang.String getBaseagreementname() {
	try {
		BaseAgreementAccessBean ba = new BaseAgreementAccessBean();
		ba.setInitKey_baseagreement(baseagreement);
		ba.refreshCopyHelper();
		baseagreementname = ba.getName();
	} catch(Exception e) {
		baseagreementname = null;
	}
	return baseagreementname;
}
public java.util.Enumeration getBaseagreements() {
	try {
		com.hps.july.persistence.BaseAgreementAccessBean ba = new com.hps.july.persistence.BaseAgreementAccessBean();
		return ba.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getGroup() {
	return group;
}
public String getRessbtypecode() {
	return ressbtype.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRessbtypename() {
	return ressbtypename;
}
public String getRestypecode() {
	return restype.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRestypename() {
	return restypename;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSearchon() {
	return searchon;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowAgregated() {
	return showAgregated;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowContract() {
	return showContract;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowOnmap() {
	return showOnmap;
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT3PARAMS;
}
public String getStateDateFrm() {
	return stateDate.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStatetype() {
	return statetype;
}
public java.util.Enumeration getSupplies() {
	try {
		com.hps.july.persistence.SupplyTypeAccessBean st = new com.hps.july.persistence.SupplyTypeAccessBean();
		return st.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * 
 * @return int
 */
public int getSupplyact() {
	return supplyact;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSupplyname() {
	return supplyname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSupplynum() {
	return supplynum;
}
/**
 * 
 * @param newAccount java.lang.String
 */
public void setAccount(java.lang.String newAccount) {
	account = newAccount;
}
/**
 * 
 * @param newAllsbtype java.lang.Boolean
 */
public void setAllsbtype(java.lang.Boolean newAllsbtype) {
	allsbtype = newAllsbtype;
}
/**
 * 
 * @param newAlltype java.lang.Boolean
 */
public void setAlltype(java.lang.Boolean newAlltype) {
	alltype = newAlltype;
}
/**
 * 
 * @param newBaseagreement int
 */
public void setBaseagreement(int newBaseagreement) {
	baseagreement = newBaseagreement;
}
/**
 * 
 * @param newBaseagreementname java.lang.String
 */
public void setBaseagreementname(java.lang.String newBaseagreementname) {
	baseagreementname = newBaseagreementname;
}
/**
 * 
 * @param newGroup java.lang.Boolean
 */
public void setGroup(java.lang.Boolean newGroup) {
	group = newGroup;
}
public void setRessbtypecode(String newCode) {
	ressbtype.setString(newCode);
}
/**
 * 
 * @param newRessbtypename java.lang.String
 */
public void setRessbtypename(java.lang.String newRessbtypename) {
	ressbtypename = newRessbtypename;
}
public void setRestypecode(String newCode) {
	restype.setString(newCode);
}
/**
 * 
 * @param newRestypename java.lang.String
 */
public void setRestypename(java.lang.String newRestypename) {
	restypename = newRestypename;
}
/**
 * 
 * @param newSearchon java.lang.String
 */
public void setSearchon(java.lang.String newSearchon) {
	searchon = newSearchon;
}
/**
 * 
 * @param newShowAgregated java.lang.Boolean
 */
public void setShowAgregated(java.lang.Boolean newShowAgregated) {
	showAgregated = newShowAgregated;
}
/**
 * 
 * @param newShowContract java.lang.Boolean
 */
public void setShowContract(java.lang.Boolean newShowContract) {
	showContract = newShowContract;
}
/**
 * 
 * @param newShowOnmap java.lang.Boolean
 */
public void setShowOnmap(java.lang.Boolean newShowOnmap) {
	showOnmap = newShowOnmap;
}
public void setStateDateFrm(String date) {
	stateDate.setString(date);
}
/**
 * 
 * @param newStatetype java.lang.String
 */
public void setStatetype(java.lang.String newStatetype) {
	statetype = newStatetype;
}
/**
 * 
 * @param newSupplyact int
 */
public void setSupplyact(int newSupplyact) {
	supplyact = newSupplyact;
}
/**
 * 
 * @param newSupplyname java.lang.String
 */
public void setSupplyname(java.lang.String newSupplyname) {
	supplyname = newSupplyname;
}
/**
 * 
 * @param newSupplynum java.lang.String
 */
public void setSupplynum(java.lang.String newSupplynum) {
	supplynum = newSupplynum;
}
public void validateValues(ActionErrors errors) throws Exception 
{
 //	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("label.all"));
 	//System.out.println("R3P:validate()");
	try {
		BaseAgreementAccessBean ba = new BaseAgreementAccessBean();
		ba.setInitKey_baseagreement(baseagreement);
		ba.refreshCopyHelper();
		baseagreementname = ba.getName();
	} catch(Exception e) {
		baseagreementname = "?";
	}
 	//System.out.println("R3P:validate(): baseagreementname="+baseagreementname );

	if(!alltype.booleanValue() && restype.isEmpty()){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report3.restype"));
	}

	if(!allsbtype.booleanValue() && ressbtype.isEmpty()){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report3.ressbtype"));
	}
 	
	if("".equals(account) && baseagreement <= 0 && supplyact <=0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report3.choosesupply"));
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
