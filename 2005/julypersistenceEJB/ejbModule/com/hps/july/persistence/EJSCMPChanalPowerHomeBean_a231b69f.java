package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPChanalPowerHomeBean_a231b69f
 */
public class EJSCMPChanalPowerHomeBean_a231b69f extends EJSHome {
	/**
	 * EJSCMPChanalPowerHomeBean_a231b69f
	 */
	public EJSCMPChanalPowerHomeBean_a231b69f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ChanalPower postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ChanalPower) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ChanalPower create(int argEquipment, int argChanal, java.lang.String argPolarization, int argBand, int argPower) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ChanalPower _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ChanalPowerBean bean = (com.hps.july.persistence.ChanalPowerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argEquipment, argChanal, argPolarization, argBand, argPower);
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
	public com.hps.july.persistence.ChanalPower create(int argEquipment, int argChanal, java.lang.String argPolarization, int argPower) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ChanalPower _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ChanalPowerBean bean = (com.hps.july.persistence.ChanalPowerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argEquipment, argChanal, argPolarization, argPower);
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
	public com.hps.july.persistence.ChanalPower findByPrimaryKey(com.hps.july.persistence.ChanalPowerKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPChanalPowerBean_a231b69f) persister).findByPrimaryKey(key);
	}
	/**
	 * findChanalPowersByBasestation
	 */
	public java.util.Enumeration findChanalPowersByBasestation(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderChanalPowerBean)persister).findChanalPowersByBasestation(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ChanalPowerBean tmpEJB = (com.hps.july.persistence.ChanalPowerBean) generalEJB;
		com.hps.july.persistence.ChanalPowerKey keyClass = new com.hps.july.persistence.ChanalPowerKey();
		keyClass.polarization = tmpEJB.polarization;
		keyClass.band = tmpEJB.band;
		keyClass.chanal = tmpEJB.chanal;
		keyClass.basestation_storageplace = tmpEJB.basestation_storageplace;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ChanalPowerKey keyFromFields(java.lang.String f0, int f1, int f2, java.lang.Integer f3) {
		com.hps.july.persistence.ChanalPowerKey keyClass = new com.hps.july.persistence.ChanalPowerKey();
		keyClass.polarization = f0;
		keyClass.band = f1;
		keyClass.chanal = f2;
		keyClass.basestation_storageplace = f3;
		return keyClass;
	}
}
