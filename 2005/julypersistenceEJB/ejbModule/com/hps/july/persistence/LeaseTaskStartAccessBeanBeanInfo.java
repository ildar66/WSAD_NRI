package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (26.09.2002 10:27:42)
 * @author: Sergey Gourov
 */
public class LeaseTaskStartAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * LeaseTaskStartAccessBeanBeanInfo constructor comment.
 */
public LeaseTaskStartAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2002 17:19:27)
 * @return java.beans.PropertyDescriptor[]
 */
public java.beans.PropertyDescriptor[] getPropertyDescriptors() {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED LeaseTaskStartAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[9];

	try {
		pd [0] = new PropertyDescriptor("date1", LeaseTaskStartAccessBean.class);
		pd [1] = new PropertyDescriptor("date2", LeaseTaskStartAccessBean.class);
		pd [2] = new PropertyDescriptor("economistWorker", LeaseTaskStartAccessBean.class, "getEconomistWorker", null);
		pd [3] = new PropertyDescriptor("enddate", LeaseTaskStartAccessBean.class);
		pd [4] = new PropertyDescriptor("leasedocument", LeaseTaskStartAccessBean.class, "getLeasedocument", null);
		pd [5] = new PropertyDescriptor("startdate", LeaseTaskStartAccessBean.class);
		pd [6] = new PropertyDescriptor("startOperator", LeaseTaskStartAccessBean.class, "getStartOperator", null);
		pd [7] = new PropertyDescriptor("taskstart", LeaseTaskStartAccessBean.class, "getTaskstart", null);
		pd [8] = new PropertyDescriptor("tasktype", LeaseTaskStartAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
