package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AccountHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Account
 * @param argAccount int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Account create(int argAccount) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Account
 * @param argAccount int
 * @param argBank java.lang.Integer
 * @param argOrganization java.lang.Integer
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Account create(int argAccount, java.lang.Integer argBank, java.lang.Integer argOrganization, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Account
 * @param argAccount int
 * @param argBank java.lang.Integer
 * @param argOrganization java.lang.Integer
 * @param argName java.lang.String
 * @param argActive java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Account create(int argAccount, java.lang.Integer argBank, java.lang.Integer argOrganization, java.lang.String argName, java.lang.Boolean argActive) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Account2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAccountByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Account
 * @param key com.hps.july.persistence.AccountKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Account findByPrimaryKey(com.hps.july.persistence.AccountKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: Account
	 */
	public com.hps.july.persistence.Account create(int account, com.hps.july.persistence.Organization argOrganization, com.hps.july.persistence.Bank argBank)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * This method was generated for supporting the relationship role named bank.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Enumeration findAccountinbankByBank(java.lang.Integer inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
