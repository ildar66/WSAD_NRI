package com.hps.july.dictionary.valueobject;

import java.util.Enumeration;
import com.hps.july.persistence.*;

/**
 * Служебный класс с данными по репитерам.
 * Используется при выводе списка репитеров.
 * @deprecated
 */
public class RepeaterValue {
	private RepiterResAccessBean o;
/**
 * Insert the method's description here.
 * Creation date: (19.08.2003 12:17:42)
 * @param rb com.hps.july.persistence.RepiterResAccessBean
 */
public RepeaterValue(RepiterResAccessBean rb) {
	this.o = rb;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2003 12:01:12)
 * @return com.hps.july.persistence.RepiterResAccessBean
 */
public com.hps.july.persistence.RepiterResAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (19.08.2003 12:01:12)
 * @param newO com.hps.july.persistence.RepiterResAccessBean
 */
public void setO(com.hps.july.persistence.RepiterResAccessBean newO) {
	o = newO;
}
}
