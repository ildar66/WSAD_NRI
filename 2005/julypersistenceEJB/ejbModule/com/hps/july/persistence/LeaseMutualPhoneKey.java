package com.hps.july.persistence;

public class LeaseMutualPhoneKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer leaseDocument_leaseDocument;
	public java.lang.String phone;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseMutualPhoneKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeaseDocument com.hps.july.persistence.LeaseDocumentKey
 * @param argPhone java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseMutualPhoneKey(LeaseDocumentKey argLeaseDocument, java.lang.String argPhone) {
	privateSetLeaseDocumentKey(argLeaseDocument);
	phone = argPhone;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseMutualPhoneKey) {
		LeaseMutualPhoneKey otherKey = (LeaseMutualPhoneKey) o;
		return ((this.leaseDocument_leaseDocument.equals(otherKey.leaseDocument_leaseDocument)
		 && this.phone.equals(otherKey.phone)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseMutualPhone2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getLeaseDocumentKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean leaseDocument_NULLTEST = true;
	leaseDocument_NULLTEST &= (leaseDocument_leaseDocument == null);
	temp.leaseDocument = ((leaseDocument_leaseDocument == null) ? 0 : leaseDocument_leaseDocument.intValue());
	if (leaseDocument_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (leaseDocument_leaseDocument.hashCode()
		 + phone.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseMutualPhone2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeaseDocumentKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean leaseDocument_NULLTEST = (inKey == null);
	if (leaseDocument_NULLTEST) leaseDocument_leaseDocument = null; else leaseDocument_leaseDocument = (new Integer(inKey.leaseDocument));
}
}
