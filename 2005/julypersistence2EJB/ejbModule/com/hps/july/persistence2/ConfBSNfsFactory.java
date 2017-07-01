package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ConfBSNfsFactory
 * @generated
 */
public class ConfBSNfsFactory extends AbstractEJBFactory {
	/**
	 * ConfBSNfsFactory
	 * @generated
	 */
	public ConfBSNfsFactory() {
		super();
	}
	/**
	 * _acquireConfBSNfsHome
	 * @generated
	 */
	protected com.hps.july.persistence2.ConfBSNfsHome _acquireConfBSNfsHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence2.ConfBSNfsHome) _acquireEJBHome();
	}
	/**
	 * acquireConfBSNfsHome
	 * @generated
	 */
	public com.hps.july.persistence2.ConfBSNfsHome acquireConfBSNfsHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence2.ConfBSNfsHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence2/ConfBSNfsHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.ConfBSNfsHome.class;
	}
	/**
	 * resetConfBSNfsHome
	 * @generated
	 */
	public void resetConfBSNfsHome() {
		resetEJBHome();
	}
	/**
	 * setConfBSNfsHome
	 * @generated
	 */
	public void setConfBSNfsHome(
		com.hps.july.persistence2.ConfBSNfsHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.ConfBSNfs findByPrimaryKey(
		com.hps.july.persistence2.ConfBSNfsKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireConfBSNfsHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * findByAll
	 * @generated
	 */
	public java.util.Enumeration findByAll(
		java.lang.String argConfType,
		int argSectA,
		int argSectB,
		int argSectC,
		int argSectD,
		int argSectE,
		int argSectF,
		int argSectG,
		int argSectH,
		java.math.BigDecimal argVoltage,
		java.lang.String argNFSId,
		int argCodeNRI)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireConfBSNfsHome().findByAll(
			argConfType,
			argSectA,
			argSectB,
			argSectC,
			argSectD,
			argSectE,
			argSectF,
			argSectG,
			argSectH,
			argVoltage,
			argNFSId,
			argCodeNRI);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.ConfBSNfs create(
		int argId,
		int argCodeNri,
		int argSectorA,
		int argSectorB,
		int argSectorC,
		int argSectorD,
		int argSectorE,
		int argSectorF,
		int argSectorG,
		int argSectorH,
		java.lang.String argNfsItemId,
		java.lang.String argConfType,
		int argSect_o900,
		int argSect_o1800)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireConfBSNfsHome().create(
			argId,
			argCodeNri,
			argSectorA,
			argSectorB,
			argSectorC,
			argSectorD,
			argSectorE,
			argSectorF,
			argSectorG,
			argSectorH,
			argNfsItemId,
			argConfType,
			argSect_o900,
			argSect_o1800);
	}
}
