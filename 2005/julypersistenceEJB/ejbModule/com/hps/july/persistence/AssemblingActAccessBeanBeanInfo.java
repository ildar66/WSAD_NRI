package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class AssemblingActAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public AssemblingActAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {


	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED AssemblingActAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[26];

	try {
		pd [0] = new PropertyDescriptor("agregat", AssemblingActAccessBean.class, "getAgregat", null);
		pd [1] = new PropertyDescriptor("contragent", AssemblingActAccessBean.class, "getContragent", null);
		pd [2] = new PropertyDescriptor("from", AssemblingActAccessBean.class, "getFrom", null);
		pd [3] = new PropertyDescriptor("to", AssemblingActAccessBean.class, "getTo", null);
		pd [4] = new PropertyDescriptor("monter", AssemblingActAccessBean.class, "getMonter", null);
		pd [5] = new PropertyDescriptor("owner", AssemblingActAccessBean.class, "getOwner", null);
		pd [6] = new PropertyDescriptor("storageManager", AssemblingActAccessBean.class, "getStorageManager", null);
		pd [7] = new PropertyDescriptor("blankdate", AssemblingActAccessBean.class);
		pd [8] = new PropertyDescriptor("blanknumber", AssemblingActAccessBean.class);
		pd [9] = new PropertyDescriptor("document", AssemblingActAccessBean.class);
		pd [10] = new PropertyDescriptor("documentState", AssemblingActAccessBean.class);
		pd [11] = new PropertyDescriptor("insuranceact", AssemblingActAccessBean.class);
		pd [12] = new PropertyDescriptor("insurancedate", AssemblingActAccessBean.class);
		pd [13] = new PropertyDescriptor("newConfiguration", AssemblingActAccessBean.class);
		pd [14] = new PropertyDescriptor("oldConfiguration", AssemblingActAccessBean.class);
		pd [15] = new PropertyDescriptor("operationType", AssemblingActAccessBean.class);
		pd [16] = new PropertyDescriptor("processSource", AssemblingActAccessBean.class);
		pd [17] = new PropertyDescriptor("processDestination", AssemblingActAccessBean.class);
		pd [18] = new PropertyDescriptor("blankindex", AssemblingActAccessBean.class);
		pd [19] = new PropertyDescriptor("agregateresource", AssemblingActAccessBean.class);
		pd [20] = new PropertyDescriptor("needapprove", AssemblingActAccessBean.class);
		pd [21] = new PropertyDescriptor("projectid", AssemblingActAccessBean.class);
		pd [22] = new PropertyDescriptor("prjstatus", AssemblingActAccessBean.class);
		pd [23] = new PropertyDescriptor("visualtype", AssemblingActAccessBean.class);
		pd [24] = new PropertyDescriptor("inventserial", AssemblingActAccessBean.class);
		pd [25] = new PropertyDescriptor("localserial", AssemblingActAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
