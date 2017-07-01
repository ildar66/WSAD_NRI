package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEPayNRI extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for datebeforepay
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDatebeforepay() throws java.rmi.RemoteException;
/**
 * Getter method for datebuch
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDatebuch() throws java.rmi.RemoteException;
/**
 * Getter method for datecreate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDatecreate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getDefinerate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFl101() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFl104() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFl105() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFl106() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFl107() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFl108() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFl109() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFl110() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getId() throws java.rmi.RemoteException;
/**
 * Getter method for idaccountnri
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIdaccountnri() throws java.rmi.RemoteException;
/**
 * Getter method for idbudjet
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdbudjet() throws java.rmi.RemoteException;
/**
 * Getter method for iddogovnri
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIddogovnri() throws java.rmi.RemoteException;
/**
 * Getter method for idexpence
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdexpence() throws java.rmi.RemoteException;
/**
 * Getter method for idpaymode
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdpaymode() throws java.rmi.RemoteException;
/**
 * Getter method for idpaytype
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdpaytype() throws java.rmi.RemoteException;
/**
 * Getter method for idtypeforbuch
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdtypeforbuch() throws java.rmi.RemoteException;
/**
 * Getter method for idusernri
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdusernri() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getIsavans() throws java.rmi.RemoteException;
/**
 * Getter method for ndspay
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getNdspay() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getNumberanddatebdoc() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getPercentavans() throws java.rmi.RemoteException;
/**
 * Getter method for purposepay
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPurposepay() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQuery getQuery() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQueryKey getQueryKey() throws java.rmi.RemoteException;
/**
 * Getter method for sumpay
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumpay() throws java.rmi.RemoteException;
/**
 * Getter method for tiprasxodov
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTiprasxodov() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getTypebasedoc() throws java.rmi.RemoteException;
/**
 * Getter method for typedogovnri
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTypedogovnri() throws java.rmi.RemoteException;
/**
 * Getter method for valutepay
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getValutepay() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetQueryKey(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException;
/**
 * Setter method for datebeforepay
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDatebeforepay(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for datebuch
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDatebuch(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for datecreate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDatecreate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setDefinerate(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFl101(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFl104(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFl105(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFl106(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFl107(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFl108(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFl109(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFl110(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idaccountnri
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdaccountnri(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idbudjet
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdbudjet(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for iddogovnri
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIddogovnri(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idexpence
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdexpence(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idpaymode
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdpaymode(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idpaytype
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdpaytype(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idtypeforbuch
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdtypeforbuch(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idusernri
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdusernri(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setIsavans(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for ndspay
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setNdspay(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setNumberanddatebdoc(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setPercentavans(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for purposepay
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPurposepay(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException;
/**
 * Setter method for sumpay
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumpay(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for tiprasxodov
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTiprasxodov(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setTypebasedoc(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for typedogovnri
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTypedogovnri(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for valutepay
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setValutepay(int newValue) throws java.rmi.RemoteException;
}
