package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * I13nActPositionFactory
 * @generated
 */
public class I13nActPositionFactory extends AbstractEJBFactory {
	/**
	 * I13nActPositionFactory
	 * @generated
	 */
	public I13nActPositionFactory() {
		super();
	}
	/**
	 * _acquireI13nActPositionHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.I13nActPositionHome _acquireI13nActPositionHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.I13nActPositionHome) _acquireEJBHome();
	}
	/**
	 * acquireI13nActPositionHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.I13nActPositionHome acquireI13nActPositionHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.I13nActPositionHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/I13nActPosition";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.I13nActPositionHome.class;
	}
	/**
	 * resetI13nActPositionHome
	 * @generated
	 */
	public void resetI13nActPositionHome() {
		resetEJBHome();
	}
	/**
	 * setI13nActPositionHome
	 * @generated
	 */
	public void setI13nActPositionHome(
		com.hps.july.persistence.I13nActPositionHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.I13nActPosition findByPrimaryKey(
		com.hps.july.persistence.DocumentPositionKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireI13nActPositionHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.I13nActPosition create(
		int argDocposition,
		java.lang.Integer argResource,
		java.lang.Integer argOwner,
		java.lang.Integer argDocument,
		int argOrder,
		java.math.BigDecimal argQty,
		java.math.BigDecimal argPrice,
		java.lang.Boolean argSourceBoxed,
		java.lang.Boolean argResultBoxed,
		java.lang.Boolean argSourceBroken,
		java.lang.Boolean argResultBroken,
		java.lang.String argState,
		java.lang.Boolean argSourceClosed,
		java.lang.Boolean argResultClosed)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireI13nActPositionHome().create(
			argDocposition,
			argResource,
			argOwner,
			argDocument,
			argOrder,
			argQty,
			argPrice,
			argSourceBoxed,
			argResultBoxed,
			argSourceBroken,
			argResultBroken,
			argState,
			argSourceClosed,
			argResultClosed);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.I13nActPosition create(int argDocposition)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireI13nActPositionHome().create(argDocposition);
	}
	/**
	 * findI13nActPositionByContract
	 * @generated
	 */
	public java.util.Enumeration findI13nActPositionByContract(
		com.hps.july.persistence.DocumentKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireI13nActPositionHome().findI13nActPositionByContract(
			inKey);
	}
}
