package com.hps.july.persistence;

import java.beans.*;

public class ExpeditionAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public ExpeditionAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[7];
	System.out.println("!!! ExpeditionAccessBeanBeanInfo called.");
	try {
		pd [0]	= new PropertyDescriptor("address", ExpeditionAccessBean.class);
		pd [1]	= new PropertyDescriptor("closedate", ExpeditionAccessBean.class);
		pd [2]	= new PropertyDescriptor("name", ExpeditionAccessBean.class);
		pd [3]	= new PropertyDescriptor("storageplace", ExpeditionAccessBean.class);
		pd [4] = new PropertyDescriptor("division", ExpeditionAccessBean.class, "getDivision", null);
		pd [5] = new PropertyDescriptor("expeditor", ExpeditionAccessBean.class, "getExpeditor", null);
		pd [6] = new PropertyDescriptor("organization", ExpeditionAccessBean.class, "getOrganization", null);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
