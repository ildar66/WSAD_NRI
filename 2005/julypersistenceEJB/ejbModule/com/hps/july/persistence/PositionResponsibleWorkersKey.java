package com.hps.july.persistence;

public class PositionResponsibleWorkersKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer type_responsibilityType;
	public java.lang.Integer position_storageplace;
	public java.lang.String resptype;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PositionResponsibleWorkersKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argType com.hps.july.persistence.ResponsibilityTypeKey
 * @param argPosition com.hps.july.persistence.StoragePlaceKey
 * @param argResptype java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PositionResponsibleWorkersKey(ResponsibilityTypeKey argType, StoragePlaceKey argPosition, java.lang.String argResptype) {
	privateSetTypeKey(argType);
	privateSetPositionKey(argPosition);
	resptype = argResptype;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof PositionResponsibleWorkersKey) {
		PositionResponsibleWorkersKey otherKey = (PositionResponsibleWorkersKey) o;
		return ((this.type_responsibilityType.equals(otherKey.type_responsibilityType)
		 && this.position_storageplace.equals(otherKey.position_storageplace)
		 && this.resptype.equals(otherKey.resptype)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getPositionKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean position_NULLTEST = true;
	position_NULLTEST &= (position_storageplace == null);
	temp.storageplace = ((position_storageplace == null) ? 0 : position_storageplace.intValue());
	if (position_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ResponsibilityTypeKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResponsibilityTypeKey getTypeKey() {
	com.hps.july.persistence.ResponsibilityTypeKey temp = null;
	temp = new com.hps.july.persistence.ResponsibilityTypeKey();
	boolean type_NULLTEST = true;
	type_NULLTEST &= (type_responsibilityType == null);
	temp.responsibilityType = ((type_responsibilityType == null) ? 0 : type_responsibilityType.intValue());
	if (type_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (type_responsibilityType.hashCode()
		 + position_storageplace.hashCode()
		 + resptype.hashCode());
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean position_NULLTEST = (inKey == null);
	if (position_NULLTEST) position_storageplace = null; else position_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResponsibilityTypeKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetTypeKey(com.hps.july.persistence.ResponsibilityTypeKey inKey) {
	boolean type_NULLTEST = (inKey == null);
	if (type_NULLTEST) type_responsibilityType = null; else type_responsibilityType = (new Integer(inKey.responsibilityType));
}
}
