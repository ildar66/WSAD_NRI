package com.hps.july.config.beans;
/**
 * Remote interface for Enterprise Bean: CfgStoragecard
 */
public interface CfgStoragecard extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: resource
	 */
	public int getResource() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: resource
	 */
	public void setResource(int newResource) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: dateopened
	 */
	public java.sql.Date getDateopened() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: dateopened
	 */
	public void setDateopened(java.sql.Date newDateopened)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: owner
	 */
	public int getOwner() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: owner
	 */
	public void setOwner(int newOwner) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: policy
	 */
	public java.lang.String getPolicy() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: policy
	 */
	public void setPolicy(java.lang.String newPolicy)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: closed
	 */
	public java.lang.String getClosed() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: closed
	 */
	public void setClosed(java.lang.String newClosed)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: qty
	 */
	public java.math.BigDecimal getQty() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: qty
	 */
	public void setQty(java.math.BigDecimal newQty)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: price
	 */
	public java.math.BigDecimal getPrice() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: price
	 */
	public void setPrice(java.math.BigDecimal newPrice)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: boxed
	 */
	public java.lang.Boolean getBoxed() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: boxed
	 */
	public void setBoxed(java.lang.Boolean newBoxed)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: document
	 */
	public java.lang.Integer getDocument() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: document
	 */
	public void setDocument(java.lang.Integer newDocument)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: broken
	 */
	public java.lang.Boolean getBroken() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: broken
	 */
	public void setBroken(java.lang.Boolean newBroken)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: storageplace
	 */
	public java.lang.Integer getStorageplace() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: storageplace
	 */
	public void setStorageplace(java.lang.Integer newStorageplace)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: contract
	 */
	public java.lang.Integer getContract() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: contract
	 */
	public void setContract(java.lang.Integer newContract)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: dateclosed
	 */
	public java.sql.Date getDateclosed() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: dateclosed
	 */
	public void setDateclosed(java.sql.Date newDateclosed)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: i13ndate
	 */
	public java.sql.Date getI13ndate() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: i13ndate
	 */
	public void setI13ndate(java.sql.Date newI13ndate)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: serialnumber
	 */
	public java.lang.String getSerialnumber() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: serialnumber
	 */
	public void setSerialnumber(java.lang.String newSerialnumber)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: party
	 */
	public java.lang.String getParty() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: party
	 */
	public void setParty(java.lang.String newParty)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: qty_broken
	 */
	public java.math.BigDecimal getQty_broken()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: qty_broken
	 */
	public void setQty_broken(java.math.BigDecimal newQty_broken)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: notes
	 */
	public java.lang.String getNotes() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: notes
	 */
	public void setNotes(java.lang.String newNotes)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: configuration
	 */
	public java.lang.String getConfiguration() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: configuration
	 */
	public void setConfiguration(java.lang.String newConfiguration)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: place
	 */
	public java.lang.String getPlace() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: place
	 */
	public void setPlace(java.lang.String newPlace)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: inventserial
	 */
	public java.lang.String getInventserial() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: inventserial
	 */
	public void setInventserial(java.lang.String newInventserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: comment
	 */
	public java.lang.String getComment() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: comment
	 */
	public void setComment(java.lang.String newComment)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: isfictserial
	 */
	public boolean isIsfictserial() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: isfictserial
	 */
	public void setIsfictserial(boolean newIsfictserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: isapproved
	 */
	public boolean isIsapproved() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: isapproved
	 */
	public void setIsapproved(boolean newIsapproved)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: localserial
	 */
	public java.lang.String getLocalserial() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: localserial
	 */
	public void setLocalserial(java.lang.String newLocalserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: ObjectStatus
	 */
	public java.lang.String getObjectStatus() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: ObjectStatus
	 */
	public void setObjectStatus(java.lang.String newObjectStatus)
		throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getSavconfigid() throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getStoragecard() throws java.rmi.RemoteException;
}
