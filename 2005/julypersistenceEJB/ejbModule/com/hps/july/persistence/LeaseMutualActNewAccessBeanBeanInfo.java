package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (08.08.2002 16:46:44)
 * @author: Sergey Gourov
 */
public class LeaseMutualActNewAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * LeaseMutualActNewAccessBeanBeanInfo constructor comment.
 */
public LeaseMutualActNewAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2002 17:19:27)
 * @return java.beans.PropertyDescriptor[]
 */
public java.beans.PropertyDescriptor[] getPropertyDescriptors() {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED LeaseMutualActNewAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[13];
	
	try {
		pd [0] = new PropertyDescriptor("actenddate", LeaseMutualActNewAccessBean.class);
		pd [1] = new PropertyDescriptor("actstartdate", LeaseMutualActNewAccessBean.class);
		pd [2] = new PropertyDescriptor("actState", LeaseMutualActNewAccessBean.class);
		pd [3] = new PropertyDescriptor("documentDate", LeaseMutualActNewAccessBean.class);
		pd [4] = new PropertyDescriptor("documentNumber", LeaseMutualActNewAccessBean.class);
		pd [5] = new PropertyDescriptor("footer", LeaseMutualActNewAccessBean.class);
		pd [6] = new PropertyDescriptor("header", LeaseMutualActNewAccessBean.class);
		pd [7] = new PropertyDescriptor("istemp", LeaseMutualActNewAccessBean.class);
		pd [8] = new PropertyDescriptor("leaseDocument", LeaseMutualActNewAccessBean.class);
		pd [9] = new PropertyDescriptor("leaseMutualReglament", LeaseMutualActNewAccessBean.class, "getLeaseMutualReglament", null);
		pd [10] = new PropertyDescriptor("isSchetFakt", LeaseMutualActNewAccessBean.class);
		pd [11] = new PropertyDescriptor("regionid", LeaseMutualActNewAccessBean.class);
		pd [12] = new PropertyDescriptor("mutualNDS", LeaseMutualActNewAccessBean.class);
		
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
