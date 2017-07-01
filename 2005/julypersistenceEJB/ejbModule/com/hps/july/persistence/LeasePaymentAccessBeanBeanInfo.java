package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (25.07.2002 19:12:48)
 * @author: Sergey Gourov
 */
public class LeasePaymentAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED LeasePaymentAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[23];
	
	try {
		pd [0] = new PropertyDescriptor("act", LeasePaymentAccessBean.class, "getAct", null);
		pd [1] = new PropertyDescriptor("begindate", LeasePaymentAccessBean.class);
		pd [2] = new PropertyDescriptor("currency", LeasePaymentAccessBean.class, "getCurrency", null);
		pd [3] = new PropertyDescriptor("date", LeasePaymentAccessBean.class);
		pd [4] = new PropertyDescriptor("docNumber", LeasePaymentAccessBean.class);
		pd [5] = new PropertyDescriptor("docposvid", LeasePaymentAccessBean.class);
		pd [6] = new PropertyDescriptor("enddate", LeasePaymentAccessBean.class);
		pd [7] = new PropertyDescriptor("leaseContract", LeasePaymentAccessBean.class, "getLeaseContract" ,null);
		pd [8] = new PropertyDescriptor("leaseDocPosition", LeasePaymentAccessBean.class);
		pd [9] = new PropertyDescriptor("leaseRule", LeasePaymentAccessBean.class, "getLeaseRule", null);
		pd [10] = new PropertyDescriptor("ndsRub", LeasePaymentAccessBean.class);
		pd [11] = new PropertyDescriptor("paymentstate", LeasePaymentAccessBean.class);
		pd [12] = new PropertyDescriptor("paymentType", LeasePaymentAccessBean.class);
		pd [13] = new PropertyDescriptor("payrate", LeasePaymentAccessBean.class);
		pd [14] = new PropertyDescriptor("resource", LeasePaymentAccessBean.class, "getResource", null);
		pd [15] = new PropertyDescriptor("rurremainder", LeasePaymentAccessBean.class);
		pd [16] = new PropertyDescriptor("source", LeasePaymentAccessBean.class);
		pd [17] = new PropertyDescriptor("summ", LeasePaymentAccessBean.class);
		pd [18] = new PropertyDescriptor("sumnds", LeasePaymentAccessBean.class);
		pd [19] = new PropertyDescriptor("sumRub", LeasePaymentAccessBean.class);
		pd [20] = new PropertyDescriptor("isSchetFakt", LeasePaymentAccessBean.class);
		pd [21] = new PropertyDescriptor("willbeinact", LeasePaymentAccessBean.class);
		pd [22] = new PropertyDescriptor("flagOplNds", LeasePaymentAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
