package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPResourceGroupHomeBean_34fe15dc
 */
public class EJSCMPResourceGroupHomeBean_34fe15dc extends EJSHome {
	/**
	 * EJSCMPResourceGroupHomeBean_34fe15dc
	 */
	public EJSCMPResourceGroupHomeBean_34fe15dc() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ResourceGroup postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ResourceGroup) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.ResourceGroup create(int groupid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.ResourceGroup _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.ResourceGroupBean bean = (com.hps.july.persistence2.ResourceGroupBean) beanO.getEnterpriseBean();
			bean.ejbCreate(groupid);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(groupid);
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
	public com.hps.july.persistence2.ResourceGroup findByPrimaryKey(com.hps.july.persistence2.ResourceGroupKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPResourceGroupBean_34fe15dc) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.ResourceGroupBean tmpEJB = (com.hps.july.persistence2.ResourceGroupBean) generalEJB;
		com.hps.july.persistence2.ResourceGroupKey keyClass = new com.hps.july.persistence2.ResourceGroupKey();
		keyClass.groupid = tmpEJB.groupid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.ResourceGroupKey keyFromFields(int f0) {
		com.hps.july.persistence2.ResourceGroupKey keyClass = new com.hps.july.persistence2.ResourceGroupKey();
		keyClass.groupid = f0;
		return keyClass;
	}
}
