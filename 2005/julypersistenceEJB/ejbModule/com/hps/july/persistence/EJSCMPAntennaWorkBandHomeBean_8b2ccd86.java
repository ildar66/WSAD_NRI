package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAntennaWorkBandHomeBean_8b2ccd86
 */
public class EJSCMPAntennaWorkBandHomeBean_8b2ccd86 extends EJSHome {
	/**
	 * EJSCMPAntennaWorkBandHomeBean_8b2ccd86
	 */
	public EJSCMPAntennaWorkBandHomeBean_8b2ccd86() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AntennaWorkBand postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AntennaWorkBand) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.AntennaWorkBand create(int argIdanten, short argBand) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AntennaWorkBand _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AntennaWorkBandBean bean = (com.hps.july.persistence.AntennaWorkBandBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdanten, argBand);
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
	 * findAntennaWorkBandsByAntenna
	 */
	public java.util.Enumeration findAntennaWorkBandsByAntenna(com.hps.july.persistence.AntennaKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntennaWorkBandBean)persister).findAntennaWorkBandsByAntenna(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AntennaWorkBand findByPrimaryKey(com.hps.july.persistence.AntennaWorkBandKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAntennaWorkBandBean_8b2ccd86) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.AntennaWorkBandBean tmpEJB = (com.hps.july.persistence.AntennaWorkBandBean) generalEJB;
		com.hps.july.persistence.AntennaWorkBandKey keyClass = new com.hps.july.persistence.AntennaWorkBandKey();
		keyClass.band = tmpEJB.band;
		keyClass.antenna_idanten = tmpEJB.antenna_idanten;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AntennaWorkBandKey keyFromFields(short f0, java.lang.Integer f1) {
		com.hps.july.persistence.AntennaWorkBandKey keyClass = new com.hps.july.persistence.AntennaWorkBandKey();
		keyClass.band = f0;
		keyClass.antenna_idanten = f1;
		return keyClass;
	}
}
