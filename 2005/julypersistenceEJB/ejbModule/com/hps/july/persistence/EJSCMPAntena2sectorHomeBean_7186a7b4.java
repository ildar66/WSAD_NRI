package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAntena2sectorHomeBean_7186a7b4
 */
public class EJSCMPAntena2sectorHomeBean_7186a7b4 extends EJSHome {
	/**
	 * EJSCMPAntena2sectorHomeBean_7186a7b4
	 */
	public EJSCMPAntena2sectorHomeBean_7186a7b4() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Antena2sector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Antena2sector) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Antena2sector findByPrimaryKey(com.hps.july.persistence.Antena2sectorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAntena2sectorBean_7186a7b4) persister).findByPrimaryKey(key);
	}
	/**
	 * findAntena2sectorsByAntenna
	 */
	public java.util.Enumeration findAntena2sectorsByAntenna(com.hps.july.persistence.AntennaKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntena2sectorBean)persister).findAntena2sectorsByAntenna(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Antena2sector create(int argAnten, int argSector) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Antena2sector _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.Antena2sectorBean bean = (com.hps.july.persistence.Antena2sectorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAnten, argSector);
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
	 * create
	 */
	public com.hps.july.persistence.Antena2sector create(int argAnten, int argSector, java.lang.Boolean argByhand) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Antena2sector _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.Antena2sectorBean bean = (com.hps.july.persistence.Antena2sectorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAnten, argSector, argByhand);
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
	 * findAntena2sectorsBySector
	 */
	public java.util.Enumeration findAntena2sectorsBySector(com.hps.july.persistence.SectorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntena2sectorBean)persister).findAntena2sectorsBySector(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.Antena2sectorBean tmpEJB = (com.hps.july.persistence.Antena2sectorBean) generalEJB;
		com.hps.july.persistence.Antena2sectorKey keyClass = new com.hps.july.persistence.Antena2sectorKey();
		keyClass.sector_idsect = tmpEJB.sector_idsect;
		keyClass.antenna_idanten = tmpEJB.antenna_idanten;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.Antena2sectorKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.Antena2sectorKey keyClass = new com.hps.july.persistence.Antena2sectorKey();
		keyClass.sector_idsect = f0;
		keyClass.antenna_idanten = f1;
		return keyClass;
	}
}
