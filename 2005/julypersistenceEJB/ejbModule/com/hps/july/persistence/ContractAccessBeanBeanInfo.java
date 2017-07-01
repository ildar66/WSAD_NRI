package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class ContractAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public ContractAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED ContractAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");

	PropertyDescriptor[] pd = new PropertyDescriptor[33];

	try {
		pd [0] = new PropertyDescriptor("finishDate", ContractAccessBean.class);
		pd [1] = new PropertyDescriptor("name", ContractAccessBean.class);
		pd [2] = new PropertyDescriptor("startDate", ContractAccessBean.class);
		pd [3] = new PropertyDescriptor("sum", ContractAccessBean.class);
		pd [4] = new PropertyDescriptor("contractState", ContractAccessBean.class);
		pd [5] = new PropertyDescriptor("blankdate", ContractAccessBean.class);
		pd [6] = new PropertyDescriptor("blanknumber", ContractAccessBean.class);
		pd [7] = new PropertyDescriptor("document", ContractAccessBean.class);
		pd [8] = new PropertyDescriptor("documentState", ContractAccessBean.class);
		pd [9] = new PropertyDescriptor("insuranceact", ContractAccessBean.class);
		pd [10] = new PropertyDescriptor("insurancedate", ContractAccessBean.class);
		pd [11] = new PropertyDescriptor("baseAgreement", ContractAccessBean.class, "getBaseAgreement", null);
		pd [12] = new PropertyDescriptor("supplyType", ContractAccessBean.class, "getSupplyType", null);
		pd [13] = new PropertyDescriptor("cardTrack", ContractAccessBean.class, "getCardTrack", null);
		pd [14] = new PropertyDescriptor("controller", ContractAccessBean.class, "getController", null);
		pd [15] = new PropertyDescriptor("currency", ContractAccessBean.class, "getCurrency", null);
		pd [16] = new PropertyDescriptor("storageCard", ContractAccessBean.class, "getStorageCard", null);
		pd [17] = new PropertyDescriptor("i13nActPosition", ContractAccessBean.class, "getI13nActPosition", null);
		pd [18] = new PropertyDescriptor("worker", ContractAccessBean.class, "getWorker", null);
		pd [19] = new PropertyDescriptor("contragent", ContractAccessBean.class, "getContragent", null);
		pd [20] = new PropertyDescriptor("currentStorageCard", ContractAccessBean.class, "getCurrentStorageCard", null);
		pd [21] = new PropertyDescriptor("documentAction", ContractAccessBean.class, "getDocumentAction", null);
		pd [22] = new PropertyDescriptor("documentPosition", ContractAccessBean.class, "getDocumentPosition", null);
		pd [23] = new PropertyDescriptor("documentsLinkFrom", ContractAccessBean.class, "getDocumentsLinkFrom", null);
		pd [24] = new PropertyDescriptor("documentsLinkTo", ContractAccessBean.class, "getDocumentsLinkTo", null);
		pd [25] = new PropertyDescriptor("from", ContractAccessBean.class, "getFrom", null);
		pd [26] = new PropertyDescriptor("to", ContractAccessBean.class, "getTo", null);
		pd [27] = new PropertyDescriptor("owner", ContractAccessBean.class, "getOwner", null);
		pd [28] = new PropertyDescriptor("textFileName", ContractAccessBean.class);
		pd [29] = new PropertyDescriptor("timelineFileName", ContractAccessBean.class);
		pd [30] = new PropertyDescriptor("needapprove", ContractAccessBean.class);
		pd [31] = new PropertyDescriptor("projectid", ContractAccessBean.class);
		pd [32] = new PropertyDescriptor("prjstatus", ContractAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
