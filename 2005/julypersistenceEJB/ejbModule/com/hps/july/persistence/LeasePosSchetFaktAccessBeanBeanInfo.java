package com.hps.july.persistence;

import java.beans.*;
/**
 * Insert the type's description here.
 * Creation date: (25.05.2003 17:10:31)
 * @author: Sergey Gourov
 */
public class LeasePosSchetFaktAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
public PropertyDescriptor[] getPropertyDescriptors()  {
	System.out.println("!!!!! Called LeasePosSchetFaktAccessBeanBeanInfo !!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[15];
	
	try {
		pd [0] = new PropertyDescriptor("country", LeasePosSchetFaktAccessBean.class);
		pd [1] = new PropertyDescriptor("edizm", LeasePosSchetFaktAccessBean.class);
		pd [2] = new PropertyDescriptor("excise", LeasePosSchetFaktAccessBean.class);
		pd [3] = new PropertyDescriptor("idPosSchetFakt", LeasePosSchetFaktAccessBean.class);
		pd [4] = new PropertyDescriptor("idSchetFakt", LeasePosSchetFaktAccessBean.class, "getIdSchetFakt", null);
		pd [5] = new PropertyDescriptor("nameResource", LeasePosSchetFaktAccessBean.class);
		pd [6] = new PropertyDescriptor("numGTD", LeasePosSchetFaktAccessBean.class);
		pd [7] = new PropertyDescriptor("posorder", LeasePosSchetFaktAccessBean.class);
		pd [8] = new PropertyDescriptor("price", LeasePosSchetFaktAccessBean.class);
		pd [9] = new PropertyDescriptor("qty", LeasePosSchetFaktAccessBean.class);
		pd [10] = new PropertyDescriptor("rateNds", LeasePosSchetFaktAccessBean.class);
		pd [11] = new PropertyDescriptor("resourceNri", LeasePosSchetFaktAccessBean.class, "getResourceNri", null);
		pd [12] = new PropertyDescriptor("sumFreeTax", LeasePosSchetFaktAccessBean.class);
		pd [13] = new PropertyDescriptor("sumNds", LeasePosSchetFaktAccessBean.class);
		pd [14] = new PropertyDescriptor("sumWithTax", LeasePosSchetFaktAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace();
	}
	return null;
}
}
