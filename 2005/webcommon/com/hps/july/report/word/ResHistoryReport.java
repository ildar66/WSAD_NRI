package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * Печать отчёта "История перемещений"
 */
public class ResHistoryReport extends AbstractReport {
	private static java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("dd.MM.yyyy");
public ResHistoryReport() {
	super();
}
public String getDocumentNameSQL() {
	return 
"CASE d.type \n"+
"WHEN 'W' THEN 's.external.waybill' \n"+
"WHEN 'T' THEN \n"+
"	CASE spt.type \n"+
"	WHEN 'S' THEN 's.internal.waybill' \n"+
"	ELSE 'p.assembling' \n"+
"	END \n"+
"WHEN 'N' THEN \n"+
"	CASE spf.type \n"+
"	WHEN 'S' THEN 's.internal.outbill' \n"+
"	ELSE 'p.dismantling' \n"+
"	END \n"+
"WHEN 'O' THEN 's.external.outbill' \n"+
"WHEN 'P' THEN \n"+
"CASE spf.type \n"+
"	WHEN 'S' THEN 's.payoff' \n"+
"	WHEN 'X' THEN 'e.payoff' \n"+
"	ELSE 'p.payoff' \n"+
"	END \n"+
"WHEN 'C' THEN 'contract' \n"+
"WHEN 'S' THEN \n"+
"	CASE spt.type \n"+
"	WHEN 'S' THEN 's.surplus' \n"+
"	WHEN 'X' THEN 'e.surplus' \n"+
"	ELSE 'p.surplus' \n"+
"	END \n"+
"WHEN 'I' THEN \n"+
"	CASE spt.type \n"+
"	WHEN 'S' THEN 's.inventarization' \n"+
"	ELSE 'p.inventarization' \n"+
"	END \n"+
"WHEN 'A' THEN \n"+
"	CASE aa.operationtype \n"+
"	WHEN 'A' THEN \n"+
"		CASE spt.type \n"+
"		WHEN 'S' THEN 's.assembling.block' \n"+
"		ELSE 'p.assembling.block' \n"+
"		END \n"+
"	WHEN 'D' THEN \n"+
"		CASE spf.type \n"+
"		WHEN 'S' THEN 's.dismantling.block' \n"+
"		ELSE 'p.dismantling.block' \n"+
"		END \n"+
"	END \n"+
"WHEN 'H' THEN \n"+
"	CASE spf.type \n"+
"	WHEN 'S' THEN 's.change' \n"+
"	WHEN 'X' THEN 'e.change' \n"+
"	ELSE 'p.change' \n"+
"	END \n"+
"WHEN 'R' THEN 's.request' \n"+
"WHEN 'F' THEN 'fault' \n"+
"WHEN 'B' THEN 'p.afsmount' \n"+
"ELSE '-' \n"+
"END docname\n";
}
public static String getPositionNameSQL() {
	return 
		"CASE sp.type "+
		"WHEN 'P' THEN (SELECT TRIM(s.name) || NVL(' D' || p.gsmid, '') || NVL(' A'||p.dampsid,'') name FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = sp.storageplace) "+
		"WHEN 'S' THEN '' "+
		"WHEN 'X' THEN '' "+
		"ELSE (SELECT NVL('D'||p.gsmid||' ','') || NVL('A' || p.dampsid || ' ', '') || TRIM(s.name) FROM equipment e, positions p, storageplaces s WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"END positionname ";
}
public void getReportData( Engine engine, String configs ) {
	log("in getReportData");
	String title = "ResHistoryReport";
	String[] columns = {"a"};
	java.util.ArrayList data = null;

    try {
		log("Report Title = " + engine.getReportTitle());
		title = engine.getReportTitle();
	} catch (ReportException e) {
		log("Cannot get report title");
	}

    Connection con = null;

    String serialnumber;

    // Determine arguments
    try {
		serialnumber = super.getString(engine,0);
	} catch (Exception e) {
		serialnumber = "-";
		log(e);
	}
    try {
	    con = getConnection();
	    // need to be the same column names as in the report
        columns = new String[]{
				"doc", "resname", "resserial", "resmanuf", "storetype", "storename",
				"agrname", "argserial", "agrmanuf",

				"opdate", "docname", "docnum", "storesrc", "storedest", "headres"
		};
		String s;
        ResultSet rs;
        Statement stmt = con.createStatement();

        String resourcename = "";
        String serial = "";
        String manufserial = "";
        String currentstorage = "";
        String currentstoragetype = "";
        String agregate = "";
        String agrtitle = "";
        
        // SQL executing
        s = "DROP TABLE reshistory_d";
		try {
			logSQL(s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}

		s = "DROP TABLE reshistory_d_docs";
		try {
			logSQL(s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}

		s = "CREATE TEMP TABLE reshistory_d ( "+
			"recid SERIAL, "+
			"docid INTEGER, "+
			"trackid INTEGER, "+
			"serial CHAR(100), "+
			"mserial CHAR(100), "+
			"storagecard INTEGER, "+
			"resname CHAR(100), "+
			"opdate DATETIME YEAR TO FRACTION(5), "+
			"docname CHAR(100), "+
			"docdate DATE, "+
			"docnum CHAR(100), "+
			"storesrc CHAR(120), "+
			"storedest CHAR(120), "+
			"headname CHAR(120), "+
			"PRIMARY KEY(recid) "+
			")";
		logSQL(s);
		stmt.execute(s);

		s = "CREATE TEMP TABLE reshistory_d_docs ( "+
			"recid SERIAL, "+
			"docid INTEGER, "+
			"trackid INTEGER, "+
			"PRIMARY KEY(recid) "+
			")";
		logSQL(s);
		stmt.execute(s);

		String nserial = serialnumber;
		boolean repeat = true;
		int r = selectDetails(stmt, nserial, false);
		if(r < 1) {
			r = selectDetails(stmt, nserial, true);
		}
		// downward serial search
		while(repeat) {
			s = "SELECT cp.oldserial oldserial "+
				"FROM documents d, changeact c, changeactpos cp "+
				"WHERE d.document = c.document  AND c.document = cp.document "+
				"AND cp.newserial = '"+nserial+"' AND cp.oldserial <> cp.newserial";
			logSQL(s);
			rs = stmt.executeQuery(s);
			if(rs.next()) {
				nserial = rs.getString("oldserial");
				selectDetails(stmt, nserial, true);
			} else {
				repeat = false;
			}
			rs.close();
		}
/*
		// upward serial search
		nserial = serialnumber;
		repeat = true;
		while(repeat) {
			s = "SELECT cp.newserial newserial "+
				"FROM documents d, changeact c, changeactpos cp "+
				"WHERE d.document = c.document  AND c.document = cp.document "+
				"AND cp.oldserial = '"+nserial+"' AND cp.oldserial <> cp.newserial";
			logSQL(s);
			rs = stmt.executeQuery(s);
			if(rs.next()) {
				nserial = rs.getString("newserial");
				rs.close();
				selectDetails(stmt, nserial);
			} else {
				rs.close();
				repeat = false;
			}
		}
*/
		insertByDependenciesDetails(stmt);

		// get header
        s = "SELECT sc.storageplace, sp.type sptype, "+ReportUtils.getStorageNameSQL()+", \n"+
			"TRIM(r.name) || ' ' || TRIM(r.model) || NVL(' ' || TRIM(sc.configuration),'') resname, \n"+
			"serial_for_sc(sc.storagecard) serial, sc.inventserial manuf, x.expeditor exp, x.organization org \n"+
			"FROM storagecards sc, resources r, storageplaces sp, outer expedition x \n"+
			"WHERE sc.resource = r.resource AND sc.storageplace = sp.storageplace AND \n"+
			"sp.storageplace = x.expedition AND sc.closed = 'N' AND \n"+
			"sc.serialnumber = '"+serialnumber+"'\n";
		logSQL(s);
		rs = stmt.executeQuery(s);
		if(rs.next()) {
			resourcename = rs.getString("resname");
			serial = rs.getString("serial");
			manufserial = rs.getString("manuf");
			currentstorage = rs.getString("storagename");
log(currentstorage);
			String spt = rs.getString("sptype");
			if(spt != null) {
				if("S".equals(spt.trim())) {
					currentstoragetype = "Склад: ";
				} else if("X".equals(spt.trim())) {
					rs.getInt("exp");
					if(rs.wasNull()) {
						rs.getInt("org");
						if(rs.wasNull()) {
							currentstoragetype = "Неизвестный подрядчик или сотрудник";
						} else {
							currentstoragetype = "Подрядчик";
						}
					} else {
						currentstoragetype = "Сотрудник";
					}
				} else {
					currentstoragetype = "Позиция / Комплект оборудования";
				}
			} else {
				currentstoragetype = "Текущее местоположение не известно";
			}
//			currentstorage = currentstoragetype + currentstorage;
		}
		rs.close();

	 	// Выбор наименования агрегата
		s = "SELECT TRIM(r.name) || ' ' || TRIM(r.model) || NVL(' ' || TRIM(sc.configuration),'') agrname, "+
			"serial_for_sc(sc.storagecard) agrserial, sc.inventserial agrmanuf "+
			"FROM agregatecontents agc, storagecards sc, resources r "+
			"WHERE sc.storagecard = agc.agregate AND sc.resource = r.resource AND agc.agregatepart IN ( "+
			"SELECT sc1.storagecard FROM storagecards sc1 WHERE sc1.serialnumber = '"+nserial+"')";
		logSQL(s);
		rs = stmt.executeQuery(s);
		if(rs.next()) {
			agregate = rs.getString("agrname");
			agregate += " Инвентарный (заводской) серийный номер " + rs.getString("agrserial");
/*
			if(rs.getString("agrmanuf") != null && !rs.getString("agrmanuf").equals(rs.getString("agrserial"))) {
				agregate += " ("+rs.getString("agrmanuf")+")";
			}
*/
			agrtitle = "Встроено в оборудование: ";
		}
		rs.close();
// end get head

		s = "SELECT docid, trackid, TRIM(serial) serial, TRIM(mserial) mserial, storagecard, TRIM(resname) resname, opdate, TRIM(docname) docname, TRIM(docnum) docnum, docdate, "+
			"TRIM(storesrc) storesrc, TRIM(storedest) storedest, TRIM(headname) headname "+
			"FROM reshistory_d "+
			"ORDER BY opdate DESC";
		logSQL(s);
		rs = stmt.executeQuery(s);

		log("Returning data");
		data = new java.util.ArrayList();
		while(rs.next()) {
			String rname = rs.getString("resname");
			String _ser = rs.getString("serial");
/*
			if(_ser != null) { _ser = _ser.trim(); } else { _ser = ""; }
			if(rs.getString("mserial") != null && !"".equals(rs.getString("mserial").trim()) && !(rs.getString("mserial").trim()).equals(_ser)) {
				_ser += " ("+rs.getString("mserial").trim()+")";
			}
*/
			rname += " S/N:"+_ser;
			String sdest = "";
			if(rs.getString("storedest") != null && !"".equals(rs.getString("storedest"))) {
				sdest = "Местоположение: "+rs.getString("storedest");
			} else {
				sdest = "Оборудование списано";
			}
			String docnum = rs.getString("docnum");
			if(rs.getDate("docdate") != null) {
				docnum += " от " + df.format(rs.getDate("docdate"));
			}
//System.out.println("SN HIST ["+serialnumber+"]: docdate:"+rs.getDate("docdate"));
	        data.add(new Object[]{
		        new Integer(0),
				rname, // resourcename, //
				sdest, serialnumber,
				"", //currentstoragetype, // rs.getString("storetype"),
				""+rs.getInt("storagecard"), //currentstorage, //rs.getString("storename"),
		        agregate, "", agrtitle,
		        rs.getTimestamp("opdate"),
		        rs.getString("docname"),
				docnum,
		        rs.getString("storesrc"),
		        rs.getString("storedest"),
				rs.getString("headname")
	        });
	        // show string
		}
		rs.close();
		reportNewData(data, con, serialnumber);
	} catch (Exception e) {
		log("ERROR: details FAILED. Stack trace:");
		log(e);
    } finally {
	    try {
	    	con.close();
	    } catch (Exception e){
			log(e);
	    }
    }
    
	try {
		Object [][] objData = new Object[data.size()][];
		int i = 0;
		java.util.Iterator it = data.iterator();
		while (it.hasNext()) {
	        log("Returning row #" + i);
	        Object [] row = (Object [])it.next();
	        objData [i] = row;
	        i++;
        }
       	engine.setData( columns, objData );
    } catch (java.lang.Throwable ex) {
		log("ERROR: setData FAILED. Stack trace:");
		log(ex);
	}
}
public void insertByDependenciesDetails(Statement stmt)
	throws java.lang.Exception
{
	String s;
	/*
	s = "UPDATE reshistory_d "+
		"SET docname = ("+
		"SELECT TRIM(reshistory_d.docname) || '.' || LOWER(d.type) FROM documents d, docdependencies ddp "+
		"WHERE ddp.documentto = reshistory_d.docid AND d.document = ddp.documentfrom "+
		"), "+
		"docdate = ("+
		"SELECT d.blankdate FROM documents d, docdependencies ddp "+
		"WHERE ddp.documentto = reshistory_d.docid AND d.document = ddp.documentfrom "+
		") ";
	*/
	s = "UPDATE reshistory_d "+
		"SET docname = ("+
		"SELECT " + getDocumentNameSQL() + " FROM documents d, docdependencies ddp, "+
		"outer storageplaces spf, outer storageplaces spt, outer asemblingacts aa "+
		"WHERE ddp.documentto = reshistory_d.docid AND d.document = ddp.documentfrom "+
		" AND spf.storageplace = d.from AND spt.storageplace = d.to AND aa.document = d.document " +
		"), "+
		"docdate = ("+
		"SELECT d.blankdate FROM documents d, docdependencies ddp "+
		"WHERE ddp.documentto = reshistory_d.docid AND d.document = ddp.documentfrom "+
		") " +
		"WHERE EXISTS (SELECT d.blankdate FROM documents d, docdependencies ddp "+
		"WHERE ddp.documentto = reshistory_d.docid AND d.document = ddp.documentfrom)";

	logSQL(s);
	stmt.execute(s);
		
/*
	// Берём коды исходных документов по связям. TrackId берём максимальный из пары
	s = "INSERT INTO reshistory_d_docs (docid, trackid) "+
		"SELECT ddp.documentfrom, MAX(rh.trackid) trackid "+
		"FROM docdependencies ddp, reshistory_d rh "+
		"WHERE ddp.documentto = rh.docid "+
		"GROUP BY ddp.documentfrom ";
	logSQL(s);
	stmt.execute(s);
	
	// Вставка исходных документов
	s = "INSERT INTO reshistory_d (docid, opdate, trackid, docname, docnum, storesrc, storedest, serial, mserial, storagecard) \n"+
		"SELECT d.document, ct.when, rhd.trackid, \n"+
		getDocumentNameSQL()+", \n"+
		"CASE d.type "+
		"WHEN 'W' THEN "+
		"	d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') || NVL(' (Счёт ' || TRIM(iwb.cordocnum) || ')','') "+
		"ELSE "+
		"	d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') "+
		"END docnum, \n"+
		ReportUtils.getStorageNameSQL("spf","storesrc")+ ", \n"+
		ReportUtils.getStorageNameSQL("spt","storedest")+", \n"+
		"sc.serialnumber, sc.manufserial, sc.storagecard \n"+
		"FROM documents d, reshistory_d_docs rhd, cardtracks ct, storagecards sc, "+
		"	outer storageplaces spf, outer storageplaces spt, "+
		"	outer (asemblingacts aa, storagecards agsc, resources agr), "+
		"	outer inwaybills iwb "+
		"WHERE "+
		"	d.document = rhd.docid "+
		"	AND spf.storageplace = d.from "+
		"	AND spt.storageplace = d.to AND aa.document = d.document "+
		"	AND iwb.document = d.document AND ct.trackid = rhd.trackid AND ct.storagecard = sc.storagecard ";

	logSQL(s);
	stmt.execute(s);

	// Удаление связанных документов из выборки
	s = "DELETE FROM reshistory_d "+
		"WHERE docid IN (SELECT dd.documentto  FROM docdependencies dd, reshistory_d_docs rhd "+
		"WHERE dd.documentfrom = rhd.docid)";
	logSQL(s);
	stmt.execute(s);
*/
}
public void log(String s) {
	//System.out.println("ResHistoryReport: "+s);
}
public void log(Throwable e) {
	e.printStackTrace(System.out);
}
public void logSQL(String s) {
	//log("[SQL]="+s);
}
// Учет новых данных (после 29.10.2004)
//   по новому алгоритму учета движения оборудования
public void reportNewData(java.util.ArrayList data, java.sql.Connection con, String serialnumber)
	throws java.lang.Exception
{
        Statement stmt = con.createStatement();

		// Определим карточку
		String resname = "";
		String resserial = "";
		String resmanuf = "";
		String storagename = "";
		String agregate = "";
		String agrtitle = "";
		String headname = "";
		String storesrc = "";
		String storedest = "";
		String docname = "";
		String docnum = "";
		Integer cardid = new Integer(0);
		Integer docid = new Integer(0);
		java.sql.Date blankdate = null;
		String qry1= "SELECT storagecard FROM storagecards WHERE serialnumber = ?";
		CDBCResultSet rs1 = new CDBCResultSet();
		rs1.executeQuery(con, qry1, new Object[] {serialnumber}, 0);
		java.util.ListIterator it1 = rs1.listIterator();
		while (it1.hasNext()) {
			CDBCRowObject ro1 = (CDBCRowObject)it1.next();
			cardid = (Integer)ro1.getColumn("storagecard").asObject();
				
			String qry2 = "SELECT st.trackid, st.serial, st.inventserial manufserial, st.storageplace, st.document, st.resource, st.operation_type " +
				" FROM storagetracks st " +
				" WHERE st.cardid = ? AND st.parent_trackid IS NULL AND (st.operation_type = 1 OR st.operation_type = 2) " +
				" ORDER BY st.trackid ASC ";
			CDBCResultSet rs2 = new CDBCResultSet();
			rs2.executeQuery(con, qry2, new Object[] {cardid}, 0);

			java.util.ListIterator it2 = rs2.listIterator();
			while (it2.hasNext()) {
				CDBCRowObject ro2 = (CDBCRowObject)it2.next();
				docid = (Integer)ro2.getColumn("document").asObject();
				
				String qry3 = "SELECT  " +
				"TRIM(r.name) || NVL(' ' || TRIM(r.model), '') || NVL(' ' || TRIM(s.configuration),'') || ' S/N: ' resname, " +
				"s.storageplace " +
				" FROM storagecards s, resources r " +
				" WHERE r.resource = s.resource AND s.storagecard = ? ";
				CDBCResultSet rs3 = new CDBCResultSet();
				rs3.executeQuery(con, qry3, new Object[] {cardid}, 1);
				java.util.ListIterator it3 = rs3.listIterator();
				if (it3.hasNext()) {
					CDBCRowObject ro3 = (CDBCRowObject)it3.next();
					resname = ro3.getColumn("resname").asString() + ro2.getColumn("serial").asString();
					storagename = "Местоположение: " + ReportUtils.getFullStorageName(stmt, ((Integer)ro3.getColumn("storageplace").asObject()).intValue());
					resmanuf = ro2.getColumn("serial").asString();

					// Определим документ
					String qry5 = "SELECT d.document, d.type, d.blankdate, \n"+
						getDocumentNameSQL()+",  \n"+
						"CASE d.type \n"+
						"WHEN 'W' THEN \n"+
						"	d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') || NVL(' (Счёт ' || TRIM(iwb.cordocnum) || ')','') \n"+
						"ELSE \n"+
						"	d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') \n"+
						"END docnum, \n"+
						"TRIM(agr.model) || NVL(' ' || TRIM(agsc.configuration),'') || NVL(' (' || TRIM(agsc.serialnumber) || ')','') headname \n"+
						"FROM documents d,  \n"+
						"outer storageplaces spf, outer storageplaces spt, \n"+
						"outer (asemblingacts aa, storagecards agsc, resources agr), \n"+
						"outer inwaybills iwb \n"+
						"WHERE \n"+
						"d.document = ? AND spf.storageplace = d.from \n"+
						"AND spt.storageplace = d.to AND aa.document = d.document \n"+
						"AND iwb.document = d.document \n"+
						"AND aa.agregat = agsc.storagecard \n"+
						"AND agsc.resource = agr.resource \n";
					CDBCResultSet rs5 = new CDBCResultSet();
					rs5.executeQuery(con, qry5, new Object[] {docid}, 1);
					java.util.ListIterator it5 = rs5.listIterator();
					if (it5.hasNext()) {
						CDBCRowObject ro5 = (CDBCRowObject)it5.next();
						docname = ro5.getColumn("docname").asString();
						docnum = ro5.getColumn("docnum").asString();
						headname = ro5.getColumn("headname").asString();
						blankdate = (java.sql.Date)ro5.getColumn("blankdate").asObject();
					}
					

					if ("2".equals(ro2.getColumn("operation_type").asString())) {
						// Если был расход - найдем соответствующий приход
						storesrc = ReportUtils.getFullStorageName(stmt, ((Integer)ro2.getColumn("storageplace").asObject()).intValue());
						String qry4 = "SELECT st.trackid, st.storageplace " +
							" FROM storagetracks st " +
							" WHERE st.parent_trackid = ? AND st.operation_type = 1 " +
							" ORDER BY st.trackid ASC ";
						CDBCResultSet rs4 = new CDBCResultSet();
						rs4.executeQuery(con, qry4, new Object[] {ro2.getColumn("trackid").asObject()}, 1);

						java.util.ListIterator it4 = rs4.listIterator();
						if (it4.hasNext()) {
							CDBCRowObject ro4 = (CDBCRowObject)it4.next();
							storedest = ReportUtils.getFullStorageName(stmt, ((Integer)ro4.getColumn("storageplace").asObject()).intValue());
						} else {
							storedest = "";
						}
					} else {
						// Был только приход, без расхода
						storesrc = "";
						storedest = ReportUtils.getFullStorageName(stmt, ((Integer)ro2.getColumn("storageplace").asObject()).intValue());
					}

	//				"doc", "resname", "resserial", "resmanuf", "storetype", "storename",
	//				"agrname", "argserial", "agrmanuf",

	//				"opdate", "docname", "docnum", "storesrc", "storedest", "headres"

			        data.add(new Object[]{
				        new Integer(0), // doc
						resname, 
						storagename, // resserial
						resmanuf,    // resmanuf
						"",          //currentstoragetype,
						cardid.toString(), // По этому признаку меняется группа
						//CDBCStoragecardsObject.findBySerial(con,ro2.getColumn("serial").asString()), // По этому признаку меняется группа
				        agregate, "", agrtitle,
				        blankdate,
				        docname,  // Document name -- change
						docnum + " от " + df.format(blankdate),
				        storesrc,
				        storedest,
						headname
			        });
					
				}
				
			}
		}
}
public int selectDetails(Statement stmt, String serialnumber, boolean closed)
	throws java.lang.Exception
{
	// Выбор детайлов
	String s =
		"INSERT INTO reshistory_d (docid, trackid, opdate, docname, docdate, docnum, storesrc, storedest, headname, serial, mserial, storagecard, resname) \n"+
		"SELECT d.document, ct.trackid, ct.when opdate, \n"+
		getDocumentNameSQL()+", d.blankdate, \n"+
		"CASE d.type \n"+
		"WHEN 'W' THEN \n"+
		"	d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') || NVL(' (Счёт ' || TRIM(iwb.cordocnum) || ')','') \n"+
		"ELSE \n"+
		"	d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') \n"+
		"END docnum, \n"+
		ReportUtils.getFullStorageNameSQL("spf","storesrc")+ ", \n"+
		ReportUtils.getFullStorageNameSQL("spt","storedest")+", \n"+
		"TRIM(agr.model) || NVL(' ' || TRIM(agsc.configuration),'') || NVL(' (' || serial_for_sc(agsc.storagecard) || ')','') headname, \n"+
		"serial_for_sc(sc.storagecard), sc.inventserial manufserial, sc.storagecard, TRIM(r.name) || NVL(' ' || TRIM(r.model),'') || NVL(' ' || TRIM(sc.configuration),'') resname \n"+
		"FROM cardtracks ct, documents d, storagecards sc, resources r, \n"+
		"outer storageplaces spf, outer storageplaces spt, \n"+
		"outer (asemblingacts aa, storagecards agsc, resources agr), \n"+
		"outer inwaybills iwb \n"+
		"WHERE \n"+
		"ct.document = d.document AND spf.storageplace = d.from \n"+
		"AND spt.storageplace = d.to AND aa.document = d.document \n"+
		"AND iwb.document = d.document \n"+
		"AND ct.storagecard = sc.storagecard AND r.resource = sc.resource \n"+
		"AND aa.agregat = agsc.storagecard \n"+
		"AND agsc.resource = agr.resource \n"+
		"AND sc.serialnumber = '"+
		ReportUtils.quoteForSQL(
			((serialnumber == null || "".equals(serialnumber.trim()))?"":serialnumber.trim())
		) +  "'  ";
		//+"'\n AND sc.closed = "+(closed?"'Y'":"'N'");

	logSQL(s);

	//System.out.println("--" + ReportUtils.quoteForSQL(serialnumber.trim()) + "--");
	return stmt.executeUpdate(s);
}
}
