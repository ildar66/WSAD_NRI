package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPHopHomeBean_260ef4c5
 */
public class EJSCMPHopHomeBean_260ef4c5 extends EJSHome {
	/**
	 * EJSCMPHopHomeBean_260ef4c5
	 */
	public EJSCMPHopHomeBean_260ef4c5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.Hop postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.Hop) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findBySiteid_endbOrderByHopsidAsc
	 */
	public java.util.Enumeration findBySiteid_endbOrderByHopsidAsc(java.lang.Integer siteid_endb) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderHopBean)persister).findBySiteid_endbOrderByHopsidAsc(siteid_endb));	}
	/**
	 * findBySiteid_endaOrderByHopsidAsc
	 */
	public java.util.Enumeration findBySiteid_endaOrderByHopsidAsc(java.lang.Integer siteid_enda) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderHopBean)persister).findBySiteid_endaOrderByHopsidAsc(siteid_enda));	}
	/**
	 * findByPositions
	 */
	public java.util.Enumeration findByPositions(java.lang.Boolean isTypeR, java.lang.Boolean isTypeO, java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isAllType, java.lang.Boolean isDAMPS, java.lang.Boolean isGSM900, java.lang.Boolean isDCS1800, java.lang.Boolean isControllers, java.lang.Boolean isWorker, java.lang.Integer argWorker) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderHopBean)persister).findByPositions(isTypeR, isTypeO, isNetZone, argNetZone, isAllType, isDAMPS, isGSM900, isDCS1800, isControllers, isWorker, argWorker));	}
	/**
	 * findByPositionAndType
	 */
	public java.util.Enumeration findByPositionAndType(java.lang.String hopstype, java.lang.Integer siteid_enda, java.lang.Integer siteid_endb) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderHopBean)persister).findByPositionAndType(hopstype, siteid_enda, siteid_endb));	}
	/**
	 * findNestedLines
	 */
	public java.util.Enumeration findNestedLines(java.lang.Boolean useType, java.lang.String type, java.lang.Integer hop, java.lang.Integer position) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderHopBean)persister).findNestedLines(useType, type, hop, position));	}
	/**
	 * findHopsByPosition
	 */
	public java.util.Enumeration findHopsByPosition(java.lang.Integer position) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderHopBean)persister).findHopsByPosition(position));	}
	/**
	 * create
	 */
	public com.hps.july.trailcom.beans.Hop create(int argHopsid, int argEquipmentid_enda, int argEquipmentid_endb) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.trailcom.beans.Hop _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.trailcom.beans.HopBean bean = (com.hps.july.trailcom.beans.HopBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argHopsid, argEquipmentid_enda, argEquipmentid_endb);
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
	public com.hps.july.trailcom.beans.Hop findByPrimaryKey(com.hps.july.trailcom.beans.HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPHopBean_260ef4c5) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.trailcom.beans.HopBean tmpEJB = (com.hps.july.trailcom.beans.HopBean) generalEJB;
		com.hps.july.trailcom.beans.HopKey keyClass = new com.hps.july.trailcom.beans.HopKey();
		keyClass.hopsid = tmpEJB.hopsid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.trailcom.beans.HopKey keyFromFields(int f0) {
		com.hps.july.trailcom.beans.HopKey keyClass = new com.hps.july.trailcom.beans.HopKey();
		keyClass.hopsid = f0;
		return keyClass;
	}
}
