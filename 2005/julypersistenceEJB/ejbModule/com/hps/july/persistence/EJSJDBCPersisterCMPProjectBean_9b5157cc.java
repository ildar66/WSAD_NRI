package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProjectBean_9b5157cc
 */
public class EJSJDBCPersisterCMPProjectBean_9b5157cc extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProjectBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO projects (project, notes, yearfinish, monthfinish, name, datestart, vctext, projecttype, position, vccontructer, contructer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM projects  WHERE project = ?";
	private static final String _storeString = "UPDATE projects  SET notes = ?, yearfinish = ?, monthfinish = ?, name = ?, datestart = ?, vctext = ?, projecttype = ?, position = ?, vccontructer = ?, contructer = ? WHERE project = ?";
	private static final String _loadString = "SELECT T1.notes, T1.yearfinish, T1.monthfinish, T1.project, T1.name, T1.datestart, T1.vctext, T1.projecttype, T1.position, T1.vccontructer, T1.contructer FROM projects  T1 WHERE T1.project = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProjectBean_9b5157cc
	 */
	public EJSJDBCPersisterCMPProjectBean_9b5157cc() throws java.rmi.RemoteException {
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
		ProjectBean b = (ProjectBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(2, (byte[])objectTemp);
			}
			if (b.yearfinish == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.yearfinish.intValue());
			}
			if (b.monthfinish == null) {
				pstmt.setNull(4, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(4, b.monthfinish.shortValue());
			}
			pstmt.setInt(1, b.project);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.datestart == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.datestart);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.vctext);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.projecttype_projecttype == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.projecttype_projecttype.intValue());
			}
			if (b.position_storageplace == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.position_storageplace.intValue());
			}
			if (b.vccontructer_organization == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.vccontructer_organization.intValue());
			}
			if (b.contructer_organization == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.contructer_organization.intValue());
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
		ProjectBean b = (ProjectBean) eb;
		com.hps.july.persistence.ProjectKey _primaryKey = (com.hps.july.persistence.ProjectKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.project = _primaryKey.project;
		b.notes = (java.lang.String)com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().objectFrom(resultSet.getBinaryStream(1));
		tempint = resultSet.getInt(2);
		b.yearfinish = resultSet.wasNull() ? null : new Integer(tempint);
		tempshort = resultSet.getShort(3);
		b.monthfinish = resultSet.wasNull() ? null : new Short(tempshort);
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.datestart = resultSet.getDate(6);
		b.vctext = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		tempint = resultSet.getInt(8);
		b.projecttype_projecttype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		b.position_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		b.vccontructer_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(11);
		b.contructer_organization = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProjectBean b = (ProjectBean) eb;
		com.hps.july.persistence.ProjectKey _primaryKey = (com.hps.july.persistence.ProjectKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.project);
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
		ProjectBean b = (ProjectBean) eb;
		com.hps.july.persistence.ProjectKey _primaryKey = new com.hps.july.persistence.ProjectKey();
		_primaryKey.project = b.project;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProjectBean b = (ProjectBean) eb;
		com.hps.july.persistence.ProjectKey _primaryKey = new com.hps.july.persistence.ProjectKey();
		_primaryKey.project = b.project;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(11, _primaryKey.project);
			objectTemp = com.hps.july.persistence.JulyAsciiStreamToStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(1, (byte[])objectTemp);
			}
			if (b.yearfinish == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.yearfinish.intValue());
			}
			if (b.monthfinish == null) {
				pstmt.setNull(3, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(3, b.monthfinish.shortValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.datestart == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.datestart);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.vctext);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.projecttype_projecttype == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.projecttype_projecttype.intValue());
			}
			if (b.position_storageplace == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.position_storageplace.intValue());
			}
			if (b.vccontructer_organization == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.vccontructer_organization.intValue());
			}
			if (b.contructer_organization == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.contructer_organization.intValue());
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
		ProjectBean b = (ProjectBean) eb;
		com.hps.july.persistence.ProjectKey _primaryKey = new com.hps.july.persistence.ProjectKey();
		_primaryKey.project = b.project;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.project);
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
		com.hps.july.persistence.ProjectKey key = new com.hps.july.persistence.ProjectKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.project = resultSet.getInt(4);
			return key;
		}
