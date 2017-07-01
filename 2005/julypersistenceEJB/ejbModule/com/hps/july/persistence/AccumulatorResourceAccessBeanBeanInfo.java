package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class AccumulatorResourceAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public AccumulatorResourceAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
//	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED ResourceAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[29];

	try {
		pd [0] = new PropertyDescriptor("active", AccumBatteryResourceAccessBean.class);
		pd [1] = new PropertyDescriptor("actualcode", AccumBatteryResourceAccessBean.class);
		pd [2] = new PropertyDescriptor("boxable", AccumBatteryResourceAccessBean.class);
		pd [3] = new PropertyDescriptor("complect", AccumBatteryResourceAccessBean.class);
		pd [4] = new PropertyDescriptor("complectpart", AccumBatteryResourceAccessBean.class);
		pd [5] = new PropertyDescriptor("model", AccumBatteryResourceAccessBean.class);
		pd [6] = new PropertyDescriptor("name", AccumBatteryResourceAccessBean.class);
		pd [7] = new PropertyDescriptor("notes", AccumBatteryResourceAccessBean.class);
		pd [8] = new PropertyDescriptor("priceable", AccumBatteryResourceAccessBean.class);
		pd [9] = new PropertyDescriptor("resource", AccumBatteryResourceAccessBean.class);
		pd [10] = new PropertyDescriptor("countpolicy", AccumBatteryResourceAccessBean.class);
		pd [11] = new PropertyDescriptor("unit", AccumBatteryResourceAccessBean.class, "getUnit", null);
		pd [12] = new PropertyDescriptor("subtype", AccumBatteryResourceAccessBean.class, "getSubtype", null);
		pd [13] = new PropertyDescriptor("storageCard", AccumBatteryResourceAccessBean.class, "getStorageCard", null);
		pd [14] = new PropertyDescriptor("resourceTaxes", AccumBatteryResourceAccessBean.class, "getResourceTaxes", null);
		pd [15] = new PropertyDescriptor("resourceSets", AccumBatteryResourceAccessBean.class, "getResourceSets", null);
		pd [16] = new PropertyDescriptor("resourceSetParts", AccumBatteryResourceAccessBean.class, "getResourceSetParts", null);
		pd [17] = new PropertyDescriptor("documentPosition", AccumBatteryResourceAccessBean.class, "getDocumentPosition", null);
		pd [18] = new PropertyDescriptor("complects", AccumBatteryResourceAccessBean.class, "getComplects", null);
		pd [19] = new PropertyDescriptor("complectparts", AccumBatteryResourceAccessBean.class, "getComplectparts", null);
		pd [20] = new PropertyDescriptor("manucode", AccumBatteryResourceAccessBean.class);
		//pd [21] = new PropertyDescriptor("manufacturer", AccumulatorResourceAccessBean.class, "getManufacturer", null);
		pd [21] = new PropertyDescriptor("resourceclass2", AccumBatteryResourceAccessBean.class);
		pd [22] = new PropertyDescriptor("groupid", AccumBatteryResourceAccessBean.class);
		pd [23] = new PropertyDescriptor("manufid", AccumBatteryResourceAccessBean.class);
		pd [24] = new PropertyDescriptor("disablenfscodes", AccumBatteryResourceAccessBean.class);
		pd [25] = new PropertyDescriptor("voltage", AccumBatteryResourceAccessBean.class);
		pd [26] = new PropertyDescriptor("capacity", AccumBatteryResourceAccessBean.class);
		pd [27] = new PropertyDescriptor("accutype", AccumBatteryResourceAccessBean.class);
		pd [28] = new PropertyDescriptor("accucount", AccumBatteryResourceAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
