package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCableResourceBandHomeBean_80c2af09
 */
public class EJSCMPCableResourceBandHomeBean_80c2af09 extends EJSHome {
	/**
	 * EJSCMPCableResourceBandHomeBean_80c2af09
	 */
	public EJSCMPCableResourceBandHomeBean_80c2af09() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.CableResourceBand postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.CableResourceBand) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.CableResourceBand findByPrimaryKey(com.hps.july.persistence.CableResourceBandKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPCableResourceBandBean_80c2af09) persister).findByPrimaryKey(key);
	}
	/**
	 * findCableResourceBandsByResource
	 */
	public java.util.Enumeration findCableResourceBandsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCableResourceBandBean)persister).findCableResourceBandsByResource(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.CableResourceBand create(int argResource, short argBand) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.CableResourceBand _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.CableResourceBandBean bean = (com.hps.july.persistence.CableResourceBandBean) beanO.getEnterpriseBean();
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
	 * findByCableResAndAntennaOrderByBand
	 */
	public java.util.Enumeration findByCableResAndAntennaOrderByBand(java.lang.Integer cable, java.lang.Integer antenna) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCableResourceBandBean)persister).findByCableResAndAntennaOrderByBand(cable, antenna));	}
	/**
	 * findByCableResOrderByBand
	 */
	public java.util.Enumeration findByCableResOrderByBand(java.lang.Integer cable) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCableResourceBandBean)persister).findByCableResOrderByBand(cable));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.CableResourceBandBean tmpEJB = (com.hps.july.persistence.CableResourceBandBean) generalEJB;
		com.hps.july.persistence.CableResourceBandKey keyClass = new com.hps.july.persistence.CableResourceBandKey();
		keyClass.band = tmpEJB.band;
		keyClass.resource_resource = tmpEJB.resource_resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.CableResourceBandKey keyFromFields(short f0, java.lang.Integer f1) {
		com.hps.july.persistence.CableResourceBandKey keyClass = new com.hps.july.persistence.CableResourceBandKey();
		keyClass.band = f0;
		keyClass.resource_resource = f1;
		return keyClass;
	}
}
