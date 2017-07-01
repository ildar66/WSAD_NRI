package com.hps.july.persistence;

public class LeaseAbonentBENKey implements java.io.Serializable {
	public short ben;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer leaseabonentban_leaseDocument;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseAbonentBENKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argBen short
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseAbonentBENKey(short argBen) {
	ben = argBen;
}
/**
 * Initialize a key from the passed values
 * @param argBen short
 * @param argLeaseabonentban com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseAbonentBENKey(short argBen, LeaseDocumentKey argLeaseabonentban) {
	ben = argBen;
	privateSetLeaseabonentbanKey(argLeaseabonentban);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseAbonentBENKey) {
		LeaseAbonentBENKey otherKey = (LeaseAbonentBENKey) o;
		return (((this.ben == otherKey.ben)
		 && this.leaseabonentban_leaseDocument.equals(otherKey.leaseabonentban_leaseDocument)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getLeaseabonentbanKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean leaseabonentban_NULLTEST = true;
	leaseabonentban_NULLTEST &= (leaseabonentban_leaseDocument == null);
	temp.leaseDocument = ((leaseabonentban_leaseDocument == null) ? 0 : leaseabonentban_leaseDocument.intValue());
	if (leaseabonentban_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return ((new Short(ben).hashCode())
		 + leaseabonentban_leaseDocument.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeaseabonentbanKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean leaseabonentban_NULLTEST = (inKey == null);
	if (leaseabonentban_NULLTEST) leaseabonentban_leaseDocument = null; else leaseabonentban_leaseDocument = (new Integer(inKey.leaseDocument));
}
}
