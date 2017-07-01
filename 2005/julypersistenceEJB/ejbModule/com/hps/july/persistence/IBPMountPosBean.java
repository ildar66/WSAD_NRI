package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 */
public class IBPMountPosBean extends DocumentPositionBean {
	private final static long serialVersionUID = 3206093459760846163L;

	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("resourceKey", getResourceKey());
		h.put("documentKey", getDocumentKey());
		h.put("realserial", getRealserial());
		h.put("sourceBroken", getSourceBroken());
		h.put("cardFromKey", getCardFromKey());
		h.put("resultClosed", getResultClosed());
		h.put("visualtagid", getVisualtagid());
		h.put("isfictserial", new Boolean(getIsfictserial()));
		h.put("cardToKey", getCardToKey());
		h.put("serialnumber", getSerialnumber());
		h.put("isReadOnly", new Boolean(getIsReadOnly()));
		h.put("agregateKey", getAgregateKey());
		h.put("sum", getSum());
		h.put("newplace", getNewplace());
		h.put("sourceClosed", getSourceClosed());
		h.put("agregateSerial", getAgregateSerial());
		h.put("manufserial", getManufserial());
		h.put("price", getPrice());
		h.put("resultBoxed", getResultBoxed());
		h.put("comment", getComment());
		h.put("docposition", new Integer(getDocposition()));
		h.put("oldplace", getOldplace());
		h.put("oldAgregateSerial", getOldAgregateSerial());
		h.put("order", new Integer(getOrder()));
		h.put("agregateresource", getAgregateresource());
		h.put("qty", getQty());
		h.put("party", getParty());
		h.put("configuration", getConfiguration());
		h.put("notes", getNotes());
		h.put("resultBroken", getResultBroken());
		h.put("oldagregateresource", getOldagregateresource());
		h.put("ownerKey", getOwnerKey());
		h.put("sourceBoxed", getSourceBoxed());
		h.put("oldagrlocserial", getOldagrlocserial());
		h.put("oldagrmanufserial", getOldagrmanufserial());
		h.put("agrlocserial", getAgrlocserial());
		h.put("localserial", getLocalserial());
		h.put("agrmanufserial", getAgrmanufserial());
		h.put("parentbtsdocpos", getParentbtsdocpos());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localRealserial =
			(java.lang.String) h.get("realserial");
		java.lang.Boolean localSourceBroken =
			(java.lang.Boolean) h.get("sourceBroken");
		java.lang.Boolean localResultClosed =
			(java.lang.Boolean) h.get("resultClosed");
		java.lang.Integer localVisualtagid =
			(java.lang.Integer) h.get("visualtagid");
		Boolean localIsfictserial = (Boolean) h.get("isfictserial");
		java.lang.String localSerialnumber =
			(java.lang.String) h.get("serialnumber");
		java.lang.String localNewplace = (java.lang.String) h.get("newplace");
		java.lang.Boolean localSourceClosed =
			(java.lang.Boolean) h.get("sourceClosed");
		java.lang.String localAgregateSerial =
			(java.lang.String) h.get("agregateSerial");
		java.lang.String localManufserial =
			(java.lang.String) h.get("manufserial");
		java.math.BigDecimal localPrice = (java.math.BigDecimal) h.get("price");
		java.lang.Boolean localResultBoxed =
			(java.lang.Boolean) h.get("resultBoxed");
		java.lang.String localComment = (java.lang.String) h.get("comment");
		Integer localDocposition = (Integer) h.get("docposition");
		java.lang.String localOldplace = (java.lang.String) h.get("oldplace");
		java.lang.String localOldAgregateSerial =
			(java.lang.String) h.get("oldAgregateSerial");
		Integer localOrder = (Integer) h.get("order");
		java.lang.Integer localAgregateresource =
			(java.lang.Integer) h.get("agregateresource");
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");
		java.lang.String localParty = (java.lang.String) h.get("party");
		java.lang.String localConfiguration =
			(java.lang.String) h.get("configuration");
		java.lang.String localNotes = (java.lang.String) h.get("notes");
		java.lang.Boolean localResultBroken =
			(java.lang.Boolean) h.get("resultBroken");
		java.lang.Integer localOldagregateresource =
			(java.lang.Integer) h.get("oldagregateresource");
		java.lang.Boolean localSourceBoxed =
			(java.lang.Boolean) h.get("sourceBoxed");
		java.lang.String localOldagrlocserial =
			(java.lang.String) h.get("oldagrlocserial");
		java.lang.String localOldagrmanufserial =
			(java.lang.String) h.get("oldagrmanufserial");
		java.lang.String localAgrlocserial =
			(java.lang.String) h.get("agrlocserial");
		java.lang.String localLocalserial =
			(java.lang.String) h.get("localserial");
		java.lang.String localAgrmanufserial =
			(java.lang.String) h.get("agrmanufserial");
		java.lang.Integer localParentbtsdocpos =
			(java.lang.Integer) h.get("parentbtsdocpos");

