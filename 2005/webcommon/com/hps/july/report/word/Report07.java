package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import java.math.*;
import java.util.*;

/**
 * Печать отчёта "Расход оборудования с объекта"
 */
public class Report07 extends AbstractReport {
	private int docId;
	private int objectType;
	private String objectCode;
	private int storageplace;
	private String storageplacename;
//	private String stype;
	private Boolean stateDate;
	private java.sql.Date date;
	private java.sql.Timestamp stDate;
	private java.sql.Timestamp endDate;

	private int resource;
	private int posnum;

	private Boolean docAll;
	private Boolean docInwaybill;
	private Boolean docDeassact;
	private Boolean docDeassactb;
	private Boolean docPayoff;
	private Boolean docInv;

	private Boolean showContract;
	private static Calendar cal = Calendar.getInstance();

	private String[] documentTypes = {
		"Внешняя расходная накладная", // O
		"Внутренняя расходная накладная", // I
		"Акт списания", // P
		"Акт демонтажа блоков", // B
		"Акт демонтажа", // D
		"Акт инвентаризации (недостача)" // N
	};
	private String[] docTypes = { "'O'", "'I'", "'P'", "'B'", "'D'", "'N'" };
public Report07() {
	super();
}
public void execDetailsSQL(Statement stmt, int type)
	throws SQLException
{
	if(type >= documentTypes.length)
		return;
	String result =
		"INSERT INTO t_report07 (document, delivdate, doctype, numdoc, unitname, contract, postavka, "+
		"qty, price, serno, partno, policy) "+
		"SELECT d.document doc, d.blankdate ddate, "+
		docTypes[type]+", NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex) dnumber, u.shortname unitname, "+
		"'', '', dp.qty qty, dp.price price, serial_for_docpos(dp.docposition), dp.party, r.countpolicy "+
		"FROM docpositions dp, resources r, documents d, units u, storageplaces spto, storageplaces spfrom "+
		"WHERE dp.resource = r.resource AND d.document = dp.document  AND r.unit = u.unit "+
		"AND d.to = spto.storageplace AND d.from = spfrom.storageplace "+
		"AND r.resource = "+resource+" "+
		"AND dp.document in ( "+
		getDocumentsCollectionSQL(type)+
		")";
	System.out.println("SQL["+type+"]=" + result);
	stmt.execute(result);
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
		return (java.sql.Date)o;
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
		return (java.sql.Timestamp)o;
	} catch(ReportException re) {
		re.printStackTrace(System.out);
		return null;
	} catch(ClassCastException cce) {
    	System.out.println("Actual class of PROMPT["+i+"]:"+o.getClass().getName());
    	return null;
	}
}
public String getDocumentsCollectionSQL(int type) {
	String select = "SELECT d.document";
	String from = " FROM documents d, storageplaces spt, storageplaces spf";
	String where = " WHERE d.state = '2' AND d.to = spt.storageplace AND d.from = spf.storageplace";
	
	switch(objectType) {
	case 1: // storage
	case 3: // equipment
		where += " AND d.from = "+storageplace;
		break;
	case 2: // position
		from += ", equipment e";
		where += " AND d.from = e.equipment AND e.position = "+storageplace;
		break;
	default:
	}
	where += " AND d.blankdate >= "+getSQLDate(stDate)+" AND d.blankdate <= "+getSQLDate(endDate)+" ";

	switch(type) {
	case 0: // Внешний расход
		where += " AND d.type = 'O'";
		break;
	case 1: // Внутренний расход
		where += " AND d.type = 'N' AND spf.type = 'S'";
		break;
	case 2: // Акт списания
		where += " AND d.type = 'P' AND spf.type = 'S'";
		break;
	case 3: // Акт демонтажа блоков
		from += ", asemblingacts aa";
		where += " AND d.type = 'A' AND aa.operationtype = 'D'";
		break;
	case 4: // Акт демонтажа
		where += " AND d.type = 'N' AND spf.type <> 'S'";
		break;	
	case 5: // Акт инвентаризации (недостача)
		where += " AND d.type = 'P' AND spf.type <> 'S'";
		break;
	}

	return select+" "+from+" "+where;
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
	    System.out.println("In Report07.getReportData");
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
		Object o = new Object();
	    try {
			docId = getInt(engine,0);
			objectType = getInt(engine,1);
			o = engine.getPrompt(2);
			objectCode = getString(engine,2);
			try {
				storageplace = Integer.parseInt(objectCode);
			} catch(Exception e) {
				e.printStackTrace();
				storageplace = 0;
			}
			stDate = new Timestamp(getDate(engine,3).getTime());
			endDate = new Timestamp(getDate(engine,4).getTime());
			try {
				resource = Integer.parseInt(getString(engine,5));
			} catch(Exception e) {
				resource = 0;
			}
			docAll = getBoolean(engine,6);
			docInwaybill = getBoolean(engine,7);
			docDeassact = getBoolean(engine,8);
			docDeassactb = getBoolean(engine,9);
			docPayoff = getBoolean(engine,10);
			docInv = getBoolean(engine,11);
			stateDate = getBoolean(engine,12);
			date = getDate(engine,13);
			showContract = getBoolean(engine,14);
	    } catch (Exception e) {
			e.printStackTrace(System.out);
	    }
	    try {
		    con = getConnection();
		    columns = new String[] {
				"document", "posname", "curname", "itemname", "PRICE", "qtytype",
				"docdate", "doctype", "docnum", "Summa", "serno", "qty",
				"kontr", "post"
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
			
	        s = "DROP TABLE t_report07";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}

			s =
			"CREATE TEMP TABLE t_report07 ( "+
			"recid SERIAL, "+
			"document INTEGER, "+
			"delivdate DATE, "+
			"doctype CHAR(1), "+
			"numdoc CHAR(40), "+
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
			if(docAll.booleanValue()) {
				System.out.println("");
				for(int i = 0; i < documentTypes.length; i++) {
					execDetailsSQL(stmt,i);
				}
			} else {
				if(docInwaybill.booleanValue()) {
					execDetailsSQL(stmt,0);
					execDetailsSQL(stmt,1);
				}
				if(docPayoff.booleanValue()) {
					execDetailsSQL(stmt,2);
				}
				if(docDeassact.booleanValue()) {
					execDetailsSQL(stmt,3);
				}
				if(docDeassactb.booleanValue()) {
					execDetailsSQL(stmt,4);
				}
				if(docInv.booleanValue()) {
					execDetailsSQL(stmt,5);
				}
			}

			if(showContract != null && showContract.booleanValue()) {
				ReportUtils.updateContractsAndSupplies(con,"t_report07");
			}
			
			s = "SELECT document, delivdate, doctype, numdoc, unitname, contract, "+
			"postavka, qty, price, (qty*price) suma, CASE policy WHEN 'S' THEN serno WHEN 'P' THEN partno WHEN 'B' THEN '' END spnum "+
			"FROM t_report07 ORDER BY delivdate desc";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);
			System.out.println("Returning data");
			data = new java.util.ArrayList();
			BigDecimal zero = new BigDecimal("0");
			String doctype;
			String numdoc = null;
			while (rs.next())
			{
				doctype = rs.getString("doctype");
				if(doctype != null) doctype = doctype.trim();
				if("O".equals(doctype)) {
					doctype = documentTypes[0];
				} else if("I".equals(doctype)) {
					doctype = documentTypes[1];
				} else if("P".equals(doctype)) {
					doctype = documentTypes[2];
				} else if("B".equals(doctype)) {
					doctype = documentTypes[3];
				} else if("D".equals(doctype)) {
					doctype = documentTypes[4];
				} else if("N".equals(doctype)) {
					doctype = documentTypes[5];
				}
					
/*
				char dt = doctype.charAt(0);
				char tot = doctype.charAt(1);
				char fromt = doctype.charAt(2);

				switch(dt) {
					case 'O':doctype = "Внешняя расходная накладная";
						break;
					case 'P':doctype = "Акт списания";
						break;
					case 'A':doctype = "Акт демонтажа блоков";
						break;
					case 'N':
						if(fromt == 'S') {
							doctype = "Внутренняя расходная накладная";
						} else {
							doctype = "Акт демонтажа";
						}
						break;
					case 'I':doctype = "Акт инвентаризации (недостача)";
						break;
					default:doctype = "?";
				}
*/				
				numdoc = rs.getString("numdoc");
				if(numdoc == null) {
					numdoc = "";
				} else {
					numdoc = numdoc.trim();
				}
			
				data.add(new Object[] {
					new Integer(0), storageplacename, baseCurrency,
					resourcename,
					rs.getBigDecimal("price"), 
					rs.getString("unitname"), rs.getTimestamp("delivdate"),
					doctype, rs.getString("numdoc"), rs.getBigDecimal("suma"),
					rs.getString("spnum"), rs.getBigDecimal("qty"),
					rs.getString("contract"), rs.getString("postavka")
		        });
			}
			rs.close();
	    } catch (Exception e) {
	        System.out.println("Report7: ERROR: details FAILED. Stack trace:");
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
public String getSQLDate(Timestamp dat) {
	if(dat == null) {
		dat = new java.sql.Timestamp((new java.util.Date()).getTime());
	}
	cal.setTime(dat);
	return "{d '"+(cal.get(Calendar.YEAR))+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+"'}";
	//return "'"+date.getDate()+"."+(date.getMonth()+1)+"."+(date.getYear()+1900)+"'";
}
}
