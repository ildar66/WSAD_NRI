package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOfficeMemoPosHomeBean_8b7defe2
 */
public class EJSCMPOfficeMemoPosHomeBean_8b7defe2 extends EJSHome {
	/**
	 * EJSCMPOfficeMemoPosHomeBean_8b7defe2
	 */
	public EJSCMPOfficeMemoPosHomeBean_8b7defe2() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.OfficeMemoPos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.OfficeMemoPos) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.OfficeMemoPos findByPrimaryKey(com.hps.july.persistence2.OfficeMemoPosKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPOfficeMemoPosBean_8b7defe2) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.OfficeMemoPos create(int argIdpos, int argIdHeader) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.OfficeMemoPos _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.OfficeMemoPosBean bean = (com.hps.july.persistence2.OfficeMemoPosBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdpos, argIdHeader);
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
		com.hps.july.persistence2.OfficeMemoPosBean tmpEJB = (com.hps.july.persistence2.OfficeMemoPosBean) generalEJB;
		com.hps.july.persistence2.OfficeMemoPosKey keyClass = new com.hps.july.persistence2.OfficeMemoPosKey();
		keyClass.idpos = tmpEJB.idpos;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.OfficeMemoPosKey keyFromFields(int f0) {
		com.hps.july.persistence2.OfficeMemoPosKey keyClass = new com.hps.july.persistence2.OfficeMemoPosKey();
		keyClass.idpos = f0;
		return keyClass;
	}
}
