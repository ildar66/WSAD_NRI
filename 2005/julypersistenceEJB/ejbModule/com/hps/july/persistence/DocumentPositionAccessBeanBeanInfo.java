package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class DocumentPositionAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public DocumentPositionAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
//	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED DocumentPositionAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[29];

	try {
		pd [0] = new PropertyDescriptor("agregate", DocumentPositionAccessBean.class, "getAgregate", null);
		pd [1] = new PropertyDescriptor("cardFrom", DocumentPositionAccessBean.class, "getCardFrom", null);
		pd [2] = new PropertyDescriptor("cardTo", DocumentPositionAccessBean.class, "getCardTo", null);
		pd [3] = new PropertyDescriptor("configuration", DocumentPositionAccessBean.class);
		pd [4] = new PropertyDescriptor("docposition", DocumentPositionAccessBean.class);
		pd [5] = new PropertyDescriptor("document", DocumentPositionAccessBean.class, "getDocument", null);
		pd [6] = new PropertyDescriptor("isReadOnly", DocumentPositionAccessBean.class, "getIsReadOnly", null);
		pd [7] = new PropertyDescriptor("order", DocumentPositionAccessBean.class);
		pd [8] = new PropertyDescriptor("owner", DocumentPositionAccessBean.class, "getOwner", null);
		pd [9] = new PropertyDescriptor("party", DocumentPositionAccessBean.class);
		pd [10] = new PropertyDescriptor("price", DocumentPositionAccessBean.class);
		pd [11] = new PropertyDescriptor("qty", DocumentPositionAccessBean.class);
		pd [12] = new PropertyDescriptor("resource", DocumentPositionAccessBean.class, "getResource", null);
		pd [13] = new PropertyDescriptor("resultBoxed", DocumentPositionAccessBean.class);
		pd [14] = new PropertyDescriptor("resultBroken", DocumentPositionAccessBean.class);
		pd [15] = new PropertyDescriptor("resultClosed", DocumentPositionAccessBean.class);
		pd [16] = new PropertyDescriptor("serialnumber", DocumentPositionAccessBean.class);
		pd [17] = new PropertyDescriptor("sourceBoxed", DocumentPositionAccessBean.class);
		pd [18] = new PropertyDescriptor("sourceBroken", DocumentPositionAccessBean.class);
		pd [19] = new PropertyDescriptor("sourceClosed", DocumentPositionAccessBean.class);
		pd [20] = new PropertyDescriptor("sum", DocumentPositionAccessBean.class, "getSum", null);
		pd [21] = new PropertyDescriptor("notes", DocumentPositionAccessBean.class);
		pd [22] = new PropertyDescriptor("newplace", DocumentPositionAccessBean.class);
		pd [23] = new PropertyDescriptor("oldplace", DocumentPositionAccessBean.class);
		pd [24] = new PropertyDescriptor("manufserial", DocumentPositionAccessBean.class);
		pd [25] = new PropertyDescriptor("isfictserial", DocumentPositionAccessBean.class);
		pd [26] = new PropertyDescriptor("realserial", DocumentPositionAccessBean.class);
		pd [27] = new PropertyDescriptor("agregateresource", DocumentPositionAccessBean.class);
		pd [28] = new PropertyDescriptor("oldagregateresource", DocumentPositionAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
