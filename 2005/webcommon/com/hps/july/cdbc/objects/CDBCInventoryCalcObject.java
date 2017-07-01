package com.hps.july.cdbc.objects;

import java.math.BigDecimal;
import java.util.*;
import com.hps.july.cdbc.lib.*;
import java.sql.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Объект для поиска необсчитанных документов модуля "учёт оборудования".
 * Creation date: (12.03.2004)
 *
 * @TODO: find assembling acts and change acts
 *
 * @author: Anthon Stefanov
 */
public class CDBCInventoryCalcObject {
	private static String SELECT_HEAD = 
		"SELECT d.document, d.blankindex, d.blanknumber, d.from, d.to, d.blankdate, d.storagemanager, d.type, d.state, "+
		"(SELECT TRIM(TRIM(p.lastname) || ' ' || SUBSTR(p.firstname,1,1) || '. ' || SUBSTR(p.middlename,1,1) || '.') FROM workers w, people p WHERE p.man = w.man AND w.worker = d.storagemanager) smanname ";
public static void appendIN(StringBuffer sb, String param, String[] array)
{
	if(array == null) {
		return;
	} else if(array.length == 0)  {
		sb.append(param);
		sb.append(" IS NULL ");
	} else {
		sb.append(param);
		sb.append(" IN (");
		int i = 0;
		for(int k = 0; k < array.length; k++) {
			if(i > 0) sb.append(",");
			if(array[k] != null) {
				sb.append("'");
				sb.append(array[i]);
				sb.append("'");
				i++;
			}
		}
		sb.append(") ");
	}
}
public Iterator findAAPDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf, storageplaces spt, asemblingacts aa ");
	sb.append("WHERE d.state = '1' AND spf.storageplace = d.from AND spt.storageplace = d.to AND aa.document = d.document AND spf.type <> 'S' AND spt.type <> 'S' AND aa.operationtype = 'A' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.to = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findAASDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf, storageplaces spt, asemblingacts aa ");
	sb.append("WHERE d.state = '1' AND spf.storageplace = d.from AND spt.storageplace = d.to AND aa.document = d.document AND spf.type = 'S' AND spt.type = 'S' AND aa.operationtype = 'A' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.to = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findADPDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf, storageplaces spt, asemblingacts aa ");
	sb.append("WHERE d.state = '1' AND spf.storageplace = d.from AND spt.storageplace = d.to AND aa.document = d.document AND spf.type <> 'S' AND spt.type <> 'S' AND aa.operationtype = 'D' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.from = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findADSDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf, storageplaces spt, asemblingacts aa ");
	sb.append("WHERE d.state = '1' AND spf.storageplace = d.from AND spt.storageplace = d.to AND aa.document = d.document AND spf.type = 'S' AND spt.type = 'S' AND aa.operationtype = 'D' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.from = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findDocuments2Process(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, String sptype, Integer storageplace, String doctypes, Integer maxdocs)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();
	StringBuffer sbtmp = new StringBuffer();
	LinkedList ptmp = new LinkedList();

	Connection con = null;
	Statement st = null;
	CDBCResultSet res = new CDBCResultSet();
	CDBCResultSet tupd = new CDBCResultSet();
	int i = 0;
	try {
		JdbcConnection jcon = new JdbcConnection();
		con = jcon.getConnection();

		st = con.createStatement();
		
		// Создание временной таблицы
		try { st.executeUpdate("DROP TABLE tmpListDocuments2Process"); } catch(Throwable t) { /**/ }
		i = st.executeUpdate("CREATE TEMP TABLE tmpListDocuments2Process(documentid INTEGER NOT NULL, doctype CHAR(5), docnumber CHAR(80), docdate DATE, storage INTEGER, spname CHAR(255), opname CHAR(255)) ");
System.out.println("D2P:"+i);
		// Выполнение поиска документов и перенос их во временную таблицу
		// При переносе каждой записи назначается идентификатор документа
		// который будет использоваться для фильтрации по типам документов.
		sbtmp.append("INSERT INTO tmpListDocuments2Process(documentid, doctype, docnumber, docdate, spname, opname) ");
		// sbtmp.append("SELECT d.document, getdocumenttype(d.document), TRIM(d.blankindex || NVL(' ' || d.blanknumber, '')), d.blankdate, ");
		sbtmp.append("SELECT d.document, getdocumenttype(d.document), TRIM(d.blanknumber), d.blankdate, ");
		sbtmp.append("(SELECT TRIM(TRIM(p.lastname) || ' ' || SUBSTR(p.firstname,1,1) || '. ' || SUBSTR(p.middlename,1,1) || '.') FROM workers w, people p WHERE p.man = w.man AND w.worker = d.storagemanager), ");
		sbtmp.append("(SELECT TRIM(TRIM(p.lastname) || ' ' || SUBSTR(p.firstname,1,1) || '. ' || SUBSTR(p.middlename,1,1) || '.') FROM operators o, people p WHERE p.man = o.man AND o.operator = d.operator) ");
		sbtmp.append("FROM documents d ");
		sbtmp.append("WHERE d.state = '1' AND d.isautodoc = 'N' AND d.type <> 'C' ");
		sbtmp.append("AND d.blankdate BETWEEN ? AND ? ");
		ptmp.add(datefrom);
		ptmp.add(dateto);

		if(owner != null) {
			sbtmp.append("AND d.owner = ? ");
			ptmp.add(owner);
		}
System.out.println("SPtype:"+sptype);
		if(sptype != null && !"0".equals(sptype)) {
			if("1".equals(sptype)) {
				sbtmp.append("AND (d.from IN (SELECT e.equipment FROM equipment e WHERE e.position = ?) OR d.to IN (SELECT e.equipment FROM equipment e WHERE e.position = ?)) ");
				ptmp.add(storageplace);
				ptmp.add(storageplace);
			} else
			if("2".equals(sptype)) {
				// Склад
				sbtmp.append("AND (d.from = ? OR d.to = ?) ");
				ptmp.add(storageplace);
				ptmp.add(storageplace);
			} else
			if("3".equals(sptype)) {
				sbtmp.append("AND (d.from IN (SELECT ex.expedition FROM expedition ex WHERE ex.expeditor = ?) OR d.to IN (SELECT ex.expedition FROM expedition ex WHERE ex.expeditor = ?)) ");
				ptmp.add(storageplace);
				ptmp.add(storageplace);
			} else
			if("4".equals(sptype)) {
				sbtmp.append("AND (d.from IN (SELECT ex.expedition FROM expedition ex WHERE ex.organization = ?) OR d.to IN (SELECT ex.expedition FROM expedition ex WHERE ex.organization = ?)) ");
				ptmp.add(storageplace);
				ptmp.add(storageplace);
			}
		}

		tupd.executeUpdate(con,sbtmp.toString(),ptmp.toArray());

		i = st.executeUpdate("UPDATE tmpListDocuments2Process SET storage = (SELECT d.to FROM documents d WHERE d.document = documentid) WHERE doctype IN ('APA','BP','RS','TP','TS','WS') ");
System.out.println("D2P:2:"+i);
		i = st.executeUpdate("UPDATE tmpListDocuments2Process SET storage = (SELECT d.from FROM documents d WHERE d.document = documentid) WHERE doctype NOT IN ('APA','BP','RS','TP','TS','WS') ");
System.out.println("D2P:3:"+i);

		sb.append("SELECT documentid, doctype, docnumber, docdate, storage, getFullstoragename(storage) spname, opname ");
		sb.append("FROM tmpListDocuments2Process d2p ");
		// ADD where with document type selection
		if(doctypes != null && !"".equals(doctypes.trim())) {
			sb.append("WHERE d2p.doctype IN (");
			sb.append(doctypes);
			sb.append(") ");
		}
		sb.append("ORDER BY docdate ASC ");

		res.executeQuery(con,sb.toString(),params.toArray(),0);
System.out.println("D2P:4:"+res.getRowsCount());
		try { st.executeUpdate("DROP TABLE tmpListDocuments2Process"); } catch(Throwable t) { /**/ }
	} catch (Exception ee) {
		ee.printStackTrace(System.out);
	} finally {
		if(st != null) try { st.close(); } catch(Exception e) { /* Ignore error */ }
		try { con.close();	} catch (Exception e) {	/* Ignore error */ }
	}
	return res.listIterator();
}
public Iterator findHPDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf, storageplaces spt, changeact ca ");
	sb.append("WHERE d.state = '1' AND spf.storageplace = d.from AND spt.storageplace = d.to AND ca.document = d.document AND spf.type NOT IN ('S','X') AND spt.type NOT IN ('S','X') ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.from = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findHSDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf, storageplaces spt, changeact ca ");
	sb.append("WHERE d.state = '1' AND spf.storageplace = d.from AND spt.storageplace = d.to AND ca.document = d.document AND spf.type IN ('S','X') AND spt.type IN ('S','X') ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.from = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findIPDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf, storageplaces spt ");
	sb.append("WHERE d.state = '1' AND d.type = 'I' AND spf.storageplace = d.from AND spt.storageplace = d.to AND spf.type NOT IN ('S','E','X') AND spt.type NOT IN ('S','E','X') ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.to = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findISDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf, storageplaces spt ");
	sb.append("WHERE d.state = '1' AND d.type = 'I' AND spf.storageplace = d.from AND spt.storageplace = d.to AND spf.type = 'S' AND spt.type = 'S' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.to = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findNPDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf ");
	sb.append("WHERE d.state = '1' AND d.from = spf.storageplace AND spf.type NOT IN ('S','E','X') AND d.type = 'N' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.from = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findNSDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf ");
	sb.append("WHERE d.state = '1' AND d.from = spf.storageplace AND spf.type = 'S' AND d.type = 'N' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.from = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findODoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d ");
	sb.append("WHERE d.state = '1' AND d.type = 'O' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.from = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findPDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spf ");
	sb.append("WHERE d.state = '1' AND d.from = spf.storageplace AND spf.type = 'S' AND d.type = 'P' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.from = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findTPDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spt ");
	sb.append("WHERE d.state = '1' AND d.to = spt.storageplace AND spt.type NOT IN ('S','E','X') AND d.type = 'T' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.to = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findTSDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d, storageplaces spt ");
	sb.append("WHERE d.state = '1' AND d.to = spt.storageplace AND spt.type = 'S' AND d.type = 'T' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.to = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
public Iterator findWDoc(java.sql.Date datefrom, java.sql.Date dateto, Integer owner, Integer storageplace)
{
	StringBuffer sb = new StringBuffer();
	LinkedList params = new LinkedList();

	sb.append(SELECT_HEAD);
	sb.append("FROM documents d ");
	sb.append("WHERE d.state = '1' AND d.type = 'W' ");
	if(datefrom != null && dateto != null) {
		sb.append("AND d.blankdate BETWEEN ? AND ? ");
		params.add(datefrom);
		params.add(dateto);
	} else {
		sb.append("AND d.blankdate = TODAY ");
	}
	if(owner != null) {	
		sb.append("AND d.owner = ? ");
		params.add(owner);
	}
	if(storageplace != null) {
		sb.append("AND d.to = ? ");
		params.add(storageplace);
	}

	sb.append("ORDER BY d.blankdate ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res.listIterator();
}
}
