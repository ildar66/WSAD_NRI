package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPControllerHomeBean_7e6b4ceb
 */
public class EJSCMPControllerHomeBean_7e6b4ceb extends EJSHome {
	/**
	 * EJSCMPControllerHomeBean_7e6b4ceb
	 */
	public EJSCMPControllerHomeBean_7e6b4ceb() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Controller postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Controller) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Controller create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition, java.lang.Integer argNumber, java.lang.String argCName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Controller _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ControllerBean bean = (com.hps.july.persistence.ControllerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace, argDivision, argName, argAddress, argPosition, argNumber, argCName);
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
	 * findControllerBySwitch
	 */
	public java.util.Enumeration findControllerBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderControllerBean)persister).findControllerBySwitch(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Controller create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Controller _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ControllerBean bean = (com.hps.july.persistence.ControllerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace, argDivision, argName, argAddress);
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
	 * findControllersByResource
	 */
	public java.util.Enumeration findControllersByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderControllerBean)persister).findControllersByResource(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Controller findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPControllerBean_7e6b4ceb) persister).findByPrimaryKey(key);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isNumber, java.lang.Integer argNumber, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isSwitch, java.lang.Integer argSwitch, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderControllerBean)persister).findByQBE(isNumber, argNumber, isName, argName, isSwitch, argSwitch, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Controller create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Controller _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ControllerBean bean = (com.hps.july.persistence.ControllerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argStorageplace);
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
return super.getEnumeration(((com.hps.july.persistence.EJSFinderControllerBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ControllerBean tmpEJB = (com.hps.july.persistence.ControllerBean) generalEJB;
		com.hps.july.persistence.StoragePlaceKey keyClass = new com.hps.july.persistence.StoragePlaceKey();
		keyClass.storageplace = tmpEJB.storageplace;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.StoragePlaceKey keyFromFields(int f0) {
		com.hps.july.persistence.StoragePlaceKey keyClass = new com.hps.july.persistence.StoragePlaceKey();
		keyClass.storageplace = f0;
		return keyClass;
	}
}
