package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import java.math.*;

/**
 * Печать отчёта "Оборудование, контракты и поставки"
 */
public class Report03 extends AbstractReport {
	private Boolean alltype;
	private int restype;
	private Boolean allsbtype;
	private int ressbtype;
	private int baseAgreement;
	private int supply;
	private String account;
	private Boolean stateType;
	private java.sql.Timestamp stateDate;
	private int searchon; // 1 till 3 - search type
	private Boolean groupByStorage;
	private Boolean showAgregated;
	private Boolean showContract;
	private Boolean showOnmap;
	private String accname;

	private static String STORAGENAME_SQL = 
		"CASE sp.type "+
		"WHEN 'P' THEN (SELECT TRIM(s.name) || NVL(' D'|| p.gsmid,'') || NVL(' A' || p.dampsid, '') name FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = sp.storageplace) "+
		"WHEN 'S' THEN (SELECT TRIM(s1.name) name FROM storageplaces s1 WHERE s1.storageplace = sp.storageplace) "+
		"WHEN 'X' THEN (SELECT NVL(trim(o.name),TRIM(p.lastname) || ' ' || NVL(SUBSTR(TRIM(p.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p.middlename),1,1)||'.','')) name "+
		"		FROM expedition e, outer organizations o, outer (workers w, people p) "+
		"		WHERE o.organization = e.organization AND "+
		"		e.expeditor = w.worker AND p.man = w.man AND e.expedition = sp.storageplace) "+
		"WHEN 'E' THEN (SELECT TRIM(s.name) || NVL(' D'|| p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'B' THEN (SELECT TRIM(s.name) || NVL(' D'|| p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'C' THEN (SELECT TRIM(s.name) || NVL(' D'|| p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'O' THEN (SELECT TRIM(s.name) || NVL(' D'|| p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'W' THEN (SELECT TRIM(s.name) || NVL(' D'|| p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'T' THEN (SELECT TRIM(s.name) || NVL(' D'|| p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"END storagename ";
public Report03() {
	super();
}
public Object[] getArray(Engine e, int i) {
	Object o;
	try {
		o = e.getPrompt(i);
	} catch(ReportException re) {
		o = new Object();
	}
	if(o instanceof Object[]) {
		return (Object[])o;
	} else {
		return null;
	}
}
public Boolean getBoolean(Engine e, int i) {
	Object o;
	try {
		o = e.getPrompt(i);
	} catch(ReportException re) {
		o = new Object();
	}
	if(o instanceof Boolean) {
		return (Boolean)o;
	} else {
		return null;
	}
}
public java.sql.Date getDate(Engine e, int i) {
	Object o = new Object();
	try {
		o = e.getPrompt(i);
		if(o instanceof java.sql.Date) {
			return (java.sql.Date)o;
		} else {
			return null;
		}
	} catch(ReportException re) {
		re.printStackTrace(System.out);
		return null;
	} catch(ClassCastException cce) {
    	System.out.println("Actual class of PROMPT["+i+"]:"+o.getClass().getName());
    	return null;
	}
}
public java.sql.Timestamp getDatetime(Engine e, int i) {
	Object o = new Object();
	try {
		o = e.getPrompt(i);
		if(o instanceof java.sql.Timestamp) {
			return (java.sql.Timestamp)o;
		} else {
			return null;
		}
	} catch(ReportException re) {
		re.printStackTrace(System.out);
		return null;
	} catch(ClassCastException cce) {
    	System.out.println("Actual class of PROMPT["+i+"]:"+o.getClass().getName());
    	return null;
	}
}
public int getInt(Engine e, int i) {
	Object o;
	try {
		o = e.getPrompt(i);
	} catch(ReportException re) {
		o = new Object();
	}
	if(o instanceof Long) {
		return ((Long)o).intValue();
	} else {
		return 0;
	}
}
public void getReportData(Engine engine, String configs) {
	System.out.println("In Report3.getReportData");
	String title = "no title";
	String[] columns = { "a" };
	java.util.ArrayList data = null;
	data = new java.util.ArrayList();

	try {
		System.out.println("Report Title = " + engine.getReportTitle());
		title = engine.getReportTitle();
	}
	catch (ReportException e) {
		System.out.println("Cannot get report title");
	}

	Connection con = null;

	// Parameters
	int docId = 0; // ???
	try {
		docId = getInt(engine,0);
		alltype = getBoolean(engine,1);
		allsbtype = getBoolean(engine,2);
		try {
			restype = Integer.parseInt(getString(engine,3));
		} catch(Exception e) { restype = 0; }
		try {
			ressbtype = Integer.parseInt(getString(engine,4));
		} catch(Exception e) { ressbtype = 0; }
		baseAgreement = getInt(engine,5);
		supply = getInt(engine,6);
		account = getString(engine,7);
		stateType = getBoolean(engine,8);
		stateDate = getDatetime(engine,9);
		searchon = getInt(engine,10);
		groupByStorage = getBoolean(engine,11);
		showAgregated = getBoolean(engine,12);
		showContract = getBoolean(engine,13);
		showOnmap = getBoolean(engine,14);
		accname = getString(engine,15);
	}
	catch (Exception e) {
		e.printStackTrace(System.out);
	}

	try {
		con = getConnection();
		columns =
			new String[] {
				"document", "iorder", "type1", "type2", "type3", "name", "posname",
				"serno", "inc", "break", "unitname", "qty", "contract", "postavka"
			};

		String s;
		ResultSet rs = null;
		Statement stmt = con.createStatement();
		Statement stmtUpd = con.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
		ResultSet rsUpd;

		String baseAgreementName = "";
		String supplyName = "";

		// find baseagreement name
		if(baseAgreement > 0) {
			s = "SELECT name FROM baseagreements WHERE baseagreement = "+baseAgreement;
			try {
				System.out.println("R3 SQL="+s);
				rs = stmt.executeQuery(s);
				if(rs.next()) {
					baseAgreementName = rs.getString("name");
					if(baseAgreementName != null) baseAgreementName = baseAgreementName.trim();
				}
			} finally {
				rs.close();
			}
		}
		// find contract name
		if(supply > 0) {
			s = "SELECT TRIM(c.name) || ' ' || TRIM(d.blanknumber) name "+
				"FROM contracts c, documents d "+
				"WHERE c.document = d.document AND c.document = "+supply;
			System.out.println("R3 SQL="+s);
			try {
				rs = stmt.executeQuery(s);
				if(rs.next()) {
					supplyName = rs.getString("name");
					if(supplyName != null) supplyName = supplyName.trim();
				}
			} finally {
				rs.close();
			}
		}

		s = "DROP TABLE t_report3";
		try {
			System.out.println("R3 SQL=" + s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}

		// create temp tables for documents and storageplaces
		s = "CREATE TEMP TABLE t_report3 ( "+
			"recid SERIAL, "+
			"storagecard INTEGER, "+
			"agregate INTEGER, "+
			"sptype CHAR(1), "+
			"spname CHAR(120), "+
			"splace INTEGER, "+
			"res INTEGER, "+
			"resname CHAR(120), "+
			"resmodel CHAR(120), "+
			"policy CHAR(1), "+
			"serno CHAR(40), "+
			"partno CHAR(40), "+
			"broken CHAR(1), "+
			"qty DECIMAL(15,3), "+
			"unitname CHAR(20), "+
			"contract CHAR(120), "+
			"postavka CHAR(120), "+
			"PRIMARY KEY(recid) "+
			")";
		System.out.println("R3 SQL="+s);
		stmt.execute(s);

		s = "DROP TABLE t_report3docpos";
		try {
			System.out.println("R3 SQL=" + s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}

		s = "CREATE TEMP TABLE t_report3docpos ( "+
			"recid SERIAL, docpos INTEGER, owner INTEGER, resource INTEGER, policy CHAR(1), "+
			"serial CHAR(40), mserial CHAR(40), party CHAR(40), "+
			"contract CHAR(120), postavka CHAR(120), "+
			"PRIMARY KEY(recid) ) ";
		System.out.println("R3 SQL="+s);
		stmt.execute(s);

		String contractWHERE = "";
		if(baseAgreement > 0) {
			contractWHERE += " AND c.baseagreement = "+baseAgreement+" ";
		}
		if(supply > 0) {
			contractWHERE += " AND c.document = "+supply+" ";
		}
		if(account != null && !"".equals(account)) {
			contractWHERE += "AND i.cordocnum MATCHES '"+ReportUtils.quoteForSQL(account)+"' ";
		}

		String resourceWHERE = "";
		if(alltype != null && !alltype.booleanValue()) {
			s+= " AND rt.resourcetype = "+restype+" ";
			if(allsbtype != null && !allsbtype.booleanValue()) {
				s+=" AND rst.resourcesubtype = "+ressbtype+" ";
			}
		}
		
			
		s = "INSERT INTO t_report3docpos(docpos,owner,resource,policy,serial,mserial,party,contract,postavka) "+
			"SELECT dp.docposition, dp.owner, dp.resource, r.countpolicy, dp.serialnumber, dp.inventserial manufserial, dp.party, "+
			"TRIM(c.name) || ' ' || TRIM(dc.blanknumber), i.cordocnum "+
			"FROM docpositions dp, resources r, resourcetypes rt, resourcesubtypes rst, inwaybills i, documents d, docdependencies dd, contracts c, documents dc "+
			"WHERE dd.type = 'I' AND dd.documentfrom = c.document AND i.document = dd.documentto "+
			"AND d.document = i.document AND d.state = '2' AND c.document = dc.document "+
			"AND dp.document = i.document AND dp.resource = r.resource AND r.countpolicy IN ('S','P') "+
			"AND r.resourcesubtype = rst.resourcesubtype AND rst.resourcetype = rt.resourcetype ";
		s += contractWHERE + resourceWHERE;
		System.out.println("R3 SQL="+s);
		stmt.execute(s);

		s = "INSERT INTO t_report3docpos(docpos,owner,resource,policy,serial,mserial,party,contract,postavka) "+
			"SELECT i.docposition, dp.owner, dp.resource, r.countpolicy, dp.serialnumber, dp.inventserial manufserial, dp.party, TRIM(c.name) || ' ' || TRIM(dc.blanknumber),i.cordocnum "+
			"FROM i13nact id, i13actpos i, docpositions dp, contracts c, resources r, resourcetypes rt, resourcesubtypes rst, "+
			"documents d, documents dc "+
			"WHERE dp.docposition = i.docposition AND dp.document = id.document AND i.contract = c.document "+
			"AND d.document = id.document AND dc.document = c.document "+
			"AND dp.resource = r.resource AND r.countpolicy IN ('S','P') "+
			"AND r.resourcesubtype = rst.resourcesubtype AND rst.resourcetype = rt.resourcetype ";
		s += contractWHERE + resourceWHERE;
		System.out.println("R3 SQL="+s);
		stmt.execute(s);
		
		s = "UPDATE t_report3docpos "+
			"SET serial = (SELECT newserial FROM changeactpos WHERE oldserial = t_report3docpos.serial), "+
			"mserial = (SELECT inventserial FROM changeactpos WHERE oldserial = t_report3docpos.serial) "+
			"WHERE serial IN (SELECT oldserial FROM changeactpos) AND policy = 'S' ";
		System.out.println("R3 SQL="+s);
		stmt.execute(s);

		String storageplaceSQL = "";
		switch(searchon) {
		case 2: storageplaceSQL = " AND sp.type in ('P','E','B','C','O','W','T') "; break;
		case 3: storageplaceSQL = " AND sp.type = 'S' "; break;
		}

		String agregateSQL = "";
		if(showAgregated != null && showAgregated.booleanValue()) {
			agregateSQL = " AND NOT EXISTS (SELECT agregate FROM agregatecontents WHERE agregatepart = sc.storagecard) ";
		}
		
		// get result for party
		s = "INSERT INTO t_report3 ( "+
			"storagecard, agregate, "+
			"sptype, spname, splace, res, resname, resmodel,"+
			"policy, serno, partno, broken, qty, unitname, contract, postavka) "+
			"SELECT sc.storagecard, "+
			"(SELECT agregate FROM agregatecontents WHERE agregatepart = sc.storagecard) agregate, "+
			"sp.type, "+STORAGENAME_SQL+", "+
			"sc.storageplace, r.resource, TRIM(r.name), TRIM(r.model) || NVL(', '||sc.configuration,''), "+
			"r.countpolicy, serial_for_sc(sc.storagecard), sc.party, sc.broken, sc.qty, "+
			"u.shortname, t3.contract, t3.postavka "+
			"FROM storagecards sc, resources r, units u, storageplaces sp, t_report3docpos t3 "+
			"WHERE sc.resource = r.resource AND "+
			"r.unit = u.unit AND "+
			"sp.storageplace = sc.storageplace AND t3.policy = 'P' AND "+
			"sc.party = t3.party AND sc.resource = t3.resource AND sc.owner = t3.owner AND "+
			"sc.closed = 'N' "+storageplaceSQL+agregateSQL;
		System.out.println("R3 SQL="+s);
		stmt.execute(s);
		// get result for serial
		s = "INSERT INTO t_report3 ( "+
			"storagecard, agregate, "+
			"sptype, spname, splace, res, resname, resmodel,"+
			"policy, serno, partno, broken, qty, unitname, contract, postavka) "+
			"SELECT sc.storagecard, "+
			"(SELECT agregate FROM agregatecontents WHERE agregatepart = sc.storagecard) agregate, "+
			"sp.type, "+STORAGENAME_SQL+", "+
			"sc.storageplace, r.resource, TRIM(r.name), TRIM(r.model) || NVL(', '||sc.configuration,''), "+
			"r.countpolicy, serial_for_sc(sc.storagecard), sc.party, sc.broken, sc.qty, "+
			"u.shortname, t3.contract, t3.postavka "+
			"FROM storagecards sc, resources r, units u, storageplaces sp, t_report3docpos t3 "+
			"WHERE sc.resource = r.resource AND "+
			"r.unit = u.unit AND "+
			"sp.storageplace = sc.storageplace AND "+
			"sc.serialnumber = t3.serial AND t3.policy = 'S' AND "+
			"sc.closed = 'N' "+storageplaceSQL+agregateSQL;
		System.out.println("R3 SQL="+s);
		stmt.execute(s);

		s = "UPDATE t_report3 SET serno = NVL(TRIM(serno),''), partno = NVL(TRIM(partno),'') ";
		System.out.println("R3 SQL="+s);
		stmt.execute(s);

		BigDecimal zero = new BigDecimal("0");
		int iorder = 1;
		String storageplacename = "";
		String spnum = "";
		Boolean broken = Boolean.FALSE;
		Boolean agregated = Boolean.FALSE;

		if(groupByStorage != null && groupByStorage.booleanValue()) {
			s =	"SELECT spname, resname, resmodel, '' serno, '' partno, '' policy, sum(qty) qty, unitname, "+
				"agregate, broken, contract, postavka FROM t_report3 "+
				"GROUP BY spname, resname, resmodel, contract, postavka, agregate, broken, unitname "+
				"ORDER BY spname, resname, resmodel";
		} else {
			s =	"SELECT spname, resname, resmodel, serno, partno, policy, sum(qty) qty, unitname, "+
				"agregate, broken, contract, postavka FROM t_report3 "+
				"GROUP BY spname, resname, resmodel, contract, postavka, serno, partno, policy, agregate, broken, unitname "+
				"ORDER BY spname, resname, resmodel";
		}
		System.out.println("R3 SQL="+s);
		rs = stmt.executeQuery(s);

		System.out.println("R3: Returning data");

		try {
			while(rs.next()) {
				storageplacename = rs.getString("spname");
				if(storageplacename != null) {
					storageplacename = storageplacename.trim();
				}
				if("S".equals(rs.getString("policy"))) {
					spnum = rs.getString("serno");
				} else
				if("P".equals(rs.getString("policy"))) {
					spnum = rs.getString("partno");
				} else {
					spnum = null;
				}
				if(spnum != null) {
					spnum = spnum.trim();
				} else {
					spnum = "";
				}
				if(rs.getInt("agregate") > 0) {
					agregated = Boolean.TRUE;
				} else {
					agregated = Boolean.FALSE;
				}
				if("Y".equals(rs.getString("broken"))) {
					broken = Boolean.TRUE;
				} else {
					broken = Boolean.FALSE;
				}
				String unitname = rs.getString("unitname");
				BigDecimal qty = rs.getBigDecimal("qty");
				String contract = rs.getString("contract");
				String post = rs.getString("postavka");
				data.add(new Object[] {
					zero, new Integer(iorder++), "type1", "type2",
					rs.getString("resname"), rs.getString("resmodel"),
					storageplacename, spnum, agregated, broken,
					unitname, qty, 
					contract,
					post
				});
			}
		} finally {
			rs.close();
		}

		System.out.println("R3 IORDER:'"+iorder+"'");
		if(rs != null) rs.close();

		// try to drop temp table
		s = "DROP TABLE t_report3";
		try {
			System.out.println("R3 SQL=" + s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}
		s = "DROP TABLE t_report3docpos";
		try {
			System.out.println("R3 SQL=" + s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}
	}
	catch (Exception e) {
		System.out.println("Report3: ERROR: details FAILED. Stack trace:");
		e.printStackTrace(System.out);
	}
	finally {
		try {
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	try {
		Object[][] objData = new Object[data.size()][];
		int i = 0;
		java.util.Iterator it = data.iterator();
		while (it.hasNext()) {
			Object[] row = (Object[]) it.next();
			objData[i] = row;
			i++;
		}
		System.out.println("Returning rows:" + i);
		engine.setData(columns, objData);
	}
	catch (java.lang.Throwable ex) {
		System.out.println("ERROR: setData FAILED. Stack trace:");
		ex.printStackTrace(System.out);
	}
}
}
