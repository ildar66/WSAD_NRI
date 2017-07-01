package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import java.math.*;

/**
 * Печать отчёта "Приход на объект". Краткий отчёт
 */
public class Report04 extends AbstractReport {
	private int docId;
	private int objectType;
	private String objectCode;
	private int storageplace;
	private Boolean stateDate;
	private java.sql.Timestamp date;
	private java.sql.Timestamp stDate;
	private java.sql.Timestamp endDate;
public Report04() {
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
public String getComplectSQL() {
	String result =
	"SELECT rt.name type1, rst.name type2, r.name type3, r.model mname, "+
	"dp.configuration conf, u.shortname unitname, sum(dp.qty) qty, dp.price price "+
	"FROM docpositions dp, resources r, resourcetypes rt, resourcesubtypes rst, "+
	"outer units u "+
	"WHERE dp.resource = r.resource AND r.resourcesubtype = rst.resourcesubtype "+
	"AND rt.resourcetype = rst.resourcetype AND r.unit = u.unit "+
	"AND dp.document in ( "+
	"SELECT document FROM documents WHERE (type = 'W' or type = 'T') "+
	"AND to = ? AND blankdate >= ? and blankdate <= ? "+
	"AND state = '2' ) "+
	"GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, dp.price, u.shortname "+
	"ORDER BY type1, type2, type3, mname, conf, qty, price";

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
public String getPositionSQL() {
	String result =
	"SELECT rt.name type1, rst.name type2, r.name type3, r.model mname, "+
	"dp.configuration conf, u.shortname unitname, sum(dp.qty) qty, dp.price price "+
	"FROM docpositions dp, resources r, resourcetypes rt, resourcesubtypes rst, "+
	"outer units u "+
	"WHERE dp.resource = r.resource AND r.resourcesubtype = rst.resourcesubtype "+
	"AND rt.resourcetype = rst.resourcetype AND r.unit = u.unit "+
	"AND dp.document in ( "+
	"SELECT d.document FROM documents d, equipment e "+
	"WHERE (d.type = 'W' or d.type = 'T') "+
	"AND d.to = e.equipment AND e.position = ? AND blankdate >= ? AND blankdate <= ? "+
	"AND d.state = '2' )"+
	"GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, dp.price, u.shortname "+
	"ORDER BY type1, type2, type3, mname, conf, qty, price";

	return result;
}
    public void getReportData( Engine engine, String configs ) {
	    System.out.println("In Report01.getReportData");
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
	    int storageplace = 0;
	    String storagename = "";
	    try {
			docId = getInt(engine,0);
			objectType = getInt(engine,1);
			storageplace = ((Long)(getArray(engine,2)[0])).intValue();
			storagename = getString(engine,3);
			stateDate = getBoolean(engine,4);
			date = getDatetime(engine,5);
			stDate = getDatetime(engine,6);
			endDate = getDatetime(engine,7);
	    } catch (Exception e) {
			e.printStackTrace(System.out);
	    }
	    try {
		    con = getConnection();
		    columns = new String[] {
			    "document", "Storage", "curname",
			    "iorder", "type1", "type2", "type3", "name",
				"unitname", "delivdate",
				"qty", "price", "suma"
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

			// get storagename
			storagename = ReportUtils.getStorageName(stmt,storageplace);
			
			// Execute details sql
			switch(objectType) {
			case 1: // positions
				s = getPositionSQL();
				break;
			case 2: // storage
				s = getStorageSQL();
				break;
			case 3: // worker
				s = getComplectSQL();
				break;
			default:
				s = null;
			}

			System.out.println("SQL=" + s);
			if(s == null || "".equals(s)) {
				throw new Exception("Unknown objectType. Should be one of following: 1- storage, 2- position, 3- equipment");
			}
				
			pstmt = con.prepareStatement(s);
System.out.println("PM1:"+storageplace);
			pstmt.setInt(1, storageplace);
System.out.println("PM2:"+stDate);
			pstmt.setTimestamp(2, stDate);
System.out.println("PM3:"+endDate);
			pstmt.setTimestamp(3, endDate);
			rs = pstmt.executeQuery();
				
			System.out.println("Returning data");
			data = new java.util.ArrayList();
			int iorder = 1;
			BigDecimal zero = new BigDecimal("0");
			while (rs.next())
			{
				String name = rs.getString("mname");
				String conf = rs.getString("conf");
				if(name == null) name = "-";
				name = name.trim();
				if(conf != null && !"".equals(conf.trim())) {
					name = name + "; "+conf.trim();
				}
				BigDecimal qty = rs.getBigDecimal("qty");
				BigDecimal suma = new BigDecimal("0");
				suma = qty.multiply(rs.getBigDecimal("price"));
		        data.add(new Object[] {
				    new Integer(0), storagename, baseCurrency,
				    new Integer(iorder++),
				    rs.getString("type1"), rs.getString("type2"), rs.getString("type3"),
					name, rs.getString("unitname"),
					new java.sql.Timestamp((new java.util.Date()).getTime()),
					qty, 
					rs.getBigDecimal("price"),
					suma
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
public String getStorageSQL() {
	String result =
	"SELECT rt.name type1, rst.name type2, r.name type3, r.model mname, "+
	"dp.configuration conf, u.shortname unitname, sum(dp.qty) qty, dp.price price "+
	"FROM docpositions dp, resources r, resourcetypes rt, resourcesubtypes rst, "+
	"outer units u "+
	"WHERE dp.resource = r.resource AND r.resourcesubtype = rst.resourcesubtype "+
	"AND rt.resourcetype = rst.resourcetype AND r.unit = u.unit "+
	"AND dp.document in ( "+
	"SELECT document FROM documents WHERE (type = 'W' or type = 'T') "+
	"AND to = ? AND blankdate >= ? and blankdate <= ? "+
	"AND state = '2' ) "+
	"GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, dp.price, u.shortname "+
	"ORDER BY type1, type2, type3, mname, conf, qty, price";

	return result;
	/* For contracts:
SELECT rt.name type1, rst.name type2, r.name type3, r.model mname, 
dp.configuration conf, d.blankdate ddate, d.type dtype, 
d.blanknumber dnumber, d.document, u.shortname unitname, sum(dp.qty) qty,
dp.price price
FROM docpositions dp, resources r, resourcetypes rt, resourcesubtypes rst, 
units u, documents d
WHERE dp.resource = r.resource AND r.resourcesubtype = rst.resourcesubtype 
AND d.document = dp.document
AND rt.resourcetype = rst.resourcetype AND r.unit = u.unit 
AND dp.document in ( 
SELECT document FROM documents WHERE (type = 'W' or type = 'T') 
AND to = ? AND blankdate >= ? and blankdate <= ?
AND state = '2' ) 
GROUP BY rt.name, rst.name, r.name, r.model, dp.configuration, d.blankdate, d.type, d.blanknumber, d.document, dp.price, u.shortname
ORDER BY type3, mname, conf, ddate, dtype, dnumber, qty, price
	*/
}
}
