package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProtoActionBean_80500ecc
 */
public class EJSJDBCPersisterCMPProtoActionBean_80500ecc extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProtoActionBean {
	private static final String _createString = "INSERT INTO protoactions (projectaction, duration, order, stepbefore, projecttype, projectactiontype) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM protoactions  WHERE projectaction = ?";
	private static final String _storeString = "UPDATE protoactions  SET duration = ?, order = ?, stepbefore = ?, projecttype = ?, projectactiontype = ? WHERE projectaction = ?";
	private static final String _loadString = "SELECT T1.projectaction, T1.duration, T1.order, T1.stepbefore, T1.projecttype, T1.projectactiontype FROM protoactions  T1 WHERE T1.projectaction = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProtoActionBean_80500ecc
	 */
	public EJSJDBCPersisterCMPProtoActionBean_80500ecc() throws java.rmi.RemoteException {
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
		ProtoActionBean b = (ProtoActionBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.projectaction);
			pstmt.setInt(2, b.duration);
			pstmt.setInt(3, b.order);
			if (b.stepbefore == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.stepbefore.intValue());
			}
			if (b.projectType_projecttype == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.projectType_projecttype.intValue());
			}
			if (b.projectActionType_projectactiontype == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.projectActionType_projectactiontype.intValue());
			}
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
		ProtoActionBean b = (ProtoActionBean) eb;
		com.hps.july.persistence.ProtoActionKey _primaryKey = (com.hps.july.persistence.ProtoActionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.projectaction = _primaryKey.projectaction;
		b.duration = resultSet.getInt(2);
		b.order = resultSet.getInt(3);
		tempint = resultSet.getInt(4);
		b.stepbefore = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.projectType_projecttype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		b.projectActionType_projectactiontype = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProtoActionBean b = (ProtoActionBean) eb;
		com.hps.july.persistence.ProtoActionKey _primaryKey = (com.hps.july.persistence.ProtoActionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.projectaction);
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
		ProtoActionBean b = (ProtoActionBean) eb;
		com.hps.july.persistence.ProtoActionKey _primaryKey = new com.hps.july.persistence.ProtoActionKey();
		_primaryKey.projectaction = b.projectaction;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProtoActionBean b = (ProtoActionBean) eb;
		com.hps.july.persistence.ProtoActionKey _primaryKey = new com.hps.july.persistence.ProtoActionKey();
		_primaryKey.projectaction = b.projectaction;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(6, _primaryKey.projectaction);
			pstmt.setInt(1, b.duration);
			pstmt.setInt(2, b.order);
			if (b.stepbefore == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.stepbefore.intValue());
			}
			if (b.projectType_projecttype == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.projectType_projecttype.intValue());
			}
			if (b.projectActionType_projectactiontype == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.projectActionType_projectactiontype.intValue());
			}
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
		ProtoActionBean b = (ProtoActionBean) eb;
		com.hps.july.persistence.ProtoActionKey _primaryKey = new com.hps.july.persistence.ProtoActionKey();
		_primaryKey.projectaction = b.projectaction;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.projectaction);
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
		com.hps.july.persistence.ProtoActionKey key = new com.hps.july.persistence.ProtoActionKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.projectaction = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findProtoActionsByProjectActionType
	 */
	public EJSFinder findProtoActionsByProjectActionType(com.hps.july.persistence.ProjectActionTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.projectaction, T1.duration, T1.order, T1.stepbefore, T1.projecttype, T1.projectactiontype FROM protoactions  T1 WHERE T1.projectactiontype = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.projectactiontype);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findStepsBeforeOrderByOrderAsc
	 */
	public EJSFinder findStepsBeforeOrderByOrderAsc(java.lang.Integer argProjectType, java.lang.Integer argProjectAction) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.projectaction, T1.duration, T1.order, T1.stepbefore, T1.projecttype, T1.projectactiontype FROM protoactions  T1 WHERE projecttype = ? AND projectaction <> ? ORDER BY order asc");
			pstmt.setObject(1, argProjectType);
			pstmt.setObject(2, argProjectAction);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProtoActionsByProjectType
	 */
	public EJSFinder findProtoActionsByProjectType(com.hps.july.persistence.ProjectTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.projectaction, T1.duration, T1.order, T1.stepbefore, T1.projecttype, T1.projectactiontype FROM protoactions  T1 WHERE T1.projecttype = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.projecttype);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProtoAction findByPrimaryKey(com.hps.july.persistence.ProtoActionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ProtoAction) home.activateBean(key);
	}
	/**
	 * findByProjectactiontypeOrderByOrderAsc
	 */
	public EJSFinder findByProjectactiontypeOrderByOrderAsc(java.lang.Integer projectactiontype) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.projectaction, T1.duration, T1.order, T1.stepbefore, T1.projecttype, T1.projectactiontype FROM protoactions  T1 WHERE projectactiontype = ? ORDER BY order asc");
			pstmt.setObject(1, projectactiontype);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByProjecttypeOrderByOrderAsc
	 */
	public EJSFinder findByProjecttypeOrderByOrderAsc(java.lang.Integer projecttype) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.projectaction, T1.duration, T1.order, T1.stepbefore, T1.projecttype, T1.projectactiontype FROM protoactions  T1 WHERE projecttype = ? ORDER BY order asc");
			pstmt.setObject(1, projecttype);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
