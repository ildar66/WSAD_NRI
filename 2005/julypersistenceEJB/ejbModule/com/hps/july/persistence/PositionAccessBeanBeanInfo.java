package com.hps.july.persistence;

import java.beans.*;

/**
 * Insert the type's description here.
 * Creation date: (04.03.2002 17:22:59)
 * @author: Dmitry Dneprov
 */
public class PositionAccessBeanBeanInfo extends java.beans.SimpleBeanInfo {
/**
 * WorkersAccessBeanBeanInfo constructor comment.
 */
public PositionAccessBeanBeanInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2002 17:24:40)
 * @return java.beans.PropertyDescriptor[]
 */
public PropertyDescriptor[] getPropertyDescriptors()  {
	PropertyDescriptor[] pd = new PropertyDescriptor[22];
	try {
		pd [0] = new PropertyDescriptor("accesslistexp", PositionAccessBean.class);
		pd [1] = new PropertyDescriptor("address", PositionAccessBean.class);
		pd [2] = new PropertyDescriptor("closedate", PositionAccessBean.class);
		pd [3] = new PropertyDescriptor("dampsid", PositionAccessBean.class);
		pd [4] = new PropertyDescriptor("dampsname", PositionAccessBean.class);
		pd [5] = new PropertyDescriptor("dcsid", PositionAccessBean.class);
		pd [6] = new PropertyDescriptor("details", PositionAccessBean.class);
		pd [7] = new PropertyDescriptor("gsmid", PositionAccessBean.class);
		pd [8] = new PropertyDescriptor("latitude", PositionAccessBean.class);
		pd [9] = new PropertyDescriptor("longitude", PositionAccessBean.class);
		pd [10] = new PropertyDescriptor("name", PositionAccessBean.class);
		pd [11] = new PropertyDescriptor("rentervolume", PositionAccessBean.class);
		pd [12] = new PropertyDescriptor("storageplace", PositionAccessBean.class);
		pd [13] = new PropertyDescriptor("inAction", PositionAccessBean.class);
		pd [14] = new PropertyDescriptor("division", PositionAccessBean.class, "getDivision", null);
		pd [15] = new PropertyDescriptor("netZone", PositionAccessBean.class, "getNetZone", null);
		pd [16] = new PropertyDescriptor("renter", PositionAccessBean.class, "getRenter", null);
		pd [17] = new PropertyDescriptor("inmetro", PositionAccessBean.class);
		pd [18] = new PropertyDescriptor("datasource", PositionAccessBean.class);
		pd [19] = new PropertyDescriptor("longitude_WGS84", PositionAccessBean.class);
		pd [20] = new PropertyDescriptor("latitude_WGS84", PositionAccessBean.class);
		pd [21] = new PropertyDescriptor("geosystem", PositionAccessBean.class);
		return pd;
	} catch (IntrospectionException ex) {
		ex.printStackTrace(System.out);
	}
	return null;
}
}
