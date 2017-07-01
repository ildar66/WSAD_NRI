package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (21.01.2003 12:07:55)
 * @author: Sergey Gourov
 */
public class LeaseSaldoAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * LeaseSaldoAccessBeanBeanInfo constructor comment.
 */
public LeaseSaldoAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors() {
	System.out.println("!!!!!!!!!! Called LeaseSaldoAccessBeanBeanInfo !!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[18];
	
	try {
		pd [0] = new PropertyDescriptor("act", LeaseSaldoAccessBean.class, "getAct", null);
		pd [1] = new PropertyDescriptor("additionalcurrency", LeaseSaldoAccessBean.class, "getAdditionalcurrency", null);
		pd [2] = new PropertyDescriptor("additionalndssum", LeaseSaldoAccessBean.class);
		pd [3] = new PropertyDescriptor("additionalsum", LeaseSaldoAccessBean.class);
		pd [4] = new PropertyDescriptor("istemp", LeaseSaldoAccessBean.class);
		pd [5] = new PropertyDescriptor("leaseContract", LeaseSaldoAccessBean.class, "getLeaseContract", null);
		pd [6] = new PropertyDescriptor("maincurrency", LeaseSaldoAccessBean.class, "getMaincurrency", null);
		pd [7] = new PropertyDescriptor("mainndssum", LeaseSaldoAccessBean.class);
		pd [8] = new PropertyDescriptor("mainsum", LeaseSaldoAccessBean.class);
		pd [9] = new PropertyDescriptor("resource", LeaseSaldoAccessBean.class, "getResource", null);
		pd [10] = new PropertyDescriptor("salDate", LeaseSaldoAccessBean.class);
		pd [11] = new PropertyDescriptor("andscalc", LeaseSaldoAccessBean.class, "getAndscalc", null);
		pd [12] = new PropertyDescriptor("asumcalc", LeaseSaldoAccessBean.class, "getAsumcalc", null);
		pd [13] = new PropertyDescriptor("mndscalc", LeaseSaldoAccessBean.class, "getMndscalc", null);
		pd [14] = new PropertyDescriptor("msumcalc", LeaseSaldoAccessBean.class, "getMsumcalc", null);
		pd [15] = new PropertyDescriptor("notes", LeaseSaldoAccessBean.class);
		pd [16] = new PropertyDescriptor("operator", LeaseSaldoAccessBean.class, "getOperator", null);
		pd [17] = new PropertyDescriptor("saldobyhand", LeaseSaldoAccessBean.class, "getSaldobyhand", null);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace();
	}
	return null;
}
}
