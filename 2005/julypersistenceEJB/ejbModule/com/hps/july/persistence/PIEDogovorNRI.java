package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEDogovorNRI extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for description
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDescription() throws java.rmi.RemoteException;
/**
 * Getter method for dogblankcode
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDogblankcode() throws java.rmi.RemoteException;
/**
 * Getter method for dogdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDogdate() throws java.rmi.RemoteException;
/**
 * Getter method for dogfinishdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDogfinishdate() throws java.rmi.RemoteException;
/**
 * Getter method for dogstartdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDogstartdate() throws java.rmi.RemoteException;
/**
 * Getter method for idaccountnri
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIdaccountnri() throws java.rmi.RemoteException;
/**
 * Getter method for idbudjet
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIdbudjet() throws java.rmi.RemoteException;
/**
 * Getter method for iddogovorplatinum
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIddogovorplatinum() throws java.rmi.RemoteException;
/**
 * Getter method for idexpence
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIdexpence() throws java.rmi.RemoteException;
/**
 * Getter method for idheaduser
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdheaduser() throws java.rmi.RemoteException;
/**
 * Getter method for idorgowner
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIdorgowner() throws java.rmi.RemoteException;
/**
 * Getter method for idpartnernri
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIdpartnernri() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdrecdogovor() throws java.rmi.RemoteException;
/**
 * Getter method for overprice
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getOverprice() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQuery getPiequery() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQueryKey getPiequeryKey() throws java.rmi.RemoteException;
/**
 * Getter method for purpose
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPurpose() throws java.rmi.RemoteException;
/**
 * Getter method for sumdog
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumdog() throws java.rmi.RemoteException;
/**
 * Getter method for valute
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getValute() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPiequeryKey(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPiequery(com.hps.july.persistence.PIEQuery aPiequery) throws java.rmi.RemoteException;
/**
 * Setter method for description
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDescription(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dogblankcode
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDogblankcode(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dogdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDogdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dogfinishdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDogfinishdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dogstartdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDogstartdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idaccountnri
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdaccountnri(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idbudjet
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdbudjet(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for iddogovorplatinum
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIddogovorplatinum(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idexpence
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdexpence(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idheaduser
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdheaduser(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idorgowner
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdorgowner(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idpartnernri
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdpartnernri(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for overprice
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setOverprice(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPiequery(com.hps.july.persistence.PIEQuery aPiequery) throws java.rmi.RemoteException;
/**
 * Setter method for purpose
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPurpose(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumdog
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumdog(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for valute
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setValute(int newValue) throws java.rmi.RemoteException;
}
