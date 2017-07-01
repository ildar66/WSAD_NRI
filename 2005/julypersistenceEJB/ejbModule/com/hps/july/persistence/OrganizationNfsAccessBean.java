package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * OrganizationNfsAccessBean
 * @generated
 */
public class OrganizationNfsAccessBean extends AbstractEntityAccessBean implements com.hps.july.persistence.OrganizationNfsAccessBeanData {
	/**
	 * @generated
	 */
	private OrganizationNfs __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_organization;
	/**
	 * getLegaladdress
	 * @generated
	 */
	public java.lang.String getLegaladdress() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
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
	 * getKpp
	 * @generated
	 */
	public java.lang.String getKpp() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
		return (((java.lang.String) __getCache("kpp")));
	}
	/**
	 * setKpp
	 * @generated
	 */
	public void setKpp(java.lang.String newValue) {
		__setCache("kpp", newValue);
	}
	/**
	 * getName
	 * @generated
	 */
	public java.lang.String getName() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
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
	 * getInn
	 * @generated
	 */
	public java.lang.String getInn() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
		return (((java.lang.String) __getCache("inn")));
	}
	/**
	 * setInn
	 * @generated
	 */
	public void setInn(java.lang.String newValue) {
		__setCache("inn", newValue);
	}
	/**
	 * setInitKey_organization
	 * @generated
	 */
	public void setInitKey_organization(int newValue) {
		this.initKey_organization = (newValue);
	}
	/**
	 * OrganizationNfsAccessBean
	 * @generated
	 */
	public OrganizationNfsAccessBean() {
		super();
	}
	/**
	 * OrganizationNfsAccessBean
	 * @generated
	 */
	public OrganizationNfsAccessBean(javax.ejb.EJBObject o) throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence/OrganizationNfs";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.OrganizationNfsHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
		return (com.hps.july.persistence.OrganizationNfsHome) PortableRemoteObject.narrow(getHome(), com.hps.july.persistence.OrganizationNfsHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.OrganizationNfs ejbRef() throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef = (com.hps.july.persistence.OrganizationNfs) PortableRemoteObject.narrow(ejbRef, com.hps.july.persistence.OrganizationNfs.class);

		return __ejbRef;
	}
	/**
	 * instantiateEJB
	 * @generated
	 */
	protected void instantiateEJB() throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException {
		if (ejbRef() != null)
			return;

		com.hps.july.persistence.OrganizationNfsKey key = keyFromFields(initKey_organization);
		ejbRef = ejbHome().findByPrimaryKey(key);
	}
	/**
	 * instantiateEJBByPrimaryKey
	 * @generated
	 */
	protected boolean instantiateEJBByPrimaryKey() throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
		boolean result = false;

		if (ejbRef() != null)
			return true;

		try {
			com.hps.july.persistence.OrganizationNfsKey pKey = (com.hps.july.persistence.OrganizationNfsKey) this.__getKey();
			if (pKey != null) {
				ejbRef = ejbHome().findByPrimaryKey(pKey);
				result = true;
			}
		} catch (javax.ejb.FinderException e) {
		}
		return result;
	}
	/**
	 * keyFromFields
	 * @generated
	 */
	private com.hps.july.persistence.OrganizationNfsKey keyFromFields(int f0) {
		com.hps.july.persistence.OrganizationNfsKey keyClass = new com.hps.july.persistence.OrganizationNfsKey();
		keyClass.organization = f0;
		return keyClass;
	}
	/**
	 * refreshCopyHelper
	 * @generated
	 */
	public void refreshCopyHelper() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
		refreshCopyHelper(ejbRef());
	}
	/**
	 * commitCopyHelper
	 * @generated
	 */
	public void commitCopyHelper() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
		commitCopyHelper(ejbRef());
	}
	/**
	 * OrganizationNfsAccessBean
	 * @generated
	 */
	public OrganizationNfsAccessBean(int organization) throws javax.naming.NamingException, javax.ejb.CreateException, java.rmi.RemoteException {
		ejbRef = ejbHome().create(organization);
	}
	/**
	 * addLeaseContractExecutor
	 * @generated
	 */
	public void addLeaseContractExecutor(com.hps.july.persistence.LeaseContract aLeaseContractExecutor) throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeaseContractExecutor(aLeaseContractExecutor);
	}
	/**
	 * getLeaseContractExecutor
	 * @generated
	 */
	public java.util.Enumeration getLeaseContractExecutor() throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseContractExecutor();
	}
	/**
	 * getLeaseContractCustomer
	 * @generated
	 */
	public java.util.Enumeration getLeaseContractCustomer() throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseContractCustomer();
	}
	/**
	 * secondaryAddLeaseContractCustomer
	 * @generated
	 */
	public void secondaryAddLeaseContractCustomer(com.hps.july.persistence.LeaseContract aLeaseContractCustomer)
		throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseContractCustomer(aLeaseContractCustomer);
	}
	/**
	 * addLeaseContractCustomer
	 * @generated
	 */
	public void addLeaseContractCustomer(com.hps.july.persistence.LeaseContract aLeaseContractCustomer) throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeaseContractCustomer(aLeaseContractCustomer);
	}
	/**
	 * secondaryAddLeaseContractExecutor
	 * @generated
	 */
	public void secondaryAddLeaseContractExecutor(com.hps.july.persistence.LeaseContract aLeaseContractExecutor)
		throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseContractExecutor(aLeaseContractExecutor);
	}
	/**
	 * secondaryRemoveLeaseContractCustomer
	 * @generated
	 */
	public void secondaryRemoveLeaseContractCustomer(com.hps.july.persistence.LeaseContract aLeaseContractCustomer)
		throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseContractCustomer(aLeaseContractCustomer);
	}
	/**
	 * secondaryRemoveLeaseContractExecutor
	 * @generated
	 */
	public void secondaryRemoveLeaseContractExecutor(com.hps.july.persistence.LeaseContract aLeaseContractExecutor)
		throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseContractExecutor(aLeaseContractExecutor);
	}
	/**
	 * getOrganization
	 * @generated
	 */
	public int getOrganization() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
		return (((Integer) __getCache("organization")).intValue());
	}
	/**
	 * getDirectorinfo
	 * @generated
	 */
	public java.lang.String getDirectorinfo() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
		return (((java.lang.String) __getCache("directorinfo")));
	}
	/**
	 * setDirectorinfo
	 * @generated
	 */
	public void setDirectorinfo(java.lang.String newValue) {
		__setCache("directorinfo", newValue);
	}
	/**
	 * getShortname
	 * @generated
	 */
	public java.lang.String getShortname() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
		return (((java.lang.String) __getCache("shortname")));
	}
	/**
	 * setShortname
	 * @generated
	 */
	public void setShortname(java.lang.String newValue) {
		__setCache("shortname", newValue);
	}
	/**
	 * getAccauntmanagerinfo
	 * @generated
	 */
	public java.lang.String getAccauntmanagerinfo() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
		return (((java.lang.String) __getCache("accauntmanagerinfo")));
	}
	/**
	 * setAccauntmanagerinfo
	 * @generated
	 */
	public void setAccauntmanagerinfo(java.lang.String newValue) {
		__setCache("accauntmanagerinfo", newValue);
	}
}
