package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (09.07.2002 16:46:01)
 * @author: Sergey Gourov
 */
public class LeaseChargeRuleAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * LeaseChargeRuleAccessBeanBeanInfo constructor comment.
 */
public LeaseChargeRuleAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[7];

	try {
		pd [0] = new PropertyDescriptor("chargeDateRule", LeaseChargeRuleAccessBean.class);
		pd [1] = new PropertyDescriptor("chargePeriod", LeaseChargeRuleAccessBean.class);
		pd [2] = new PropertyDescriptor("curency", LeaseChargeRuleAccessBean.class, "getCurency", null);
		pd [3] = new PropertyDescriptor("leaseDocument", LeaseChargeRuleAccessBean.class, "getLeaseDocument", null);
		pd [4] = new PropertyDescriptor("leaseRule", LeaseChargeRuleAccessBean.class);
		pd [5] = new PropertyDescriptor("resource", LeaseChargeRuleAccessBean.class, "getResource", null);
		pd [6] = new PropertyDescriptor("sum", LeaseChargeRuleAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
