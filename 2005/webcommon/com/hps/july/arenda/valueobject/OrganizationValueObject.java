package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Контейнер "организаций+счет"
 * Creation date: (30.09.2002 18:00:19)
 * @author: Sergey Gourov
 */
public class OrganizationValueObject {
	private com.hps.july.persistence.OrganizationAccessBean o;
	private com.hps.july.persistence.AccountAccessBean account;
/**
 * OrganizationValueObject constructor comment.
 */
public OrganizationValueObject(OrganizationAccessBean bean) {
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 18:09:24)
 * @return com.hps.july.persistence.AccountAccessBean
 */
public com.hps.july.persistence.AccountAccessBean getAccount() {
	return account;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 18:06:23)
 * @return com.hps.july.persistence.OrganizationAccessBean
 */
public com.hps.july.persistence.OrganizationAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 18:09:24)
 * @param newAccount com.hps.july.persistence.AccountAccessBean
 */
public void setAccount(com.hps.july.persistence.AccountAccessBean newAccount) {
	account = newAccount;
}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 18:06:23)
 * @param newO com.hps.july.persistence.OrganizationAccessBean
 */
public void setO(com.hps.july.persistence.OrganizationAccessBean newO) {
	o = newO;
}
}
