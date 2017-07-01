package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class WorkerAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public WorkerAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {


	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED WorkersAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[13];

	try {
		pd [0] = new PropertyDescriptor("company", WorkerAccessBean.class, "getCompany", null);
		pd [1] = new PropertyDescriptor("division", WorkerAccessBean.class, "getDivision", null);
		pd [2] = new PropertyDescriptor("man", WorkerAccessBean.class, "getMan", null);
		pd [3] = new PropertyDescriptor("position", WorkerAccessBean.class, "getPosition", null);
		pd [4] = new PropertyDescriptor("email", WorkerAccessBean.class);
		pd [5] = new PropertyDescriptor("fax", WorkerAccessBean.class);
		pd [6] = new PropertyDescriptor("active", WorkerAccessBean.class);
		pd [7] = new PropertyDescriptor("localphone", WorkerAccessBean.class);
		pd [8] = new PropertyDescriptor("lotusaddress", WorkerAccessBean.class);
		pd [9] = new PropertyDescriptor("mobilephone", WorkerAccessBean.class);
		pd [10] = new PropertyDescriptor("phone1", WorkerAccessBean.class);
		pd [11] = new PropertyDescriptor("phone2", WorkerAccessBean.class);
		pd [12] = new PropertyDescriptor("worker", WorkerAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
