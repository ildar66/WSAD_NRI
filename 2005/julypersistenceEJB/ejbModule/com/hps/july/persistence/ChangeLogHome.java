package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ChangeLogHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ChangeLog
 * @param argLogid int
 * @param argRecdate java.sql.Timestamp
 * @param argObjtype short
 * @param argObjid int
 * @param argEventtype java.lang.String
 * @param argMan int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ChangeLog create(int argLogid, java.sql.Timestamp argRecdate, short argObjtype, int argObjid, java.lang.String argEventtype, int argMan) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ChangeLog
 * @param key com.hps.july.persistence.ChangeLogKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ChangeLog findByPrimaryKey(com.hps.july.persistence.ChangeLogKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(
        Boolean isObjtype, Short objtype,
        Boolean isObjid, Integer objid,
        Boolean isPeriod, java.sql.Timestamp dateStart, java.sql.Timestamp dateEnd,
        Boolean isMan, Integer man,
        Boolean isEventtype, String eventtype,
        Integer order
    ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findChangeLogsByPeople(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
