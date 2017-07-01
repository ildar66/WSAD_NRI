package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPGroup2ResourceHomeBean_ebda9379
 */
public class EJSCMPGroup2ResourceHomeBean_ebda9379 extends EJSHome {
	/**
	 * EJSCMPGroup2ResourceHomeBean_ebda9379
	 */
	public EJSCMPGroup2ResourceHomeBean_ebda9379() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Group2Resource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Group2Resource) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.Group2Resource create(int groupid, int resource, java.math.BigDecimal qty) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.Group2Resource _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.Group2ResourceBean bean = (com.hps.july.persistence2.Group2ResourceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(groupid, resource, qty);
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
	public com.hps.july.persistence2.Group2Resource findByPrimaryKey(com.hps.july.persistence2.Group2ResourceKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPGroup2ResourceBean_ebda9379) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.Group2ResourceBean tmpEJB = (com.hps.july.persistence2.Group2ResourceBean) generalEJB;
		com.hps.july.persistence2.Group2ResourceKey keyClass = new com.hps.july.persistence2.Group2ResourceKey();
		keyClass.groupid = tmpEJB.groupid;
		keyClass.resource = tmpEJB.resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.Group2ResourceKey keyFromFields(int f0, int f1) {
		com.hps.july.persistence2.Group2ResourceKey keyClass = new com.hps.july.persistence2.Group2ResourceKey();
		keyClass.groupid = f0;
		keyClass.resource = f1;
		return keyClass;
	}
}
