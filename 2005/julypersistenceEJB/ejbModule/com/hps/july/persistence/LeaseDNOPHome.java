package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseDNOPHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseDNOP
 * @param argLeaseCharge java.lang.Integer
 * @param argLeasePayment java.lang.Integer
 * @param argChargeSum java.math.BigDecimal
 * @param argPayRurSum java.math.BigDecimal
 * @param argSource java.lang.String
 * @param argByHandChargeRateRur java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseDNOP create(java.lang.Integer argLeaseCharge, java.lang.Integer argLeasePayment, java.math.BigDecimal argChargeSum, java.math.BigDecimal argPayRurSum, java.lang.String argSource, java.lang.Boolean argByHandChargeRateRur) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByActAndHand(Integer argAct, String argHand) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByActAndSource(Integer argAct, String argSource) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByLeaseChargeOrderByLeasePayment(Integer leaseCharge)
 throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByLeaseChargeSource(Integer argLeaseCharge, String argSource)
	 throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByLeasePaymentSource(Integer argLeasePayment, String argSource)
	 throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseDNOP
 * @param key com.hps.july.persistence.LeaseDNOPKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseDNOP findByPrimaryKey(com.hps.july.persistence.LeaseDNOPKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDNOP2LeaseCharge.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseDNOPByLeaseCharge(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseDNOPPayByLeasePayment(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseDNOPsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
