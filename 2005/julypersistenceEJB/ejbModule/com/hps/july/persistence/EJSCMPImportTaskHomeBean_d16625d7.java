package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPImportTaskHomeBean_d16625d7
 */
public class EJSCMPImportTaskHomeBean_d16625d7 extends EJSHome {
	/**
	 * EJSCMPImportTaskHomeBean_d16625d7
	 */
	public EJSCMPImportTaskHomeBean_d16625d7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ImportTask postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ImportTask) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ImportTask create(int argImptaskid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ImportTask _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ImportTaskBean bean = (com.hps.july.persistence.ImportTaskBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argImptaskid, argName);
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
	public com.hps.july.persistence.ImportTask findByPrimaryKey(com.hps.july.persistence.ImportTaskKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPImportTaskBean_d16625d7) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ImportTaskBean tmpEJB = (com.hps.july.persistence.ImportTaskBean) generalEJB;
		com.hps.july.persistence.ImportTaskKey keyClass = new com.hps.july.persistence.ImportTaskKey();
		keyClass.imptaskid = tmpEJB.imptaskid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ImportTaskKey keyFromFields(int f0) {
		com.hps.july.persistence.ImportTaskKey keyClass = new com.hps.july.persistence.ImportTaskKey();
		keyClass.imptaskid = f0;
		return keyClass;
	}
}
