package com.hps.july.persistence;

import java.beans.*;

public class PayOffActAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public PayOffActAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[22];
	try {
		pd [0]	= new PropertyDescriptor("blankdate", PayOffActAccessBean.class);
		pd [1]	= new PropertyDescriptor("blanknumber", PayOffActAccessBean.class);
		pd [2]	= new PropertyDescriptor("document", PayOffActAccessBean.class);
		pd [3]	= new PropertyDescriptor("documentState", PayOffActAccessBean.class);
		pd [4]	= new PropertyDescriptor("insuranceact", PayOffActAccessBean.class);
		pd [5]	= new PropertyDescriptor("insurancedate", PayOffActAccessBean.class);
		pd [6]	= new PropertyDescriptor("insuranseMan", PayOffActAccessBean.class);
		pd [7]	= new PropertyDescriptor("processDestination", PayOffActAccessBean.class);
		pd [8]	= new PropertyDescriptor("processSource", PayOffActAccessBean.class);
		pd [9]	= new PropertyDescriptor("contragent", PayOffActAccessBean.class, "getContragent", null);
		pd [10]	= new PropertyDescriptor("from", PayOffActAccessBean.class, "getFrom", null);
		pd [11]	= new PropertyDescriptor("owner", PayOffActAccessBean.class, "getOwner", null);
		pd [12]	= new PropertyDescriptor("storageManager", PayOffActAccessBean.class, "getStorageManager", null);
		pd [13]	= new PropertyDescriptor("to", PayOffActAccessBean.class, "getTo", null);
		pd [14]	= new PropertyDescriptor("chairMan", PayOffActAccessBean.class, "getChairMan", null);
		pd [15]	= new PropertyDescriptor("member1", PayOffActAccessBean.class, "getMember1", null);
		pd [16]	= new PropertyDescriptor("member2", PayOffActAccessBean.class, "getMember2", null);
		pd [17]	= new PropertyDescriptor("blankindex", PayOffActAccessBean.class);
		pd [18]	= new PropertyDescriptor("needapprove", PayOffActAccessBean.class);
		pd [19] = new PropertyDescriptor("projectid", PayOffActAccessBean.class);
		pd [20] = new PropertyDescriptor("prjstatus", PayOffActAccessBean.class);
		pd [21] = new PropertyDescriptor("visualtagid", PayOffActAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
