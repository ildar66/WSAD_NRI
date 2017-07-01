package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPApparatPlacesHomeBean_0a67f164
 */
public class EJSCMPApparatPlacesHomeBean_0a67f164 extends EJSHome {
	/**
	 * EJSCMPApparatPlacesHomeBean_0a67f164
	 */
	public EJSCMPApparatPlacesHomeBean_0a67f164() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ApparatPlaces postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ApparatPlaces) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.ApparatPlaces create(int argApplaceid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.ApparatPlaces _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.ApparatPlacesBean bean = (com.hps.july.persistence2.ApparatPlacesBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argApplaceid, argName);
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
	public com.hps.july.persistence2.ApparatPlaces findByPrimaryKey(com.hps.july.persistence2.ApparatPlacesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPApparatPlacesBean_0a67f164) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.ApparatPlacesBean tmpEJB = (com.hps.july.persistence2.ApparatPlacesBean) generalEJB;
		com.hps.july.persistence2.ApparatPlacesKey keyClass = new com.hps.july.persistence2.ApparatPlacesKey();
		keyClass.applaceid = tmpEJB.applaceid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.ApparatPlacesKey keyFromFields(int f0) {
		com.hps.july.persistence2.ApparatPlacesKey keyClass = new com.hps.july.persistence2.ApparatPlacesKey();
		keyClass.applaceid = f0;
		return keyClass;
	}
}
