package com.hps.july.persistence;

public class LeaseMRCntPriorKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer reglament_leaseDocument;
	public java.lang.Integer contract1_leaseDocument;
	public java.lang.Integer contract2_leaseDocument;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseMRCntPriorKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argReglament com.hps.july.persistence.LeaseDocumentKey
 * @param argContract1 com.hps.july.persistence.LeaseDocumentKey
 * @param argContract2 com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseMRCntPriorKey(LeaseDocumentKey argReglament, LeaseDocumentKey argContract1, LeaseDocumentKey argContract2) {
	privateSetReglamentKey(argReglament);
	privateSetContract1Key(argContract1);
	privateSetContract2Key(argContract2);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseMRCntPriorKey) {
		LeaseMRCntPriorKey otherKey = (LeaseMRCntPriorKey) o;
		return ((this.reglament_leaseDocument.equals(otherKey.reglament_leaseDocument)
		 && this.contract1_leaseDocument.equals(otherKey.contract1_leaseDocument)
		 && this.contract2_leaseDocument.equals(otherKey.contract2_leaseDocument)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getContract1Key() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean contract1_NULLTEST = true;
	contract1_NULLTEST &= (contract1_leaseDocument == null);
	temp.leaseDocument = ((contract1_leaseDocument == null) ? 0 : contract1_leaseDocument.intValue());
	if (contract1_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getContract2Key() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean contract2_NULLTEST = true;
	contract2_NULLTEST &= (contract2_leaseDocument == null);
	temp.leaseDocument = ((contract2_leaseDocument == null) ? 0 : contract2_leaseDocument.intValue());
	if (contract2_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getReglamentKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean reglament_NULLTEST = true;
	reglament_NULLTEST &= (reglament_leaseDocument == null);
	temp.leaseDocument = ((reglament_leaseDocument == null) ? 0 : reglament_leaseDocument.intValue());
	if (reglament_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (reglament_leaseDocument.hashCode()
		 + contract1_leaseDocument.hashCode()
		 + contract2_leaseDocument.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetContract1Key(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean contract1_NULLTEST = (inKey == null);
	if (contract1_NULLTEST) contract1_leaseDocument = null; else contract1_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetContract2Key(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean contract2_NULLTEST = (inKey == null);
	if (contract2_NULLTEST) contract2_leaseDocument = null; else contract2_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetReglamentKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean reglament_NULLTEST = (inKey == null);
	if (reglament_NULLTEST) reglament_leaseDocument = null; else reglament_leaseDocument = (new Integer(inKey.leaseDocument));
}
}
