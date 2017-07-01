package com.hps.july.persistence2;
/**
 * Bean implementation class for Enterprise Bean: ResourceSetClass
 */
public class ResourceSetClassBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * Implementation field for persistent attribute: classid
	 */
	public int classid;
	/**
	 * Implementation field for persistent attribute: classname
	 */
	public java.lang.String classname;
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
	public com.hps.july.persistence2.ResourceSetClassKey ejbCreate(int argClassid, String argClassname)
		throws javax.ejb.CreateException {
		_initLinks();
		classid = argClassid;
		classname = argClassname;
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int classid) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: classname
	 */
	public java.lang.String getClassname() {
		return classname;
	}
	/**
	 * Set accessor for persistent attribute: classname
	 */
	public void setClassname(java.lang.String newClassname) {
		classname = newClassname;
	}
	/**
	 * @return
	 */
	public int getClassid() {
		return classid;
	}

	/**
	 * @param i
	 */
	public void setClassid(int i) {
		classid = i;
	}

	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("classid", new Integer(getClassid()));
		h.put("classname", getClassname());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Integer localClassid = (Integer) h.get("classid");
		java.lang.String localClassname = (java.lang.String) h.get("classname");

		if (h.containsKey("classid"))
			setClassid((localClassid).intValue());
		if (h.containsKey("classname"))
			setClassname((localClassname));
	}
}
