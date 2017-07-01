package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import java.math.*;
import java.util.*;

/**
 * Печать отчёта "Приход оборудования на объект"
 */
public class Report05 extends AbstractReport {
	private int docId;
	private int objectType;
	private String objectCode;
	private int storageplace;
	private String storageplacename;
	private Boolean stateDate;
	private java.sql.Timestamp date;
	private java.sql.Timestamp stDate;
	private java.sql.Timestamp endDate;

	private int resource;
	private int posnum;

	private Boolean docAll;
	private Boolean docIntincome;
	private Boolean docExtincome;
	private Boolean docAssact;
	private Boolean docAssactb;
	private Boolean docInvextra;

	private Boolean showContract;
	private static Calendar cal = Calendar.getInstance();
public Report05() {
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
public String getDetailsSQL() {
	String result =
		"INSERT INTO t_report05 (document, delivdate, doctype, numdoc, unitname, contract, postavka, "+
		"qty, price, serno, partno, policy) "+
		"SELECT d.document doc, d.blankdate ddate, d.type dtype, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), u.shortname unitname, "+
		"'', '', dp.qty qty, dp.price price, serial_for_docpos(dp.docposition), dp.party, r.countpolicy "+
		"FROM docpositions dp, resources r, documents d, units u "+
		"WHERE dp.resource = r.resource AND d.document = dp.document  AND r.unit = u.unit "+
		"AND r.resource = "+resource+" "+
		"AND dp.document in ( "+
		getDocumentsCollectionSQL()+
		")";

	return result;
}
public String getDocumentsCollectionSQL() {
	String result;
	String docs = "";

	result= "SELECT d.document FROM documents d "+
			"WHERE d.state = '2' ";
System.out.println("R5 objectType="+objectType);
	switch(objectType) {
	case 1: // position
		result = "SELECT d.document FROM documents d, equipment e "+
				"WHERE d.state = '2' "+
				"AND d.to = e.equipment AND e.position = "+storageplace;
		break;
	case 2: // storage
		result += "AND d.to = "+storageplace;
		break;
	case 3: // equipment
		result += "AND d.to = "+storageplace;
		break;
	default:
	}
	result += " AND d.blankdate >= "+getSQLDate(stDate)+" AND d.blankdate <= "+getSQLDate(endDate)+" ";

	System.out.println("DOC ALL:"+docAll);
	if(docAll == null) {
		docAll = Boolean.TRUE;
	}
	if(docAll.booleanValue()) {
		result += "AND d.type in ('W','A','T','I') ";
	} else {
//		System.out.println("DOC EXT:"+docExtincome);
		if(docExtincome.booleanValue()) {
			if(!"".equals(docs)) docs += ",";
			docs += "'W'";
		}
//		System.out.println("DOC INT:"+docIntincome);
		if(docIntincome.booleanValue()) {
			if(!"".equals(docs)) docs += ",";
			docs += "'T'";
		}
//		System.out.println("DOC ASS:"+docAssact+", "+docAssactb);
		if(docAssact.booleanValue() || docAssactb.booleanValue()) {
			if(!"".equals(docs)) docs += ",";
			docs += "'A'";
		}
//		System.out.println("DOC INV:"+docInvextra);
		if(docInvextra.booleanValue()) {
			if(!"".equals(docs)) docs += ",";
			docs += "'I'";
		}
		if(!"".equals(docs)) {
			result += "AND d.type in ("+docs+") ";
		} else {
			result += "AND d.type in ('') ";
		}

	}
	return result;
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
    public void getReportData( Engine engine, String configs ) {
	    System.out.println("In Report05.getReportData");
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
		storageplacename = "";
	    try {
			docId = getInt(engine,0);
			objectType = getInt(engine,1);
			storageplace = ((Long)(getArray(engine,2)[0])).intValue();
			stateDate = getBoolean(engine,3);
			date = getDatetime(engine,4);
			stDate = getDatetime(engine,5);
			endDate = getDatetime(engine,6);
			resource = getInt(engine,7);
			docAll = getBoolean(engine,8);
			docIntincome = getBoolean(engine,9);
			docExtincome = getBoolean(engine,10);
			docAssact = getBoolean(engine,11);
			docAssactb = getBoolean(engine,12);
			docInvextra = getBoolean(engine,13);
			showContract = getBoolean(engine,14);
	    } catch (Exception e) {
			e.printStackTrace(System.out);
	    }
	    System.out.println("R5 objectType="+objectType);
	    try {
		    con = getConnection();
		    columns = new String[] {
				"document", "curname", "posname", "type",
				"unitname", "delivdate", "doctype", "numdoc", "contract",
				"postavka", "qty", "price", "suma", "serno"
			};

	        String s;
	        ResultSet rs;
	        Statement stmt = con.createStatement();
	        PreparedStatement pstmt;
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
			storageplacename = "";
			storageplacename = ReportUtils.getFullStorageName(stmt,storageplace);

			String resourcename = "---";
			s = "SELECT TRIM(name) || ', ' || TRIM(model) name FROM resources WHERE resource = "+resource;
			rs = stmt.executeQuery(s);
			if(rs.next()) {
				resourcename = rs.getString("name").trim();
			}
			
	        s = "DROP TABLE t_report05";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}

			s =
			"CREATE TEMP TABLE t_report05 ( "+
			"recid SERIAL, "+
			"document INTEGER, "+
			"delivdate DATE, "+
			"doctype CHAR(1), "+
			"numdoc CHAR(120), "+
			"unitname CHAR(120), "+
			"contract CHAR(40), "+
			"postavka CHAR(40), "+
			"qty DECIMAL(15,3), "+
			"price DECIMAL(15,2), "+
			"serno CHAR(40), "+
			"partno CHAR(40), "+
			"policy CHAR(1), "+
			"PRIMARY KEY(recid) "+
			")";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Execute details sql
			s = getDetailsSQL();
			System.out.println("SQL=" + s);
			stmt.execute(s);

			if(showContract != null && showContract.booleanValue()) {
				/*
				s = "UPDATE t_report05 "+
					"SET postavka = (SELECT UNIQUE iw.cordocnum "+
					"FROM inwaybills iw "+
					"WHERE iw.document = t_report05.document)";
				System.out.println("R5 SQL="+s);
				try {
					stmt.execute(s);
				} catch(Exception e) {
					e.printStackTrace(System.out);
				}
				*/
				ReportUtils.updateContractsAndSupplies(con,"t_report05");
			}
			
			s = "SELECT document, delivdate, doctype, numdoc, unitname, contract, "+
			"postavka, qty, price, (qty*price) suma, CASE policy WHEN 'S' THEN serno WHEN 'P' THEN partno WHEN 'B' THEN '' END spnum "+
			"FROM t_report05 ORDER BY delivdate desc";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);
			System.out.println("Returning data");
			data = new java.util.ArrayList();
			BigDecimal zero = new BigDecimal("0");
			String doctype;
			while (rs.next())
			{
				doctype = rs.getString("doctype");
				if("W".equals(doctype)) {
					doctype = "Внеш. прих. ордер";
				} else if("T".equals(doctype)) {
					doctype = "Внутр. прих. ордер";
				} else if("A".equals(doctype)) {
					doctype = "Акт монтажа";
				} else if("I".equals(doctype)) {
					doctype = "Акт инвентаризации (излишки)";
				}
				data.add(new Object[] {
					new Integer(0), baseCurrency,
					storageplacename,
					resourcename,
					rs.getString("unitname"), rs.getTimestamp("delivdate"),
					doctype,
					rs.getString("numdoc"), rs.getString("contract"), rs.getString("postavka"),
					rs.getBigDecimal("qty"), rs.getBigDecimal("price"), rs.getBigDecimal("suma"), rs.getString("spnum")
		        });
			}
			rs.close();
	    } catch (Exception e) {
	        System.out.println("Report4: ERROR: details FAILED. Stack trace:");
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
}
