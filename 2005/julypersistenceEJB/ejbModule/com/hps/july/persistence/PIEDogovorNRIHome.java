package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEDogovorNRIHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEDogovorNRI
 * @param argIdrecdogovor int
 * @param argQuery int
 * @param argOrgOwner int
 * @param argPartnerNri int
 * @param argAccountNri int
 * @param argDogovorPlatinum java.lang.String
 * @param argIdBudjet int
 * @param argIdExperience int
 * @param argDogDate java.sql.Date
 * @param argDogStartDate java.sql.Date
 * @param argDogEndDate java.sql.Date
 * @param argDogBlankCode java.lang.String
 * @param argSumDog java.math.BigDecimal
 * @param argValute int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEDogovorNRI create(int argIdrecdogovor, int argQuery, int argOrgOwner, int argPartnerNri, int argAccountNri, java.lang.String argDogovorPlatinum, int argIdBudjet, int argIdExperience, java.sql.Date argDogDate, java.sql.Date argDogStartDate, java.sql.Date argDogEndDate, java.lang.String argDogBlankCode, java.math.BigDecimal argSumDog, int argValute) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEDogovorNRI
 * @param key com.hps.july.persistence.PIEDogovorNRIKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEDogovorNRI findByPrimaryKey(com.hps.july.persistence.PIEDogovorNRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPIEDogovorNRIsByPiequery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
