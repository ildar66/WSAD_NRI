package com.hps.july.persistence;

public class LeaseOnPositionKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer position_storageplace;
	public java.lang.Integer leaseArendaAgreementNew_leaseDocument;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseOnPositionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argPosition com.hps.july.persistence.StoragePlaceKey
 * @param argLeaseArendaAgreementNew com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseOnPositionKey(StoragePlaceKey argPosition, LeaseDocumentKey argLeaseArendaAgreementNew) {
	privateSetPositionKey(argPosition);
	privateSetLeaseArendaAgreementNewKey(argLeaseArendaAgreementNew);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseOnPositionKey) {
		LeaseOnPositionKey otherKey = (LeaseOnPositionKey) o;
		return ((this.position_storageplace.equals(otherKey.position_storageplace)
		 && this.leaseArendaAgreementNew_leaseDocument.equals(otherKey.leaseArendaAgreementNew_leaseDocument)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getLeaseArendaAgreementNewKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean leaseArendaAgreementNew_NULLTEST = true;
	leaseArendaAgreementNew_NULLTEST &= (leaseArendaAgreementNew_leaseDocument == null);
	temp.leaseDocument = ((leaseArendaAgreementNew_leaseDocument == null) ? 0 : leaseArendaAgreementNew_leaseDocument.intValue());
	if (leaseArendaAgreementNew_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getPositionKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean position_NULLTEST = true;
	position_NULLTEST &= (position_storageplace == null);
	temp.storageplace = ((position_storageplace == null) ? 0 : position_storageplace.intValue());
	if (position_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (position_storageplace.hashCode()
		 + leaseArendaAgreementNew_leaseDocument.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeaseArendaAgreementNewKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean leaseArendaAgreementNew_NULLTEST = (inKey == null);
	if (leaseArendaAgreementNew_NULLTEST) leaseArendaAgreementNew_leaseDocument = null; else leaseArendaAgreementNew_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean position_NULLTEST = (inKey == null);
	if (position_NULLTEST) position_storageplace = null; else position_storageplace = (new Integer(inKey.storageplace));
}
}
