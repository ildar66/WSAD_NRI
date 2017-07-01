package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class ChangeActAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public ChangeActAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	//System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED ChangeActAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[20];

	try {
		pd [0] = new PropertyDescriptor("blankdate", ChangeActAccessBean.class);
		pd [1] = new PropertyDescriptor("blanknumber", ChangeActAccessBean.class);
		pd [2] = new PropertyDescriptor("document", ChangeActAccessBean.class);
		pd [3] = new PropertyDescriptor("documentState", ChangeActAccessBean.class);
		pd [4] = new PropertyDescriptor("insuranceact", ChangeActAccessBean.class);
		pd [5] = new PropertyDescriptor("insurancedate", ChangeActAccessBean.class);
		pd [6] = new PropertyDescriptor("insuranseMan", ChangeActAccessBean.class);
		pd [7] = new PropertyDescriptor("processDestination", ChangeActAccessBean.class);
		pd [8] = new PropertyDescriptor("processSource", ChangeActAccessBean.class);
		pd [9] = new PropertyDescriptor("contragent", ChangeActAccessBean.class, "getContragent", null);
		pd [10] = new PropertyDescriptor("from", ChangeActAccessBean.class, "getFrom", null);
		pd [11] = new PropertyDescriptor("owner", ChangeActAccessBean.class, "getOwner", null);
		pd [12] = new PropertyDescriptor("storageManager", ChangeActAccessBean.class, "getStorageManager", null);
		pd [13] = new PropertyDescriptor("to", ChangeActAccessBean.class, "getTo", null);
		pd [14] = new PropertyDescriptor("blankindex", ChangeActAccessBean.class);
		pd [15] = new PropertyDescriptor("acttype", ChangeActAccessBean.class);
		pd [16] = new PropertyDescriptor("needapprove", ChangeActAccessBean.class);
		pd [17] = new PropertyDescriptor("projectid", ChangeActAccessBean.class);
		pd [18] = new PropertyDescriptor("prjstatus", ChangeActAccessBean.class);
		pd [19] = new PropertyDescriptor("visualtagid", ChangeActAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
