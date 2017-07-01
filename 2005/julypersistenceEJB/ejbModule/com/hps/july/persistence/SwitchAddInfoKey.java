package com.hps.july.persistence;

public class SwitchAddInfoKey implements java.io.Serializable {
	public java.sql.Date act_date;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer switch_storageplace;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SwitchAddInfoKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAct_date java.sql.Date
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SwitchAddInfoKey(java.sql.Date argAct_date) {
	act_date = argAct_date;
}
/**
 * Initialize a key from the passed values
 * @param argAct_date java.sql.Date
 * @param argSwitch com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SwitchAddInfoKey(java.sql.Date argAct_date, StoragePlaceKey argSwitch) {
	act_date = argAct_date;
	privateSetSwitchKey(argSwitch);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof SwitchAddInfoKey) {
		SwitchAddInfoKey otherKey = (SwitchAddInfoKey) o;
		return ((this.act_date.equals(otherKey.act_date)
		 && this.switch_storageplace.equals(otherKey.switch_storageplace)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getSwitchKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean switch_NULLTEST = true;
	switch_NULLTEST &= (switch_storageplace == null);
	temp.storageplace = ((switch_storageplace == null) ? 0 : switch_storageplace.intValue());
	if (switch_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (act_date.hashCode()
		 + switch_storageplace.hashCode());
}
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSwitchKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean switch_NULLTEST = (inKey == null);
	if (switch_NULLTEST) switch_storageplace = null; else switch_storageplace = (new Integer(inKey.storageplace));
}
}
