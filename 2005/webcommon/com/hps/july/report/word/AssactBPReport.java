package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;

/**
 * Печать актов монтажа блоков на позиции
 */
public class AssactBPReport extends AbstractReport {
	/**
	 * ContractSupply constructor comment.
	 */
	public AssactBPReport() {
		super();
	}
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
	        columns = new String[]{"document", "blanknumber", "blankdate", "storagename", 
		        "bsnum", "bsname", "inuser1", "inuser2", "pruser", // header fields
		        "iorder", "bloktype", "serno", "price", "itemtype", "iserno", "schnum", "describe"}; // need to be the same column name(s) as in the report


	        String s;
	        ResultSet rs;
	        Statement stmt = con.createStatement();
			Statement stmtUpd = con.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			ResultSet rsUpd;

	        // Create temp tables
	        s = "DROP TABLE t_assactph";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_assactph ( " +
	            " recid SERIAL, " +
	            " document INTEGER, " +
	        	" blanknumber CHAR(20), " +
			    " blankdate    DATE, " +
			    " storagecode  CHAR(20), " +
			    " storagename  CHAR(80), " +
			    " itemtype     CHAR(80), " +
			    " iserno       CHAR(20), " +
			    " schnum       CHAR(40), " +
			    " inuser1      CHAR(80), " +
			    " inuser2      CHAR(80), " +
			    " pruser       CHAR(80), " +
			    " PRIMARY KEY(recid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

	        s = "DROP TABLE t_assactpd";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_assactpd ( " +
	        	" posid SERIAL, " +
	        	" docposition INTEGER NOT NULL, " +
	            " document INTEGER, " +
			    " iorder       INTEGER, " +
			    " blocktype    CHAR(30), " +
			    " serno        CHAR(20), " +
			    " price        DEC(15,2), " +
			    " describe     CHAR(100), " +
			    " countpolicy  CHAR(1), " +
			    " PRIMARY KEY (posid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Insert from doc header
			s = "INSERT INTO t_assactph (document, blanknumber, blankdate, storagecode,   " +
				" storagename, itemtype, iserno, inuser1, inuser2) " +
				// "SELECT d.document, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), d.blankdate, 'A' || p.gsmid || ' ' || 'D' || p.dampsid, " +
				"SELECT d.document, TRIM(d.blanknumber), d.blankdate, 'A' || p.gsmid || ' ' || 'D' || p.dampsid, " +
				" NVL(s1.name, s.name),  " +
				" TRIM(r.name) || ' ' || TRIM(r.model) || ' ' || NVL(a.newconfiguration, ''),  " +
				" serial_for_sc(c.storagecard), " +
				" TRIM(p1.lastname) || ' ' || NVL(SUBSTR(TRIM(p1.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p1.middlename),1,1)||'.',''), "+
				" TRIM(p2.lastname) || ' ' || NVL(SUBSTR(TRIM(p2.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p2.middlename),1,1)||'.','') "+
//				" TRIM(p1.lastname) || ' ' || TRIM(p1.firstname) || ' ' || TRIM(p1.middlename), " +
//				" TRIM(p2.lastname) || ' ' || TRIM(p2.firstname) || ' ' || TRIM(p2.middlename) " +
				"FROM documents d, asemblingacts a, storageplaces s, " +
				" storagecards c, resources r, outer (equipment e, positions p, storageplaces s1), " +
				" outer(workers w1, people p1), outer(workers w2, people p2) " +
				"WHERE a.document = d.document AND " +
				" ( (s.storageplace = d.to AND a.operationtype='A') OR (s.storageplace = d.from AND a.operationtype='D') ) AND " +
				" c.storagecard = a.agregat AND r.resource = c.resource AND " +
				" w1.worker = a.monter AND p1.man = w1.man AND " +
				" w2.worker = d.storagemanager AND p2.man = w2.man AND " +
				" e.equipment = s.storageplace AND p.storageplace = e.position AND " +
				" s1.storageplace = p.storageplace AND " +
				" d.document = " + docId;
			System.out.println("SQL=" + s);
			stmt.execute(s);

			/*
			// Find contract info
			s = "SELECT d.blanknumber, d.blankdate " +
				"FROM docdependencies dp, documents d " +
				"WHERE d.document = dp.documentfrom AND dp.type='I' AND dp.documentto = " + docId;
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);
			if (rs.next()) {
				s = "SELECT * FROM t_inwaybillh ";
				System.out.println("SQL=" + s);
				rsUpd = stmtUpd.executeQuery(s);
				if (rsUpd.next()) {
					rsUpd.updateString("contrname", rs.getString("blanknumber"));
					rsUpd.updateDate("contrdate", rs.getDate("blankdate"));
					rsUpd.updateRow();
				}
				rsUpd.close();
			}
			rs.close();
			*/

			// Insert from docpositions
			s = "INSERT INTO t_assactpd (docposition, document, iorder, blocktype, countpolicy, serno, " +
				" price, describe) " +
				"SELECT dp.docposition, dp.document, dp.order, r.model, " +
				" r.countpolicy,  " +
				" serial_for_docpos(dp.docposition), " +
				" dp.price, dp.notes " +
				"FROM docpositions dp, resources r " +
				"WHERE r.resource = dp.resource AND  " +
				" dp.document = " + docId;
			System.out.println("SQL=" + s);
			stmt.execute(s);

			
			// Select result
			s = "SELECT *  " +
			" FROM t_assactph h, t_assactpd d " +
			" WHERE d.document = h.document " +
			" ORDER BY d.iorder ASC ";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);

	        
			System.out.println("Returning data");
			data = new java.util.ArrayList();
			while (rs.next()) {
		        {
	        
			        data.add(new Object[]{new Integer(rs.getInt("document")), rs.getString("blanknumber"),
				        rs.getDate("blankdate"), rs.getString("storagename"), 
				        rs.getString("storagecode"), rs.getString("storagename"), 
				        rs.getString("inuser1"), rs.getString("inuser2"), rs.getString("pruser"),
				        new Integer(rs.getInt("iorder")), rs.getString("blocktype"), rs.getString("serno"),
				        rs.getBigDecimal("price"),  
				        rs.getString("itemtype"), rs.getString("iserno"),
				        rs.getString("schnum"), rs.getString("describe")
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
