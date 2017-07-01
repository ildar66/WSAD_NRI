package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface OfficeMemoPos extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for cardamount
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getCardamount() throws java.rmi.RemoteException;
/**
 * Getter method for cardname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCardname() throws java.rmi.RemoteException;
/**
 * Getter method for comcardcnt
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getComcardcnt() throws java.rmi.RemoteException;
/**
 * Getter method for defectdescr
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDefectdescr() throws java.rmi.RemoteException;
/**
 * Getter method for enddate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getEnddate() throws java.rmi.RemoteException;
/**
 * Getter method for equipcnt
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getEquipcnt() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getEquipcode() throws java.rmi.RemoteException;
/**
 * Getter method for equipname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getEquipname() throws java.rmi.RemoteException;
/**
 * Getter method for idheader
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIdheader() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdpos() throws java.rmi.RemoteException;
/**
 * Getter method for isgarantie
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getIsgarantie() throws java.rmi.RemoteException;
/**
 * Getter method for opertype
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getOpertype() throws java.rmi.RemoteException;
/**
 * Getter method for phoneNumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPhoneNumber() throws java.rmi.RemoteException;
/**
 * Getter method for service
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getService() throws java.rmi.RemoteException;
/**
 * Getter method for simcardcnt
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getSimcardcnt() throws java.rmi.RemoteException;
/**
 * Getter method for startdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getStartdate() throws java.rmi.RemoteException;
/**
 * Getter method for tarifplan
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTarifplan() throws java.rmi.RemoteException;
/**
 * Setter method for cardamount
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setCardamount(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for cardname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCardname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for comcardcnt
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setComcardcnt(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for defectdescr
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDefectdescr(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for enddate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setEnddate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for equipcnt
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setEquipcnt(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setEquipcode(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for equipname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setEquipname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idheader
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdheader(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for isgarantie
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIsgarantie(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for opertype
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setOpertype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for phoneNumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPhoneNumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for service
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setService(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for simcardcnt
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setSimcardcnt(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for startdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setStartdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for tarifplan
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTarifplan(java.lang.String newValue) throws java.rmi.RemoteException;
}
