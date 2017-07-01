package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSwitchHomeBean_dc445190
 */
public class EJSCMPSwitchHomeBean_dc445190 extends EJSHome {
	/**
	 * EJSCMPSwitchHomeBean_dc445190
	 */
	public EJSCMPSwitchHomeBean_dc445190() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Switch postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Switch) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isNumber, java.lang.Integer argNumber, java.lang.Boolean isType, java.lang.String argType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSwitchBean)persister).findByQBE(isNumber, argNumber, isType, argType, order));	}
	/**
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Boolean isNumber, java.lang.Integer argNumber, java.lang.Boolean isType, java.lang.String argType, java.lang.Boolean isPlanState, java.lang.String argPlanState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSwitchBean)persister).findByQBE2(isNumber, argNumber, isType, argType, isPlanState, argPlanState, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Switch create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Switch _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SwitchBean bean = (com.hps.july.persistence.SwitchBean) beanO.getEnterpriseBean();
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Switch findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSwitchBean_dc445190) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Switch create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition, java.lang.String argType, java.lang.Integer argNumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Switch _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SwitchBean bean = (com.hps.july.persistence.SwitchBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace, argDivision, argName, argAddress, argPosition, argType, argNumber);
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
	public com.hps.july.persistence.Switch create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Switch _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SwitchBean bean = (com.hps.july.persistence.SwitchBean) beanO.getEnterpriseBean();
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
	 * findSwitchesByResource
	 */
	public java.util.Enumeration findSwitchesByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSwitchBean)persister).findSwitchesByResource(inKey));	}
	/**
	 * findAllOrderByNameAsc
	 */
	public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSwitchBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SwitchBean tmpEJB = (com.hps.july.persistence.SwitchBean) generalEJB;
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
