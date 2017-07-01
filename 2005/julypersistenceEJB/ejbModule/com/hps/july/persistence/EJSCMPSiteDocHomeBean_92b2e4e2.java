package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSiteDocHomeBean_92b2e4e2
 */
public class EJSCMPSiteDocHomeBean_92b2e4e2 extends EJSHome {
	/**
	 * EJSCMPSiteDocHomeBean_92b2e4e2
	 */
	public EJSCMPSiteDocHomeBean_92b2e4e2() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SiteDoc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SiteDoc) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findSiteDocsBySiteDocType
	 */
	public java.util.Enumeration findSiteDocsBySiteDocType(com.hps.july.persistence.SiteDocTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocBean)persister).findSiteDocsBySiteDocType(inKey));	}
	/**
	 * findByPosition
	 */
	public java.util.Enumeration findByPosition(java.lang.Integer position, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocBean)persister).findByPosition(position, order));	}
	/**
	 * findByProjectactions_Project
	 */
	public java.util.Enumeration findByProjectactions_Project(java.lang.Integer project) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocBean)persister).findByProjectactions_Project(project));	}
	/**
	 * findByProjectaction
	 */
	public java.util.Enumeration findByProjectaction(java.lang.Integer projectaction) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocBean)persister).findByProjectaction(projectaction));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.SiteDoc findByPrimaryKey(com.hps.july.persistence.SiteDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSiteDocBean_92b2e4e2) persister).findByPrimaryKey(key);
	}
	/**
	 * findByEquipment
	 */
	public java.util.Enumeration findByEquipment(java.lang.Integer position, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocBean)persister).findByEquipment(position, order));	}
	/**
	 * findByHop
	 */
	public java.util.Enumeration findByHop(java.lang.Integer hopid, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocBean)persister).findByHop(hopid, order));	}
	/**
	 * findSiteDocsByMan
	 */
	public java.util.Enumeration findSiteDocsByMan(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocBean)persister).findSiteDocsByMan(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SiteDoc create(int argSitedoc, int siteDocType, int man) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SiteDoc _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SiteDocBean bean = (com.hps.july.persistence.SiteDocBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSitedoc, siteDocType, man);
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
	 * findSiteDocsByProjectAction
	 */
	public java.util.Enumeration findSiteDocsByProjectAction(com.hps.july.persistence.ProjectActionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocBean)persister).findSiteDocsByProjectAction(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SiteDocBean tmpEJB = (com.hps.july.persistence.SiteDocBean) generalEJB;
		com.hps.july.persistence.SiteDocKey keyClass = new com.hps.july.persistence.SiteDocKey();
		keyClass.sitedoc = tmpEJB.sitedoc;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SiteDocKey keyFromFields(int f0) {
		com.hps.july.persistence.SiteDocKey keyClass = new com.hps.july.persistence.SiteDocKey();
		keyClass.sitedoc = f0;
		return keyClass;
	}
}
