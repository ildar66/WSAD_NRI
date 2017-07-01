package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Sector extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antena2sector2sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntena2sectors() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for azimut
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getAzimut() throws java.rmi.RemoteException;
/**
 * 
 * @return short
 * @exception String The exception description.
 */
short getBand() throws java.rmi.RemoteException;
/**
 * Getter method for btsnumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBtsnumber() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getByhand() throws java.rmi.RemoteException;
/**
 * Getter method for capgprs
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getCapgprs() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getCellname() throws java.rmi.RemoteException;
/**
 * Getter method for conabis
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getConabis() throws java.rmi.RemoteException;
/**
 * Getter method for conf
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getConf() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDatasource() throws java.rmi.RemoteException;
/**
 * Getter method for ddk
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getDdk() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.BaseStation getEquipment() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getEquipmentKey() throws java.rmi.RemoteException;
/**
 * Getter method for hasbuster
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getHasbuster() throws java.rmi.RemoteException;
/**
 * Getter method for hasflt
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getHasflt() throws java.rmi.RemoteException;
/**
 * Getter method for haslna
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getHaslna() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdsect() throws java.rmi.RemoteException;
/**
 * Getter method for ishr
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getIshr() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getLac() throws java.rmi.RemoteException;
/**
 * Getter method for namesect
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNamesect() throws java.rmi.RemoteException;
/**
 * Getter method for numpo
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNumpo() throws java.rmi.RemoteException;
/**
 * Getter method for numsect
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNumsect() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOperator() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getPlanfacttype() throws java.rmi.RemoteException;
/**
 * Getter method for portabis
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getPortabis() throws java.rmi.RemoteException;
/**
 * Getter method for power
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getPower() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getRac() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRepiters() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for trxnum
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTrxnum() throws java.rmi.RemoteException;
/**
 * Getter method for trxnum2
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTrxnum2() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getTrxovrnum() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getTxovrsetpwr() throws java.rmi.RemoteException;
/**
 * Getter method for txpwr
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getTxpwr() throws java.rmi.RemoteException;
/**
 * Getter method for txpwr2
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getTxpwr2() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getTxsetpwr() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetEquipmentKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antena2sector2sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntena2sectors(com.hps.july.persistence.Antena2sector anAntena2sectors) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antena2sector2sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntena2sectors(com.hps.july.persistence.Antena2sector anAntena2sectors) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetEquipment(com.hps.july.persistence.BaseStation anEquipment) throws java.rmi.RemoteException;
/**
 * Setter method for azimut
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setAzimut(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue short
 * @exception String The exception description.
 */
void setBand(short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for btsnumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBtsnumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setByhand(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for capgprs
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setCapgprs(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setCellname(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for conabis
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setConabis(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for conf
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setConf(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setDatasource(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for ddk
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setDdk(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sector2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setEquipment(com.hps.july.persistence.BaseStation anEquipment) throws java.rmi.RemoteException;
/**
 * Setter method for hasbuster
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setHasbuster(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for hasflt
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setHasflt(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for haslna
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setHaslna(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for ishr
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIshr(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setLac(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for namesect
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNamesect(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for numpo
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNumpo(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for numsect
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNumsect(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newOperator java.lang.Integer
 * @exception String The exception description.
 */
void setOperator(java.lang.Integer newOperator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setPlanfacttype(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for portabis
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setPortabis(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for power
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setPower(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setRac(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for trxnum
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTrxnum(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for trxnum2
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTrxnum2(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setTrxovrnum(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setTxovrsetpwr(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for txpwr
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setTxpwr(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for txpwr2
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setTxpwr2(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setTxsetpwr(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
