package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface I13nActPositionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.I13nActPosition
 * @param argDocposition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.I13nActPosition create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.I13nActPosition
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
 * @param argState java.lang.String
 * @param argSourceClosed java.lang.Boolean
 * @param argResultClosed java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.I13nActPosition create(int argDocposition, java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, java.lang.Boolean argSourceBoxed, java.lang.Boolean argResultBoxed, java.lang.Boolean argSourceBroken, java.lang.Boolean argResultBroken, java.lang.String argState, java.lang.Boolean argSourceClosed, java.lang.Boolean argResultClosed) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.I13nActPosition
 * @param key com.hps.july.persistence.DocumentPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.I13nActPosition findByPrimaryKey(DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findI13nActPositionByContract(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
