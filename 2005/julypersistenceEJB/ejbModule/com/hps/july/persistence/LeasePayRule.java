package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeasePayRule extends com.hps.july.persistence.LeaseRule, com.ibm.ivj.ejb.runtime.CopyHelper {
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeasePayment(com.hps.july.persistence.LeasePayment aLeasePayment) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Currency getCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getCurrencyKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeasePayment() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Account getOrgAcc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AccountKey getOrgAccKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Organization getOrgToPay() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OrganizationKey getOrgToPayKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getPayBeforeDate() throws java.rmi.RemoteException;
/**
 * Getter method for payPeriod
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPayPeriod() throws java.rmi.RemoteException;
/**
 * Getter method for PayPurpose
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPayPurpose() throws java.rmi.RemoteException;
/**
 * Getter method for payTerms
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPayTerms() throws java.rmi.RemoteException;
/**
 * Getter method for payType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPayType() throws java.rmi.RemoteException;
/**
 * Getter method for ppType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPpType() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSeparateNdsPay() throws java.rmi.RemoteException;
/**
 * Getter method for sum
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSum() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getValiddatepay() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOrgAccKey(com.hps.july.persistence.AccountKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOrgToPayKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeasePayment(com.hps.july.persistence.LeasePayment aLeasePayment) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeasePayment(com.hps.july.persistence.LeasePayment aLeasePayment) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetOrgAcc(com.hps.july.persistence.Account anOrgAcc) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetOrgToPay(com.hps.july.persistence.Organization anOrgToPay) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2OrgAcc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setOrgAcc(com.hps.july.persistence.Account anOrgAcc) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Orgtopay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setOrgToPay(com.hps.july.persistence.Organization anOrgToPay) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setPayBeforeDate(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for payPeriod
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPayPeriod(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for PayPurpose
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPayPurpose(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for payTerms
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPayTerms(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for payType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPayType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for ppType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPpType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setSeparateNdsPay(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sum
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSum(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setValiddatepay(java.lang.String newValue) throws java.rmi.RemoteException;
}
