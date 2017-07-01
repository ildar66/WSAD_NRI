package com.hps.july.arenda.valueobject;

import java.util.*;
import com.hps.july.cdbc.lib.*;
/**
* Bean-Wrapper "Справочник тарифных планов"
* Creation date: (30.09.2004 12:01:07)
* @author: Shafigullin Ildar
*/
public class TarifPlan_VO {
	private java.lang.Integer idTarifPlan; //код тарифного плана
	private java.lang.String nameTarifPlan; //наименование тарифного плана
	private java.lang.String codeTarifPlan; //обозначение тарифного плана
	private Date effective_date;//дата начала действия
	private java.util.Date expiration_date;//дата окончания действия
	private java.lang.String useInNri;//признак необходимости использования в NRI
/**
 * TarifPlan_VO constructor comment.
 */
public TarifPlan_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:08:01)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public TarifPlan_VO(CDBCRowObject ro) {
	idTarifPlan = (Integer) ro.getColumn("idtarifplan").asObject();
	setNameTarifPlan(ro.getColumn("nametarifplan").asString());
	setCodeTarifPlan(ro.getColumn("codetarifplan").asString());
	setEffective_date((Date) ro.getColumn("effective_date").asObject());
	setExpiration_date((Date) ro.getColumn("expiration_date").asObject());
	setUseInNri(ro.getColumn("useinnri").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:04:15)
 * @return java.lang.String
 */
public java.lang.String getCodeTarifPlan() {
	return codeTarifPlan;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:05:09)
 * @return java.util.Date
 */
public Date getEffective_date() {
	return effective_date;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:05:37)
 * @return java.util.Date
 */
public java.util.Date getExpiration_date() {
	return expiration_date;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:03:28)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdTarifPlan() {
	return idTarifPlan;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:03:55)
 * @return java.lang.String
 */
public java.lang.String getNameTarifPlan() {
	return nameTarifPlan;
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
 * Creation date: (30.09.2004 12:04:15)
 * @param newCodeTarifPlan java.lang.String
 */
public void setCodeTarifPlan(java.lang.String newCodeTarifPlan) {
	codeTarifPlan = newCodeTarifPlan;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:05:09)
 * @param newEffective_date java.util.Date
 */
public void setEffective_date(Date newEffective_date) {
	effective_date = newEffective_date;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:05:37)
 * @param newExpiration_date java.util.Date
 */
public void setExpiration_date(java.util.Date newExpiration_date) {
	expiration_date = newExpiration_date;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:03:28)
 * @param newIdTarifPlan java.lang.Integer
 */
public void setIdTarifPlan(java.lang.Integer newIdTarifPlan) {
	idTarifPlan = newIdTarifPlan;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2004 12:03:55)
 * @param newNameTarifPlan java.lang.String
 */
public void setNameTarifPlan(java.lang.String newNameTarifPlan) {
	nameTarifPlan = newNameTarifPlan;
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
	return "TarifPlan_VO: id=" + getIdTarifPlan() + "; name=" + getNameTarifPlan();
}
}
