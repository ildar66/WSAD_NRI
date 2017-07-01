package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEDopInfoDocHomeBean_fc0be349
 */
public class EJSCMPPIEDopInfoDocHomeBean_fc0be349 extends EJSHome {
	/**
	 * EJSCMPPIEDopInfoDocHomeBean_fc0be349
	 */
	public EJSCMPPIEDopInfoDocHomeBean_fc0be349() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDopInfoDoc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDopInfoDoc) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEDopInfoDoc create(int argDocument, boolean argFlagSyncPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEDopInfoDoc _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEDopInfoDocBean bean = (com.hps.july.persistence.PIEDopInfoDocBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argFlagSyncPlatinum);
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
	public com.hps.july.persistence.PIEDopInfoDoc findByPrimaryKey(com.hps.july.persistence.PIEDopInfoDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEDopInfoDocBean_fc0be349) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEDopInfoDocBean tmpEJB = (com.hps.july.persistence.PIEDopInfoDocBean) generalEJB;
		com.hps.july.persistence.PIEDopInfoDocKey keyClass = new com.hps.july.persistence.PIEDopInfoDocKey();
		keyClass.document = tmpEJB.document;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEDopInfoDocKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEDopInfoDocKey keyClass = new com.hps.july.persistence.PIEDopInfoDocKey();
		keyClass.document = f0;
		return keyClass;
	}
}
