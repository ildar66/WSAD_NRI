package com.hps.july.config.beans;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgStoragecardAccessBean
 * @generated
 */
public class CfgStoragecardAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.config.beans.CfgStoragecardAccessBeanData {
	/**
	 * @generated
	 */
	private CfgStoragecard __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_savconfigid;
	/**
	 * @generated
	 */
	private int initKey_storagecard;
	/**
	 * getOwner
	 * @generated
	 */
	public int getOwner()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("owner")).intValue());
	}
	/**
	 * setOwner
	 * @generated
	 */
	public void setOwner(int newValue) {
		__setCache("owner", new Integer(newValue));
	}
	/**
	 * getI13ndate
	 * @generated
	 */
	public java.sql.Date getI13ndate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("i13ndate")));
	}
	/**
	 * setI13ndate
	 * @generated
	 */
	public void setI13ndate(java.sql.Date newValue) {
		__setCache("i13ndate", newValue);
	}
	/**
	 * getComment
	 * @generated
	 */
	public java.lang.String getComment()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("comment")));
	}
	/**
	 * setComment
	 * @generated
	 */
	public void setComment(java.lang.String newValue) {
		__setCache("comment", newValue);
	}
	/**
	 * getBroken
	 * @generated
	 */
	public java.lang.Boolean getBroken()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("broken")));
	}
	/**
	 * setBroken
	 * @generated
	 */
	public void setBroken(java.lang.Boolean newValue) {
		__setCache("broken", newValue);
	}
	/**
	 * getResource
	 * @generated
	 */
	public int getResource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("resource")).intValue());
	}
	/**
	 * setResource
	 * @generated
	 */
	public void setResource(int newValue) {
		__setCache("resource", new Integer(newValue));
	}
	/**
	 * isIsapproved
	 * @generated
	 */
	public boolean isIsapproved()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("isapproved")).booleanValue());
	}
	/**
	 * setIsapproved
	 * @generated
	 */
	public void setIsapproved(boolean newValue) {
		__setCache("isapproved", new Boolean(newValue));
	}
	/**
	 * getDateclosed
	 * @generated
	 */
	public java.sql.Date getDateclosed()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("dateclosed")));
	}
	/**
	 * setDateclosed
	 * @generated
	 */
	public void setDateclosed(java.sql.Date newValue) {
		__setCache("dateclosed", newValue);
	}
	/**
	 * getClosed
	 * @generated
	 */
	public java.lang.String getClosed()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("closed")));
	}
	/**
	 * setClosed
	 * @generated
	 */
	public void setClosed(java.lang.String newValue) {
		__setCache("closed", newValue);
	}
	/**
	 * getStorageplace
	 * @generated
	 */
	public java.lang.Integer getStorageplace()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("storageplace")));
	}
	/**
	 * setStorageplace
	 * @generated
	 */
	public void setStorageplace(java.lang.Integer newValue) {
		__setCache("storageplace", newValue);
	}
	/**
	 * getSerialnumber
	 * @generated
	 */
	public java.lang.String getSerialnumber()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("serialnumber")));
	}
	/**
	 * setSerialnumber
	 * @generated
	 */
	public void setSerialnumber(java.lang.String newValue) {
		__setCache("serialnumber", newValue);
	}
	/**
	 * getPlace
	 * @generated
	 */
	public java.lang.String getPlace()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("place")));
	}
	/**
	 * setPlace
	 * @generated
	 */
	public void setPlace(java.lang.String newValue) {
		__setCache("place", newValue);
	}
	/**
	 * getQty_broken
	 * @generated
	 */
	public java.math.BigDecimal getQty_broken()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("qty_broken")));
	}
	/**
	 * setQty_broken
	 * @generated
	 */
	public void setQty_broken(java.math.BigDecimal newValue) {
		__setCache("qty_broken", newValue);
	}
	/**
	 * getQty
	 * @generated
	 */
	public java.math.BigDecimal getQty()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("qty")));
	}
	/**
	 * setQty
	 * @generated
	 */
	public void setQty(java.math.BigDecimal newValue) {
		__setCache("qty", newValue);
	}
	/**
	 * getLocalserial
	 * @generated
	 */
	public java.lang.String getLocalserial()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("localserial")));
	}
	/**
	 * setLocalserial
	 * @generated
	 */
	public void setLocalserial(java.lang.String newValue) {
		__setCache("localserial", newValue);
	}
	/**
	 * getConfiguration
	 * @generated
	 */
	public java.lang.String getConfiguration()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("configuration")));
	}
	/**
	 * setConfiguration
	 * @generated
	 */
	public void setConfiguration(java.lang.String newValue) {
		__setCache("configuration", newValue);
	}
	/**
	 * getNotes
	 * @generated
	 */
	public java.lang.String getNotes()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("notes")));
	}
	/**
	 * setNotes
	 * @generated
	 */
	public void setNotes(java.lang.String newValue) {
		__setCache("notes", newValue);
	}
	/**
	 * getPolicy
	 * @generated
	 */
	public java.lang.String getPolicy()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("policy")));
	}
	/**
	 * setPolicy
	 * @generated
	 */
	public void setPolicy(java.lang.String newValue) {
		__setCache("policy", newValue);
	}
	/**
	 * getParty
	 * @generated
	 */
	public java.lang.String getParty()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("party")));
	}
	/**
	 * setParty
	 * @generated
	 */
	public void setParty(java.lang.String newValue) {
		__setCache("party", newValue);
	}
	/**
	 * getDocument
	 * @generated
	 */
	public java.lang.Integer getDocument()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("document")));
	}
	/**
	 * setDocument
	 * @generated
	 */
	public void setDocument(java.lang.Integer newValue) {
		__setCache("document", newValue);
	}
	/**
	 * getBoxed
	 * @generated
	 */
	public java.lang.Boolean getBoxed()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("boxed")));
	}
	/**
	 * setBoxed
	 * @generated
	 */
	public void setBoxed(java.lang.Boolean newValue) {
		__setCache("boxed", newValue);
	}
	/**
	 * getInventserial
	 * @generated
	 */
	public java.lang.String getInventserial()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("inventserial")));
	}
	/**
	 * setInventserial
	 * @generated
	 */
	public void setInventserial(java.lang.String newValue) {
		__setCache("inventserial", newValue);
	}
	/**
	 * getContract
	 * @generated
	 */
	public java.lang.Integer getContract()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("contract")));
	}
	/**
	 * setContract
	 * @generated
	 */
	public void setContract(java.lang.Integer newValue) {
		__setCache("contract", newValue);
	}
	/**
	 * getPrice
	 * @generated
	 */
	public java.math.BigDecimal getPrice()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("price")));
	}
	/**
	 * setPrice
	 * @generated
	 */
	public void setPrice(java.math.BigDecimal newValue) {
		__setCache("price", newValue);
	}
	/**
	 * getDateopened
	 * @generated
	 */
	public java.sql.Date getDateopened()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("dateopened")));
	}
	/**
	 * setDateopened
	 * @generated
	 */
	public void setDateopened(java.sql.Date newValue) {
		__setCache("dateopened", newValue);
	}
	/**
	 * isIsfictserial
	 * @generated
	 */
	public boolean isIsfictserial()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("isfictserial")).booleanValue());
	}
	/**
	 * setIsfictserial
	 * @generated
	 */
	public void setIsfictserial(boolean newValue) {
		__setCache("isfictserial", new Boolean(newValue));
	}
	/**
	 * getObjectStatus
	 * @generated
	 */
	public java.lang.String getObjectStatus()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("objectStatus")));
	}
	/**
	 * setObjectStatus
	 * @generated
	 */
	public void setObjectStatus(java.lang.String newValue) {
		__setCache("objectStatus", newValue);
	}
	/**
	 * getSavconfigid
	 * @generated
	 */
	public int getSavconfigid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("savconfigid")).intValue());
	}
	/**
	 * getStoragecard
	 * @generated
	 */
	public int getStoragecard()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("storagecard")).intValue());
	}
	/**
	 * setInitKey_savconfigid
	 * @generated
	 */
	public void setInitKey_savconfigid(int newValue) {
		this.initKey_savconfigid = (newValue);
	}
	/**
	 * setInitKey_storagecard
	 * @generated
	 */
	public void setInitKey_storagecard(int newValue) {
		this.initKey_storagecard = (newValue);
	}
	/**
	 * CfgStoragecardAccessBean
	 * @generated
	 */
	public CfgStoragecardAccessBean() {
		super();
	}
	/**
	 * CfgStoragecardAccessBean
	 * @generated
	 */
	public CfgStoragecardAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgStoragecardHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.config.beans.CfgStoragecardHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.config
				.beans
				.CfgStoragecardHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.config.beans.CfgStoragecardHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.config.beans.CfgStoragecard ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.config
						.beans
						.CfgStoragecard) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.config.beans.CfgStoragecard.class);

		return __ejbRef;
	}
	/**
	 * instantiateEJB
	 * @generated
	 */
	protected void instantiateEJB()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		if (ejbRef() != null)
			return;

		com.hps.july.config.beans.CfgStoragecardKey key =
			keyFromFields(initKey_savconfigid, initKey_storagecard);
		ejbRef = ejbHome().findByPrimaryKey(key);
	}
	/**
	 * instantiateEJBByPrimaryKey
	 * @generated
	 */
	protected boolean instantiateEJBByPrimaryKey()
		throws
			javax.ejb.CreateException,
			java.rmi.RemoteException,
			javax.naming.NamingException {
		boolean result = false;

		if (ejbRef() != null)
			return true;

		try {
			com.hps.july.config.beans.CfgStoragecardKey pKey =
				(com.hps.july.config.beans.CfgStoragecardKey) this.__getKey();
			if (pKey != null) {
				ejbRef = ejbHome().findByPrimaryKey(pKey);
				result = true;
			}
		} catch (javax.ejb.FinderException e) {
		}
		return result;
	}
	/**
	 * keyFromFields
	 * @generated
	 */
	private com.hps.july.config.beans.CfgStoragecardKey keyFromFields(
		int f0,
		int f1) {
		com.hps.july.config.beans.CfgStoragecardKey keyClass =
			new com.hps.july.config.beans.CfgStoragecardKey();
		keyClass.savconfigid = f0;
		keyClass.storagecard = f1;
		return keyClass;
	}
	/**
	 * refreshCopyHelper
	 * @generated
	 */
	public void refreshCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		refreshCopyHelper(ejbRef());
	}
	/**
	 * commitCopyHelper
	 * @generated
	 */
	public void commitCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		commitCopyHelper(ejbRef());
	}
	/**
	 * CfgStoragecardAccessBean
	 * @generated
	 */
	public CfgStoragecardAccessBean(
		int savconfigid,
		int storagecard,
		int resource,
		java.sql.Date dateopened,
		int owner,
		java.lang.String policy,
		java.lang.String closed,
		java.math.BigDecimal qty,
		java.math.BigDecimal price,
		boolean isfictserial,
		boolean isapproved,
		java.lang.String objectstatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				savconfigid,
				storagecard,
				resource,
				dateopened,
				owner,
				policy,
				closed,
				qty,
				price,
				isfictserial,
				isapproved,
				objectstatus);
	}
}
