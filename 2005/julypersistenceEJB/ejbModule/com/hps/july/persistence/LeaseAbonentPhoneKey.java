package com.hps.july.persistence;

public class LeaseAbonentPhoneKey implements java.io.Serializable {
	public java.lang.String phonenumber;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer phone2ban_leaseDocument;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseAbonentPhoneKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeasedocument int
 * @param argPhonenumber java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseAbonentPhoneKey(int argLeasedocument, java.lang.String argPhonenumber) {
	phone2ban_leaseDocument = new Integer(argLeasedocument);
	phonenumber = argPhonenumber;
}
/**
 * Initialize a key from the passed values
 * @param argPhonenumber java.lang.String
 * @param argPhone2ban com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseAbonentPhoneKey(java.lang.String argPhonenumber, LeaseDocumentKey argPhone2ban) {
	phonenumber = argPhonenumber;
	privateSetPhone2banKey(argPhone2ban);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseAbonentPhoneKey) {
		LeaseAbonentPhoneKey otherKey = (LeaseAbonentPhoneKey) o;
		return ((this.phonenumber.equals(otherKey.phonenumber)
		 && this.phone2ban_leaseDocument.equals(otherKey.phone2ban_leaseDocument)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getPhone2banKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean phone2ban_NULLTEST = true;
	phone2ban_NULLTEST &= (phone2ban_leaseDocument == null);
	temp.leaseDocument = ((phone2ban_leaseDocument == null) ? 0 : phone2ban_leaseDocument.intValue());
	if (phone2ban_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (phonenumber.hashCode()
		 + phone2ban_leaseDocument.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPhone2banKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean phone2ban_NULLTEST = (inKey == null);
	if (phone2ban_NULLTEST) phone2ban_leaseDocument = null; else phone2ban_leaseDocument = (new Integer(inKey.leaseDocument));
}
}
