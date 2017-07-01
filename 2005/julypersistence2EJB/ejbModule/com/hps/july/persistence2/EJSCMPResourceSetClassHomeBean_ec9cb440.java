package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPResourceSetClassHomeBean_ec9cb440
 */
public class EJSCMPResourceSetClassHomeBean_ec9cb440 extends EJSHome {
	/**
	 * EJSCMPResourceSetClassHomeBean_ec9cb440
	 */
	public EJSCMPResourceSetClassHomeBean_ec9cb440() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ResourceSetClass postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ResourceSetClass) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.ResourceSetClass create(int argClassid, java.lang.String argClassname) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.ResourceSetClass _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.ResourceSetClassBean bean = (com.hps.july.persistence2.ResourceSetClassBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argClassid, argClassname);
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
	public com.hps.july.persistence2.ResourceSetClass findByPrimaryKey(com.hps.july.persistence2.ResourceSetClassKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPResourceSetClassBean_ec9cb440) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.ResourceSetClassBean tmpEJB = (com.hps.july.persistence2.ResourceSetClassBean) generalEJB;
		com.hps.july.persistence2.ResourceSetClassKey keyClass = new com.hps.july.persistence2.ResourceSetClassKey();
		keyClass.classid = tmpEJB.classid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.ResourceSetClassKey keyFromFields(int f0) {
		com.hps.july.persistence2.ResourceSetClassKey keyClass = new com.hps.july.persistence2.ResourceSetClassKey();
		keyClass.classid = f0;
		return keyClass;
	}
}
