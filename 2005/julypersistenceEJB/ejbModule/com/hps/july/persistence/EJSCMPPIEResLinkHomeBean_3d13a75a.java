package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEResLinkHomeBean_3d13a75a
 */
public class EJSCMPPIEResLinkHomeBean_3d13a75a extends EJSHome {
	/**
	 * EJSCMPPIEResLinkHomeBean_3d13a75a
	 */
	public EJSCMPPIEResLinkHomeBean_3d13a75a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEResLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEResLink) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEResLink create(int argIdresnri, int argOwner, java.lang.String argIdResPlatinum, java.sql.Timestamp argVdat, java.lang.Boolean argFlagMainLink) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEResLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEResLinkBean bean = (com.hps.july.persistence.PIEResLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdresnri, argOwner, argIdResPlatinum, argVdat, argFlagMainLink);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByIdresnriAndOwner
	 */
	public java.util.Enumeration findByIdresnriAndOwner(java.lang.Integer argIdresNri, java.lang.Integer argOwner) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEResLinkBean)persister).findByIdresnriAndOwner(argIdresNri, argOwner));	}
	/**
	 * findPIEResLinksByResplatinum
	 */
	public java.util.Enumeration findPIEResLinksByResplatinum(com.hps.july.persistence.PIEResPlatinumKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEResLinkBean)persister).findPIEResLinksByResplatinum(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEResLink create(int argIdresnri, int argOwner, java.lang.String argIdResPlatinum, java.sql.Timestamp argVdat) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEResLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEResLinkBean bean = (com.hps.july.persistence.PIEResLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdresnri, argOwner, argIdResPlatinum, argVdat);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PIEResLink findByPrimaryKey(com.hps.july.persistence.PIEResLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEResLinkBean_3d13a75a) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEResLinkBean tmpEJB = (com.hps.july.persistence.PIEResLinkBean) generalEJB;
		com.hps.july.persistence.PIEResLinkKey keyClass = new com.hps.july.persistence.PIEResLinkKey();
		keyClass.idresnri = tmpEJB.idresnri;
		keyClass.resplatinum_idresplatinum = tmpEJB.resplatinum_idresplatinum;
		keyClass.resplatinum_owner = tmpEJB.resplatinum_owner;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEResLinkKey keyFromFields(int f0, java.lang.String f1, java.lang.Integer f2) {
		com.hps.july.persistence.PIEResLinkKey keyClass = new com.hps.july.persistence.PIEResLinkKey();
		keyClass.idresnri = f0;
		keyClass.resplatinum_idresplatinum = f1;
		keyClass.resplatinum_owner = f2;
		return keyClass;
	}
}
