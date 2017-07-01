package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class SwitchAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public SwitchAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {


	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED SwitchAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[10];

	try {
		pd [0] = new PropertyDescriptor("division", SwitchAccessBean.class, "getDivision", null);
		pd [1] = new PropertyDescriptor("position", SwitchAccessBean.class, "getPosition", null);
		pd [2] = new PropertyDescriptor("address", SwitchAccessBean.class);
		pd [3] = new PropertyDescriptor("closedate", SwitchAccessBean.class);
		pd [4] = new PropertyDescriptor("switchType", SwitchAccessBean.class);
		pd [5] = new PropertyDescriptor("equipmentState", SwitchAccessBean.class);
		pd [6] = new PropertyDescriptor("name", SwitchAccessBean.class);
		pd [7] = new PropertyDescriptor("number", SwitchAccessBean.class);
		pd [8] = new PropertyDescriptor("storageplace", SwitchAccessBean.class);
		pd [9] = new PropertyDescriptor("datasource", SwitchAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
