package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEDogovorLinkHomeBean_cfdd92a1
 */
public class EJSCMPPIEDogovorLinkHomeBean_cfdd92a1 extends EJSHome {
	/**
	 * EJSCMPPIEDogovorLinkHomeBean_cfdd92a1
	 */
	public EJSCMPPIEDogovorLinkHomeBean_cfdd92a1() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDogovorLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDogovorLink) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEDogovorLink create(int argIddogovornri, java.lang.String argTypedogovornri, int argOwner, java.lang.String argIdDogovorPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEDogovorLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEDogovorLinkBean bean = (com.hps.july.persistence.PIEDogovorLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIddogovornri, argTypedogovornri, argOwner, argIdDogovorPlatinum);
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
	public com.hps.july.persistence.PIEDogovorLink findByPrimaryKey(com.hps.july.persistence.PIEDogovorLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEDogovorLinkBean_cfdd92a1) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEDogovorLinkBean tmpEJB = (com.hps.july.persistence.PIEDogovorLinkBean) generalEJB;
		com.hps.july.persistence.PIEDogovorLinkKey keyClass = new com.hps.july.persistence.PIEDogovorLinkKey();
		keyClass.iddogovornri = tmpEJB.iddogovornri;
		keyClass.typedogovornri = tmpEJB.typedogovornri;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEDogovorLinkKey keyFromFields(int f0, java.lang.String f1) {
		com.hps.july.persistence.PIEDogovorLinkKey keyClass = new com.hps.july.persistence.PIEDogovorLinkKey();
		keyClass.iddogovornri = f0;
		keyClass.typedogovornri = f1;
		return keyClass;
	}
}
