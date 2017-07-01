package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class PeopleAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public PeopleAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {


	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED !!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[8];

	try {
		pd [0] = new PropertyDescriptor("lastname", PeopleAccessBean.class);
		pd [1] = new PropertyDescriptor("firstname", PeopleAccessBean.class);
		pd [2] = new PropertyDescriptor("middlename", PeopleAccessBean.class);
		pd [3] = new PropertyDescriptor("passportser", PeopleAccessBean.class);
		pd [4] = new PropertyDescriptor("fullName", PeopleAccessBean.class, "getFullName", null);
		pd [5] = new PropertyDescriptor("isActive", PeopleAccessBean.class);
		pd [6] = new PropertyDescriptor("passportDate", PeopleAccessBean.class);
		pd [7] = new PropertyDescriptor("passportWhom", PeopleAccessBean.class);
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
