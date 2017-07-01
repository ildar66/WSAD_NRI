package com.hps.july.persistence;

public class Sitedoc2SplaceKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer storagePlace_storageplace;
	public java.lang.Integer siteDoc_sitedoc;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Sitedoc2SplaceKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argStoragePlace com.hps.july.persistence.StoragePlaceKey
 * @param argSiteDoc com.hps.july.persistence.SiteDocKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Sitedoc2SplaceKey(StoragePlaceKey argStoragePlace, SiteDocKey argSiteDoc) {
	privateSetStoragePlaceKey(argStoragePlace);
	privateSetSiteDocKey(argSiteDoc);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof Sitedoc2SplaceKey) {
		Sitedoc2SplaceKey otherKey = (Sitedoc2SplaceKey) o;
		return ((this.storagePlace_storageplace.equals(otherKey.storagePlace_storageplace)
		 && this.siteDoc_sitedoc.equals(otherKey.siteDoc_sitedoc)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named Sitedoc2Splace2SiteDoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.SiteDocKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SiteDocKey getSiteDocKey() {
	com.hps.july.persistence.SiteDocKey temp = null;
	temp = new com.hps.july.persistence.SiteDocKey();
	boolean siteDoc_NULLTEST = true;
	siteDoc_NULLTEST &= (siteDoc_sitedoc == null);
	temp.sitedoc = ((siteDoc_sitedoc == null) ? 0 : siteDoc_sitedoc.intValue());
	if (siteDoc_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Sitedoc2Splace2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getStoragePlaceKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean storagePlace_NULLTEST = true;
	storagePlace_NULLTEST &= (storagePlace_storageplace == null);
	temp.storageplace = ((storagePlace_storageplace == null) ? 0 : storagePlace_storageplace.intValue());
	if (storagePlace_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (storagePlace_storageplace.hashCode()
		 + siteDoc_sitedoc.hashCode());
}
/**
 * This method was generated for supporting the association named Sitedoc2Splace2SiteDoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.SiteDocKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSiteDocKey(com.hps.july.persistence.SiteDocKey inKey) {
	boolean siteDoc_NULLTEST = (inKey == null);
	if (siteDoc_NULLTEST) siteDoc_sitedoc = null; else siteDoc_sitedoc = (new Integer(inKey.sitedoc));
}
/**
 * This method was generated for supporting the association named Sitedoc2Splace2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetStoragePlaceKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean storagePlace_NULLTEST = (inKey == null);
	if (storagePlace_NULLTEST) storagePlace_storageplace = null; else storagePlace_storageplace = (new Integer(inKey.storageplace));
}
}
