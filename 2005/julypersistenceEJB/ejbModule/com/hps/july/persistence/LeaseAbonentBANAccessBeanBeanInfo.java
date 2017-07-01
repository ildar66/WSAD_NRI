package com.hps.july.persistence;

import java.util.*;
import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (16.10.2003 12:52:47)
 * @author: Maxim Gerasimov
 */
public class LeaseAbonentBANAccessBeanBeanInfo extends java.beans.SimpleBeanInfo{
/**
 * LeaseAbonentBANAccessBeanBeanInfo constructor comment.
 */
public LeaseAbonentBANAccessBeanBeanInfo() {
	super();
}
public java.beans.PropertyDescriptor[] getPropertyDescriptors() {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED LeaseAbonentBanAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[37];

	try {
		pd [0] = new PropertyDescriptor("contractState",		LeaseAbonentBANAccessBean.class);
		pd [1] = new PropertyDescriptor("contractType",			LeaseAbonentBANAccessBean.class);
		pd [2] = new PropertyDescriptor("currency1",			LeaseAbonentBANAccessBean.class, "getCurrency1", null);
		pd [3] = new PropertyDescriptor("currency2", 			LeaseAbonentBANAccessBean.class, "getCurrency2", null);
		pd [4] = new PropertyDescriptor("documentDate",			LeaseAbonentBANAccessBean.class);
		pd [5] = new PropertyDescriptor("documentNumber",		LeaseAbonentBANAccessBean.class);
		pd [6] = new PropertyDescriptor("economist",			LeaseAbonentBANAccessBean.class, "getEconomist", null);
		pd [7] = new PropertyDescriptor("endDate",				LeaseAbonentBANAccessBean.class);
		pd [8] = new PropertyDescriptor("extendPeriod",			LeaseAbonentBANAccessBean.class);
		pd [9] = new PropertyDescriptor("extendType",			LeaseAbonentBANAccessBean.class);
		pd [10] = new PropertyDescriptor("leaseDocument",		LeaseAbonentBANAccessBean.class);
		pd [11] = new PropertyDescriptor("leaseMutualContracts",LeaseAbonentBANAccessBean.class, "getLeaseMutualContracts", null);
		pd [12] = new PropertyDescriptor("leaseRules",			LeaseAbonentBANAccessBean.class, "getLeaseRules", null);
		pd [13] = new PropertyDescriptor("orgCustomer",			LeaseAbonentBANAccessBean.class, "getOrgCustomer", null);
		pd [14] = new PropertyDescriptor("orgExecutor",			LeaseAbonentBANAccessBean.class, "getOrgExecutor", null);
		pd [15] = new PropertyDescriptor("reportPeriod",		LeaseAbonentBANAccessBean.class);
		pd [16] = new PropertyDescriptor("startDate",			LeaseAbonentBANAccessBean.class);
		pd [17] = new PropertyDescriptor("summ1",				LeaseAbonentBANAccessBean.class);
		pd [18] = new PropertyDescriptor("summ2",				LeaseAbonentBANAccessBean.class);
		
		pd [19] = new PropertyDescriptor("accounttype",			LeaseAbonentBANAccessBean.class);
		pd [20] = new PropertyDescriptor("bil_acctypename",		LeaseAbonentBANAccessBean.class);
		pd [21] = new PropertyDescriptor("bil_billaddress",		LeaseAbonentBANAccessBean.class);
		pd [22] = new PropertyDescriptor("bil_contrstatus",		LeaseAbonentBANAccessBean.class);
		pd [23] = new PropertyDescriptor("bil_contrstname",		LeaseAbonentBANAccessBean.class);
		pd [24] = new PropertyDescriptor("bil_inn",				LeaseAbonentBANAccessBean.class);
		pd [25] = new PropertyDescriptor("bil_name",			LeaseAbonentBANAccessBean.class);
		pd [26] = new PropertyDescriptor("bil_startservdate",	LeaseAbonentBANAccessBean.class);
		pd [27] = new PropertyDescriptor("bil_suspdate",		LeaseAbonentBANAccessBean.class);
		pd [28] = new PropertyDescriptor("bil_contrstdate",		LeaseAbonentBANAccessBean.class);
		pd [29] = new PropertyDescriptor("ban",					LeaseAbonentBANAccessBean.class);
		pd [30] = new PropertyDescriptor("flagworkpie",			LeaseAbonentBANAccessBean.class);
		pd [31] = new PropertyDescriptor("useallben",			LeaseAbonentBANAccessBean.class);
		pd [32] = new PropertyDescriptor("chargeNds", LeaseAbonentBANAccessBean.class);
		pd [33] = new PropertyDescriptor("balans", LeaseAbonentBANAccessBean.class);
		pd [34] = new PropertyDescriptor("regionid", LeaseAbonentBANAccessBean.class);
		pd [35] = new PropertyDescriptor("RateNDS", LeaseAbonentBANAccessBean.class);
		pd [36] = new PropertyDescriptor("NalogAgent", LeaseAbonentBANAccessBean.class);

		return pd;
	} catch (IntrospectionException ex) {
		System.out.println("Error in "+this.getClass().getName());
		ex.printStackTrace(System.out);
	}
	return null;

}
}
