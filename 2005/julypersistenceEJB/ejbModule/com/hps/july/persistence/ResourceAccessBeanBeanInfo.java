package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class ResourceAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public ResourceAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
//	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED ResourceAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[25];

	try {
		pd [0] = new PropertyDescriptor("active", ResourceAccessBean.class);
		pd [1] = new PropertyDescriptor("actualcode", ResourceAccessBean.class);
		pd [2] = new PropertyDescriptor("boxable", ResourceAccessBean.class);
		pd [3] = new PropertyDescriptor("complect", ResourceAccessBean.class);
		pd [4] = new PropertyDescriptor("complectpart", ResourceAccessBean.class);
		pd [5] = new PropertyDescriptor("model", ResourceAccessBean.class);
		pd [6] = new PropertyDescriptor("name", ResourceAccessBean.class);
		pd [7] = new PropertyDescriptor("notes", ResourceAccessBean.class);
		pd [8] = new PropertyDescriptor("priceable", ResourceAccessBean.class);
		pd [9] = new PropertyDescriptor("resource", ResourceAccessBean.class);
		pd [10] = new PropertyDescriptor("countpolicy", ResourceAccessBean.class);
		pd [11] = new PropertyDescriptor("unit", ResourceAccessBean.class, "getUnit", null);
		pd [12] = new PropertyDescriptor("subtype", ResourceAccessBean.class, "getSubtype", null);
		pd [13] = new PropertyDescriptor("storageCard", ResourceAccessBean.class, "getStorageCard", null);
		pd [14] = new PropertyDescriptor("resourceTaxes", ResourceAccessBean.class, "getResourceTaxes", null);
		pd [15] = new PropertyDescriptor("resourceSets", ResourceAccessBean.class, "getResourceSets", null);
		pd [16] = new PropertyDescriptor("resourceSetParts", ResourceAccessBean.class, "getResourceSetParts", null);
		pd [17] = new PropertyDescriptor("documentPosition", ResourceAccessBean.class, "getDocumentPosition", null);
		pd [18] = new PropertyDescriptor("complects", ResourceAccessBean.class, "getComplects", null);
		pd [19] = new PropertyDescriptor("complectparts", ResourceAccessBean.class, "getComplectparts", null);
		pd [20] = new PropertyDescriptor("manucode", ResourceAccessBean.class);
		//pd [21] = new PropertyDescriptor("manufacturer", ResourceAccessBean.class, "getManufacturer", null);
		pd [21] = new PropertyDescriptor("resourceclass2", ResourceAccessBean.class);
		pd [22] = new PropertyDescriptor("groupid", ResourceAccessBean.class);
		pd [23] = new PropertyDescriptor("manufid", ResourceAccessBean.class);
		pd [24] = new PropertyDescriptor("disablenfscodes", ResourceAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
