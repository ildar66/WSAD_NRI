package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AntennaHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Antenna
 * @param argIdanten int
 * @param argResource int
 * @param argNumant java.lang.String
 * @param argKindant java.lang.String
 * @param argNakl java.math.BigDecimal
 * @param argAzant java.math.BigDecimal
 * @param argHset1 java.math.BigDecimal
 * @param argLencable java.math.BigDecimal
 * @param argEquipment int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Antenna create(int argIdanten, int argResource, java.lang.String argNumant, java.lang.String argKindant, java.math.BigDecimal argNakl, java.math.BigDecimal argAzant, java.math.BigDecimal argHset1, java.math.BigDecimal argLencable, int argEquipment) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Antenna
 * @param argIdanten int
 * @param argResource int
 * @param argNumant java.lang.String
 * @param argKindant java.lang.String
 * @param argNakl java.math.BigDecimal
 * @param argAzant java.math.BigDecimal
 * @param argHset1 java.math.BigDecimal
 * @param argLencable java.math.BigDecimal
 * @param argEquipment int
 * @param argByhand java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Antenna create(int argIdanten, int argResource, java.lang.String argNumant, java.lang.String argKindant, java.math.BigDecimal argNakl, java.math.BigDecimal argAzant, java.math.BigDecimal argHset1, java.math.BigDecimal argLencable, int argEquipment, java.lang.Boolean argByhand) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAntennesByCableres(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAntennesByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAntennesByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAntennesByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByEquipmentOrderByNumAsc(Integer argEquipment) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Antenna
 * @param key com.hps.july.persistence.AntennaKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Antenna findByPrimaryKey(com.hps.july.persistence.AntennaKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(Integer argBSNum, String bsType,
	Boolean isPlanstate, String argPlanstate, 
	Boolean isState, String argState,
	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findGrresAntennesByGroundresource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
