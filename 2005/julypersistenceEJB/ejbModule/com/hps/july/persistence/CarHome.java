package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface CarHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Car
 * @param argCar int
 * @param argIsour java.lang.Boolean
 * @param argCarmodel java.lang.String
 * @param argCarnumber java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Car create(int argCar, java.lang.Boolean argIsour, java.lang.String argCarmodel, java.lang.String argCarnumber) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByOrganizationIsour(Integer organization, String isour) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Car
 * @param key com.hps.july.persistence.CarKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Car findByPrimaryKey(com.hps.july.persistence.CarKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(
    Boolean isOrganization, Integer organization,
    Boolean isDivision, Integer division,
    Integer order
	) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findCarsByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Car2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findCarsByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
