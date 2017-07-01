package com.hps.july.platinum.sessionbean;

import com.hps.july.persistence.*;

/**
 * Insert the type's description here.
 * Creation date: (24.12.2002 9:57:14)
 * @author: Dmitry Dneprov
 */
public class OwnerStorageObject {
	private com.hps.july.persistence.OrganizationAccessBean owner;
	private com.hps.july.persistence.StoragePlaceAccessBean storage;
/**
 * OwnerStorageObject constructor comment.
 */
public OwnerStorageObject(OrganizationAccessBean argOwner, StoragePlaceAccessBean argStorage) {
	super();
	this.owner = argOwner;
	this.storage = argStorage;
}
/**
 * Compares two objects for equality. Returns a boolean that indicates
 * whether this object is equivalent to the specified object. This method
 * is used when an object is stored in a hashtable.
 * @param obj the Object to compare with
 * @return true if these Objects are equal; false otherwise.
 * @see java.util.Hashtable
 */
public boolean equals(Object obj) {
	// Insert code to compare the receiver and obj here.
	// This implementation forwards the message to super.  You may replace or supplement this.
	// NOTE: obj might be an instance of any class
	//return super.equals(obj);
	if (!(obj instanceof OwnerStorageObject))
		return false;
	OwnerStorageObject oo = (OwnerStorageObject)obj;
	try {
		// Compare owners
		boolean isOwners = false;
		if ( (oo.getOwner() == null) && (getOwner() == null) )
			isOwners = true;
		if ( (oo.getOwner() != null) && (getOwner() != null) )
			if ( oo.getOwner().getOrganization() == getOwner().getOrganization() )
				isOwners = true;
				
		// Compare storages
		boolean isStorages = false;
		if ( (oo.getStorage() == null) && (getStorage() == null) )
			isStorages = true;
		if ( (oo.getStorage() != null) && (getStorage() != null) )
			if (oo.getStorage().getStorageplace() == getStorage().getStorageplace() )
				isStorages = true;
				
		return (isOwners && isStorages);
		
	} catch (Exception e) {
		// Something goes wrong
		e.printStackTrace(System.out);
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 10:03:34)
 * @return com.hps.july.persistence.OrganizationAccessBean
 */
public com.hps.july.persistence.OrganizationAccessBean getOwner() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 10:04:00)
 * @return com.hps.july.persistence.StoragePlaceAccessBean
 */
public com.hps.july.persistence.StoragePlaceAccessBean getStorage() {
	return storage;
}
/**
 * Generates a hash code for the receiver.
 * This method is supported primarily for
 * hash tables, such as those provided in java.util.
 * @return an integer hash code for the receiver
 * @see java.util.Hashtable
 */
public int hashCode() {
	// Insert code to generate a hash code for the receiver here.
	// This implementation forwards the message to super.  You may replace or supplement this.
	// NOTE: if two objects are equal (equals(Object) returns true) they must have the same hash code
	//return super.hashCode();
	int res = 0;
	try {
		if (getOwner() != null)
			res = getOwner().getOrganization() * 10;
		if (getStorage() != null)
			res = res + getStorage().getStorageplace();
	} catch (Exception e) {
		// Something fatal occured
		e.printStackTrace(System.out);
	}
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 10:03:34)
 * @param newOwner com.hps.july.persistence.OrganizationAccessBean
 */
public void setOwner(com.hps.july.persistence.OrganizationAccessBean newOwner) {
	owner = newOwner;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 10:04:00)
 * @param newStorage com.hps.july.persistence.StoragePlaceAccessBean
 */
public void setStorage(com.hps.july.persistence.StoragePlaceAccessBean newStorage) {
	storage = newStorage;
}
}
