package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Контейнер "Оплаты"
 * Creation date: (07.10.2002 15:43:07)
 * @author: Sergey Gourov
 */
public class LeasePaymentValueObject {
	private com.hps.july.persistence.LeasePaymentAccessBean o;
	private java.lang.String pptype;
	private com.hps.july.persistence.AccountAccessBean orgAcc;
	private java.lang.String payPurpose;
	private java.sql.Date billDate;
	private java.lang.String billNumber;
	private com.hps.july.persistence.OrganizationNfsAccessBean orgExecutor;
	private java.math.BigDecimal rate;
	private java.lang.String numpayplatinum;
/**
 * LeasePaymentValueObject constructor comment.
 * @param bean com.hps.july.persistence.OrganizationNfsAccessBean
 */
public LeasePaymentValueObject(LeasePaymentAccessBean bean) {
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:13:17)
 * @return java.sql.Date
 */
public java.sql.Date getBillDate() {
	return billDate;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:13:45)
 * @return java.lang.String
 */
public java.lang.String getBillNumber() {
	return billNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2003 10:22:34)
 * @return java.lang.String
 */
public java.lang.String getNumpayplatinum() {
	return numpayplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 15:44:37)
 * @return com.hps.july.persistence.LeasePaymentAccessBean
 */
public com.hps.july.persistence.LeasePaymentAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:08:03)
 * @return com.hps.july.persistence.AccountAccessBean
 */
public com.hps.july.persistence.AccountAccessBean getOrgAcc() {
	return orgAcc;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:45:45)
 * @return com.hps.july.persistence.OrganizationNfsAccessBean
 */
public com.hps.july.persistence.OrganizationNfsAccessBean getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:10:53)
 * @return java.lang.String
 */
public java.lang.String getPayPurpose() {
	return payPurpose;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 15:46:14)
 * @return java.lang.String
 */
public java.lang.String getPptype() {
	return pptype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 18:05:34)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRate() {
	return rate;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:13:17)
 * @param newBillDate java.sql.Date
 */
public void setBillDate(java.sql.Date newBillDate) {
	billDate = newBillDate;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:13:45)
 * @param newBillNumber java.lang.String
 */
public void setBillNumber(java.lang.String newBillNumber) {
	billNumber = newBillNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2003 10:22:34)
 * @param newNumpayplatinum java.lang.String
 */
public void setNumpayplatinum(java.lang.String newNumpayplatinum) {
	numpayplatinum = newNumpayplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 15:44:37)
 * @param newO com.hps.july.persistence.LeasePaymentAccessBean
 */
public void setO(com.hps.july.persistence.LeasePaymentAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:08:03)
 * @param newOrgAcc com.hps.july.persistence.AccountAccessBean
 */
public void setOrgAcc(com.hps.july.persistence.AccountAccessBean newOrgAcc) {
	orgAcc = newOrgAcc;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:45:45)
 * @param newOrgExecutor com.hps.july.persistence.OrganizationNfsAccessBean
 */
public void setOrgExecutor(com.hps.july.persistence.OrganizationNfsAccessBean newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 10:10:53)
 * @param newPayPurpose java.lang.String
 */
public void setPayPurpose(java.lang.String newPayPurpose) {
	payPurpose = newPayPurpose;
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 15:46:14)
 * @param newPptype java.lang.String
 */
public void setPptype(java.lang.String newPptype) {
	pptype = newPptype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 18:05:34)
 * @param newRate java.math.BigDecimal
 */
public void setRate(java.math.BigDecimal newRate) {
	rate = newRate;
}
}
