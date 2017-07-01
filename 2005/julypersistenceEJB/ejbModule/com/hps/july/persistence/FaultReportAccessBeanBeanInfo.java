package com.hps.july.persistence;

import java.beans.*;

public class FaultReportAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public FaultReportAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[23];
	try {
		pd [ 0]	= new PropertyDescriptor("blankdate", FaultReportAccessBean.class);
		pd [ 1]	= new PropertyDescriptor("blanknumber", FaultReportAccessBean.class);
		pd [ 2]	= new PropertyDescriptor("document", FaultReportAccessBean.class);
		pd [ 3]	= new PropertyDescriptor("documentState", FaultReportAccessBean.class);
		pd [ 4]	= new PropertyDescriptor("insuranceact", FaultReportAccessBean.class);
		pd [ 5]	= new PropertyDescriptor("insurancedate", FaultReportAccessBean.class);
		pd [ 5]	= new PropertyDescriptor("insuranseMan", FaultReportAccessBean.class);
		pd [ 6]	= new PropertyDescriptor("processDestination", FaultReportAccessBean.class);
		pd [ 7]	= new PropertyDescriptor("processSource", FaultReportAccessBean.class);
		pd [ 8] = new PropertyDescriptor("contragent", FaultReportAccessBean.class, "getContragent", null);
		pd [ 9] = new PropertyDescriptor("division", FaultReportAccessBean.class, "getDivision", null);
		pd [10] = new PropertyDescriptor("equipment", FaultReportAccessBean.class, "getEquipment", null);
		pd [11] = new PropertyDescriptor("from", FaultReportAccessBean.class, "getFrom", null);
		pd [12] = new PropertyDescriptor("owner", FaultReportAccessBean.class, "getOwner", null);
		pd [13] = new PropertyDescriptor("storageManager", FaultReportAccessBean.class, "getStorageManager", null);
		pd [14] = new PropertyDescriptor("techStuff", FaultReportAccessBean.class, "getTechStuff", null);
		pd [15] = new PropertyDescriptor("to", FaultReportAccessBean.class, "getTo", null);
		pd [16]	= new PropertyDescriptor("blankindex", FaultReportAccessBean.class);
		pd [17]	= new PropertyDescriptor("oldresource", FaultReportAccessBean.class);
		pd [18]	= new PropertyDescriptor("newresource", FaultReportAccessBean.class);
		pd [19]	= new PropertyDescriptor("agregateresource", FaultReportAccessBean.class);
		pd [20] = new PropertyDescriptor("needapprove", FaultReportAccessBean.class);
		pd [21] = new PropertyDescriptor("projectid", FaultReportAccessBean.class);
		pd [22] = new PropertyDescriptor("prjstatus", FaultReportAccessBean.class);
		//pd [23] = new PropertyDescriptor("visualtagid", FaultReportAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
