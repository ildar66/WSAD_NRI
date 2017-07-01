package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBeenetObjectHomeBean_f8cb309f
 */
public class EJSCMPBeenetObjectHomeBean_f8cb309f extends EJSHome {
	/**
	 * EJSCMPBeenetObjectHomeBean_f8cb309f
	 */
	public EJSCMPBeenetObjectHomeBean_f8cb309f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.BeenetObject postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.BeenetObject) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.BeenetObject create(java.lang.String argBeenetid, int argCategId, int argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.BeenetObject _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.BeenetObjectBean bean = (com.hps.july.persistence2.BeenetObjectBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argBeenetid, argCategId, argPosition);
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
	public com.hps.july.persistence2.BeenetObject findByPrimaryKey(com.hps.july.persistence2.BeenetObjectKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPBeenetObjectBean_f8cb309f) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.BeenetObjectBean tmpEJB = (com.hps.july.persistence2.BeenetObjectBean) generalEJB;
		com.hps.july.persistence2.BeenetObjectKey keyClass = new com.hps.july.persistence2.BeenetObjectKey();
		keyClass.beenetid = tmpEJB.beenetid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.BeenetObjectKey keyFromFields(java.lang.String f0) {
		com.hps.july.persistence2.BeenetObjectKey keyClass = new com.hps.july.persistence2.BeenetObjectKey();
		keyClass.beenetid = f0;
		return keyClass;
	}
}
