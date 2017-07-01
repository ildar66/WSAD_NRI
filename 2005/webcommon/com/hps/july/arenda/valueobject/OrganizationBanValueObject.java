package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Контейнер "Справочник организаций+BAN"
 * Creation date: (03.10.2002 17:14:58)
 * @author: Sergey Gourov
 */
public class OrganizationBanValueObject {
	private com.hps.july.persistence.OrganizationAccessBean o;
	private java.lang.String bans;
/**
 * OrganizationBanValueObject constructor comment.
 */
public OrganizationBanValueObject(OrganizationAccessBean bean) {
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2002 17:18:42)
 * @return java.lang.String
 */
public java.lang.String getBans() {
	return bans;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2002 17:15:31)
 * @return com.hps.july.persistence.OrganizationAccessBean
 */
public com.hps.july.persistence.OrganizationAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2002 17:18:42)
 * @param newBans java.lang.String
 */
public void setBans(java.lang.String newBans) {
	bans = newBans;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2002 17:15:31)
 * @param newO com.hps.july.persistence.OrganizationAccessBean
 */
public void setO(com.hps.july.persistence.OrganizationAccessBean newO) {
	o = newO;
}
}
