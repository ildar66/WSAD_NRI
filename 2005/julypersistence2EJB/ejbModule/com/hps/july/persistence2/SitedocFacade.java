package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SitedocFacade extends javax.ejb.EJBObject {

/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.EtapDocValueObject
 * @param comlines int []
 * @exception String The exception description.
 * @exception String The exception description.
 */
void createEtapDoc(com.hps.july.persistence2.EtapDocValueObject argObj, int [] comlines) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.GKRCHDocValueObject
 * @exception String The exception description.
 */
void createGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject argObj) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.GKRCHDocValueObject
 * @param argResources com.hps.july.persistence2.DocResourceValueObject []
 * @param argRegions int []
 * @exception String The exception description.
 */
void createGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject argObj, com.hps.july.persistence2.DocResourceValueObject [] argResources, int [] argRegions) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.RRLDocValueObject
 * @exception String The exception description.
 */
void createRRLDoc(com.hps.july.persistence2.RRLDocValueObject argObj) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.RRLDocValueObject
 * @param argResources com.hps.july.persistence2.DocResourceValueObject []
 * @exception String The exception description.
 */
void createRRLDoc(com.hps.july.persistence2.RRLDocValueObject argObj, com.hps.july.persistence2.DocResourceValueObject [] argResources) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argSiteDoc int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void deleteEtapDoc(int argSiteDoc) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param argSiteDoc int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void deleteGKRCHDoc(int argSiteDoc) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param argSiteDoc int
 * @exception String The exception description.
 * @exception String The exception description.
 */
void deleteRRLDoc(int argSiteDoc) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return com.hps.july.persistence2.EtapDocValueObject
 * @param argSiteDoc int
 * @exception String The exception description.
 */
com.hps.july.persistence2.EtapDocValueObject findEtapDocByPrimaryKey(int argSiteDoc) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence2.GKRCHDocValueObject
 * @param argSiteDoc int
 * @exception String The exception description.
 */
com.hps.july.persistence2.GKRCHDocValueObject findGKRCHDocByPrimaryKey(int argSiteDoc) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence2.RRLDocValueObject
 * @param argSiteDoc int
 * @exception String The exception description.
 */
com.hps.july.persistence2.RRLDocValueObject findRRLDocByPrimaryKey(int argSiteDoc) throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getGKRCHSiteDocType() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getRRLSiteDocType() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.EtapDocValueObject
 * @param comlines int []
 * @exception String The exception description.
 * @exception String The exception description.
 */
void updateEtapDoc(com.hps.july.persistence2.EtapDocValueObject argObj, int [] comlines) throws java.rmi.RemoteException, java.lang.Exception;
/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.GKRCHDocValueObject
 * @exception String The exception description.
 */
void updateGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject argObj) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.GKRCHDocValueObject
 * @param argResources com.hps.july.persistence2.DocResourceValueObject []
 * @param argRegions int []
 * @exception String The exception description.
 */
void updateGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject argObj, com.hps.july.persistence2.DocResourceValueObject [] argResources, int [] argRegions) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.RRLDocValueObject
 * @exception String The exception description.
 */
void updateRRLDoc(com.hps.july.persistence2.RRLDocValueObject argObj) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argObj com.hps.july.persistence2.RRLDocValueObject
 * @param argResources com.hps.july.persistence2.DocResourceValueObject []
 * @exception String The exception description.
 */
void updateRRLDoc(com.hps.july.persistence2.RRLDocValueObject argObj, com.hps.july.persistence2.DocResourceValueObject [] argResources) throws java.rmi.RemoteException;
}
