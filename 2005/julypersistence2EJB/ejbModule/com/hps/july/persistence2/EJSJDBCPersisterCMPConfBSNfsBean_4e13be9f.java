package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPConfBSNfsBean_4e13be9f
 */
public class EJSJDBCPersisterCMPConfBSNfsBean_4e13be9f extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderConfBSNfsBean {
	private static final String _createString = "INSERT INTO confbsnfs (id, codenri, nfsitem_id, conftype, voltage, sect_a, sect_b, sect_c, sect_d, sect_e, sect_f, sect_g, sect_h, sect_o900, sect_o1800) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM confbsnfs  WHERE id = ?";
	private static final String _storeString = "UPDATE confbsnfs  SET codenri = ?, nfsitem_id = ?, conftype = ?, voltage = ?, sect_a = ?, sect_b = ?, sect_c = ?, sect_d = ?, sect_e = ?, sect_f = ?, sect_g = ?, sect_h = ?, sect_o900 = ?, sect_o1800 = ? WHERE id = ?";
	private static final String _loadString = "SELECT T1.id, T1.codenri, T1.nfsitem_id, T1.conftype, T1.voltage, T1.sect_a, T1.sect_b, T1.sect_c, T1.sect_d, T1.sect_e, T1.sect_f, T1.sect_g, T1.sect_h, T1.sect_o900, T1.sect_o1800 FROM confbsnfs  T1 WHERE T1.id = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"codenri", "nfsitem_id", "conftype", "sect_a", "sect_b", "sect_c", "sect_d", "sect_e", "sect_f", "sect_g", "sect_h", "sect_o900", "sect_o1800"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPConfBSNfsBean_4e13be9f
	 */
	public EJSJDBCPersisterCMPConfBSNfsBean_4e13be9f() throws java.rmi.RemoteException {
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
		ConfBSNfsBean b = (ConfBSNfsBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[13];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.id);
			pstmt.setInt(2, b.codenri);
			cacheData[0] = new Integer(b.codenri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.nfsitem_id);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.conftype);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			if (b.voltage == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.voltage);
			}
			pstmt.setInt(6, b.sect_a);
			cacheData[3] = new Integer(b.sect_a);
			pstmt.setInt(7, b.sect_b);
			cacheData[4] = new Integer(b.sect_b);
			pstmt.setInt(8, b.sect_c);
			cacheData[5] = new Integer(b.sect_c);
			pstmt.setInt(9, b.sect_d);
			cacheData[6] = new Integer(b.sect_d);
			pstmt.setInt(10, b.sect_e);
			cacheData[7] = new Integer(b.sect_e);
			pstmt.setInt(11, b.sect_f);
			cacheData[8] = new Integer(b.sect_f);
			pstmt.setInt(12, b.sect_g);
			cacheData[9] = new Integer(b.sect_g);
			pstmt.setInt(13, b.sect_h);
			cacheData[10] = new Integer(b.sect_h);
			pstmt.setInt(14, b.sect_o900);
			cacheData[11] = new Integer(b.sect_o900);
			pstmt.setInt(15, b.sect_o1800);
			cacheData[12] = new Integer(b.sect_o1800);
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
		ConfBSNfsBean b = (ConfBSNfsBean) eb;
		com.hps.july.persistence2.ConfBSNfsKey _primaryKey = (com.hps.july.persistence2.ConfBSNfsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.id = _primaryKey.id;
		b.codenri = resultSet.getInt(2);
		b.nfsitem_id = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.conftype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.voltage = resultSet.getBigDecimal(5);
		b.sect_a = resultSet.getInt(6);
		b.sect_b = resultSet.getInt(7);
		b.sect_c = resultSet.getInt(8);
		b.sect_d = resultSet.getInt(9);
		b.sect_e = resultSet.getInt(10);
		b.sect_f = resultSet.getInt(11);
		b.sect_g = resultSet.getInt(12);
		b.sect_h = resultSet.getInt(13);
		b.sect_o900 = resultSet.getInt(14);
		b.sect_o1800 = resultSet.getInt(15);
		Object[] cacheData = new Object[13];
		tempint = resultSet.getInt(2);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getString(3);
		cacheData[2] = resultSet.getString(4);
		tempint = resultSet.getInt(6);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		cacheData[4] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		cacheData[7] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(11);
		cacheData[8] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(12);
		cacheData[9] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(13);
		cacheData[10] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(14);
		cacheData[11] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		cacheData[12] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		ConfBSNfsBean b = (ConfBSNfsBean) eb;
		com.hps.july.persistence2.ConfBSNfsKey _primaryKey = (com.hps.july.persistence2.ConfBSNfsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.id);
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
		ConfBSNfsBean b = (ConfBSNfsBean) eb;
		com.hps.july.persistence2.ConfBSNfsKey _primaryKey = new com.hps.july.persistence2.ConfBSNfsKey();
		_primaryKey.id = b.id;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		ConfBSNfsBean b = (ConfBSNfsBean) eb;
		com.hps.july.persistence2.ConfBSNfsKey _primaryKey = new com.hps.july.persistence2.ConfBSNfsKey();
		_primaryKey.id = b.id;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(15, _primaryKey.id);
			pstmt.setInt(1, b.codenri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.nfsitem_id);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.conftype);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.voltage == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.voltage);
			}
			pstmt.setInt(5, b.sect_a);
			pstmt.setInt(6, b.sect_b);
			pstmt.setInt(7, b.sect_c);
			pstmt.setInt(8, b.sect_d);
			pstmt.setInt(9, b.sect_e);
			pstmt.setInt(10, b.sect_f);
			pstmt.setInt(11, b.sect_g);
			pstmt.setInt(12, b.sect_h);
			pstmt.setInt(13, b.sect_o900);
			pstmt.setInt(14, b.sect_o1800);
			int inputPos = 15;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
			}
			if (cacheData[8] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
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
		ConfBSNfsBean b = (ConfBSNfsBean) eb;
		com.hps.july.persistence2.ConfBSNfsKey _primaryKey = new com.hps.july.persistence2.ConfBSNfsKey();
		_primaryKey.id = b.id;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.id);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
			}
			if (cacheData[8] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
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
		com.hps.july.persistence2.ConfBSNfsKey key = new com.hps.july.persistence2.ConfBSNfsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.id = resultSet.getInt(1);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence2.ConfBSNfs findByPrimaryKey(com.hps.july.persistence2.ConfBSNfsKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.ConfBSNfs) home.activateBean(primaryKey);
	}
	/**
	 * findByAll
	 */
	public EJSFinder findByAll(java.lang.String argConfType, int argSectA, int argSectB, int argSectC, int argSectD, int argSectE, int argSectF, int argSectG, int argSectH, java.math.BigDecimal argVoltage, java.lang.String argNFSId, int argCodeNRI) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement(" select  q1.id,  q1.codenri,  q1.nfsitem_id,  q1.conftype,  q1.voltage,  q1.sect_a,  q1.sect_b,  q1.sect_c,  q1.sect_d,  q1.sect_e,  q1.sect_f,  q1.sect_g,  q1.sect_h,  q1.sect_o900,  q1.sect_o1800 from confbsnfs q1 where  ( q1.conftype = ?)  and  ( q1.sect_a = ?)  and  ( q1.sect_b = ?)  and  ( q1.sect_c = ?)  and  ( q1.sect_d = ?)  and  ( q1.sect_e = ?)  and  ( q1.sect_f = ?)  and  ( q1.sect_g = ?)  and  ( q1.sect_h = ?)  and  ( q1.voltage = ?)  and  ( q1.nfsitem_id = ?)  and  ( q1.codenri = ?) ");
			Object convObj = null;
			convObj = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(argConfType);
			if (convObj == null)
			   pstmt.setNull(1, java.sql.Types.CHAR);
			else
			   pstmt.setString(1, ((java.lang.String) convObj));
			pstmt.setInt(2, argSectA);
			pstmt.setInt(3, argSectB);
			pstmt.setInt(4, argSectC);
			pstmt.setInt(5, argSectD);
			pstmt.setInt(6, argSectE);
			pstmt.setInt(7, argSectF);
			pstmt.setInt(8, argSectG);
			pstmt.setInt(9, argSectH);
			pstmt.setBigDecimal(10, argVoltage);
			convObj = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(argNFSId);
			if (convObj == null)
			   pstmt.setNull(11, java.sql.Types.CHAR);
			else
			   pstmt.setString(11, ((java.lang.String) convObj));
			pstmt.setInt(12, argCodeNRI);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
