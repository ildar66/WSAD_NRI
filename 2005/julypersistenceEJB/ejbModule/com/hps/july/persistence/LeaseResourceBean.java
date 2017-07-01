package com.hps.july.persistence;
/**
 * Bean implementation class for Enterprise Bean: LeaseResource
 */
public class LeaseResourceBean extends com.hps.july.persistence.ResourceBean {
	/**
	 * Implementation field for persistent attribute: needCwAct
	 */
	public boolean needCwAct;
	/**
	 * Implementation field for persistent attribute: useInArendaContract
	 */
	public boolean useInArendaContract;
	/**
	 * Implementation field for persistent attribute: useInAbonentContract
	 */
	public boolean useInAbonentContract;
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
	 * Get accessor for persistent attribute: needCwAct
	 */
	public boolean isNeedCwAct() {
		return needCwAct;
	}
	/**
	 * Set accessor for persistent attribute: needCwAct
	 */
	public void setNeedCwAct(boolean newNeedCwAct) {
		needCwAct = newNeedCwAct;
	}
	/**
	 * Get accessor for persistent attribute: useInArendaContract
	 */
	public boolean isUseInArendaContract() {
		return useInArendaContract;
	}
	/**
	 * Set accessor for persistent attribute: useInArendaContract
	 */
	public void setUseInArendaContract(boolean newUseInArendaContract) {
		useInArendaContract = newUseInArendaContract;
	}
	/**
	 * Get accessor for persistent attribute: useInAbonentContract
	 */
	public boolean isUseInAbonentContract() {
		return useInAbonentContract;
	}
	/**
	 * Set accessor for persistent attribute: useInAbonentContract
	 */
	public void setUseInAbonentContract(boolean newUseInAbonentContract) {
		useInAbonentContract = newUseInAbonentContract;
	}
	
	public final static int RESOURCECLASS2 = 20;
	
	/**
	 * ejbCreate method for a CMP entity bean
	 * @param argResource int
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public void ejbCreate(int argResource, String argName, String argModel, String argNotes, Boolean argComplect, 
		String argCountpolicy, Boolean argBoxable, Boolean argPriceable, Boolean argComplectpart, 
		Boolean argActive, int argSubType, 
		boolean argNeedCwAct, boolean argUseInArendaContract, boolean argUseInAbonentContract) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
		super.ejbCreate(argResource, argName, argModel, argNotes, argComplect, 
			argCountpolicy, argBoxable, argPriceable, argComplectpart, 
			argActive, argSubType, RESOURCECLASS2);
		_initLinks();
		
		// All CMP fields should be initialized here.
		needCwAct = argNeedCwAct;
		useInArendaContract = argUseInArendaContract;
		useInAbonentContract = argUseInAbonentContract;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("useInAbonentContract", new Boolean(isUseInAbonentContract()));
		h.put("needCwAct", new Boolean(isNeedCwAct()));
		h.put("useInArendaContract", new Boolean(isUseInArendaContract()));
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
		Boolean localUseInAbonentContract =
			(Boolean) h.get("useInAbonentContract");
		Boolean localNeedCwAct = (Boolean) h.get("needCwAct");
		Boolean localUseInArendaContract =
			(Boolean) h.get("useInArendaContract");
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

		if (h.containsKey("useInAbonentContract"))
			setUseInAbonentContract((localUseInAbonentContract).booleanValue());
		if (h.containsKey("needCwAct"))
			setNeedCwAct((localNeedCwAct).booleanValue());
		if (h.containsKey("useInArendaContract"))
			setUseInArendaContract((localUseInArendaContract).booleanValue());
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
