package com.hps.july.platinum.sessionbean;

import com.hps.july.persistence.*;

/**
 * Insert the type's description here.
 * Creation date: (26.12.2002 9:44:51)
 * @author: Dmitry Dneprov
 */
public class DocPositionObject {
	private int locType;
	private com.hps.july.persistence.StoragePlaceAccessBean locfromstorage;
	private int locdocument;
	private java.sql.Date blankdate;
	private int docposition;
	private com.hps.july.persistence.StoragePlaceAccessBean from;
	private com.hps.july.persistence.StoragePlaceAccessBean to;
	private java.math.BigDecimal qty;
	private java.math.BigDecimal price;
	private java.lang.String party;
	private java.lang.String serialnumber;
	private java.lang.String countpolicy;
	private com.hps.july.persistence.OrganizationAccessBean owner;
	private com.hps.july.persistence.ResourceAccessBean resource;
	private com.hps.july.persistence.StorageCardAccessBean cardFrom;
	private com.hps.july.persistence.StorageCardAccessBean cardTo;
	private java.lang.String partyplatinum;
/**
 * DocPositionObject constructor comment.
 */
public DocPositionObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:47:46)
 * @return java.sql.Date
 */
public java.sql.Date getBlankdate() {
	return blankdate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 14:01:17)
 * @return com.hps.july.persistence.StorageCardAccessBean
 */
public com.hps.july.persistence.StorageCardAccessBean getCardFrom() {
	return cardFrom;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 14:01:31)
 * @return com.hps.july.persistence.StorageCardAccessBean
 */
public com.hps.july.persistence.StorageCardAccessBean getCardTo() {
	return cardTo;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:50:49)
 * @return java.lang.String
 */
public java.lang.String getCountpolicy() {
	return countpolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:48:17)
 * @return int
 */
public int getDocposition() {
	return docposition;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:48:45)
 * @return com.hps.july.persistence.StoragePlaceAccessBean
 */
public com.hps.july.persistence.StoragePlaceAccessBean getFrom() {
	return from;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:47:21)
 * @return int
 */
public int getLocdocument() {
	return locdocument;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:46:17)
 * @return com.hps.july.persistence.StoragePlaceAccessBean
 */
public com.hps.july.persistence.StoragePlaceAccessBean getLocfromstorage() {
	return locfromstorage;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:45:18)
 * @return int
 */
public int getLocType() {
	return locType;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 13:53:59)
 * @return com.hps.july.persistence.OrganizationAccessBean
 */
public com.hps.july.persistence.OrganizationAccessBean getOwner() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:50:17)
 * @return java.lang.String
 */
public java.lang.String getParty() {
	return party;
}
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 13:03:48)
 * @return java.lang.String
 */
public java.lang.String getPartyplatinum() {
	return partyplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:49:46)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:49:34)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty() {
	return qty;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 14:00:48)
 * @return com.hps.july.persistence.ResourceAccessBean
 */
public com.hps.july.persistence.ResourceAccessBean getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:50:33)
 * @return java.lang.String
 */
public java.lang.String getSerialnumber() {
	return serialnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:49:05)
 * @return com.hps.july.persistence.StoragePlaceAccessBean
 */
public com.hps.july.persistence.StoragePlaceAccessBean getTo() {
	return to;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 9:44:57)
 * @param dpo com.hps.july.platinum.sessionbean.DocPositionObject
 */
