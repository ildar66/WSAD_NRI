package com.hps.july.persistence;

/**
 * EJSFinderProjectBean
 */
public interface EJSFinderProjectBean {
	/**
	 * findProjectsByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectsByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Integer division, java.lang.Integer projecttype, java.lang.Boolean isSupregions, java.lang.Integer[] supregions, java.lang.Boolean isRegions, java.lang.Integer[] regions, java.lang.Boolean isNetzones, java.lang.Integer[] netzones, java.lang.Boolean isPosition, java.lang.Integer argPosition, java.lang.Boolean isResponsible, java.lang.Integer argResponsible, java.lang.Boolean isEndDate, java.lang.Short endMonth, java.lang.Integer endYear, java.lang.Boolean isProjectstate, java.lang.String argProjectstate, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectsByContructer
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectsByContructer(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE1
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE1(java.lang.Integer projecttype, java.lang.Boolean isProjectstate, java.lang.String argProjectstate, java.lang.Boolean isPosition, java.lang.Integer argPosition, java.lang.Boolean isNetzone, java.lang.Integer argNetzone, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findVcprojectsByVccontructer
	 */
	public com.ibm.ejs.persistence.EJSFinder findVcprojectsByVccontructer(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectsByProjecttype
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectsByProjecttype(com.hps.july.persistence.ProjectTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
