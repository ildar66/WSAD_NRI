package com.hps.july.persistence2;
/**
 * Bean implementation class for Enterprise Bean: Country
 */
public class CountryBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: country
	 */
	public int country;
	/**
	 * Implementation field for persistent attribute: name
	 */
	public java.lang.String name;
	/**
	 * Implementation field for persistent attribute: ccode
	 */
	public java.math.BigDecimal ccode;
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
	public com.hps.july.persistence2.CountryKey ejbCreate(int argCountry, String argName, java.math.BigDecimal argCCode)
		throws javax.ejb.CreateException {
		_initLinks();
		country = argCountry;
		name = argName;
		ccode = argCCode;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int country) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName) {
		name = newName;
	}
	/**
	 * Get accessor for persistent attribute: ccode
	 */
	public java.math.BigDecimal getCcode() {
		return ccode;
	}
	/**
	 * Set accessor for persistent attribute: ccode
	 */
	public void setCcode(java.math.BigDecimal newCcode) {
		ccode = newCcode;
	}
	/**
	 * @return
	 */
	public int getCountry() {
		return country;
	}

	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("name", getName());
		h.put("ccode", getCcode());
		h.put("country", new Integer(getCountry()));
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localName = (java.lang.String) h.get("name");
		java.math.BigDecimal localCcode = (java.math.BigDecimal) h.get("ccode");

		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("ccode"))
			setCcode((localCcode));
	}
}
