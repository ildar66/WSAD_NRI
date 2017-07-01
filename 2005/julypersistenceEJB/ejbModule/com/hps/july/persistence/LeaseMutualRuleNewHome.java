package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseMutualRuleNewHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.LeaseMutualRuleNew
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseMutualRuleNew create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseMutualRuleNew
 * @param key com.hps.july.persistence.LeaseMutualRuleNewKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseMutualRuleNew findByPrimaryKey(com.hps.july.persistence.LeaseMutualRuleNewKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(Integer argreglament) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseMutualRuleNewsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseMutualRulesByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * ejbCreate method for a CMP entity bean
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public com.hps.july.persistence.LeaseMutualRuleNew create(
		Integer argReglament,
		Integer argResource,
		String argChargeDateRule,
		String argPayDateRule,
		boolean argDopChargeDateRule,
		int argRateType)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
