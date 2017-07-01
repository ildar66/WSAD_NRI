package com.hps.july.persistence;

/**
 * EJSFinderOrganizationBean
 */
public interface EJSFinderOrganizationBean {
	/**
	 * findOrganizationsButBanksByCompanyAndGroup
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrganizationsButBanksByCompanyAndGroup(java.lang.Integer argCompany, java.lang.Boolean isGroup, java.lang.Integer searchgroup, java.lang.Integer searchGroupping) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrganizationsByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrganizationsByQBE2(java.lang.Boolean isHaveBans, java.lang.Boolean isRenter, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Boolean isBan, java.lang.Integer ban, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrganizationByCompany
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrganizationByCompany(com.hps.july.persistence.CompanyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrganizationsByNameOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrganizationsByNameOrderByNameAsc(java.lang.String name, java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrganizationsButBanksByCompany
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrganizationsButBanksByCompany(java.lang.Integer argCompany) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByInnOrderByInnAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByInnOrderByInnAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByNameOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByNameOrderByNameAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBanksByNameOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBanksByNameOrderByNameAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOurOrganizations
	 */
	public com.ibm.ejs.persistence.EJSFinder findOurOrganizations() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrganizationsByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrganizationsByQBE(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrganizationsByQBEAndGroup
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrganizationsByQBEAndGroup(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSupplier, java.lang.Boolean isProvider, java.lang.Boolean isRenter, java.lang.Boolean isInn, java.lang.String argInn, java.lang.Integer order, java.lang.Boolean isGroup, java.lang.Integer group, java.lang.Integer groupping) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBanksByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findBanksByQBE(java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isBic, java.lang.String argBic, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrganizationsByReglament
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrganizationsByReglament(java.lang.Integer argCustReglament, java.lang.Integer argExecReglament) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
