package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
import com.hps.july.cdbc.lib.*;
/**
*  онтейнер дл€ строк таблицы:nfs_pays "ѕлатежи из системы NFS"
* Creation date: (02.06.2004 16:30:32)
* @author: Shafigullin Ildar
*/
public class NFS_Pay_VO {
	private java.lang.Integer idPayNfs; //уникальный код платежа
	private java.lang.Integer numPay; //номер платежа
	private Date datePay; //дата платежа
	private java.lang.String statePay; //состо€ние платежа
	private BigDecimal sumPay; // сумма платежа
	private java.lang.String currPay; //валюта
	private java.math.BigDecimal sumRubPay; //сумма в рубл€х платежа
	private java.lang.String purpose; //назначение платежа
	private NFS_SchetFakt_VO sfNFS; //ссылка на с_ф
	private java.lang.Boolean lnkPayNfs; //признак св€зи с платежом NRI
	private NFS_VendorSite_VO recipient; //получатель платежа
	private java.math.BigDecimal sumNdsRub; //сумма ндс в руб.
	private NFS_Account_VO account; //счет
	private java.lang.String status;//статус записи(удалена или активна?)
	private java.sql.Date datecreate;
	private java.sql.Date datemodify;
/**
 * NFS_Pay_VO constructor comment.
 */
public NFS_Pay_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 17:49:10)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public NFS_Pay_VO(CDBCRowObject ro) {
	idPayNfs = (Integer) ro.getColumn("idpaynfs").asObject();
	setNumPay((Integer)ro.getColumn("numpay").asObject());
	setSumPay((BigDecimal) ro.getColumn("sumpay").asObject());
	setSumRubPay((BigDecimal) ro.getColumn("sumrubpay").asObject());
	setCurrPay(ro.getColumn("currpay").asString());
	setStatePay(ro.getColumn("statepay").asString());
	setPurpose(ro.getColumn("purpose").asString());
	setDatePay((Date)ro.getColumn("datepay").asObject());
	initLnkPayNfs(ro);
	setStatus(ro.getColumn("statuspay").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 16:59:14)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public void calcNds(CDBCRowObject ro) {
	setSumNdsRub((BigDecimal)ro.getColumn("sumndsrubpay").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 13:10:41)
 * @return com.hps.july.arenda.valueobject.NFS_Account_VO
 */
public NFS_Account_VO getAccount() {
	return account;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:38:24)
 * @return java.lang.String
 */
public java.lang.String getCurrPay() {
	return currPay;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:58:46)
 * @return java.sql.Date
 */
public java.sql.Date getDatecreate() {
	return datecreate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:59:52)
 * @return java.sql.Date
 */
public java.sql.Date getDatemodify() {
	return datemodify;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:35:12)
 * @return java.sql.Date
 */
public Date getDatePay() {
	return datePay;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:31:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdPayNfs() {
	return idPayNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2004 12:01:24)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getLnkPayNfs() {
	return lnkPayNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:34:21)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumPay() {
	return numPay;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:40:05)
 * @return java.lang.String
 */
public java.lang.String getPurpose() {
	return purpose;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 12:38:04)
 * @return com.hps.july.arenda.valueobject.NFS_VendorSite_VO
 */
public NFS_VendorSite_VO getRecipient() {
	return recipient;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 17:09:50)
 * @return com.hps.july.arenda.valueobject.NFS_SchetFakt_VO
 */
public NFS_SchetFakt_VO getSfNFS() {
	return sfNFS;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:36:04)
 * @return java.lang.String
 */
public java.lang.String getStatePay() {
	return statePay;
}
/**
 * Insert the method's description here.
 * Creation date: (12.01.2005 14:44:37)
 * @return java.lang.String
 */
public java.lang.String getStatus() {
	return status;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 12:46:23)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumNdsRub() {
	return sumNdsRub;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:37:24)
 * @return java.math.BigDecimal
 */
public BigDecimal getSumPay() {
	return sumPay;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:39:12)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumRubPay() {
	return sumRubPay;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 13:10:41)
 * @param newAccount com.hps.july.arenda.valueobject.NFS_Account_VO
 */
public void initAccount(CDBCRowObject ro) {
	if (ro.getColumn("idaccountrecipient").asObject() != null) {
		//init account:
		String idAccountRecipient = ro.getColumn("idaccountrecipient").asString();
		String idVendorSiteNfs = ro.getColumn("idvendorsitenfs").asString();
		NFS_Account_VO.NFS_Account_PK pk = new NFS_Account_VO.NFS_Account_PK(idAccountRecipient, idVendorSiteNfs);
		String accountNum = ro.getColumn("accountnumpay").asString();
		account = new NFS_Account_VO(pk, accountNum);
		//init BANK for account:
		String nameBankPay = ro.getColumn("namebankpay").asString();
		String corrAccBankPay = ro.getColumn("corraccbankpay").asString();
		String bikBankPay = ro.getColumn("bikbankpay").asString();
		NFS_Bank_VO bank = new NFS_Bank_VO(null, nameBankPay, bikBankPay, corrAccBankPay);
		account.setBank(bank);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2004 12:34:01)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initLnkPayNfs(CDBCRowObject ro) {
	String lnkPayNfsStr = ro.getColumn("islnkpaynfs").asString();
	if (lnkPayNfsStr.equalsIgnoreCase("Y")) {
		setLnkPayNfs(Boolean.TRUE);
	} else {
		setLnkPayNfs(Boolean.FALSE);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 12:38:04)
 * @param ro CDBCRowObject
 */
public void initRecipient(CDBCRowObject ro) {
	if (ro.getColumn("idsitepay").asObject() != null) {
		Integer id = (Integer) ro.getColumn("idsitepay").asObject();
		String name = ro.getColumn("recipientpay").asString();
		//String inn = ro.getColumn("kpp").asString();
		//String code = ro.getColumn("codesite").asString();
		recipient = new NFS_VendorSite_VO(id, name, null, null);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 18:00:26)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public void initSfNFS(CDBCRowObject ro) {
	if (ro.getColumn("idsfnfs").asObject() != null) {
		sfNFS = new NFS_SchetFakt_VO(ro);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:38:24)
 * @param newCurrPay java.lang.String
 */
public void setCurrPay(java.lang.String newCurrPay) {
	currPay = newCurrPay;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:58:46)
 * @param newDatecreate java.sql.Date
 */
public void setDatecreate(java.sql.Date newDatecreate) {
	datecreate = newDatecreate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:59:52)
 * @param newDatemodify java.sql.Date
 */
public void setDatemodify(java.sql.Date newDatemodify) {
	datemodify = newDatemodify;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:35:12)
 * @param newDatePay java.sql.Date
 */
public void setDatePay(Date newDatePay) {
	datePay = newDatePay;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2004 12:01:24)
 * @param newLnkPayNfs java.lang.Boolean
 */
public void setLnkPayNfs(java.lang.Boolean newLnkPayNfs) {
	lnkPayNfs = newLnkPayNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:34:21)
 * @param newNumPay java.lang.Integer
 */
public void setNumPay(java.lang.Integer newNumPay) {
	numPay = newNumPay;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:40:05)
 * @param newPurpose java.lang.String
 */
public void setPurpose(java.lang.String newPurpose) {
	purpose = newPurpose;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:36:04)
 * @param newStatePay java.lang.String
 */
public void setStatePay(java.lang.String newStatePay) {
	statePay = newStatePay;
}
/**
 * Insert the method's description here.
 * Creation date: (12.01.2005 14:44:37)
 * @param newStatus java.lang.String
 */
public void setStatus(java.lang.String newStatus) {
	status = newStatus;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 12:46:23)
 * @param newSumNdsRub java.math.BigDecimal
 */
public void setSumNdsRub(java.math.BigDecimal newSumNdsRub) {
	sumNdsRub = newSumNdsRub;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:37:24)
 * @param newSumPay java.math.BigDecimal
 */
public void setSumPay(BigDecimal newSumPay) {
	sumPay = newSumPay;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:39:12)
 * @param newSumRubPay java.math.BigDecimal
 */
public void setSumRubPay(java.math.BigDecimal newSumRubPay) {
	sumRubPay = newSumRubPay;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "Pay: id=" + idPayNfs + "; Num= " + getNumPay();
}
}
