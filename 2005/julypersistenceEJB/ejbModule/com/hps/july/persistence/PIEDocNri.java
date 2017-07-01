package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEDocNri extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPIEDocPosNris(com.hps.july.persistence.PIEDocPosNri aPIEDocPosNris) throws java.rmi.RemoteException;
/**
 * Getter method for contragent
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getContragent() throws java.rmi.RemoteException;
/**
 * Getter method for datedoc
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDatedoc() throws java.rmi.RemoteException;
/**
 * Getter method for gtdnumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getGtdnumber() throws java.rmi.RemoteException;
/**
 * Getter method for headuser
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getHeaduser() throws java.rmi.RemoteException;
/**
 * Getter method for iddogovnri
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIddogovnri() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdrecdoc() throws java.rmi.RemoteException;
/**
 * Getter method for idvaluta
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdvaluta() throws java.rmi.RemoteException;
/**
 * Getter method for owner
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOwner() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPIEDocPosNris() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for placefrom
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getPlacefrom() throws java.rmi.RemoteException;
/**
 * Getter method for placeto
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getPlaceto() throws java.rmi.RemoteException;
/**
 * Getter method for prim
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPrim() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQuery getQuery() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQueryKey getQueryKey() throws java.rmi.RemoteException;
/**
 * Getter method for soprnumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSoprnumber() throws java.rmi.RemoteException;
/**
 * Getter method for sumdoc
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumdoc() throws java.rmi.RemoteException;
/**
 * Getter method for tempinbill
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTempinbill() throws java.rmi.RemoteException;
/**
 * Getter method for typedocnri
 * @return short
 * @exception java.rmi.RemoteException The exception description.
 */
short getTypedocnri() throws java.rmi.RemoteException;
/**
 * Getter method for typedogovnri
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTypedogovnri() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetQueryKey(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPIEDocPosNris(com.hps.july.persistence.PIEDocPosNri aPIEDocPosNris) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePIEDocPosNris(com.hps.july.persistence.PIEDocPosNri aPIEDocPosNris) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException;
/**
 * Setter method for contragent
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setContragent(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for datedoc
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDatedoc(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for gtdnumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setGtdnumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for headuser
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setHeaduser(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for iddogovnri
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIddogovnri(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idvaluta
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdvaluta(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for owner
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setOwner(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for placefrom
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setPlacefrom(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for placeto
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setPlaceto(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for prim
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPrim(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException;
/**
 * Setter method for soprnumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSoprnumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumdoc
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumdoc(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for tempinbill
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTempinbill(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for typedocnri
 * @param newValue short
 * @exception java.rmi.RemoteException The exception description.
 */
void setTypedocnri(short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for typedogovnri
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTypedogovnri(java.lang.String newValue) throws java.rmi.RemoteException;
}
