package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface IBPMountPosHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.IBPMountPos
 * @param argDocposition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.IBPMountPos create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.IBPMountPos
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
com.hps.july.persistence.IBPMountPos create(int argDocposition, Integer argResource, Integer argOwner, Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, Boolean argSourceBoxed, Boolean argResultBoxed, Boolean argSourceBroken, Boolean argResultBroken, Boolean argSourceClosed, Boolean argResultClosed) throws javax.ejb.CreateException, java.rmi.RemoteException;
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
 * @return com.hps.july.persistence.IBPMountPos
 * @param argAgregatSerial java.lang.String
 * @param argDate java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.IBPMountPos findByAgregateAfterDate(String argAgregatSerial, java.sql.Date argDate) throws java.rmi.RemoteException, javax.ejb.FinderException;
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
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @param argPolicy java.lang.String
 * @param argNumber java.lang.String
 * @param isResource java.lang.Boolean
 * @param argResource java.lang.Integer
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByDocumentQBE(Integer argDocument, String argPolicy, String argNumber, Boolean isResource, Integer argResource, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param argDocument java.lang.Integer
 * @param argPolicy java.lang.String
 * @param argNumber java.lang.String
 * @param isOwner java.lang.Boolean
 * @param owner java.lang.Integer
 * @param isResource java.lang.Boolean
 * @param argResource java.lang.Integer
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByDocumentQBE2(Integer argDocument, String argPolicy, String argNumber, Boolean isOwner, Integer owner, Boolean isResource, Integer argResource, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.IBPMountPos
 * @param argDocument java.lang.Integer
 * @param argSerial java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.IBPMountPos findByDocumentSerialnum(Integer argDocument, String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.IBPMountPos
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.IBPMountPos findByPrimaryKey(DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param argResource java.lang.Integer
 * @param argOwner java.lang.Integer
 * @param isSerial java.lang.Boolean
 * @param argSerial java.lang.String
 * @param isParty java.lang.Boolean
 * @param argParty java.lang.String
 * @param isTo java.lang.Boolean
 * @param argTo java.lang.Integer
 * @param isFrom java.lang.Boolean
 * @param argFrom java.lang.Integer
 * @param argDocType java.lang.String
 * @param isAddDoc java.lang.Boolean
 * @param argAddDoc java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByQBE(Integer argResource, Integer argOwner, Boolean isSerial, String argSerial, Boolean isParty, String argParty, Boolean isTo, Integer argTo, Boolean isFrom, Integer argFrom, String argDocType, Boolean isAddDoc, Integer argAddDoc) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param requestId java.lang.Integer
 * @param resourceId java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByRequestResource(Integer requestId, Integer resourceId) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.IBPMountPos
 * @param argDocument java.lang.Integer
 * @param argStorage java.lang.Integer
 * @param argDate java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.IBPMountPos findByResourceSetAndStorageAfterDate(Integer argDocument, Integer argStorage, java.sql.Date argDate) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.IBPMountPos
 * @param argStorage java.lang.Integer
 * @param argDate java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.IBPMountPos findByStorageAfterDate(Integer argStorage, java.sql.Date argDate) throws java.rmi.RemoteException, javax.ejb.FinderException;
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
 * @return com.hps.july.persistence.IBPMountPos
 * @param argDocument java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.IBPMountPos findMaxOrderPosition(Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
