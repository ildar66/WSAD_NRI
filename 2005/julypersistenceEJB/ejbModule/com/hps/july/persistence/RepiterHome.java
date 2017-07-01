package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface RepiterHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Repiter
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Repiter create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Repiter
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Repiter create(int argStorageplace, Integer argDivision, String argName, String argAddress) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Repiter
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argPosition java.lang.Integer
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Repiter create(int argStorageplace, Integer argDivision, String argName, String argAddress, Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Repiter
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argPosition java.lang.Integer
 * @param argDonor_sect java.lang.Integer
 * @param argDonor_type java.lang.String
 * @param argRepiter_class java.lang.String
 * @param argResource java.lang.Integer
 * @param argReppower java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Repiter create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition, java.lang.Integer argDonor_sect, java.lang.String argDonor_type, java.lang.String argRepiter_class, java.lang.Integer argResource, java.math.BigDecimal argReppower) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Repiter
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argPosition java.lang.Integer
 * @param argDonor_sect java.lang.Integer
 * @param argDonor_type java.lang.String
 * @param argRepiter_class java.lang.String
 * @param argResource java.lang.Integer
 * @param argReppower java.math.BigDecimal
 * @param argNumber int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Repiter create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition, java.lang.Integer argDonor_sect, java.lang.String argDonor_type, java.lang.String argRepiter_class, java.lang.Integer argResource, java.math.BigDecimal argReppower, int argNumber) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Repiter
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argPosition java.lang.Integer
 * @param argDonor_sect java.lang.Integer
 * @param argDonor_type java.lang.String
 * @param argRepiter_class java.lang.String
 * @param argReppower java.math.BigDecimal
 * @param argNumber int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Repiter create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition, java.lang.Integer argDonor_sect, java.lang.String argDonor_type, java.lang.String argRepiter_class, java.math.BigDecimal argReppower, int argNumber) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return java.util.Enumeration
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param position java.lang.Integer
 * @param owner java.lang.Integer
 * @param state java.lang.String
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByPlatinumAndStatus(Integer position, Integer owner, String state, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.Repiter
 * @param key com.hps.july.persistence.StoragePlaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Repiter findByPrimaryKey(StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(Boolean isDonorSect, Integer donorSect, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRepitersByDonor_ant(com.hps.july.persistence.AntennaKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRepitersByDonor_sect(com.hps.july.persistence.SectorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findRepitersByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
