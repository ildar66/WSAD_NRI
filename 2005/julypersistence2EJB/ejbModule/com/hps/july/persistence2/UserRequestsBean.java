package com.hps.july.persistence2;
/**
 * Bean implementation class for Enterprise Bean: UserRequests
 */
public class UserRequestsBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: request
	 */
	public int request;
	/**
	 * Implementation field for persistent attribute: datetimein
	 */
	public java.sql.Date datetimein;
	/**
	 * Implementation field for persistent attribute: requesttype
	 */
	public int requesttype;
	/**
	 * Implementation field for persistent attribute: filialtype
	 */
	public int filialtype;
	/**
	 * Implementation field for persistent attribute: module
	 */
	public int module;
	/**
	 * Implementation field for persistent attribute: description
	 */
	public java.lang.String description;
	/**
	 * Implementation field for persistent attribute: status
	 */
	public java.lang.String status;
	/**
	 * Implementation field for persistent attribute: rfcnum
	 */
	public java.lang.String rfcnum;
	/**
	 * Implementation field for persistent attribute: regionid
	 */
	public java.lang.Integer regionid;
	/**
	 * Implementation field for persistent attribute: supregid
	 */
	public java.lang.Integer supregid;
	/**
	 * Implementation field for persistent attribute: worker
	 */
	public int worker;
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence2.UserRequestsKey ejbCreate(int argRequest, java.sql.Date argDatetimein,
			int argRequesttype, int argFilialtype, int argWorker, int argModule, 
			String argDescr, String argStatus)
		throws javax.ejb.CreateException {
		_initLinks();
		request = argRequest;
		datetimein = argDatetimein;
		requesttype = argRequesttype;
		filialtype = argFilialtype;
		regionid = null;
		supregid = null;
		worker = argWorker;
		module = argModule;
		description = argDescr;
		status = argStatus;
		rfcnum = null;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int request) throws javax.ejb.CreateException {
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
	 * This method was generated for supporting the associations.
	 */
	protected void _initLinks() {
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected java.util.Vector _getLinks() {
		java.util.Vector links = new java.util.Vector();
		return links;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _removeLinks()
		throws java.rmi.RemoteException, javax.ejb.RemoveException {
		java.util.List links = _getLinks();
		for (int i = 0; i < links.size(); i++) {
			try {
				((com.ibm.ivj.ejb.associations.interfaces.Link) links.get(i))
					.remove();
			} catch (javax.ejb.FinderException e) {
			} //Consume Finder error since I am going away
		}
	}
	/**
	 * Get accessor for persistent attribute: datetimein
	 */
	public java.sql.Date getDatetimein() {
		return datetimein;
	}
	/**
	 * Set accessor for persistent attribute: datetimein
	 */
	public void setDatetimein(java.sql.Date newDatetimein) {
		datetimein = newDatetimein;
	}
	/**
	 * Get accessor for persistent attribute: requesttype
	 */
	public int getRequesttype() {
		return requesttype;
	}
	/**
	 * Set accessor for persistent attribute: requesttype
	 */
	public void setRequesttype(int newRequesttype) {
		requesttype = newRequesttype;
	}
	/**
	 * Get accessor for persistent attribute: filialtype
	 */
	public int getFilialtype() {
		return filialtype;
	}
	/**
	 * Set accessor for persistent attribute: filialtype
	 */
	public void setFilialtype(int newFilialtype) {
		filialtype = newFilialtype;
	}
	/**
	 * Get accessor for persistent attribute: module
	 */
	public int getModule() {
		return module;
	}
	/**
	 * Set accessor for persistent attribute: module
	 */
	public void setModule(int newModule) {
		module = newModule;
	}
	/**
	 * Get accessor for persistent attribute: description
	 */
	public java.lang.String getDescription() {
		return description;
	}
	/**
	 * Set accessor for persistent attribute: description
	 */
	public void setDescription(java.lang.String newDescription) {
		description = newDescription;
	}
	/**
	 * Get accessor for persistent attribute: status
	 */
	public java.lang.String getStatus() {
		return status;
	}
	/**
	 * Set accessor for persistent attribute: status
	 */
	public void setStatus(java.lang.String newStatus) {
		status = newStatus;
	}
	/**
	 * Get accessor for persistent attribute: rfcnum
	 */
	public java.lang.String getRfcnum() {
		return rfcnum;
	}
	/**
	 * Set accessor for persistent attribute: rfcnum
	 */
	public void setRfcnum(java.lang.String newRfcnum) {
		rfcnum = newRfcnum;
	}
	/**
	 * @return
	 */
	public int getRequest() {
		return request;
	}

	/**
	 * @param i
	 */
	public void setRequest(int i) {
		request = i;
	}

	/**
	 * Get accessor for persistent attribute: regionid
	 */
	public java.lang.Integer getRegionid() {
		return regionid;
	}
	/**
	 * Set accessor for persistent attribute: regionid
	 */
	public void setRegionid(java.lang.Integer newRegionid) {
		regionid = newRegionid;
	}
	/**
	 * Get accessor for persistent attribute: supregid
	 */
	public java.lang.Integer getSupregid() {
		return supregid;
	}
	/**
	 * Set accessor for persistent attribute: supregid
	 */
	public void setSupregid(java.lang.Integer newSupregid) {
		supregid = newSupregid;
	}
	/**
	 * Get accessor for persistent attribute: worker
	 */
	public int getWorker() {
		return worker;
	}
	/**
	 * Set accessor for persistent attribute: worker
	 */
	public void setWorker(int newWorker) {
		worker = newWorker;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("module", new Integer(getModule()));
		h.put("requesttype", new Integer(getRequesttype()));
		h.put("worker", new Integer(getWorker()));
		h.put("request", new Integer(getRequest()));
		h.put("status", getStatus());
		h.put("supregid", getSupregid());
		h.put("datetimein", getDatetimein());
		h.put("rfcnum", getRfcnum());
		h.put("regionid", getRegionid());
		h.put("description", getDescription());
		h.put("filialtype", new Integer(getFilialtype()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Integer localModule = (Integer) h.get("module");
		Integer localRequesttype = (Integer) h.get("requesttype");
		Integer localWorker = (Integer) h.get("worker");
		Integer localRequest = (Integer) h.get("request");
		java.lang.String localStatus = (java.lang.String) h.get("status");
		java.lang.Integer localSupregid = (java.lang.Integer) h.get("supregid");
		java.sql.Date localDatetimein = (java.sql.Date) h.get("datetimein");
		java.lang.String localRfcnum = (java.lang.String) h.get("rfcnum");
		java.lang.Integer localRegionid = (java.lang.Integer) h.get("regionid");
		java.lang.String localDescription =
			(java.lang.String) h.get("description");
		Integer localFilialtype = (Integer) h.get("filialtype");

		if (h.containsKey("module"))
			setModule((localModule).intValue());
		if (h.containsKey("requesttype"))
			setRequesttype((localRequesttype).intValue());
		if (h.containsKey("worker"))
			setWorker((localWorker).intValue());
		if (h.containsKey("request"))
			setRequest((localRequest).intValue());
		if (h.containsKey("status"))
			setStatus((localStatus));
		if (h.containsKey("supregid"))
			setSupregid((localSupregid));
		if (h.containsKey("datetimein"))
			setDatetimein((localDatetimein));
		if (h.containsKey("rfcnum"))
			setRfcnum((localRfcnum));
		if (h.containsKey("regionid"))
			setRegionid((localRegionid));
		if (h.containsKey("description"))
			setDescription((localDescription));
		if (h.containsKey("filialtype"))
			setFilialtype((localFilialtype).intValue());
	}
}
