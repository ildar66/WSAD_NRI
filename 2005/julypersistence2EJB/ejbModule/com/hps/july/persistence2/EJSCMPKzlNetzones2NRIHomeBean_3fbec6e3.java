package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPKzlNetzones2NRIHomeBean_3fbec6e3
 */
public class EJSCMPKzlNetzones2NRIHomeBean_3fbec6e3 extends EJSHome {
	/**
	 * EJSCMPKzlNetzones2NRIHomeBean_3fbec6e3
	 */
	public EJSCMPKzlNetzones2NRIHomeBean_3fbec6e3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.KzlNetzones2NRI postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.KzlNetzones2NRI) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.KzlNetzones2NRI findByPrimaryKey(com.hps.july.persistence2.KzlNetzones2NRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPKzlNetzones2NRIBean_3fbec6e3) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.KzlNetzones2NRI create(int argKzlregionid, int argNetzone) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.KzlNetzones2NRI _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.KzlNetzones2NRIBean bean = (com.hps.july.persistence2.KzlNetzones2NRIBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argKzlregionid, argNetzone);
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
		com.hps.july.persistence2.KzlNetzones2NRIBean tmpEJB = (com.hps.july.persistence2.KzlNetzones2NRIBean) generalEJB;
		com.hps.july.persistence2.KzlNetzones2NRIKey keyClass = new com.hps.july.persistence2.KzlNetzones2NRIKey();
		keyClass.kzlregionid = tmpEJB.kzlregionid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.KzlNetzones2NRIKey keyFromFields(int f0) {
		com.hps.july.persistence2.KzlNetzones2NRIKey keyClass = new com.hps.july.persistence2.KzlNetzones2NRIKey();
		keyClass.kzlregionid = f0;
		return keyClass;
	}
}
