package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import java.math.*;

/**
 * Печать отчёта "Текущее местоположение оборудования"
 */
public class Report08 extends AbstractReport {
	private String serial;
	private Boolean showAgregated;
	private int storagecard = 0;

	private int	resource;
	private String resourcename;
	private String resourcemodel;
	private String resourceconf;
	private String resourcetitle;
	private int storageplace;
	private String storageplacetype;
	private String storageplacename;
//	private String stype = "";
	private int mainpart;
	private String mainpartname = "";
	private String mainpartsn = "";
public Report08() {
	super();
}
public int getAgregationType(Statement stmt) {
	String s;
	int result = 0;
	ResultSet rs = null;

	try {
		s = "SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = "+storagecard;
System.out.println("SQL="+s);
		rs = stmt.executeQuery(s);
		if(rs.next()) {
			result = 1;
			mainpart = rs.getInt("agregate");
			rs.close(); rs = null;
			s = "SELECT r.name name, r.model model, "+
				"sc.configuration conf, sc.serialnumber sn "+
				"FROM storagecards sc, resources r, storageplaces s "+
				"WHERE sc.resource = r.resource AND "+
				"sc.storageplace = s.storageplace AND sc.storagecard = "+mainpart;
System.out.println("SQL="+s);
			rs = stmt.executeQuery(s);
			if(rs.next()) {
				mainpartname = rs.getString("name");
				if(mainpartname != null) mainpartname = mainpartname.trim();
				if(rs.getString("model") != null) {
					mainpartname += " " + rs.getString("model").trim();
				}
				if(rs.getString("conf") != null) {
					mainpartname += "; " + rs.getString("conf").trim();
				}
				if(rs.getString("sn") != null) {
					mainpartsn = rs.getString("sn").trim();
				}
			}
		} else {
			if(Boolean.TRUE.equals(showAgregated)) {
				rs.close(); rs = null;
				s = "SELECT agregatepart FROM agregatecontents a1 WHERE a1.agregate = "+storagecard;
System.out.println("SQL="+s);
				rs = stmt.executeQuery(s);
				if(rs.next()) {
					result = 2;
				}
			}
			rs.close(); rs = null;
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	} finally {
		if(rs != null) { try { rs.close(); } catch(Exception e) {} }
	}
	return result;
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
	System.out.println("In Report08.getReportData");
	String title = "no title";
	String[] columns = { "a" };
	java.util.ArrayList data = null;

	try {
		System.out.println("Report Title = " + engine.getReportTitle());
		title = engine.getReportTitle();
	}
	catch (ReportException e) {
		System.out.println("Cannot get report title");
	}

	Connection con = null;

	// Parameters
	// doc, serno, showIntDevices
	try {
		serial = getString(engine, 1);
		showAgregated = getBoolean(engine, 2);
	}
	catch (Exception e) {
		e.printStackTrace(System.out);
	}

	try {
		con = getConnection();
		columns =
			new String[] {
				"document",	"Name",	"serno", "Name2", "serno2", "Pos", "namepos",
				"code", "itemname",	"serno3", "partno","qty"
			};

		String s;
		ResultSet rs;
		Statement stmt = con.createStatement();
		PreparedStatement pstmt;

		s = "SELECT sc.storagecard card, sc.resource resource, " +
			"sc.storageplace storageplace, sp.type storageplacetype, "+ //s.name storageplacename, 
			ReportUtils.getFullStorageNameSQL("sp","storageplacename")+ ", "+
			"r.name name, r.model model, sc.configuration conf, serial_for_sc(sc.storagecard) serno "+
			"FROM storagecards sc, resources r, storageplaces sp "+
			"WHERE sc.resource = r.resource AND "+
			"sc.storageplace = sp.storageplace AND "+
			"sc.closed = 'N' AND "+
			"serialnumber = ?";
		System.out.println("R8 SQL="+s);
		pstmt =	con.prepareStatement(s);
		pstmt.setString(1, serial);
		System.out.println("R8 Serial="+serial);
		rs = pstmt.executeQuery();
		String serno = "";
		if (rs.next()) {
			storagecard = rs.getInt("card");
			resource = rs.getInt("resource");
			resourcename = rs.getString("name");
			resourcemodel = rs.getString("model");
			resourceconf = rs.getString("conf");
			storageplace = rs.getInt("storageplace");
			storageplacetype = rs.getString("storageplacetype").trim();
			storageplacename = rs.getString("storageplacename");
			serno = rs.getString("serno");
			if(storageplacename != null) storageplacename = storageplacename.trim();

			resourcetitle = ""+resource;
			if(resourcename != null) {
				resourcetitle = resourcename.trim();
			}
			if(resourcemodel != null) {
				resourcetitle += " " + resourcemodel.trim();
			}
			if(resourceconf != null && !"".equals(resourceconf)) {
				resourcetitle += "; " + resourceconf;
			}
		}
		else {
			// no storagecards with this SERNO
			resourcetitle = "Оборудование с таким серийным номером не найдено";
		}
		/// TODO: Concatenate resource title from name, model and configuration
		/// Determine storageplace full name

		String stype = getStype(stmt,storageplace);
//		storageplacename = ReportUtils.getFullStorageName(stmt,storageplace);
		/// Determine is resource agregate, agregate or single device
		int agregationType = getAgregationType(stmt);

		System.out.println("Returning data");
		data = new java.util.ArrayList();
		BigDecimal zero = new BigDecimal("0");
		switch (agregationType) {
			case 0 :
				// add one line with header only
				data.add(new Object[] {
					zero, resourcetitle, serno, mainpartname, mainpartsn, stype, storageplacename,
					"code",	"itemname",	"serno", "partno", new BigDecimal("1")
				});
				break;
			case 1 :
				// agregated - find main part
				data.add(new Object[] {
					zero, resourcetitle, serno, mainpartname, mainpartsn, stype, storageplacename, 
					"code", "itemname", "serno", "partno", new BigDecimal("1")
				});
				break;
			case 2 :
				// find blocks
				s = "SELECT sc.resource resource, TRIM(r.name) || ' ' || TRIM(r.model) name, r.model model, sc.configuration conf, "+
					"serial_for_sc(sc.storagecard) serial, sc.party party, sum(sc.qty) qty "+
					"FROM storagecards sc, resources r, storageplaces s "+
					"WHERE sc.resource = r.resource AND "+
					"sc.storageplace = s.storageplace AND "+
					"sc.storagecard in (SELECT agregatepart FROM agregatecontents a1 WHERE a1.agregate = "+storagecard+") "+
					"GROUP BY sc.resource, r.name, r.model, sc.configuration, sc.serialnumber, sc.party "+
					"ORDER BY name";
				rs = stmt.executeQuery(s);
				while(rs.next()) {
					data.add(new Object[] {
						zero, resourcetitle, serno, mainpartname, mainpartsn, stype, storageplacename, 
						new Integer(rs.getInt("resource")), rs.getString("name"), rs.getString("serial"), rs.getString("party"), rs.getBigDecimal("qty")
					});
				}
				break;
		}
		rs.close();
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
public static String getStype(Statement stmt, int storageplace) {
	String s;
	ResultSet rs = null;
	String stype = "S";	
	s = "SELECT "+
		"CASE sp.type "+
		"    WHEN 'S' THEN 'S' "+
		"    WHEN 'X' THEN (SELECT CASE e.organization WHEN NULL THEN 'O' ELSE 'W' END FROM expedition e WHERE e.expedition = sp.storageplace) "+
		"    ELSE 'P' "+
		"END stype "+
		"FROM storageplaces sp "+
		"WHERE sp.storageplace = "+storageplace;
	try {
		rs = stmt.executeQuery(s);
		if(rs.next()) {
			stype = rs.getString("stype");
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	try { rs.close(); } catch(Exception se) {}

	return stype;
}
}
