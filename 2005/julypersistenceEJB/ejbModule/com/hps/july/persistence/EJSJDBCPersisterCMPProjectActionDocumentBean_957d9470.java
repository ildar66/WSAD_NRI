package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPProjectActionDocumentBean_957d9470
 */
public class EJSJDBCPersisterCMPProjectActionDocumentBean_957d9470 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderProjectActionDocumentBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO projactiondocs (prjactdoc, docname, docbody, docdate, notes, projectaction) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM projactiondocs  WHERE prjactdoc = ?";
	private static final String _storeString = "UPDATE projactiondocs  SET docname = ?, docbody = ?, docdate = ?, notes = ?, projectaction = ? WHERE prjactdoc = ?";
	private static final String _loadString = "SELECT T1.prjactdoc, T1.docname, T1.docbody, T1.docdate, T1.notes, T1.projectaction FROM projactiondocs  T1 WHERE T1.prjactdoc = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPProjectActionDocumentBean_957d9470
	 */
	public EJSJDBCPersisterCMPProjectActionDocumentBean_957d9470() throws java.rmi.RemoteException {
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
		ProjectActionDocumentBean b = (ProjectActionDocumentBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.projectactiondocument);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.docbody == null) {
				pstmt.setNull(3, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(3, b.docbody);
			}
			if (b.docdate == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.docdate);
			}
			if (b.notes == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.notes);
			}
			if (b.projectaction_projectaction == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.projectaction_projectaction.intValue());
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
		ProjectActionDocumentBean b = (ProjectActionDocumentBean) eb;
		com.hps.july.persistence.ProjectActionDocumentKey _primaryKey = (com.hps.july.persistence.ProjectActionDocumentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.projectactiondocument = _primaryKey.projectactiondocument;
		b.docname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.docbody = resultSet.getBytes(3);
		b.docdate = resultSet.getDate(4);
		b.notes = resultSet.getString(5);
		tempint = resultSet.getInt(6);
		b.projectaction_projectaction = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ProjectActionDocumentBean b = (ProjectActionDocumentBean) eb;
		com.hps.july.persistence.ProjectActionDocumentKey _primaryKey = (com.hps.july.persistence.ProjectActionDocumentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.projectactiondocument);
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
		ProjectActionDocumentBean b = (ProjectActionDocumentBean) eb;
		com.hps.july.persistence.ProjectActionDocumentKey _primaryKey = new com.hps.july.persistence.ProjectActionDocumentKey();
		_primaryKey.projectactiondocument = b.projectactiondocument;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ProjectActionDocumentBean b = (ProjectActionDocumentBean) eb;
		com.hps.july.persistence.ProjectActionDocumentKey _primaryKey = new com.hps.july.persistence.ProjectActionDocumentKey();
		_primaryKey.projectactiondocument = b.projectactiondocument;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(6, _primaryKey.projectactiondocument);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docname);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.docbody == null) {
				pstmt.setNull(2, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(2, b.docbody);
			}
			if (b.docdate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.docdate);
			}
			if (b.notes == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(4, b.notes);
			}
			if (b.projectaction_projectaction == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.projectaction_projectaction.intValue());
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
		ProjectActionDocumentBean b = (ProjectActionDocumentBean) eb;
		com.hps.july.persistence.ProjectActionDocumentKey _primaryKey = new com.hps.july.persistence.ProjectActionDocumentKey();
		_primaryKey.projectactiondocument = b.projectactiondocument;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.projectactiondocument);
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
		com.hps.july.persistence.ProjectActionDocumentKey key = new com.hps.july.persistence.ProjectActionDocumentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.projectactiondocument = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Integer argProject, java.lang.Boolean isProjectAction, java.lang.Integer argProjectaction, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(argProject, isProjectAction, argProjectaction, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findProjectActionDocumentsByProjectaction
	 */
	public EJSFinder findProjectActionDocumentsByProjectaction(com.hps.july.persistence.ProjectActionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.prjactdoc, T1.docname, T1.docbody, T1.docdate, T1.notes, T1.projectaction FROM projactiondocs  T1 WHERE T1.projectaction = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.projectaction);
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
	public com.hps.july.persistence.ProjectActionDocument findByPrimaryKey(com.hps.july.persistence.ProjectActionDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.ProjectActionDocument) home.activateBean(key);
	}
	private static final String genericFindSqlString = "SELECT T1.prjactdoc, T1.docname, T1.docbody, T1.docdate, T1.notes, T1.projectaction FROM projactiondocs  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {114};
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
	private ProjectActionDocumentBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.ProjectActionDocumentBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.ProjectActionDocumentBeanFinderObject temp_finderObject = new com.hps.july.persistence.ProjectActionDocumentBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
