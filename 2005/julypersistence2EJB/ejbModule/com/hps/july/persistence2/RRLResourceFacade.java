package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface RRLResourceFacade extends javax.ejb.EJBObject {

/**
 * 
 * @return void
 * @param antenaValue com.hps.july.dictionary.valueobject.RRLAntenaValue
 * @exception String The exception description.
 */
void createRRLAntena(com.hps.july.persistence2.RRLAntenaValue antenaValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param paramsValue com.hps.july.dictionary.valueobject.RRLResourceParamsValue
 * @exception String The exception description.
 */
void createRRLAntParams(com.hps.july.persistence2.RRLResourceParamsValue paramsValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param speedValue com.hps.july.dictionary.valueobject.RRLResourceSpeedParamsValue
 * @exception String The exception description.
 */
void createRRLSpeedParams(com.hps.july.persistence2.RRLResourceSpeedParamsValue speedValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param resource int
 * @exception String The exception description.
 */
void deleteRRLAntena(int resource) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param antenaValue com.hps.july.dictionary.valueobject.RRLAntenaValue
 * @exception String The exception description.
 */
void updateRRLAntena(com.hps.july.persistence2.RRLAntenaValue antenaValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param paramsValue com.hps.july.dictionary.valueobject.RRLResourceParamsValue
 * @exception String The exception description.
 */
void updateRRLAntParams(com.hps.july.persistence2.RRLResourceParamsValue paramsValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param speedValue com.hps.july.dictionary.valueobject.RRLResourceSpeedParamsValue
 * @exception String The exception description.
 */
void updateRRLSpeedParams(com.hps.july.persistence2.RRLResourceSpeedParamsValue speedValue) throws java.rmi.RemoteException;
}
