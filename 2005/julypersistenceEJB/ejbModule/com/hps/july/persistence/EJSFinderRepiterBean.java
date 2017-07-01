package com.hps.july.persistence;

/**
 * EJSFinderRepiterBean
 */
public interface EJSFinderRepiterBean {
	/**
	 * findRepitersByDonor_sect
	 */
	public com.ibm.ejs.persistence.EJSFinder findRepitersByDonor_sect(com.hps.july.persistence.SectorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRepitersByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findRepitersByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isDonorSect, java.lang.Integer donorSect, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRepitersByDonor_ant
	 */
	public com.ibm.ejs.persistence.EJSFinder findRepitersByDonor_ant(com.hps.july.persistence.AntennaKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPlatinumAndStatus
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPlatinumAndStatus(java.lang.Integer position, java.lang.Integer owner, java.lang.String state, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
