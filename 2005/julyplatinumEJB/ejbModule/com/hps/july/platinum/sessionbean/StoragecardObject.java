package com.hps.july.platinum.sessionbean;

import com.hps.july.persistence.*;

/**
 * Insert the type's description here.
 * Creation date: (24.12.2002 9:57:14)
 * @author: Dmitry Dneprov
 */
public class StoragecardObject {
	private int resource;
	private int owner;
	private java.lang.String serialnumber;
	private java.lang.String party;
	private java.lang.String countpolicy;
/**
 * OwnerStorageObject constructor comment.
 */
public StoragecardObject(DocumentPositionAccessBean argDocpos) {
	super();
	try {
		resource = argDocpos.getResource().getResource();
		owner = argDocpos.getOwner().getOrganization();
		countpolicy = argDocpos.getResource().getCountpolicy();
		serialnumber = argDocpos.getSerialnumber();
		party = argDocpos.getParty();
	} catch (Exception e) {
		System.out.println("PLATINUM-SYNC: Cannot create storagecard object - strange");
		e.printStackTrace(System.out);
		resource = 0;
		owner = 0;
		countpolicy = "";
		serialnumber = "";
		party = "";
	}
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
	if (!(obj instanceof StoragecardObject))
		return false;
	StoragecardObject oo = (StoragecardObject)obj;
	try {
		// Compare owners
		boolean isOwners = false;
		if ( oo.getOwner() == getOwner() )
			isOwners = true;
				
		// Compare resources
		boolean isResources = false;
		if ( oo.getResource() == getResource() )
			isResources = true;
			
		// Compare countpolicy
		boolean isCountpolicy = false;
		boolean isSerial = false;
		boolean isParty = false;
		
		if ( oo.getCountpolicy() == getCountpolicy() ) {
			isCountpolicy = true;
	
			if ("S".equalsIgnoreCase(getCountpolicy())) {
				if (oo.getSerialnumber().equals(getSerialnumber())) {
					isSerial = true;
					isParty = true;
				} 
			} else if ("P".equalsIgnoreCase(getCountpolicy())) {
				if (oo.getParty().equals(getParty())) {
					isSerial = true;
					isParty = true;
				}
			} else {
				isSerial = true;
				isParty = true;
			}
		}
				
		return (isOwners && isResources && isCountpolicy && isSerial && isParty);
		
	} catch (Exception e) {
		// Something goes wrong
		e.printStackTrace(System.out);
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:35:07)
 * @return java.lang.String
 */
public java.lang.String getCountpolicy() {
	return countpolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:34:05)
 * @return int
 */
public int getOwner() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:34:43)
 * @return java.lang.String
 */
public java.lang.String getParty() {
	return party;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:33:52)
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:34:24)
 * @return java.lang.String
 */
public java.lang.String getSerialnumber() {
	return serialnumber;
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
		res = getOwner() + getResource();
		if ("S".equalsIgnoreCase(getCountpolicy()))
			res = res + 1000;
		if ("P".equalsIgnoreCase(getCountpolicy()))
			res = res + 2000;
		if ("B".equalsIgnoreCase(getCountpolicy()))
			res = res + 3000;
	} catch (Exception e) {
		// Something fatal occured
		e.printStackTrace(System.out);
	}
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:35:07)
 * @param newCountpolicy java.lang.String
 */
public void setCountpolicy(java.lang.String newCountpolicy) {
	countpolicy = newCountpolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:34:05)
 * @param newOwner int
 */
public void setOwner(int newOwner) {
	owner = newOwner;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:34:43)
 * @param newParty java.lang.String
 */
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:33:52)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:34:24)
 * @param newSerialnumber java.lang.String
 */
public void setSerialnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
}
