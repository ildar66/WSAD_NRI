package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPBSInstComplectResourceSetBean_c1bebc4d
 */
public class EJSJDBCPersisterCMPBSInstComplectResourceSetBean_c1bebc4d extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderBSInstComplectResourceSetBean {
	private static final String[] _createString = {"INSERT INTO resourcesets (resourceset, mainpartqty, type, name, resourcesetclass, nfsitem_id, mainpart) VALUES (?, ?, ?, ?, ?, ?, ?)", "INSERT INTO bsinstcomplectresourceset (resourceset) VALUES (?)"};
	private static final String[] _removeString = {"DELETE FROM bsinstcomplectresourceset  WHERE resourceset = ?", "DELETE FROM resourcesets  WHERE resourceset = ?"};
	private static final String _storeString = "UPDATE resourcesets  SET mainpartqty = ?, type = ?, name = ?, resourcesetclass = ?, nfsitem_id = ?, mainpart = ? WHERE resourceset = ?";
	private static final String _loadString = "SELECT T2.mainpartqty, T2.resourceset, T2.type, T2.name, T2.resourcesetclass, T2.nfsitem_id, T2.mainpart FROM resourcesets  T2, bsinstcomplectresourceset  T1 WHERE T2.resourcesetclass = 2 AND T2.resourceset = T1.resourceset AND T2.resourceset = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPBSInstComplectResourceSetBean_c1bebc4d
	 */
	public EJSJDBCPersisterCMPBSInstComplectResourceSetBean_c1bebc4d() throws java.rmi.RemoteException {
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
		BSInstComplectResourceSetBean b = (BSInstComplectResourceSetBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			if (b.mainpartqty == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.mainpartqty);
			}
			pstmt.setInt(1, b.resourceset);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.resourcesetclass == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.resourcesetclass.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.nfsitemid);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.mainpart_resource == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.mainpart_resource.intValue());
			}
			pstmt.setInt(5, 2);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			pstmt.setInt(1, b.resourceset);
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
		BSInstComplectResourceSetBean b = (BSInstComplectResourceSetBean) eb;
		com.hps.july.persistence.ResourceSetKey _primaryKey = (com.hps.july.persistence.ResourceSetKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.resourceset = _primaryKey.resourceset;
		b.mainpartqty = resultSet.getBigDecimal(1);
		b.type = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		tempint = resultSet.getInt(5);
		b.resourcesetclass = resultSet.wasNull() ? null : new Integer(tempint);
		b.nfsitemid = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		tempint = resultSet.getInt(7);
		b.mainpart_resource = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		BSInstComplectResourceSetBean b = (BSInstComplectResourceSetBean) eb;
		com.hps.july.persistence.ResourceSetKey _primaryKey = (com.hps.july.persistence.ResourceSetKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.resourceset);
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
		BSInstComplectResourceSetBean b = (BSInstComplectResourceSetBean) eb;
		com.hps.july.persistence.ResourceSetKey _primaryKey = new com.hps.july.persistence.ResourceSetKey();
		_primaryKey.resourceset = b.resourceset;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		BSInstComplectResourceSetBean b = (BSInstComplectResourceSetBean) eb;
		com.hps.july.persistence.ResourceSetKey _primaryKey = new com.hps.july.persistence.ResourceSetKey();
		_primaryKey.resourceset = b.resourceset;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(7, _primaryKey.resourceset);
			if (b.mainpartqty == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.mainpartqty);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.resourcesetclass == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.resourcesetclass.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.nfsitemid);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.mainpart_resource == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.mainpart_resource.intValue());
			}
			pstmt.setInt(4, 2);
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
		BSInstComplectResourceSetBean b = (BSInstComplectResourceSetBean) eb;
		com.hps.july.persistence.ResourceSetKey _primaryKey = new com.hps.july.persistence.ResourceSetKey();
		_primaryKey.resourceset = b.resourceset;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.resourceset);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.resourceset);
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
		com.hps.july.persistence.ResourceSetKey key = new com.hps.july.persistence.ResourceSetKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.resourceset = resultSet.getInt(2);
			return key;
		}
return null;
	}
	/**
	 * getBean
	 */
	public javax.ejb.EJBObject getBean(Object obj) throws Exception {
		javax.ejb.EJBObject bean = null;
		ResultSet rs = (ResultSet) obj;
		Integer discriminator = new Integer (rs.getInt(5));
		if ( discriminator.equals( new Integer("2")) ) {
			bean = super.getBean(obj);
		}
		if (bean == null) {
			try{
				if (rs != null) rs.close();
			}
			catch (SQLException sqlExc) {}
			throw new EJSPersistenceException("Unknown or superclass discriminator value retrieved from database.");
		}
		return bean;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.BSInstComplectResourceSet findByPrimaryKey(com.hps.july.persistence.ResourceSetKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.BSInstComplectResourceSet result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.ResourceSetKey _primaryKey = (com.hps.july.persistence.ResourceSetKey)primaryKey;
		try {
			try {
				result = (com.hps.july.persistence.BSInstComplectResourceSet)home.getBean(primaryKey);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.resourceset);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.BSInstComplectResourceSet)tmpFinder.nextElement();
				}
			}
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
		finally {
			if ( tmpFinder != null ) tmpFinder.close();
		}
		if (result == null) {
			throw new javax.ejb.ObjectNotFoundException();
		}
		return result;
	}
}