		if (h.containsKey("realserial"))
			setRealserial((localRealserial));
		if (h.containsKey("sourceBroken"))
			setSourceBroken((localSourceBroken));
		if (h.containsKey("resultClosed"))
			setResultClosed((localResultClosed));
		if (h.containsKey("visualtagid"))
			setVisualtagid((localVisualtagid));
		if (h.containsKey("isfictserial"))
			setIsfictserial((localIsfictserial).booleanValue());
		if (h.containsKey("serialnumber"))
			setSerialnumber((localSerialnumber));
		if (h.containsKey("newplace"))
			setNewplace((localNewplace));
		if (h.containsKey("sourceClosed"))
			setSourceClosed((localSourceClosed));
		if (h.containsKey("agregateSerial"))
			setAgregateSerial((localAgregateSerial));
		if (h.containsKey("manufserial"))
			setManufserial((localManufserial));
		if (h.containsKey("price"))
			setPrice((localPrice));
		if (h.containsKey("resultBoxed"))
			setResultBoxed((localResultBoxed));
		if (h.containsKey("comment"))
			setComment((localComment));
		if (h.containsKey("docposition"))
			setDocposition((localDocposition).intValue());
		if (h.containsKey("oldplace"))
			setOldplace((localOldplace));
		if (h.containsKey("oldAgregateSerial"))
			setOldAgregateSerial((localOldAgregateSerial));
		if (h.containsKey("order"))
			setOrder((localOrder).intValue());
		if (h.containsKey("agregateresource"))
			setAgregateresource((localAgregateresource));
		if (h.containsKey("qty"))
			setQty((localQty));
		if (h.containsKey("party"))
			setParty((localParty));
		if (h.containsKey("configuration"))
			setConfiguration((localConfiguration));
		if (h.containsKey("notes"))
			setNotes((localNotes));
		if (h.containsKey("resultBroken"))
			setResultBroken((localResultBroken));
		if (h.containsKey("oldagregateresource"))
			setOldagregateresource((localOldagregateresource));
		if (h.containsKey("sourceBoxed"))
			setSourceBoxed((localSourceBoxed));
		if (h.containsKey("oldagrlocserial"))
			setOldagrlocserial((localOldagrlocserial));
		if (h.containsKey("oldagrmanufserial"))
			setOldagrmanufserial((localOldagrmanufserial));
		if (h.containsKey("agrlocserial"))
			setAgrlocserial((localAgrlocserial));
		if (h.containsKey("localserial"))
			setLocalserial((localLocalserial));
		if (h.containsKey("agrmanufserial"))
			setAgrmanufserial((localAgrmanufserial));
		if (h.containsKey("parentbtsdocpos"))
			setParentbtsdocpos((localParentbtsdocpos));
	}
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
}
