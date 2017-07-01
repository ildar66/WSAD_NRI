package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPGroupHomeBean_191efb78
 */
public class EJSCMPGroupHomeBean_191efb78 extends EJSHome {
	/**
	 * EJSCMPGroupHomeBean_191efb78
	 */
	public EJSCMPGroupHomeBean_191efb78() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Group postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Group) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByParentOrderByNameDesc
	 */
	public java.util.Enumeration findByParentOrderByNameDesc(java.lang.Integer parent) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderGroupBean)persister).findByParentOrderByNameDesc(parent));	}
	/**
	 * findByParentOrderByNameAsc
	 */
	public java.util.Enumeration findByParentOrderByNameAsc(java.lang.Integer parent) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderGroupBean)persister).findByParentOrderByNameAsc(parent));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isParent, java.lang.Integer parent, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderGroupBean)persister).findByQBE(isParent, parent, isIsActive, isActive, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Group findByPrimaryKey(com.hps.july.persistence.DivisionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPGroupBean_191efb78) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Group create(int argDivision, java.lang.String argName, java.lang.String argShortName, java.lang.Integer argParent) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Group _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.GroupBean bean = (com.hps.july.persistence.GroupBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDivision, argName, argShortName, argParent);
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
		com.hps.july.persistence.GroupBean tmpEJB = (com.hps.july.persistence.GroupBean) generalEJB;
		com.hps.july.persistence.DivisionKey keyClass = new com.hps.july.persistence.DivisionKey();
		keyClass.division = tmpEJB.division;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DivisionKey keyFromFields(int f0) {
		com.hps.july.persistence.DivisionKey keyClass = new com.hps.july.persistence.DivisionKey();
		keyClass.division = f0;
		return keyClass;
	}
}
