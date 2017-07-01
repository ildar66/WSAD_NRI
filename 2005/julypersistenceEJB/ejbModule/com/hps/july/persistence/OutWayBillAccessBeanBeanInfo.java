package com.hps.july.persistence;

import java.beans.*;

public class OutWayBillAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public OutWayBillAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[19];
	try {
		pd [0]	= new PropertyDescriptor("blankdate", OutWayBillAccessBean.class);
		pd [1]	= new PropertyDescriptor("blanknumber", OutWayBillAccessBean.class);
		pd [2]	= new PropertyDescriptor("document", OutWayBillAccessBean.class);
		pd [3]	= new PropertyDescriptor("documentState", OutWayBillAccessBean.class);
		pd [4]	= new PropertyDescriptor("insuranceact", OutWayBillAccessBean.class);
		pd [5]	= new PropertyDescriptor("insurancedate", OutWayBillAccessBean.class);
		pd [6]	= new PropertyDescriptor("insuranseMan", OutWayBillAccessBean.class);
		pd [7]	= new PropertyDescriptor("processDestination", OutWayBillAccessBean.class);
		pd [8]	= new PropertyDescriptor("processSource", OutWayBillAccessBean.class);
		pd [9]	= new PropertyDescriptor("contragent", OutWayBillAccessBean.class, "getContragent", null);
		pd [10]	= new PropertyDescriptor("from", OutWayBillAccessBean.class, "getFrom", null);
		pd [11]	= new PropertyDescriptor("owner", OutWayBillAccessBean.class, "getOwner", null);
		pd [12]	= new PropertyDescriptor("storageManager", OutWayBillAccessBean.class, "getStorageManager", null);
		pd [13]	= new PropertyDescriptor("to", OutWayBillAccessBean.class, "getTo", null);
		pd [14]	= new PropertyDescriptor("blankindex", OutWayBillAccessBean.class);
		pd [15]	= new PropertyDescriptor("needapprove", OutWayBillAccessBean.class);
		pd [16] = new PropertyDescriptor("projectid", OutWayBillAccessBean.class);
		pd [17] = new PropertyDescriptor("prjstatus", OutWayBillAccessBean.class);
		pd [18] = new PropertyDescriptor("visualtagid", OutWayBillAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
