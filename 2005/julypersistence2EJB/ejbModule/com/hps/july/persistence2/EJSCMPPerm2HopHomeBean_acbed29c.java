package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPerm2HopHomeBean_acbed29c
 */
public class EJSCMPPerm2HopHomeBean_acbed29c extends EJSHome {
	/**
	 * EJSCMPPerm2HopHomeBean_acbed29c
	 */
	public EJSCMPPerm2HopHomeBean_acbed29c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Perm2Hop postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Perm2Hop) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.Perm2Hop findByPrimaryKey(com.hps.july.persistence2.Perm2HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPPerm2HopBean_acbed29c) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.Perm2Hop create(int argFreqpermid, int argHopsid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.Perm2Hop _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.Perm2HopBean bean = (com.hps.july.persistence2.Perm2HopBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argFreqpermid, argHopsid);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argFreqpermid, argHopsid);
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
		com.hps.july.persistence2.Perm2HopBean tmpEJB = (com.hps.july.persistence2.Perm2HopBean) generalEJB;
		com.hps.july.persistence2.Perm2HopKey keyClass = new com.hps.july.persistence2.Perm2HopKey();
		keyClass.freqpermid = tmpEJB.freqpermid;
		keyClass.hopsid = tmpEJB.hopsid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.Perm2HopKey keyFromFields(int f0, int f1) {
		com.hps.july.persistence2.Perm2HopKey keyClass = new com.hps.july.persistence2.Perm2HopKey();
		keyClass.freqpermid = f0;
		keyClass.hopsid = f1;
		return keyClass;
	}
}
