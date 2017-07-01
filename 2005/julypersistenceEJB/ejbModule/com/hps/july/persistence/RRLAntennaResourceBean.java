package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 */
public class RRLAntennaResourceBean extends ResourceBean {
	public java.math.BigDecimal freqdevhighk;
	public int freqdevhighlog10;
	public java.math.BigDecimal freqdevlowk;
	public int freqdevlowlog10;
	public String mkkrrecomm;
	public java.sql.Date protocoldate;
	public String protocolnum;
	private final static long serialVersionUID = 3206093459760846163L;
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
}
	public final static int RESOURCECLASS2 = 4;
/**
 * ejbCreate method for a CMP entity bean
 * @param argResource int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argResource, String argName, String argModel, String argNotes, Boolean argComplect, 
	String argCountpolicy, Boolean argBoxable, Boolean argPriceable, Boolean argComplectpart, 
	Boolean argActive, int argSubType,
	java.math.BigDecimal argFreqDevLowK, int argFreqDevLowLog10, 
	java.math.BigDecimal argFreqDevHighK, int argFreqDevHighLog10,
	String argMkkrRecomm, String argProtocolNum, java.sql.Date argProtocolDate
	     ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate(argResource, argName, argModel, argNotes, argComplect, 
		argCountpolicy, argBoxable, argPriceable, argComplectpart, 
		argActive, argSubType, RESOURCECLASS2);
	_initLinks();
	// All CMP fields should be initialized here.

	freqdevlowk = argFreqDevLowK;
	freqdevlowlog10 =  argFreqDevLowLog10;
	freqdevhighk = argFreqDevHighK;
	freqdevhighlog10 = argFreqDevHighLog10;
	mkkrrecomm = argMkkrRecomm;
	protocolnum = argProtocolNum;
	protocoldate = argProtocolDate;
}
/**
 * Getter method for freqdevhighk
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getFreqdevhighk() {
	return freqdevhighk;
}
/**
 * Getter method for freqdevhighlog10
 * @return int
 */
public int getFreqdevhighlog10() {
	return freqdevhighlog10;
}
/**
 * Getter method for freqdevlowk
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getFreqdevlowk() {
	return freqdevlowk;
}
/**
 * Getter method for freqdevlowlog10
 * @return int
 */
public int getFreqdevlowlog10() {
	return freqdevlowlog10;
}
/**
 * Getter method for mkkrrecomm
 * @return java.lang.String
 */
public java.lang.String getMkkrrecomm() {
	return mkkrrecomm;
}
/**
 * Getter method for protocoldate
 * @return java.sql.Date
 */
public java.sql.Date getProtocoldate() {
	return protocoldate;
}
/**
 * Getter method for protocolnum
 * @return java.lang.String
 */
public java.lang.String getProtocolnum() {
	return protocolnum;
}
/**
 * Setter method for freqdevhighk
 * @param newValue java.math.BigDecimal
 */
public void setFreqdevhighk(java.math.BigDecimal newValue) {
	this.freqdevhighk = newValue;
}
/**
 * Setter method for freqdevhighlog10
 * @param newValue int
 */
public void setFreqdevhighlog10(int newValue) {
	this.freqdevhighlog10 = newValue;
}
/**
 * Setter method for freqdevlowk
 * @param newValue java.math.BigDecimal
 */
public void setFreqdevlowk(java.math.BigDecimal newValue) {
	this.freqdevlowk = newValue;
}
/**
 * Setter method for freqdevlowlog10
 * @param newValue int
 */
public void setFreqdevlowlog10(int newValue) {
	this.freqdevlowlog10 = newValue;
}
/**
 * Setter method for mkkrrecomm
 * @param newValue java.lang.String
 */
public void setMkkrrecomm(java.lang.String newValue) {
	this.mkkrrecomm = newValue;
}
/**
 * Setter method for protocoldate
 * @param newValue java.sql.Date
 */
public void setProtocoldate(java.sql.Date newValue) {
	this.protocoldate = newValue;
}
/**
 * Setter method for protocolnum
 * @param newValue java.lang.String
 */
public void setProtocolnum(java.lang.String newValue) {
	this.protocolnum = newValue;
}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("freqdevlowlog10", new Integer(getFreqdevlowlog10()));
		h.put("freqdevlowk", getFreqdevlowk());
		h.put("freqdevhighlog10", new Integer(getFreqdevhighlog10()));
		h.put("protocolnum", getProtocolnum());
		h.put("protocoldate", getProtocoldate());
		h.put("mkkrrecomm", getMkkrrecomm());
		h.put("freqdevhighk", getFreqdevhighk());
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
		Integer localFreqdevlowlog10 = (Integer) h.get("freqdevlowlog10");
		java.math.BigDecimal localFreqdevlowk =
			(java.math.BigDecimal) h.get("freqdevlowk");
		Integer localFreqdevhighlog10 = (Integer) h.get("freqdevhighlog10");
		java.lang.String localProtocolnum =
			(java.lang.String) h.get("protocolnum");
		java.sql.Date localProtocoldate = (java.sql.Date) h.get("protocoldate");
		java.lang.String localMkkrrecomm =
			(java.lang.String) h.get("mkkrrecomm");
		java.math.BigDecimal localFreqdevhighk =
			(java.math.BigDecimal) h.get("freqdevhighk");
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

		if (h.containsKey("freqdevlowlog10"))
			setFreqdevlowlog10((localFreqdevlowlog10).intValue());
		if (h.containsKey("freqdevlowk"))
			setFreqdevlowk((localFreqdevlowk));
		if (h.containsKey("freqdevhighlog10"))
			setFreqdevhighlog10((localFreqdevhighlog10).intValue());
		if (h.containsKey("protocolnum"))
			setProtocolnum((localProtocolnum));
		if (h.containsKey("protocoldate"))
			setProtocoldate((localProtocoldate));
		if (h.containsKey("mkkrrecomm"))
			setMkkrrecomm((localMkkrrecomm));
		if (h.containsKey("freqdevhighk"))
			setFreqdevhighk((localFreqdevhighk));
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
