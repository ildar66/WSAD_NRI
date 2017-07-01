package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSitedoc2HopsHomeBean_b6731521
 */
public class EJSCMPSitedoc2HopsHomeBean_b6731521 extends EJSHome {
	/**
	 * EJSCMPSitedoc2HopsHomeBean_b6731521
	 */
	public EJSCMPSitedoc2HopsHomeBean_b6731521() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.Sitedoc2Hops postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.Sitedoc2Hops) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.trailcom.beans.Sitedoc2Hops findByPrimaryKey(com.hps.july.trailcom.beans.Sitedoc2HopsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPSitedoc2HopsBean_b6731521) persister).findByPrimaryKey(key);
	}
	/**
	 * findSitedoc2HopsByHop
	 */
	public java.util.Enumeration findSitedoc2HopsByHop(com.hps.july.trailcom.beans.HopKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderSitedoc2HopsBean)persister).findSitedoc2HopsByHop(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.trailcom.beans.Sitedoc2Hops create(int argSitedoc, int argHopsid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.trailcom.beans.Sitedoc2Hops _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.trailcom.beans.Sitedoc2HopsBean bean = (com.hps.july.trailcom.beans.Sitedoc2HopsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSitedoc, argHopsid);
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
	 * findSitedoc2HopsBySitedoc
	 */
	public java.util.Enumeration findSitedoc2HopsBySitedoc(java.lang.Integer sitedoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderSitedoc2HopsBean)persister).findSitedoc2HopsBySitedoc(sitedoc));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.trailcom.beans.Sitedoc2HopsBean tmpEJB = (com.hps.july.trailcom.beans.Sitedoc2HopsBean) generalEJB;
		com.hps.july.trailcom.beans.Sitedoc2HopsKey keyClass = new com.hps.july.trailcom.beans.Sitedoc2HopsKey();
		keyClass.sitedoc = tmpEJB.sitedoc;
		keyClass.hop_hopsid = tmpEJB.hop_hopsid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.trailcom.beans.Sitedoc2HopsKey keyFromFields(int f0, java.lang.Integer f1) {
		com.hps.july.trailcom.beans.Sitedoc2HopsKey keyClass = new com.hps.july.trailcom.beans.Sitedoc2HopsKey();
		keyClass.sitedoc = f0;
		keyClass.hop_hopsid = f1;
		return keyClass;
	}
}
