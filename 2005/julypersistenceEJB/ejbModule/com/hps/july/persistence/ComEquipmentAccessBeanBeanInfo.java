package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (01.10.2003 16:02:47)
 * @author: Maxim Gerasimov
 */
public class ComEquipmentAccessBeanBeanInfo extends SimpleBeanInfo {
/**
 * ComEquipmentAccessBeanBeanInfo constructor comment.
 */
public ComEquipmentAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[20];
	try {
		pd [0] = new PropertyDescriptor("address", ComEquipmentAccessBean.class);
		pd [1] = new PropertyDescriptor("closedate", ComEquipmentAccessBean.class);
		pd [2] = new PropertyDescriptor("comEquipmentType", ComEquipmentAccessBean.class);
		pd [3] = new PropertyDescriptor("dateassemb", ComEquipmentAccessBean.class);
		pd [4] = new PropertyDescriptor("datebldbeg", ComEquipmentAccessBean.class);
		pd [5] = new PropertyDescriptor("datepr", ComEquipmentAccessBean.class);
		pd [6] = new PropertyDescriptor("datetest", ComEquipmentAccessBean.class);
		pd [7] = new PropertyDescriptor("equipcomment", ComEquipmentAccessBean.class);
		pd [8] = new PropertyDescriptor("equipmentState", ComEquipmentAccessBean.class);
		pd [9] = new PropertyDescriptor("name", ComEquipmentAccessBean.class);
		pd [10] = new PropertyDescriptor("operator", ComEquipmentAccessBean.class);
		pd [11] = new PropertyDescriptor("pwrcat", ComEquipmentAccessBean.class);
		pd [12] = new PropertyDescriptor("pwrrescat", ComEquipmentAccessBean.class);
		pd [13] = new PropertyDescriptor("pwrreserve", ComEquipmentAccessBean.class);
		pd [14] = new PropertyDescriptor("pwrval", ComEquipmentAccessBean.class);
		pd [15] = new PropertyDescriptor("storageplace", ComEquipmentAccessBean.class);
		pd [16] = new PropertyDescriptor("division", ComEquipmentAccessBean.class, "getDivision", null);
		pd [17] = new PropertyDescriptor("position", ComEquipmentAccessBean.class, "getPosition", null);
		pd [18] = new PropertyDescriptor("resource", ComEquipmentAccessBean.class, "getResource", null);
		pd [19] = new PropertyDescriptor("datasource", ComEquipmentAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
