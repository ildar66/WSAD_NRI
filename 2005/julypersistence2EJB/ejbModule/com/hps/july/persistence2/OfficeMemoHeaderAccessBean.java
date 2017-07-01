package com.hps.july.persistence2;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * OfficeMemoHeaderAccessBean
 * @generated
 */
public class OfficeMemoHeaderAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence2.OfficeMemoHeaderAccessBeanData {
	/**
	 * @generated
	 */
	private OfficeMemoHeader __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_idheader;
	/**
	 * getFilename
	 * @generated
	 */
	public java.lang.String getFilename()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("filename")));
	}
	/**
	 * setFilename
	 * @generated
	 */
	public void setFilename(java.lang.String newValue) {
		__setCache("filename", newValue);
	}
	/**
	 * getState
	 * @generated
	 */
	public java.lang.String getState()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("state")));
	}
	/**
	 * setState
	 * @generated
	 */
	public void setState(java.lang.String newValue) {
		__setCache("state", newValue);
	}
	/**
	 * getMan
	 * @generated
	 */
	public int getMan()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("man")).intValue());
	}
	/**
	 * setMan
	 * @generated
	 */
	public void setMan(int newValue) {
		__setCache("man", new Integer(newValue));
	}
	/**
	 * getDate
	 * @generated
	 */
	public java.sql.Date getDate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("date")));
	}
	/**
	 * setDate
	 * @generated
	 */
	public void setDate(java.sql.Date newValue) {
		__setCache("date", newValue);
	}
	/**
	 * getNumber
	 * @generated
	 */
	public java.lang.String getNumber()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("number")));
	}
	/**
	 * setNumber
	 * @generated
	 */
	public void setNumber(java.lang.String newValue) {
		__setCache("number", newValue);
	}
	/**
	 * getUsetype
	 * @generated
	 */
	public java.lang.String getUsetype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("usetype")));
	}
	/**
	 * setUsetype
	 * @generated
	 */
	public void setUsetype(java.lang.String newValue) {
		__setCache("usetype", newValue);
	}
	/**
	 * getTarget
	 * @generated
	 */
	public int getTarget()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("target")).intValue());
	}
	/**
	 * setTarget
	 * @generated
	 */
	public void setTarget(int newValue) {
		__setCache("target", new Integer(newValue));
	}
	/**
	 * getAbonentContract
	 * @generated
	 */
	public int getAbonentContract()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("abonentContract")).intValue());
	}
	/**
	 * setAbonentContract
	 * @generated
	 */
	public void setAbonentContract(int newValue) {
		__setCache("abonentContract", new Integer(newValue));
	}
	/**
	 * getLeasebill
	 * @generated
	 */
	public java.lang.Integer getLeasebill()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("leasebill")));
	}
	/**
	 * setLeasebill
	 * @generated
	 */
	public void setLeasebill(java.lang.Integer newValue) {
		__setCache("leasebill", newValue);
	}
	/**
	 * getType
	 * @generated
	 */
	public java.lang.String getType()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("type")));
	}
	/**
	 * setType
	 * @generated
	 */
	public void setType(java.lang.String newValue) {
		__setCache("type", newValue);
	}
	/**
	 * getIdheader
	 * @generated
	 */
	public int getIdheader()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("idheader")).intValue());
	}
	/**
	 * getArendaContract
	 * @generated
	 */
	public java.lang.Integer getArendaContract()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("arendaContract")));
	}
	/**
	 * setArendaContract
	 * @generated
	 */
	public void setArendaContract(java.lang.Integer newValue) {
		__setCache("arendaContract", newValue);
	}
	/**
	 * getTo
	 * @generated
	 */
	public java.lang.String getTo()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("to")));
	}
	/**
	 * setTo
	 * @generated
	 */
	public void setTo(java.lang.String newValue) {
		__setCache("to", newValue);
	}
	/**
	 * getFrom
	 * @generated
	 */
	public java.lang.String getFrom()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("from")));
	}
	/**
	 * setFrom
	 * @generated
	 */
	public void setFrom(java.lang.String newValue) {
		__setCache("from", newValue);
	}
	/**
	 * setInitKey_idheader
	 * @generated
	 */
	public void setInitKey_idheader(int newValue) {
		this.initKey_idheader = (newValue);
	}
	/**
	 * OfficeMemoHeaderAccessBean
	 * @generated
	 */
	public OfficeMemoHeaderAccessBean() {
		super();
	}
	/**
	 * OfficeMemoHeaderAccessBean
	 * @generated
	 */
	public OfficeMemoHeaderAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "com/hps/july/persistence2/OfficeMemoHeader";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence2.OfficeMemoHeaderHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence2
				.OfficeMemoHeaderHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence2.OfficeMemoHeaderHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence2.OfficeMemoHeader ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.persistence2
						.OfficeMemoHeader) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence2.OfficeMemoHeader.class);

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

		com.hps.july.persistence2.OfficeMemoHeaderKey key =
			keyFromFields(initKey_idheader);
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
			com.hps.july.persistence2.OfficeMemoHeaderKey pKey =
				(com.hps.july.persistence2.OfficeMemoHeaderKey) this.__getKey();
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
	private com.hps.july.persistence2.OfficeMemoHeaderKey keyFromFields(
		int f0) {
		com.hps.july.persistence2.OfficeMemoHeaderKey keyClass =
			new com.hps.july.persistence2.OfficeMemoHeaderKey();
		keyClass.idheader = f0;
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
	 * OfficeMemoHeaderAccessBean
	 * @generated
	 */
	public OfficeMemoHeaderAccessBean(
		int argIdheader,
		int argAbonentContract,
		java.lang.String argNumber,
		java.sql.Date argDate,
		int argMan,
		java.lang.String argType,
		int argTarget)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argIdheader,
				argAbonentContract,
				argNumber,
				argDate,
				argMan,
				argType,
				argTarget);
	}
}
