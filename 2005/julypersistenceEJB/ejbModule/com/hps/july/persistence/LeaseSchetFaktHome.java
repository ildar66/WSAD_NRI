package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseSchetFaktHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseSchetFakt
 * @param argIdSchetFakt int
 * @param idContract int
 * @param idCurrency int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseSchetFakt create(Integer argIdSchetFakt, Integer idContract, Integer idCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdActOrderByDateSchetFaktAsc(Integer idAct) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdActOrderByDateSchetFaktDesc(Integer idAct) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdActOrderByNumberSchetFaktAsc(Integer idAct) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdActOrderByNumberSchetFaktDesc(Integer idAct) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdContractOrderByDateSchetFaktAsc(Integer idContract) throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdContractOrderByDateSchetFaktDesc(Integer idContract) throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdContractOrderByNumberSchetFaktAsc(Integer idContract) throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByIdContractOrderByNumberSchetFaktDesc(Integer idContract) throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseSchetFakt
 * @param key com.hps.july.persistence.LeaseSchetFaktKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseSchetFakt findByPrimaryKey(com.hps.july.persistence.LeaseSchetFaktKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseSchetFaktsByIdAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseSchetFaktsByIdContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseSchetFaktsByIdCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(Integer idAct, Boolean isContractType, String typeContract, Integer order) 
	throws java.rmi.RemoteException, javax.ejb.FinderException;
}
