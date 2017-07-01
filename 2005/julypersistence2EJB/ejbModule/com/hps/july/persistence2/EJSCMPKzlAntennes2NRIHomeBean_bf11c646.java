package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPKzlAntennes2NRIHomeBean_bf11c646
 */
public class EJSCMPKzlAntennes2NRIHomeBean_bf11c646 extends EJSHome {
	/**
	 * EJSCMPKzlAntennes2NRIHomeBean_bf11c646
	 */
	public EJSCMPKzlAntennes2NRIHomeBean_bf11c646() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.KzlAntennes2NRI postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.KzlAntennes2NRI) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.KzlAntennes2NRI findByPrimaryKey(com.hps.july.persistence2.KzlAntennes2NRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPKzlAntennes2NRIBean_bf11c646) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.KzlAntennes2NRI create(int argAntposantennid, int argResource) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.KzlAntennes2NRI _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.KzlAntennes2NRIBean bean = (com.hps.july.persistence2.KzlAntennes2NRIBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAntposantennid, argResource);
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
		com.hps.july.persistence2.KzlAntennes2NRIBean tmpEJB = (com.hps.july.persistence2.KzlAntennes2NRIBean) generalEJB;
		com.hps.july.persistence2.KzlAntennes2NRIKey keyClass = new com.hps.july.persistence2.KzlAntennes2NRIKey();
		keyClass.antposantennid = tmpEJB.antposantennid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.KzlAntennes2NRIKey keyFromFields(int f0) {
		com.hps.july.persistence2.KzlAntennes2NRIKey keyClass = new com.hps.july.persistence2.KzlAntennes2NRIKey();
		keyClass.antposantennid = f0;
		return keyClass;
	}
}
