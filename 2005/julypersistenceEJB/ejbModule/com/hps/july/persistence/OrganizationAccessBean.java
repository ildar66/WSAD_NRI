package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * OrganizationAccessBean
 * @generated
 */
public class OrganizationAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence.OrganizationAccessBeanData {
	/**
	 * @generated
	 */
	private Organization __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_organization;
	/**
	 * getContactList
	 * @generated
	 */
	public java.lang.String getContactList()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("contactList")));
	}
	/**
	 * setContactList
	 * @generated
	 */
	public void setContactList(java.lang.String newValue) {
		__setCache("contactList", newValue);
	}
	/**
	 * getIschannalrenter
	 * @generated
	 */
	public java.lang.Boolean getIschannalrenter()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("ischannalrenter")));
	}
	/**
	 * setIschannalrenter
	 * @generated
	 */
	public void setIschannalrenter(java.lang.Boolean newValue) {
		__setCache("ischannalrenter", newValue);
	}
	/**
	 * getIsprovider
	 * @generated
	 */
	public java.lang.Boolean getIsprovider()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("isprovider")));
	}
	/**
	 * setIsprovider
	 * @generated
	 */
	public void setIsprovider(java.lang.Boolean newValue) {
		__setCache("isprovider", newValue);
	}
	/**
	 * getAccauntmanagerinfo
	 * @generated
	 */
	public java.lang.String getAccauntmanagerinfo()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("accauntmanagerinfo")));
	}
	/**
	 * setAccauntmanagerinfo
	 * @generated
	 */
	public void setAccauntmanagerinfo(java.lang.String newValue) {
		__setCache("accauntmanagerinfo", newValue);
	}
	/**
	 * getPhone
	 * @generated
	 */
	public java.lang.String getPhone()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("phone")));
	}
	/**
	 * setPhone
	 * @generated
	 */
	public void setPhone(java.lang.String newValue) {
		__setCache("phone", newValue);
	}
	/**
	 * getIssupplier
	 * @generated
	 */
	public java.lang.Boolean getIssupplier()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("issupplier")));
	}
	/**
	 * setIssupplier
	 * @generated
	 */
	public void setIssupplier(java.lang.Boolean newValue) {
		__setCache("issupplier", newValue);
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
	 * getFax
	 * @generated
	 */
	public java.lang.String getFax()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("fax")));
	}
	/**
	 * setFax
	 * @generated
	 */
	public void setFax(java.lang.String newValue) {
		__setCache("fax", newValue);
	}
	/**
	 * getIsrenter
	 * @generated
	 */
	public java.lang.Boolean getIsrenter()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("isrenter")));
	}
	/**
	 * setIsrenter
	 * @generated
	 */
	public void setIsrenter(java.lang.Boolean newValue) {
		__setCache("isrenter", newValue);
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
	 * getCompanyKey
	 * @generated
	 */
	public com.hps.july.persistence.CompanyKey getCompanyKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com.hps.july.persistence.CompanyKey) __getCache("companyKey")));
	}
	/**
	 * getBossPosition
	 * @generated
	 */
	public java.lang.String getBossPosition()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("bossPosition")));
	}
	/**
	 * setBossPosition
	 * @generated
	 */
	public void setBossPosition(java.lang.String newValue) {
		__setCache("bossPosition", newValue);
	}
	/**
	 * getZip
	 * @generated
	 */
	public java.lang.String getZip()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("zip")));
	}
	/**
	 * setZip
	 * @generated
	 */
	public void setZip(java.lang.String newValue) {
		__setCache("zip", newValue);
	}
	/**
	 * getOkpo
	 * @generated
	 */
	public java.lang.String getOkpo()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("okpo")));
	}
	/**
	 * setOkpo
	 * @generated
	 */
	public void setOkpo(java.lang.String newValue) {
		__setCache("okpo", newValue);
	}
	/**
	 * getDirectorinfo
	 * @generated
	 */
	public java.lang.String getDirectorinfo()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
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
	 * getOrganization
	 * @generated
	 */
	public int getOrganization()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("organization")).intValue());
	}
	/**
	 * setOrganization
	 * @generated
	 */
	public void setOrganization(int newValue) {
		__setCache("organization", new Integer(newValue));
	}
	/**
	 * getOrganizationType
	 * @generated
	 */
	public java.lang.String getOrganizationType()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("organizationType")));
	}
	/**
	 * setOrganizationType
	 * @generated
	 */
	public void setOrganizationType(java.lang.String newValue) {
		__setCache("organizationType", newValue);
	}
	/**
	 * getOkonh
	 * @generated
	 */
	public java.lang.String getOkonh()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("okonh")));
	}
	/**
	 * setOkonh
	 * @generated
	 */
	public void setOkonh(java.lang.String newValue) {
		__setCache("okonh", newValue);
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
	 * getInn
	 * @generated
	 */
	public java.lang.String getInn()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
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
	 * getShortname
	 * @generated
	 */
	public java.lang.String getShortname()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
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
	 * getKpp
	 * @generated
	 */
	public java.lang.String getKpp()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
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
	 * getPhisicaladdress
	 * @generated
	 */
	public java.lang.String getPhisicaladdress()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("phisicaladdress")));
	}
	/**
	 * setPhisicaladdress
	 * @generated
	 */
	public void setPhisicaladdress(java.lang.String newValue) {
		__setCache("phisicaladdress", newValue);
	}
	/**
	 * getBank
	 * @generated
	 */
	public java.lang.Boolean getBank()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("bank")));
	}
	/**
	 * setBank
	 * @generated
	 */
	public void setBank(java.lang.Boolean newValue) {
		__setCache("bank", newValue);
	}
	/**
	 * setInitKey_organization
	 * @generated
	 */
	public void setInitKey_organization(int newValue) {
		this.initKey_organization = (newValue);
	}
	/**
	 * OrganizationAccessBean
	 * @generated
	 */
	public OrganizationAccessBean() {
		super();
	}
	/**
	 * OrganizationAccessBean
	 * @generated
	 */
	public OrganizationAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "com/hps/july/persistence/Organization";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.OrganizationHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence
				.OrganizationHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence.OrganizationHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.Organization ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.persistence
						.Organization) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence.Organization.class);

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

		com.hps.july.persistence.OrganizationKey key =
			keyFromFields(initKey_organization);
		ejbRef = ejbHome().findByPrimaryKey(key);
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
			com.hps.july.persistence.OrganizationKey pKey =
				(com.hps.july.persistence.OrganizationKey) this.__getKey();
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
	private com.hps.july.persistence.OrganizationKey keyFromFields(int f0) {
		com.hps.july.persistence.OrganizationKey keyClass =
			new com.hps.july.persistence.OrganizationKey();
		keyClass.organization = f0;
		return keyClass;
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
	 * findOrganizationsButBanksByCompanyAndGroup
	 * @generated
	 */
	public java.util.Enumeration findOrganizationsButBanksByCompanyAndGroup(
		java.lang.Integer argCompany,
		java.lang.Boolean isGroup,
		java.lang.Integer searchgroup,
		java.lang.Integer searchGroupping)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findOrganizationsButBanksByCompanyAndGroup(
				argCompany,
				isGroup,
				searchgroup,
				searchGroupping);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findOrganizationsByQBE2
	 * @generated
	 */
	public java.util.Enumeration findOrganizationsByQBE2(
		java.lang.Boolean isHaveBans,
		java.lang.Boolean isRenter,
		java.lang.Boolean isName,
		java.lang.String argName,
		java.lang.Boolean isInn,
		java.lang.String argInn,
		java.lang.Boolean isBan,
		java.lang.Integer ban,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findOrganizationsByQBE2(
				isHaveBans,
				isRenter,
				isName,
				argName,
				isInn,
				argInn,
				isBan,
				ban,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findOrganizationByCompany
	 * @generated
	 */
	public java.util.Enumeration findOrganizationByCompany(
		com.hps.july.persistence.CompanyKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs = localHome.findOrganizationByCompany(inKey);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findOrganizationsByNameOrderByNameAsc
	 * @generated
	 */
	public java.util.Enumeration findOrganizationsByNameOrderByNameAsc(
		java.lang.String name,
		java.lang.Boolean argIsSupplier,
		java.lang.Boolean argIsProvider,
		java.lang.Boolean argIsRenter)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findOrganizationsByNameOrderByNameAsc(
				name,
				argIsSupplier,
				argIsProvider,
				argIsRenter);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * OrganizationAccessBean
	 * @generated
	 */
	public OrganizationAccessBean(
		int organization,
		com.hps.july.persistence.Company argCompany)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(organization, argCompany);
	}
	/**
	 * OrganizationAccessBean
	 * @generated
	 */
	public OrganizationAccessBean(
		int argOrganization,
		java.lang.String argName,
		java.lang.Boolean argIsSupplier,
		java.lang.Boolean argIsProvider,
		java.lang.Boolean argIsRenter,
		java.lang.Boolean argBank)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argOrganization,
				argName,
				argIsSupplier,
				argIsProvider,
				argIsRenter,
				argBank);
	}
	/**
	 * findOrganizationsButBanksByCompany
	 * @generated
	 */
	public java.util.Enumeration findOrganizationsButBanksByCompany(
		java.lang.Integer argCompany)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findOrganizationsButBanksByCompany(argCompany);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByInnOrderByInnAsc
	 * @generated
	 */
	public java.util.Enumeration findByInnOrderByInnAsc(java.lang.String name)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs = localHome.findByInnOrderByInnAsc(name);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByNameOrderByNameAsc
	 * @generated
	 */
	public java.util.Enumeration findByNameOrderByNameAsc(
		java.lang.String name)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs = localHome.findByNameOrderByNameAsc(name);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findBanksByNameOrderByNameAsc
	 * @generated
	 */
	public java.util.Enumeration findBanksByNameOrderByNameAsc(
		java.lang.String name)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findBanksByNameOrderByNameAsc(name);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findOurOrganizations
	 * @generated
	 */
	public java.util.Enumeration findOurOrganizations()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs = localHome.findOurOrganizations();
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * OrganizationAccessBean
	 * @generated
	 */
	public OrganizationAccessBean(
		int argOrganization,
		java.lang.String argName,
		java.lang.Boolean argIsSupplier,
		java.lang.Boolean argIsProvider,
		java.lang.Boolean argIsRenter,
		java.lang.Boolean argIsChannalRenter,
		java.lang.Boolean argBank)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argOrganization,
				argName,
				argIsSupplier,
				argIsProvider,
				argIsRenter,
				argIsChannalRenter,
				argBank);
	}
	/**
	 * findOrganizationsByQBE
	 * @generated
	 */
	public java.util.Enumeration findOrganizationsByQBE(
		java.lang.Boolean isName,
		java.lang.String argName,
		java.lang.Boolean isSupplier,
		java.lang.Boolean isProvider,
		java.lang.Boolean isRenter,
		java.lang.Boolean isInn,
		java.lang.String argInn,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findOrganizationsByQBE(
				isName,
				argName,
				isSupplier,
				isProvider,
				isRenter,
				isInn,
				argInn,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findOrganizationsByQBEAndGroup
	 * @generated
	 */
	public java.util.Enumeration findOrganizationsByQBEAndGroup(
		java.lang.Boolean isName,
		java.lang.String argName,
		java.lang.Boolean isSupplier,
		java.lang.Boolean isProvider,
		java.lang.Boolean isRenter,
		java.lang.Boolean isInn,
		java.lang.String argInn,
		java.lang.Integer order,
		java.lang.Boolean isGroup,
		java.lang.Integer group,
		java.lang.Integer groupping)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findOrganizationsByQBEAndGroup(
				isName,
				argName,
				isSupplier,
				isProvider,
				isRenter,
				isInn,
				argInn,
				order,
				isGroup,
				group,
				groupping);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * OrganizationAccessBean
	 * @generated
	 */
	public OrganizationAccessBean(int argOrganization)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(argOrganization);
	}
	/**
	 * findBanksByQBE
	 * @generated
	 */
	public java.util.Enumeration findBanksByQBE(
		java.lang.Boolean isName,
		java.lang.String argName,
		java.lang.Boolean isBic,
		java.lang.String argBic,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findBanksByQBE(isName, argName, isBic, argBic, order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findOrganizationsByReglament
	 * @generated
	 */
	public java.util.Enumeration findOrganizationsByReglament(
		java.lang.Integer argCustReglament,
		java.lang.Integer argExecReglament)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.OrganizationHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findOrganizationsByReglament(
				argCustReglament,
				argExecReglament);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * secondaryRemoveVcprojects
	 * @generated
	 */
	public void secondaryRemoveVcprojects(
		com.hps.july.persistence.Project aVcprojects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveVcprojects(aVcprojects);
	}
	/**
	 * secondaryAddVcprojects
	 * @generated
	 */
	public void secondaryAddVcprojects(
		com.hps.july.persistence.Project aVcprojects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddVcprojects(aVcprojects);
	}
	/**
	 * secondaryRemovePositionResponsibleWorker
	 * @generated
	 */
	public void secondaryRemovePositionResponsibleWorker(
		com
			.hps
			.july
			.persistence
			.PositionResponsibleWorkers aPositionResponsibleWorker)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemovePositionResponsibleWorker(
			aPositionResponsibleWorker);
	}
	/**
	 * secondaryRemoveExpedition
	 * @generated
	 */
	public void secondaryRemoveExpedition(
		com.hps.july.persistence.Expedition anExpedition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveExpedition(anExpedition);
	}
	/**
	 * getProjects
	 * @generated
	 */
	public java.util.Enumeration getProjects()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getProjects();
	}
	/**
	 * addProjects
	 * @generated
	 */
	public void addProjects(com.hps.july.persistence.Project aProjects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addProjects(aProjects);
	}
	/**
	 * getDocumentPosition
	 * @generated
	 */
	public java.util.Enumeration getDocumentPosition()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getDocumentPosition();
	}
	/**
	 * secondarySetCompany
	 * @generated
	 */
	public void secondarySetCompany(com.hps.july.persistence.Company aCompany)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetCompany(aCompany);
	}
	/**
	 * secondaryAddAccount
	 * @generated
	 */
	public void secondaryAddAccount(com.hps.july.persistence.Account anAccount)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddAccount(anAccount);
	}
	/**
	 * getExpedition
	 * @generated
	 */
	public java.util.Enumeration getExpedition()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getExpedition();
	}
	/**
	 * secondaryAddPIEMxranPlatinums
	 * @generated
	 */
	public void secondaryAddPIEMxranPlatinums(
		com.hps.july.persistence.PIEMxranPlatinum aPIEMxranPlatinums)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddPIEMxranPlatinums(aPIEMxranPlatinums);
	}
	/**
	 * secondaryRemoveSearches
	 * @generated
	 */
	public void secondaryRemoveSearches(
		com.hps.july.persistence.Searches aSearches)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveSearches(aSearches);
	}
	/**
	 * secondaryAddProjects
	 * @generated
	 */
	public void secondaryAddProjects(
		com.hps.july.persistence.Project aProjects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddProjects(aProjects);
	}
	/**
	 * getCompany
	 * @generated
	 */
	public com.hps.july.persistence.CompanyAccessBean getCompany()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Company localEJBRef = ejbRef().getCompany();
		if (localEJBRef != null)
			return new com.hps.july.persistence.CompanyAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * addLeasePayRule4orgtopay
	 * @generated
	 */
	public void addLeasePayRule4orgtopay(
		com.hps.july.persistence.LeasePayRule aLeasePayRule4orgtopay)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeasePayRule4orgtopay(aLeasePayRule4orgtopay);
	}
	/**
	 * secondaryAddCars
	 * @generated
	 */
	public void secondaryAddCars(com.hps.july.persistence.Car aCars)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddCars(aCars);
	}
	/**
	 * addOwnedDocument
	 * @generated
	 */
	public void addOwnedDocument(
		com.hps.july.persistence.Document anOwnedDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addOwnedDocument(anOwnedDocument);
	}
	/**
	 * setCompany
	 * @generated
	 */
	public void setCompany(com.hps.july.persistence.Company aCompany)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setCompany(aCompany);
	}
	/**
	 * secondaryRemoveDocumentPosition
	 * @generated
	 */
	public void secondaryRemoveDocumentPosition(
		com.hps.july.persistence.DocumentPosition aDocumentPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveDocumentPosition(aDocumentPosition);
	}
	/**
	 * addDocumentPosition
	 * @generated
	 */
	public void addDocumentPosition(
		com.hps.july.persistence.DocumentPosition aDocumentPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addDocumentPosition(aDocumentPosition);
	}
	/**
	 * getPositionResponsibleWorker
	 * @generated
	 */
	public java.util.Enumeration getPositionResponsibleWorker()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getPositionResponsibleWorker();
	}
	/**
	 * addContragentDocument
	 * @generated
	 */
	public void addContragentDocument(
		com.hps.july.persistence.Document aContragentDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addContragentDocument(aContragentDocument);
	}
	/**
	 * addAccount
	 * @generated
	 */
	public void addAccount(com.hps.july.persistence.Account anAccount)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addAccount(anAccount);
	}
	/**
	 * secondaryAddContagentDocument
	 * @generated
	 */
	public void secondaryAddContagentDocument(
		com.hps.july.persistence.Document aContagentDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddContagentDocument(aContagentDocument);
	}
	/**
	 * secondaryRemovePIEMxranPlatinums
	 * @generated
	 */
	public void secondaryRemovePIEMxranPlatinums(
		com.hps.july.persistence.PIEMxranPlatinum aPIEMxranPlatinums)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemovePIEMxranPlatinums(aPIEMxranPlatinums);
	}
	/**
	 * addPositionResponsibleWorker
	 * @generated
	 */
	public void addPositionResponsibleWorker(
		com
			.hps
			.july
			.persistence
			.PositionResponsibleWorkers aPositionResponsibleWorker)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addPositionResponsibleWorker(aPositionResponsibleWorker);
	}
	/**
	 * addRenteePosition
	 * @generated
	 */
	public void addRenteePosition(
		com.hps.july.persistence.Position aRenteePosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addRenteePosition(aRenteePosition);
	}
	/**
	 * secondaryAddOwnedDocument
	 * @generated
	 */
	public void secondaryAddOwnedDocument(
		com.hps.july.persistence.Document anOwnedDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddOwnedDocument(anOwnedDocument);
	}
	/**
	 * secondaryAddExpedition
	 * @generated
	 */
	public void secondaryAddExpedition(
		com.hps.july.persistence.Expedition anExpedition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddExpedition(anExpedition);
	}
	/**
	 * getContagentDocument
	 * @generated
	 */
	public java.util.Enumeration getContagentDocument()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getContagentDocument();
	}
	/**
	 * addWorkers
	 * @generated
	 */
	public void addWorkers(com.hps.july.persistence.Worker aWorkers)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addWorkers(aWorkers);
	}
	/**
	 * getWorkers
	 * @generated
	 */
	public java.util.Enumeration getWorkers()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getWorkers();
	}
	/**
	 * addExpedition
	 * @generated
	 */
	public void addExpedition(com.hps.july.persistence.Expedition anExpedition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addExpedition(anExpedition);
	}
	/**
	 * getRenteePosition
	 * @generated
	 */
	public java.util.Enumeration getRenteePosition()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getRenteePosition();
	}
	/**
	 * getCars
	 * @generated
	 */
	public java.util.Enumeration getCars()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getCars();
	}
	/**
	 * addCars
	 * @generated
	 */
	public void addCars(com.hps.july.persistence.Car aCars)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addCars(aCars);
	}
	/**
	 * removeWorkers
	 * @generated
	 */
	public void removeWorkers(com.hps.july.persistence.Worker aWorkers)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeWorkers(aWorkers);
	}
	/**
	 * privateSetCompanyKey
	 * @generated
	 */
	public void privateSetCompanyKey(com.hps.july.persistence.CompanyKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetCompanyKey(inKey);
	}
	/**
	 * secondaryRemoveRenteePosition
	 * @generated
	 */
	public void secondaryRemoveRenteePosition(
		com.hps.july.persistence.Position aRenteePosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveRenteePosition(aRenteePosition);
	}
	/**
	 * addStorageCard
	 * @generated
	 */
	public void addStorageCard(
		com.hps.july.persistence.StorageCard aStorageCard)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addStorageCard(aStorageCard);
	}
	/**
	 * secondaryRemoveProjects
	 * @generated
	 */
	public void secondaryRemoveProjects(
		com.hps.july.persistence.Project aProjects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveProjects(aProjects);
	}
	/**
	 * secondaryAddRenteePosition
	 * @generated
	 */
	public void secondaryAddRenteePosition(
		com.hps.july.persistence.Position aRenteePosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddRenteePosition(aRenteePosition);
	}
	/**
	 * getAccount
	 * @generated
	 */
	public java.util.Enumeration getAccount()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getAccount();
	}
	/**
	 * secondaryAddContragentDocument
	 * @generated
	 */
	public void secondaryAddContragentDocument(
		com.hps.july.persistence.Document aContragentDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddContragentDocument(aContragentDocument);
	}
	/**
	 * getLeasePayRule4orgtopay
	 * @generated
	 */
	public java.util.Enumeration getLeasePayRule4orgtopay()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeasePayRule4orgtopay();
	}
	/**
	 * secondaryRemoveContagentDocument
	 * @generated
	 */
	public void secondaryRemoveContagentDocument(
		com.hps.july.persistence.Document aContagentDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveContagentDocument(aContagentDocument);
	}
	/**
	 * removeProjects
	 * @generated
	 */
	public void removeProjects(com.hps.july.persistence.Project aProjects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeProjects(aProjects);
	}
	/**
	 * getVcprojects
	 * @generated
	 */
	public java.util.Enumeration getVcprojects()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getVcprojects();
	}
	/**
	 * secondaryAddPositionResponsibleWorker
	 * @generated
	 */
	public void secondaryAddPositionResponsibleWorker(
		com
			.hps
			.july
			.persistence
			.PositionResponsibleWorkers aPositionResponsibleWorker)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddPositionResponsibleWorker(
			aPositionResponsibleWorker);
	}
	/**
	 * secondaryAddWorkers
	 * @generated
	 */
	public void secondaryAddWorkers(com.hps.july.persistence.Worker aWorkers)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddWorkers(aWorkers);
	}
	/**
	 * addVcprojects
	 * @generated
	 */
	public void addVcprojects(com.hps.july.persistence.Project aVcprojects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addVcprojects(aVcprojects);
	}
	/**
	 * secondaryAddLeasePayRule4orgtopay
	 * @generated
	 */
	public void secondaryAddLeasePayRule4orgtopay(
		com.hps.july.persistence.LeasePayRule aLeasePayRule4orgtopay)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeasePayRule4orgtopay(aLeasePayRule4orgtopay);
	}
	/**
	 * removeCars
	 * @generated
	 */
	public void removeCars(com.hps.july.persistence.Car aCars)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeCars(aCars);
	}
	/**
	 * secondaryRemoveStorageCard
	 * @generated
	 */
	public void secondaryRemoveStorageCard(
		com.hps.july.persistence.StorageCard aStorageCard)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveStorageCard(aStorageCard);
	}
	/**
	 * secondaryRemoveAccount
	 * @generated
	 */
	public void secondaryRemoveAccount(
		com.hps.july.persistence.Account anAccount)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveAccount(anAccount);
	}
	/**
	 * secondaryAddStorageCard
	 * @generated
	 */
	public void secondaryAddStorageCard(
		com.hps.july.persistence.StorageCard aStorageCard)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddStorageCard(aStorageCard);
	}
	/**
	 * getContragentDocument
	 * @generated
	 */
	public java.util.Enumeration getContragentDocument()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getContragentDocument();
	}
	/**
	 * secondaryRemoveWorkers
	 * @generated
	 */
	public void secondaryRemoveWorkers(
		com.hps.july.persistence.Worker aWorkers)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveWorkers(aWorkers);
	}
	/**
	 * secondaryRemoveOwnedDocument
	 * @generated
	 */
	public void secondaryRemoveOwnedDocument(
		com.hps.july.persistence.Document anOwnedDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveOwnedDocument(anOwnedDocument);
	}
	/**
	 * getStorageCard
	 * @generated
	 */
	public java.util.Enumeration getStorageCard()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getStorageCard();
	}
	/**
	 * getPIEMxranPlatinums
	 * @generated
	 */
	public java.util.Enumeration getPIEMxranPlatinums()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getPIEMxranPlatinums();
	}
	/**
	 * getSearches
	 * @generated
	 */
	public java.util.Enumeration getSearches()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getSearches();
	}
	/**
	 * addContagentDocument
	 * @generated
	 */
	public void addContagentDocument(
		com.hps.july.persistence.Document aContagentDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addContagentDocument(aContagentDocument);
	}
	/**
	 * getOwnedDocument
	 * @generated
	 */
	public java.util.Enumeration getOwnedDocument()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getOwnedDocument();
	}
	/**
	 * secondaryRemoveLeasePayRule4orgtopay
	 * @generated
	 */
	public void secondaryRemoveLeasePayRule4orgtopay(
		com.hps.july.persistence.LeasePayRule aLeasePayRule4orgtopay)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeasePayRule4orgtopay(aLeasePayRule4orgtopay);
	}
	/**
	 * secondaryRemoveCars
	 * @generated
	 */
	public void secondaryRemoveCars(com.hps.july.persistence.Car aCars)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveCars(aCars);
	}
	/**
	 * secondaryRemoveContragentDocument
	 * @generated
	 */
	public void secondaryRemoveContragentDocument(
		com.hps.july.persistence.Document aContragentDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveContragentDocument(aContragentDocument);
	}
	/**
	 * secondaryAddSearches
	 * @generated
	 */
	public void secondaryAddSearches(
		com.hps.july.persistence.Searches aSearches)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddSearches(aSearches);
	}
	/**
	 * removePositionResponsibleWorker
	 * @generated
	 */
	public void removePositionResponsibleWorker(
		com
			.hps
			.july
			.persistence
			.PositionResponsibleWorkers aPositionResponsibleWorker)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removePositionResponsibleWorker(aPositionResponsibleWorker);
	}
	/**
	 * removeVcprojects
	 * @generated
	 */
	public void removeVcprojects(com.hps.july.persistence.Project aVcprojects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeVcprojects(aVcprojects);
	}
	/**
	 * secondaryAddDocumentPosition
	 * @generated
	 */
	public void secondaryAddDocumentPosition(
		com.hps.july.persistence.DocumentPosition aDocumentPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddDocumentPosition(aDocumentPosition);
	}
}
