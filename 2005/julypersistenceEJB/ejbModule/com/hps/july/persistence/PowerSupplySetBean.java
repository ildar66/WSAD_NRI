package com.hps.july.persistence;
/**
 * Bean implementation class for Enterprise Bean: PowerSupplySet
 */
public class PowerSupplySetBean
	extends com.hps.july.persistence.ResourceSetBean {
	/**
	 * Implementation field for persistent attribute: power
	 */
	public java.math.BigDecimal power;
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
		_initLinks();
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
		_initLinks();
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
		try {
			_removeLinks();
		} catch (java.rmi.RemoteException e) {
			throw new javax.ejb.RemoveException(e.getMessage());
		}
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: power
	 */
	public java.math.BigDecimal getPower() {
		return power;
	}
	/**
	 * Set accessor for persistent attribute: power
	 */
	public void setPower(java.math.BigDecimal newPower) {
		power = newPower;
	}
	
	//public final static int RESOURCESET_CLASS = 1;
	
	public void ejbCreate(int argResourceset, String argName, Integer argMainPart, java.math.BigDecimal argMainPartQty, 
		String argType, java.math.BigDecimal argPower ) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.ejbCreate(argResourceset, argName, argMainPart, argMainPartQty, 
		argType);
		_initLinks();
		// All CMP fields should be initialized here.
		power = argPower;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("power", getPower());
		h.put("name", getName());
		h.put("mainpartKey", getMainpartKey());
		h.put("mainpartqty", getMainpartqty());
		h.put("nfsitemid", getNfsitemid());
		h.put("type", getType());
		h.put("resourceset", new Integer(getResourceset()));
		h.put("resourcesetclass", getResourcesetclass());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.math.BigDecimal localPower = (java.math.BigDecimal) h.get("power");
		java.lang.String localName = (java.lang.String) h.get("name");
		java.math.BigDecimal localMainpartqty =
			(java.math.BigDecimal) h.get("mainpartqty");
		java.lang.String localNfsitemid = (java.lang.String) h.get("nfsitemid");
		java.lang.String localType = (java.lang.String) h.get("type");
		Integer localResourceset = (Integer) h.get("resourceset");
		java.lang.Integer localResourcesetclass =
			(java.lang.Integer) h.get("resourcesetclass");

		if (h.containsKey("power"))
			setPower((localPower));
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("mainpartqty"))
			setMainpartqty((localMainpartqty));
		if (h.containsKey("nfsitemid"))
			setNfsitemid((localNfsitemid));
		if (h.containsKey("type"))
			setType((localType));
		if (h.containsKey("resourceset"))
			setResourceset((localResourceset).intValue());
		if (h.containsKey("resourcesetclass"))
			setResourcesetclass((localResourcesetclass));
	}
}
