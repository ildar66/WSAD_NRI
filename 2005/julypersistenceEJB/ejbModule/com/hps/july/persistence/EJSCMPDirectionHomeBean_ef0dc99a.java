package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPDirectionHomeBean_ef0dc99a
 */
public class EJSCMPDirectionHomeBean_ef0dc99a extends EJSHome {
	/**
	 * EJSCMPDirectionHomeBean_ef0dc99a
	 */
	public EJSCMPDirectionHomeBean_ef0dc99a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Direction postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Direction) super.postCreate(beanO, ejsKey, true);
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
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDirectionBean)persister).findByParentOrderByNameDesc(parent));	}
	/**
	 * findByParentOrderByNameAsc
	 */
	public java.util.Enumeration findByParentOrderByNameAsc(java.lang.Integer parent) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDirectionBean)persister).findByParentOrderByNameAsc(parent));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isParent, java.lang.Integer parent, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDirectionBean)persister).findByQBE(isParent, parent, isIsActive, isActive, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Direction findByPrimaryKey(com.hps.july.persistence.DivisionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPDirectionBean_ef0dc99a) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Direction create(int argDivision, java.lang.String argName, java.lang.String argShortName, java.lang.Integer parent) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Direction _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DirectionBean bean = (com.hps.july.persistence.DirectionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDivision, argName, argShortName, parent);
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
		com.hps.july.persistence.DirectionBean tmpEJB = (com.hps.july.persistence.DirectionBean) generalEJB;
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
