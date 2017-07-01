package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRRLHops2HomeBean_04b3f8f3
 */
public class EJSCMPRRLHops2HomeBean_04b3f8f3 extends EJSHome {
	/**
	 * EJSCMPRRLHops2HomeBean_04b3f8f3
	 */
	public EJSCMPRRLHops2HomeBean_04b3f8f3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.RRLHops2 postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.RRLHops2) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.trailcom.beans.RRLHops2 create(int hopid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.trailcom.beans.RRLHops2 _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.trailcom.beans.RRLHops2Bean bean = (com.hps.july.trailcom.beans.RRLHops2Bean) beanO.getEnterpriseBean();
			bean.ejbCreate(hopid);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.RRLHops2 findByPrimaryKey(com.hps.july.trailcom.beans.RRLHops2Key key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPRRLHops2Bean_04b3f8f3) persister).findByPrimaryKey(key);
	}
	/**
	 * findRrlHops2ByHopid
	 */
	public com.hps.july.trailcom.beans.RRLHops2 findRrlHops2ByHopid(com.hps.july.trailcom.beans.HopKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPRRLHops2Bean_04b3f8f3)persister).findRrlHops2ByHopid(inKey);	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.trailcom.beans.RRLHops2Bean tmpEJB = (com.hps.july.trailcom.beans.RRLHops2Bean) generalEJB;
		com.hps.july.trailcom.beans.RRLHops2Key keyClass = new com.hps.july.trailcom.beans.RRLHops2Key();
		keyClass.hopid_hopsid = tmpEJB.hopid_hopsid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.trailcom.beans.RRLHops2Key keyFromFields(java.lang.Integer f0) {
		com.hps.july.trailcom.beans.RRLHops2Key keyClass = new com.hps.july.trailcom.beans.RRLHops2Key();
		keyClass.hopid_hopsid = f0;
		return keyClass;
	}
}
