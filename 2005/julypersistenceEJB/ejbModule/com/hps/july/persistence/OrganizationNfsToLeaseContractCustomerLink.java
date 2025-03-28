package com.hps.july.persistence;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
/**
 * OrganizationNfsToLeaseContractCustomerLink
 * @generated
 */
public class OrganizationNfsToLeaseContractCustomerLink extends com.ibm.ivj.ejb.associations.links.SingleToManyLink {
	/**
	 * @generated
	 */
	private static com.hps.july.persistence.LeaseContractHome targetHome;
	/**
	 * @generated
	 */
	private static final java.lang.String targetHomeName = "com/hps/july/persistence/LeaseContract";
	/**
	 * Create a link instance with the passed source bean.
	 * @generated
	 */
	public OrganizationNfsToLeaseContractCustomerLink(javax.ejb.EntityBean anEntityBean) {
		super(anEntityBean);
	}
	/**
	 * Get the target home for the link.
	 * @generated
	 */
	protected synchronized com.hps.july.persistence.LeaseContractHome getTargetHome(com.ibm.ivj.ejb.associations.links.Link aLink) throws javax.naming.NamingException {
		if (targetHome == null)
			targetHome = (com.hps.july.persistence.LeaseContractHome) lookupTargetHome("java:comp/env/ejb/LeaseContract", com.hps.july.persistence.LeaseContractHome.class);
		return targetHome;
	}
	/**
	 * Fetch the target for this many link, return an enumeration of the members.
	 * @generated
	 */
	protected java.util.Enumeration fetchTargetEnumeration() throws javax.ejb.FinderException, java.rmi.RemoteException {
		Enumeration enum = null;
		try {
			enum =
				((com.hps.july.persistence.LeaseContractHome) getTargetHome(this)).findLeaseContractCustomerByOrgCustomer(
					(com.hps.july.persistence.OrganizationNfsKey) getEntityContext().getPrimaryKey());
		} catch (NamingException e) {
			throw new FinderException(e.toString());
		}
		return enum;
	}
	/**
	 * Get the entity context from the source bean.
	 * @generated
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return ((com.hps.july.persistence.OrganizationNfsBean) source).getEntityContext();
	}
	/**
	 * Return whether or not the source key is valid for querying.
	 * @generated
	 */
	protected boolean isKeyValid() {
		return (getEntityContext().getPrimaryKey() != null);
	}
	/**
	 * Direct my counterLink to set my source as its target.
	 * @generated
	 */
	public void secondarySetCounterLinkOf(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
		if (anEJB != null)
			((com.hps.july.persistence.LeaseContract) anEJB).secondarySetOrgCustomer(
				(com.hps.july.persistence.OrganizationNfs) javax.rmi.PortableRemoteObject.narrow(getEntityContext().getEJBObject(), com.hps.july.persistence.OrganizationNfs.class));
	}
	/**
	 * Send my counterLink #secondaryDisconnect by routing through my target EJB.
	 * @generated
	 */
	public void setNullCounterLinkOf(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
		if (anEJB != null)
			 ((com.hps.july.persistence.LeaseContract) anEJB).setOrgCustomer(null);
	}
	/**
	 * Send my counterLink #secondaryDisconnect by routing through my target EJB.
	 * @generated
	 */
	public void secondarySetNullCounterLinkOf(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
		if (anEJB != null)
			 ((com.hps.july.persistence.LeaseContract) anEJB).secondarySetOrgCustomer(null);
	}
	/**
	 * Add an element to this many link.  Disallow null adds.
	 * @generated
	 */
	public void addElement(javax.ejb.EJBObject targetEJB) throws java.rmi.RemoteException {
		if (targetEJB != null) {
			super.addElement(targetEJB);
			((com.hps.july.persistence.LeaseContract) targetEJB).privateSetOrgCustomerKey((com.hps.july.persistence.OrganizationNfsKey) getEntityContext().getPrimaryKey());
		}
	}
	/**
	 * Narrow the remote object.
	 * @generated
	 */
	protected javax.ejb.EJBObject narrowElement(java.lang.Object element) throws java.rmi.RemoteException {
		return (EJBObject) javax.rmi.PortableRemoteObject.narrow(element, com.hps.july.persistence.LeaseContract.class);
	}
	/**
	 * Check if I contain anEJB by comparing primary keys.
	 * @generated
	 */
	protected boolean currentlyContains(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
		return super.currentlyContains(anEJB) || getEntityContext().getPrimaryKey().equals(((com.hps.july.persistence.LeaseContract) anEJB).getOrgCustomerKey());
	}
}
