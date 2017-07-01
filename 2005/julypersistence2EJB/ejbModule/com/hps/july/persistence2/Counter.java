package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Counter extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getCounterid() throws java.rmi.RemoteException;
/**
 * Getter method for counterinfo_id
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getCounterinfo_id() throws java.rmi.RemoteException;
/**
 * Getter method for cstate
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getCstate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDismantling_date() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getDismantling_reason() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getDismantling_set() throws java.rmi.RemoteException;
/**
 * Getter method for initial_settings
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getInitial_settings() throws java.rmi.RemoteException;
/**
 * Getter method for installation_date
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getInstallation_date() throws java.rmi.RemoteException;
/**
 * Getter method for last_verification
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getLast_verification() throws java.rmi.RemoteException;
/**
 * Getter method for modified_date
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getModified_date() throws java.rmi.RemoteException;
/**
 * Getter method for modifiedby
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getModifiedby() throws java.rmi.RemoteException;
/**
 * Getter method for next_verification
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getNext_verification() throws java.rmi.RemoteException;
/**
 * Getter method for nextid
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getNextid() throws java.rmi.RemoteException;
/**
 * Getter method for place_info
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPlace_info() throws java.rmi.RemoteException;
/**
 * Getter method for positionid
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getPositionid() throws java.rmi.RemoteException;
/**
 * Getter method for production_year
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getProduction_year() throws java.rmi.RemoteException;
/**
 * Getter method for replace_date
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getReplace_date() throws java.rmi.RemoteException;
/**
 * Getter method for replace_reason
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getReplace_reason() throws java.rmi.RemoteException;
/**
 * Getter method for replace_settings
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getReplace_settings() throws java.rmi.RemoteException;
/**
 * Getter method for vendor_number
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getVendor_number() throws java.rmi.RemoteException;
/**
 * Setter method for counterinfo_id
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setCounterinfo_id(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for cstate
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setCstate(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDismantling_date(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setDismantling_reason(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setDismantling_set(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for initial_settings
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setInitial_settings(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for installation_date
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setInstallation_date(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for last_verification
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setLast_verification(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for modified_date
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setModified_date(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for modifiedby
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setModifiedby(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for next_verification
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setNext_verification(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nextid
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setNextid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for place_info
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPlace_info(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for positionid
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setPositionid(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for production_year
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setProduction_year(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for replace_date
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setReplace_date(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for replace_reason
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setReplace_reason(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for replace_settings
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setReplace_settings(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for vendor_number
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setVendor_number(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: isVendorPowerSupply
	 */
	public java.lang.Boolean getIsVendorPowerSupply() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: isVendorPowerSupply
	 */
	public void setIsVendorPowerSupply(java.lang.Boolean newIsVendorPowerSupply) throws java.rmi.RemoteException;
}
