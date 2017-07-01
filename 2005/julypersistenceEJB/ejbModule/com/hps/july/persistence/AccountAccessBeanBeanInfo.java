package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class AccountAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public AccountAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[5];
	try {
		pd [0] = new PropertyDescriptor("account", AccountAccessBean.class);
		pd [1] = new PropertyDescriptor("accountvalue", AccountAccessBean.class);
		pd [2] = new PropertyDescriptor("bank", AccountAccessBean.class, "getBank", null);
		pd [3] = new PropertyDescriptor("organization", AccountAccessBean.class, "getOrganization", null);
		pd [4] = new PropertyDescriptor("active", AccountAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
