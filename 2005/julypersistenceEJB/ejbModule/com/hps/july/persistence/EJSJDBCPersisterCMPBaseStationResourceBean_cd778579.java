package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPBaseStationResourceBean_cd778579
 */
public class EJSJDBCPersisterCMPBaseStationResourceBean_cd778579 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderBaseStationResourceBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO resources (resource, notes, actualcode, countpolicy, manucode, complectpart, active, complect, boxable, name, model, priceable, resourceclass2, groupid, manufid, disablenfscodes, resourcesubtype, unit, resourceclass) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO basestationres (resource, generation, height, length, modification, productline, standard, width, makeyear, maxtrxcount, maxsectorscount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM basestationres  WHERE resource = ?", "DELETE FROM resources  WHERE resource = ?"};
	private static final String[] _storeString = {"UPDATE basestationres  SET generation = ?, height = ?, length = ?, modification = ?, productline = ?, standard = ?, width = ?, makeyear = ?, maxtrxcount = ?, maxsectorscount = ? WHERE resource = ?", "UPDATE resources  SET notes = ?, actualcode = ?, countpolicy = ?, manucode = ?, complectpart = ?, active = ?, complect = ?, boxable = ?, name = ?, model = ?, priceable = ?, resourceclass2 = ?, groupid = ?, manufid = ?, disablenfscodes = ?, resourcesubtype = ?, unit = ?, resourceclass = ? WHERE resource = ?"};
	private static final String _loadString = "SELECT T2.notes, T2.actualcode, T2.countpolicy, T2.resource, T2.manucode, T2.complectpart, T2.active, T2.complect, T2.boxable, T2.name, T2.model, T2.priceable, T2.resourceclass2, T2.groupid, T2.manufid, T2.disablenfscodes, T2.resourcesubtype, T2.unit, T2.resourceclass, T1.generation, T1.height, T1.length, T1.modification, T1.productline, T1.standard, T1.width, T1.makeyear, T1.maxtrxcount, T1.maxsectorscount FROM basestationres  T1, resources  T2 WHERE T2.resourceclass = \'B\' AND T2.resource = T1.resource AND T2.resource = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPBaseStationResourceBean_cd778579
	 */
	public EJSJDBCPersisterCMPBaseStationResourceBean_cd778579() throws java.rmi.RemoteException {
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
		BaseStationResourceBean b = (BaseStationResourceBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			if (b.notes == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.notes);
			}
			pstmt.setInt(3, b.actualcode);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.countpolicy);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.resource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.manucode);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.complectpart);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.active);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.complect);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.boxable);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.model);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.priceable);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			if (b.resourceclass2 == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.resourceclass2.intValue());
			}
			if (b.groupid == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.groupid.intValue());
			}
			if (b.manufid == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.manufid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.disablenfscodes);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			if (b.subtype_resourcesubtype == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.subtype_resourcesubtype.intValue());
			}
			if (b.unit_unit == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.unit_unit.intValue());
			}
			pstmt.setString(19, "B");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.generation);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.height == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.height.intValue());
			}
			if (b.length == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.length.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.modification);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.productline);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.standard);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.width == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.width.intValue());
			}
			if (b.makeyear == null) {
				pstmt.setNull(9, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(9, b.makeyear.shortValue());
			}
			if (b.maxtrxcount == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.maxtrxcount.intValue());
			}
			if (b.maxsectorscount == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.maxsectorscount.intValue());
			}
			pstmt.setInt(1, b.resource);
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
		BaseStationResourceBean b = (BaseStationResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = (com.hps.july.persistence.ResourceKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.resource = _primaryKey.resource;
		b.generation = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(20));
		tempint = resultSet.getInt(21);
		b.height = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(22);
		b.length = resultSet.wasNull() ? null : new Integer(tempint);
		b.modification = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(23));
		b.productline = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(24));
		b.standard = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(25));
		tempint = resultSet.getInt(26);
		b.width = resultSet.wasNull() ? null : new Integer(tempint);
		tempshort = resultSet.getShort(27);
		b.makeyear = resultSet.wasNull() ? null : new Short(tempshort);
		tempint = resultSet.getInt(28);
		b.maxtrxcount = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(29);
		b.maxsectorscount = resultSet.wasNull() ? null : new Integer(tempint);
		b.notes = resultSet.getString(1);
		b.actualcode = resultSet.getInt(2);
		b.countpolicy = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.manucode = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.complectpart = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(6));
		b.active = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(7));
		b.complect = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(8));
		b.boxable = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(9));
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.model = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(11));
		b.priceable = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(12));
		tempint = resultSet.getInt(13);
		b.resourceclass2 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(14);
		b.groupid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		b.manufid = resultSet.wasNull() ? null : new Integer(tempint);
		b.disablenfscodes = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(16));
		tempint = resultSet.getInt(17);
		b.subtype_resourcesubtype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(18);
		b.unit_unit = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		BaseStationResourceBean b = (BaseStationResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = (com.hps.july.persistence.ResourceKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.resource);
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
		BaseStationResourceBean b = (BaseStationResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = new com.hps.july.persistence.ResourceKey();
		_primaryKey.resource = b.resource;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		BaseStationResourceBean b = (BaseStationResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = new com.hps.july.persistence.ResourceKey();
		_primaryKey.resource = b.resource;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(11, _primaryKey.resource);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.generation);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.height == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.height.intValue());
			}
			if (b.length == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.length.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.modification);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.productline);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.standard);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.width == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.width.intValue());
			}
			if (b.makeyear == null) {
				pstmt.setNull(8, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(8, b.makeyear.shortValue());
			}
			if (b.maxtrxcount == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.maxtrxcount.intValue());
			}
			if (b.maxsectorscount == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.maxsectorscount.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			pstmt.setInt(19, _primaryKey.resource);
			if (b.notes == null) {
				pstmt.setNull(1, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(1, b.notes);
			}
			pstmt.setInt(2, b.actualcode);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.countpolicy);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.manucode);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.complectpart);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.active);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.complect);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.boxable);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.model);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.priceable);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.resourceclass2 == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.resourceclass2.intValue());
			}
			if (b.groupid == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.groupid.intValue());
			}
			if (b.manufid == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.manufid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.disablenfscodes);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.subtype_resourcesubtype == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.subtype_resourcesubtype.intValue());
			}
			if (b.unit_unit == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.unit_unit.intValue());
			}
			pstmt.setString(18, "B");
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
		BaseStationResourceBean b = (BaseStationResourceBean) eb;
		com.hps.july.persistence.ResourceKey _primaryKey = new com.hps.july.persistence.ResourceKey();
		_primaryKey.resource = b.resource;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.resource);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.resource);
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
		com.hps.july.persistence.ResourceKey key = new com.hps.july.persistence.ResourceKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.resource = resultSet.getInt(4);
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
		java.lang.String discriminator = rs.getString(19).trim();
		if ( discriminator.equals("B") ) {
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
	 * findResourcesByQBE3
	 */
	public EJSFinder findResourcesByQBE3(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByQBE3(isSubtypekey, subtypeKey, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, connected, owner, order);
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
	public com.hps.july.persistence.BaseStationResource findByPrimaryKey(com.hps.july.persistence.ResourceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.BaseStationResource result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.ResourceKey _primaryKey = (com.hps.july.persistence.ResourceKey)key;
		try {
			try {
				result = (com.hps.july.persistence.BaseStationResource)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.resource);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.BaseStationResource)tmpFinder.nextElement();
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
	 * findResourcesByLeasePayRules
	 */
	public EJSFinder findResourcesByLeasePayRules(java.util.Vector listContracts) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByLeasePayRules(listContracts);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 */
	public EJSFinder findResourceByReglamentOrderByCodeAsc(java.lang.Integer argReglament) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourceByReglamentOrderByCodeAsc(argReglament);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourcesByQBE2
	 */
	public EJSFinder findResourcesByQBE2(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByQBE2(isSubtypekey, subtypeKey, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findActiveResourceBySubtype
	 */
	public EJSFinder findActiveResourceBySubtype(java.lang.Integer argSubtype, java.lang.String argActive) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T2.notes, T2.actualcode, T2.countpolicy, T2.resource, T2.manucode, T2.complectpart, T2.active, T2.complect, T2.boxable, T2.name, T2.model, T2.priceable, T2.resourceclass2, T2.groupid, T2.manufid, T2.disablenfscodes, T2.resourcesubtype, T2.unit, T2.resourceclass, T1.generation, T1.height, T1.length, T1.modification, T1.productline, T1.standard, T1.width, T1.makeyear, T1.maxtrxcount, T1.maxsectorscount FROM basestationres  T1, resources  T2 WHERE T2.resourceclass = \'B\' AND T2.resource = T1.resource AND resourcesubtype = ? AND active = ?");
			pstmt.setObject(1, argSubtype);
			if (argActive == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argActive);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBasestationResourceForBowse
	 */
	public EJSFinder findBasestationResourceForBowse(java.lang.Boolean isResourcetype, java.lang.Integer resourcetype, java.lang.Boolean isResourcesubtype, java.lang.Integer resourcesubtype, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.String active, java.lang.Boolean isGeneration, java.lang.String generation, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findBasestationResourceForBowse(isResourcetype, resourcetype, isResourcesubtype, resourcesubtype, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, active, isGeneration, generation, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourcesByQBE
	 */
	public EJSFinder findResourcesByQBE(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByQBE(isSubtypekey, subtypeKey, isModel, model, isName, name, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findResourcesByLeaseChargeRules
	 */
	public EJSFinder findResourcesByLeaseChargeRules(java.util.Vector listContracts) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findResourcesByLeaseChargeRules(listContracts);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBasestationByQBE
	 */
	public EJSFinder findBasestationByQBE(java.lang.Boolean isType, java.lang.Integer type, java.lang.Boolean isSubtype, java.lang.Integer subtype, java.lang.Boolean isGeneration, java.lang.String generation, java.lang.String active, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isManufacturer, java.lang.String manufacturer, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findBasestationByQBE(isType, type, isSubtype, subtype, isGeneration, generation, active, isModel, model, isManufacturer, manufacturer, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T2.notes, T2.actualcode, T2.countpolicy, T2.resource, T2.manucode, T2.complectpart, T2.active, T2.complect, T2.boxable, T2.name, T2.model, T2.priceable, T2.resourceclass2, T2.groupid, T2.manufid, T2.disablenfscodes, T2.resourcesubtype, T2.unit, T2.resourceclass, T1.generation, T1.height, T1.length, T1.modification, T1.productline, T1.standard, T1.width, T1.makeyear, T1.maxtrxcount, T1.maxsectorscount FROM basestationres  T1, resources  T2 WHERE T2.resourceclass = \'B\' AND T2.resource = T1.resource AND ";
	private static final int[] genericFindInsertPoints = {513};
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
	private BaseStationResourceBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.BaseStationResourceBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.BaseStationResourceBeanFinderObject temp_finderObject = new com.hps.july.persistence.BaseStationResourceBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
