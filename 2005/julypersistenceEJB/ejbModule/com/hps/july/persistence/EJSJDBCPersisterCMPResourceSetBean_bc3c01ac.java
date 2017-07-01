package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPResourceSetBean_bc3c01ac
 */
public class EJSJDBCPersisterCMPResourceSetBean_bc3c01ac extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderResourceSetBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO resourcesets (resourceset, mainpartqty, type, name, resourcesetclass, nfsitem_id, mainpart) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM resourcesets  WHERE resourceset = ?";
	private static final String _storeString = "UPDATE resourcesets  SET mainpartqty = ?, type = ?, name = ?, resourcesetclass = ?, nfsitem_id = ?, mainpart = ? WHERE resourceset = ?";
	private static final String _loadString = "(((SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM resourcesets  T3 WHERE T3.resourcesetclass = 0 AND T3.resourceset = ?)  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM uzopowersupplyset  T4, resourcesets  T3 WHERE T3.resourceset = T4.resourceset AND T3.resourcesetclass = 3 AND T3.resourceset = ?) )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, T2.power FROM powersupplyset  T2, resourcesets  T3 WHERE T3.resourceset = T2.resourceset AND T3.resourcesetclass = 1 AND T3.resourceset = ?) )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM bsinstcomplectresourceset  T1, resourcesets  T3 WHERE T3.resourceset = T1.resourceset AND T3.resourcesetclass = 2 AND T3.resourceset = ?) ";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPResourceSetBean_bc3c01ac
	 */
	public EJSJDBCPersisterCMPResourceSetBean_bc3c01ac() throws java.rmi.RemoteException {
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
		ResourceSetBean b = (ResourceSetBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
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
			pstmt.setInt(5, 0);
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
		ResourceSetBean b = (ResourceSetBean) eb;
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
		ResourceSetBean b = (ResourceSetBean) eb;
		com.hps.july.persistence.ResourceSetKey _primaryKey = (com.hps.july.persistence.ResourceSetKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.resourceset);
			pstmt.setInt(2, _primaryKey.resourceset);
			pstmt.setInt(3, _primaryKey.resourceset);
			pstmt.setInt(4, _primaryKey.resourceset);
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
		ResourceSetBean b = (ResourceSetBean) eb;
		com.hps.july.persistence.ResourceSetKey _primaryKey = new com.hps.july.persistence.ResourceSetKey();
		_primaryKey.resourceset = b.resourceset;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ResourceSetBean b = (ResourceSetBean) eb;
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
			pstmt.setInt(4, 0);
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
		ResourceSetBean b = (ResourceSetBean) eb;
		com.hps.july.persistence.ResourceSetKey _primaryKey = new com.hps.july.persistence.ResourceSetKey();
		_primaryKey.resourceset = b.resourceset;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
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
		if ( discriminator.equals( new Integer("0")) ) {
			bean = super.getBean(obj);
		}
		else {
			String homeName = null;
			if ( discriminator.equals( new Integer("1")) ) {
				homeName = "PowerSupplySet";
			}
			else
			if ( discriminator.equals( new Integer("3")) ) {
				homeName = "UZOPowerSupplySet";
			}
			else
			if ( discriminator.equals( new Integer("2")) ) {
				homeName = "BSInstComplectResourceSet";
			}
			if (homeName != null) {
				bean = ((com.ibm.ejs.container.EJSHome)home).getBean(homeName, getPrimaryKey(rs), rs);
			}
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
	 * findResourceSetsBySubtype
	 */
	public EJSFinder findResourceSetsBySubtype(java.lang.Integer argSubtype) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("(((SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM resourcesets  T3 WHERE T3.resourcesetclass = 0 AND T1.mainpart IN  (SELECT resource FROM resources r1 WHERE r1.resourcesubtype = ?) )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM uzopowersupplyset  T4, resourcesets  T3 WHERE T3.resourceset = T4.resourceset AND T3.resourcesetclass = 3 AND T1.mainpart IN  (SELECT resource FROM resources r1 WHERE r1.resourcesubtype = ?) ) )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, T2.power FROM powersupplyset  T2, resourcesets  T3 WHERE T3.resourceset = T2.resourceset AND T3.resourcesetclass = 1 AND T1.mainpart IN  (SELECT resource FROM resources r1 WHERE r1.resourcesubtype = ?) ) )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM bsinstcomplectresourceset  T1, resourcesets  T3 WHERE T3.resourceset = T1.resourceset AND T3.resourcesetclass = 2 AND T1.mainpart IN  (SELECT resource FROM resources r1 WHERE r1.resourcesubtype = ?) ) ");
			for (int _EJS_i=0; _EJS_i<4; _EJS_i+=1) {
				pstmt.setObject(_EJS_i+1, argSubtype);
			}
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
	public com.hps.july.persistence.ResourceSet findByPrimaryKey(com.hps.july.persistence.ResourceSetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.ResourceSet result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.ResourceSetKey _primaryKey = (com.hps.july.persistence.ResourceSetKey)key;
		try {
			try {
				result = (com.hps.july.persistence.ResourceSet)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.resourceset);
				pstmt.setInt(2, _primaryKey.resourceset);
				pstmt.setInt(3, _primaryKey.resourceset);
				pstmt.setInt(4, _primaryKey.resourceset);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.ResourceSet)tmpFinder.nextElement();
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
	/**
	 * findResourceSetsByMainpart
	 */
	public EJSFinder findResourceSetsByMainpart(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("(((SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM resourcesets  T3 WHERE T3.resourcesetclass = 0 AND T3.mainpart = ?)  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM uzopowersupplyset  T4, resourcesets  T3 WHERE T3.resourceset = T4.resourceset AND T3.resourcesetclass = 3 AND T3.mainpart = ?) )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, T2.power FROM powersupplyset  T2, resourcesets  T3 WHERE T3.resourceset = T2.resourceset AND T3.resourcesetclass = 1 AND T3.mainpart = ?) )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM bsinstcomplectresourceset  T1, resourcesets  T3 WHERE T3.resourceset = T1.resourceset AND T3.resourcesetclass = 2 AND T3.mainpart = ?) ");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			pstmt.setInt(2, inKey.resource);
			pstmt.setInt(3, inKey.resource);
			pstmt.setInt(4, inKey.resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isSubtypekey, subtypeKey, isModel, model, isName, name, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "(((SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM resourcesets  T3 WHERE T3.resourcesetclass = 0 AND )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM uzopowersupplyset  T4, resourcesets  T3 WHERE T3.resourceset = T4.resourceset AND T3.resourcesetclass = 3 AND ) )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, T2.power FROM powersupplyset  T2, resourcesets  T3 WHERE T3.resourceset = T2.resourceset AND T3.resourcesetclass = 1 AND ) )  UNION ALL (SELECT T3.mainpartqty, T3.resourceset, T3.type, T3.name, T3.resourcesetclass, T3.nfsitem_id, T3.mainpart, CAST(NULL AS DECIMAL(5, 0)) FROM bsinstcomplectresourceset  T1, resourcesets  T3 WHERE T3.resourceset = T1.resourceset AND T3.resourcesetclass = 2 AND ) ";
	private static final int[] genericFindInsertPoints = {972, 699, 456, 193};
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
	private ResourceSetBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.ResourceSetBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.ResourceSetBeanFinderObject temp_finderObject = new com.hps.july.persistence.ResourceSetBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
