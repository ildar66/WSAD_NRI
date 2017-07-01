package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class OperatorAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public OperatorAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {


	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED OperatorsAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[6];

	try {
		pd [0] = new PropertyDescriptor("man", OperatorAccessBean.class, "getMan", null);
		pd [1] = new PropertyDescriptor("enabled", OperatorAccessBean.class);
		pd [2] = new PropertyDescriptor("login", OperatorAccessBean.class);
		pd [3] = new PropertyDescriptor("operator", OperatorAccessBean.class);
		pd [4] = new PropertyDescriptor("password", OperatorAccessBean.class);
		pd [5] = new PropertyDescriptor("msucode", OperatorAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
