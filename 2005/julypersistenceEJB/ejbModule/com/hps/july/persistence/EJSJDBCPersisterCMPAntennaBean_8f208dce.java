package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAntennaBean_8f208dce
 */
public class EJSJDBCPersisterCMPAntennaBean_8f208dce extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderAntennaBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO antennes (id_anten, locationtype, az_variation, az_ant, groundcnt, num_ant, kswn, input_power, nakl, nakl_variation, byhand, len_cable, h_set1, storagecard, kind_ant, datasource, electricaltilt, planfacttype, resource, cableres, operator, groundresource, equipment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM antennes  WHERE id_anten = ?";
	private static final String _storeString = "UPDATE antennes  SET locationtype = ?, az_variation = ?, az_ant = ?, groundcnt = ?, num_ant = ?, kswn = ?, input_power = ?, nakl = ?, nakl_variation = ?, byhand = ?, len_cable = ?, h_set1 = ?, storagecard = ?, kind_ant = ?, datasource = ?, electricaltilt = ?, planfacttype = ?, resource = ?, cableres = ?, operator = ?, groundresource = ?, equipment = ? WHERE id_anten = ?";
	private static final String _loadString = "SELECT T1.locationtype, T1.az_variation, T1.az_ant, T1.id_anten, T1.groundcnt, T1.num_ant, T1.kswn, T1.input_power, T1.nakl, T1.nakl_variation, T1.byhand, T1.len_cable, T1.h_set1, T1.storagecard, T1.kind_ant, T1.datasource, T1.electricaltilt, T1.planfacttype, T1.resource, T1.cableres, T1.operator, T1.groundresource, T1.equipment FROM antennes  T1 WHERE T1.id_anten = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"locationtype", "az_variation", "az_ant", "groundcnt", "num_ant", "kswn", "input_power", "nakl", "nakl_variation", "byhand", "len_cable", "h_set1", "storagecard", "kind_ant", "datasource", "electricaltilt", "planfacttype", "resource", "cableres", "operator", "groundresource", "equipment"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAntennaBean_8f208dce
	 */
	public EJSJDBCPersisterCMPAntennaBean_8f208dce() throws java.rmi.RemoteException {
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
		AntennaBean b = (AntennaBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[22];
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.locationtype);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.azvariation);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			if (b.azant == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.azant);
			}
			cacheData[2] = b.azant;
			pstmt.setInt(1, b.idanten);
			if (b.groundcnt == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.groundcnt.intValue());
			}
			cacheData[3] = b.groundcnt;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numant);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[4] = objectTemp;
			if (b.kswn == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.kswn);
			}
			cacheData[5] = b.kswn;
			if (b.inputpower == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.inputpower);
			}
			cacheData[6] = b.inputpower;
			if (b.nakl == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.nakl);
			}
			cacheData[7] = b.nakl;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.naklvariation);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			cacheData[8] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			cacheData[9] = objectTemp;
			if (b.lencable == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.lencable);
			}
			cacheData[10] = b.lencable;
			if (b.hset1 == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.hset1);
			}
			cacheData[11] = b.hset1;
			if (b.storagecard == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.storagecard.intValue());
			}
			cacheData[12] = b.storagecard;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kindant);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			cacheData[13] = objectTemp;
			pstmt.setInt(16, b.datasource);
			cacheData[14] = new Integer(b.datasource);
			if (b.electricalTilt == null) {
				pstmt.setNull(17, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(17, b.electricalTilt);
			}
			cacheData[15] = b.electricalTilt;
			pstmt.setInt(18, b.planfacttype);
			cacheData[16] = new Integer(b.planfacttype);
			if (b.resource_resource == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.resource_resource.intValue());
			}
			cacheData[17] = b.resource_resource;
			if (b.cableres_resource == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.cableres_resource.intValue());
			}
			cacheData[18] = b.cableres_resource;
			if (b.operator_operator == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.operator_operator.intValue());
			}
			cacheData[19] = b.operator_operator;
			if (b.groundresource_resource == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.groundresource_resource.intValue());
			}
			cacheData[20] = b.groundresource_resource;
			if (b.equipment_storageplace == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.equipment_storageplace.intValue());
			}
			cacheData[21] = b.equipment_storageplace;
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		putDataIntoCache(cacheData);
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		AntennaBean b = (AntennaBean) eb;
		com.hps.july.persistence.AntennaKey _primaryKey = (com.hps.july.persistence.AntennaKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idanten = _primaryKey.idanten;
		b.locationtype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.azvariation = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.azant = resultSet.getBigDecimal(3);
		tempint = resultSet.getInt(5);
		b.groundcnt = resultSet.wasNull() ? null : new Integer(tempint);
		b.numant = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		b.kswn = resultSet.getBigDecimal(7);
		b.inputpower = resultSet.getBigDecimal(8);
		b.nakl = resultSet.getBigDecimal(9);
		b.naklvariation = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.byhand = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(11));
		b.lencable = resultSet.getBigDecimal(12);
		b.hset1 = resultSet.getBigDecimal(13);
		tempint = resultSet.getInt(14);
		b.storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		b.kindant = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(15));
		b.datasource = resultSet.getInt(16);
		b.electricalTilt = resultSet.getBigDecimal(17);
		b.planfacttype = resultSet.getInt(18);
		tempint = resultSet.getInt(19);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(20);
		b.cableres_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		b.operator_operator = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(22);
		b.groundresource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(23);
		b.equipment_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[22];
		cacheData[0] = resultSet.getString(1);
		cacheData[1] = resultSet.getString(2);
		cacheData[2] = resultSet.getBigDecimal(3);
		tempint = resultSet.getInt(5);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[4] = resultSet.getString(6);
		cacheData[5] = resultSet.getBigDecimal(7);
		cacheData[6] = resultSet.getBigDecimal(8);
		cacheData[7] = resultSet.getBigDecimal(9);
		cacheData[8] = resultSet.getString(10);
		cacheData[9] = resultSet.getString(11);
		cacheData[10] = resultSet.getBigDecimal(12);
		cacheData[11] = resultSet.getBigDecimal(13);
		tempint = resultSet.getInt(14);
		cacheData[12] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[13] = resultSet.getString(15);
		tempint = resultSet.getInt(16);
		cacheData[14] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[15] = resultSet.getBigDecimal(17);
		tempint = resultSet.getInt(18);
		cacheData[16] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(19);
		cacheData[17] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(20);
		cacheData[18] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		cacheData[19] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(22);
		cacheData[20] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(23);
		cacheData[21] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AntennaBean b = (AntennaBean) eb;
		com.hps.july.persistence.AntennaKey _primaryKey = (com.hps.july.persistence.AntennaKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idanten);
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
		AntennaBean b = (AntennaBean) eb;
		com.hps.july.persistence.AntennaKey _primaryKey = new com.hps.july.persistence.AntennaKey();
		_primaryKey.idanten = b.idanten;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AntennaBean b = (AntennaBean) eb;
		com.hps.july.persistence.AntennaKey _primaryKey = new com.hps.july.persistence.AntennaKey();
		_primaryKey.idanten = b.idanten;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(23, _primaryKey.idanten);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.locationtype);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.azvariation);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.azant == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.azant);
			}
			if (b.groundcnt == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.groundcnt.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numant);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.kswn == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.kswn);
			}
			if (b.inputpower == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.inputpower);
			}
			if (b.nakl == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.nakl);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.naklvariation);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.byhand);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.lencable == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.lencable);
			}
			if (b.hset1 == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.hset1);
			}
			if (b.storagecard == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.storagecard.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.kindant);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			pstmt.setInt(15, b.datasource);
			if (b.electricalTilt == null) {
				pstmt.setNull(16, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(16, b.electricalTilt);
			}
			pstmt.setInt(17, b.planfacttype);
			if (b.resource_resource == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.resource_resource.intValue());
			}
			if (b.cableres_resource == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.cableres_resource.intValue());
			}
			if (b.operator_operator == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.operator_operator.intValue());
			}
			if (b.groundresource_resource == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.groundresource_resource.intValue());
			}
			if (b.equipment_storageplace == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.equipment_storageplace.intValue());
			}
			int inputPos = 23;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
			}
			if (cacheData[13] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[14]).intValue());
			}
			if (cacheData[15] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
			}
			if (cacheData[17] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[17]).intValue());
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[19]).intValue());
			}
			if (cacheData[20] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[20]).intValue());
			}
			if (cacheData[21] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[21]).intValue());
			}
			if (pstmt.executeUpdate() < 1) {
				throw new OptimisticUpdateFailureException("executeUpdate returned zero rows updated");
			}
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
		AntennaBean b = (AntennaBean) eb;
		com.hps.july.persistence.AntennaKey _primaryKey = new com.hps.july.persistence.AntennaKey();
		_primaryKey.idanten = b.idanten;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idanten);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
			}
			if (cacheData[13] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[14]).intValue());
			}
			if (cacheData[15] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
			}
			if (cacheData[17] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[17]).intValue());
			}
			if (cacheData[18] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[18]).intValue());
			}
			if (cacheData[19] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[19]).intValue());
			}
			if (cacheData[20] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[20]).intValue());
			}
			if (cacheData[21] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[21]).intValue());
			}
			if (pstmt.executeUpdate() < 1) {
				throw new OptimisticUpdateFailureException("executeUpdate returned zero rows updated");
			}
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence.AntennaKey key = new com.hps.july.persistence.AntennaKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idanten = resultSet.getInt(4);
			return key;
		}
