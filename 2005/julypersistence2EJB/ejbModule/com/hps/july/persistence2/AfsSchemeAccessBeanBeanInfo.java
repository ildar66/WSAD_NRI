/*
 * Created on 20.04.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.persistence2;

import java.beans.*;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AfsSchemeAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public AfsSchemeAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
//	System.out.println("!!!!!!!!!!!!!! BeanInfo CALLED ResourceAccessBeanBeanInfo!!!!!!!!!!!!!!!!!!");
	PropertyDescriptor[] pd = new PropertyDescriptor[17];

	try {
		pd [0] = new PropertyDescriptor("schemeid", AfsSchemeAccessBean.class);
		pd [1] = new PropertyDescriptor("numscheme", AfsSchemeAccessBean.class);
		pd [2] = new PropertyDescriptor("sectcount900", AfsSchemeAccessBean.class);
		pd [3] = new PropertyDescriptor("sectcount1800", AfsSchemeAccessBean.class);
		pd [4] = new PropertyDescriptor("antX2", AfsSchemeAccessBean.class);
		pd [5] = new PropertyDescriptor("antX4", AfsSchemeAccessBean.class);
		pd [6] = new PropertyDescriptor("antV1", AfsSchemeAccessBean.class);
		pd [7] = new PropertyDescriptor("antV2", AfsSchemeAccessBean.class);
		pd [8] = new PropertyDescriptor("dbc1", AfsSchemeAccessBean.class);
		pd [9] = new PropertyDescriptor("dbc2", AfsSchemeAccessBean.class);
		pd [10] = new PropertyDescriptor("df1", AfsSchemeAccessBean.class);
		pd [11] = new PropertyDescriptor("df2", AfsSchemeAccessBean.class);
		pd [12] = new PropertyDescriptor("tma", AfsSchemeAccessBean.class);
		pd [13] = new PropertyDescriptor("jo", AfsSchemeAccessBean.class);
		pd [14] = new PropertyDescriptor("ji", AfsSchemeAccessBean.class);
		pd [15] = new PropertyDescriptor("conn", AfsSchemeAccessBean.class);
		pd [16] = new PropertyDescriptor("notes", AfsSchemeAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
