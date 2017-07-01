package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (31.07.2002 15:19:15)
 * @author: Sergey Gourov
 */
public class LeaseArendaAgreementNewAccessBeanBeanInfo extends SimpleBeanInfo {
/**
 * Insert the method's description here.
 * Creation date: (20.06.2002 17:19:27)
 * @return java.beans.PropertyDescriptor[]
 */
public java.beans.PropertyDescriptor[] getPropertyDescriptors() {
    System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED LeaseArendaAgreementNewAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
    PropertyDescriptor[] pd = new PropertyDescriptor[49];

    try {
        pd[0] = new PropertyDescriptor("contractState", LeaseArendaAgreementNewAccessBean.class);
        pd[1] = new PropertyDescriptor("contractType", LeaseArendaAgreementNewAccessBean.class);
        pd[2] = new PropertyDescriptor("currency1", LeaseArendaAgreementNewAccessBean.class, "getCurrency1", null);
        pd[3] = new PropertyDescriptor("currency2", LeaseArendaAgreementNewAccessBean.class, "getCurrency2", null);
        pd[4] = new PropertyDescriptor("documentDate", LeaseArendaAgreementNewAccessBean.class);
        pd[5] = new PropertyDescriptor("documentNumber", LeaseArendaAgreementNewAccessBean.class);
        pd[6] = new PropertyDescriptor("economist", LeaseArendaAgreementNewAccessBean.class, "getEconomist", null);
        pd[7] = new PropertyDescriptor("endDate", LeaseArendaAgreementNewAccessBean.class);
        pd[8] = new PropertyDescriptor("extendPeriod", LeaseArendaAgreementNewAccessBean.class);
        pd[9] = new PropertyDescriptor("extendType", LeaseArendaAgreementNewAccessBean.class);
        pd[10] = new PropertyDescriptor("leaseDocument", LeaseArendaAgreementNewAccessBean.class);
		pd [11] = new PropertyDescriptor("leaseMutualContracts", LeaseArendaAgreementNewAccessBean.class, "getLeaseMutualContracts", null);
        pd[12] = new PropertyDescriptor("leaseRules", LeaseArendaAgreementNewAccessBean.class, "getLeaseRules", null);
        pd[13] = new PropertyDescriptor("orgCustomer", LeaseArendaAgreementNewAccessBean.class, "getOrgCustomer", null);
        pd[14] = new PropertyDescriptor("orgExecutor", LeaseArendaAgreementNewAccessBean.class, "getOrgExecutor", null);
        pd[15] = new PropertyDescriptor("reportPeriod", LeaseArendaAgreementNewAccessBean.class);
        pd[16] = new PropertyDescriptor("startDate", LeaseArendaAgreementNewAccessBean.class);
        pd[17] = new PropertyDescriptor("summ1", LeaseArendaAgreementNewAccessBean.class);
        pd[18] = new PropertyDescriptor("summ2", LeaseArendaAgreementNewAccessBean.class);
        pd[19] = new PropertyDescriptor("docFileName", LeaseArendaAgreementNewAccessBean.class);
        pd[20] = new PropertyDescriptor("mainDocument", LeaseArendaAgreementNewAccessBean.class);
        pd[21] = new PropertyDescriptor("isActive", LeaseArendaAgreementNewAccessBean.class);
        pd[22] = new PropertyDescriptor("chargeNds", LeaseArendaAgreementNewAccessBean.class);
        pd[23] = new PropertyDescriptor("officialdoc", LeaseArendaAgreementNewAccessBean.class);
        pd[24] = new PropertyDescriptor("dateclose", LeaseArendaAgreementNewAccessBean.class);
        pd[25] = new PropertyDescriptor("needofficialdoc", LeaseArendaAgreementNewAccessBean.class);
        pd[26] = new PropertyDescriptor("basestartdate", LeaseArendaAgreementNewAccessBean.class);
        pd[27] = new PropertyDescriptor("baseenddate", LeaseArendaAgreementNewAccessBean.class);
        pd[28] = new PropertyDescriptor("customerold", LeaseArendaAgreementNewAccessBean.class);
		pd [29] = new PropertyDescriptor("modified", LeaseArendaAgreementNewAccessBean.class);
		pd [30] = new PropertyDescriptor("created", LeaseArendaAgreementNewAccessBean.class);
		pd [31] = new PropertyDescriptor("modifiedby", LeaseArendaAgreementNewAccessBean.class);
		pd [32] = new PropertyDescriptor("createdby", LeaseArendaAgreementNewAccessBean.class);
		pd [33] = new PropertyDescriptor("changeenddate", LeaseArendaAgreementNewAccessBean.class);
		pd [34] = new PropertyDescriptor("extendyears", LeaseArendaAgreementNewAccessBean.class);
		pd [35] = new PropertyDescriptor("extendmonthes", LeaseArendaAgreementNewAccessBean.class);
		pd [36] = new PropertyDescriptor("extenddays", LeaseArendaAgreementNewAccessBean.class);
		pd [37] = new PropertyDescriptor("regionid", LeaseArendaAgreementNewAccessBean.class);
		pd [38] = new PropertyDescriptor("RateNDS", LeaseArendaAgreementNewAccessBean.class);
		pd [39] = new PropertyDescriptor("NalogAgent", LeaseArendaAgreementNewAccessBean.class);
		pd [40] = new PropertyDescriptor("haveioact", LeaseArendaAgreementNewAccessBean.class);
		pd [41] = new PropertyDescriptor("ioactnumber", LeaseArendaAgreementNewAccessBean.class);
		pd [42] = new PropertyDescriptor("ioactdate", LeaseArendaAgreementNewAccessBean.class);
		pd [43] = new PropertyDescriptor("isRateLimit", LeaseArendaAgreementNewAccessBean.class);
		pd [44] = new PropertyDescriptor("rateLimitMin", LeaseArendaAgreementNewAccessBean.class);
		pd [45] = new PropertyDescriptor("rateLimitMax", LeaseArendaAgreementNewAccessBean.class);
		pd [46] = new PropertyDescriptor("buchdocnumber", LeaseArendaAgreementNewAccessBean.class);
		pd [47] = new PropertyDescriptor("havedocsigned", LeaseArendaAgreementNewAccessBean.class);
		pd [48] = new PropertyDescriptor("havedocsignedcustomer", LeaseArendaAgreementNewAccessBean.class);
		
        return pd;
    } catch (IntrospectionException ex) {
        ex.printStackTrace(System.out);
    }
    return null;
}
}
