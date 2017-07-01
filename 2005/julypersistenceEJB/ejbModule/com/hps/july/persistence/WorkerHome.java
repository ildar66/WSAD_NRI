package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface WorkerHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Worker
 * @param argWorker int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Worker create(int argWorker) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Worker
 * @param argWorker int
 * @param argMan java.lang.Integer
 * @param argPosition java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Worker create(int argWorker, java.lang.Integer argMan, java.lang.Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Worker
 * @param argWorker int
 * @param argMan java.lang.Integer
 * @param argPosition java.lang.Integer
 * @param argIsour java.lang.Boolean
 * @param argIsservicestuff java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Worker create(int argWorker, java.lang.Integer argMan, java.lang.Integer argPosition, java.lang.Boolean argIsour, java.lang.Boolean argIsservicestuff) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAlienWorkers(Integer organization, String family) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByLastNameOrderByLastNameAsc( String name ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Worker
 * @param key com.hps.july.persistence.WorkerKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Worker findByPrimaryKey(com.hps.july.persistence.WorkerKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(Boolean isDivision, Integer argDivision,
  Boolean isLastName, String argLastName,
  Boolean isActive, Boolean argActive, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findWorkersByCompany(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findWorkersByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findWorkersByMan(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Worker2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findWorkersByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findWorkersByPosition(com.hps.july.persistence.WorkPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