public boolean reduceQty(boolean isInQty) {

	boolean result = true;
	try {
		//logIt("reduceQty for docposition: " + getDocposition() + " isInQty=" + isInQty );
		java.math.BigDecimal sumQty = new java.math.BigDecimal(0);
		sumQty.setScale(2);
		PIELinkPrihRashAccessBean tpr = new PIELinkPrihRashAccessBean();
		java.util.Enumeration tprs;
		if (isInQty)
			tprs = tpr.findByDocposPrihod(new Integer(getDocposition()));
		else
			tprs = tpr.findByDocposRashod(new Integer(getDocposition()));
		while (tprs.hasMoreElements()) {
			PIELinkPrihRashAccessBean pr = (PIELinkPrihRashAccessBean)tprs.nextElement();
			sumQty = sumQty.add(pr.getQty());
		}
		//logIt("Qty=Qty-sumQty: old-qty: " + getQty()+ " dec-qty: " + sumQty );
		setQty(getQty().subtract(sumQty));
		//logIt("    new-qty:" + getQty() );
		
	} catch (Exception e) {
		System.out.println("PLATINUM-SYNC: Strange exception in reduceInQty");
		e.printStackTrace(System.out);
		result = false;
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 12:02:59)
 * @param dpo com.hps.july.platinum.sessionbean.DocPositionObject
 * @param dp com.hps.july.persistence.DocumentPositionAccessBean
 */
public boolean setAllAttributes(int locType, DocumentPositionAccessBean dp) {
	try {
		setLocType(locType);
		setLocfromstorage(dp.getDocument().getFrom());
		setLocdocument(dp.getDocument().getDocument());
		setBlankdate(dp.getDocument().getBlankdate());
		setDocposition(dp.getDocposition());
		setFrom(dp.getDocument().getFrom());
		setTo(dp.getDocument().getTo());
		setQty(dp.getQty());
		setPrice(dp.getPrice());
		setParty(dp.getParty());
		setSerialnumber(dp.getSerialnumber());
		setOwner(dp.getOwner());
		setResource(dp.getResource());
		setCardFrom(dp.getCardFrom());
		setCardTo(dp.getCardTo());
		setCountpolicy(dp.getResource().getCountpolicy());
		return true;
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:47:46)
 * @param newBlankdate java.sql.Date
 */
public void setBlankdate(java.sql.Date newBlankdate) {
	blankdate = newBlankdate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 14:01:17)
 * @param newCardFrom com.hps.july.persistence.StorageCardAccessBean
 */
public void setCardFrom(com.hps.july.persistence.StorageCardAccessBean newCardFrom) {
	cardFrom = newCardFrom;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 14:01:31)
 * @param newCardTo com.hps.july.persistence.StorageCardAccessBean
 */
public void setCardTo(com.hps.july.persistence.StorageCardAccessBean newCardTo) {
	cardTo = newCardTo;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:50:49)
 * @param newCountpolicy java.lang.String
 */
public void setCountpolicy(java.lang.String newCountpolicy) {
	countpolicy = newCountpolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:48:17)
 * @param newDocposition int
 */
public void setDocposition(int newDocposition) {
	docposition = newDocposition;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:48:45)
 * @param newFrom com.hps.july.persistence.StoragePlaceAccessBean
 */
public void setFrom(com.hps.july.persistence.StoragePlaceAccessBean newFrom) {
	from = newFrom;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:47:21)
 * @param newLocdocument int
 */
public void setLocdocument(int newLocdocument) {
	locdocument = newLocdocument;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:46:17)
 * @param newLocfromstorage com.hps.july.persistence.StoragePlaceAccessBean
 */
public void setLocfromstorage(com.hps.july.persistence.StoragePlaceAccessBean newLocfromstorage) {
	locfromstorage = newLocfromstorage;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:45:18)
 * @param newLocType int
 */
public void setLocType(int newLocType) {
	locType = newLocType;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 13:53:59)
 * @param newOwner com.hps.july.persistence.OrganizationAccessBean
 */
public void setOwner(com.hps.july.persistence.OrganizationAccessBean newOwner) {
	owner = newOwner;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:50:17)
 * @param newParty java.lang.String
 */
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 13:03:48)
 * @param newPartyplatinum java.lang.String
 */
public void setPartyplatinum(java.lang.String newPartyplatinum) {
	partyplatinum = newPartyplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:49:46)
 * @param newPrice java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newPrice) {
	price = newPrice;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:49:34)
 * @param newQty java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newQty) {
	qty = newQty;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 14:00:48)
 * @param newResource com.hps.july.persistence.ResourceAccessBean
 */
public void setResource(com.hps.july.persistence.ResourceAccessBean newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:50:33)
 * @param newSerialnumber java.lang.String
 */
public void setSerialnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 9:49:05)
 * @param newTo com.hps.july.persistence.StoragePlaceAccessBean
 */
public void setTo(com.hps.july.persistence.StoragePlaceAccessBean newTo) {
	to = newTo;
}
}
