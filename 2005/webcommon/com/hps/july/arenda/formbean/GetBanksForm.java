package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * Bean-form
 * Форма "банки".
 * Creation date: (09.04.2003 11:52:43)
 * @author: Sergey Gourov
 */
public class GetBanksForm extends com.hps.july.web.util.EditForm {
	private java.lang.Boolean isAllBanks;
	private com.hps.july.web.util.StringAndIntegerProperty bankCode;
	private java.lang.String bik;
	private java.lang.String name;
	private java.lang.String corracount;
	private java.lang.String address;
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 14:20:45)
 */
public GetBanksForm() {
	bankCode = new com.hps.july.web.util.StringAndIntegerProperty();
	setAction("Add");
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:20:36)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:57:01)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 16:00:16)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getBankCode() {
	return bankCode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 16:00:16)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getBankCodeFrm() {
	return bankCode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:55:50)
 * @return java.lang.String
 */
public java.lang.String getBik() {
	return bik;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:56:33)
 * @return java.lang.String
 */
public java.lang.String getCorracount() {
	return corracount;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:12:41)
 */
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:54:34)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAllBanks() {
	return isAllBanks;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:56:10)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:24:14)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.GET_BANKS;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:57:01)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 16:00:16)
 * @param newBankCode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setBankCode(Integer newBankCode) {
	bankCode.setInteger(newBankCode);
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 16:00:16)
 * @param newBankCode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setBankCodeFrm(String newBankCode) {
	bankCode.setString(newBankCode);
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:55:50)
 * @param newBik java.lang.String
 */
public void setBik(java.lang.String newBik) {
	bik = newBik;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:56:33)
 * @param newCorracount java.lang.String
 */
public void setCorracount(java.lang.String newCorracount) {
	corracount = newCorracount;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:54:34)
 * @param newIsAllBanks java.lang.Boolean
 */
public void setIsAllBanks(java.lang.Boolean newIsAllBanks) {
	isAllBanks = newIsAllBanks;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 11:56:10)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (!getIsAllBanks().booleanValue()) {
		if (bankCode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.getbanks.bankcode"));
		} else if (!bankCode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.getbanks.bankcode"));
		} else {
			try {
				OrganizationAccessBean bean = new OrganizationAccessBean();
				bean.setInitKey_organization(getBankCode().intValue());
				bean.refreshCopyHelper();
				
				if (!bean.getBank().booleanValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.getbanks.bankcode"));
				}
			} catch (Exception ex) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.getbanks.bankcode"));
				}
			}
		}
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
