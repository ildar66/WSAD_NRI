package com.hps.july.persistence;

public class LeaseDNOPKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer leaseCharge_leaseDocPosition;
	public java.lang.Integer leasePayment_leaseDocPosition;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseDNOPKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeaseCharge com.hps.july.persistence.LeaseDocPositionKey
 * @param argLeasePayment com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseDNOPKey(LeaseDocPositionKey argLeaseCharge, LeaseDocPositionKey argLeasePayment) {
	privateSetLeaseChargeKey(argLeaseCharge);
	privateSetLeasePaymentKey(argLeasePayment);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseDNOPKey) {
		LeaseDNOPKey otherKey = (LeaseDNOPKey) o;
		return ((this.leaseCharge_leaseDocPosition.equals(otherKey.leaseCharge_leaseDocPosition)
		 && this.leasePayment_leaseDocPosition.equals(otherKey.leasePayment_leaseDocPosition)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseDNOP2LeaseCharge.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPositionKey getLeaseChargeKey() {
	com.hps.july.persistence.LeaseDocPositionKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocPositionKey();
	boolean leaseCharge_NULLTEST = true;
	leaseCharge_NULLTEST &= (leaseCharge_leaseDocPosition == null);
	temp.leaseDocPosition = ((leaseCharge_leaseDocPosition == null) ? 0 : leaseCharge_leaseDocPosition.intValue());
	if (leaseCharge_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPositionKey getLeasePaymentKey() {
	com.hps.july.persistence.LeaseDocPositionKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocPositionKey();
	boolean leasePayment_NULLTEST = true;
	leasePayment_NULLTEST &= (leasePayment_leaseDocPosition == null);
	temp.leaseDocPosition = ((leasePayment_leaseDocPosition == null) ? 0 : leasePayment_leaseDocPosition.intValue());
	if (leasePayment_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (leaseCharge_leaseDocPosition.hashCode()
		 + leasePayment_leaseDocPosition.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseDNOP2LeaseCharge.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeaseChargeKey(com.hps.july.persistence.LeaseDocPositionKey inKey) {
	boolean leaseCharge_NULLTEST = (inKey == null);
	if (leaseCharge_NULLTEST) leaseCharge_leaseDocPosition = null; else leaseCharge_leaseDocPosition = (new Integer(inKey.leaseDocPosition));
}
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeasePaymentKey(com.hps.july.persistence.LeaseDocPositionKey inKey) {
	boolean leasePayment_NULLTEST = (inKey == null);
	if (leasePayment_NULLTEST) leasePayment_leaseDocPosition = null; else leasePayment_leaseDocPosition = (new Integer(inKey.leaseDocPosition));
}
}
