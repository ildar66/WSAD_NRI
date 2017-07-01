package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEDocInfoDocPosHomeBean_e77ba69e
 */
public class EJSCMPPIEDocInfoDocPosHomeBean_e77ba69e extends EJSHome {
	/**
	 * EJSCMPPIEDocInfoDocPosHomeBean_e77ba69e
	 */
	public EJSCMPPIEDocInfoDocPosHomeBean_e77ba69e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDocInfoDocPos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDocInfoDocPos) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEDocInfoDocPos create(int argDocposition, boolean argFlagFullLink) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEDocInfoDocPos _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEDocInfoDocPosBean bean = (com.hps.july.persistence.PIEDocInfoDocPosBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocposition, argFlagFullLink);
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
	public com.hps.july.persistence.PIEDocInfoDocPos findByPrimaryKey(com.hps.july.persistence.PIEDocInfoDocPosKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEDocInfoDocPosBean_e77ba69e) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEDocInfoDocPosBean tmpEJB = (com.hps.july.persistence.PIEDocInfoDocPosBean) generalEJB;
		com.hps.july.persistence.PIEDocInfoDocPosKey keyClass = new com.hps.july.persistence.PIEDocInfoDocPosKey();
		keyClass.docposition = tmpEJB.docposition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEDocInfoDocPosKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEDocInfoDocPosKey keyClass = new com.hps.july.persistence.PIEDocInfoDocPosKey();
		keyClass.docposition = f0;
		return keyClass;
	}
}
