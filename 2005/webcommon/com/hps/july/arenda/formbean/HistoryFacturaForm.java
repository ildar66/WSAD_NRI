package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
/**
 * "История фактуры"(лист)
 * Form-Bean.
 * Creation date: (18.05.2003 15:59:09)
 * @author: Sergey Gourov
 */
public class HistoryFacturaForm extends FacturaForm {
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	request.getSession().setAttribute("historySchetFact", new Integer(getSchetFact()));
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2003 14:37:54)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_FACTURA_EDIT;
}
}
