package com.hps.july.trailcom.beans;

/**
 * This is a Home interface for the Entity Bean
 */
public interface HopHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.trailcom.beans.Hop
 * @param argHopsid int
 * @param argEquipmentid_enda int
 * @param argEquipmentid_endb int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.trailcom.beans.Hop create(int argHopsid, int argEquipmentid_enda, int argEquipmentid_endb) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByPositionAndType(String hopstype, Integer siteid_enda, Integer siteid_endb) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByPositions(
	java.lang.Boolean isTypeR, 
	java.lang.Boolean isTypeO, 
	java.lang.Boolean isNetZone, 				java.lang.Integer argNetZone, 
	java.lang.Boolean isAllType, 
	java.lang.Boolean isDAMPS, 
	java.lang.Boolean isGSM900, 
	java.lang.Boolean isDCS1800, 
	java.lang.Boolean isControllers, 
	java.lang.Boolean isWorker, 				java.lang.Integer argWorker) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.trailcom.beans.Hop
 * @param key com.hps.july.trailcom.beans.HopKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.trailcom.beans.Hop findByPrimaryKey(com.hps.july.trailcom.beans.HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findBySiteid_endaOrderByHopsidAsc(Integer siteid_enda) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findBySiteid_endbOrderByHopsidAsc(Integer siteid_endb) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findHopsByPosition(Integer position) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findNestedLines(Boolean useType, String type, Integer hop, Integer position) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
