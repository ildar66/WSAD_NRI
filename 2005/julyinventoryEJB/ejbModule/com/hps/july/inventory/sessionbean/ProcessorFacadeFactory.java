package com.hps.july.inventory.sessionbean;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ProcessorFacadeFactory
 * @generated
 */
public class ProcessorFacadeFactory extends AbstractEJBFactory {
	/**
	 * ProcessorFacadeFactory
	 * @generated
	 */
	public ProcessorFacadeFactory() {
		super();
	}
	/**
	 * _acquireProcessorFacadeHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.inventory
		.sessionbean
		.ProcessorFacadeHome _acquireProcessorFacadeHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.inventory
			.sessionbean
			.ProcessorFacadeHome) _acquireEJBHome();
	}
	/**
	 * acquireProcessorFacadeHome
	 * @generated
	 */
	public com
		.hps
		.july
		.inventory
		.sessionbean
		.ProcessorFacadeHome acquireProcessorFacadeHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.inventory
			.sessionbean
			.ProcessorFacadeHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/inventory/sessionbean/ProcessorFacade";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.inventory.sessionbean.ProcessorFacadeHome.class;
	}
	/**
	 * resetProcessorFacadeHome
	 * @generated
	 */
	public void resetProcessorFacadeHome() {
		resetEJBHome();
	}
	/**
	 * setProcessorFacadeHome
	 * @generated
	 */
	public void setProcessorFacadeHome(
		com.hps.july.inventory.sessionbean.ProcessorFacadeHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.inventory.sessionbean.ProcessorFacade create()
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireProcessorFacadeHome().create();
	}
}
