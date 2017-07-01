package com.hps.july.arenda.formbean;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import java.math.BigDecimal;
import javax.servlet.http.*;
import com.hps.july.arenda.valueobject.LeaseAbonentBANValue;
import com.ibm.ivj.ejb.runtime.*;
import java.text.*;
import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
/**
 * Form-Bean 
 * "абонентские платежи".
 */
public class AbonentPayForm extends com.hps.july.web.util.EditForm {
	private int paypos;
	private boolean usenri;
	private StringAndSqlDateProperty date;
	private StringAndBigDecimalProperty rursum;
	private StringAndBigDecimalProperty usdsum;
	private StringAndBigDecimalProperty rate;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal nrirursum;
	private StringAndBigDecimalProperty nriusdsum;
	private StringAndBigDecimalProperty nriunrursum;
	private StringAndBigDecimalProperty nriunusdsum;
	private StringAndIntegerProperty resource;
	private String number;
	private boolean needpay;
	private java.lang.String recordstatus;
	private java.lang.String changeneedpay;
	private boolean initialNeedpay;
	//Ќазначение платежа:
	private String payPurpose = null;
		
public AbonentPayForm() {
	date = new StringAndSqlDateProperty();
	date = new StringAndSqlDateProperty();
	nrirursum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	nriusdsum = new StringAndBigDecimalProperty();
	nriunrursum = new StringAndBigDecimalProperty();
	nriunusdsum = new StringAndBigDecimalProperty();
	rursum = new StringAndBigDecimalProperty();
	usdsum = new StringAndBigDecimalProperty();
	rate = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	usenri = false;
	paypos = 0;
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	AbonentPaymentAccessBean pay = (AbonentPaymentAccessBean) bean;
	pay.setFlagworknri(false);
	pay.setByhand(isUsenri());
	pay.setSumnriusd(nriusdsum.getBigDecimal());
	pay.setSumnrirur(nrirursum.getBigDecimal());
	if (isUsenri()) {
		pay.setSumfreeusd(nriunusdsum.getBigDecimal());
		pay.setSumfreerur(nriunrursum.getBigDecimal());
	} else {
		pay.setSumfreeusd(null);
		pay.setSumfreerur(null);
	}

	if (getInitialNeedpay() != getNeedpay()) {
		pay.setChangeneedpay("H");
	}
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request) throws Exception {
	return null;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	try {
		AbonentPaymentAccessBean pay = (AbonentPaymentAccessBean) bean;
		usenri = pay.getByhand();
		setDate(pay.getPaydate());
		setNumber(pay.getPaynumber());
		setResource(pay.getResource());
		setRursum(pay.getSumpayrur());
		setUsdsum(pay.getSumpayusd());
		setNrirursum(pay.getSumnrirur());
		setNriusdsum(pay.getSumnriusd());
		setNriunrursum(pay.getSumfreerur());
		setNriunusdsum(pay.getSumfreeusd());
		setInitialNeedpay(pay.getNeedpay());
		try {
			rate.setBigDecimal(pay.getSumpayrur().divide(pay.getSumpayusd(),4,BigDecimal.ROUND_CEILING));
		} catch(Exception e) {
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 17:21:29)
 * @return java.lang.String
 */
public java.lang.String getChangeneedpay() {
	return changeneedpay;
}
public AbstractEntityAccessBean getDataBean(HttpServletRequest request) {
	AbonentPaymentAccessBean bean = new AbonentPaymentAccessBean();
	bean.setInitKey_paypos(getPaypos());
	return bean;
}
public java.sql.Date getDate() {
	return date.getSqlDate();
}
public String getDateFrm() {
	return date.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 17:27:33)
 * @return boolean
 */
public boolean getInitialNeedpay() {
	return initialNeedpay;
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2003 20:09:12)
 * @return boolean
 */
public boolean getNeedpay() {
	return needpay;
}
public BigDecimal getNrirursum() {
	return nrirursum.getBigDecimal();
}
public String getNrirursumFrm() {
	return nrirursum.getString();
}
public BigDecimal getNriunrursum() {
	return nriunrursum.getBigDecimal();
}
public String getNriunrursumFrm() {
	return nriunrursum.getString();
}
public BigDecimal getNriunusdsum() {
	return nriunusdsum.getBigDecimal();
}
public String getNriunusdsumFrm() {
	return nriunusdsum.getString();
}
public BigDecimal getNriusdsum() {
	return nriusdsum.getBigDecimal();
}
public String getNriusdsumFrm() {
	return nriusdsum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (07.02.2003 18:19:00)
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:42:41)
 * @return com.hps.july.persistence.OrganizationAccessBean
 */
public Organization getOrgCustomer() throws Exception {
	/*OrganizationAccessBean bean = constructCustomer();
	if (bean != null) {
		return (Organization) bean.getEJBRef();
	} else {*/
		return null;
	//}
}
/**
 * Insert the method's description here.
 * Creation date: (07.02.2003 13:44:16)
 * @return int
 */
public int getPaypos() {
	return paypos;
}
public BigDecimal getRate() {
	return rate.getBigDecimal();
}
public String getRateFrm() {
	return rate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2003 15:58:28)
 * @return java.lang.String
 */
public java.lang.String getRecordstatus() {
	return recordstatus;
}
public Integer getResource() {
	return resource.getInteger();
}
public String getResourceFrm() {
	return resource.getString();
}
public Enumeration getResources() {
	try {
		NamedValueAccessBean nvBean = new NamedValueAccessBean();
		nvBean.setInitKey_id("ARENDA_TYPE");
		nvBean.refreshCopyHelper();
		
		return new ResourceAccessBean().findResourceBySubtype(new ResourceSubTypeKey(nvBean.getIntvalue()));
	} catch(Exception e) {
		e.printStackTrace();
		return new Vector().elements();
	}
}
public BigDecimal getRursum() {
	return rursum.getBigDecimal();
}
public String getRursumFrm() {
	return rursum.getString();
}
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_PAY_EDIT;
}
public BigDecimal getUsdsum() {
	return usdsum.getBigDecimal();
}
public String getUsdsumFrm() {
	return usdsum.getString();
}
public boolean isUsenri() {
	return usenri;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 17:21:29)
 * @param newChangeneedpay java.lang.String
 */
public void setChangeneedpay(java.lang.String newChangeneedpay) {
	changeneedpay = newChangeneedpay;
}
public void setDate(java.sql.Date newDate)
{
	date.setSqlDate(newDate);
}
public void setDateFrm(String newDate)
{
	date.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 17:27:33)
 * @param newInitialNeedpay boolean
 */
public void setInitialNeedpay(boolean newInitialNeedpay) {
	initialNeedpay = newInitialNeedpay;
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2003 20:09:12)
 * @param newNeedpay boolean
 */
public void setNeedpay(boolean newNeedpay) {
	needpay = newNeedpay;
}
public void setNrirursum(BigDecimal newsum) {
	nrirursum.setBigDecimal(newsum);
}
public void setNrirursumFrm(String newsum) {
	nrirursum.setString(newsum);
}
public void setNriunrursum(BigDecimal newsum) {
	nriunrursum.setBigDecimal(newsum);
}
public void setNriunrursumFrm(String newsum) {
	nriunrursum.setString(newsum);
}
public void setNriunusdsum(BigDecimal newsum) {
	nriunusdsum.setBigDecimal(newsum);
}
public void setNriunusdsumFrm(String newsum) {
	nriunusdsum.setString(newsum);
}
public void setNriusdsum(BigDecimal newsum) {
	nriusdsum.setBigDecimal(newsum);
}
public void setNriusdsumFrm(String newsum) {
	nriusdsum.setString(newsum);
}
/**
 * Insert the method's description here.
 * Creation date: (07.02.2003 18:19:00)
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (07.02.2003 13:44:16)
 * @param newPaypos int
 */
public void setPaypos(int newPaypos) {
	paypos = newPaypos;
}
public void setRateFrm(String newrate) {
	rate.setString(newrate);
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2003 15:58:28)
 * @param newRecordstatus java.lang.String
 */
public void setRecordstatus(java.lang.String newRecordstatus) {
	recordstatus = newRecordstatus;
}
public void setResource(Integer newResource) {
	resource.setInteger(newResource);
}
public void setResourceFrm(String newResource) {
	resource.setString(newResource);
}
public void setRursum(BigDecimal newsum) {
	rursum.setBigDecimal(newsum);
}
public void setRursumFrm(String newsum) {
	rursum.setString(newsum);
}
public void setUsdsum(BigDecimal newsum) {
	usdsum.setBigDecimal(newsum);
}
public void setUsdsumFrm(String newsum) {
	usdsum.setString(newsum);
}
public void setUsenri(boolean newUsenri) {
	usenri = newUsenri;
}
public void validateValues(ActionErrors errors)	throws Exception {
	if (isUsenri()) {
		if (nrirursum.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.empty.nrirursum"));
		} else if (!nrirursum.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.invalid.nrirursum"));
		} else if (nrirursum.getBigDecimal().signum() < 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.invalid.nrirursum.negative"));
		}
		
		if (rursum.getBigDecimal() == null) {
			if (nriusdsum.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.empty.nriusdsum"));
			} else if (!nriusdsum.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.invalid.nriusdsum"));
			} else if (nriusdsum.getBigDecimal().signum() < 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.invalid.nriusdsum.negative"));
			}
			throw new ValidationException();
		}

		if(nrirursum.getBigDecimal().compareTo(rursum.getBigDecimal()) > 0){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.nri.sum.bigger2"));
		}
		
		if (nriunrursum.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.empty.nriunrursum"));
		} else if (!nriunrursum.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.invalid.nriunrursum"));
		}
		
		if (nriunusdsum.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.empty.nriunusdsum"));
		} else if(!nriunusdsum.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.invalid.nriunusdsum"));
		}
		
		if (!errors.empty()) {
			throw new ValidationException();
		}
		
		try {
			if (rursum.getBigDecimal() != null) {
				rate.setBigDecimal(rursum.getBigDecimal().divide(usdsum.getBigDecimal(), 4, BigDecimal.ROUND_HALF_UP));
				nriusdsum.setBigDecimal(nrirursum.getBigDecimal().divide(rate.getBigDecimal(), 2, BigDecimal.ROUND_HALF_UP));
				nriunrursum.setBigDecimal(rursum.getBigDecimal().subtract(nrirursum.getBigDecimal()));
			} else {
				nriunrursum.setBigDecimal(new BigDecimal("0.00").subtract(nrirursum.getBigDecimal()));
			}
			
			nriunusdsum.setBigDecimal(usdsum.getBigDecimal().subtract(nriusdsum.getBigDecimal()));
		} catch(Exception e) {
			e.printStackTrace(System.out);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.pays.calcerror"));
		}
		
		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
}
	/**
	 * @return
	 */
	public String getPayPurpose() {
		return payPurpose;
	}

	/**
	 * @param string
	 */
	public void setPayPurpose(String string) {
		payPurpose = string;
	}

}
