package com.hps.july.persistence;

import java.beans.*;

public class InternalOutBillAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public InternalOutBillAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[22];
	try {
		pd [ 0]	= new PropertyDescriptor("blankdate", InternalOutBillAccessBean.class);
		pd [ 1]	= new PropertyDescriptor("blanknumber", InternalOutBillAccessBean.class);
		pd [ 2]	= new PropertyDescriptor("document", InternalOutBillAccessBean.class);
		pd [ 3]	= new PropertyDescriptor("documentState", InternalOutBillAccessBean.class);
		pd [ 4]	= new PropertyDescriptor("insuranceact", InternalOutBillAccessBean.class);
		pd [ 5]	= new PropertyDescriptor("insurancedate", InternalOutBillAccessBean.class);
		pd [ 6]	= new PropertyDescriptor("insuranseMan", InternalOutBillAccessBean.class);
		pd [ 7]	= new PropertyDescriptor("processDestination", InternalOutBillAccessBean.class);
		pd [ 8]	= new PropertyDescriptor("processSource", InternalOutBillAccessBean.class);
		pd [ 9] = new PropertyDescriptor("contragent", InternalOutBillAccessBean.class, "getContragent", null);
		pd [10] = new PropertyDescriptor("from", InternalOutBillAccessBean.class, "getFrom", null);
		pd [11] = new PropertyDescriptor("owner", InternalOutBillAccessBean.class, "getOwner", null);
		pd [12] = new PropertyDescriptor("position", InternalOutBillAccessBean.class, "getPosition", null);
		pd [13] = new PropertyDescriptor("storageManager", InternalOutBillAccessBean.class, "getStorageManager", null);
		pd [14] = new PropertyDescriptor("to", InternalOutBillAccessBean.class, "getTo", null);
		pd [15] = new PropertyDescriptor("fixing", InternalOutBillAccessBean.class);
		pd [16] = new PropertyDescriptor("monter", InternalOutBillAccessBean.class, "getMonter", null);
		pd [17]	= new PropertyDescriptor("blankindex", InternalOutBillAccessBean.class);
		pd [18]	= new PropertyDescriptor("needapprove", InternalOutBillAccessBean.class);
		pd [19] = new PropertyDescriptor("projectid", InternalOutBillAccessBean.class);
		pd [20] = new PropertyDescriptor("prjstatus", InternalOutBillAccessBean.class);
		pd [21] = new PropertyDescriptor("visualtagid", InternalOutBillAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
