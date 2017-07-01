package com.hps.july.persistence;
/**
 * Bean implementation class for Enterprise Bean: AccumBatteryResource
 */
public class AccumBatteryResourceBean
	extends com.hps.july.persistence.ResourceBean {
	/**
	 * Implementation field for persistent attribute: voltage
	 */
	public java.math.BigDecimal voltage;
	/**
	 * Implementation field for persistent attribute: capacity
	 */
	public java.math.BigDecimal capacity;
	/**
	 * Implementation field for persistent attribute: accutype
	 */
	public java.lang.String accutype;
	/**
	 * Implementation field for persistent attribute: accucount
	 */
	public java.lang.Integer accucount;
	
	public final static int RESOURCECLASS2 = 18;

	public void ejbCreate(int argResource, String argName, String argModel, String argNotes, Boolean argComplect, 
		String argCountpolicy, Boolean argBoxable, Boolean argPriceable, Boolean argComplectpart, 
		Boolean argActive, int argSubType ) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.ejbCreate(argResource, argName, argModel, argNotes, argComplect, 
			argCountpolicy, argBoxable, argPriceable, argComplectpart, 
			argActive, argSubType, RESOURCECLASS2);
		_initLinks();
		// All CMP fields should be initialized here.
		accucount = null;
		accutype = null;
		capacity = null;
		voltage = null;
	}


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
	 * Get accessor for persistent attribute: voltage
	 */
	public java.math.BigDecimal getVoltage() {
		return voltage;
	}
	/**
	 * Set accessor for persistent attribute: voltage
	 */
	public void setVoltage(java.math.BigDecimal newVoltage) {
		voltage = newVoltage;
	}
	/**
	 * Get accessor for persistent attribute: capacity
	 */
	public java.math.BigDecimal getCapacity() {
		return capacity;
	}
	/**
	 * Set accessor for persistent attribute: capacity
	 */
	public void setCapacity(java.math.BigDecimal newCapacity) {
		capacity = newCapacity;
	}
	/**
	 * Get accessor for persistent attribute: accutype
	 */
	public java.lang.String getAccutype() {
		return accutype;
	}
	/**
	 * Set accessor for persistent attribute: accutype
	 */
	public void setAccutype(java.lang.String newAccutype) {
		accutype = newAccutype;
	}
	/**
	 * Get accessor for persistent attribute: accucount
	 */
	public java.lang.Integer getAccucount() {
		return accucount;
	}
	/**
	 * Set accessor for persistent attribute: accucount
	 */
	public void setAccucount(java.lang.Integer newAccucount) {
		accucount = newAccucount;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("accucount", getAccucount());
		h.put("capacity", getCapacity());
		h.put("accutype", getAccutype());
		h.put("voltage", getVoltage());
		h.put("unitKey", getUnitKey());
		h.put("subtypeKey", getSubtypeKey());
		h.put("countpolicy", getCountpolicy());
		h.put("model", getModel());
		h.put("manufid", getManufid());
		h.put("resourceclass2", getResourceclass2());
		h.put("actualcode", new Integer(getActualcode()));
		h.put("name", getName());
		h.put("groupid", getGroupid());
		h.put("priceable", getPriceable());
		h.put("complectpart", getComplectpart());
		h.put("resource", new Integer(getResource()));
		h.put("manucode", getManucode());
		h.put("complect", getComplect());
		h.put("disablenfscodes", getDisablenfscodes());
		h.put("subtype_resourcesubtype", getSubtype_resourcesubtype());
		h.put("notes", getNotes());
		h.put("active", getActive());
		h.put("boxable", getBoxable());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Integer localAccucount =
			(java.lang.Integer) h.get("accucount");
		java.math.BigDecimal localCapacity =
			(java.math.BigDecimal) h.get("capacity");
		java.lang.String localAccutype = (java.lang.String) h.get("accutype");
		java.math.BigDecimal localVoltage =
			(java.math.BigDecimal) h.get("voltage");
		java.lang.String localCountpolicy =
			(java.lang.String) h.get("countpolicy");
		java.lang.String localModel = (java.lang.String) h.get("model");
		java.lang.Integer localManufid = (java.lang.Integer) h.get("manufid");
		java.lang.Integer localResourceclass2 =
			(java.lang.Integer) h.get("resourceclass2");
		Integer localActualcode = (Integer) h.get("actualcode");
		java.lang.String localName = (java.lang.String) h.get("name");
		java.lang.Integer localGroupid = (java.lang.Integer) h.get("groupid");
		java.lang.Boolean localPriceable =
			(java.lang.Boolean) h.get("priceable");
		java.lang.Boolean localComplectpart =
			(java.lang.Boolean) h.get("complectpart");
		Integer localResource = (Integer) h.get("resource");
		java.lang.String localManucode = (java.lang.String) h.get("manucode");
		java.lang.Boolean localComplect = (java.lang.Boolean) h.get("complect");
		java.lang.Boolean localDisablenfscodes =
			(java.lang.Boolean) h.get("disablenfscodes");
		java.lang.Integer localSubtype_resourcesubtype =
			(java.lang.Integer) h.get("subtype_resourcesubtype");
		java.lang.String localNotes = (java.lang.String) h.get("notes");
		java.lang.Boolean localActive = (java.lang.Boolean) h.get("active");
		java.lang.Boolean localBoxable = (java.lang.Boolean) h.get("boxable");

		if (h.containsKey("accucount"))
			setAccucount((localAccucount));
		if (h.containsKey("capacity"))
			setCapacity((localCapacity));
		if (h.containsKey("accutype"))
			setAccutype((localAccutype));
		if (h.containsKey("voltage"))
			setVoltage((localVoltage));
		if (h.containsKey("countpolicy"))
			setCountpolicy((localCountpolicy));
		if (h.containsKey("model"))
			setModel((localModel));
		if (h.containsKey("manufid"))
			setManufid((localManufid));
		if (h.containsKey("resourceclass2"))
			setResourceclass2((localResourceclass2));
		if (h.containsKey("actualcode"))
			setActualcode((localActualcode).intValue());
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("groupid"))
			setGroupid((localGroupid));
		if (h.containsKey("priceable"))
			setPriceable((localPriceable));
		if (h.containsKey("complectpart"))
			setComplectpart((localComplectpart));
		if (h.containsKey("resource"))
			setResource((localResource).intValue());
		if (h.containsKey("manucode"))
			setManucode((localManucode));
		if (h.containsKey("complect"))
			setComplect((localComplect));
		if (h.containsKey("disablenfscodes"))
			setDisablenfscodes((localDisablenfscodes));
		if (h.containsKey("subtype_resourcesubtype"))
			setSubtype_resourcesubtype((localSubtype_resourcesubtype));
		if (h.containsKey("notes"))
			setNotes((localNotes));
		if (h.containsKey("active"))
			setActive((localActive));
		if (h.containsKey("boxable"))
			setBoxable((localBoxable));
	}
}
