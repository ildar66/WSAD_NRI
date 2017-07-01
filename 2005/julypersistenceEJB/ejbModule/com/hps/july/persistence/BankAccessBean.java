package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * BankAccessBean
 * @generated
 * 
 */
public class BankAccessBean extends AbstractEntityAccessBean implements com.hps.july.persistence.BankAccessBeanData {
	/**
	 * @generated
	 */
	private Bank __ejbRef;
	/**
	 * @generated
	 */
	private java.lang.Integer init_primaryKey;
	/**
	 * getSource
	 * @generated
	 */
	public java.lang.Integer getSource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("source")));
	}
	/**
	 * setSource
	 * @generated
	 */
	public void setSource(java.lang.Integer newValue) {
		__setCache("source", newValue);
	}
	/**
	 * getCreatedBy
	 * @generated
	 */
	public java.lang.Integer getCreatedBy()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("createdBy")));
	}
	/**
	 * setCreatedBy
	 * @generated
	 */
	public void setCreatedBy(java.lang.Integer newValue) {
		__setCache("createdBy", newValue);
	}
	/**
	 * getName
	 * @generated
	 */
	public java.lang.String getName()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("name")));
	}
	/**
	 * setName
	 * @generated
	 */
	public void setName(java.lang.String newValue) {
		__setCache("name", newValue);
	}
	/**
	 * getModifiedBy
	 * @generated
	 */
	public java.lang.Integer getModifiedBy()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("modifiedBy")));
	}
	/**
	 * setModifiedBy
	 * @generated
	 */
	public void setModifiedBy(java.lang.Integer newValue) {
		__setCache("modifiedBy", newValue);
	}
	/**
	 * getBik
	 * @generated
	 */
	public java.lang.String getBik()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("bik")));
	}
	/**
	 * setBik
	 * @generated
	 */
	public void setBik(java.lang.String newValue) {
		__setCache("bik", newValue);
	}
	/**
	 * getSwift
	 * @generated
	 */
	public java.lang.String getSwift()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("swift")));
	}
	/**
	 * setSwift
	 * @generated
	 */
	public void setSwift(java.lang.String newValue) {
		__setCache("swift", newValue);
	}
	/**
	 * getCreated
	 * @generated
	 */
	public java.sql.Timestamp getCreated()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Timestamp) __getCache("created")));
	}
	/**
	 * setCreated
	 * @generated
	 */
	public void setCreated(java.sql.Timestamp newValue) {
		__setCache("created", newValue);
	}
	/**
	 * getRecordStatus
	 * @generated
	 */
	public java.lang.String getRecordStatus()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("recordStatus")));
	}
	/**
	 * setRecordStatus
	 * @generated
	 */
	public void setRecordStatus(java.lang.String newValue) {
		__setCache("recordStatus", newValue);
	}
	/**
	 * getModified
	 * @generated
	 */
	public java.sql.Timestamp getModified()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Timestamp) __getCache("modified")));
	}
	/**
	 * setModified
	 * @generated
	 */
	public void setModified(java.sql.Timestamp newValue) {
		__setCache("modified", newValue);
	}
	/**
	 * getKoraccount
	 * @generated
	 */
	public java.lang.String getKoraccount()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("koraccount")));
	}
	/**
	 * setKoraccount
	 * @generated
	 */
	public void setKoraccount(java.lang.String newValue) {
		__setCache("koraccount", newValue);
	}
	/**
	 * getLegaladdress
	 * @generated
	 */
	public java.lang.String getLegaladdress()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("legaladdress")));
	}
	/**
	 * setLegaladdress
	 * @generated
	 */
	public void setLegaladdress(java.lang.String newValue) {
		__setCache("legaladdress", newValue);
	}
	/**
	 * setInit_primaryKey
	 * @generated
	 */
	public void setInit_primaryKey(java.lang.Integer newValue) {
		this.init_primaryKey = (newValue);
	}
	/**
	 * BankAccessBean
	 * @generated
	 */
	public BankAccessBean() {
		super();
	}
	/**
	 * BankAccessBean
	 * @generated
	 */
	public BankAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence/BankHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.BankHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (com.hps.july.persistence.BankHome) PortableRemoteObject.narrow(
			getHome(),
			com.hps.july.persistence.BankHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.Bank ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(com.hps.july.persistence.Bank) PortableRemoteObject.narrow(
					ejbRef,
					com.hps.july.persistence.Bank.class);

		return __ejbRef;
	}
	/**
	 * instantiateEJB
	 * @generated
	 */
	protected void instantiateEJB()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		if (ejbRef() != null)
			return;

		ejbRef = ejbHome().findByPrimaryKey(init_primaryKey);
	}
	/**
	 * instantiateEJBByPrimaryKey
	 * @generated
	 */
	protected boolean instantiateEJBByPrimaryKey()
		throws
			javax.ejb.CreateException,
			java.rmi.RemoteException,
			javax.naming.NamingException {
		boolean result = false;

		if (ejbRef() != null)
			return true;

		try {
			java.lang.Integer pKey = (java.lang.Integer) this.__getKey();
			if (pKey != null) {
				ejbRef = ejbHome().findByPrimaryKey(pKey);
				result = true;
			}
		} catch (javax.ejb.FinderException e) {
		}
		return result;
	}
	/**
	 * refreshCopyHelper
	 * @generated
	 */
	public void refreshCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		refreshCopyHelper(ejbRef());
	}
	/**
	 * commitCopyHelper
	 * @generated
	 */
	public void commitCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		commitCopyHelper(ejbRef());
	}
	/**
	 * BankAccessBean
	 * @generated
	 */
	public BankAccessBean(java.lang.Integer idBank)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(idBank);
	}
	/**
	 * secondaryRemoveAccountinbank
	 * @generated
	 */
	public void secondaryRemoveAccountinbank(
		com.hps.july.persistence.Account anAccountinbank)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveAccountinbank(anAccountinbank);
	}
	/**
	 * addAccountinbank
	 * @generated
	 */
	public void addAccountinbank(
		com.hps.july.persistence.Account anAccountinbank)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addAccountinbank(anAccountinbank);
	}
	/**
	 * getAccountinbank
	 * @generated
	 */
	public java.util.Enumeration getAccountinbank()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getAccountinbank();
	}
	/**
	 * secondaryAddAccountinbank
	 * @generated
	 */
	public void secondaryAddAccountinbank(
		com.hps.july.persistence.Account anAccountinbank)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddAccountinbank(anAccountinbank);
	}
	/**
	 * findBankByBik
	 * @generated
	 */
	public BankAccessBean findBankByBik(java.lang.String argBik)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.BankHome localHome = ejbHome();
		com.hps.july.persistence.Bank ejbs = localHome.findBankByBik(argBik);
		return (BankAccessBean) createAccessBeans(ejbs);
	}
	/**
	 * getIdBank
	 * @generated
	 */
	public java.lang.Integer getIdBank()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("idBank")));
	}
}
