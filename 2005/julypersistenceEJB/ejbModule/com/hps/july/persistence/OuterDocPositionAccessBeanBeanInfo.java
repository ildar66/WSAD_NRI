package com.hps.july.persistence;

import java.beans.*;

public class OuterDocPositionAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public OuterDocPositionAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[7];
	try {
		pd [0]	= new PropertyDescriptor("configuration", OuterDocPositionAccessBean.class);
		pd [1]	= new PropertyDescriptor("note", OuterDocPositionAccessBean.class);
		pd [2]	= new PropertyDescriptor("outerDocPosition", OuterDocPositionAccessBean.class);
		pd [3]	= new PropertyDescriptor("outerPrice", OuterDocPositionAccessBean.class);
		pd [4]	= new PropertyDescriptor("outerQty", OuterDocPositionAccessBean.class);
		pd [5] = new PropertyDescriptor("inWayBill", OuterDocPositionAccessBean.class, "getInWayBill", null);
		pd [6] = new PropertyDescriptor("resource", OuterDocPositionAccessBean.class, "getResource", null);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace();
	}
	return null;
}
}
