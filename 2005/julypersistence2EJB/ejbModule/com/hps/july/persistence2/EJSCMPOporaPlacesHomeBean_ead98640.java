package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOporaPlacesHomeBean_ead98640
 */
public class EJSCMPOporaPlacesHomeBean_ead98640 extends EJSHome {
	/**
	 * EJSCMPOporaPlacesHomeBean_ead98640
	 */
	public EJSCMPOporaPlacesHomeBean_ead98640() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.OporaPlaces postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.OporaPlaces) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.OporaPlaces create(int argOplaceid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.OporaPlaces _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.OporaPlacesBean bean = (com.hps.july.persistence2.OporaPlacesBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOplaceid, argName);
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
	public com.hps.july.persistence2.OporaPlaces findByPrimaryKey(com.hps.july.persistence2.OporaPlacesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPOporaPlacesBean_ead98640) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.OporaPlacesBean tmpEJB = (com.hps.july.persistence2.OporaPlacesBean) generalEJB;
		com.hps.july.persistence2.OporaPlacesKey keyClass = new com.hps.july.persistence2.OporaPlacesKey();
		keyClass.oplaceid = tmpEJB.oplaceid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.OporaPlacesKey keyFromFields(int f0) {
		com.hps.july.persistence2.OporaPlacesKey keyClass = new com.hps.july.persistence2.OporaPlacesKey();
		keyClass.oplaceid = f0;
		return keyClass;
	}
}
