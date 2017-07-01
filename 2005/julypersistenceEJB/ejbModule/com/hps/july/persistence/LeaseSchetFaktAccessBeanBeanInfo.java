package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (23.05.2003 11:22:21)
 * @author: Sergey Gourov
 */
public class LeaseSchetFaktAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public PropertyDescriptor[] getPropertyDescriptors() {
	System.out.println("!!!!!!!!!! Called LeaseSchetFaktAccessBeanBeanInfo !!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[16];
	
	try {
		pd [0] = new PropertyDescriptor("baseDocDate", LeaseSchetFaktAccessBean.class);
		pd [1] = new PropertyDescriptor("baseDocNumber", LeaseSchetFaktAccessBean.class);
		pd [2] = new PropertyDescriptor("dateSchetFakt", LeaseSchetFaktAccessBean.class);
		pd [3] = new PropertyDescriptor("idAct", LeaseSchetFaktAccessBean.class, "getIdAct", null);
		pd [4] = new PropertyDescriptor("idContract", LeaseSchetFaktAccessBean.class, "getIdContract", null);
		pd [5] = new PropertyDescriptor("idCurrency", LeaseSchetFaktAccessBean.class, "getIdCurrency", null);
		pd [6] = new PropertyDescriptor("idSchetFakt", LeaseSchetFaktAccessBean.class, "getIdSchetFakt", null);
		pd [7] = new PropertyDescriptor("numberSchetFakt", LeaseSchetFaktAccessBean.class);
		pd [8] = new PropertyDescriptor("dateStartSf", LeaseSchetFaktAccessBean.class);
		pd [9] = new PropertyDescriptor("dateEndSf", LeaseSchetFaktAccessBean.class);
		pd [10] = new PropertyDescriptor("created", LeaseSchetFaktAccessBean.class);
		pd [11] = new PropertyDescriptor("createdBy", LeaseSchetFaktAccessBean.class);
		pd [12] = new PropertyDescriptor("modified", LeaseSchetFaktAccessBean.class);
		pd [13] = new PropertyDescriptor("modifiedBy", LeaseSchetFaktAccessBean.class);
		pd [14] = new PropertyDescriptor("state", LeaseSchetFaktAccessBean.class);
		pd [15] = new PropertyDescriptor("idRegistryDoc", LeaseSchetFaktAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace();
	}
	return null;
}
}
