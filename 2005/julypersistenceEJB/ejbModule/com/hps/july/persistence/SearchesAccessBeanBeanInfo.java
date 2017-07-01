package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class SearchesAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public SearchesAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {


	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED SearchesAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[4];

	try {
		pd [0] = new PropertyDescriptor("order", SearchesAccessBean.class);
		pd [1] = new PropertyDescriptor("groupping", SearchesAccessBean.class, "getGroupping", null);
		pd [2] = new PropertyDescriptor("organization", SearchesAccessBean.class, "getOrganization", null);
		pd [3] = new PropertyDescriptor("group", SearchesAccessBean.class, "getGroup", null);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
