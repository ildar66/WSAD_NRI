package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPRRLAntParamsBean_f2fc01d9
 */
public class EJSJDBCPersisterCMPRRLAntParamsBean_f2fc01d9 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderRRLAntParamsBean {
	private static final String _createString = "INSERT INTO rrlantparams (rrlantid, amplifkoeff, antdiam, dnangleh, dnanglew, resource) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM rrlantparams  WHERE rrlantid = ?";
	private static final String _storeString = "UPDATE rrlantparams  SET amplifkoeff = ?, antdiam = ?, dnangleh = ?, dnanglew = ?, resource = ? WHERE rrlantid = ?";
	private static final String _loadString = "SELECT T1.rrlantid, T1.amplifkoeff, T1.antdiam, T1.dnangleh, T1.dnanglew, T1.resource FROM rrlantparams  T1 WHERE T1.rrlantid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPRRLAntParamsBean_f2fc01d9
	 */
	public EJSJDBCPersisterCMPRRLAntParamsBean_f2fc01d9() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postInit
	 */
	public void postInit() {
	}
	/**
	 * _create
	 */
	public void _create(EntityBean eb) throws Exception {
		Object objectTemp = null;
		RRLAntParamsBean b = (RRLAntParamsBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.rrlantid);
			if (b.amplifkoeff == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.amplifkoeff);
			}
			if (b.antdiam == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.antdiam);
			}
			if (b.dnangleh == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.dnangleh);
			}
			if (b.dnanglew == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.dnanglew);
			}
			pstmt.setInt(6, b.resource);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		RRLAntParamsBean b = (RRLAntParamsBean) eb;
		com.hps.july.persistence.RRLAntParamsKey _primaryKey = (com.hps.july.persistence.RRLAntParamsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.rrlantid = _primaryKey.rrlantid;
		b.amplifkoeff = resultSet.getBigDecimal(2);
		b.antdiam = resultSet.getBigDecimal(3);
		b.dnangleh = resultSet.getBigDecimal(4);
		b.dnanglew = resultSet.getBigDecimal(5);
		b.resource = resultSet.getInt(6);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		RRLAntParamsBean b = (RRLAntParamsBean) eb;
		com.hps.july.persistence.RRLAntParamsKey _primaryKey = (com.hps.july.persistence.RRLAntParamsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.rrlantid);
			resultSet = pstmt.executeQuery();
			if (!(resultSet.next())) throw new javax.ejb.ObjectNotFoundException();
			hydrate(eb, resultSet, pKey);
		}
		finally {
			if (resultSet != null) resultSet.close();
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * refresh
	 */
	public void refresh(EntityBean eb, boolean forUpdate) throws Exception {
		RRLAntParamsBean b = (RRLAntParamsBean) eb;
		com.hps.july.persistence.RRLAntParamsKey _primaryKey = new com.hps.july.persistence.RRLAntParamsKey();
		_primaryKey.rrlantid = b.rrlantid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		RRLAntParamsBean b = (RRLAntParamsBean) eb;
		com.hps.july.persistence.RRLAntParamsKey _primaryKey = new com.hps.july.persistence.RRLAntParamsKey();
		_primaryKey.rrlantid = b.rrlantid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(6, _primaryKey.rrlantid);
			if (b.amplifkoeff == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.amplifkoeff);
			}
			if (b.antdiam == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.antdiam);
			}
			if (b.dnangleh == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.dnangleh);
			}
			if (b.dnanglew == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.dnanglew);
			}
			pstmt.setInt(5, b.resource);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * remove
	 */
	public void remove(EntityBean eb) throws Exception {
		Object objectTemp = null;
		RRLAntParamsBean b = (RRLAntParamsBean) eb;
		com.hps.july.persistence.RRLAntParamsKey _primaryKey = new com.hps.july.persistence.RRLAntParamsKey();
		_primaryKey.rrlantid = b.rrlantid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.rrlantid);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence.RRLAntParamsKey key = new com.hps.july.persistence.RRLAntParamsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.rrlantid = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.RRLAntParams findByPrimaryKey(com.hps.july.persistence.RRLAntParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.RRLAntParams) home.activateBean(key);
	}
	/**
	 * findByResourceAndDiam
	 */
	public EJSFinder findByResourceAndDiam(int argResource, java.math.BigDecimal argDiam) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.rrlantid, T1.amplifkoeff, T1.antdiam, T1.dnangleh, T1.dnanglew, T1.resource FROM rrlantparams  T1 WHERE resource = ? AND antdiam = ?");
			pstmt.setInt(1, argResource);
			pstmt.setBigDecimal(2, argDiam);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByResource
	 */
	public EJSFinder findByResource(int argResource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.rrlantid, T1.amplifkoeff, T1.antdiam, T1.dnangleh, T1.dnanglew, T1.resource FROM rrlantparams  T1 WHERE resource = ?");
			pstmt.setInt(1, argResource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
