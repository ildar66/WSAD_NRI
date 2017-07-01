package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSectorHomeBean_905f53fa
 */
public class EJSCMPSectorHomeBean_905f53fa extends EJSHome {
	/**
	 * EJSCMPSectorHomeBean_905f53fa
	 */
	public EJSCMPSectorHomeBean_905f53fa() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Sector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Sector) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Sector create(int argIdsect, int argEquipment, java.lang.String argNamesect, short argBand, java.lang.String argNumsect) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Sector _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SectorBean bean = (com.hps.july.persistence.SectorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdsect, argEquipment, argNamesect, argBand, argNumsect);
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
	 * findByBasestationOrderByNumberAsc
	 */
	public java.util.Enumeration findByBasestationOrderByNumberAsc(java.lang.Integer argEquipment) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSectorBean)persister).findByBasestationOrderByNumberAsc(argEquipment));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Integer argBSNum, java.lang.String bsType, java.lang.Boolean isPlanstate, java.lang.String argPlanstate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSectorBean)persister).findByQBE(argBSNum, bsType, isPlanstate, argPlanstate, isState, argState, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Sector findByPrimaryKey(com.hps.july.persistence.SectorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSectorBean_905f53fa) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Sector create(int argIdsect, int argEquipment, java.lang.String argNamesect, short argBand, java.lang.String argNumsect, java.lang.Boolean argByhand) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Sector _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SectorBean bean = (com.hps.july.persistence.SectorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdsect, argEquipment, argNamesect, argBand, argNumsect, argByhand);
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
	 * findSectorsByEquipment
	 */
	public java.util.Enumeration findSectorsByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSectorBean)persister).findSectorsByEquipment(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SectorBean tmpEJB = (com.hps.july.persistence.SectorBean) generalEJB;
		com.hps.july.persistence.SectorKey keyClass = new com.hps.july.persistence.SectorKey();
		keyClass.idsect = tmpEJB.idsect;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SectorKey keyFromFields(int f0) {
		com.hps.july.persistence.SectorKey keyClass = new com.hps.july.persistence.SectorKey();
		keyClass.idsect = f0;
		return keyClass;
	}
}