return null;
	}

	/**
	 * RdbRt
	 */
	public class RdbRt {
	public static final String EQUALS = " = ";
	public static final String ISNULL = " IS NULL";
	public static final String MARKER = "?";
	public static final String AND = " AND ";
	private String fStatement;
	private String[] fPredicates = new String[0];
	private boolean[] fPredicateMap = new boolean[0];
	public RdbRt() { }
	public RdbRt(String aStmt) {
		rootStmt(aStmt);
	}
	public RdbRt(String aStmt, String[] anArray, boolean[] aMap) {
		rootStmt(aStmt);
		predicates(anArray);
		predicateMap(aMap);
	}
	public String nativeQuery() {
		StringBuffer aBuffer = new StringBuffer();
		statementOn(aBuffer);
		return aBuffer.toString();
	}
	public String nativeQuery(Object[] values) {
		StringBuffer aBuffer = new StringBuffer();
		statementOn(aBuffer, values);
		return aBuffer.toString();
	}
	public String[] predicates() {
		return fPredicates;
	}
	public void predicates(String[] anArray) {
		fPredicates = anArray;
	}
	public boolean[] predicateMap() {
		return fPredicateMap;
	}
	public void predicateMap(boolean[] anArray) {
		fPredicateMap = anArray;
	}
	public void predicatesOn(StringBuffer aBuffer, Object[] values) {
		int j = predicates().length;
		if (j != values.length)
			throw new RuntimeException("differing number of predicates and values");
		String each;
		for (int i = 0; i < j; i++) {
			if (!fPredicateMap[i]) continue;
				aBuffer.append(AND);
			each = predicates()[i];
			aBuffer.append(each);
			if (values[i] == null)
				aBuffer.append(ISNULL);
			else {
				aBuffer.append(EQUALS);
				aBuffer.append(MARKER);
			}
		}
	}
	public String rootStmt() {
		return fStatement;
	}
	public void rootStmt(String aStmt) {
		fStatement = aStmt;
	}
	public void statementOn(StringBuffer aBuffer) {
		aBuffer.append(rootStmt());
	}
	public void statementOn(StringBuffer aBuffer, Object[] values) {
		aBuffer.append(rootStmt());
		if (predicates() != null && predicates().length != 0) {
			predicatesOn(aBuffer, values);
		}
	}
	}
	/**
	 * findAntennesByOperator
	 */
	public EJSFinder findAntennesByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.locationtype, T1.az_variation, T1.az_ant, T1.id_anten, T1.groundcnt, T1.num_ant, T1.kswn, T1.input_power, T1.nakl, T1.nakl_variation, T1.byhand, T1.len_cable, T1.h_set1, T1.storagecard, T1.kind_ant, T1.datasource, T1.electricaltilt, T1.planfacttype, T1.resource, T1.cableres, T1.operator, T1.groundresource, T1.equipment FROM antennes  T1 WHERE T1.operator = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.operator);
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
	public EJSFinder findByQBE(java.lang.Integer argBSNum, java.lang.String bsType, java.lang.Boolean isPlanstate, java.lang.String argPlanstate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(argBSNum, bsType, isPlanstate, argPlanstate, isState, argState, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAntennesByResource
	 */
	public EJSFinder findAntennesByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.locationtype, T1.az_variation, T1.az_ant, T1.id_anten, T1.groundcnt, T1.num_ant, T1.kswn, T1.input_power, T1.nakl, T1.nakl_variation, T1.byhand, T1.len_cable, T1.h_set1, T1.storagecard, T1.kind_ant, T1.datasource, T1.electricaltilt, T1.planfacttype, T1.resource, T1.cableres, T1.operator, T1.groundresource, T1.equipment FROM antennes  T1 WHERE T1.resource = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findGrresAntennesByGroundresource
	 */
	public EJSFinder findGrresAntennesByGroundresource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.locationtype, T1.az_variation, T1.az_ant, T1.id_anten, T1.groundcnt, T1.num_ant, T1.kswn, T1.input_power, T1.nakl, T1.nakl_variation, T1.byhand, T1.len_cable, T1.h_set1, T1.storagecard, T1.kind_ant, T1.datasource, T1.electricaltilt, T1.planfacttype, T1.resource, T1.cableres, T1.operator, T1.groundresource, T1.equipment FROM antennes  T1 WHERE T1.groundresource = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAntennesByEquipment
	 */
	public EJSFinder findAntennesByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.locationtype, T1.az_variation, T1.az_ant, T1.id_anten, T1.groundcnt, T1.num_ant, T1.kswn, T1.input_power, T1.nakl, T1.nakl_variation, T1.byhand, T1.len_cable, T1.h_set1, T1.storagecard, T1.kind_ant, T1.datasource, T1.electricaltilt, T1.planfacttype, T1.resource, T1.cableres, T1.operator, T1.groundresource, T1.equipment FROM antennes  T1 WHERE T1.equipment = ?");
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
	 * findAntennesByCableres
	 */
	public EJSFinder findAntennesByCableres(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.locationtype, T1.az_variation, T1.az_ant, T1.id_anten, T1.groundcnt, T1.num_ant, T1.kswn, T1.input_power, T1.nakl, T1.nakl_variation, T1.byhand, T1.len_cable, T1.h_set1, T1.storagecard, T1.kind_ant, T1.datasource, T1.electricaltilt, T1.planfacttype, T1.resource, T1.cableres, T1.operator, T1.groundresource, T1.equipment FROM antennes  T1 WHERE T1.cableres = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByEquipmentOrderByNumAsc
	 */
	public EJSFinder findByEquipmentOrderByNumAsc(java.lang.Integer argEquipment) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.locationtype, T1.az_variation, T1.az_ant, T1.id_anten, T1.groundcnt, T1.num_ant, T1.kswn, T1.input_power, T1.nakl, T1.nakl_variation, T1.byhand, T1.len_cable, T1.h_set1, T1.storagecard, T1.kind_ant, T1.datasource, T1.electricaltilt, T1.planfacttype, T1.resource, T1.cableres, T1.operator, T1.groundresource, T1.equipment FROM antennes  T1 WHERE equipment = ? AND planfacttype=1 ORDER BY num_ant ASC");
			pstmt.setObject(1, argEquipment);
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
	public com.hps.july.persistence.Antenna findByPrimaryKey(com.hps.july.persistence.AntennaKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Antenna) home.activateBean(key);
	}
	private static final String genericFindSqlString = "SELECT T1.locationtype, T1.az_variation, T1.az_ant, T1.id_anten, T1.groundcnt, T1.num_ant, T1.kswn, T1.input_power, T1.nakl, T1.nakl_variation, T1.byhand, T1.len_cable, T1.h_set1, T1.storagecard, T1.kind_ant, T1.datasource, T1.electricaltilt, T1.planfacttype, T1.resource, T1.cableres, T1.operator, T1.groundresource, T1.equipment FROM antennes  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {355};
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
	private AntennaBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.AntennaBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.AntennaBeanFinderObject temp_finderObject = new com.hps.july.persistence.AntennaBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
