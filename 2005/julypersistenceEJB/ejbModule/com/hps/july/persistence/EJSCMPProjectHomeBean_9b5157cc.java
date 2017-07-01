package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectHomeBean_9b5157cc
 */
public class EJSCMPProjectHomeBean_9b5157cc extends EJSHome {
	/**
	 * EJSCMPProjectHomeBean_9b5157cc
	 */
	public EJSCMPProjectHomeBean_9b5157cc() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Project postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Project) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findProjectsByPosition
	 */
	public java.util.Enumeration findProjectsByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectBean)persister).findProjectsByPosition(inKey));	}
	/**
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Integer division, java.lang.Integer projecttype, java.lang.Boolean isSupregions, java.lang.Integer[] supregions, java.lang.Boolean isRegions, java.lang.Integer[] regions, java.lang.Boolean isNetzones, java.lang.Integer[] netzones, java.lang.Boolean isPosition, java.lang.Integer argPosition, java.lang.Boolean isResponsible, java.lang.Integer argResponsible, java.lang.Boolean isEndDate, java.lang.Short endMonth, java.lang.Integer endYear, java.lang.Boolean isProjectstate, java.lang.String argProjectstate, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectBean)persister).findByQBE2(division, projecttype, isSupregions, supregions, isRegions, regions, isNetzones, netzones, isPosition, argPosition, isResponsible, argResponsible, isEndDate, endMonth, endYear, isProjectstate, argProjectstate, order));	}
	/**
	 * findProjectsByContructer
	 */
	public java.util.Enumeration findProjectsByContructer(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectBean)persister).findProjectsByContructer(inKey));	}
	/**
	 * findByQBE1
	 */
	public java.util.Enumeration findByQBE1(java.lang.Integer projecttype, java.lang.Boolean isProjectstate, java.lang.String argProjectstate, java.lang.Boolean isPosition, java.lang.Integer argPosition, java.lang.Boolean isNetzone, java.lang.Integer argNetzone, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectBean)persister).findByQBE1(projecttype, isProjectstate, argProjectstate, isPosition, argPosition, isNetzone, argNetzone, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Project findByPrimaryKey(com.hps.july.persistence.ProjectKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectBean_9b5157cc) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Project create(int argProject, int argProjectType, java.lang.String argName, int position) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Project _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectBean bean = (com.hps.july.persistence.ProjectBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProject, argProjectType, argName, position);
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
	 * findVcprojectsByVccontructer
	 */
	public java.util.Enumeration findVcprojectsByVccontructer(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectBean)persister).findVcprojectsByVccontructer(inKey));	}
	/**
	 * findProjectsByProjecttype
	 */
	public java.util.Enumeration findProjectsByProjecttype(com.hps.july.persistence.ProjectTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectBean)persister).findProjectsByProjecttype(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ProjectBean tmpEJB = (com.hps.july.persistence.ProjectBean) generalEJB;
		com.hps.july.persistence.ProjectKey keyClass = new com.hps.july.persistence.ProjectKey();
		keyClass.project = tmpEJB.project;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProjectKey keyFromFields(int f0) {
		com.hps.july.persistence.ProjectKey keyClass = new com.hps.july.persistence.ProjectKey();
		keyClass.project = f0;
		return keyClass;
	}
}
