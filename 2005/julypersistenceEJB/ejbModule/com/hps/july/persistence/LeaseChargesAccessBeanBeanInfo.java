package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (23.07.2002 16:16:41)
 * @author: Sergey Gourov
 */
public class LeaseChargesAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * LeaseChargesAccessBeanBeanInfo constructor comment.
 */
public LeaseChargesAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2002 17:19:27)
 * @return java.beans.PropertyDescriptor[]
 */
public java.beans.PropertyDescriptor[] getPropertyDescriptors() {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED LeaseChargesAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[18];

	try {
		pd [0] = new PropertyDescriptor("act", LeaseChargesAccessBean.class, "getAct", null);
		pd [1] = new PropertyDescriptor("begindate", LeaseChargesAccessBean.class);
		pd [2] = new PropertyDescriptor("byhandraterur", LeaseChargesAccessBean.class);
		pd [3] = new PropertyDescriptor("currency", LeaseChargesAccessBean.class, "getCurrency", null);
		pd [4] = new PropertyDescriptor("date", LeaseChargesAccessBean.class);
		pd [5] = new PropertyDescriptor("docposvid", LeaseChargesAccessBean.class);
		pd [6] = new PropertyDescriptor("enddate", LeaseChargesAccessBean.class);
		pd [7] = new PropertyDescriptor("leaseContract", LeaseChargesAccessBean.class, "getLeaseContract", null);
		pd [8] = new PropertyDescriptor("leaseDocPosition", LeaseChargesAccessBean.class);
		pd [9] = new PropertyDescriptor("leaseRule", LeaseChargesAccessBean.class, "getLeaseRule", null);
		pd [10] = new PropertyDescriptor("remainderrate2rur", LeaseChargesAccessBean.class);
		pd [11] = new PropertyDescriptor("remaindersum", LeaseChargesAccessBean.class);
		pd [12] = new PropertyDescriptor("resource", LeaseChargesAccessBean.class, "getResource", null);
		pd [13] = new PropertyDescriptor("source", LeaseChargesAccessBean.class);
		pd [14] = new PropertyDescriptor("summ", LeaseChargesAccessBean.class);
		pd [15] = new PropertyDescriptor("sumnds", LeaseChargesAccessBean.class);
		pd [16] = new PropertyDescriptor("billnumber", LeaseChargesAccessBean.class);
		pd [17] = new PropertyDescriptor("willbeinact", LeaseChargesAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
