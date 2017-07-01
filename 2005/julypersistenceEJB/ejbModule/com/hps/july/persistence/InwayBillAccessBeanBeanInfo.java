package com.hps.july.persistence;

import java.beans.*;

public class InwayBillAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public InwayBillAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[30];
	try {
		pd [0]	= new PropertyDescriptor("blankdate", InwayBillAccessBean.class);
		pd [1]	= new PropertyDescriptor("blanknumber", InwayBillAccessBean.class);
		pd [2]	= new PropertyDescriptor("cordocdate", InwayBillAccessBean.class);
		pd [3]	= new PropertyDescriptor("cordocnum", InwayBillAccessBean.class);
		pd [4]	= new PropertyDescriptor("gtdnumber", InwayBillAccessBean.class);
		pd [5]	= new PropertyDescriptor("gtddate", InwayBillAccessBean.class);
		pd [6]	= new PropertyDescriptor("dActDate", InwayBillAccessBean.class);
		pd [7]	= new PropertyDescriptor("dActNumber", InwayBillAccessBean.class);
		pd [8]	= new PropertyDescriptor("dActRepresentative", InwayBillAccessBean.class);
		pd [9]	= new PropertyDescriptor("document", InwayBillAccessBean.class);
		pd [10]	= new PropertyDescriptor("documentState", InwayBillAccessBean.class);
		pd [11]	= new PropertyDescriptor("insuranceact", InwayBillAccessBean.class);
		pd [12]	= new PropertyDescriptor("insurancedate", InwayBillAccessBean.class);
		pd [13]	= new PropertyDescriptor("processDestination", InwayBillAccessBean.class);
		pd [14]	= new PropertyDescriptor("processSource", InwayBillAccessBean.class);
		pd [15]	= new PropertyDescriptor("supplyCondition", InwayBillAccessBean.class);
		pd [16] = new PropertyDescriptor("contragent", InwayBillAccessBean.class, "getContragent", null);
		pd [17] = new PropertyDescriptor("currency", InwayBillAccessBean.class, "getCurrency", null);
		pd [18] = new PropertyDescriptor("dActStorManager", InwayBillAccessBean.class, "getDActStorManager", null);
		pd [19] = new PropertyDescriptor("dActTechStuf", InwayBillAccessBean.class, "getDActTechStuf", null);
		pd [20] = new PropertyDescriptor("from", InwayBillAccessBean.class, "getFrom", null);
		pd [21] = new PropertyDescriptor("owner", InwayBillAccessBean.class, "getOwner", null);
		pd [22] = new PropertyDescriptor("to", InwayBillAccessBean.class, "getTo", null);
		pd [23] = new PropertyDescriptor("storageManager", InwayBillAccessBean.class, "getStorageManager", null);
		pd [24] = new PropertyDescriptor("insuranseMan", InwayBillAccessBean.class);
		pd [25]	= new PropertyDescriptor("blankindex", InwayBillAccessBean.class);
		pd [26]	= new PropertyDescriptor("needapprove", InwayBillAccessBean.class);
		pd [27] = new PropertyDescriptor("projectid", InwayBillAccessBean.class);
		pd [28] = new PropertyDescriptor("prjstatus", InwayBillAccessBean.class);
		pd [29] = new PropertyDescriptor("visualtype", InwayBillAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
