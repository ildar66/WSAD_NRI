package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: BaseStationResource
 */
public interface BaseStationResource extends com.hps.july.persistence.Resource, com.ibm.ivj.ejb.runtime.CopyHelper {










/**
 * Getter method for generation
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getGeneration() throws java.rmi.RemoteException;
/**
 * Getter method for height
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getHeight() throws java.rmi.RemoteException;
/**
 * Getter method for length
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getLength() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getMakeyear() throws java.rmi.RemoteException;
/**
 * Getter method for modification
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getModification() throws java.rmi.RemoteException;
/**
 * Getter method for productline
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getProductline() throws java.rmi.RemoteException;
/**
 * Getter method for standard
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getStandard() throws java.rmi.RemoteException;
/**
 * Getter method for width
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getWidth() throws java.rmi.RemoteException;
/**
 * Setter method for generation
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setGeneration(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for height
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setHeight(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for length
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setLength(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setMakeyear(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for modification
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setModification(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for productline
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setProductline(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for standard
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setStandard(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for width
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setWidth(java.lang.Integer newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: maxtrxcount
	 */
	public java.lang.Integer getMaxtrxcount() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: maxtrxcount
	 */
	public void setMaxtrxcount(java.lang.Integer newMaxtrxcount)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: maxsectorscount
	 */
	public java.lang.Integer getMaxsectorscount()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: maxsectorscount
	 */
	public void setMaxsectorscount(java.lang.Integer newMaxsectorscount)
		throws java.rmi.RemoteException;
}
