package com.hps.july.inventory.valueobject;

import javax.ejb.EJBObject;
import java.util.Enumeration;
import com.hps.july.persistence.*;
import java.math.BigDecimal;

/**
 * —лужебный класс дл€ вывода данных по карточке хранени€
 * »спользуетс€ в форме выборе оборудовани€
 */
public class StorageCardValue {
	private com.hps.july.persistence.StorageCardAccessBean so;
	private boolean canselect;
	private BigDecimal qty;
public StorageCardValue(Object o, Integer doc, boolean inside)
	throws Exception
{
	boolean agregated = false;
	canselect = false;
	
	if(o instanceof StorageCardAccessBean) {
		so = (StorageCardAccessBean)o;
		so.refreshCopyHelper();
		try {
			java.util.Enumeration en = so.getAgregate();
			StorageCardAccessBean agregate = null;
			if(en.hasMoreElements()) {
				agregated = true;
				Object mm = en.nextElement();//javax.rmi.PortableRemoteObject.narrow(en.nextElement(),AgregateContent.class);
				agregate = (new AgregateContentAccessBean((EJBObject)mm)).getAgregate();
			}
			qty = so.getQty();
			String policy = so.getPolicy();
			// decreace qty from agregate
			if(agregate != null) {
				AgregateContentAccessBean ac = new AgregateContentAccessBean();
				en = ac.findAgregateContentByAgregate(new StorageCardKey(agregate.getStoragecard()));
				if(en.hasMoreElements()) {
					while(en.hasMoreElements()) {
						AgregateContentAccessBean agrpart = (AgregateContentAccessBean)en.nextElement();
						agrpart.refreshCopyHelper();
						if("S".equals(policy)) {
						} else if("P".equals(policy)) {
							if((so.getResource().getResource() == agrpart.getParts().getResource().getResource()) &&
								(so.getParty() != null && so.getParty().equals(agrpart.getParts().getParty()))) {
								if(inside) {
									qty = agrpart.getQty();
								} else {
									qty = qty.subtract(agrpart.getQty());
								}
							}
						} else if("B".equals(policy)) {
							if(so.getResource().getResource() == agrpart.getParts().getResource().getResource()) {
								if(inside) { qty = agrpart.getQty(); }
								else { qty = qty.subtract(agrpart.getQty()); }
							}
						}
					}
				}
			}
			// decreace qty from document
			if(doc != null) {
				DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
				Enumeration em = null;
				if("S".equals(policy)) {
					em = dp.findByDocumentQBE2(
						doc,
			    		"S", so.getSerialnumber(),
						Boolean.FALSE, new Integer(0),
						Boolean.FALSE, new Integer(0),
						new Integer(1)
					);
				} else if("P".equals(policy)) {
					em = dp.findByDocumentQBE2(
						doc,
			    		"P", so.getParty(),
			    		Boolean.TRUE, new Integer(so.getOwner().getOrganization()),
						Boolean.FALSE, new Integer(0),
						new Integer(1)
					);
				} else if("B".equals(policy)) {
					em = dp.findByDocumentQBE2(
						doc, "B", "",
			    		Boolean.TRUE, new Integer(so.getOwner().getOrganization()),
						Boolean.TRUE, new Integer(so.getResource().getResource()),
						new Integer(1)
					);
				}
				if(em != null) {
					while(em.hasMoreElements()) {
						dp = (DocumentPositionAccessBean)em.nextElement();
						dp.refreshCopyHelper();
						qty = qty.subtract(dp.getQty());
					}
				}
			}
			qty.setScale(3,BigDecimal.ROUND_HALF_UP);
			if("S".equals(policy)) {
				if(!agregated) {
					if(so.getSerialnumber() != null && !"".equals(so.getSerialnumber())) {
						canselect = true;
					} else {
						canselect = false;
					}
				} else {
					canselect = inside;
				}
			} else {
				canselect = true;
			} 
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		if(qty.doubleValue() <= 0.0) {
			throw new Exception("Qty less than zero.");
		}
	} else {
		throw new Exception("Null row value.");
	}
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty() {
	return qty;
}
/**
 * 
 * @return com.hps.july.persistence.StorageCardAccessBean
 */
public com.hps.july.persistence.StorageCardAccessBean getSo() {
	return so;
}
/**
 * 
 * @return boolean
 */
public boolean isCanselect() {
	return canselect;
}
/**
 * 
 * @param newCanselect boolean
 */
public void setCanselect(boolean newCanselect) {
	canselect = newCanselect;
}
/**
 * 
 * @param newQty java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newQty) {
	qty = newQty;
}
/**
 * 
 * @param newSo com.hps.july.persistence.StorageCardAccessBean
 */
public void setSo(com.hps.july.persistence.StorageCardAccessBean newSo) {
	so = newSo;
}
}
