package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseResBil2NRIHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseResBil2NRI
 * @param argIdrecord int
 * @param argIdresbilling java.lang.String
 * @param argBillresname java.lang.String
 * @param argRecord_status java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseResBil2NRI create(int argIdrecord, java.lang.String argIdresbilling, java.lang.String argBillresname, java.lang.String argRecord_status) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseResBil2NRI
 * @param key com.hps.july.persistence.LeaseResBil2NRIKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseResBil2NRI findByPrimaryKey(com.hps.july.persistence.LeaseResBil2NRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(
		Boolean isSubtype, Integer subtype,
    Boolean isModel, String model,
    Boolean isName, String name,
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer connected,
    Integer order
	) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE2(
		Boolean isIdresbilling, String idresbilling,
    Boolean isBillresname, String billresname,
    Integer connected,
    Integer order	) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseResBilsByLeaseResBil(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
