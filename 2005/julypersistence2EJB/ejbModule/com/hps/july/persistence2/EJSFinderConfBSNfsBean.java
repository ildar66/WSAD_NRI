package com.hps.july.persistence2;

/**
 * EJSFinderConfBSNfsBean
 */
public interface EJSFinderConfBSNfsBean {
	/**
	 * findByAll
	 */
	public com.ibm.ejs.persistence.EJSFinder findByAll(java.lang.String argConfType, int argSectA, int argSectB, int argSectC, int argSectD, int argSectE, int argSectF, int argSectG, int argSectH, java.math.BigDecimal argVoltage, java.lang.String argNFSId, int argCodeNRI) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
