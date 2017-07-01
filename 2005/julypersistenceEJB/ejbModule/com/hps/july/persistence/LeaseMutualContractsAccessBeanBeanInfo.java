package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (15.07.2002 10:30:38)
 * @author: Sergey Gourov
 */
public class LeaseMutualContractsAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * LeaseMutualContractsAccessBeanBeanInfo constructor comment.
 */
public LeaseMutualContractsAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2002 17:19:27)
 * @return java.beans.PropertyDescriptor[]
 */
public java.beans.PropertyDescriptor[] getPropertyDescriptors() {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED LeaseMutualContractsAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[3];

	try {
		pd [0] = new PropertyDescriptor("contract", LeaseMutualContractsAccessBean.class, "getContract", null);
		pd [1] = new PropertyDescriptor("reglament", LeaseMutualContractsAccessBean.class, "getReglament", null);
		pd [2] = new PropertyDescriptor("resource", LeaseMutualContractsAccessBean.class, "getResource", null);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
