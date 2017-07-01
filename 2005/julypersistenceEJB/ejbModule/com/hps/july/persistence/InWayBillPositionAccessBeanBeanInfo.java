package com.hps.july.persistence;

import java.beans.*;

public class InWayBillPositionAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public InWayBillPositionAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[32];
	try {
		pd [0]	= new PropertyDescriptor("agregateSerial", InWayBillPositionAccessBean.class);
		pd [1]	= new PropertyDescriptor("configuration", InWayBillPositionAccessBean.class);
		pd [2]	= new PropertyDescriptor("docposition", InWayBillPositionAccessBean.class);
		pd [3]	= new PropertyDescriptor("order", InWayBillPositionAccessBean.class);
		pd [4]	= new PropertyDescriptor("party", InWayBillPositionAccessBean.class);
		pd [5]	= new PropertyDescriptor("price", InWayBillPositionAccessBean.class);
		pd [6]	= new PropertyDescriptor("qty", InWayBillPositionAccessBean.class);
		pd [7]	= new PropertyDescriptor("resultBoxed", InWayBillPositionAccessBean.class);
		pd [8]	= new PropertyDescriptor("resultBroken", InWayBillPositionAccessBean.class);
		pd [9]	= new PropertyDescriptor("resultClosed", InWayBillPositionAccessBean.class);
		pd [10]	= new PropertyDescriptor("serialnumber", InWayBillPositionAccessBean.class);
		pd [11]	= new PropertyDescriptor("sourceBoxed", InWayBillPositionAccessBean.class);
		pd [12]	= new PropertyDescriptor("sourceBroken", InWayBillPositionAccessBean.class);
		pd [13]	= new PropertyDescriptor("sourceClosed", InWayBillPositionAccessBean.class);
		pd [14] = new PropertyDescriptor("agregate", InWayBillPositionAccessBean.class, "getAgregate", null);
		pd [15] = new PropertyDescriptor("cardFrom", InWayBillPositionAccessBean.class, "getCardFrom", null);
		pd [16] = new PropertyDescriptor("cardTo", InWayBillPositionAccessBean.class, "getCardTo", null);
		pd [17] = new PropertyDescriptor("document", InWayBillPositionAccessBean.class, "getDocument", null);
		pd [18] = new PropertyDescriptor("outerDocPosition", InWayBillPositionAccessBean.class, "getOuterDocPosition", null);
		pd [19] = new PropertyDescriptor("owner", InWayBillPositionAccessBean.class, "getOwner", null);
		pd [20] = new PropertyDescriptor("resource", InWayBillPositionAccessBean.class, "getResource", null);
		pd [21]	= new PropertyDescriptor("notes", InWayBillPositionAccessBean.class);
		pd [22]	= new PropertyDescriptor("sourcePrice", InWayBillPositionAccessBean.class);
		pd [23]	= new PropertyDescriptor("manufserial", InWayBillPositionAccessBean.class);
		pd [24]	= new PropertyDescriptor("isfictserial", InWayBillPositionAccessBean.class);
		pd [25]	= new PropertyDescriptor("realserial", InWayBillPositionAccessBean.class);
		pd [26]	= new PropertyDescriptor("localserial", InWayBillPositionAccessBean.class);
		pd [27]	= new PropertyDescriptor("agrmanufserial", InWayBillPositionAccessBean.class);
		pd [28]	= new PropertyDescriptor("agrlocserial", InWayBillPositionAccessBean.class);
		pd [29]	= new PropertyDescriptor("oldagrmanufserial", InWayBillPositionAccessBean.class);
		pd [30]	= new PropertyDescriptor("oldagrlocserial", InWayBillPositionAccessBean.class);
		pd [31]	= new PropertyDescriptor("parentbtsdocpos", InWayBillPositionAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace();
	}
	return null;
}
}
