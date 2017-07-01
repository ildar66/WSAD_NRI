package com.hps.july.persistence;
import javax.ejb.*;
import javax.naming.*;
/**
 * AccountToBankLink
 * @generated
 */
public class AccountToBankLink extends com.ibm.ivj.ejb.associations.links.ManyToSingleLink {
	/**
	 * @generated
	 */
	private static com.hps.july.persistence.BankHome targetHome;
	/**
	 * @generated
	 */
	private static final java.lang.String targetHomeName = "ejb/com/hps/july/persistence/BankHome";
	/**
	 * Create a link instance with the passed source bean.
	 * @generated
	 */
	public AccountToBankLink(javax.ejb.EntityBean anEntityBean) {
		super(anEntityBean);
	}
	/**
	 * Get the target home for the link.
	 * @generated
	 */
	protected synchronized com.hps.july.persistence.BankHome getTargetHome(com.ibm.ivj.ejb.associations.links.Link aLink) throws javax.naming.NamingException {
		if (targetHome == null)
			targetHome = (com.hps.july.persistence.BankHome) lookupTargetHome("java:comp/env/ejb/Bank", com.hps.july.persistence.BankHome.class);
		return targetHome;
	}
	/**
	 * Fetch the target for this single link, return an instance of the target class.
	 * @generated
	 */
	protected javax.ejb.EJBObject fetchTarget() throws javax.ejb.FinderException, java.rmi.RemoteException {
		EJBObject target = null;
		java.lang.Integer key = ((com.hps.july.persistence.AccountBean) source).getBankKey();
		try {
			target = ((com.hps.july.persistence.BankHome) getTargetHome(this)).findByPrimaryKey(key);
		} catch (NamingException e) {
			throw new FinderException(e.toString());
		}
		return target;
	}
	/**
	 * Get the entity context from the source bean.
	 * @generated
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return ((com.hps.july.persistence.AccountBean) source).getEntityContext();
	}
	/**
	 * Return whether or not the source key is valid for querying.
	 * @generated
	 */
	protected boolean isKeyValid() {
		return (((com.hps.july.persistence.AccountBean) source).getBankKey() != null);
	}
	/**
	 * Forward inverse maintenance through my target EJB.
	 * @generated
	 */
	public void secondaryRemoveElementCounterLinkOf(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
		if (anEJB != null)
			((com.hps.july.persistence.Bank) anEJB).secondaryRemoveAccountinbank(
				(com.hps.july.persistence.Account) javax.rmi.PortableRemoteObject.narrow(getEntityContext().getEJBObject(), com.hps.july.persistence.Account.class));
	}
	/**
	 * Forward inverse maintenance through my target EJB.
	 * @generated
	 */
	public void secondaryAddElementCounterLinkOf(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
		if (anEJB != null)
			((com.hps.july.persistence.Bank) anEJB).secondaryAddAccountinbank(
				(com.hps.july.persistence.Account) javax.rmi.PortableRemoteObject.narrow(getEntityContext().getEJBObject(), com.hps.july.persistence.Account.class));
	}
	/**
	 * Set the target for this single link, an instance of the target class.
	 * @generated
	 */
	public void set(javax.ejb.EJBObject targetEJB) throws java.rmi.RemoteException {
		super.set(targetEJB);
		if (targetEJB == null)
			 ((com.hps.july.persistence.AccountBean) source).privateSetBankKey(null);
		else
			 ((com.hps.july.persistence.AccountBean) source).privateSetBankKey((java.lang.Integer) targetEJB.getPrimaryKey());
	}
	/**
	 * Reset my target key.
	 * @generated
	 */
	protected void resetKey() throws java.rmi.RemoteException {
		((com.hps.july.persistence.AccountBean) source).privateSetBankKey(null);
	}
}
