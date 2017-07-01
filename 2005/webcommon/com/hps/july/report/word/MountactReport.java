package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;

/**
 * Печать актов монтажа
 */
public class MountactReport
	extends AbstractReport
{
public void getReportData( Engine engine, String configs ) {
    System.out.println("In getReportData");
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
    int docId = 0;
    // Determine arguments
    try {
    	docId = ((java.lang.Long)engine.getPrompt(0)).intValue();
    	System.out.println("REPORT for docId=" + docId);
    } catch (Exception e) {
	    e.printStackTrace(System.out);
    }
    try {
	    con = getConnection();
        columns = new String[]{"document", "blanknumber", "blankdate", 
	        "bsnum", "bsname", "platnum", "supplname",  "storagename",
	        "iuser1", "iuser2", "ouser", // header fields
	        "iorder", "name", "qty", "price", "suma", "serno"}; // need to be the same column name(s) as in the report


        String s;
        ResultSet rs;
        Statement stmt = con.createStatement();
		Statement stmtUpd = con.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
		ResultSet rsUpd;

        // Create temp tables
        s = "DROP TABLE t_mounth";
		try {
			System.out.println("SQL=" + s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}
        
        s = "CREATE TEMP TABLE t_mounth ( " +
            " recid SERIAL, " +
            " document INTEGER, " +
        	" blanknumber CHAR(20), " +
		    " blankdate    DATE, " +
		    " bsnum        CHAR(20), " +
		    " bsname       CHAR(80), " +
		    " platnum      CHAR(20), " +
		    " supplname    CHAR(80), " +
		    " fullname     CHAR(80), " +
		    " storagename  CHAR(80), " +
		    " iuser1       CHAR(80), " +
		    " iuser2       CHAR(80), " +
		    " ouser        CHAR(80), " +
		    " storagecode INTEGER," +
		    " PRIMARY KEY(recid) " +
        	" )";
		System.out.println("SQL=" + s);
		stmt.execute(s);

        s = "DROP TABLE t_mountd";
		try {
			System.out.println("SQL=" + s);
			stmt.execute(s);
		} catch (Exception e) {
			// Nothing to do - suppress
		}
        
        s = "CREATE TEMP TABLE t_mountd ( " +
        	" posid SERIAL, " +
        	" docposition INTEGER NOT NULL, " +
            " document INTEGER, " +
		    " iorder       INTEGER, " +
		    " name         CHAR(80), " +
		    " qty          DEC(15,3), " +
		    " price        DEC(15,2), " +
		    " suma         DEC(15,2), " +
		    // " serno        CHAR(20), " +
			" serno        CHAR(80), " +
		    " countpolicy  CHAR(1), " +
		    " PRIMARY KEY (posid) " +
        	" )";
		System.out.println("SQL=" + s);
		stmt.execute(s);

		// Insert from doc header
		s = "INSERT INTO t_mounth (document, blanknumber, blankdate, bsnum, bsname, " +
			" supplname, iuser1, iuser2, ouser, storagecode) " +
			// "SELECT d.document, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), d.blankdate, NVL('D' || p.gsmid,'') || NVL(' A' || p.dampsid,''), sp.name, "+
			"SELECT d.document, TRIM(d.blanknumber), d.blankdate, NVL('D' || p.gsmid,'') || NVL(' A' || p.dampsid,''), sp.name, "+
			"o.name, "+
			"NVL(TRIM(p1.lastname) || ' ' || NVL(SUBSTR(TRIM(p1.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p1.middlename),1,1)||'.',''), d.insuranceman), "+
			"TRIM(p2.lastname) || ' ' || NVL(SUBSTR(TRIM(p2.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p2.middlename),1,1)||'.',''), "+
			"TRIM(p3.lastname) || ' ' || NVL(SUBSTR(TRIM(p3.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p3.middlename),1,1)||'.',''), "+
			"d.to "+
			"FROM documents d, internalwaybills i, equipment e, storageplaces se, positions p, storageplaces sp, "+
			"expedition x, outer organizations o, outer(workers w1, people p1), "+
			"outer (workers w2, people p2), outer(workers w3, people p3) "+
			"WHERE d.to = e.equipment AND e.equipment = se.storageplace AND e.position = p.storageplace AND p.storageplace = sp.storageplace AND "+
			"d.from = x.expedition AND o.organization = x.organization AND "+
			"x.expeditor = w1.worker AND w1.man = p1.man AND "+
			"i.monter = w2.worker AND w2.man = p2.man AND "+
			"d.storagemanager = w3.worker AND w3.man = p3.man AND "+
			"d.document = i.document AND "+
			"d.document = " + docId;
		System.out.println("SQL=" + s);
		stmt.execute(s);

		// Insert from docpositions
		s = "INSERT INTO t_mountd (docposition, document, iorder, name, countpolicy, qty, " +
			" price, suma, serno) " +
			"SELECT dp.docposition, dp.document, dp.order, " +
			" TRIM(r.name) || ' ' || NVL(TRIM(r.model), '') || ' ' || NVL(TRIM(dp.configuration), ''), " +
			" r.countpolicy, dp.qty, dp.price, dp.qty*dp.price, " +
			" serial_for_docpos(dp.docposition) " +
			"FROM docpositions dp, resources r " +
			"WHERE r.resource = dp.resource AND  " +
			" dp.document = " + docId;
		System.out.println("SQL=" + s);
		stmt.execute(s);

		
		// Select result
		s = "SELECT *  " +
		" FROM t_mounth h, t_mountd d " +
		" WHERE d.document = h.document " +
		" ORDER BY d.iorder ASC ";
		System.out.println("SQL=" + s);
		rs = stmt.executeQuery(s);

        
		System.out.println("Returning data");
		data = new java.util.ArrayList();
		while (rs.next()) {
	        {
        		String supplname = rs.getString("supplname");
        		if (supplname == null)
        			supplname = rs.getString("fullname");
        		
		        data.add(new Object[]{new Integer(rs.getInt("document")), rs.getString("blanknumber"),
			        rs.getDate("blankdate"), rs.getString("bsnum"), rs.getString("bsname"), 
			        rs.getString("platnum"), supplname, rs.getString("storagename"), 
			        rs.getString("iuser1"), rs.getString("iuser2"), rs.getString("ouser"),
			        new Integer(rs.getInt("iorder")), rs.getString("name"), 
			        rs.getBigDecimal("qty"), rs.getBigDecimal("price"), rs.getBigDecimal("suma"),  
			        rs.getString("serno")
			        });
	        };
		}
		rs.close();
    } catch (Exception e) {
        System.out.println("ERROR: details FAILED. Stack trace:");
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
			System.out.println("Returning row #" + i);
			Object [] row = (Object [])it.next();
			objData [i] = row;
			i++;
		}
		engine.setData( columns, objData );
	} catch (java.lang.Throwable ex) {
        System.out.println("ERROR: setData FAILED. Stack trace:");
        ex.printStackTrace(System.out);
	}
}
}
