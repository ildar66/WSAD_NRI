package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSitedocFacade_41d8fcb3
 */
public class EJSRemoteStatelessSitedocFacade_41d8fcb3 extends EJSWrapper implements SitedocFacade {
	/**
	 * EJSRemoteStatelessSitedocFacade_41d8fcb3
	 */
	public EJSRemoteStatelessSitedocFacade_41d8fcb3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
	/**
	 * findEtapDocByPrimaryKey
	 */
	public com.hps.july.persistence2.EtapDocValueObject findEtapDocByPrimaryKey(int argSiteDoc) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence2.EtapDocValueObject _EJS_result = null;
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.findEtapDocByPrimaryKey(argSiteDoc);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findGKRCHDocByPrimaryKey
	 */
	public com.hps.july.persistence2.GKRCHDocValueObject findGKRCHDocByPrimaryKey(int argSiteDoc) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence2.GKRCHDocValueObject _EJS_result = null;
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.findGKRCHDocByPrimaryKey(argSiteDoc);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findRRLDocByPrimaryKey
	 */
	public com.hps.july.persistence2.RRLDocValueObject findRRLDocByPrimaryKey(int argSiteDoc) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence2.RRLDocValueObject _EJS_result = null;
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.findRRLDocByPrimaryKey(argSiteDoc);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getGKRCHSiteDocType
	 */
	public int getGKRCHSiteDocType() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getGKRCHSiteDocType();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRRLSiteDocType
	 */
	public int getRRLSiteDocType() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getRRLSiteDocType();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * createEtapDoc
	 */
	public void createEtapDoc(com.hps.july.persistence2.EtapDocValueObject argObj, int[] comlines) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.createEtapDoc(argObj, comlines);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * createGKRCHDoc
	 */
	public void createGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject argObj) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.createGKRCHDoc(argObj);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * createGKRCHDoc
	 */
	public void createGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject argObj, com.hps.july.persistence2.DocResourceValueObject[] argResources, int[] argRegions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 7, _EJS_s);
			beanRef.createGKRCHDoc(argObj, argResources, argRegions);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * createRRLDoc
	 */
	public void createRRLDoc(com.hps.july.persistence2.RRLDocValueObject argObj) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 8, _EJS_s);
			beanRef.createRRLDoc(argObj);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * createRRLDoc
	 */
	public void createRRLDoc(com.hps.july.persistence2.RRLDocValueObject argObj, com.hps.july.persistence2.DocResourceValueObject[] argResources) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 9, _EJS_s);
			beanRef.createRRLDoc(argObj, argResources);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * deleteEtapDoc
	 */
	public void deleteEtapDoc(int argSiteDoc) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 10, _EJS_s);
			beanRef.deleteEtapDoc(argSiteDoc);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * deleteGKRCHDoc
	 */
	public void deleteGKRCHDoc(int argSiteDoc) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 11, _EJS_s);
			beanRef.deleteGKRCHDoc(argSiteDoc);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * deleteRRLDoc
	 */
	public void deleteRRLDoc(int argSiteDoc) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 12, _EJS_s);
			beanRef.deleteRRLDoc(argSiteDoc);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateEtapDoc
	 */
	public void updateEtapDoc(com.hps.july.persistence2.EtapDocValueObject argObj, int[] comlines) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 13, _EJS_s);
			beanRef.updateEtapDoc(argObj, comlines);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateGKRCHDoc
	 */
	public void updateGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject argObj) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 14, _EJS_s);
			beanRef.updateGKRCHDoc(argObj);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateGKRCHDoc
	 */
	public void updateGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject argObj, com.hps.july.persistence2.DocResourceValueObject[] argResources, int[] argRegions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 15, _EJS_s);
			beanRef.updateGKRCHDoc(argObj, argResources, argRegions);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateRRLDoc
	 */
	public void updateRRLDoc(com.hps.july.persistence2.RRLDocValueObject argObj) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 16, _EJS_s);
			beanRef.updateRRLDoc(argObj);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateRRLDoc
	 */
	public void updateRRLDoc(com.hps.july.persistence2.RRLDocValueObject argObj, com.hps.july.persistence2.DocResourceValueObject[] argResources) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.SitedocFacadeBean beanRef = (com.hps.july.persistence2.SitedocFacadeBean)container.preInvoke(this, 17, _EJS_s);
			beanRef.updateRRLDoc(argObj, argResources);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
