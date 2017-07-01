package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface OrganizationHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Organization
 * @param argOrganization int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Organization create(int argOrganization) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Organization
 * @param argOrganization int
 * @param argName java.lang.String
 * @param argIsSupplier java.lang.Boolean
 * @param argIsProvider java.lang.Boolean
 * @param argIsRenter java.lang.Boolean
 * @param argBank java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Organization create(int argOrganization, java.lang.String argName, java.lang.Boolean argIsSupplier, java.lang.Boolean argIsProvider, java.lang.Boolean argIsRenter, java.lang.Boolean argBank) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findBanksByNameOrderByNameAsc( String name ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findBanksByQBE( Boolean isName, String argName, Boolean isBic, String argBic, Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByInnOrderByInnAsc( String name ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByNameOrderByNameAsc( String name ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Organization
 * @param key com.hps.july.persistence.OrganizationKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Organization findByPrimaryKey(com.hps.july.persistence.OrganizationKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findOrganizationByCompany(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findOrganizationsButBanksByCompany(Integer argCompany) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named organizations2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findOrganizationsButBanksByCompanyAndGroup(Integer argCompany, Boolean isGroup, 
	Integer searchgroup, Integer searchGroupping ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findOrganizationsByNameOrderByNameAsc( String name, 
	Boolean argIsSupplier, Boolean argIsProvider, Boolean argIsRenter ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findOrganizationsByQBE( Boolean isName, String argName, Boolean isSupplier,
	Boolean isProvider, Boolean isRenter, Boolean isInn, String argInn, Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findOrganizationsByQBE2( Boolean isHaveBans, 
	Boolean isRenter, 
	Boolean isName, String argName, 
	Boolean isInn, String argInn, Boolean isBan, Integer ban, Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findOrganizationsByQBEAndGroup( Boolean isName, String argName, Boolean isSupplier,
	Boolean isProvider, Boolean isRenter, Boolean isInn, String argInn, Integer order, 
	Boolean isGroup, Integer group, Integer groupping ) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findOrganizationsByReglament(Integer argCustReglament, Integer argExecReglament) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findOurOrganizations() throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: Organization
	 */
	public com.hps.july.persistence.Organization create(int organization, com.hps.july.persistence.Company argCompany) throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean
	 * @param argOrganization int
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public com.hps.july.persistence.Organization create(
		int argOrganization,
		String argName,
		Boolean argIsSupplier,
		Boolean argIsProvider,
		Boolean argIsRenter,
		Boolean argIsChannalRenter,
		Boolean argBank)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
