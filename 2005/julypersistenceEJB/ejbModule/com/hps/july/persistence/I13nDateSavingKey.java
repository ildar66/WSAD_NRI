package com.hps.july.persistence;

public class I13nDateSavingKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer i13nAct_document;
	public java.lang.Integer storageCard_storagecard;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public I13nDateSavingKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argI13nAct com.hps.july.persistence.DocumentKey
 * @param argStorageCard com.hps.july.persistence.StorageCardKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public I13nDateSavingKey(DocumentKey argI13nAct, StorageCardKey argStorageCard) {
	privateSetI13nActKey(argI13nAct);
	privateSetStorageCardKey(argStorageCard);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof I13nDateSavingKey) {
		I13nDateSavingKey otherKey = (I13nDateSavingKey) o;
		return ((this.i13nAct_document.equals(otherKey.i13nAct_document)
		 && this.storageCard_storagecard.equals(otherKey.storageCard_storagecard)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.DocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getI13nActKey() {
	com.hps.july.persistence.DocumentKey temp = null;
	temp = new com.hps.july.persistence.DocumentKey();
	boolean i13nAct_NULLTEST = true;
	i13nAct_NULLTEST &= (i13nAct_document == null);
	temp.document = ((i13nAct_document == null) ? 0 : i13nAct_document.intValue());
	if (i13nAct_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.StorageCardKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getStorageCardKey() {
	com.hps.july.persistence.StorageCardKey temp = null;
	temp = new com.hps.july.persistence.StorageCardKey();
	boolean storageCard_NULLTEST = true;
	storageCard_NULLTEST &= (storageCard_storagecard == null);
	temp.storagecard = ((storageCard_storagecard == null) ? 0 : storageCard_storagecard.intValue());
	if (storageCard_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (i13nAct_document.hashCode()
		 + storageCard_storagecard.hashCode());
}
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.DocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetI13nActKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean i13nAct_NULLTEST = (inKey == null);
	if (i13nAct_NULLTEST) i13nAct_document = null; else i13nAct_document = (new Integer(inKey.document));
}
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.StorageCardKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetStorageCardKey(com.hps.july.persistence.StorageCardKey inKey) {
	boolean storageCard_NULLTEST = (inKey == null);
	if (storageCard_NULLTEST) storageCard_storagecard = null; else storageCard_storagecard = (new Integer(inKey.storagecard));
}
}
