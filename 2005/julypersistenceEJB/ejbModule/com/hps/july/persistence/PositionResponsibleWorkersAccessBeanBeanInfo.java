package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class PositionResponsibleWorkersAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public PositionResponsibleWorkersAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED PositionResponsibleWorkersAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[5];
	
	try {
		pd [0] = new PropertyDescriptor("organization", PositionResponsibleWorkersAccessBean.class, "getOrganization", null);
		pd [1] = new PropertyDescriptor("position", PositionResponsibleWorkersAccessBean.class, "getPosition", null);
		pd [2] = new PropertyDescriptor("resptype", PositionResponsibleWorkersAccessBean.class, "getResptype", null);
		pd [3] = new PropertyDescriptor("type", PositionResponsibleWorkersAccessBean.class, "getType", null);
		pd [4] = new PropertyDescriptor("worker", PositionResponsibleWorkersAccessBean.class, "getWorker", null);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
