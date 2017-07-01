package com.hps.july.persistence;

public class LeaseVPaymentKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer act_leaseDocument;
	public java.lang.Integer debetcontract_leaseDocument;
	public java.lang.Integer creditcontract_leaseDocument;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseVPaymentKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAct com.hps.july.persistence.LeaseDocumentKey
 * @param argDebetcontract com.hps.july.persistence.LeaseDocumentKey
 * @param argCreditcontract com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseVPaymentKey(LeaseDocumentKey argAct, LeaseDocumentKey argDebetcontract, LeaseDocumentKey argCreditcontract) {
	privateSetActKey(argAct);
	privateSetDebetcontractKey(argDebetcontract);
	privateSetCreditcontractKey(argCreditcontract);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseVPaymentKey) {
		LeaseVPaymentKey otherKey = (LeaseVPaymentKey) o;
		return ((this.act_leaseDocument.equals(otherKey.act_leaseDocument)
		 && this.debetcontract_leaseDocument.equals(otherKey.debetcontract_leaseDocument)
		 && this.creditcontract_leaseDocument.equals(otherKey.creditcontract_leaseDocument)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseVPayment2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getActKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean act_NULLTEST = true;
	act_NULLTEST &= (act_leaseDocument == null);
	temp.leaseDocument = ((act_leaseDocument == null) ? 0 : act_leaseDocument.intValue());
	if (act_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseVPayment2creditcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getCreditcontractKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean creditcontract_NULLTEST = true;
	creditcontract_NULLTEST &= (creditcontract_leaseDocument == null);
	temp.leaseDocument = ((creditcontract_leaseDocument == null) ? 0 : creditcontract_leaseDocument.intValue());
	if (creditcontract_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseVPayment2debetcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getDebetcontractKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean debetcontract_NULLTEST = true;
	debetcontract_NULLTEST &= (debetcontract_leaseDocument == null);
	temp.leaseDocument = ((debetcontract_leaseDocument == null) ? 0 : debetcontract_leaseDocument.intValue());
	if (debetcontract_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (act_leaseDocument.hashCode()
		 + debetcontract_leaseDocument.hashCode()
		 + creditcontract_leaseDocument.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseVPayment2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetActKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean act_NULLTEST = (inKey == null);
	if (act_NULLTEST) act_leaseDocument = null; else act_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseVPayment2creditcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCreditcontractKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean creditcontract_NULLTEST = (inKey == null);
	if (creditcontract_NULLTEST) creditcontract_leaseDocument = null; else creditcontract_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseVPayment2debetcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDebetcontractKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean debetcontract_NULLTEST = (inKey == null);
	if (debetcontract_NULLTEST) debetcontract_leaseDocument = null; else debetcontract_leaseDocument = (new Integer(inKey.leaseDocument));
}
}
