package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSearchesHomeBean_cc646049
 */
public class EJSCMPSearchesHomeBean_cc646049 extends EJSHome {
	/**
	 * EJSCMPSearchesHomeBean_cc646049
	 */
	public EJSCMPSearchesHomeBean_cc646049() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Searches postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Searches) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findSearchesByOrganization
	 */
	public java.util.Enumeration findSearchesByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSearchesBean)persister).findSearchesByOrganization(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Searches findByPrimaryKey(com.hps.july.persistence.SearchesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSearchesBean_cc646049) persister).findByPrimaryKey(key);
	}
	/**
	 * findSearchesByGroupping
	 */
	public java.util.Enumeration findSearchesByGroupping(com.hps.july.persistence.SearchGrouppingKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSearchesBean)persister).findSearchesByGroupping(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Searches create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Searches _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SearchesBean bean = (com.hps.july.persistence.SearchesBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
	 * create
	 */
	public com.hps.july.persistence.Searches create(java.lang.Integer argGroup, java.lang.Integer argGroupping, java.lang.Integer argOrganization, java.lang.Integer argOrder) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Searches _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SearchesBean bean = (com.hps.july.persistence.SearchesBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argGroup, argGroupping, argOrganization, argOrder);
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
	 * findSearchesByGroup
	 */
	public java.util.Enumeration findSearchesByGroup(com.hps.july.persistence.SearchGroupKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSearchesBean)persister).findSearchesByGroup(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SearchesBean tmpEJB = (com.hps.july.persistence.SearchesBean) generalEJB;
		com.hps.july.persistence.SearchesKey keyClass = new com.hps.july.persistence.SearchesKey();
		keyClass.organization_organization = tmpEJB.organization_organization;
		keyClass.group_searchgroup = tmpEJB.group_searchgroup;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SearchesKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.SearchesKey keyClass = new com.hps.july.persistence.SearchesKey();
		keyClass.organization_organization = f0;
		keyClass.group_searchgroup = f1;
		return keyClass;
	}
}
