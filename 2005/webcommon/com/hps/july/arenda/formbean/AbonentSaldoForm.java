package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
/**
 * Form-Bean 
 * "Ñאכüהמ ןמ המדמגמנאל"
 * Creation date: (15.04.2003 12:44:52)
 * @author: Sergey Gourov
 */
public class AbonentSaldoForm extends SaldoForm {
/**
 * AbonentSaldoForm constructor comment.
 */
public AbonentSaldoForm() {
	listForm = "AbonentSaldoListForm";
}
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();

		return new ResourceAccessBean().findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:09:52)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_SALDO_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setSalDate(null);
	setSum2Zero();
}
}
