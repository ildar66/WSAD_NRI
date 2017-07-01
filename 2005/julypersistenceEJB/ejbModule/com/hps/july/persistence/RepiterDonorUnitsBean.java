package com.hps.july.persistence;
/**
 * Bean implementation class for Enterprise Bean: RepiterDonorUnits
 */
public class RepiterDonorUnitsBean
	extends com.hps.july.persistence.ResourceBean {
	/**
	 * Implementation field for persistent attribute: power
	 */
	public java.math.BigDecimal power;
	/**
	 * Implementation field for persistent attribute: workband
	 */
	public java.lang.Integer workband;
	/**
	 * Implementation field for persistent attribute: linkband
	 */
	public java.lang.Integer linkband;
	/**
	 * Implementation field for persistent attribute: gainfactor
	 */
	public java.math.BigDecimal gainfactor;
	/**
	 * Implementation field for persistent attribute: voltageid
	 */
	public java.lang.Integer voltageid;
	/**
	 * Implementation field for persistent attribute: usedpower
	 */
	public java.math.BigDecimal usedpower;
	/**
	 * Implementation field for persistent attribute: entriescount
	 */
	public java.lang.Integer entriescount;
	/**
	 * Implementation field for persistent attribute: antgatescount
	 */
	public java.lang.Integer antgatescount;
	/**
	 * Implementation field for persistent attribute: signaldelay
	 */
	public java.math.BigDecimal signaldelay;
	/**
	 * Implementation field for persistent attribute: noisefactor
	 */
	public java.math.BigDecimal noisefactor;
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
	/**
	 * Get accessor for persistent attribute: workband
	 */
	public java.lang.Integer getWorkband() {
		return workband;
	}
	/**
	 * Set accessor for persistent attribute: workband
	 */
	public void setWorkband(java.lang.Integer newWorkband) {
		workband = newWorkband;
	}
	/**
	 * Get accessor for persistent attribute: linkband
	 */
	public java.lang.Integer getLinkband() {
		return linkband;
	}
	/**
	 * Set accessor for persistent attribute: linkband
	 */
	public void setLinkband(java.lang.Integer newLinkband) {
		linkband = newLinkband;
	}
	/**
	 * Get accessor for persistent attribute: gainfactor
	 */
	public java.math.BigDecimal getGainfactor() {
		return gainfactor;
	}
	/**
	 * Set accessor for persistent attribute: gainfactor
	 */
	public void setGainfactor(java.math.BigDecimal newGainfactor) {
		gainfactor = newGainfactor;
	}
	/**
	 * Get accessor for persistent attribute: voltageid
	 */
	public java.lang.Integer getVoltageid() {
		return voltageid;
	}
	/**
	 * Set accessor for persistent attribute: voltageid
	 */
	public void setVoltageid(java.lang.Integer newVoltageid) {
		voltageid = newVoltageid;
	}
	/**
	 * Get accessor for persistent attribute: usedpower
	 */
	public java.math.BigDecimal getUsedpower() {
		return usedpower;
	}
	/**
	 * Set accessor for persistent attribute: usedpower
	 */
	public void setUsedpower(java.math.BigDecimal newUsedpower) {
		usedpower = newUsedpower;
	}
	/**
	 * Get accessor for persistent attribute: entriescount
	 */
	public java.lang.Integer getEntriescount() {
		return entriescount;
	}
	/**
	 * Set accessor for persistent attribute: entriescount
	 */
	public void setEntriescount(java.lang.Integer newEntriescount) {
		entriescount = newEntriescount;
	}
	/**
	 * Get accessor for persistent attribute: antgatescount
	 */
	public java.lang.Integer getAntgatescount() {
		return antgatescount;
	}
	/**
	 * Set accessor for persistent attribute: antgatescount
	 */
	public void setAntgatescount(java.lang.Integer newAntgatescount) {
		antgatescount = newAntgatescount;
	}
	/**
	 * Get accessor for persistent attribute: signaldelay
	 */
	public java.math.BigDecimal getSignaldelay() {
		return signaldelay;
	}
	/**
	 * Set accessor for persistent attribute: signaldelay
	 */
	public void setSignaldelay(java.math.BigDecimal newSignaldelay) {
		signaldelay = newSignaldelay;
	}
	/**
	 * Get accessor for persistent attribute: noisefactor
	 */
	public java.math.BigDecimal getNoisefactor() {
		return noisefactor;
	}
	/**
	 * Set accessor for persistent attribute: noisefactor
	 */
	public void setNoisefactor(java.math.BigDecimal newNoisefactor) {
		noisefactor = newNoisefactor;
	}
	
	public final static int RESOURCE_CLASS2 = 21;
	
	public void ejbCreate(int argResource, String argName, String argModel, String argNotes, Boolean argComplect, 
		String argCountpolicy, Boolean argBoxable, Boolean argPriceable, Boolean argComplectpart, 
		Boolean argActive, int argSubType) throws javax.ejb.CreateException, java.rmi.RemoteException {
			super.ejbCreate(argResource, argName, argModel, argNotes, argComplect, 
			argCountpolicy, argBoxable, argPriceable, argComplectpart, 
			argActive, argSubType, RESOURCE_CLASS2);
		_initLinks();
		// All CMP fields should be initialized here.
		power = null;
		workband = null;
		linkband = null;
		gainfactor = null;
		voltageid = null;
		usedpower = null;
		entriescount = null;
		antgatescount = null;
		signaldelay = null;
		noisefactor = null;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("signaldelay", getSignaldelay());
		h.put("power", getPower());
		h.put("entriescount", getEntriescount());
		h.put("usedpower", getUsedpower());
		h.put("workband", getWorkband());
		h.put("gainfactor", getGainfactor());
		h.put("linkband", getLinkband());
		h.put("noisefactor", getNoisefactor());
		h.put("voltageid", getVoltageid());
		h.put("antgatescount", getAntgatescount());
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
		java.math.BigDecimal localSignaldelay =
			(java.math.BigDecimal) h.get("signaldelay");
		java.math.BigDecimal localPower = (java.math.BigDecimal) h.get("power");
		java.lang.Integer localEntriescount =
			(java.lang.Integer) h.get("entriescount");
		java.math.BigDecimal localUsedpower =
			(java.math.BigDecimal) h.get("usedpower");
		java.lang.Integer localWorkband = (java.lang.Integer) h.get("workband");
		java.math.BigDecimal localGainfactor =
			(java.math.BigDecimal) h.get("gainfactor");
		java.lang.Integer localLinkband = (java.lang.Integer) h.get("linkband");
		java.math.BigDecimal localNoisefactor =
			(java.math.BigDecimal) h.get("noisefactor");
		java.lang.Integer localVoltageid =
			(java.lang.Integer) h.get("voltageid");
		java.lang.Integer localAntgatescount =
			(java.lang.Integer) h.get("antgatescount");
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

		if (h.containsKey("signaldelay"))
			setSignaldelay((localSignaldelay));
		if (h.containsKey("power"))
			setPower((localPower));
		if (h.containsKey("entriescount"))
			setEntriescount((localEntriescount));
		if (h.containsKey("usedpower"))
			setUsedpower((localUsedpower));
		if (h.containsKey("workband"))
			setWorkband((localWorkband));
		if (h.containsKey("gainfactor"))
			setGainfactor((localGainfactor));
		if (h.containsKey("linkband"))
			setLinkband((localLinkband));
		if (h.containsKey("noisefactor"))
			setNoisefactor((localNoisefactor));
		if (h.containsKey("voltageid"))
			setVoltageid((localVoltageid));
		if (h.containsKey("antgatescount"))
			setAntgatescount((localAntgatescount));
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
