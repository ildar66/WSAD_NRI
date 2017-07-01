package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (24.01.2003 18:13:41)
 * @author: Sergey Gourov
 */
public class LeaseDNOPAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * LeaseDNOPAccessBeanBeanInfo constructor comment.
 */
public LeaseDNOPAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED LeaseDNOPAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[9];

	try {
		pd [0] = new PropertyDescriptor("act", LeaseDNOPAccessBean.class, "getAct", null);
		pd [1] = new PropertyDescriptor("byhandchangeraterur", LeaseDNOPAccessBean.class);
		pd [2] = new PropertyDescriptor("chargerurrate", LeaseDNOPAccessBean.class);
		pd [3] = new PropertyDescriptor("chargerursum", LeaseDNOPAccessBean.class);
		pd [4] = new PropertyDescriptor("chargesum", LeaseDNOPAccessBean.class);
		pd [5] = new PropertyDescriptor("leaseCharge", LeaseDNOPAccessBean.class, "getLeaseCharge", null);
		pd [6] = new PropertyDescriptor("leasePayment", LeaseDNOPAccessBean.class, "getLeasePayment", null);
		pd [7] = new PropertyDescriptor("payrursum", LeaseDNOPAccessBean.class);
		pd [8] = new PropertyDescriptor("source", LeaseDNOPAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
