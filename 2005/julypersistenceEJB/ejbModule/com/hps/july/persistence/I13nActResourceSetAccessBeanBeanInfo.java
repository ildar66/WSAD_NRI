package com.hps.july.persistence;

import java.beans.*;

public class I13nActResourceSetAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public I13nActResourceSetAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[2];
	try {
		pd [0] = new PropertyDescriptor("i13nAct", I13nActResourceSetAccessBean.class, "getI13nAct", null);
		pd [1] = new PropertyDescriptor("resource", I13nActResourceSetAccessBean.class, "getResource", null);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
