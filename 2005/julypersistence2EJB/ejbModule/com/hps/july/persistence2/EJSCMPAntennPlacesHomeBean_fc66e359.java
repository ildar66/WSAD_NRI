package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAntennPlacesHomeBean_fc66e359
 */
public class EJSCMPAntennPlacesHomeBean_fc66e359 extends EJSHome {
	/**
	 * EJSCMPAntennPlacesHomeBean_fc66e359
	 */
	public EJSCMPAntennPlacesHomeBean_fc66e359() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.AntennPlaces postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.AntennPlaces) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence2.AntennPlaces findByPrimaryKey(com.hps.july.persistence2.AntennPlacesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPAntennPlacesBean_fc66e359) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.AntennPlaces create(int argAntplaceid, java.lang.String argName, boolean argIsVc) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.AntennPlaces _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.AntennPlacesBean bean = (com.hps.july.persistence2.AntennPlacesBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAntplaceid, argName, argIsVc);
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
		com.hps.july.persistence2.AntennPlacesBean tmpEJB = (com.hps.july.persistence2.AntennPlacesBean) generalEJB;
		com.hps.july.persistence2.AntennPlacesKey keyClass = new com.hps.july.persistence2.AntennPlacesKey();
		keyClass.antplaceid = tmpEJB.antplaceid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.AntennPlacesKey keyFromFields(int f0) {
		com.hps.july.persistence2.AntennPlacesKey keyClass = new com.hps.july.persistence2.AntennPlacesKey();
		keyClass.antplaceid = f0;
		return keyClass;
	}
}
