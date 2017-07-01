package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (20.06.2002 17:17:23)
 * @author: Sergey Gourov
 */
public class ContractPositionAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * ContractPositionAccessBeanBeanInfo constructor comment.
 */
public ContractPositionAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2002 17:19:27)
 * @return java.beans.PropertyDescriptor[]
 */
public java.beans.PropertyDescriptor[] getPropertyDescriptors() {
	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED ContractPositionAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[22];

	try {
		pd [0] = new PropertyDescriptor("agregate", ContractPositionAccessBean.class, "getAgregate", null);
		pd [1] = new PropertyDescriptor("cardFrom", ContractPositionAccessBean.class, "getCardFrom", null);
		pd [2] = new PropertyDescriptor("cardTo", ContractPositionAccessBean.class, "getCardTo", null);
		pd [3] = new PropertyDescriptor("configuration", ContractPositionAccessBean.class);
		pd [4] = new PropertyDescriptor("docposition", ContractPositionAccessBean.class);
		pd [5] = new PropertyDescriptor("document", ContractPositionAccessBean.class, "getDocument", null);
		pd [6] = new PropertyDescriptor("isReadOnly", ContractPositionAccessBean.class, "getIsReadOnly", null);
		pd [7] = new PropertyDescriptor("order", ContractPositionAccessBean.class);
		pd [8] = new PropertyDescriptor("owner", ContractPositionAccessBean.class, "getOwner", null);
		pd [9] = new PropertyDescriptor("party", ContractPositionAccessBean.class);
		pd [10] = new PropertyDescriptor("price", ContractPositionAccessBean.class);
		pd [11] = new PropertyDescriptor("qty", ContractPositionAccessBean.class);
		pd [12] = new PropertyDescriptor("resource", ContractPositionAccessBean.class, "getResource", null);
		pd [13] = new PropertyDescriptor("resultBoxed", ContractPositionAccessBean.class);
		pd [14] = new PropertyDescriptor("resultBroken", ContractPositionAccessBean.class);
		pd [15] = new PropertyDescriptor("resultClosed", ContractPositionAccessBean.class);
		pd [16] = new PropertyDescriptor("serialnumber", ContractPositionAccessBean.class);
		pd [17] = new PropertyDescriptor("sourceBoxed", ContractPositionAccessBean.class);
		pd [18] = new PropertyDescriptor("sourceBroken", ContractPositionAccessBean.class);
		pd [19] = new PropertyDescriptor("sourceClosed", ContractPositionAccessBean.class);
		pd [20] = new PropertyDescriptor("sum", ContractPositionAccessBean.class, "getSum", null);
		pd [21] = new PropertyDescriptor("contractPositionOrder", ContractPositionAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
