package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface DocumentPositionHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.DocumentPosition
 * @param argDocposition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.DocumentPosition create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.DocumentPosition
 * @param argDocposition int
 * @param argResource java.lang.Integer
 * @param argOwner java.lang.Integer
 * @param argDocument java.lang.Integer
 * @param argOrder int
 * @param argQty java.math.BigDecimal
 * @param argPrice java.math.BigDecimal
 * @param argSourceBoxed java.lang.Boolean
 * @param argResultBoxed java.lang.Boolean
 * @param argSourceBroken java.lang.Boolean
 * @param argResultBroken java.lang.Boolean
 * @param argSourceClosed java.lang.Boolean
 * @param argResultClosed java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.DocumentPosition create(int argDocposition, java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, java.lang.Boolean argSourceBoxed, java.lang.Boolean argResultBoxed, java.lang.Boolean argSourceBroken, java.lang.Boolean argResultBroken, java.lang.Boolean argSourceClosed, java.lang.Boolean argResultClosed) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAgregatePartsByAgregate(com.hps.july.persistence.DocumentPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findBadAgregatesByDocument( Integer argDocument ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.DocumentPosition
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.DocumentPosition findByAgregateAfterDate( String argAgregatSerial, java.sql.Date argDate ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByDocOrderByAgregateAsc( Integer argDocument ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByDocOrderByAgregateDesc( Integer argDocument ) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByDocumentQBE(
    Integer argDocument,
    String argPolicy, String argNumber,
    Boolean isResource, Integer argResource,
    Integer order
) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByDocumentQBE2(
    Integer argDocument,
    String argPolicy, String argNumber,
    Boolean isOwner, Integer owner,
    Boolean isResource, Integer argResource,
    Integer order
) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.DocumentPosition
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.DocumentPosition findByDocumentSerialnum( Integer argDocument, String argSerial ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.DocumentPosition
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.DocumentPosition findByPrimaryKey(com.hps.july.persistence.DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(Integer argResource, Integer argOwner, 
	Boolean isSerial, String argSerial,
	Boolean isParty, String argParty,
	Boolean isTo, Integer argTo,
	Boolean isFrom, Integer argFrom,
	String argDocType,
	Boolean isAddDoc, Integer argAddDoc
	) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByRequestResource(Integer requestId, Integer resourceId) 
	throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.DocumentPosition
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.DocumentPosition findByResourceSetAndStorageAfterDate( Integer argDocument, Integer argStorage, java.sql.Date argDate ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.DocumentPosition
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.DocumentPosition findByStorageAfterDate( Integer argStorage, java.sql.Date argDate ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc( Integer argDocument, String argPolicy ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderDesc( Integer argDocument, String argPolicy ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findDocPositionsByDocOrderByOrderAsc( Integer argDocument ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findDocPositionsByDocOrderByOrderDesc( Integer argDocument ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findDocumentPositionByDocument(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findDocumentPositionByOwner(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findDocumentPositionByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findInDocumentPositionByCardTo(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.DocumentPosition
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.DocumentPosition findMaxOrderPosition( Integer argDocument ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findOutDocumentPositionByCardFrom(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
