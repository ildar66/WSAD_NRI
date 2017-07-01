package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface InternalWayBillPositionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.InternalWayBillPosition
 * @param argDocposition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.InternalWayBillPosition create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.InternalWayBillPosition
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
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.InternalWayBillPosition create(int argDocposition, Integer argResource, Integer argOwner, Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, Boolean argSourceBoxed, Boolean argResultBoxed, Boolean argSourceBroken, Boolean argResultBroken, Boolean argSourceClosed, Boolean argResultClosed) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findBadAgregatesByDocument(Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByDocOrderByAgregateAsc(Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByDocOrderByAgregateDesc(Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.InternalWayBillPosition
 * @param argDocument java.lang.Integer
 * @param argSerial java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.InternalWayBillPosition findByDocumentSerialnum(Integer argDocument, String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.InternalWayBillPosition
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.InternalWayBillPosition findByPrimaryKey(DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
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
 * @return com.hps.july.persistence.InternalWayBillPosition
 * @param argDocument java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.InternalWayBillPosition findMaxOrderPosition(Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
