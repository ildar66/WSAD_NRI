package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPNetZoneHomeBean_6ae04792
 */
public class EJSCMPNetZoneHomeBean_6ae04792 extends EJSHome {
	/**
	 * EJSCMPNetZoneHomeBean_6ae04792
	 */
	public EJSCMPNetZoneHomeBean_6ae04792() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.NetZone postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.NetZone) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.NetZone create(int argNetzone, java.lang.String argName, java.lang.String argZonecode) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.NetZone _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.NetZoneBean bean = (com.hps.july.persistence.NetZoneBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argNetzone, argName, argZonecode);
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
	public com.hps.july.persistence.NetZone create(int argNetzone, java.lang.String argName, java.lang.String argZonecode, int argRegionId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.NetZone _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.NetZoneBean bean = (com.hps.july.persistence.NetZoneBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argNetzone, argName, argZonecode, argRegionId);
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
	public com.hps.july.persistence.NetZone findByPrimaryKey(com.hps.july.persistence.NetZoneKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPNetZoneBean_6ae04792) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.NetZone create(int argNetzone, java.lang.String argName, java.lang.String argZonecode, int argRegionId, java.math.BigDecimal argTCode) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.NetZone _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.NetZoneBean bean = (com.hps.july.persistence.NetZoneBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argNetzone, argName, argZonecode, argRegionId, argTCode);
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
	public com.hps.july.persistence.NetZone create(int argNetzone) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.NetZone _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.NetZoneBean bean = (com.hps.july.persistence.NetZoneBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argNetzone);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argNetzone);
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
	 * findAllOrderByNameAsc
	 */
	public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderNetZoneBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.NetZoneBean tmpEJB = (com.hps.july.persistence.NetZoneBean) generalEJB;
		com.hps.july.persistence.NetZoneKey keyClass = new com.hps.july.persistence.NetZoneKey();
		keyClass.netzone = tmpEJB.netzone;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.NetZoneKey keyFromFields(int f0) {
		com.hps.july.persistence.NetZoneKey keyClass = new com.hps.july.persistence.NetZoneKey();
		keyClass.netzone = f0;
		return keyClass;
	}
}
