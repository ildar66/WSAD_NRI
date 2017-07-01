package com.hps.july.dictionary.valueobject;

import java.util.Enumeration;
import com.hps.july.persistence.*;

/**
 * —лужебный класс с данными по оборудованию.
 * »спользуетс€ при выводе общего списка оборудовани€.
 * @deprecated
 */
public class ResourceValue {
	private ResourceAccessBean o;
	private String rtype;
public ResourceValue(ResourceAccessBean ar) {
	o = ar;
	rtype = "O";
	try {
		if(o.getEJBRef() instanceof BaseStationResource) {
			rtype = "B";
		} else 
		if(o.getEJBRef() instanceof AntennaResource) {
			rtype = "A";
		} else 
		if(o.getEJBRef() instanceof CableResource) {
			rtype = "C";
		}
	} catch(Exception e) {
	}
}
public com.hps.july.persistence.ResourceAccessBean getO() {
	return o;
}
public java.lang.String getRtype() {
	return rtype;
}
public void setO(com.hps.july.persistence.ResourceAccessBean newO) {
	o = newO;
}
public void setRtype(java.lang.String newRtype) {
	rtype = newRtype;
}
}
