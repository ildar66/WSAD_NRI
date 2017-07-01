package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class ResourceSetAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public ResourceSetAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {


	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED ResourceSetAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[5];

	try {
		pd [0] = new PropertyDescriptor("mainpartqty", ResourceSetAccessBean.class);
		pd [1] = new PropertyDescriptor("name", ResourceSetAccessBean.class);
		pd [2] = new PropertyDescriptor("resourceset", ResourceSetAccessBean.class);
		pd [3] = new PropertyDescriptor("type", ResourceSetAccessBean.class);
		pd [4] = new PropertyDescriptor("mainpart", ResourceSetAccessBean.class, "getMainpart", null);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
