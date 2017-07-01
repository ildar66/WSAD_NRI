package com.hps.july.persistence2;
/**
 * Home interface for Enterprise Bean: ConfBSNfs
 */
public interface ConfBSNfsHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: ConfBSNfs
	 */
	public com.hps.july.persistence2.ConfBSNfs findByPrimaryKey(
		com.hps.july.persistence2.ConfBSNfsKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	public java.util.Enumeration findByAll(java.lang.String argConfType, int argSectA, int argSectB, int argSectC, int argSectD, int argSectE, int argSectF, int argSectG, int argSectH, java.math.BigDecimal argVoltage, java.lang.String argNFSId, int argCodeNRI) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
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
		String argNfsItemId,
		String argConfType,
		int argSect_o900,
		int argSect_o1800)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
