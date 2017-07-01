package com.hps.july.persistence;

import java.beans.*;

public class InternalWayBillPositionAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public InternalWayBillPositionAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[37];
	try {
		pd [ 0]	= new PropertyDescriptor("agregateSerial", InternalWayBillPositionAccessBean.class);
		pd [ 1]	= new PropertyDescriptor("configuration", InternalWayBillPositionAccessBean.class);
		pd [ 2]	= new PropertyDescriptor("docposition", InternalWayBillPositionAccessBean.class);
		pd [ 3]	= new PropertyDescriptor("docQty", InternalWayBillPositionAccessBean.class);
		pd [ 4]	= new PropertyDescriptor("notes", InternalWayBillPositionAccessBean.class);
		pd [ 5]	= new PropertyDescriptor("oldAgregateSerial", InternalWayBillPositionAccessBean.class);
		pd [ 6]	= new PropertyDescriptor("order", InternalWayBillPositionAccessBean.class);
		pd [ 7]	= new PropertyDescriptor("party", InternalWayBillPositionAccessBean.class);
		pd [ 8]	= new PropertyDescriptor("price", InternalWayBillPositionAccessBean.class);
		pd [ 9]	= new PropertyDescriptor("qty", InternalWayBillPositionAccessBean.class);
		pd [10]	= new PropertyDescriptor("resultBoxed", InternalWayBillPositionAccessBean.class);
		pd [11]	= new PropertyDescriptor("resultBroken", InternalWayBillPositionAccessBean.class);
		pd [12]	= new PropertyDescriptor("resultClosed", InternalWayBillPositionAccessBean.class);
		pd [13]	= new PropertyDescriptor("serialnumber", InternalWayBillPositionAccessBean.class);
		pd [14]	= new PropertyDescriptor("sourceBoxed", InternalWayBillPositionAccessBean.class);
		pd [15]	= new PropertyDescriptor("sourceBroken", InternalWayBillPositionAccessBean.class);
		pd [16]	= new PropertyDescriptor("sourceClosed", InternalWayBillPositionAccessBean.class);
			
		pd [17]	= new PropertyDescriptor("agregate", InternalWayBillPositionAccessBean.class, "getAgregate", null);
		pd [18]	= new PropertyDescriptor("cardFrom", InternalWayBillPositionAccessBean.class, "getCardFrom", null);
		pd [19]	= new PropertyDescriptor("cardTo", InternalWayBillPositionAccessBean.class, "getCardTo", null);
		pd [20]	= new PropertyDescriptor("document", InternalWayBillPositionAccessBean.class, "getDocument", null);
		pd [21]	= new PropertyDescriptor("owner", InternalWayBillPositionAccessBean.class, "getOwner", null);
		pd [22]	= new PropertyDescriptor("resource", InternalWayBillPositionAccessBean.class, "getResource", null);
		pd [23]	= new PropertyDescriptor("sum", InternalWayBillPositionAccessBean.class, "getSum", null);
		pd [24] = new PropertyDescriptor("newplace", InternalWayBillPositionAccessBean.class);
		pd [25] = new PropertyDescriptor("oldplace", InternalWayBillPositionAccessBean.class);
		pd [26]	= new PropertyDescriptor("manufserial", InternalWayBillPositionAccessBean.class);
		pd [27]	= new PropertyDescriptor("isfictserial", InternalWayBillPositionAccessBean.class);
		pd [28]	= new PropertyDescriptor("realserial", InternalWayBillPositionAccessBean.class);
		pd [29]	= new PropertyDescriptor("oldAgregateresource", InternalWayBillPositionAccessBean.class);
		pd [30]	= new PropertyDescriptor("agregateresource", InternalWayBillPositionAccessBean.class);
		pd [31]	= new PropertyDescriptor("localserial", InternalWayBillPositionAccessBean.class);
		pd [32]	= new PropertyDescriptor("agrmanufserial", InternalWayBillPositionAccessBean.class);
		pd [33]	= new PropertyDescriptor("agrlocserial", InternalWayBillPositionAccessBean.class);
		pd [34]	= new PropertyDescriptor("oldagrmanufserial", InternalWayBillPositionAccessBean.class);
		pd [35]	= new PropertyDescriptor("oldagrlocserial", InternalWayBillPositionAccessBean.class);
		pd [36]	= new PropertyDescriptor("parentbtsdocpos", InternalWayBillPositionAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
