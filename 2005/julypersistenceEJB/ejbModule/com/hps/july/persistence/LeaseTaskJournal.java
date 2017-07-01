package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseTaskJournal extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for currency1
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getCurrency1() throws java.rmi.RemoteException;
/**
 * Getter method for currency2
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getCurrency2() throws java.rmi.RemoteException;
/**
 * Getter method for date1
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDate1() throws java.rmi.RemoteException;
/**
 * Getter method for date2
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDate2() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseTaskStart getJournal2start() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseTaskStartKey getJournal2startKey() throws java.rmi.RemoteException;
/**
 * Getter method for jrnaction
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getJrnaction() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getJrndate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getJrnmessage() throws java.rmi.RemoteException;
/**
 * Getter method for jrntype
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getJrntype() throws java.rmi.RemoteException;
/**
 * Getter method for leasedocposition
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getLeasedocposition() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getLeasedocposition2() throws java.rmi.RemoteException;
/**
 * Getter method for leasedocument
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getLeasedocument() throws java.rmi.RemoteException;
/**
 * Getter method for leaserule
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getLeaserule() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getResource1() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getResource2() throws java.rmi.RemoteException;
/**
 * Getter method for summ1
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumm1() throws java.rmi.RemoteException;
/**
 * Getter method for summ2
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumm2() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getTaskjournal() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetJournal2startKey(com.hps.july.persistence.LeaseTaskStartKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetJournal2start(com.hps.july.persistence.LeaseTaskStart aJournal2start) throws java.rmi.RemoteException;
/**
 * Setter method for currency1
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setCurrency1(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for currency2
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setCurrency2(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for date1
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDate1(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for date2
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDate2(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setJournal2start(com.hps.july.persistence.LeaseTaskStart aJournal2start) throws java.rmi.RemoteException;
/**
 * Setter method for jrnaction
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setJrnaction(int newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setJrndate(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setJrnmessage(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for jrntype
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setJrntype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for leasedocposition
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setLeasedocposition(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setLeasedocposition2(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for leasedocument
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setLeasedocument(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for leaserule
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setLeaserule(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setResource1(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setResource2(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for summ1
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumm1(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for summ2
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumm2(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
