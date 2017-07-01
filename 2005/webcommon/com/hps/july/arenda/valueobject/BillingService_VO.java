package com.hps.july.arenda.valueobject;

import java.util.*;
import com.hps.july.cdbc.lib.*;
/**
* Bean-Wrapper "Справочник услуг связи"
* Creation date: (30.09.2004 12:01:07)
* @author: Shafigullin Ildar
*/
public class BillingService_VO {
	private java.lang.Integer idService; //код услуги
	private java.lang.String nameService; //наименование услуги
	private java.lang.String codeService; //код обозначение услуги в биллинге
	private java.lang.String useInNri;//признак использования в системе NRI(Y/N)
/**
 * NameService_VO constructor comment.
 */
public BillingService_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:08:01)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public BillingService_VO(CDBCRowObject ro) {
	idService = (Integer) ro.getColumn("idservice").asObject();
	setNameService(ro.getColumn("nameservice").asString());
	setCodeService(ro.getColumn("codeservice").asString());
	setUseInNri(ro.getColumn("useinnri").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 16:13:21)
 * @return java.lang.String
 */
public java.lang.String getCodeService() {
	return codeService;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 16:13:21)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdService() {
	return idService;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 16:13:21)
 * @return java.lang.String
 */
public java.lang.String getNameService() {
	return nameService;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:06:23)
 * @return java.lang.String
 */
public java.lang.String getUseInNri() {
	return useInNri;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 16:13:21)
 * @param newCodeService java.lang.String
 */
public void setCodeService(java.lang.String newCodeService) {
	codeService = newCodeService;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 16:13:21)
 * @param newIdService java.lang.Integer
 */
public void setIdService(java.lang.Integer newIdService) {
	idService = newIdService;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 16:13:21)
 * @param newNameService java.lang.String
 */
public void setNameService(java.lang.String newNameService) {
	nameService = newNameService;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:06:23)
 * @param newUseInNri java.lang.String
 */
public void setUseInNri(java.lang.String newUseInNri) {
	useInNri = newUseInNri;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:14:58)
 */
public String toString() {
	return "BillingService_VO: id=" + getIdService() + "; name=" + getNameService();
}
}
