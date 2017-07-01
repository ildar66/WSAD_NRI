package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class ControllerAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public ControllerAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	System.out.println("!!!!BeanInfo ControllerAccessBeanBeanInfo!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[38];

	try {
		pd [0]	= new PropertyDescriptor("address", ControllerAccessBean.class);
		pd [1]	= new PropertyDescriptor("aint_qty", ControllerAccessBean.class);
		pd [2]	= new PropertyDescriptor("atr_qty", ControllerAccessBean.class);
		pd [3]	= new PropertyDescriptor("atr_qty_max", ControllerAccessBean.class);
		pd [4]	= new PropertyDescriptor("closedate", ControllerAccessBean.class);
		pd [5]	= new PropertyDescriptor("commentctrl", ControllerAccessBean.class);
		pd [6]	= new PropertyDescriptor("controllerName", ControllerAccessBean.class);
		pd [7]	= new PropertyDescriptor("contype", ControllerAccessBean.class);
		pd [8]	= new PropertyDescriptor("dateassemb", ControllerAccessBean.class);
		pd [9]	= new PropertyDescriptor("datebldbeg", ControllerAccessBean.class);
		pd [10]	= new PropertyDescriptor("datepr", ControllerAccessBean.class);
		pd [11]	= new PropertyDescriptor("datetest", ControllerAccessBean.class);
		pd [12]	= new PropertyDescriptor("equipcomment", ControllerAccessBean.class);
		pd [13]	= new PropertyDescriptor("equipmentState", ControllerAccessBean.class);
		pd [14]	= new PropertyDescriptor("hway_qty_grps", ControllerAccessBean.class);
		pd [15]	= new PropertyDescriptor("hway_qty_voice", ControllerAccessBean.class);
		pd [16]	= new PropertyDescriptor("lac_numbers", ControllerAccessBean.class);
		pd [17]	= new PropertyDescriptor("mfs_num", ControllerAccessBean.class);
		pd [18]	= new PropertyDescriptor("name", ControllerAccessBean.class);
		pd [19]	= new PropertyDescriptor("number", ControllerAccessBean.class);
		pd [20]	= new PropertyDescriptor("omcr_num", ControllerAccessBean.class);
		pd [21]	= new PropertyDescriptor("operator", ControllerAccessBean.class);
		pd [22]	= new PropertyDescriptor("pwrcat", ControllerAccessBean.class);
		pd [23]	= new PropertyDescriptor("pwrrescat", ControllerAccessBean.class);
		pd [24]	= new PropertyDescriptor("pwrreserve", ControllerAccessBean.class);
		pd [25]	= new PropertyDescriptor("pwrval", ControllerAccessBean.class);
		pd [26]	= new PropertyDescriptor("qtyshell", ControllerAccessBean.class);
		pd [27]	= new PropertyDescriptor("storageplace", ControllerAccessBean.class);
		pd [28]	= new PropertyDescriptor("trx_use_percent", ControllerAccessBean.class);
		pd [29]	= new PropertyDescriptor("trxfr_qty", ControllerAccessBean.class);
		pd [30]	= new PropertyDescriptor("trxfr_qty_max", ControllerAccessBean.class);
		pd [31]	= new PropertyDescriptor("trxhr_qty", ControllerAccessBean.class);
		pd [32]	= new PropertyDescriptor("verpo", ControllerAccessBean.class);

		pd [33]	= new PropertyDescriptor("division", ControllerAccessBean.class, "getDivision", null);
		pd [34]	= new PropertyDescriptor("position", ControllerAccessBean.class, "getPosition", null);
		pd [35]	= new PropertyDescriptor("resource", ControllerAccessBean.class, "getResource", null);
		pd [36]	= new PropertyDescriptor("switch", ControllerAccessBean.class, "getSwitch", null);
		pd [37]	= new PropertyDescriptor("datasource", ControllerAccessBean.class);
		
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
