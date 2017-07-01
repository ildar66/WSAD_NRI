package com.hps.july.arenda.valueobject;

import java.math.*;
import com.hps.july.cdbc.lib.*;
/**
* Контейнер для строк таблицы:nfs_zp "Заказы на приобретение NFS"
* Creation date: (02.06.2004 15:54:52)
* @author: Shafigullin Ildar
*/
public class NFS_ZP_VO {
	private java.lang.Integer idZpNfs; //уникальный код ЗП
	private java.lang.String numZp; //номер ЗП
	private BigDecimal sumZp; //сумма ЗП
	private java.lang.String currZp; //валюта
	private java.lang.String stateZp; //состояние заказа на покупку
	private java.math.BigDecimal ndsZp;//ндс ЗП
	private NFS_Vendor_VO vendor;
	private NFS_VendorSite_VO site;
	private java.lang.String status;//статус записи(удалена или активна?)
	private java.lang.Integer idorgnfs;
	private java.sql.Timestamp datemodify;
	private java.sql.Timestamp datecreate;
	private NFS_Contract_VO contract;
	private String userCreate;
	private String userModify;
/**
 * NFS_ZP_VO constructor comment.
 */
public NFS_ZP_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 17:17:53)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public NFS_ZP_VO(CDBCRowObject ro) {
    idZpNfs = (Integer) ro.getColumn("idzpnfs").asObject();
    setNumZp(ro.getColumn("numzp").asString());
    setSumZp((BigDecimal) ro.getColumn("sumzp").asObject());
    setNdsZp((BigDecimal) ro.getColumn("ndszp").asObject());
    setCurrZp(ro.getColumn("currzp").asString());
    setStateZp(ro.getColumn("statezp").asString());
    setStatus(ro.getColumn("statuszp").asString());
    setIdorgnfs((Integer)ro.getColumn("idorgnfs_zp").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 14:53:37)
 * @return com.hps.july.arenda.valueobject.NFS_Contract_VO
 */
public NFS_Contract_VO getContract() {
	return contract;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:07:20)
 * @return java.lang.String
 */
public java.lang.String getCurrZp() {
	return currZp;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:57:33)
 * @return java.sql.Date
 */
public java.sql.Timestamp getDatecreate() {
	return datecreate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:56:56)
 * @return java.sql.Date
 */
public java.sql.Timestamp getDatemodify() {
	return datemodify;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 12:14:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdorgnfs() {
	return idorgnfs;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 15:58:20)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdZpNfs() {
	return idZpNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 12:45:42)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNdsZp() {
	return ndsZp;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:00:54)
 * @return java.lang.String
 */
public java.lang.String getNumZp() {
	return numZp;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 14:16:11)
 * @return com.hps.july.arenda.valueobject.NFS_VendorSite_VO
 */
public NFS_VendorSite_VO getSite() {
	return site;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:08:29)
 * @return java.lang.String
 */
public java.lang.String getStateZp() {
	return stateZp;
}
/**
 * Insert the method's description here.
 * Creation date: (12.01.2005 14:50:10)
 * @return java.lang.String
 */
public java.lang.String getStatus() {
	return status;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:04:24)
 * @return java.math.BigDecimal
 */
public BigDecimal getSumZp() {
	return sumZp;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 13:08:44)
 * @return com.hps.july.arenda.valueobject.NFS_Vendor_VO
 */
public NFS_Vendor_VO getVendor() {
	return vendor;
}
/**
 * Insert the method's description here.
 * Creation date: (04.05.2005 14:53:37)
 * @param  ro CDBCRowObject
 */
public void initContract(CDBCRowObject ro) {
	contract = new NFS_Contract_VO(ro);
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
	if (ro.getColumn("vendorid_zp").asObject() != null) {
		Integer id = (Integer)ro.getColumn("vendorid_zp").asObject();
		String name = ro.getColumn("namevendor_zp").asString();
		String inn = ro.getColumn("innvendor_zp").asString();
		vendor = new NFS_Vendor_VO(id, name, inn);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:07:20)
 * @param newCurrZp java.lang.String
 */
public void setCurrZp(java.lang.String newCurrZp) {
	currZp = newCurrZp;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:57:33)
 * @param newDatecreate java.sql.Date
 */
public void setDatecreate(java.sql.Timestamp newDatecreate) {
	datecreate = newDatecreate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 16:56:56)
 * @param newDatemodify java.sql.Date
 */
public void setDatemodify(java.sql.Timestamp newDatemodify) {
	datemodify = newDatemodify;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 12:14:38)
 * @param newIdorgnfs java.lang.Integer
 */
public void setIdorgnfs(java.lang.Integer newIdorgnfs) {
	idorgnfs = newIdorgnfs;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 12:45:42)
 * @param newNdsZp java.math.BigDecimal
 */
public void setNdsZp(java.math.BigDecimal newNdsZp) {
	ndsZp = newNdsZp;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:00:54)
 * @param newNumZp java.lang.String
 */
public void setNumZp(java.lang.String newNumZp) {
	numZp = newNumZp;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:08:29)
 * @param newStateZp java.lang.String
 */
public void setStateZp(java.lang.String newStateZp) {
	stateZp = newStateZp;
}
/**
 * Insert the method's description here.
 * Creation date: (12.01.2005 14:50:10)
 * @param newStatus java.lang.String
 */
public void setStatus(java.lang.String newStatus) {
	status = newStatus;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 16:04:24)
 * @param newSumZp java.math.BigDecimal
 */
public void setSumZp(BigDecimal newSumZp) {
	sumZp = newSumZp;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	// This implementation forwards the message to super. You may replace or supplement this.
	return "Zp: id=" + idZpNfs + "; Num= " + getNumZp();
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
	/**
	 * Кто создал,изменил(когда).
	 * Creation date: (11.06.2004 13:08:44)
	 * @param newVendor com.hps.july.arenda.valueobject.NFS_Vendor_VO
	 */
	public void initDomainInfo(CDBCRowObject ro) {
		setUserCreate(ro.getColumn("userCreate").asString());
		setUserModify(ro.getColumn("userModify").asString());
		setDatecreate((java.sql.Timestamp)ro.getColumn("datecreate").asObject());
		setDatemodify((java.sql.Timestamp)ro.getColumn("datemodify").asObject());
	}
}
