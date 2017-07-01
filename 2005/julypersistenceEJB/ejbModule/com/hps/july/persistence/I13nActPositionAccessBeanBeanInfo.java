package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class I13nActPositionAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public I13nActPositionAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[34];
	try {
		pd [0]	= new PropertyDescriptor("configuration", I13nActPositionAccessBean.class);
		pd [1]	= new PropertyDescriptor("contentsScanned", I13nActPositionAccessBean.class);
		pd [2]	= new PropertyDescriptor("docposition", I13nActPositionAccessBean.class);
		pd [3]	= new PropertyDescriptor("note", I13nActPositionAccessBean.class);
		pd [4]	= new PropertyDescriptor("order", I13nActPositionAccessBean.class);
		pd [5]	= new PropertyDescriptor("party", I13nActPositionAccessBean.class);
		pd [6]	= new PropertyDescriptor("positionState", I13nActPositionAccessBean.class);
		pd [7]	= new PropertyDescriptor("price", I13nActPositionAccessBean.class);
		pd [8]	= new PropertyDescriptor("qty", I13nActPositionAccessBean.class);
		pd [9]	= new PropertyDescriptor("serialnumber", I13nActPositionAccessBean.class);
		pd [10] = new PropertyDescriptor("agregate", I13nActPositionAccessBean.class, "getAgregate", null);
		pd [11] = new PropertyDescriptor("contract", I13nActPositionAccessBean.class, "getContract", null);
		pd [12] = new PropertyDescriptor("owner", I13nActPositionAccessBean.class, "getOwner", null);
		pd [13] = new PropertyDescriptor("resource", I13nActPositionAccessBean.class, "getResource", null);
		pd [14] = new PropertyDescriptor("cardfrom", I13nActPositionAccessBean.class, "getCardFrom", null);
		pd [15] = new PropertyDescriptor("cardto", I13nActPositionAccessBean.class, "getCardTo", null);
		pd [16]	= new PropertyDescriptor("sourceBoxed", I13nActPositionAccessBean.class);
		pd [17]	= new PropertyDescriptor("sourceBroken", I13nActPositionAccessBean.class);
		pd [18]	= new PropertyDescriptor("sourceClosed", I13nActPositionAccessBean.class);
		pd [19]	= new PropertyDescriptor("resultBoxed", I13nActPositionAccessBean.class);
		pd [20]	= new PropertyDescriptor("resultBroken", I13nActPositionAccessBean.class);
		pd [21]	= new PropertyDescriptor("resultClosed", I13nActPositionAccessBean.class);
		pd [22] = new PropertyDescriptor("sum", I13nActPositionAccessBean.class, "getSum", null);
		pd [23] = new PropertyDescriptor("newplace", I13nActPositionAccessBean.class);
		pd [24] = new PropertyDescriptor("oldplace", I13nActPositionAccessBean.class);
		pd [25]	= new PropertyDescriptor("manufserial", I13nActPositionAccessBean.class);
		pd [26]	= new PropertyDescriptor("isfictserial", I13nActPositionAccessBean.class);
		pd [27]	= new PropertyDescriptor("realserial", I13nActPositionAccessBean.class);
		pd [28]	= new PropertyDescriptor("localserial", I13nActPositionAccessBean.class);
		pd [29]	= new PropertyDescriptor("agrmanufserial", I13nActPositionAccessBean.class);
		pd [30]	= new PropertyDescriptor("agrlocserial", I13nActPositionAccessBean.class);
		pd [31]	= new PropertyDescriptor("oldagrmanufserial", I13nActPositionAccessBean.class);
		pd [32]	= new PropertyDescriptor("oldagrlocserial", I13nActPositionAccessBean.class);
		pd [33]	= new PropertyDescriptor("parentbtsdocpos", I13nActPositionAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
