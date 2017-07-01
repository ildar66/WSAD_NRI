package com.hps.july.persistence;
/**
 * Bean implementation class for Enterprise Bean: CfgDocument
 */
public class CfgDocumentBean extends com.hps.july.persistence.DocumentBean {
	/**
	 * Implementation field for persistent attribute: savconfigidold
	 */
	public int savconfigidold;
	/**
	 * Implementation field for persistent attribute: savconfigidnew
	 */
	public int savconfigidnew;

	/**
	 * Implementation field for persistent attribute: storedem
	 */
	public java.lang.Integer storedem;
	/**
	 * Implementation field for persistent attribute: storebad
	 */
	public java.lang.Integer storebad;
	public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, 
			Boolean argProcessSource, Boolean argProcessDestination,
			int SavconfigIdOld, int SavconfigIdNew ) throws javax.ejb.CreateException, java.rmi.RemoteException {
				super.ejbCreate(argDocument, argOwner, argFrom, 
				argTo, argBlankDate, argBlankindex, argBlankNumber, 
				argState, argProcessSource, argProcessDestination);
		_initLinks();
		// All CMP fields should be initialized here.
		savconfigidold = SavconfigIdOld;
		savconfigidnew = SavconfigIdNew;
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
	 * Get accessor for persistent attribute: savconfigidold
	 */
	public int getSavconfigidold() {
		return savconfigidold;
	}
	/**
	 * Set accessor for persistent attribute: savconfigidold
	 */
	public void setSavconfigidold(int newSavconfigidold) {
		savconfigidold = newSavconfigidold;
	}
	/**
	 * Get accessor for persistent attribute: savconfigidnew
	 */
	public int getSavconfigidnew() {
		return savconfigidnew;
	}
	/**
	 * Set accessor for persistent attribute: savconfigidnew
	 */
	public void setSavconfigidnew(int newSavconfigidnew) {
		savconfigidnew = newSavconfigidnew;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("savconfigidold", new Integer(getSavconfigidold()));
		h.put("savconfigidnew", new Integer(getSavconfigidnew()));
		h.put("visualtype", getVisualtype());
		h.put("blankindex", new Integer(getBlankindex()));
		h.put("document", new Integer(getDocument()));
		h.put("insurancedate", getInsurancedate());
		h.put("processSource", getProcessSource());
		h.put("showtouser", new Boolean(getShowtouser()));
		h.put("storageManagerKey", getStorageManagerKey());
		h.put("isautodoc", new Boolean(getIsautodoc()));
		h.put("blanknumber", getBlanknumber());
		h.put("contragentKey", getContragentKey());
		h.put("prjstatus", getPrjstatus());
		h.put("insuranseMan", getInsuranseMan());
		h.put("fromKey", getFromKey());
		h.put("parentdocument", getParentdocument());
		h.put("needapprove", new Boolean(getNeedapprove()));
		h.put("documentState", getDocumentState());
		h.put("processDestination", getProcessDestination());
		h.put("to2", getTo2());
		h.put("blankdate", getBlankdate());
		h.put("operator", getOperator());
		h.put("projectid", getProjectid());
		h.put("insuranceact", getInsuranceact());
		h.put("toKey", getToKey());
		h.put("ownerKey", getOwnerKey());
		h.put("storebad", getStorebad());
		h.put("storedem", getStoredem());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Integer localSavconfigidold = (Integer) h.get("savconfigidold");
		Integer localSavconfigidnew = (Integer) h.get("savconfigidnew");
		java.lang.Integer localVisualtype =
			(java.lang.Integer) h.get("visualtype");
		Integer localBlankindex = (Integer) h.get("blankindex");
		Integer localDocument = (Integer) h.get("document");
		java.sql.Date localInsurancedate =
			(java.sql.Date) h.get("insurancedate");
		java.lang.Boolean localProcessSource =
			(java.lang.Boolean) h.get("processSource");
		Boolean localShowtouser = (Boolean) h.get("showtouser");
		Boolean localIsautodoc = (Boolean) h.get("isautodoc");
		java.lang.String localBlanknumber =
			(java.lang.String) h.get("blanknumber");
		java.lang.String localPrjstatus = (java.lang.String) h.get("prjstatus");
		java.lang.String localInsuranseMan =
			(java.lang.String) h.get("insuranseMan");
		java.lang.Integer localParentdocument =
			(java.lang.Integer) h.get("parentdocument");
		Boolean localNeedapprove = (Boolean) h.get("needapprove");
		java.lang.String localDocumentState =
			(java.lang.String) h.get("documentState");
		java.lang.Boolean localProcessDestination =
			(java.lang.Boolean) h.get("processDestination");
		java.lang.Integer localTo2 = (java.lang.Integer) h.get("to2");
		java.sql.Date localBlankdate = (java.sql.Date) h.get("blankdate");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.lang.Integer localProjectid =
			(java.lang.Integer) h.get("projectid");
		java.lang.String localInsuranceact =
			(java.lang.String) h.get("insuranceact");
		java.lang.Integer localStorebad = (java.lang.Integer) h.get("storebad");
		java.lang.Integer localStoredem = (java.lang.Integer) h.get("storedem");

		if (h.containsKey("savconfigidold"))
			setSavconfigidold((localSavconfigidold).intValue());
		if (h.containsKey("savconfigidnew"))
			setSavconfigidnew((localSavconfigidnew).intValue());
		if (h.containsKey("visualtype"))
			setVisualtype((localVisualtype));
		if (h.containsKey("blankindex"))
			setBlankindex((localBlankindex).intValue());
		if (h.containsKey("document"))
			setDocument((localDocument).intValue());
		if (h.containsKey("insurancedate"))
			setInsurancedate((localInsurancedate));
		if (h.containsKey("processSource"))
			setProcessSource((localProcessSource));
		if (h.containsKey("showtouser"))
			setShowtouser((localShowtouser).booleanValue());
		if (h.containsKey("isautodoc"))
			setIsautodoc((localIsautodoc).booleanValue());
		if (h.containsKey("blanknumber"))
			setBlanknumber((localBlanknumber));
		if (h.containsKey("prjstatus"))
			setPrjstatus((localPrjstatus));
		if (h.containsKey("insuranseMan"))
			setInsuranseMan((localInsuranseMan));
		if (h.containsKey("parentdocument"))
			setParentdocument((localParentdocument));
		if (h.containsKey("needapprove"))
			setNeedapprove((localNeedapprove).booleanValue());
		if (h.containsKey("documentState"))
			setDocumentState((localDocumentState));
		if (h.containsKey("processDestination"))
			setProcessDestination((localProcessDestination));
		if (h.containsKey("to2"))
			setTo2((localTo2));
		if (h.containsKey("blankdate"))
			setBlankdate((localBlankdate));
		if (h.containsKey("operator"))
			setOperator((localOperator));
		if (h.containsKey("projectid"))
			setProjectid((localProjectid));
		if (h.containsKey("insuranceact"))
			setInsuranceact((localInsuranceact));
		if (h.containsKey("storebad"))
			setStorebad((localStorebad));
		if (h.containsKey("storedem"))
			setStoredem((localStoredem));
	}
	/**
	 * Get accessor for persistent attribute: storedem
	 */
	public java.lang.Integer getStoredem() {
		return storedem;
	}
	/**
	 * Set accessor for persistent attribute: storedem
	 */
	public void setStoredem(java.lang.Integer newStoredem) {
		storedem = newStoredem;
	}
	/**
	 * Get accessor for persistent attribute: storebad
	 */
	public java.lang.Integer getStorebad() {
		return storebad;
	}
	/**
	 * Set accessor for persistent attribute: storebad
	 */
	public void setStorebad(java.lang.Integer newStorebad) {
		storebad = newStorebad;
	}
}
