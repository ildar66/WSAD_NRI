package com.hps.july.persistence;

public class AgregateContentKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer agregate_storagecard;
	public java.lang.Integer parts_storagecard;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AgregateContentKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAgregate com.hps.july.persistence.StorageCardKey
 * @param argParts com.hps.july.persistence.StorageCardKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AgregateContentKey(StorageCardKey argAgregate, StorageCardKey argParts) {
	privateSetAgregateKey(argAgregate);
	privateSetPartsKey(argParts);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof AgregateContentKey) {
		AgregateContentKey otherKey = (AgregateContentKey) o;
		return ((this.agregate_storagecard.equals(otherKey.agregate_storagecard)
		 && this.parts_storagecard.equals(otherKey.parts_storagecard)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.StorageCardKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getAgregateKey() {
	com.hps.july.persistence.StorageCardKey temp = null;
	temp = new com.hps.july.persistence.StorageCardKey();
	boolean agregate_NULLTEST = true;
	agregate_NULLTEST &= (agregate_storagecard == null);
	temp.storagecard = ((agregate_storagecard == null) ? 0 : agregate_storagecard.intValue());
	if (agregate_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.StorageCardKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getPartsKey() {
	com.hps.july.persistence.StorageCardKey temp = null;
	temp = new com.hps.july.persistence.StorageCardKey();
	boolean parts_NULLTEST = true;
	parts_NULLTEST &= (parts_storagecard == null);
	temp.storagecard = ((parts_storagecard == null) ? 0 : parts_storagecard.intValue());
	if (parts_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (agregate_storagecard.hashCode()
		 + parts_storagecard.hashCode());
}
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.StorageCardKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAgregateKey(com.hps.july.persistence.StorageCardKey inKey) {
	boolean agregate_NULLTEST = (inKey == null);
	if (agregate_NULLTEST) agregate_storagecard = null; else agregate_storagecard = (new Integer(inKey.storagecard));
}
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.StorageCardKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPartsKey(com.hps.july.persistence.StorageCardKey inKey) {
	boolean parts_NULLTEST = (inKey == null);
	if (parts_NULLTEST) parts_storagecard = null; else parts_storagecard = (new Integer(inKey.storagecard));
}
}
