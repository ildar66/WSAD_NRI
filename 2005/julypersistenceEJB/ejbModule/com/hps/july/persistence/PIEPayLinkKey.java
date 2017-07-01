package com.hps.july.persistence;

public class PIEPayLinkKey implements java.io.Serializable {
	public int docposition; 
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.String piepayplatinum_idpayplatinum;
	public java.lang.Integer piepayplatinum_owner;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPayLinkKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argDocposition int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPayLinkKey(int argDocposition) {
	docposition = argDocposition;
}
/**
 * Initialize a key from the passed values
 * @param argDocposition int
 * @param argPiepayplatinum com.hps.july.persistence.PIEPayPlatinumKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPayLinkKey(int argDocposition, PIEPayPlatinumKey argPiepayplatinum) {
	docposition = argDocposition;
	privateSetPiepayplatinumKey(argPiepayplatinum);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof PIEPayLinkKey) {
		PIEPayLinkKey otherKey = (PIEPayLinkKey) o;
		return (((this.docposition == otherKey.docposition)
		 && this.piepayplatinum_idpayplatinum.equals(otherKey.piepayplatinum_idpayplatinum)
		 && this.piepayplatinum_owner.equals(otherKey.piepayplatinum_owner)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.PIEPayPlatinumKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEPayPlatinumKey getPiepayplatinumKey() {
	com.hps.july.persistence.PIEPayPlatinumKey temp = null;
	temp = new com.hps.july.persistence.PIEPayPlatinumKey();
	boolean piepayplatinum_NULLTEST = true;
	piepayplatinum_NULLTEST &= (piepayplatinum_idpayplatinum == null);
	temp.idpayplatinum = piepayplatinum_idpayplatinum;
	piepayplatinum_NULLTEST &= (piepayplatinum_owner == null);
	temp.owner = ((piepayplatinum_owner == null) ? 0 : piepayplatinum_owner.intValue());
	if (piepayplatinum_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return ((new java.lang.Integer(docposition).hashCode())
		 + piepayplatinum_idpayplatinum.hashCode()
		 + piepayplatinum_owner.hashCode());
}
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.PIEPayPlatinumKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPiepayplatinumKey(com.hps.july.persistence.PIEPayPlatinumKey inKey) {
	boolean piepayplatinum_NULLTEST = (inKey == null);
	if (piepayplatinum_NULLTEST) piepayplatinum_idpayplatinum = null; else piepayplatinum_idpayplatinum = inKey.idpayplatinum;
	if (piepayplatinum_NULLTEST) piepayplatinum_owner = null; else piepayplatinum_owner = (new Integer(inKey.owner));
}
}
