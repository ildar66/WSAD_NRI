package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface AfsMountActHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.AfsMountAct
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.AfsMountAct create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.AfsMountAct
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
 * @param argFixing java.lang.Boolean
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.AfsMountAct create(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, Boolean argProcessDestination, Boolean argFixing) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.AfsMountAct
 * @param argDocument int
 * @param argOwner java.lang.Integer
 * @param argBlankDate java.sql.Date
 * @param argBlankindex int
 * @param argState java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.AfsMountAct create(int argDocument, Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, String argState) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.AfsMountAct
 * @param key com.hps.july.persistence.DocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.AfsMountAct findByPrimaryKey(DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param isDate java.lang.Boolean
 * @param startDate java.sql.Date
 * @param endDate java.sql.Date
 * @param isOwner java.lang.Boolean
 * @param owner java.lang.Integer
 * @param isStorage java.lang.Boolean
 * @param storage java.lang.Integer
 * @param isContractor java.lang.Boolean
 * @param contractor java.lang.Integer
 * @param isWorker java.lang.Boolean
 * @param worker java.lang.Integer
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByQBE(Boolean isDate, java.sql.Date startDate, java.sql.Date endDate, Boolean isOwner, Integer owner, Boolean isStorage, Integer storage, Boolean isContractor, Integer contractor, Boolean isWorker, Integer worker, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param isDate java.lang.Boolean
 * @param datefrom java.sql.Date
 * @param dateto java.sql.Date
 * @param isOwner java.lang.Boolean
 * @param owner java.lang.Integer
 * @param isPosition java.lang.Boolean
 * @param position java.lang.Integer
 * @param isProvider java.lang.Boolean
 * @param provider java.lang.Integer
 * @param isWorker java.lang.Boolean
 * @param worker java.lang.Integer
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByQBE2(Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, Boolean isOwner, Integer owner, Boolean isPosition, Integer position, Boolean isProvider, Integer provider, Boolean isWorker, Integer worker, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
