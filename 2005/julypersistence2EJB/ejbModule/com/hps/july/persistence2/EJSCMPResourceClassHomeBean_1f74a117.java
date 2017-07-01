package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPResourceClassHomeBean_1f74a117
 */
public class EJSCMPResourceClassHomeBean_1f74a117 extends EJSHome {
	/**
	 * EJSCMPResourceClassHomeBean_1f74a117
	 */
	public EJSCMPResourceClassHomeBean_1f74a117() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ResourceClass postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ResourceClass) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.ResourceClass create(int argClassid, java.lang.String argClassname) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.ResourceClass _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.ResourceClassBean bean = (com.hps.july.persistence2.ResourceClassBean) beanO.getEnterpriseBean();
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
	public com.hps.july.persistence2.ResourceClass findByPrimaryKey(com.hps.july.persistence2.ResourceClassKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPResourceClassBean_1f74a117) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.ResourceClassBean tmpEJB = (com.hps.july.persistence2.ResourceClassBean) generalEJB;
		com.hps.july.persistence2.ResourceClassKey keyClass = new com.hps.july.persistence2.ResourceClassKey();
		keyClass.classid = tmpEJB.classid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.ResourceClassKey keyFromFields(int f0) {
		com.hps.july.persistence2.ResourceClassKey keyClass = new com.hps.july.persistence2.ResourceClassKey();
		keyClass.classid = f0;
		return keyClass;
	}
}
