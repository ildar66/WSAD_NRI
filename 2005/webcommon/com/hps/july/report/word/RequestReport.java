package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;

/**
 * Печать требований
 */
public class RequestReport extends AbstractReport {
	/**
	 * ContractSupply constructor comment.
	 */
	public RequestReport() {
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
	        columns = new String[]{"document", "blanknumber", "blankdate", "orgname", "customer", 
		        "numauto", "objnum", "objname", "address", "pruser", "outuser", "inuser", // header fields
		        "name", "docqty", "factqty", "describe"}; // need to be the same column name(s) as in the report


	        String s;
	        ResultSet rs;
	        Statement stmt = con.createStatement();
			Statement stmtUpd = con.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			ResultSet rsUpd;

	        // Create temp tables
	        s = "DROP TABLE t_reqh";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_reqh ( " +
	            " recid SERIAL, " +
	            " document INTEGER, " +
	        	" blanknumber CHAR(20), " +
			    " blankdate    DATE, " +
			    " orgname      CHAR(80), " +
			    " manname      CHAR(80), " +
			    " customer     CHAR(80), " +
			    " numauto      CHAR(80), " +
			    " objnum       INTEGER, " +
			    " objname      CHAR(80), " +
			    " address      CHAR(80), " +
			    " pruser       CHAR(80), " +
			    " outuser      CHAR(80), " +
			    " inuser       CHAR(80), " +
			    " PRIMARY KEY(recid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

	        s = "DROP TABLE t_reqd";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_reqd ( " +
	        	" posid SERIAL, " +
	        	" docposition INTEGER NOT NULL, " +
	            " document INTEGER, " +
	            " resource INTEGER, " +
			    " name         CHAR(120), " +
			    " docqty       DEC(15,3), " +
			    " factqty      DEC(15,3), " +
			    " describe     CHAR(80), " +
			    " PRIMARY KEY (posid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Insert from doc header
			s = "INSERT INTO t_reqh (document, blanknumber, blankdate, orgname, manname, " +
				" customer, numauto, objnum, objname, address) " +
				// "SELECT d.document, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), d.blankdate,   " +
				"SELECT d.document, TRIM(d.blanknumber), d.blankdate,   " +
				" o.name, TRIM(p.lastname) || ' ' || NVL(SUBSTR(TRIM(p.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p.middlename),1,1)||'.',''), " +
				" d.insuranceman, q.navto, s.storageplace, s.name, s.address " +
				"FROM documents d, requests q, expedition e, outer organizations o, " +
				" outer (workers w, people p), storageplaces s " +
				"WHERE  " +
				" e.expedition = d.from AND o.organization = e.organization AND " +
				" e.expeditor = w.worker AND p.man = w.man AND  " +
				" s.storageplace = q.position AND q.document = d.document AND " +
				" d.document = " + docId;
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Insert from docpositions
			s = "INSERT INTO t_reqd (docposition, document, resource, name,  " +
				" docqty, factqty, describe) " +
				"SELECT dp.docposition, dp.document, dp.order, TRIM(r.name) || ' ' || TRIM(r.model) || ' ' || NVL(dp.configuration,''), " +
				" dp.qty, dp.qty, dp.notes " +
				"FROM docpositions dp, resources r " +
				"WHERE r.resource = dp.resource AND " +
				" dp.document = " + docId;
			System.out.println("SQL=" + s);
			stmt.execute(s);

			
			// Select result
			s = "SELECT *  " +
			" FROM t_reqh h, t_reqd d " +
			" WHERE d.document = h.document " +
			" ORDER BY d.name ASC ";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);

	        
			System.out.println("Returning data");
			data = new java.util.ArrayList();
			while (rs.next()) {
		        {
	        		String supplname = rs.getString("orgname");
	        		if (supplname == null)
	        			supplname = rs.getString("manname");
	        		
			        data.add(new Object[]{new Integer(rs.getInt("document")), rs.getString("blanknumber"),
				        rs.getDate("blankdate"), supplname, rs.getString("customer"),
				        rs.getString("numauto"), new Integer(rs.getInt("objnum")), rs.getString("objname"),
				        rs.getString("address"),
				        rs.getString("pruser"), rs.getString("outuser"), rs.getString("inuser"),
				        rs.getString("name"), 
				        rs.getBigDecimal("docqty"), rs.getBigDecimal("factqty"), 
				        rs.getString("describe")
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
