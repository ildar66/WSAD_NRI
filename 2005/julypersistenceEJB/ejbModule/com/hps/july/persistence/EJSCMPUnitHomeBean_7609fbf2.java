package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPUnitHomeBean_7609fbf2
 */
public class EJSCMPUnitHomeBean_7609fbf2 extends EJSHome {
	/**
	 * EJSCMPUnitHomeBean_7609fbf2
	 */
	public EJSCMPUnitHomeBean_7609fbf2() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Unit postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Unit) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Unit create(int argUnit) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Unit _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.UnitBean bean = (com.hps.july.persistence.UnitBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argUnit);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argUnit);
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
	public com.hps.july.persistence.Unit create(int argUnit, java.lang.String argName, java.lang.String argShortName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Unit _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.UnitBean bean = (com.hps.july.persistence.UnitBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argUnit, argName, argShortName);
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
	public com.hps.july.persistence.Unit findByPrimaryKey(com.hps.july.persistence.UnitKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPUnitBean_7609fbf2) persister).findByPrimaryKey(key);
	}
	/**
	 * findAll
	 */
	public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderUnitBean)persister).findAll());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.UnitBean tmpEJB = (com.hps.july.persistence.UnitBean) generalEJB;
		com.hps.july.persistence.UnitKey keyClass = new com.hps.july.persistence.UnitKey();
		keyClass.unit = tmpEJB.unit;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.UnitKey keyFromFields(int f0) {
		com.hps.july.persistence.UnitKey keyClass = new com.hps.july.persistence.UnitKey();
		keyClass.unit = f0;
		return keyClass;
	}
}
