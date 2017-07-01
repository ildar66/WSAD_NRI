package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface RequestHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Request
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Request create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Request
 * @param argDocument int
 * @param argOwner java.lang.Integer
 * @param argFrom java.lang.Integer
 * @param argTo java.lang.Integer
 * @param argBlankDate java.sql.Date
 * @param argBlankindex int
 * @param argBlankNumber java.lang.String
 * @param argState java.lang.String
 * @param argProcessSource java.lang.Boolean
 * @param argProcessDestination java.lang.Boolean
 * @param argDivisionRequester java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Request create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.Integer argDivisionRequester) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Request
 * @param argDocument int
 * @param argOwner java.lang.Integer
 * @param argBlankDate java.sql.Date
 * @param argBlankNumber java.lang.String
 * @param argState java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Request create(int argDocument, Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, String argState) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Request
 * @param key com.hps.july.persistence.DocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Request findByPrimaryKey(DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(
	  Boolean useDate, 					java.sql.Date datefrom, java.sql.Date dateto, // Период
	  Boolean useDivision, 			Integer division, // Подразделение
	  Boolean usePosition, 			Integer position, // Позиция position
	  String requestType, // Тип требования, A - все требования, P - дляподрядчика, W - для сотрудника
	  Boolean useOrganization, 	Integer organization, // Если выбран тип P и
	  Boolean useWorker, 				Integer worker,
	  Boolean hasNoLink
  ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRequestByChecker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRequestByDivisionRequester(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRequestByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRequestSenderBySender(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
