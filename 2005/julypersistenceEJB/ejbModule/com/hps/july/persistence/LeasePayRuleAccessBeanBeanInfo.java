package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (27.07.2002 14:20:40)
 * @author: Sergey Gourov
 */
public class LeasePayRuleAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * LeasePayRuleAccessBeanBeanInfo constructor comment.
 */
public LeasePayRuleAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
	System.out.println("Called LeasePayRuleAccessBeanBeanInfo !!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[16];
	
	try {
		pd [0] = new PropertyDescriptor("currency", LeasePayRuleAccessBean.class, "getCurrency", null);
		pd [1] = new PropertyDescriptor("leaseDocument", LeasePayRuleAccessBean.class, "getLeaseDocument", null);
		pd [2] = new PropertyDescriptor("leasePayment", LeasePayRuleAccessBean.class, "getLeasePayment", null);
		pd [3] = new PropertyDescriptor("leaseRule", LeasePayRuleAccessBean.class);
		pd [4] = new PropertyDescriptor("orgAcc", LeasePayRuleAccessBean.class, "getOrgAcc", null);
		pd [5] = new PropertyDescriptor("orgToPay", LeasePayRuleAccessBean.class, "getOrgToPay", null);
		pd [6] = new PropertyDescriptor("payBeforeDate", LeasePayRuleAccessBean.class);
		pd [7] = new PropertyDescriptor("payPeriod", LeasePayRuleAccessBean.class);
		pd [8] = new PropertyDescriptor("payPurpose", LeasePayRuleAccessBean.class);
		pd [9] = new PropertyDescriptor("payTerms", LeasePayRuleAccessBean.class);
		pd [10] = new PropertyDescriptor("payType", LeasePayRuleAccessBean.class);
		pd [11] = new PropertyDescriptor("ppType", LeasePayRuleAccessBean.class);
		pd [12] = new PropertyDescriptor("resource", LeasePayRuleAccessBean.class, "getResource", null);
		pd [13] = new PropertyDescriptor("sum", LeasePayRuleAccessBean.class);
		pd [14] = new PropertyDescriptor("separateNdsPay", LeasePayRuleAccessBean.class);
		pd [15] = new PropertyDescriptor("validdatepay", LeasePayRuleAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace();
	}
	return null;
}
}