return null;
	}
	/**
	 * findProjectsByPosition
	 */
	public EJSFinder findProjectsByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.notes, T1.yearfinish, T1.monthfinish, T1.project, T1.name, T1.datestart, T1.vctext, T1.projecttype, T1.position, T1.vccontructer, T1.contructer FROM projects  T1 WHERE T1.position = ?");
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
	 * findByQBE2
	 */
	public EJSFinder findByQBE2(java.lang.Integer division, java.lang.Integer projecttype, java.lang.Boolean isSupregions, java.lang.Integer[] supregions, java.lang.Boolean isRegions, java.lang.Integer[] regions, java.lang.Boolean isNetzones, java.lang.Integer[] netzones, java.lang.Boolean isPosition, java.lang.Integer argPosition, java.lang.Boolean isResponsible, java.lang.Integer argResponsible, java.lang.Boolean isEndDate, java.lang.Short endMonth, java.lang.Integer endYear, java.lang.Boolean isProjectstate, java.lang.String argProjectstate, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE2(division, projecttype, isSupregions, supregions, isRegions, regions, isNetzones, netzones, isPosition, argPosition, isResponsible, argResponsible, isEndDate, endMonth, endYear, isProjectstate, argProjectstate, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProjectsByContructer
	 */
	public EJSFinder findProjectsByContructer(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.notes, T1.yearfinish, T1.monthfinish, T1.project, T1.name, T1.datestart, T1.vctext, T1.projecttype, T1.position, T1.vccontructer, T1.contructer FROM projects  T1 WHERE T1.contructer = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.organization);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE1
	 */
	public EJSFinder findByQBE1(java.lang.Integer projecttype, java.lang.Boolean isProjectstate, java.lang.String argProjectstate, java.lang.Boolean isPosition, java.lang.Integer argPosition, java.lang.Boolean isNetzone, java.lang.Integer argNetzone, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE1(projecttype, isProjectstate, argProjectstate, isPosition, argPosition, isNetzone, argNetzone, order);
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
	public com.hps.july.persistence.Project findByPrimaryKey(com.hps.july.persistence.ProjectKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Project) home.activateBean(key);
	}
	/**
	 * findVcprojectsByVccontructer
	 */
	public EJSFinder findVcprojectsByVccontructer(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.notes, T1.yearfinish, T1.monthfinish, T1.project, T1.name, T1.datestart, T1.vctext, T1.projecttype, T1.position, T1.vccontructer, T1.contructer FROM projects  T1 WHERE T1.vccontructer = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.organization);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProjectsByProjecttype
	 */
	public EJSFinder findProjectsByProjecttype(com.hps.july.persistence.ProjectTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.notes, T1.yearfinish, T1.monthfinish, T1.project, T1.name, T1.datestart, T1.vctext, T1.projecttype, T1.position, T1.vccontructer, T1.contructer FROM projects  T1 WHERE T1.projecttype = ?");
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
	private static final String genericFindSqlString = "SELECT T1.notes, T1.yearfinish, T1.monthfinish, T1.project, T1.name, T1.datestart, T1.vctext, T1.projecttype, T1.position, T1.vccontructer, T1.contructer FROM projects  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {178};
	/**
	 * getMergedPreparedStatement
	 */
	public PreparedStatement getMergedPreparedStatement(String searchCondition) throws Exception {
		StringBuffer sb = new StringBuffer(genericFindSqlString);
		for (int i = 0; i < genericFindInsertPoints.length; i++) {
		   sb.insert(genericFindInsertPoints[i], searchCondition);
		}
		return super.getPreparedStatement(sb.toString());
	}
	/**
	 * getMergedWhereCount
	 */
	public int getMergedWhereCount() {
		return genericFindInsertPoints.length;
	}
	/**
	 * getGenericFindSqlString
	 */
	public String getGenericFindSqlString() {
		return genericFindSqlString;
	}
	/**
	 * getGenericFindInsertPoints
	 */
	public int[] getGenericFindInsertPoints() {
		return genericFindInsertPoints;
	}
	private ProjectBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.ProjectBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.ProjectBeanFinderObject temp_finderObject = new com.hps.july.persistence.ProjectBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
