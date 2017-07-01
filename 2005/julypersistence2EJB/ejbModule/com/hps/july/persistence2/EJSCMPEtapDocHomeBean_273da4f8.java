package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPEtapDocHomeBean_273da4f8
 */
public class EJSCMPEtapDocHomeBean_273da4f8 extends EJSHome {
	/**
	 * EJSCMPEtapDocHomeBean_273da4f8
	 */
	public EJSCMPEtapDocHomeBean_273da4f8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.EtapDoc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.EtapDoc) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.EtapDoc create(int argSitedoc, int argEtapTypeId, int argFreqPermId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.EtapDoc _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.EtapDocBean bean = (com.hps.july.persistence2.EtapDocBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSitedoc, argEtapTypeId, argFreqPermId);
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
	public com.hps.july.persistence2.EtapDoc findByPrimaryKey(com.hps.july.persistence2.EtapDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPEtapDocBean_273da4f8) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.EtapDocBean tmpEJB = (com.hps.july.persistence2.EtapDocBean) generalEJB;
		com.hps.july.persistence2.EtapDocKey keyClass = new com.hps.july.persistence2.EtapDocKey();
		keyClass.sitedoc = tmpEJB.sitedoc;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.EtapDocKey keyFromFields(int f0) {
		com.hps.july.persistence2.EtapDocKey keyClass = new com.hps.july.persistence2.EtapDocKey();
		keyClass.sitedoc = f0;
		return keyClass;
	}
}
