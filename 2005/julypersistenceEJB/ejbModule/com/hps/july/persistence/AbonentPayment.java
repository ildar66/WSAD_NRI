package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AbonentPayment extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAbonPays2docposes(com.hps.july.persistence.AbonPays2docpos anAbonPays2docposes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseAbonentDNOPs(com.hps.july.persistence.LeaseAbonentDNOP aLeaseAbonentDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAbonPays2docposes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getBen() throws java.rmi.RemoteException;
/**
 * Getter method for byhand
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getByhand() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getChangeneedpay() throws java.rmi.RemoteException;
/**
 * Getter method for flagworknri
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getFlagworknri() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseAbonentBAN getLeaseabonentban() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getLeaseabonentbanKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseAbonentDNOPs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for needpay
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getNeedpay() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getPaydate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPaynumber() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getPaypos() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPymtype() throws java.rmi.RemoteException;
/**
 * Getter method for recordstatus
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRecordstatus() throws java.rmi.RemoteException;
/**
 * Getter method for resource
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getResource() throws java.rmi.RemoteException;
/**
 * Getter method for sumfreerur
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumfreerur() throws java.rmi.RemoteException;
/**
 * Getter method for sumfreeusd
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumfreeusd() throws java.rmi.RemoteException;
/**
 * Getter method for sumnrirur
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumnrirur() throws java.rmi.RemoteException;
/**
 * Getter method for sumnriusd
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumnriusd() throws java.rmi.RemoteException;
/**
 * Getter method for sumpayrur
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumpayrur() throws java.rmi.RemoteException;
/**
 * Getter method for sumpayusd
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumpayusd() throws java.rmi.RemoteException;
/**
 * Getter method for typename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTypename() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetLeaseabonentbanKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAbonPays2docposes(com.hps.july.persistence.AbonPays2docpos anAbonPays2docposes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseAbonentDNOPs(com.hps.july.persistence.LeaseAbonentDNOP aLeaseAbonentDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAbonPays2docposes(com.hps.july.persistence.AbonPays2docpos anAbonPays2docposes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseAbonentDNOPs(com.hps.july.persistence.LeaseAbonentDNOP aLeaseAbonentDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetLeaseabonentban(com.hps.july.persistence.LeaseAbonentBAN aLeaseabonentban) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setBen(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for byhand
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setByhand(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setChangeneedpay(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for flagworknri
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setFlagworknri(boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setLeaseabonentban(com.hps.july.persistence.LeaseAbonentBAN aLeaseabonentban) throws java.rmi.RemoteException;
/**
 * Setter method for needpay
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setNeedpay(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setPaydate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPaynumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPymtype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for recordstatus
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRecordstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for resource
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setResource(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumfreerur
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumfreerur(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumfreeusd
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumfreeusd(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumnrirur
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumnrirur(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumnriusd
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumnriusd(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumpayrur
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumpayrur(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumpayusd
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumpayusd(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for typename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTypename(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: payPurpose
	 */
	public java.lang.String getPayPurpose() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: payPurpose
	 */
	public void setPayPurpose(java.lang.String newPayPurpose) throws java.rmi.RemoteException;
}
