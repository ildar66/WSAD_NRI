package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseTaskJournalBean_d1845446
 */
public class EJSJDBCPersisterCMPLeaseTaskJournalBean_d1845446 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseTaskJournalBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO leasetaskjournal (taskjournal, resource1, leasedocument, jrndate, leasedocposition2, date2, jrnaction, currency1, leaserule, summ2, jrntype, currency2, leasedocposition, summ1, resource2, date1, jrnmessage, taskstart) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasetaskjournal  WHERE taskjournal = ?";
	private static final String _storeString = "UPDATE leasetaskjournal  SET resource1 = ?, leasedocument = ?, jrndate = ?, leasedocposition2 = ?, date2 = ?, jrnaction = ?, currency1 = ?, leaserule = ?, summ2 = ?, jrntype = ?, currency2 = ?, leasedocposition = ?, summ1 = ?, resource2 = ?, date1 = ?, jrnmessage = ?, taskstart = ? WHERE taskjournal = ?";
	private static final String _loadString = "SELECT T1.resource1, T1.leasedocument, T1.jrndate, T1.leasedocposition2, T1.date2, T1.jrnaction, T1.currency1, T1.taskjournal, T1.leaserule, T1.summ2, T1.jrntype, T1.currency2, T1.leasedocposition, T1.summ1, T1.resource2, T1.date1, T1.jrnmessage, T1.taskstart FROM leasetaskjournal  T1 WHERE T1.taskjournal = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"resource1", "leasedocument", "jrndate", "leasedocposition2", "date2", "jrnaction", "currency1", "leaserule", "summ2", "jrntype", "currency2", "leasedocposition", "summ1", "resource2", "date1", "jrnmessage", "taskstart"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseTaskJournalBean_d1845446
	 */
	public EJSJDBCPersisterCMPLeaseTaskJournalBean_d1845446() throws java.rmi.RemoteException {
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
		LeaseTaskJournalBean b = (LeaseTaskJournalBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[17];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.resource1 == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.resource1.intValue());
			}
			cacheData[0] = b.resource1;
			if (b.leasedocument == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.leasedocument.intValue());
			}
			cacheData[1] = b.leasedocument;
			if (b.jrndate == null) {
				pstmt.setNull(4, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(4, b.jrndate);
			}
			cacheData[2] = b.jrndate;
			if (b.leasedocposition2 == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.leasedocposition2.intValue());
			}
			cacheData[3] = b.leasedocposition2;
			if (b.date2 == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.date2);
			}
			cacheData[4] = b.date2;
			pstmt.setInt(7, b.jrnaction);
			cacheData[5] = new Integer(b.jrnaction);
			if (b.currency1 == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.currency1.intValue());
			}
			cacheData[6] = b.currency1;
			pstmt.setInt(1, b.taskjournal);
			if (b.leaserule == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.leaserule.intValue());
			}
			cacheData[7] = b.leaserule;
			if (b.summ2 == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.summ2);
			}
			cacheData[8] = b.summ2;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.jrntype);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			cacheData[9] = objectTemp;
			if (b.currency2 == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.currency2.intValue());
			}
			cacheData[10] = b.currency2;
			if (b.leasedocposition == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.leasedocposition.intValue());
			}
			cacheData[11] = b.leasedocposition;
			if (b.summ1 == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.summ1);
			}
			cacheData[12] = b.summ1;
			if (b.resource2 == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.resource2.intValue());
			}
			cacheData[13] = b.resource2;
			if (b.date1 == null) {
				pstmt.setNull(16, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(16, b.date1);
			}
			cacheData[14] = b.date1;
			if (b.jrnmessage == null) {
				pstmt.setNull(17, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(17, b.jrnmessage);
			}
			cacheData[15] = b.jrnmessage;
			if (b.journal2start_taskstart == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.journal2start_taskstart.intValue());
			}
			cacheData[16] = b.journal2start_taskstart;
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
		LeaseTaskJournalBean b = (LeaseTaskJournalBean) eb;
		com.hps.july.persistence.LeaseTaskJournalKey _primaryKey = (com.hps.july.persistence.LeaseTaskJournalKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.taskjournal = _primaryKey.taskjournal;
		tempint = resultSet.getInt(1);
		b.resource1 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.leasedocument = resultSet.wasNull() ? null : new Integer(tempint);
		b.jrndate = resultSet.getTimestamp(3);
		tempint = resultSet.getInt(4);
		b.leasedocposition2 = resultSet.wasNull() ? null : new Integer(tempint);
		b.date2 = resultSet.getDate(5);
		b.jrnaction = resultSet.getInt(6);
		tempint = resultSet.getInt(7);
		b.currency1 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		b.leaserule = resultSet.wasNull() ? null : new Integer(tempint);
		b.summ2 = resultSet.getBigDecimal(10);
		b.jrntype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(11));
		tempint = resultSet.getInt(12);
		b.currency2 = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(13);
		b.leasedocposition = resultSet.wasNull() ? null : new Integer(tempint);
		b.summ1 = resultSet.getBigDecimal(14);
		tempint = resultSet.getInt(15);
		b.resource2 = resultSet.wasNull() ? null : new Integer(tempint);
		b.date1 = resultSet.getDate(16);
		b.jrnmessage = resultSet.getString(17);
		tempint = resultSet.getInt(18);
		b.journal2start_taskstart = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[17];
		tempint = resultSet.getInt(1);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[2] = resultSet.getTimestamp(3);
		tempint = resultSet.getInt(4);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[4] = resultSet.getDate(5);
		tempint = resultSet.getInt(6);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		cacheData[7] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[8] = resultSet.getBigDecimal(10);
		cacheData[9] = resultSet.getString(11);
		tempint = resultSet.getInt(12);
		cacheData[10] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(13);
		cacheData[11] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[12] = resultSet.getBigDecimal(14);
		tempint = resultSet.getInt(15);
		cacheData[13] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[14] = resultSet.getDate(16);
		cacheData[15] = resultSet.getString(17);
		tempint = resultSet.getInt(18);
		cacheData[16] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseTaskJournalBean b = (LeaseTaskJournalBean) eb;
		com.hps.july.persistence.LeaseTaskJournalKey _primaryKey = (com.hps.july.persistence.LeaseTaskJournalKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.taskjournal);
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
		LeaseTaskJournalBean b = (LeaseTaskJournalBean) eb;
		com.hps.july.persistence.LeaseTaskJournalKey _primaryKey = new com.hps.july.persistence.LeaseTaskJournalKey();
		_primaryKey.taskjournal = b.taskjournal;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseTaskJournalBean b = (LeaseTaskJournalBean) eb;
		com.hps.july.persistence.LeaseTaskJournalKey _primaryKey = new com.hps.july.persistence.LeaseTaskJournalKey();
		_primaryKey.taskjournal = b.taskjournal;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(18, _primaryKey.taskjournal);
			if (b.resource1 == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.resource1.intValue());
			}
			if (b.leasedocument == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.leasedocument.intValue());
			}
			if (b.jrndate == null) {
				pstmt.setNull(3, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(3, b.jrndate);
			}
			if (b.leasedocposition2 == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.leasedocposition2.intValue());
			}
			if (b.date2 == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.date2);
			}
			pstmt.setInt(6, b.jrnaction);
			if (b.currency1 == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.currency1.intValue());
			}
			if (b.leaserule == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.leaserule.intValue());
			}
			if (b.summ2 == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.summ2);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.jrntype);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.currency2 == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.currency2.intValue());
			}
			if (b.leasedocposition == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.leasedocposition.intValue());
			}
			if (b.summ1 == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.summ1);
			}
			if (b.resource2 == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.resource2.intValue());
			}
			if (b.date1 == null) {
				pstmt.setNull(15, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(15, b.date1);
			}
			if (b.jrnmessage == null) {
				pstmt.setNull(16, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(16, b.jrnmessage);
			}
			if (b.journal2start_taskstart == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.journal2start_taskstart.intValue());
			}
			int inputPos = 18;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
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
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
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
		LeaseTaskJournalBean b = (LeaseTaskJournalBean) eb;
		com.hps.july.persistence.LeaseTaskJournalKey _primaryKey = new com.hps.july.persistence.LeaseTaskJournalKey();
		_primaryKey.taskjournal = b.taskjournal;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.taskjournal);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
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
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[15]);
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
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
		com.hps.july.persistence.LeaseTaskJournalKey key = new com.hps.july.persistence.LeaseTaskJournalKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.taskjournal = resultSet.getInt(8);
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
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Integer taskStart, java.lang.Boolean isError, java.lang.Boolean isWarning, java.lang.Boolean isSuccess, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(taskStart, isError, isWarning, isSuccess, order);
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
	public com.hps.july.persistence.LeaseTaskJournal findByPrimaryKey(com.hps.july.persistence.LeaseTaskJournalKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseTaskJournal) home.activateBean(key);
	}
	/**
	 * findByTaskStartOrderByJrndateAscAndTaskjournalAsc
	 */
	public EJSFinder findByTaskStartOrderByJrndateAscAndTaskjournalAsc(java.lang.Integer taskStart, java.lang.Boolean isError, java.lang.Boolean isWarning, java.lang.Boolean isSuccess) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByTaskStartOrderByJrndateAscAndTaskjournalAsc(taskStart, isError, isWarning, isSuccess);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByTaskStartType
	 */
	public EJSFinder findByTaskStartType(java.lang.Integer taskStart, java.lang.Boolean isJrnType, java.lang.String jrnType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByTaskStartType(taskStart, isJrnType, jrnType, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findStart2journalByJournal2start
	 */
	public EJSFinder findStart2journalByJournal2start(com.hps.july.persistence.LeaseTaskStartKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.resource1, T1.leasedocument, T1.jrndate, T1.leasedocposition2, T1.date2, T1.jrnaction, T1.currency1, T1.taskjournal, T1.leaserule, T1.summ2, T1.jrntype, T1.currency2, T1.leasedocposition, T1.summ1, T1.resource2, T1.date1, T1.jrnmessage, T1.taskstart FROM leasetaskjournal  T1 WHERE T1.taskstart = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.taskstart);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByTaskStartOrderByJrnDate
	 */
	public EJSFinder findByTaskStartOrderByJrnDate(java.lang.Integer taskStart, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByTaskStartOrderByJrnDate(taskStart, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.resource1, T1.leasedocument, T1.jrndate, T1.leasedocposition2, T1.date2, T1.jrnaction, T1.currency1, T1.taskjournal, T1.leaserule, T1.summ2, T1.jrntype, T1.currency2, T1.leasedocposition, T1.summ1, T1.resource2, T1.date1, T1.jrnmessage, T1.taskstart FROM leasetaskjournal  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {292};
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
	private LeaseTaskJournalBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeaseTaskJournalBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeaseTaskJournalBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeaseTaskJournalBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
