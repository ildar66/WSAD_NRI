package com.hps.july.persistence2;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * UserRequestsAccessBean
 * @generated
 */
public class UserRequestsAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence2.UserRequestsAccessBeanData {
	/**
	 * @generated
	 */
	private UserRequests __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_request;
	/**
	 * getModule
	 * @generated
	 */
	public int getModule()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("module")).intValue());
	}
	/**
	 * setModule
	 * @generated
	 */
	public void setModule(int newValue) {
		__setCache("module", new Integer(newValue));
	}
	/**
	 * getRequesttype
	 * @generated
	 */
	public int getRequesttype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("requesttype")).intValue());
	}
	/**
	 * setRequesttype
	 * @generated
	 */
	public void setRequesttype(int newValue) {
		__setCache("requesttype", new Integer(newValue));
	}
	/**
	 * getWorker
	 * @generated
	 */
	public int getWorker()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("worker")).intValue());
	}
	/**
	 * setWorker
	 * @generated
	 */
	public void setWorker(int newValue) {
		__setCache("worker", new Integer(newValue));
	}
	/**
	 * getRequest
	 * @generated
	 */
	public int getRequest()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("request")).intValue());
	}
	/**
	 * setRequest
	 * @generated
	 */
	public void setRequest(int newValue) {
		__setCache("request", new Integer(newValue));
	}
	/**
	 * getStatus
	 * @generated
	 */
	public java.lang.String getStatus()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("status")));
	}
	/**
	 * setStatus
	 * @generated
	 */
	public void setStatus(java.lang.String newValue) {
		__setCache("status", newValue);
	}
	/**
	 * getSupregid
	 * @generated
	 */
	public java.lang.Integer getSupregid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("supregid")));
	}
	/**
	 * setSupregid
	 * @generated
	 */
	public void setSupregid(java.lang.Integer newValue) {
		__setCache("supregid", newValue);
	}
	/**
	 * getDatetimein
	 * @generated
	 */
	public java.sql.Date getDatetimein()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("datetimein")));
	}
	/**
	 * setDatetimein
	 * @generated
	 */
	public void setDatetimein(java.sql.Date newValue) {
		__setCache("datetimein", newValue);
	}
	/**
	 * getRfcnum
	 * @generated
	 */
	public java.lang.String getRfcnum()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("rfcnum")));
	}
	/**
	 * setRfcnum
	 * @generated
	 */
	public void setRfcnum(java.lang.String newValue) {
		__setCache("rfcnum", newValue);
	}
	/**
	 * getRegionid
	 * @generated
	 */
	public java.lang.Integer getRegionid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("regionid")));
	}
	/**
	 * setRegionid
	 * @generated
	 */
	public void setRegionid(java.lang.Integer newValue) {
		__setCache("regionid", newValue);
	}
	/**
	 * getDescription
	 * @generated
	 */
	public java.lang.String getDescription()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("description")));
	}
	/**
	 * setDescription
	 * @generated
	 */
	public void setDescription(java.lang.String newValue) {
		__setCache("description", newValue);
	}
	/**
	 * getFilialtype
	 * @generated
	 */
	public int getFilialtype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("filialtype")).intValue());
	}
	/**
	 * setFilialtype
	 * @generated
	 */
	public void setFilialtype(int newValue) {
		__setCache("filialtype", new Integer(newValue));
	}
	/**
	 * setInitKey_request
	 * @generated
	 */
	public void setInitKey_request(int newValue) {
		this.initKey_request = (newValue);
	}
	/**
	 * UserRequestsAccessBean
	 * @generated
	 */
	public UserRequestsAccessBean() {
		super();
	}
	/**
	 * UserRequestsAccessBean
	 * @generated
	 */
	public UserRequestsAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence2/UserRequestsHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence2.UserRequestsHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence2
				.UserRequestsHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence2.UserRequestsHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence2.UserRequests ejbRef()
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
						.UserRequests) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence2.UserRequests.class);

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

		com.hps.july.persistence2.UserRequestsKey key =
			keyFromFields(initKey_request);
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
			com.hps.july.persistence2.UserRequestsKey pKey =
				(com.hps.july.persistence2.UserRequestsKey) this.__getKey();
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
	private com.hps.july.persistence2.UserRequestsKey keyFromFields(int f0) {
		com.hps.july.persistence2.UserRequestsKey keyClass =
			new com.hps.july.persistence2.UserRequestsKey();
		keyClass.request = f0;
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
	 * UserRequestsAccessBean
	 * @generated
	 */
	public UserRequestsAccessBean(
		int argRequest,
		java.sql.Date argDatetimein,
		int argRequesttype,
		int argFilialtype,
		int argWorker,
		int argModule,
		java.lang.String argDescr,
		java.lang.String argStatus)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argRequest,
				argDatetimein,
				argRequesttype,
				argFilialtype,
				argWorker,
				argModule,
				argDescr,
				argStatus);
	}
}
