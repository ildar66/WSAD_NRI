package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class StorageCardAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public StorageCardAccessBeanBeanInfo() {
	super();
}
public PropertyDescriptor[] getPropertyDescriptors()  {
//	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED StorageCardAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[31];
	try {
		pd [0] = new PropertyDescriptor("boxed", StorageCardAccessBean.class);
		pd [1] = new PropertyDescriptor("broken", StorageCardAccessBean.class);
		pd [2] = new PropertyDescriptor("closed", StorageCardAccessBean.class);
		pd [3] = new PropertyDescriptor("configuration", StorageCardAccessBean.class);
		pd [4] = new PropertyDescriptor("dateclosed", StorageCardAccessBean.class);
		pd [5] = new PropertyDescriptor("dateopened", StorageCardAccessBean.class);
		pd [6] = new PropertyDescriptor("i13nDate", StorageCardAccessBean.class);
		pd [7] = new PropertyDescriptor("notes", StorageCardAccessBean.class);
		pd [8] = new PropertyDescriptor("party", StorageCardAccessBean.class);
		pd [9] = new PropertyDescriptor("policy", StorageCardAccessBean.class);
		pd[10] = new PropertyDescriptor("price", StorageCardAccessBean.class);
		pd[11] = new PropertyDescriptor("qty", StorageCardAccessBean.class);
		pd[12] = new PropertyDescriptor("qtyBroken", StorageCardAccessBean.class);
		pd[13] = new PropertyDescriptor("serialnumber", StorageCardAccessBean.class);
		pd[14] = new PropertyDescriptor("storagecard", StorageCardAccessBean.class);
		pd[15] = new PropertyDescriptor("agregate", StorageCardAccessBean.class, "getAgregate", null);
		pd[16] = new PropertyDescriptor("agregateContent", StorageCardAccessBean.class, "getAgregateContent", null);
		pd[17] = new PropertyDescriptor("assemblingAct", StorageCardAccessBean.class, "getAssemblingAct", null);
		pd[18] = new PropertyDescriptor("cardTrack", StorageCardAccessBean.class, "getCardTrack", null);
		pd[19] = new PropertyDescriptor("contract", StorageCardAccessBean.class, "getContract", null);
		pd[20] = new PropertyDescriptor("currentstorage", StorageCardAccessBean.class, "getCurrentstorage", null);
		pd[21] = new PropertyDescriptor("i13nAct", StorageCardAccessBean.class, "getI13nAct", null);
		pd[22] = new PropertyDescriptor("i13nDateSaving", StorageCardAccessBean.class, "getI13nDateSaving", null);
		pd[23] = new PropertyDescriptor("inDocumentPosition", StorageCardAccessBean.class, "getInDocumentPosition", null);
		pd[24] = new PropertyDescriptor("lastDocument", StorageCardAccessBean.class, "getLastDocument", null);
		pd[25] = new PropertyDescriptor("outDocumentPosition", StorageCardAccessBean.class, "getOutDocumentPosition", null);
		pd[26] = new PropertyDescriptor("owner", StorageCardAccessBean.class, "getOwner", null);
		pd[27] = new PropertyDescriptor("resource", StorageCardAccessBean.class, "getResource", null);
		pd[28] = new PropertyDescriptor("place", StorageCardAccessBean.class);
		pd[29] = new PropertyDescriptor("manufserial", StorageCardAccessBean.class);
		pd[30] = new PropertyDescriptor("isfictserial", StorageCardAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
//		System.out.println("!!!!!!!!!!!!!! BeanInfo EXCEPTION StorageCardAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
		ex.printStackTrace(System.out);
	}
	return null;
}
}
