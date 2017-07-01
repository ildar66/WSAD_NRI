package com.hps.july.arenda.valueobject;

import java.math.*;
import com.hps.july.cdbc.lib.*;
import java.sql.Timestamp;
/**
*  онтейнер дл€ строк таблицы:nfs_sf "—чета фактуры предоплаты из NFS"
* Creation date: (02.06.2004 16:12:51)
* @author: Shafigullin Ildar
*/
public class NFS_SchetFakt_VO {
	private java.lang.Integer idSfNfs; //уникальный код с_ф
	private java.lang.String numSf; //номер с_ф
	private java.lang.String stateSf; //состо€ние счет фактуры
	private BigDecimal sumSf; //сумма —‘
	private java.lang.String currSf; //валюта
	private NFS_ZP_VO zpNFS; //ссылка на "«аказы на приобретение"
	private Timestamp dateCreate; //дата создани€
	private java.math.BigDecimal nds; //ндс 
	private java.math.BigDecimal taxRate; //ставка ндс
	private NFS_VendorSite_VO recipient; //получатель платежа
	private NFS_Account_VO account; //счет
	private NFS_Vendor_VO vendor;
	private NFS_VendorSite_VO site;
	private java.lang.String status;//статус записи(удалена или активна?)
	private java.lang.Integer idorgnfs;
	private java.sql.Timestamp datecreate;
	private java.sql.Timestamp datemodify;
	private String userCreate;
	private String userModify;	
/**
 * NFS_SchetFakt_VO constructor comment.
 */
public NFS_SchetFakt_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 17:31:13)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public NFS_SchetFakt_VO(CDBCRowObject ro) {
	idSfNfs = (Integer) ro.getColumn("idsfnfs").asObject();
	setNumSf(ro.getColumn("numsf").asString());
	setSumSf((BigDecimal) ro.getColumn("sumsf").asObject());
	setCurrSf(ro.getColumn("currsf").asString());
	setStateSf(ro.getColumn("statesf").asString());
	setDateCreate((Timestamp)ro.getColumn("sfdatecreate").asObject());
	setStatus(ro.getColumn("statussf").asString());
	setIdorgnfs((Integer)ro.getColumn("idorgnfs_sf").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 16:59:14)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public void calcNds(CDBCRowObject ro) {
	setNds((BigDecimal)ro.getColumn("ndssf").asObject());
	setTaxRate((BigDecimal)ro.getColumn("taxratesf").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 18:03:39)
 * @return com.hps.july.arenda.valueobject.NFS_Account_VO
 */
public NFS_Account_VO getAccount() {
	return account;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:19:08)
 * @return java.lang.String
 */
public java.lang.String getCurrSf() {
	return currSf;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:58:19)
 * @return java.sql.Date
 */
public java.sql.Timestamp getDatecreate() {
	return datecreate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 16:22:28)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getDateCreate() {
	return dateCreate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 17:06:14)
 * @return java.sql.Date
 */
public java.sql.Timestamp getDatemodify() {
	return datemodify;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 12:14:07)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdorgnfs() {
	return idorgnfs;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:14:43)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdSfNfs() {
	return idSfNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:01:48)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNds() {
	return nds;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:16:05)
 * @return java.lang.String
 */
public java.lang.String getNumSf() {
	return numSf;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:12:08)
 * @return com.hps.july.arenda.valueobject.NFS_VendorSite_VO
 */
public NFS_VendorSite_VO getRecipient() {
	return recipient;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2004 10:46:04)
 * @return com.hps.july.arenda.valueobject.NFS_VendorSite_VO
 */
public NFS_VendorSite_VO getSite() {
	return site;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:17:15)
 * @return java.lang.String
 */
public java.lang.String getStateSf() {
	return stateSf;
}
/**
 * Insert the method's description here.
 * Creation date: (12.01.2005 14:48:18)
 * @return java.lang.String
 */
public java.lang.String getStatus() {
	return status;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:18:09)
 * @return java.math.BigDecimal
 */
public BigDecimal getSumSf() {
	return sumSf;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:05:31)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getTaxRate() {
	return taxRate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2004 10:46:04)
 * @return com.hps.july.arenda.valueobject.NFS_Vendor_VO
 */
public NFS_Vendor_VO getVendor() {
	return vendor;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 17:11:48)
 * @return com.hps.july.arenda.valueobject.NFS_ZP_VO
 */
public NFS_ZP_VO getZpNFS() {
	return zpNFS;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 18:03:39)
 * @param ro CDBCRowObject
 */
public void initAccount(CDBCRowObject ro) {
	if (ro.getColumn("idaccnfs").asObject() != null) {
		//init account:
		String idAccNfs = ro.getColumn("idaccnfs").asString();
		String idVendorSiteNfs = ro.getColumn("idvendorsitenfs").asString();
		NFS_Account_VO.NFS_Account_PK pk = new NFS_Account_VO.NFS_Account_PK(idAccNfs, idVendorSiteNfs);
		String accountNum = ro.getColumn("accountnumsf").asString();
		account = new NFS_Account_VO(pk, accountNum);
		//init BANK for account:
		String nameBankSf = ro.getColumn("namebanksf").asString();
		String corrAccBankSf = ro.getColumn("corraccbanksf").asString();
		String bikBankSf = ro.getColumn("bikbanksf").asString();
		NFS_Bank_VO bank = new NFS_Bank_VO(null, nameBankSf, bikBankSf, corrAccBankSf);
		account.setBank(bank);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:12:08)
 * @param ro CDBCRowObject 
 */
public void initRecipient(CDBCRowObject ro) {
	if (ro.getColumn("idsite3sf").asObject() != null) {
		Integer id = (Integer) ro.getColumn("idsite3sf").asObject();
		String name = ro.getColumn("recipientsf").asString();
		//String inn = ro.getColumn("kpp").asString();
		//String code = ro.getColumn("codesite").asString();
		recipient = new NFS_VendorSite_VO(id, name, null, null);
	} else if (ro.getColumn("idsitesf").asObject() != null) {
		Integer id = (Integer) ro.getColumn("idsitesf").asObject();
		String name = ro.getColumn("recipientsf").asString();
		//String inn = ro.getColumn("kpp").asString();
		//String code = ro.getColumn("codesite").asString();
		recipient = new NFS_VendorSite_VO(id, name, null, null);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 14:16:11)
 * @param newSite com.hps.july.arenda.valueobject.NFS_VendorSite_VO
 */
public void initSite(CDBCRowObject ro) {
	if (ro.getColumn("vendorsiteid").asObject() != null) {
		Integer id = (Integer) ro.getColumn("vendorsiteid").asObject();
		String name = ro.getColumn("namesite").asString();
		String kpp = ro.getColumn("kpp").asString();
		String code = ro.getColumn("codesite").asString();
		site = new NFS_VendorSite_VO(id, name, kpp, code);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 13:08:44)
 * @param newVendor com.hps.july.arenda.valueobject.NFS_Vendor_VO
 */
public void initVendor(CDBCRowObject ro) {
	if (ro.getColumn("vendorid_sf").asObject() != null) {
		Integer id = (Integer)ro.getColumn("vendorid_sf").asObject();
		String name = ro.getColumn("namevendor_sf").asString();
		String inn = ro.getColumn("innvendor_sf").asString();
		vendor = new NFS_Vendor_VO(id, name, inn);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 17:36:07)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public void initZpNFS(CDBCRowObject ro) {
	if (ro.getColumn("idzpnfs").asObject() != null) {
		zpNFS = new NFS_ZP_VO(ro);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:19:08)
 * @param newCurrSf java.lang.String
 */
public void setCurrSf(java.lang.String newCurrSf) {
	currSf = newCurrSf;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:58:19)
 * @param newDatecreate java.sql.Date
 */
public void setDatecreate(java.sql.Timestamp newDatecreate) {
	datecreate = newDatecreate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 16:22:28)
 * @param newDateCreate java.sql.Timestamp
 */
public void setDateCreate(java.sql.Timestamp newDateCreate) {
	dateCreate = newDateCreate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 17:06:14)
 * @param newDatemodify java.sql.Date
 */
public void setDatemodify(java.sql.Timestamp newDatemodify) {
	datemodify = newDatemodify;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 12:14:07)
 * @param newIdorgnfs java.lang.Integer
 */
public void setIdorgnfs(java.lang.Integer newIdorgnfs) {
	idorgnfs = newIdorgnfs;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:01:48)
 * @param newNds java.math.BigDecimal
 */
public void setNds(java.math.BigDecimal newNds) {
	nds = newNds;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:16:05)
 * @param newNumSf java.lang.String
 */
public void setNumSf(java.lang.String newNumSf) {
	numSf = newNumSf;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2004 10:46:04)
 * @param newSite com.hps.july.arenda.valueobject.NFS_VendorSite_VO
 */
public void setSite(NFS_VendorSite_VO newSite) {
	site = newSite;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:17:15)
 * @param newStateSf java.lang.String
 */
public void setStateSf(java.lang.String newStateSf) {
	stateSf = newStateSf;
}
/**
 * Insert the method's description here.
 * Creation date: (12.01.2005 14:48:18)
 * @param newStatus java.lang.String
 */
public void setStatus(java.lang.String newStatus) {
	status = newStatus;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:18:09)
 * @param newSumSf java.math.BigDecimal
 */
public void setSumSf(BigDecimal newSumSf) {
	sumSf = newSumSf;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 17:05:31)
 * @param newTaxRate java.math.BigDecimal
 */
public void setTaxRate(java.math.BigDecimal newTaxRate) {
	taxRate = newTaxRate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2004 10:46:04)
 * @param newVendor com.hps.july.arenda.valueobject.NFS_Vendor_VO
 */
public void setVendor(NFS_Vendor_VO newVendor) {
	vendor = newVendor;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "SchetFakt: id=" + idSfNfs + "; Num= " + getNumSf() + "; dateCreate: " + getDateCreate();
}
/**
 *  то создал,изменил(когда).
 * Creation date: (11.06.2004 13:08:44)
 * @param newVendor com.hps.july.arenda.valueobject.NFS_Vendor_VO
 */
public void initDomainInfo(CDBCRowObject ro) {
	setUserCreate(ro.getColumn("userCreate").asString());
	setUserModify(ro.getColumn("userModify").asString());
	setDatecreate((java.sql.Timestamp)ro.getColumn("datecreate").asObject());
	setDatemodify((java.sql.Timestamp)ro.getColumn("datemodify").asObject());
}
	/**
	 * @return
	 */
	public String getUserCreate() {
		return userCreate;
	}

	/**
	 * @return
	 */
	public String getUserModify() {
		return userModify;
	}

	/**
	 * @param string
	 */
	public void setUserCreate(String string) {
		userCreate = string;
	}

	/**
	 * @param string
	 */
	public void setUserModify(String string) {
		userModify = string;
	}

}
