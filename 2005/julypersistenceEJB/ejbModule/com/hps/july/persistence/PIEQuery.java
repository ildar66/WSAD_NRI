package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEQuery extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPIEDocNris(com.hps.july.persistence.PIEDocNri aPIEDocNris) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPIEDogovorNRIs(com.hps.july.persistence.PIEDogovorNRI aPIEDogovorNRIs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPIEPayNRIs(com.hps.july.persistence.PIEPayNRI aPIEPayNRIs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPIEQueryLists(com.hps.july.persistence.PIEQueryList aPIEQueryLists) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPIEQueryLogs(com.hps.july.persistence.PIEQueryLog aPIEQueryLogs) throws java.rmi.RemoteException;
/**
 * Getter method for datebeg
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getDatebeg() throws java.rmi.RemoteException;
/**
 * Getter method for dateend
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getDateend() throws java.rmi.RemoteException;
/**
 * Getter method for idobjnriint
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdobjnriint() throws java.rmi.RemoteException;
/**
 * Getter method for idobjnristr
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIdobjnristr() throws java.rmi.RemoteException;
/**
 * Getter method for idobjplat
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIdobjplat() throws java.rmi.RemoteException;
/**
 * Getter method for idplatinumqry
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdplatinumqry() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdquery() throws java.rmi.RemoteException;
/**
 * Getter method for operation
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getOperation() throws java.rmi.RemoteException;
/**
 * Getter method for owner
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getOwner() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPIEDocNris() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPIEDogovorNRIs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPIEPayNRIs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPIEQueryLists() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPIEQueryLogs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for status
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getStatus() throws java.rmi.RemoteException;
/**
 * Getter method for statusop
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getStatusop() throws java.rmi.RemoteException;
/**
 * Getter method for typeobjnri
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTypeobjnri() throws java.rmi.RemoteException;
/**
 * Getter method for typequery
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTypequery() throws java.rmi.RemoteException;
/**
 * Getter method for vdat
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getVdat() throws java.rmi.RemoteException;
/**
 * Getter method for voper
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getVoper() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPIEDocNris(com.hps.july.persistence.PIEDocNri aPIEDocNris) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPIEDogovorNRIs(com.hps.july.persistence.PIEDogovorNRI aPIEDogovorNRIs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPIEPayNRIs(com.hps.july.persistence.PIEPayNRI aPIEPayNRIs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPIEQueryLists(com.hps.july.persistence.PIEQueryList aPIEQueryLists) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPIEQueryLogs(com.hps.july.persistence.PIEQueryLog aPIEQueryLogs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePIEDocNris(com.hps.july.persistence.PIEDocNri aPIEDocNris) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDogovorNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePIEDogovorNRIs(com.hps.july.persistence.PIEDogovorNRI aPIEDogovorNRIs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePIEPayNRIs(com.hps.july.persistence.PIEPayNRI aPIEPayNRIs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePIEQueryLists(com.hps.july.persistence.PIEQueryList aPIEQueryLists) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePIEQueryLogs(com.hps.july.persistence.PIEQueryLog aPIEQueryLogs) throws java.rmi.RemoteException;
/**
 * Setter method for datebeg
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setDatebeg(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dateend
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setDateend(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idobjnriint
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdobjnriint(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idobjnristr
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdobjnristr(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idobjplat
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdobjplat(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idplatinumqry
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdplatinumqry(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for operation
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setOperation(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for owner
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setOwner(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for status
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setStatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for statusop
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setStatusop(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for typeobjnri
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTypeobjnri(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for typequery
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTypequery(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for vdat
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setVdat(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for voper
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setVoper(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
