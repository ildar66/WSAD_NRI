package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AbonentBillPos extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAbonBillpos2docposes(com.hps.july.persistence.AbonBillpos2docpos anAbonBillpos2docposes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAbonBillpos2docposes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getBillpos() throws java.rmi.RemoteException;
/**
 * Getter method for cargocountry
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCargocountry() throws java.rmi.RemoteException;
/**
 * Getter method for cargonumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCargonumber() throws java.rmi.RemoteException;
/**
 * Getter method for itemid
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getItemid() throws java.rmi.RemoteException;
/**
 * Getter method for itemname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getItemname() throws java.rmi.RemoteException;
/**
 * Getter method for ndsrate
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getNdsrate() throws java.rmi.RemoteException;
/**
 * Getter method for ndssumm
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getNdssumm() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getNdssummnri() throws java.rmi.RemoteException;
/**
 * Getter method for nsprate
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getNsprate() throws java.rmi.RemoteException;
/**
 * Getter method for nspsumm
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getNspsumm() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getNspsummnri() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonentBill getPos2bill() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonentBillKey getPos2billKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Currency getPos2currency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getPos2currencyKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getPos2resource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getPos2resourceKey() throws java.rmi.RemoteException;
/**
 * Getter method for qty
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getQty() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getRecordstatus() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getSumbyhand() throws java.rmi.RemoteException;
/**
 * Getter method for summ
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumm() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSummnri() throws java.rmi.RemoteException;
/**
 * Getter method for summpure
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSummpure() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSummpurenri() throws java.rmi.RemoteException;
/**
 * Getter method for unitname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getUnitname() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPos2billKey(com.hps.july.persistence.AbonentBillKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPos2currencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPos2resourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAbonBillpos2docposes(com.hps.july.persistence.AbonBillpos2docpos anAbonBillpos2docposes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAbonBillpos2docposes(com.hps.july.persistence.AbonBillpos2docpos anAbonBillpos2docposes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPos2bill(com.hps.july.persistence.AbonentBill aPos2bill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPos2currency(com.hps.july.persistence.Currency aPos2currency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPos2resource(com.hps.july.persistence.Resource aPos2resource) throws java.rmi.RemoteException;
/**
 * Setter method for cargocountry
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCargocountry(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for cargonumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCargonumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for itemid
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setItemid(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for itemname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setItemname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for ndsrate
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setNdsrate(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for ndssumm
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setNdssumm(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setNdssummnri(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nsprate
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setNsprate(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nspsumm
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setNspsumm(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setNspsummnri(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPos2bill(com.hps.july.persistence.AbonentBill aPos2bill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPos2currency(com.hps.july.persistence.Currency aPos2currency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPos2resource(com.hps.july.persistence.Resource aPos2resource) throws java.rmi.RemoteException;
/**
 * Setter method for qty
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setQty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setRecordstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setSumbyhand(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for summ
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumm(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSummnri(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for summpure
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSummpure(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSummpurenri(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for unitname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setUnitname(java.lang.String newValue) throws java.rmi.RemoteException;
}
