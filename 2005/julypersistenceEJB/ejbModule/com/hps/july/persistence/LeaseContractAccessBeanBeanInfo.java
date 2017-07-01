package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (15.07.2002 10:43:14)
 * @author: Sergey Gourov
 */
public class LeaseContractAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * LeaseContractAccessBeanBeanInfo constructor comment.
 */
public LeaseContractAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2002 17:19:27)
 * @return java.beans.PropertyDescriptor[]
 */
public java.beans.PropertyDescriptor[] getPropertyDescriptors() {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED LeaseContractAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[37];

	try {
		pd [0] = new PropertyDescriptor("contractState", LeaseContractAccessBean.class);
		pd [1] = new PropertyDescriptor("contractType", LeaseContractAccessBean.class);
		pd [2] = new PropertyDescriptor("currency1", LeaseContractAccessBean.class, "getCurrency1", null);
		pd [3] = new PropertyDescriptor("currency2", LeaseContractAccessBean.class, "getCurrency2", null);
		pd [4] = new PropertyDescriptor("documentDate", LeaseContractAccessBean.class);
		pd [5] = new PropertyDescriptor("documentNumber", LeaseContractAccessBean.class);
		pd [6] = new PropertyDescriptor("economist", LeaseContractAccessBean.class, "getEconomist", null);
		pd [7] = new PropertyDescriptor("endDate", LeaseContractAccessBean.class);
		pd [8] = new PropertyDescriptor("extendPeriod", LeaseContractAccessBean.class);
		pd [9] = new PropertyDescriptor("extendType", LeaseContractAccessBean.class);
		pd [10] = new PropertyDescriptor("leaseDocument", LeaseContractAccessBean.class);
		pd [11] = new PropertyDescriptor("leaseMutualContracts", LeaseContractAccessBean.class, "getLeaseMutualContracts", null);
		pd [12] = new PropertyDescriptor("leaseRules", LeaseContractAccessBean.class, "getLeaseRules", null);
		pd [13] = new PropertyDescriptor("orgCustomer", LeaseContractAccessBean.class, "getOrgCustomer", null);
		pd [14] = new PropertyDescriptor("orgExecutor", LeaseContractAccessBean.class, "getOrgExecutor", null);
		pd [15] = new PropertyDescriptor("reportPeriod", LeaseContractAccessBean.class);
		pd [16] = new PropertyDescriptor("startDate", LeaseContractAccessBean.class);
		pd [17] = new PropertyDescriptor("summ1", LeaseContractAccessBean.class);
		pd [18] = new PropertyDescriptor("summ2", LeaseContractAccessBean.class);
		pd [19] = new PropertyDescriptor("chargeNds", LeaseContractAccessBean.class);
		pd [20] = new PropertyDescriptor("modified", LeaseContractAccessBean.class);
		pd [21] = new PropertyDescriptor("created", LeaseContractAccessBean.class);
		pd [22] = new PropertyDescriptor("modifiedby", LeaseContractAccessBean.class);
		pd [23] = new PropertyDescriptor("createdby", LeaseContractAccessBean.class);
		pd [24] = new PropertyDescriptor("changeenddate", LeaseContractAccessBean.class);
		pd [25] = new PropertyDescriptor("extendyears", LeaseContractAccessBean.class);
		pd [26] = new PropertyDescriptor("extendmonthes", LeaseContractAccessBean.class);
		pd [27] = new PropertyDescriptor("extenddays", LeaseContractAccessBean.class);
		pd [28] = new PropertyDescriptor("regionid", LeaseContractAccessBean.class);
		pd [29] = new PropertyDescriptor("RateNDS", LeaseContractAccessBean.class);
		pd [30] = new PropertyDescriptor("NalogAgent", LeaseContractAccessBean.class);
		pd [31] = new PropertyDescriptor("isRateLimit", LeaseContractAccessBean.class);
		pd [32] = new PropertyDescriptor("rateLimitMin", LeaseContractAccessBean.class);
		pd [33] = new PropertyDescriptor("rateLimitMax", LeaseContractAccessBean.class);
		pd [34] = new PropertyDescriptor("buchdocnumber", LeaseContractAccessBean.class);
		pd [35] = new PropertyDescriptor("havedocsigned", LeaseContractAccessBean.class);
		pd [36] = new PropertyDescriptor("havedocsignedcustomer", LeaseContractAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
