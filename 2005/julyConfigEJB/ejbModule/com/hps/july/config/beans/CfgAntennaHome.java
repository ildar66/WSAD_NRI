package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgAntenna
 */
public interface CfgAntennaHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgAntenna
	 */
	public com.hps.july.config.beans.CfgAntenna findByPrimaryKey(
		com.hps.july.config.beans.CfgAntennaKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
		
	public com.hps.july.config.beans.CfgAntenna create(
		int savconfigid,
		int id_anten,
		int resource, String num_ant, String kind_ant,
		java.math.BigDecimal nakl, java.math.BigDecimal az_ant,
		java.math.BigDecimal h_set1, java.math.BigDecimal len_cable,
		int equipment, boolean byhand, String locationtype,
		int datasource, String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
