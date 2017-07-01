package com.hps.july.journal.beans;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Journal extends javax.ejb.EJBObject {

/**
 * 
 * @return boolean
 * @param idAntenna int
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean removeAntenna(int idAntenna) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException;
/**
 * 
 * @return boolean
 * @param idBasestation int
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean removeBasestation(int idBasestation) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException;
/**
 * 
 * @return boolean
 * @param idLeasedocument int
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean removeLeaseArendaAgrmnts(int idLeasedocument) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException;
/**
 * 
 * @return boolean
 * @param idLeasedocument int
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean removeLeaseMutualAct(int idLeasedocument) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException;
/**
 * 
 * @return boolean
 * @param idPay int
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean removeLeasePayment(int idPay) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException;
/**
 * 
 * @return boolean
 * @param idPosition int
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean removePosition(int idPosition) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException;
/**
 * 
 * @return boolean
 * @param idSector int
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean removeSector(int idSector) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException;
/**
 * 
 * @return boolean
 * @param idResponsibility int
 * @param idStorageplace int
 * @param idResptype java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 * @exception String The exception description.
 */
boolean removeWorkresponsible(int idResponsibility, int idStorageplace, java.lang.String idResptype) throws javax.ejb.FinderException, javax.ejb.RemoveException, javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException, java.rmi.ServerException;
}
