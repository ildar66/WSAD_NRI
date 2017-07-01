package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEPayPlatinum extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for date
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDate() throws java.rmi.RemoteException;
/**
 * Getter method for docnumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDocnumber() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getDocposition() throws java.rmi.RemoteException;
/**
 * Getter method for flagworknri
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getFlagworknri() throws java.rmi.RemoteException;
/**
 * Getter method for iddogovornri
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIddogovornri() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getIdpayplatinum() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getOwner() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getPaystateplatinum() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEPayLinks() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for purposepay
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPurposepay() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getRecordstatus() throws java.rmi.RemoteException;
/**
 * Getter method for summ
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumm() throws java.rmi.RemoteException;
/**
 * Getter method for summnds
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSummnds() throws java.rmi.RemoteException;
/**
 * Getter method for summndsrub
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSummndsrub() throws java.rmi.RemoteException;
/**
 * Getter method for summrub
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSummrub() throws java.rmi.RemoteException;
/**
 * Getter method for valute
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getValute() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEPayLinks(com.hps.july.persistence.PIEPayLink aPIEPayLinks) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEPayLinks(com.hps.july.persistence.PIEPayLink aPIEPayLinks) throws java.rmi.RemoteException;
/**
 * Setter method for date
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for docnumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDocnumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setDocposition(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for flagworknri
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setFlagworknri(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for iddogovornri
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIddogovornri(int newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setPaystateplatinum(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for purposepay
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPurposepay(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setRecordstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for summ
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumm(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for summnds
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSummnds(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for summndsrub
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSummndsrub(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for summrub
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSummrub(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for valute
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setValute(int newValue) throws java.rmi.RemoteException;
}
