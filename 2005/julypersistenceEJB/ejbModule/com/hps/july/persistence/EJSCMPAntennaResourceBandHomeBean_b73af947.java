package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAntennaResourceBandHomeBean_b73af947
 */
public class EJSCMPAntennaResourceBandHomeBean_b73af947 extends EJSHome {
	/**
	 * EJSCMPAntennaResourceBandHomeBean_b73af947
	 */
	public EJSCMPAntennaResourceBandHomeBean_b73af947() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AntennaResourceBand postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AntennaResourceBand) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.AntennaResourceBand create(int argResource, short argBand) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AntennaResourceBand _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AntennaResourceBandBean bean = (com.hps.july.persistence.AntennaResourceBandBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResource, argBand);
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
	 * findAntennaResourceBandsByResource
	 */
	public java.util.Enumeration findAntennaResourceBandsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntennaResourceBandBean)persister).findAntennaResourceBandsByResource(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AntennaResourceBand findByPrimaryKey(com.hps.july.persistence.AntennaResourceBandKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAntennaResourceBandBean_b73af947) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.AntennaResourceBandBean tmpEJB = (com.hps.july.persistence.AntennaResourceBandBean) generalEJB;
		com.hps.july.persistence.AntennaResourceBandKey keyClass = new com.hps.july.persistence.AntennaResourceBandKey();
		keyClass.band = tmpEJB.band;
		keyClass.resource_resource = tmpEJB.resource_resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AntennaResourceBandKey keyFromFields(short f0, java.lang.Integer f1) {
		com.hps.july.persistence.AntennaResourceBandKey keyClass = new com.hps.july.persistence.AntennaResourceBandKey();
		keyClass.band = f0;
		keyClass.resource_resource = f1;
		return keyClass;
	}
}
