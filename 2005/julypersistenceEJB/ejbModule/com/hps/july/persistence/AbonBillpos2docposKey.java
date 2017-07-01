package com.hps.july.persistence;

public class AbonBillpos2docposKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer leasedocposition_leaseDocPosition;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AbonBillpos2docposKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeasedocposition com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AbonBillpos2docposKey(LeaseDocPositionKey argLeasedocposition) {
	privateSetLeasedocpositionKey(argLeasedocposition);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof AbonBillpos2docposKey) {
		AbonBillpos2docposKey otherKey = (AbonBillpos2docposKey) o;
		return ((this.leasedocposition_leaseDocPosition.equals(otherKey.leasedocposition_leaseDocPosition)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPositionKey getLeasedocpositionKey() {
	com.hps.july.persistence.LeaseDocPositionKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocPositionKey();
	boolean leasedocposition_NULLTEST = true;
	leasedocposition_NULLTEST &= (leasedocposition_leaseDocPosition == null);
	temp.leaseDocPosition = ((leasedocposition_leaseDocPosition == null) ? 0 : leasedocposition_leaseDocPosition.intValue());
	if (leasedocposition_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (leasedocposition_leaseDocPosition.hashCode());
}
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocPositionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeasedocpositionKey(com.hps.july.persistence.LeaseDocPositionKey inKey) {
	boolean leasedocposition_NULLTEST = (inKey == null);
	if (leasedocposition_NULLTEST) leasedocposition_leaseDocPosition = null; else leasedocposition_leaseDocPosition = (new Integer(inKey.leaseDocPosition));
}
}
