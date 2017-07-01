package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import java.math.*;
import java.util.*;

/**
 * Печать отчёта "Приход на объект". Подробный отчёт с указанием документов
 */
public class Report042 extends AbstractReport {
	private int docId;
	private int objectType;
	private String objectCode;
	private int storageplace;
	private Boolean stateDate;
	private java.sql.Timestamp date;
	private java.sql.Timestamp stDate;
	private java.sql.Timestamp endDate;
	private Boolean showContract;
	private java.util.Calendar cal = java.util.Calendar.getInstance();
public Report042() {
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
public String getComplectName(Statement stmt) {
	String name = "";
	ResultSet rs = null;
	try {
		rs = stmt.executeQuery(
			"SELECT sp.type, "+
			"CASE sp.type WHEN 'B' THEN b.name WHEN 'C' THEN NVL(l.type,'') WHEN 'O' THEN c.name WHEN 'W' THEN ''||s.number WHEN 'T' THEN o.type WHEN 'R' THEN rs.model WHEN 'L' THEN '' || w.number END name "+
			"FROM storageplaces sp, equipment e, outer basestations b, outer comequipment l, outer controllers c, outer switches s, outer otherequipment o, outer (repiters r, resources rs), outer wlan w "+
			"WHERE e.equipment = sp.storageplace AND "+
			"b.equipment = e.equipment AND l.equipment = e.equipment AND "+
			"c.equipment = e.equipment AND s.equipment = e.equipment AND "+
			"o.equipment = e.equipment AND r.equipment = e.equipment AND r.resource = rs.resource AND w.equipment = e.equipment "+
/*	
			"SELECT sp.type, CASE sp.type WHEN 'B' THEN b.name WHEN 'C' THEN l.type "+
			"WHEN 'O' THEN c.name WHEN 'W' THEN '' || s.number WHEN 'T' THEN o.type "+
			"END name "+
			"FROM storageplaces sp, equipment e, outer basestations b, "+
			"outer comequipment l, outer controllers c, outer switches s, outer otherequipment o "+
			"WHERE "+
			"e.equipment = sp.storageplace AND "+
			"b.equipment = e.equipment AND l.equipment = e.equipment AND "+
			"c.equipment = e.equipment AND s.equipment = e.equipment AND "+
			"o.equipment = e.equipment AND "+
*/
			"AND e.equipment = "+storageplace);
		if(rs.next()) {
			name = rs.getString("name");
		}
	} catch(Exception e) {
	} finally {
		try {
			if(rs != null) rs.close();
		} catch(SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}
	return name;
}
public String getComplectSQL() {
	String result =
	"INSERT INTO t_report42 (type1, type2, type3, name, "+
	"conf, unitname, ddate, dtype, dnumber, document, "+
	"price, qty, contract, postavka) "+
	"SELECT rt.name type1, rst.name type2, r.name type3, r.model mname, "+
	// "dp.configuration conf, u.shortname unitname, d.blankdate ddate, d.type dtype, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex) dnumber, "+
	"dp.configuration conf, u.shortname unitname, d.blankdate ddate, d.type dtype, TRIM(d.blanknumber) dnumber, "+
	"d.document, dp.price price, sum(dp.qty) qty, '', '' "+
	"FROM docpositions dp, resources r, resourcetypes rt, resourcesubtypes rst, "+
	"outer units u, documents d "+
	"WHERE dp.resource = r.resource AND r.resourcesubtype = rst.resourcesubtype "+
	"AND d.document = dp.document "+
	"AND rt.resourcetype = rst.resourcetype AND r.unit = u.unit "+
	"AND dp.document in ( "+
	"SELECT document FROM documents WHERE (type = 'W' or type = 'T') "+
	"AND to = "+storageplace+" AND blankdate >= "+getSQLDate(stDate)+" and blankdate <= "+getSQLDate(endDate)+" "+
	"AND state = '2' ) "+
	// "GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, d.blankdate, d.type, d.blankindex, d.blanknumber, d.document, dp.price, u.shortname";
	"GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, d.blankdate, d.type, d.blanknumber, d.document, dp.price, u.shortname";

	return result;
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
public String getPositionName(Statement stmt) {
	String name = "";
	ResultSet rs = null;
	try {
		rs = stmt.executeQuery("SELECT s.name, p.dampsid, p.gsmid FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = "+storageplace);
		if(rs.next()) {
			name = rs.getString("name");
			if(name == null) {
				name = "";
			} else {
				name = name.trim() + " ";
			}
			int a = rs.getInt("dampsid");
			if(!rs.wasNull()) {
				name += " A"+a;
			}
			int d = rs.getInt("gsmid");
			if(!rs.wasNull()) {
				name += " D"+d;
			}
		}
	} catch(Exception e) {
	} finally {
		try {
			if(rs != null) rs.close();
		} catch(SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}
	return name;
}
public String getPositionSQL() {
	String result =
	"INSERT INTO t_report42 (type1, type2, type3, name, "+
	"conf, unitname, ddate, dtype, dnumber, document, "+
	"price, qty, contract, postavka) "+
	"SELECT rt.name type1, rst.name type2, r.name type3, r.model mname, "+
	// "dp.configuration conf, u.shortname unitname, d.blankdate ddate, d.type dtype, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex) dnumber, "+
	"dp.configuration conf, u.shortname unitname, d.blankdate ddate, d.type dtype, TRIM(d.blanknumber) dnumber, "+
	"d.document, dp.price price, sum(dp.qty) qty, '', '' "+
	"FROM docpositions dp, resources r, resourcetypes rt, resourcesubtypes rst, "+
	"outer units u, documents d "+
	"WHERE dp.resource = r.resource AND r.resourcesubtype = rst.resourcesubtype "+
	"AND d.document = dp.document "+
	"AND rt.resourcetype = rst.resourcetype AND r.unit = u.unit "+
	"AND dp.document in ( "+
	"SELECT d.document FROM documents d, equipment e "+
	"WHERE (d.type = 'W' or d.type = 'T') "+
	"AND d.to = e.equipment AND e.position = "+storageplace+" AND blankdate >= "+getSQLDate(stDate)+" AND blankdate <= "+getSQLDate(endDate)+" "+
	"AND d.state = '2' )"+
	// "GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, d.blankdate, d.type, d.blankindex, d.blanknumber, d.document, dp.price, u.shortname";
	"GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, d.blankdate, d.type, d.blanknumber, d.document, dp.price, u.shortname";

	return result;
}
    public void getReportData( Engine engine, String configs ) {
	    System.out.println("In Report042.getReportData");
	    String title = "no title";
	    String[] columns = {"a"};
	    java.util.ArrayList data = null;

	    try {
	    	System.out.println("Report Title = " + engine.getReportTitle());
	    	title = engine.getReportTitle();
	    } catch (ReportException e) {
	    	System.out.println("Cannot get report title");
	    }

	    Connection con = null;

	    // Parameters
	    // doc, objectType, objectCode, stateDate, date, stDate, endDate
	    // Determine arguments
		storageplace = 0;
		String storageplacename = "";
		showContract = Boolean.TRUE;
	    try {
			docId = getInt(engine,0);
			objectType = getInt(engine,1);
			storageplace = ((Long)(getArray(engine,2)[0])).intValue();
			//storageplacename = getString(engine,3);			
			stateDate = getBoolean(engine,4);
			date = getDatetime(engine,5);
			stDate = getDatetime(engine,6);
			endDate = getDatetime(engine,7);
			showContract = getBoolean(engine,8);
	    } catch (Exception e) {
			e.printStackTrace(System.out);
	    }
	    try {
		    con = getConnection();
		    columns = new String[] {
			    "document", "curname", "posname",
			    "iorder", "type1", "type2", "type3", "name",
				"unitname", "delivdate", "doctype", "numdoc",
				"contract", "postavka",
				"qty", "price", "suma"
			};

	        String s;
	        ResultSet rs;
			Statement stmt = con.createStatement();
			//PreparedStatement pstmt;

			storageplacename = getStorageName(stmt);
			
			ResultSet rsUpd;

			String baseCurrency = "";
			// Execute header sql
			s =
			"SELECT c.shortname FROM namedvalues n, currencies c "+
			"WHERE n.id = 'BASE_CURRENCY' AND c.currency = n.intvalue";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);
			if(rs.next()) {
				baseCurrency = rs.getString("shortname");
				System.out.println("BASE CURRENCY=" + baseCurrency);
			}
			rs.close();

	        s = "DROP TABLE t_report42";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}

			s =
			"CREATE TEMP TABLE t_report42 ( "+
			"recid SERIAL, "+
			"type1 CHAR(100), "+
			"type2 CHAR(100), "+
			"type3 CHAR(100), "+
			"name CHAR(120), "+
			"conf CHAR(100), "+
			"unitname CHAR(20), "+
			"ddate DATE, "+
			"dtype CHAR(40), "+
			"dnumber CHAR(20), "+
			"document INTEGER, "+
			"price DECIMAL(15,2), "+
			"qty DECIMAL(15,3), "+
			"contract CHAR(40), "+
			"postavka CHAR(40), "+
			"PRIMARY KEY(recid) "+
			")";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Execute details sql
			switch(objectType) {
			case 1: // positions
				s = getPositionSQL();
				break;
			case 2: // storage
				s = getStorageSQL();
				break;
			case 3: // equipment
				s = getComplectSQL();
				break;
			default:
				s = null;
			}

			System.out.println("SQL=" + s);
			if(s == null || "".equals(s)) {
				throw new Exception("Unknown objectType. Should be one of following: 1- storage, 2- position, 3- equipment");
			}
			/*
			pstmt = con.prepareStatement(s);
			System.out.println("R42:STORAGE:" + storageplace);
			pstmt.setInt(1, storageplace);
			System.out.println("R42:START DATE:" + stDate);
			pstmt.setTimestamp(2, stDate);
			System.out.println("R42:END DATE:" + endDate);
			pstmt.setTimestamp(3, endDate);
			pstmt.execute();
			*/
			stmt.execute(s);
			
			if(Boolean.TRUE.equals(showContract)) {
//				ReportUtils.updateContractsAndSupplies(con/*,"t_report42"*/);
				s = "UPDATE t_report42 SET contract = ( "+
					"SELECT TRIM(c.name) || ' ' || TRIM(d.blanknumber) FROM documents d, contracts c, docdependencies dp "+
					"WHERE d.document = c.document AND dp.documentfrom = c.document "+
					"AND dp.documentto = t_report42.document), postavka = ( "+
					"SELECT cordocnum FROM inwaybills WHERE document = t_report42.document) ";
				stmt.execute(s);				
			}

			s = "UPDATE t_report42 SET dtype = (SELECT CASE d.type "+
				"WHEN 'W' THEN 'Внеш. прих. ордер' "+
				"WHEN 'T' THEN "+
				"  CASE sto.type "+
				"  WHEN 'S' THEN 'Внутр. прих. ордер' "+
				"  ELSE 'Акт монтажа' "+
				"  END "+
				"WHEN 'O' THEN 'Внеш. расх. накладная' "+
				"WHEN 'N' THEN "+
				"  CASE sfrom.type "+
				"  WHEN 'S' THEN 'Внутр. расх. накладная' "+
				"  ELSE 'Акт демонтажа' "+
				"  END "+
				"WHEN 'I' THEN 'Акт инвентаризации' "+
				"WHEN 'P' THEN 'Акт списания' "+
				"WHEN 'H' THEN 'Акт замены' "+
				"WHEN 'R' THEN 'Требование' "+
				"WHEN 'S' THEN 'Акт инвент. (излишки)' "+
				"WHEN 'F' THEN 'FAULT REPORT' "+
				"WHEN 'C' THEN 'Контракт' "+
				"WHEN 'A' THEN "+
				"  CASE a.operationtype "+
				"  WHEN 'A' THEN 'Акт монтажа блоков' "+
				"  WHEN 'D' THEN 'Акт демонтажа блоков' "+
				"  END "+
				"ELSE '' "+
				"END "+
				"FROM documents d, outer asemblingacts a, outer storageplaces sto, outer storageplaces sfrom "+
				"WHERE d.document = a.document AND d.to = sto.storageplace AND d.from = sfrom.storageplace "+
				"AND d.document = t_report42.document)";
			System.out.println("R4 SQL="+s);
			stmt.execute(s);

			s = "SELECT type1, type2, type3, name, conf, "+
				"unitname, ddate, dtype, dnumber, contract, postavka, qty, price "+
				"FROM t_report42 ORDER BY type1, type2, type3, name, conf, ddate, dtype, dnumber, qty, price";
			System.out.println("Returning data");
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);
			data = new java.util.ArrayList();
			int iorder = 1;
			BigDecimal zero = new BigDecimal("0");
//	"document", "curname", "storagename",
//	"iorder", "type1", "type2", "type3", "name",
//	"unitname", "delivdate", "doctype", "numdoc",
//	"contract", "postavka",
//	"qty", "price", "suma"
			while (rs.next())
			{
				String name = rs.getString("name");
				String conf = rs.getString("conf");
				if(name == null) name = "-";
				name = name.trim();
				if(conf != null && !"".equals(conf.trim())) {
					name = name + "; "+conf.trim();
				}
				BigDecimal qty = rs.getBigDecimal("qty");
				BigDecimal suma = zero;
				suma = qty.multiply(rs.getBigDecimal("price"));
		        data.add(new Object[] {
					new Integer(0), baseCurrency, storageplacename,
					new Integer(iorder++),
					rs.getString("type1"), rs.getString("type2"), rs.getString("type3"), name,
					rs.getString("unitname"), rs.getDate("ddate"), rs.getString("dtype"), rs.getString("dnumber"),
					rs.getString("contract"), rs.getString("postavka"),
					qty, rs.getBigDecimal("price"), suma
		        });
			}
			rs.close();
			stmt.close();
			//pstmt.close();
	    } catch (Exception e) {
	        System.out.println("Report4.2: ERROR: details FAILED. Stack trace:");
	        e.printStackTrace(System.out);
	    } finally {
		    try {
		    	con.close();
		    } catch (Exception e){
			    e.printStackTrace(System.out);
		    }
	    }
    
        try {
	        Object [][] objData = new Object[data.size()][];
	        int i = 0;
	        java.util.Iterator it = data.iterator();
	        while (it.hasNext()) {
		        Object [] row = (Object [])it.next();
		        objData [i] = row;
		        i++;
	        }
	        System.out.println("Returning rows:" + i);
        	engine.setData( columns, objData );
        } catch (java.lang.Throwable ex) {
	        System.out.println("ERROR: setData FAILED. Stack trace:");
	        ex.printStackTrace(System.out);
        }
    }
public String getSQLDate(Timestamp date) {
	if(date == null) {
		date = new java.sql.Timestamp((new java.util.Date()).getTime());
	}
	cal.setTime(date);
	return "{d '"+(cal.get(Calendar.YEAR))+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+"'}";
	//return "'"+date.getDate()+"."+(date.getMonth()+1)+"."+(date.getYear()+1900)+"'";
}
public String getStorageName(Statement stmt) {
	String name = "---";
	ResultSet rs = null;
	try {
		rs = stmt.executeQuery("SELECT name FROM storageplaces WHERE storageplace = "+storageplace);
		if(rs.next()) {
			name = rs.getString("name");
			System.err.println("++++++name: " + name);
		}
	} catch(Exception e) {
	} finally {
		try {
			if(rs != null) rs.close();
		} catch(SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}
	return name;
}
public String getStorageSQL() {
	String result =
	"INSERT INTO t_report42 (type1, type2, type3, name, "+
	"conf, unitname, ddate, dtype, dnumber, document, "+
	"price, qty, contract, postavka) "+
	"SELECT rt.name type1, rst.name type2, r.name type3, r.model mname, "+
	// "dp.configuration conf, u.shortname unitname, d.blankdate ddate, d.type dtype, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex) dnumber, "+
	"dp.configuration conf, u.shortname unitname, d.blankdate ddate, d.type dtype, TRIM(d.blanknumber) dnumber, "+
	"d.document, dp.price price, sum(dp.qty) qty, '', '' "+
	"FROM docpositions dp, resources r, resourcetypes rt, resourcesubtypes rst, "+
	"outer units u, documents d "+
	"WHERE dp.resource = r.resource AND r.resourcesubtype = rst.resourcesubtype "+
	"AND d.document = dp.document "+
	"AND rt.resourcetype = rst.resourcetype AND r.unit = u.unit "+
	"AND dp.document in ( "+
	"SELECT document FROM documents WHERE (type = 'W' or type = 'T') "+
	"AND to = "+storageplace+" AND blankdate >= "+getSQLDate(stDate)+" and blankdate <= "+getSQLDate(endDate)+" "+
	"AND state = '2' ) "+
	// "GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, d.blankdate, d.type, d.blankindex, d.blanknumber, d.document, dp.price, u.shortname";
	"GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, d.blankdate, d.type, d.blanknumber, d.document, dp.price, u.shortname";

	return result;
}
}
