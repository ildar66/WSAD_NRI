package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * OrganizationFactory
 * @generated
 */
public class OrganizationFactory extends AbstractEJBFactory {
	/**
	 * OrganizationFactory
	 * @generated
	 */
	public OrganizationFactory() {
		super();
	}
	/**
	 * _acquireOrganizationHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.OrganizationHome _acquireOrganizationHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.OrganizationHome) _acquireEJBHome();
	}
	/**
	 * acquireOrganizationHome
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationHome acquireOrganizationHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.OrganizationHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/Organization";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.OrganizationHome.class;
	}
	/**
	 * resetOrganizationHome
	 * @generated
	 */
	public void resetOrganizationHome() {
		resetEJBHome();
	}
	/**
	 * setOrganizationHome
	 * @generated
	 */
	public void setOrganizationHome(
		com.hps.july.persistence.OrganizationHome home) {
		setEJBHome(home);
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
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome()
			.findOrganizationsButBanksByCompanyAndGroup(
			argCompany,
			isGroup,
			searchgroup,
			searchGroupping);
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
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findOrganizationsByQBE2(
			isHaveBans,
			isRenter,
			isName,
			argName,
			isInn,
			argInn,
			isBan,
			ban,
			order);
	}
	/**
	 * findOrganizationByCompany
	 * @generated
	 */
	public java.util.Enumeration findOrganizationByCompany(
		com.hps.july.persistence.CompanyKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findOrganizationByCompany(inKey);
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
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome()
			.findOrganizationsByNameOrderByNameAsc(
			name,
			argIsSupplier,
			argIsProvider,
			argIsRenter);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Organization create(
		int organization,
		com.hps.july.persistence.Company argCompany)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOrganizationHome().create(organization, argCompany);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Organization create(
		int argOrganization,
		java.lang.String argName,
		java.lang.Boolean argIsSupplier,
		java.lang.Boolean argIsProvider,
		java.lang.Boolean argIsRenter,
		java.lang.Boolean argBank)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOrganizationHome().create(
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
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findOrganizationsButBanksByCompany(
			argCompany);
	}
	/**
	 * findByInnOrderByInnAsc
	 * @generated
	 */
	public java.util.Enumeration findByInnOrderByInnAsc(java.lang.String name)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findByInnOrderByInnAsc(name);
	}
	/**
	 * findByNameOrderByNameAsc
	 * @generated
	 */
	public java.util.Enumeration findByNameOrderByNameAsc(
		java.lang.String name)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findByNameOrderByNameAsc(name);
	}
	/**
	 * findBanksByNameOrderByNameAsc
	 * @generated
	 */
	public java.util.Enumeration findBanksByNameOrderByNameAsc(
		java.lang.String name)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findBanksByNameOrderByNameAsc(name);
	}
	/**
	 * findOurOrganizations
	 * @generated
	 */
	public java.util.Enumeration findOurOrganizations()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findOurOrganizations();
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Organization findByPrimaryKey(
		com.hps.july.persistence.OrganizationKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Organization create(
		int argOrganization,
		java.lang.String argName,
		java.lang.Boolean argIsSupplier,
		java.lang.Boolean argIsProvider,
		java.lang.Boolean argIsRenter,
		java.lang.Boolean argIsChannalRenter,
		java.lang.Boolean argBank)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOrganizationHome().create(
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
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findOrganizationsByQBE(
			isName,
			argName,
			isSupplier,
			isProvider,
			isRenter,
			isInn,
			argInn,
			order);
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
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findOrganizationsByQBEAndGroup(
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
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Organization create(int argOrganization)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOrganizationHome().create(argOrganization);
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
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findBanksByQBE(
			isName,
			argName,
			isBic,
			argBic,
			order);
	}
	/**
	 * findOrganizationsByReglament
	 * @generated
	 */
	public java.util.Enumeration findOrganizationsByReglament(
		java.lang.Integer argCustReglament,
		java.lang.Integer argExecReglament)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOrganizationHome().findOrganizationsByReglament(
			argCustReglament,
			argExecReglament);
	}
}
