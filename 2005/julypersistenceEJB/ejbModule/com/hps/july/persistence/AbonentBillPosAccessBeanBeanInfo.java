package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (09.10.2002 10:20:47)
 * @author: Sergey Gourov
 */
public class AbonentBillPosAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * AbonentBillPosAccessBeanBeanInfo constructor comment.
 */
public AbonentBillPosAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED AbonentBillPosAccessBeanBeanInfo !!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[22];
	
	try {
		pd [0] = new PropertyDescriptor("billpos", AbonentBillPosAccessBean.class, "getBillpos", null);
		pd [1] = new PropertyDescriptor("cargocountry", AbonentBillPosAccessBean.class);
		pd [2] = new PropertyDescriptor("cargonumber", AbonentBillPosAccessBean.class);
		pd [3] = new PropertyDescriptor("itemid", AbonentBillPosAccessBean.class);
		pd [4] = new PropertyDescriptor("itemname", AbonentBillPosAccessBean.class);
		pd [5] = new PropertyDescriptor("ndsrate", AbonentBillPosAccessBean.class);
		pd [6] = new PropertyDescriptor("ndssumm", AbonentBillPosAccessBean.class);
		pd [7] = new PropertyDescriptor("nsprate", AbonentBillPosAccessBean.class);
		pd [8] = new PropertyDescriptor("nspsumm", AbonentBillPosAccessBean.class);
		pd [9] = new PropertyDescriptor("pos2bill", AbonentBillPosAccessBean.class, "getPos2bill", null);
		pd [10] = new PropertyDescriptor("pos2currency", AbonentBillPosAccessBean.class, "getPos2currency", null);
		pd [11] = new PropertyDescriptor("pos2resource", AbonentBillPosAccessBean.class, "getPos2resource", null);
		pd [12] = new PropertyDescriptor("qty", AbonentBillPosAccessBean.class);
		pd [13] = new PropertyDescriptor("summ", AbonentBillPosAccessBean.class);
		pd [14] = new PropertyDescriptor("summpure", AbonentBillPosAccessBean.class);
		pd [15] = new PropertyDescriptor("unitname", AbonentBillPosAccessBean.class);
		pd [16] = new PropertyDescriptor("ndssummnri", AbonentBillPosAccessBean.class);
		pd [17] = new PropertyDescriptor("nspsummnri", AbonentBillPosAccessBean.class);
		pd [18] = new PropertyDescriptor("summnri", AbonentBillPosAccessBean.class);
		pd [19] = new PropertyDescriptor("summpurenri", AbonentBillPosAccessBean.class);
		pd [20] = new PropertyDescriptor("recordstatus", AbonentBillPosAccessBean.class);
		pd [21] = new PropertyDescriptor("sumbyhand", AbonentBillPosAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
