package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: LeaseMutualActNew
 */
public interface LeaseMutualActNew extends com.hps.july.persistence.LeaseDocument, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getActenddate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getActfilename() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getActstartdate() throws java.rmi.RemoteException;
/**
 * Getter method for actState
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getActState() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFooter() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getHeader() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getIsSchetFakt() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getIstemp() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseCalcRates() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseDNOPs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseDocPositions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseMutualReglament getLeaseMutualReglament() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getLeaseMutualReglamentKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseSaldos() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseVPayment2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseVPayments() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetLeaseMutualReglamentKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseVPayment2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseVPayments(com.hps.july.persistence.LeaseVPayment aLeaseVPayments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseVPayment2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseVPayments(com.hps.july.persistence.LeaseVPayment aLeaseVPayments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetLeaseMutualReglament(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglament) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setActenddate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setActstartdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for actState
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setActState(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFooter(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setHeader(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setIsSchetFakt(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setIstemp(boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setLeaseMutualReglament(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglament) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: mutualNDS
	 */
	public java.lang.Boolean getMutualNDS() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: mutualNDS
	 */
	public void setMutualNDS(java.lang.Boolean newMutualNDS) throws java.rmi.RemoteException;
}
