package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface ContractPositionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ContractPosition
 * @param argDocposition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ContractPosition create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ContractPosition
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
 * @param argContractPositionOrder java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ContractPosition create(int argDocposition, java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, java.lang.Boolean argSourceBoxed, java.lang.Boolean argResultBoxed, java.lang.Boolean argSourceBroken, java.lang.Boolean argResultBroken, java.lang.Boolean argSourceClosed, java.lang.Boolean argResultClosed, java.lang.String argContractPositionOrder) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findBadAgregatesByDocument(Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByDocOrderByContractPositionOrderAsc( Integer argDocument ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.ContractPosition
 * @param argDocument java.lang.Integer
 * @param argSerial java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ContractPosition findByDocumentSerialnum(Integer argDocument, String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.ContractPosition
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ContractPosition findByPrimaryKey(DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @param argPolicy java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(Integer argDocument, String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @param argPolicy java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderDesc(Integer argDocument, String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findDocPositionsByDocOrderByOrderAsc(Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.ContractPosition
 * @param argDocument java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ContractPosition findMaxOrderPosition(Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
