package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
import java.math.*;
import java.util.*;
/**
 * Bean-Wrapper "Абонентские договора"
 */
public class LeaseAbonentBANValue {
	private LeaseAbonentBANAccessBean o;
	private String bens;
	private java.math.BigDecimal balans;
	
	/**
	 * 
	 * @param bean
	 */
	public LeaseAbonentBANValue(LeaseAbonentBANAccessBean bean) {
		o = bean;
		try {
			if (o.getUseallben()) {
				bens = "";
			} else {
				Enumeration en = (new LeaseAbonentBENAccessBean()).findByLeasedocumentOrderByBenAsc(new Integer(o.getLeaseDocument()));
				bens = null;
				LeaseAbonentBENAccessBean ben;
				while (en.hasMoreElements()) {
					ben = (LeaseAbonentBENAccessBean) en.nextElement();
					if (bens == null || "".equals(bens)) {
						bens = "" + ben.getBen();
					} else {
						bens += ", " + ben.getBen();
					}
				}
				if (bens == null)
					bens = "";
			}
		} catch (Exception e) {
			bens = "";
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.04.2004 17:24:25)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getBalans() throws Exception {
		return o.getBalans();
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getBens() {
		return bens;
	}
	public LeaseAbonentBANAccessBean getO() {
		return o;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.04.2004 17:24:25)
	 * @param newBalans java.math.BigDecimal
	 */
	public void setBalans(java.math.BigDecimal newBalans) {
		o.setBalans(newBalans);
	}
	/**
	 * 
	 * @param newBens java.lang.String
	 */
	public void setBens(java.lang.String newBens) {
		bens = newBens;
	}
	public void setO(LeaseAbonentBANAccessBean newO) {
		o = newO;
	}
}
