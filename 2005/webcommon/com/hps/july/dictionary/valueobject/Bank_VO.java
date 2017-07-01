package com.hps.july.dictionary.valueobject;

import java.sql.*;
import java.math.*;
import com.hps.july.cdbc.lib.*;
/**
*  Контейнер банков.
* Creation date: (23.03.2005 13:51:17)
* @author: Shafigullin Ildar
*/
public class Bank_VO extends OrganizationVO{
	private java.lang.String bik;
	private java.lang.String koraccount;
/**
 * Bank_VO constructor comment.
 */
public Bank_VO(CDBCRowObject ro) {
	super((Integer)ro.getColumn("organization").asObject());
	setName(ro.getColumn("name").asString());
	setBik(ro.getColumn("bik").asString());
	setKoraccount(ro.getColumn("koraccount").asString());
	setTypeOrg(BankType);
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 14:55:07)
 * @return java.lang.String
 */
public java.lang.String getBik() {
	return bik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 14:56:57)
 * @return java.lang.String
 */
public java.lang.String getKoraccount() {
	return koraccount;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 14:55:07)
 * @param newBik java.lang.String
 */
public void setBik(java.lang.String newBik) {
	bik = newBik;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 14:56:57)
 * @param newKoraccount java.lang.String
 */
public void setKoraccount(java.lang.String newKoraccount) {
	koraccount = newKoraccount;
}
}
