package com.hps.july.persistence2;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * ConfBSNfsAccessBean
 * @generated
 */
public class ConfBSNfsAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence2.ConfBSNfsAccessBeanData {
	/**
	 * @generated
	 */
	private ConfBSNfs __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_id;
	/**
	 * getId
	 * @generated
	 */
	public int getId()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("id")).intValue());
	}
	/**
	 * getSect_h
	 * @generated
	 */
	public int getSect_h()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_h")).intValue());
	}
	/**
	 * setSect_h
	 * @generated
	 */
	public void setSect_h(int newValue) {
		__setCache("sect_h", new Integer(newValue));
	}
	/**
	 * getSect_g
	 * @generated
	 */
	public int getSect_g()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_g")).intValue());
	}
	/**
	 * setSect_g
	 * @generated
	 */
	public void setSect_g(int newValue) {
		__setCache("sect_g", new Integer(newValue));
	}
	/**
	 * getVoltage
	 * @generated
	 */
	public java.math.BigDecimal getVoltage()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("voltage")));
	}
	/**
	 * setVoltage
	 * @generated
	 */
	public void setVoltage(java.math.BigDecimal newValue) {
		__setCache("voltage", newValue);
	}
	/**
	 * getSect_f
	 * @generated
	 */
	public int getSect_f()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_f")).intValue());
	}
	/**
	 * setSect_f
	 * @generated
	 */
	public void setSect_f(int newValue) {
		__setCache("sect_f", new Integer(newValue));
	}
	/**
	 * getSect_e
	 * @generated
	 */
	public int getSect_e()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_e")).intValue());
	}
	/**
	 * setSect_e
	 * @generated
	 */
	public void setSect_e(int newValue) {
		__setCache("sect_e", new Integer(newValue));
	}
	/**
	 * getCodenri
	 * @generated
	 */
	public int getCodenri()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("codenri")).intValue());
	}
	/**
	 * setCodenri
	 * @generated
	 */
	public void setCodenri(int newValue) {
		__setCache("codenri", new Integer(newValue));
	}
	/**
	 * getSect_d
	 * @generated
	 */
	public int getSect_d()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_d")).intValue());
	}
	/**
	 * setSect_d
	 * @generated
	 */
	public void setSect_d(int newValue) {
		__setCache("sect_d", new Integer(newValue));
	}
	/**
	 * getSect_c
	 * @generated
	 */
	public int getSect_c()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_c")).intValue());
	}
	/**
	 * setSect_c
	 * @generated
	 */
	public void setSect_c(int newValue) {
		__setCache("sect_c", new Integer(newValue));
	}
	/**
	 * getSect_b
	 * @generated
	 */
	public int getSect_b()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_b")).intValue());
	}
	/**
	 * setSect_b
	 * @generated
	 */
	public void setSect_b(int newValue) {
		__setCache("sect_b", new Integer(newValue));
	}
	/**
	 * getSect_a
	 * @generated
	 */
	public int getSect_a()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_a")).intValue());
	}
	/**
	 * setSect_a
	 * @generated
	 */
	public void setSect_a(int newValue) {
		__setCache("sect_a", new Integer(newValue));
	}
	/**
	 * getNfsitem_id
	 * @generated
	 */
	public java.lang.String getNfsitem_id()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("nfsitem_id")));
	}
	/**
	 * setNfsitem_id
	 * @generated
	 */
	public void setNfsitem_id(java.lang.String newValue) {
		__setCache("nfsitem_id", newValue);
	}
	/**
	 * getConftype
	 * @generated
	 */
	public java.lang.String getConftype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("conftype")));
	}
	/**
	 * setConftype
	 * @generated
	 */
	public void setConftype(java.lang.String newValue) {
		__setCache("conftype", newValue);
	}
	/**
	 * setInitKey_id
	 * @generated
	 */
	public void setInitKey_id(int newValue) {
		this.initKey_id = (newValue);
	}
	/**
	 * ConfBSNfsAccessBean
	 * @generated
	 */
	public ConfBSNfsAccessBean() {
		super();
	}
	/**
	 * ConfBSNfsAccessBean
	 * @generated
	 */
	public ConfBSNfsAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence2/ConfBSNfsHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence2.ConfBSNfsHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence2
				.ConfBSNfsHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence2.ConfBSNfsHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence2.ConfBSNfs ejbRef()
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
						.ConfBSNfs) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence2.ConfBSNfs.class);

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

		com.hps.july.persistence2.ConfBSNfsKey key = keyFromFields(initKey_id);
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
			com.hps.july.persistence2.ConfBSNfsKey pKey =
				(com.hps.july.persistence2.ConfBSNfsKey) this.__getKey();
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
	private com.hps.july.persistence2.ConfBSNfsKey keyFromFields(int f0) {
		com.hps.july.persistence2.ConfBSNfsKey keyClass =
			new com.hps.july.persistence2.ConfBSNfsKey();
		keyClass.id = f0;
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
	 * findByAll
	 * @generated
	 */
	public java.util.Enumeration findByAll(
		java.lang.String argConfType,
		int argSectA,
		int argSectB,
		int argSectC,
		int argSectD,
		int argSectE,
		int argSectF,
		int argSectG,
		int argSectH,
		java.math.BigDecimal argVoltage,
		java.lang.String argNFSId,
		int argCodeNRI)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence2.ConfBSNfsHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByAll(
				argConfType,
				argSectA,
				argSectB,
				argSectC,
				argSectD,
				argSectE,
				argSectF,
				argSectG,
				argSectH,
				argVoltage,
				argNFSId,
				argCodeNRI);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * getSect_o900
	 * @generated
	 */
	public int getSect_o900()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_o900")).intValue());
	}
	/**
	 * setSect_o900
	 * @generated
	 */
	public void setSect_o900(int newValue) {
		__setCache("sect_o900", new Integer(newValue));
	}
	/**
	 * getSect_o1800
	 * @generated
	 */
	public int getSect_o1800()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("sect_o1800")).intValue());
	}
	/**
	 * setSect_o1800
	 * @generated
	 */
	public void setSect_o1800(int newValue) {
		__setCache("sect_o1800", new Integer(newValue));
	}
	/**
	 * ConfBSNfsAccessBean
	 * @generated
	 */
	public ConfBSNfsAccessBean(
		int argId,
		int argCodeNri,
		int argSectorA,
		int argSectorB,
		int argSectorC,
		int argSectorD,
		int argSectorE,
		int argSectorF,
		int argSectorG,
		int argSectorH,
		java.lang.String argNfsItemId,
		java.lang.String argConfType,
		int argSect_o900,
		int argSect_o1800)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argId,
				argCodeNri,
				argSectorA,
				argSectorB,
				argSectorC,
				argSectorD,
				argSectorE,
				argSectorF,
				argSectorG,
				argSectorH,
				argNfsItemId,
				argConfType,
				argSect_o900,
				argSect_o1800);
	}
}
