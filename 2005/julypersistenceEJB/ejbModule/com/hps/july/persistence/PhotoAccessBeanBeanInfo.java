package com.hps.july.persistence;

import java.beans.*;

public class PhotoAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
	/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	System.out.println("PhotoAccessBeanBeanInfo called!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[7];
	try {
		pd [0] = new PropertyDescriptor("date", PhotoAccessBean.class);
		pd [1] = new PropertyDescriptor("description", PhotoAccessBean.class);
		pd [2] = new PropertyDescriptor("filename", PhotoAccessBean.class);
		pd [3] = new PropertyDescriptor("image", PhotoAccessBean.class);
		pd [4] = new PropertyDescriptor("photo", PhotoAccessBean.class);
		pd [5] = new PropertyDescriptor("photographer", PhotoAccessBean.class, "getPhotographer", null);
		pd [6] = new PropertyDescriptor("position", PhotoAccessBean.class, "getPosition", null);
		
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
