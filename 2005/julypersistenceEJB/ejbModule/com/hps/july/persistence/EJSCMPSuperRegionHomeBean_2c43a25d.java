package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSuperRegionHomeBean_2c43a25d
 */
public class EJSCMPSuperRegionHomeBean_2c43a25d extends EJSHome {
	/**
	 * EJSCMPSuperRegionHomeBean_2c43a25d
	 */
	public EJSCMPSuperRegionHomeBean_2c43a25d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SuperRegion postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SuperRegion) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.SuperRegion create(int argSupregid, java.lang.String argSupregname, int argSupregcode) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SuperRegion _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SuperRegionBean bean = (com.hps.july.persistence.SuperRegionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSupregid, argSupregname, argSupregcode);
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
	 * create
	 */
	public com.hps.july.persistence.SuperRegion create(int argSupregid, java.lang.String argSupregname) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SuperRegion _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SuperRegionBean bean = (com.hps.july.persistence.SuperRegionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSupregid, argSupregname);
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
	public com.hps.july.persistence.SuperRegion findByPrimaryKey(com.hps.july.persistence.SuperRegionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSuperRegionBean_2c43a25d) persister).findByPrimaryKey(key);
	}
	/**
	 * findAllOrderByCodeAsc
	 */
	public java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSuperRegionBean)persister).findAllOrderByCodeAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SuperRegionBean tmpEJB = (com.hps.july.persistence.SuperRegionBean) generalEJB;
		com.hps.july.persistence.SuperRegionKey keyClass = new com.hps.july.persistence.SuperRegionKey();
		keyClass.supregid = tmpEJB.supregid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SuperRegionKey keyFromFields(int f0) {
		com.hps.july.persistence.SuperRegionKey keyClass = new com.hps.july.persistence.SuperRegionKey();
		keyClass.supregid = f0;
		return keyClass;
	}
}
