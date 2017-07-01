package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessParty_dc8443e4
 */
public class EJSRemoteStatelessParty_dc8443e4 extends EJSWrapper implements Party {
	/**
	 * EJSRemoteStatelessParty_dc8443e4
	 */
	public EJSRemoteStatelessParty_dc8443e4() throws java.rmi.RemoteException {
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
	 * getOwner
	 */
	public java.lang.Integer getOwner() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.PartyBean beanRef = (com.hps.july.inventory.sessionbean.PartyBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getOwner();
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
	 * getResource
	 */
	public java.lang.Integer getResource() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.PartyBean beanRef = (com.hps.july.inventory.sessionbean.PartyBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getResource();
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
	 * getParty
	 */
	public java.lang.String getParty() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.PartyBean beanRef = (com.hps.july.inventory.sessionbean.PartyBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getParty();
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
	 * findPartyByQBE2
	 */
	public java.util.ArrayList findPartyByQBE2(java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.ArrayList _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.PartyBean beanRef = (com.hps.july.inventory.sessionbean.PartyBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findPartyByQBE2(isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, connected, owner, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * setOwner
	 */
	public void setOwner(java.lang.Integer newOwner) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.PartyBean beanRef = (com.hps.july.inventory.sessionbean.PartyBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.setOwner(newOwner);
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
		return ;
	}
	/**
	 * setParty
	 */
	public void setParty(java.lang.String newParty) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.PartyBean beanRef = (com.hps.july.inventory.sessionbean.PartyBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.setParty(newParty);
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
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setResource
	 */
	public void setResource(java.lang.Integer newResource) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.PartyBean beanRef = (com.hps.july.inventory.sessionbean.PartyBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.setResource(newResource);
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
}
