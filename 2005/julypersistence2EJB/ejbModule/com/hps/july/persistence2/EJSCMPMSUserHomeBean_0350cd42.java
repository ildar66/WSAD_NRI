package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPMSUserHomeBean_0350cd42
 */
public class EJSCMPMSUserHomeBean_0350cd42 extends EJSHome {
	/**
	 * EJSCMPMSUserHomeBean_0350cd42
	 */
	public EJSCMPMSUserHomeBean_0350cd42() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.MSUser postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.MSUser) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.MSUser create(int argMsucode, java.lang.String argMsUser) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.MSUser _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.MSUserBean bean = (com.hps.july.persistence2.MSUserBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argMsucode, argMsUser);
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
	public com.hps.july.persistence2.MSUser findByPrimaryKey(com.hps.july.persistence2.MSUserKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPMSUserBean_0350cd42) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.MSUserBean tmpEJB = (com.hps.july.persistence2.MSUserBean) generalEJB;
		com.hps.july.persistence2.MSUserKey keyClass = new com.hps.july.persistence2.MSUserKey();
		keyClass.msucode = tmpEJB.msucode;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.MSUserKey keyFromFields(int f0) {
		com.hps.july.persistence2.MSUserKey keyClass = new com.hps.july.persistence2.MSUserKey();
		keyClass.msucode = f0;
		return keyClass;
	}
}
