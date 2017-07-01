package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEQueryLog extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
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
 * Getter method for date3
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDate3() throws java.rmi.RemoteException;
/**
 * Getter method for dec1
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getDec1() throws java.rmi.RemoteException;
/**
 * Getter method for dec2
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getDec2() throws java.rmi.RemoteException;
/**
 * Getter method for dec3
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getDec3() throws java.rmi.RemoteException;
/**
 * Getter method for errorcode
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getErrorcode() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdnriquerylog() throws java.rmi.RemoteException;
/**
 * Getter method for int1
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getInt1() throws java.rmi.RemoteException;
/**
 * Getter method for int2
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getInt2() throws java.rmi.RemoteException;
/**
 * Getter method for int3
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getInt3() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQuery getQuery() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQueryKey getQueryKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getString1() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getString2() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getString3() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getString4() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getString5() throws java.rmi.RemoteException;
/**
 * Getter method for textmsg
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTextmsg() throws java.rmi.RemoteException;
/**
 * Getter method for typemsg
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTypemsg() throws java.rmi.RemoteException;
/**
 * Getter method for typesystem
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTypesystem() throws java.rmi.RemoteException;
/**
 * Getter method for vdat
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getVdat() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetQueryKey(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException;
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
 * Setter method for date3
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDate3(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dec1
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setDec1(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dec2
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setDec2(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dec3
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setDec3(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for errorcode
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setErrorcode(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for int1
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setInt1(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for int2
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setInt2(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for int3
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setInt3(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryLog2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setString1(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setString2(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setString3(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setString4(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setString5(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for textmsg
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTextmsg(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for typemsg
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTypemsg(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for typesystem
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTypesystem(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for vdat
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setVdat(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
}
