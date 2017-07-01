package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRepiterDonorUnitsHomeBean_2f97607b
 */
public class EJSCMPRepiterDonorUnitsHomeBean_2f97607b extends EJSHome {
	/**
	 * EJSCMPRepiterDonorUnitsHomeBean_2f97607b
	 */
	public EJSCMPRepiterDonorUnitsHomeBean_2f97607b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RepiterDonorUnits postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RepiterDonorUnits) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.RepiterDonorUnits create(int resource, com.hps.july.persistence.Unit argUnit, com.hps.july.persistence.ResourceSubType argSubtype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RepiterDonorUnits _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RepiterDonorUnitsBean bean = (com.hps.july.persistence.RepiterDonorUnitsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(resource, argUnit, argSubtype);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(resource, argUnit, argSubtype);
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
	public com.hps.july.persistence.RepiterDonorUnits findByPrimaryKey(com.hps.july.persistence.ResourceKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRepiterDonorUnitsBean_2f97607b) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.RepiterDonorUnits create(int argResource, java.lang.String argName, java.lang.String argModel, java.lang.String argNotes, java.lang.Boolean argComplect, java.lang.String argCountpolicy, java.lang.Boolean argBoxable, java.lang.Boolean argPriceable, java.lang.Boolean argComplectpart, java.lang.Boolean argActive, int argSubType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RepiterDonorUnits _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RepiterDonorUnitsBean bean = (com.hps.july.persistence.RepiterDonorUnitsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResource, argName, argModel, argNotes, argComplect, argCountpolicy, argBoxable, argPriceable, argComplectpart, argActive, argSubType);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.RepiterDonorUnitsBean tmpEJB = (com.hps.july.persistence.RepiterDonorUnitsBean) generalEJB;
		com.hps.july.persistence.ResourceKey keyClass = new com.hps.july.persistence.ResourceKey();
		keyClass.resource = tmpEJB.resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ResourceKey keyFromFields(int f0) {
		com.hps.july.persistence.ResourceKey keyClass = new com.hps.july.persistence.ResourceKey();
		keyClass.resource = f0;
		return keyClass;
	}
}
