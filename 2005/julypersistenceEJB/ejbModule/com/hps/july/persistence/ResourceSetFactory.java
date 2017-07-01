package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ResourceSetFactory
 * @generated
 */
public class ResourceSetFactory extends AbstractEJBFactory {
	/**
	 * ResourceSetFactory
	 * @generated
	 */
	public ResourceSetFactory() {
		super();
	}
	/**
	 * _acquireResourceSetHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.ResourceSetHome _acquireResourceSetHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.ResourceSetHome) _acquireEJBHome();
	}
	/**
	 * acquireResourceSetHome
	 * @generated
	 */
	public com.hps.july.persistence.ResourceSetHome acquireResourceSetHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.ResourceSetHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/ResourceSet";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.ResourceSetHome.class;
	}
	/**
	 * resetResourceSetHome
	 * @generated
	 */
	public void resetResourceSetHome() {
		resetEJBHome();
	}
	/**
	 * setResourceSetHome
	 * @generated
	 */
	public void setResourceSetHome(
		com.hps.july.persistence.ResourceSetHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.ResourceSet create(
		int argResourceset,
		java.lang.String argName,
		java.lang.Integer argMainPart,
		java.math.BigDecimal argMainPartQty,
		java.lang.String argType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireResourceSetHome().create(
			argResourceset,
			argName,
			argMainPart,
			argMainPartQty,
			argType);
	}
	/**
	 * findResourceSetsBySubtype
	 * @generated
	 */
	public java.util.Enumeration findResourceSetsBySubtype(
		java.lang.Integer argSubtype)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceSetHome().findResourceSetsBySubtype(argSubtype);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.ResourceSet findByPrimaryKey(
		com.hps.july.persistence.ResourceSetKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceSetHome().findByPrimaryKey(key);
	}
	/**
	 * findResourceSetsByMainpart
	 * @generated
	 */
	public java.util.Enumeration findResourceSetsByMainpart(
		com.hps.july.persistence.ResourceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceSetHome().findResourceSetsByMainpart(inKey);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isSubtypekey,
		com.hps.july.persistence.ResourceSubTypeKey subtypeKey,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireResourceSetHome().findByQBE(
			isSubtypekey,
			subtypeKey,
			isModel,
			model,
			isName,
			name,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.ResourceSet create(int argResourceset)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireResourceSetHome().create(argResourceset);
	}
}
