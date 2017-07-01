package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import java.math.*;

/**
 * Печать отчёта "Местоположение оборудования"
 */
public class Report02 extends AbstractReport {
	private int resource;
	private String resourcemodel;
	private String resourcename = "";
	private int searchon; // 1 till 5 - search type
	private Boolean stateType;
	private java.sql.Date stateDate;
	private Boolean groupByStorage;
	private Boolean showAgregated;
	private Boolean showOncard;
public Report02() {
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
	System.out.println("In Report2.getReportData");
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
		try {
			resource = Integer.parseInt(getString(engine,1));
		} catch(Exception e) {
			resource = 0;
		}
		resourcemodel = getString(engine,2);
		resourcename = getString(engine,3);
		searchon = getInt(engine,4);
		stateType = getBoolean(engine,5);
		stateDate = getDate(engine,6);
		groupByStorage = getBoolean(engine,7);
		showAgregated = getBoolean(engine,8);
		showOncard = getBoolean(engine,9);
	}
	catch (Exception e) {
		e.printStackTrace(System.out);
	}

	try {
		con = getConnection();
		columns =
			new String[] {
				"document",	"iorder", "type1", "type2", "name", "namepos", "serno",
				"inc", "break", "unitname", "qty"
			};

		String s;
		ResultSet rs = null;
		Statement stmt = con.createStatement();
//		PreparedStatement pstmt;

		// find resource name
		s = "SELECT TRIM(name) || ', ' || TRIM(model) name FROM resources WHERE resource = "+resource;
		System.out.println("R2 SQL="+s);
		rs = stmt.executeQuery(s);
		if(rs.next()) {
			resourcename = rs.getString("name");
		}

		s = "DROP TABLE t_report2";
		try {
			System.out.println("R2 SQL=" + s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}
		
		s = "CREATE TEMP TABLE t_report2 ( "+
			"recid SERIAL, "+
			"storagecard INTEGER, "+
			"agregate INTEGER, "+
			"sptype CHAR(1), "+
			"spname CHAR(120), "+
			"splace INTEGER, "+
			"policy CHAR(1), "+
			"serno CHAR(40), "+
			"partno CHAR(40), "+
			"broken CHAR(1), "+
			"qty DECIMAL(15,3), "+
			"unitname CHAR(20), "+
			"PRIMARY KEY(recid) "+
			")";
		System.out.println("R2 SQL="+s);
		stmt.execute(s);

		// searchon:
		// 1 - anywhere, 2 - positions, 3 - storages, 4 - organizations, 5 - workers
		
		// form detailed SQL
		s = 
		"INSERT INTO t_report2 "+
		"(storagecard, agregate, sptype, spname, splace, policy, serno, partno, broken, qty, unitname) "+
		"SELECT sc.storagecard,(SELECT agregate FROM agregatecontents WHERE agregatepart = sc.storagecard) agregate, "+
		"sp.type, ";

		s +=
		"CASE sp.type "+
		"WHEN 'P' THEN (SELECT TRIM(s.name) || NVL(' A'||p.dampsid,'') || NVL(' D' || p.gsmid, '') name FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = sp.storageplace) "+
		"WHEN 'S' THEN (SELECT TRIM(s1.name) name FROM storageplaces s1 WHERE s1.storageplace = sp.storageplace) "+
		"WHEN 'X' THEN (SELECT NVL(trim(o.name),TRIM(p.lastname) || ' ' || NVL(SUBSTR(TRIM(p.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p.middlename),1,1)||'.','')) name "+
		"		FROM expedition e, outer organizations o, outer (workers w, people p) "+
		"		WHERE o.organization = e.organization AND "+
		"		e.expeditor = w.worker AND p.man = w.man AND e.expedition = sp.storageplace) "+
		"WHEN 'E' THEN (SELECT TRIM(s.name) || NVL(' A'||p.dampsid,'') || NVL(' D' || p.gsmid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'B' THEN (SELECT TRIM(s.name) || NVL(' A'||p.dampsid,'') || NVL(' D' || p.gsmid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'C' THEN (SELECT TRIM(s.name) || NVL(' A'||p.dampsid,'') || NVL(' D' || p.gsmid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'O' THEN (SELECT TRIM(s.name) || NVL(' A'||p.dampsid,'') || NVL(' D' || p.gsmid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'W' THEN (SELECT TRIM(s.name) || NVL(' A'||p.dampsid,'') || NVL(' D' || p.gsmid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'T' THEN (SELECT TRIM(s.name) || NVL(' A'||p.dampsid,'') || NVL(' D' || p.gsmid, '') name "+
		"		FROM equipment e, positions p, storageplaces s "+
		"		WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"END storagename ";

		s +=", sc.storageplace, r.countpolicy, serial_for_sc(sc.storagecard), sc.party, "+
		"sc.broken, sc.qty qty, u.shortname unitname "+
		"FROM storagecards sc, storageplaces sp, resources r, units u ";
		if(searchon == 4 || searchon == 5) {
			s += ", expedition x ";
		}
		s +=
		"WHERE sc.resource = "+resource+" AND "+
		"sc.storageplace = sp.storageplace AND "+
		"sc.resource = r.resource AND "+
		"r.unit = u.unit AND "+
		"sc.closed = 'N' ";
		switch(searchon) {
		case 2: s+= " AND sp.type in ('P','E','B','C','O','W','T') "; break;
		case 3: s+= " AND sp.type = 'S' "; break;
		case 4: s+= " AND sp.type = 'X' AND sp.storageplace = x.expedition AND x.organization is not null "; break;
		case 5: s+= " AND sp.type = 'X' AND sp.storageplace = x.expedition AND x.expeditor is not null "; break;
		}
		System.out.println("R2 SQL="+s);
		stmt.execute(s);

		s = "UPDATE t_report2 SET serno = NVL(TRIM(serno),''), partno = NVL(TRIM(partno),'') ";
		System.out.println("R2 SQL="+s);
		stmt.execute(s);

		if(groupByStorage != null && groupByStorage.booleanValue()) {
			s = //"SELECT spname, '' spnum, agregate, broken, sum(qty) qty, unitname FROM t_report2 GROUP BY spname, agregate, broken, unitname ORDER BY spname ";
				"SELECT spname, '' policy, '' serno, '' partno, agregate, broken, sum(qty) qty, unitname FROM t_report2 "+
				"GROUP BY spname, agregate, broken, unitname "+
				"ORDER BY spname ";
		} else {
			s = //"SELECT spname, CASE policy WHEN 'S' THEN serno WHEN 'P' THEN partno WHEN 'B' THEN '' END spnum, agregate, broken, qty, unitname FROM t_report2 ORDER BY spname";
				"SELECT spname, agregate, policy, serno, partno, broken, sum(qty) qty, unitname FROM t_report2 "+
				"GROUP BY spname, agregate, broken, unitname, policy, serno, partno "+
				"ORDER BY spname ";
		}
		rs = stmt.executeQuery(s);

		System.out.println("R2: Returning data");
		BigDecimal zero = new BigDecimal("0");
		int iorder = 1;
		String storageplacename = "";
		String spnum = "";
		Boolean broken = Boolean.FALSE;
		Boolean agregated = Boolean.FALSE;
		
		while(rs.next()) {
			storageplacename = rs.getString("spname");
			if(storageplacename != null) {
				storageplacename = storageplacename.trim();
			}
			/*
			else {
				storageplacename = "Хранилище №"+storageplace;
			}
			*/
			if("S".equals(rs.getString("policy"))) {
				spnum = rs.getString("serno");
			} else
			if("P".equals(rs.getString("policy"))) {
				spnum = rs.getString("partno");
			} else {
				spnum = null;
			}
			/*
			spnum = rs.getString("spnum");
			*/
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
			data.add(new Object[] {
				zero, new Integer(iorder++), "type1", "type2", resourcename,
				storageplacename, spnum, agregated, broken,
				rs.getString("unitname"), rs.getBigDecimal("qty")
			});
		}
		System.out.println("R2 IORDER:'"+iorder+"'");
/*		
		System.out.println("STYPE:'"+stype+"'");
		switch (agregationType) {
			case 0 :
				// add one line with header only
				data.add(new Object[] {
					zero, resourcetitle, serial, mainpartname, mainpartsn, stype, storageplacename,
					"code",	"itemname",	"serno", "partno","qty"
				});
				break;
			case 1 :
				// agregated - find main part
				data.add(new Object[] {
					zero, resourcetitle, serial, mainpartname, mainpartsn, stype, storageplacename, 
					"code", "itemname", "serno", "partno", "qty"
				});
				break;
			case 2 :
				// find blocks
				s = "SELECT sc.resource resource, r.name name, r.model model, sc.configuration conf, "+
					"sc.serialnumber serial, sc.party party, sum(sc.qty) qty "+
					"FROM storagecards sc, resources r, storageplaces s "+
					"WHERE sc.resource = r.resource AND "+
					"sc.storageplace = s.storageplace AND "+
					"sc.storagecard in (SELECT agregatepart FROM agregatecontents a1 WHERE a1.agregate = "+storagecard+") "+
					"GROUP BY sc.resource, r.name, r.model, sc.configuration, sc.serialnumber, sc.party "+
					"ORDER BY name";
				rs = stmt.executeQuery(s);
				while(rs.next()) {
					data.add(new Object[] {
						zero, resourcetitle, serial, mainpartname, mainpartsn, stype, storageplacename, 
						new Integer(rs.getInt("resource")), rs.getString("name"), rs.getString("serial"), rs.getString("party"), rs.getBigDecimal("qty")
					});
				}
				break;
		*/
		if(rs != null) rs.close();

		// try to drop temp table
		s = "DROP TABLE t_report2";
		try {
			System.out.println("R2 SQL=" + s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}
	}
	catch (Exception e) {
		System.out.println("Report8: ERROR: details FAILED. Stack trace:");
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
