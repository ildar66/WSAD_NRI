package com.hps.july.arenda.valueobject;

import com.hps.july.cdbc.lib.*;
import java.util.*;
/**
* Контейнер NFS.
* Creation date: (02.06.2004 15:53:59)
* @author: Shafigullin Ildar
*/
public class NFS_VO {
	private NFS_Pay_VO payNFS;
	private NFS_ZP_VO zpNFS;
	private NFS_SchetFakt_VO schetFaktNFS;
	private NFS_Contract_VO contractNFS;
	private Map params;
/**
 * NFS_VO constructor comment.
 */
public NFS_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 18:07:26)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public NFS_VO(CDBCRowObject ro) {
	initPayNFS(ro);
	initSchetFaktNFS(ro);
	initZpNFS(ro);
	initContractNFS(ro);
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 15:26:43)
 * @return com.hps.july.arenda.valueobject.NFS_Contract_VO
 */
public NFS_Contract_VO getContractNFS() {
	return contractNFS;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2004 17:15:07)
 * @return java.util.Map
 */
public Map getParams() {
	params = new HashMap();
	if (getZpNFS() != null) {
		params.put("idZpNfs", getZpNFS().getIdZpNfs());
	}
	if (getContractNFS() != null) {
		params.put("idContractNfs", getContractNFS().getIdContractNfs());
	}
	if (getSchetFaktNFS() != null) {
		params.put("idSchetFaktNfs", getSchetFaktNFS().getIdSfNfs());
	}
	if (getPayNFS() != null) {
		params.put("idPayNfs", getPayNFS().getIdPayNfs());
	}
	return params;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 18:11:16)
 * @return com.hps.july.arenda.valueobject.NFS_Pay_VO
 */
public NFS_Pay_VO getPayNFS() {
	return payNFS;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 11:14:10)
 * @return com.hps.july.arenda.valueobject.NFS_SchetFakt_VO
 */
public NFS_SchetFakt_VO getSchetFaktNFS() {
	return schetFaktNFS;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 11:09:53)
 * @return com.hps.july.arenda.valueobject.NFS_ZP_VO
 */
public NFS_ZP_VO getZpNFS() {
	return zpNFS;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 15:25:06)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initContractNFS(CDBCRowObject ro) {
	if (ro.getColumn("idcontractnfs").asObject() != null) {
		contractNFS = new NFS_Contract_VO(ro);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2004 18:13:09)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initPayNFS(CDBCRowObject ro) {
	if (ro.getColumn("idpaynfs").asObject() != null) {
		payNFS = new NFS_Pay_VO(ro);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 11:15:42)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initSchetFaktNFS(CDBCRowObject ro) {
	if (ro.getColumn("idsfnfs").asObject() != null) {
		schetFaktNFS = new NFS_SchetFakt_VO(ro);
		schetFaktNFS.initVendor(ro);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 11:11:32)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initZpNFS(CDBCRowObject ro) {
	if (ro.getColumn("idzpnfs").asObject() != null) {
		zpNFS = new NFS_ZP_VO(ro);
		zpNFS.initVendor(ro);
	}
}
/**
*Если одно из составляющих (счет-фактура или платеж или зп) имеет статус-удален, то возвращает false.
* Creation date: (12.01.2005 16:39:51)
* @return boolean
*/
public boolean isActiveRecord() {
    boolean activeRecord = true;
    if ((getPayNFS() != null) && getPayNFS().getStatus().equalsIgnoreCase("D"))
        activeRecord = false;
    if ((getSchetFaktNFS() != null) && getSchetFaktNFS().getStatus().equalsIgnoreCase("D"))
        activeRecord = false;
    if ((getZpNFS() != null) && getZpNFS().getStatus().equalsIgnoreCase("D"))
        activeRecord = false;
    return activeRecord;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	// This implementation forwards the message to super. You may replace or supplement this.
	return super.toString();
}
}
