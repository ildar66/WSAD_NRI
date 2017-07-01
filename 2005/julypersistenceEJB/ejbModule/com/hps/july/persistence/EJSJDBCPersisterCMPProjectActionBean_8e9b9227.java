package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProjectActionBean_8e9b9227
 */
public class EJSJDBCPersisterCMPProjectActionBean_8e9b9227 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProjectActionBean {
	private static final String _createString = "INSERT INTO projectactions (projectaction, plandate, agreement, hasproblems, completed, factdate, notes, order, suggplandate, isnewplandate, project, projectactiontype, equipment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM projectactions  WHERE projectaction = ?";
	private static final String _storeString = "UPDATE projectactions  SET plandate = ?, agreement = ?, hasproblems = ?, completed = ?, factdate = ?, notes = ?, order = ?, suggplandate = ?, isnewplandate = ?, project = ?, projectactiontype = ?, equipment = ? WHERE projectaction = ?";
	private static final String _loadString = "SELECT T1.plandate, T1.agreement, T1.hasproblems, T1.completed, T1.factdate, T1.notes, T1.order, T1.projectaction, T1.suggplandate, T1.isnewplandate, T1.project, T1.projectactiontype, T1.equipment FROM projectactions  T1 WHERE T1.projectaction = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProjectActionBean_8e9b9227
	 */
	public EJSJDBCPersisterCMPProjectActionBean_8e9b9227() throws java.rmi.RemoteException {
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
		ProjectActionBean b = (ProjectActionBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.plandate == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.plandate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.agreement);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.hasproblems));
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.completed);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.factdate == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.factdate);
			}
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(7, (byte[])objectTemp);
			}
			pstmt.setInt(8, b.order);
			pstmt.setInt(1, b.projectaction);
			if (b.suggplandate == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.suggplandate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isNewplandate);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.project_project == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.project_project.intValue());
			}
			if (b.projectactiontype_projectactiontype == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.projectactiontype_projectactiontype.intValue());
			}
			if (b.equipment_storageplace == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.equipment_storageplace.intValue());
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
		ProjectActionBean b = (ProjectActionBean) eb;
		com.hps.july.persistence.ProjectActionKey _primaryKey = (com.hps.july.persistence.ProjectActionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.projectaction = _primaryKey.projectaction;
		b.plandate = resultSet.getDate(1);
		b.agreement = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(2));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(3));
		b.hasproblems = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.completed = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(4));
		b.factdate = resultSet.getDate(5);
		b.notes = (java.lang.String)com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().objectFrom(resultSet.getBinaryStream(6));
		b.order = resultSet.getInt(7);
		b.suggplandate = resultSet.getDate(9);
		b.isNewplandate = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(10));
		tempint = resultSet.getInt(11);
		b.project_project = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(12);
		b.projectactiontype_projectactiontype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(13);
		b.equipment_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProjectActionBean b = (ProjectActionBean) eb;
		com.hps.july.persistence.ProjectActionKey _primaryKey = (com.hps.july.persistence.ProjectActionKey)pKey;
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
		ProjectActionBean b = (ProjectActionBean) eb;
		com.hps.july.persistence.ProjectActionKey _primaryKey = new com.hps.july.persistence.ProjectActionKey();
		_primaryKey.projectaction = b.projectaction;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProjectActionBean b = (ProjectActionBean) eb;
		com.hps.july.persistence.ProjectActionKey _primaryKey = new com.hps.july.persistence.ProjectActionKey();
		_primaryKey.projectaction = b.projectaction;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(13, _primaryKey.projectaction);
			if (b.plandate == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.plandate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.agreement);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.hasproblems));
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.completed);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.factdate == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.factdate);
			}
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(6, (byte[])objectTemp);
			}
			pstmt.setInt(7, b.order);
			if (b.suggplandate == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.suggplandate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isNewplandate);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.project_project == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.project_project.intValue());
			}
			if (b.projectactiontype_projectactiontype == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.projectactiontype_projectactiontype.intValue());
			}
			if (b.equipment_storageplace == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.equipment_storageplace.intValue());
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
		ProjectActionBean b = (ProjectActionBean) eb;
		com.hps.july.persistence.ProjectActionKey _primaryKey = new com.hps.july.persistence.ProjectActionKey();
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
		com.hps.july.persistence.ProjectActionKey key = new com.hps.july.persistence.ProjectActionKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.projectaction = resultSet.getInt(8);
			return key;
		}
return null;
	}
	/**
	 * findByProjectAndOrder
	 */
	public EJSFinder findByProjectAndOrder(java.lang.Integer Project, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.plandate, T1.agreement, T1.hasproblems, T1.completed, T1.factdate, T1.notes, T1.order, T1.projectaction, T1.suggplandate, T1.isnewplandate, T1.project, T1.projectactiontype, T1.equipment FROM projectactions  T1 WHERE project = ? AND order = ?");
			pstmt.setObject(1, Project);
			pstmt.setObject(2, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProjectActionsByProjectactiontype
	 */
	public EJSFinder findProjectActionsByProjectactiontype(com.hps.july.persistence.ProjectActionTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.plandate, T1.agreement, T1.hasproblems, T1.completed, T1.factdate, T1.notes, T1.order, T1.projectaction, T1.suggplandate, T1.isnewplandate, T1.project, T1.projectactiontype, T1.equipment FROM projectactions  T1 WHERE T1.projectactiontype = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProjectAction findByPrimaryKey(com.hps.july.persistence.ProjectActionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ProjectAction) home.activateBean(key);
	}
	/**
	 * findProjectActionsByProject
	 */
	public EJSFinder findProjectActionsByProject(com.hps.july.persistence.ProjectKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.plandate, T1.agreement, T1.hasproblems, T1.completed, T1.factdate, T1.notes, T1.order, T1.projectaction, T1.suggplandate, T1.isnewplandate, T1.project, T1.projectactiontype, T1.equipment FROM projectactions  T1 WHERE T1.project = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.project);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProjectActionsByEquipment
	 */
	public EJSFinder findProjectActionsByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.plandate, T1.agreement, T1.hasproblems, T1.completed, T1.factdate, T1.notes, T1.order, T1.projectaction, T1.suggplandate, T1.isnewplandate, T1.project, T1.projectactiontype, T1.equipment FROM projectactions  T1 WHERE T1.equipment = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storageplace);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByProjectOrderByOrderAsc
	 */
	public EJSFinder findByProjectOrderByOrderAsc(java.lang.Integer project) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.plandate, T1.agreement, T1.hasproblems, T1.completed, T1.factdate, T1.notes, T1.order, T1.projectaction, T1.suggplandate, T1.isnewplandate, T1.project, T1.projectactiontype, T1.equipment FROM projectactions  T1 WHERE project = ? ORDER BY order ASC");
			pstmt.setObject(1, project);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByProjectAndProjectActionType
	 */
	public EJSFinder findByProjectAndProjectActionType(java.lang.Integer project, java.lang.Integer projectActionType) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.plandate, T1.agreement, T1.hasproblems, T1.completed, T1.factdate, T1.notes, T1.order, T1.projectaction, T1.suggplandate, T1.isnewplandate, T1.project, T1.projectactiontype, T1.equipment FROM projectactions  T1 WHERE project = ? AND projectactiontype = ?");
			pstmt.setObject(1, project);
			pstmt.setObject(2, projectActionType);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
