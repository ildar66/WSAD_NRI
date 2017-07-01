package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class StorageAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public StorageAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {


	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED StorageAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[11];

	try {
		pd [0] = new PropertyDescriptor("address", StorageAccessBean.class);
		pd [1] = new PropertyDescriptor("closedate", StorageAccessBean.class);
		pd [2] = new PropertyDescriptor("internalphone", StorageAccessBean.class);
		pd [3] = new PropertyDescriptor("name", StorageAccessBean.class);
		pd [4] = new PropertyDescriptor("pstnphone", StorageAccessBean.class);
		pd [5] = new PropertyDescriptor("storageplace", StorageAccessBean.class);
		pd [6] = new PropertyDescriptor("division", StorageAccessBean.class, "getDivision", null);
		pd [7] = new PropertyDescriptor("created", StorageAccessBean.class);
		pd [8] = new PropertyDescriptor("createdby", StorageAccessBean.class);
		pd [9] = new PropertyDescriptor("modified", StorageAccessBean.class);
		pd [10] = new PropertyDescriptor("modifiedby", StorageAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
