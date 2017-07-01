package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeasePosSchetFakt extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for country
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCountry() throws java.rmi.RemoteException;
/**
 * Getter method for edizm
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getEdizm() throws java.rmi.RemoteException;
/**
 * Getter method for excise
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getExcise() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdPosSchetFakt() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseSchetFakt getIdSchetFakt() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseSchetFaktKey getIdSchetFaktKey() throws java.rmi.RemoteException;
/**
 * Getter method for nameResource
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNameResource() throws java.rmi.RemoteException;
/**
 * Getter method for numGTD
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNumGTD() throws java.rmi.RemoteException;
/**
 * Getter method for posorder
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getPosorder() throws java.rmi.RemoteException;
/**
 * Getter method for price
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getPrice() throws java.rmi.RemoteException;
/**
 * Getter method for qty
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getQty() throws java.rmi.RemoteException;
/**
 * Getter method for rateNds
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getRateNds() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResourceNri() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceNriKey() throws java.rmi.RemoteException;
/**
 * Getter method for sumFreeTax
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumFreeTax() throws java.rmi.RemoteException;
/**
 * Getter method for sumNds
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumNds() throws java.rmi.RemoteException;
/**
 * Getter method for sumWithTax
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumWithTax() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetIdSchetFaktKey(com.hps.july.persistence.LeaseSchetFaktKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceNriKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetIdSchetFakt(com.hps.july.persistence.LeaseSchetFakt anIdSchetFakt) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResourceNri(com.hps.july.persistence.Resource aResourceNri) throws java.rmi.RemoteException;
/**
 * Setter method for country
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCountry(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for edizm
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setEdizm(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for excise
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setExcise(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setIdSchetFakt(com.hps.july.persistence.LeaseSchetFakt anIdSchetFakt) throws java.rmi.RemoteException;
/**
 * Setter method for nameResource
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNameResource(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for numGTD
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNumGTD(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for posorder
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setPosorder(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for price
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setPrice(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for qty
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setQty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for rateNds
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setRateNds(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResourceNri(com.hps.july.persistence.Resource aResourceNri) throws java.rmi.RemoteException;
/**
 * Setter method for sumFreeTax
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumFreeTax(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumNds
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumNds(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumWithTax
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumWithTax(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
