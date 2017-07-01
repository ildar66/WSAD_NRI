package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Ресурс типа "Репитер"
 */
public class RepiterResBean extends ResourceBean {
	public java.math.BigDecimal bandwidth;
	public Boolean islinear;
	public Integer numchanals;
	public java.math.BigDecimal reppower;
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink repitersLink = null;
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getRepitersLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	repitersLink = null;
}
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException {
	this.getRepitersLink().addElement(aRepiters);
}
	public final static int RESOURCECLASS2 = 5;
	/**
	 * Implementation field for persistent attribute: endbandwidth
	 */
	public java.math.BigDecimal endbandwidth;
	/**
	 * Implementation field for persistent attribute: dimensions
	 */
	public java.lang.String dimensions;
	/**
	 * Implementation field for persistent attribute: weight
	 */
	public java.math.BigDecimal weight;
	/**
	 * Implementation field for persistent attribute: usedpower
	 */
	public java.math.BigDecimal usedpower;
	/**
	 * Implementation field for persistent attribute: gainfactor
	 */
	public java.lang.Integer gainfactor;
	/**
	 * Implementation field for persistent attribute: signaldelay
	 */
	public java.math.BigDecimal signaldelay;
	/**
	 * Implementation field for persistent attribute: noisefactor
	 */
	public java.math.BigDecimal noisefactor;
	/**
	 * Implementation field for persistent attribute: workband
	 */
	public java.lang.Integer workband;
	/**
	 * Implementation field for persistent attribute: linkband
	 */
	public java.lang.Integer linkband;
	/**
	 * Implementation field for persistent attribute: voltageid
	 */
	public java.lang.Integer voltageid;
	/**
	 * Implementation field for persistent attribute: repitertype
	 */
	public java.lang.Integer repitertype;
	/**
	 * Implementation field for persistent attribute: antentriescount
	 */
	public java.lang.Integer antentriescount;
	
	/**
	 * Implementation field for persistent attribute: downlinkband
	 */
	public java.lang.Integer downlinkband;
	/**
	 * Implementation field for persistent attribute: downlinkbandup
	 */
	public java.lang.Integer downlinkbandup;
	/**
	 * Implementation field for persistent attribute: remotecontrol
	 */
	public java.lang.Boolean remotecontrol;
	/**
	 * ejbCreate method for a CMP entity bean
	 * @param argResource int
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public void ejbCreate(int argResource, String argName, String argModel, String argNotes, Boolean argComplect, 
		String argCountpolicy, Boolean argBoxable, Boolean argPriceable, Boolean argComplectpart, 
		Boolean argActive, int argSubType,
		Boolean argIslinear) throws javax.ejb.CreateException, java.rmi.RemoteException {
		
		super.ejbCreate(argResource, argName, argModel, argNotes, argComplect, 
			argCountpolicy, argBoxable, argPriceable, argComplectpart, argActive, argSubType, RESOURCECLASS2);
		_initLinks();
		
		islinear = argIslinear;	
		bandwidth = null;
		numchanals = null;
		reppower = null;	
		endbandwidth = null;
		dimensions = null;
		weight = null;
		usedpower = null;
		gainfactor = null;
		signaldelay = null;
		noisefactor = null;
		workband = null;
		linkband = null;
		voltageid = null;
		repitertype = null;
		antentriescount = null;
		downlinkband = null;
		downlinkbandup = null;
		remotecontrol = null;
	}

/**
 * Getter method for bandwidth
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBandwidth() {
	return bandwidth;
}
/**
 * Getter method for islinear
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIslinear() {
	return islinear;
}
/**
 * Getter method for numchanals
 * @return java.lang.Integer
 */
public java.lang.Integer getNumchanals() {
	return numchanals;
}
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRepiters() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getRepitersLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getRepitersLink() {
	if (repitersLink == null)
		repitersLink = new RepiterResToRepitersLink(this);
	return repitersLink;
}
/**
 * Getter method for reppower
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getReppower() {
	return reppower;
}
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException {
	this.getRepitersLink().removeElement(aRepiters);
}
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRepiters(com.hps.july.persistence.Repiter aRepiters) {
	this.getRepitersLink().secondaryAddElement(aRepiters);
}
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRepiters(com.hps.july.persistence.Repiter aRepiters) {
	this.getRepitersLink().secondaryRemoveElement(aRepiters);
}
/**
 * Setter method for bandwidth
 * @param newValue java.math.BigDecimal
 */
