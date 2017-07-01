package com.hps.july.persistence;

public class ContrAddInfoKey implements java.io.Serializable {
	public java.sql.Date act_date;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer controller_storageplace;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ContrAddInfoKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAct_date java.sql.Date
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ContrAddInfoKey(java.sql.Date argAct_date) {
	act_date = argAct_date;
}
/**
 * Initialize a key from the passed values
 * @param argAct_date java.sql.Date
 * @param argController com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ContrAddInfoKey(java.sql.Date argAct_date, StoragePlaceKey argController) {
	act_date = argAct_date;
	privateSetControllerKey(argController);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof ContrAddInfoKey) {
		ContrAddInfoKey otherKey = (ContrAddInfoKey) o;
		return ((this.act_date.equals(otherKey.act_date)
		 && this.controller_storageplace.equals(otherKey.controller_storageplace)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named ContrAddInfo2controllers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getControllerKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean controller_NULLTEST = true;
	controller_NULLTEST &= (controller_storageplace == null);
	temp.storageplace = ((controller_storageplace == null) ? 0 : controller_storageplace.intValue());
	if (controller_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (act_date.hashCode()
		 + controller_storageplace.hashCode());
}
/**
 * This method was generated for supporting the association named ContrAddInfo2controllers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetControllerKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean controller_NULLTEST = (inKey == null);
	if (controller_NULLTEST) controller_storageplace = null; else controller_storageplace = (new Integer(inKey.storageplace));
}
}
