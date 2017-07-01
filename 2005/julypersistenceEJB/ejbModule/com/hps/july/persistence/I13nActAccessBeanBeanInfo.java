package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class I13nActAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public I13nActAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[21];
	try {
		pd [0] = new PropertyDescriptor("blanknumber", I13nActAccessBean.class);
		pd [1] = new PropertyDescriptor("blankdate", I13nActAccessBean.class);
		pd [2] = new PropertyDescriptor("documentState", I13nActAccessBean.class);
		pd [3] = new PropertyDescriptor("document", I13nActAccessBean.class);
		pd [4] = new PropertyDescriptor("insurancedate", I13nActAccessBean.class);
		pd [5] = new PropertyDescriptor("insuranceact", I13nActAccessBean.class);
		pd [6] = new PropertyDescriptor("type", I13nActAccessBean.class);
		pd [7] = new PropertyDescriptor("contragent", I13nActAccessBean.class, "getContragent", null);
		pd [8] = new PropertyDescriptor("owner", I13nActAccessBean.class, "getOwner", null);
		pd [9] = new PropertyDescriptor("agregate", I13nActAccessBean.class, "getAgregate", null);
		pd [10] = new PropertyDescriptor("from", I13nActAccessBean.class, "getFrom", null);
		pd [11] = new PropertyDescriptor("to", I13nActAccessBean.class, "getTo", null);
		pd [12] = new PropertyDescriptor("storagemanager", I13nActAccessBean.class, "getStorageManager", null);
		pd [13] = new PropertyDescriptor("techstuff", I13nActAccessBean.class, "getTechStuff", null);
		pd [14] = new PropertyDescriptor("insuranseMan", I13nActAccessBean.class);
		pd [15] = new PropertyDescriptor("blankindex", I13nActAccessBean.class);
		pd [16] = new PropertyDescriptor("agregateresource", I13nActAccessBean.class);
		pd [17] = new PropertyDescriptor("needapprove", I13nActAccessBean.class);
		pd [18] = new PropertyDescriptor("projectid", I13nActAccessBean.class);
		pd [19] = new PropertyDescriptor("prjstatus", I13nActAccessBean.class);
		pd [20] = new PropertyDescriptor("visualtagid", I13nActAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