public void setBandwidth(java.math.BigDecimal newValue) {
	this.bandwidth = newValue;
}
/**
 * Setter method for islinear
 * @param newValue java.lang.Boolean
 */
public void setIslinear(java.lang.Boolean newValue) {
	this.islinear = newValue;
}
/**
 * Setter method for numchanals
 * @param newValue java.lang.Integer
 */
public void setNumchanals(java.lang.Integer newValue) {
	this.numchanals = newValue;
}
/**
 * Setter method for reppower
 * @param newValue java.math.BigDecimal
 */
public void setReppower(java.math.BigDecimal newValue) {
	this.reppower = newValue;
}
	/**
	 * Get accessor for persistent attribute: endbandwidth
	 */
	public java.math.BigDecimal getEndbandwidth() {
		return endbandwidth;
	}
	/**
	 * Set accessor for persistent attribute: endbandwidth
	 */
	public void setEndbandwidth(java.math.BigDecimal newEndbandwidth) {
		endbandwidth = newEndbandwidth;
	}
	/**
	 * Get accessor for persistent attribute: dimensions
	 */
	public java.lang.String getDimensions() {
		return dimensions;
	}
	/**
	 * Set accessor for persistent attribute: dimensions
	 */
	public void setDimensions(java.lang.String newDimensions) {
		dimensions = newDimensions;
	}
	/**
	 * Get accessor for persistent attribute: weight
	 */
	public java.math.BigDecimal getWeight() {
		return weight;
	}
	/**
	 * Set accessor for persistent attribute: weight
	 */
	public void setWeight(java.math.BigDecimal newWeight) {
		weight = newWeight;
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
	 * Get accessor for persistent attribute: gainfactor
	 */
	public java.lang.Integer getGainfactor() {
		return gainfactor;
	}
	/**
	 * Set accessor for persistent attribute: gainfactor
	 */
	public void setGainfactor(java.lang.Integer newGainfactor) {
		gainfactor = newGainfactor;
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
	 * Get accessor for persistent attribute: repitertype
	 */
	public java.lang.Integer getRepitertype() {
		return repitertype;
	}
	/**
	 * Set accessor for persistent attribute: repitertype
	 */
	public void setRepitertype(java.lang.Integer newRepitertype) {
		repitertype = newRepitertype;
	}
	/**
	 * Get accessor for persistent attribute: antentriescount
	 */
	public java.lang.Integer getAntentriescount() {
		return antentriescount;
	}
	/**
	 * Set accessor for persistent attribute: antentriescount
	 */
	public void setAntentriescount(java.lang.Integer newAntentriescount) {
		antentriescount = newAntentriescount;
	}
	/**
	 * Get accessor for persistent attribute: downlinkband
	 */
	public java.lang.Integer getDownlinkband() {
		return downlinkband;
	}
	/**
	 * Set accessor for persistent attribute: downlinkband
	 */
	public void setDownlinkband(java.lang.Integer newDownlinkband) {
		downlinkband = newDownlinkband;
	}
	/**
	 * Get accessor for persistent attribute: downlinkbandup
	 */
	public java.lang.Integer getDownlinkbandup() {
		return downlinkbandup;
	}
	/**
	 * Set accessor for persistent attribute: downlinkbandup
	 */
	public void setDownlinkbandup(java.lang.Integer newDownlinkbandup) {
		downlinkbandup = newDownlinkbandup;
	}
	/**
	 * Get accessor for persistent attribute: remotecontrol
	 */
	public java.lang.Boolean getRemotecontrol() {
		return remotecontrol;
	}
	/**
	 * Set accessor for persistent attribute: remotecontrol
	 */
	public void setRemotecontrol(java.lang.Boolean newRemotecontrol) {
		remotecontrol = newRemotecontrol;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("voltageid", getVoltageid());
		h.put("dimensions", getDimensions());
		h.put("repitertype", getRepitertype());
		h.put("weight", getWeight());
		h.put("noisefactor", getNoisefactor());
		h.put("downlinkbandup", getDownlinkbandup());
		h.put("antentriescount", getAntentriescount());
		h.put("reppower", getReppower());
		h.put("remotecontrol", getRemotecontrol());
		h.put("gainfactor", getGainfactor());
		h.put("linkband", getLinkband());
		h.put("numchanals", getNumchanals());
		h.put("endbandwidth", getEndbandwidth());
		h.put("downlinkband", getDownlinkband());
		h.put("bandwidth", getBandwidth());
		h.put("workband", getWorkband());
		h.put("usedpower", getUsedpower());
		h.put("signaldelay", getSignaldelay());
		h.put("islinear", getIslinear());
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
		java.lang.Integer localVoltageid =
			(java.lang.Integer) h.get("voltageid");
		java.lang.String localDimensions =
			(java.lang.String) h.get("dimensions");
		java.lang.Integer localRepitertype =
			(java.lang.Integer) h.get("repitertype");
		java.math.BigDecimal localWeight =
			(java.math.BigDecimal) h.get("weight");
		java.math.BigDecimal localNoisefactor =
			(java.math.BigDecimal) h.get("noisefactor");
		java.lang.Integer localDownlinkbandup =
			(java.lang.Integer) h.get("downlinkbandup");
		java.lang.Integer localAntentriescount =
			(java.lang.Integer) h.get("antentriescount");
		java.math.BigDecimal localReppower =
			(java.math.BigDecimal) h.get("reppower");
		java.lang.Boolean localRemotecontrol =
			(java.lang.Boolean) h.get("remotecontrol");
		java.lang.Integer localGainfactor =
			(java.lang.Integer) h.get("gainfactor");
		java.lang.Integer localLinkband = (java.lang.Integer) h.get("linkband");
		java.lang.Integer localNumchanals =
			(java.lang.Integer) h.get("numchanals");
		java.math.BigDecimal localEndbandwidth =
			(java.math.BigDecimal) h.get("endbandwidth");
		java.lang.Integer localDownlinkband =
			(java.lang.Integer) h.get("downlinkband");
		java.math.BigDecimal localBandwidth =
			(java.math.BigDecimal) h.get("bandwidth");
		java.lang.Integer localWorkband = (java.lang.Integer) h.get("workband");
		java.math.BigDecimal localUsedpower =
			(java.math.BigDecimal) h.get("usedpower");
		java.math.BigDecimal localSignaldelay =
			(java.math.BigDecimal) h.get("signaldelay");
		java.lang.Boolean localIslinear = (java.lang.Boolean) h.get("islinear");
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

		if (h.containsKey("voltageid"))
			setVoltageid((localVoltageid));
		if (h.containsKey("dimensions"))
			setDimensions((localDimensions));
		if (h.containsKey("repitertype"))
			setRepitertype((localRepitertype));
		if (h.containsKey("weight"))
			setWeight((localWeight));
		if (h.containsKey("noisefactor"))
			setNoisefactor((localNoisefactor));
		if (h.containsKey("downlinkbandup"))
			setDownlinkbandup((localDownlinkbandup));
		if (h.containsKey("antentriescount"))
			setAntentriescount((localAntentriescount));
		if (h.containsKey("reppower"))
			setReppower((localReppower));
		if (h.containsKey("remotecontrol"))
			setRemotecontrol((localRemotecontrol));
		if (h.containsKey("gainfactor"))
			setGainfactor((localGainfactor));
		if (h.containsKey("linkband"))
			setLinkband((localLinkband));
		if (h.containsKey("numchanals"))
			setNumchanals((localNumchanals));
		if (h.containsKey("endbandwidth"))
			setEndbandwidth((localEndbandwidth));
		if (h.containsKey("downlinkband"))
			setDownlinkband((localDownlinkband));
		if (h.containsKey("bandwidth"))
			setBandwidth((localBandwidth));
		if (h.containsKey("workband"))
			setWorkband((localWorkband));
		if (h.containsKey("usedpower"))
			setUsedpower((localUsedpower));
		if (h.containsKey("signaldelay"))
			setSignaldelay((localSignaldelay));
		if (h.containsKey("islinear"))
			setIslinear((localIslinear));
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
