package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;

/**
 * Печать внутренней расходной накладной
 */
public class InternalRReport extends AbstractReport {
	/**
	 * ContractSupply constructor comment.
	 */
	public InternalRReport() {
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
	        columns = new String[]{"document",
		        "organizationname",
		        "blanknumber", "blankdate", "ocustoner", "position", 
		        "icustoner", "docs", "describe", "outuser", "inuser",  // header fields
		        "iorder", "name", "qty", "serno", "price", "suma"}; // need to be the same column name(s) as in the report


	        String s;
	        ResultSet rs;
	        Statement stmt = con.createStatement();
			Statement stmtUpd = con.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			ResultSet rsUpd;

	        // Create temp tables
	        s = "DROP TABLE t_internrh";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_internrh ( " +
	            " recid SERIAL, " +
	            " document INTEGER, " +
	            " ownername CHAR(80), "+
	        	" blanknumber CHAR(20), " +
			    " blankdate    DATE, " +
			    " ocustoner    CHAR(80), " +
			    " position     CHAR(80), " +
			    " custoner     CHAR(80), " +
			    " docs         CHAR(200), " +
			    " describe     CHAR(80), " +
			    " fullname     CHAR(80), " +
			    " outuser      CHAR(80), " +
			    " inuser       CHAR(80), " +
			    " PRIMARY KEY(recid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

	        s = "DROP TABLE t_internrd";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_internrd ( " +
	        	" posid        SERIAL, " +
	        	" docposition  INTEGER NOT NULL, " +
	            " document     INTEGER, " +
			    " iorder       INTEGER, " +
			    " name         CHAR(120), " +
			    " qty          DEC(15,3), " +
			    " serno        CHAR(200), " +
			    " price        DEC(15,2), " +
			    " suma         DEC(15,2), " +
			    " countpolicy  CHAR(1), " +
			    " PRIMARY KEY (posid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Insert from doc header
			s = "INSERT INTO t_internrh (ownername, document, blanknumber, blankdate, ocustoner,  " +
				" fullname, custoner, position, inuser, outuser) " +
				// "SELECT ow.name, d.document, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), d.blankdate,   " +
				"SELECT ow.name, d.document, TRIM(d.blanknumber), d.blankdate,   " +
				" o.name, TRIM(p.lastname) || ' ' || NVL(SUBSTR(TRIM(p.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p.middlename),1,1)||'.',''), " +
				" s.name, NVL('A'||pp.dampsid||' ','') || NVL('D'||pp.gsmid||' ','') || TRIM(s1.name) pname, d.insuranceman, " +
				" TRIM(p1.lastname) || ' ' || NVL(SUBSTR(TRIM(p1.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p1.middlename),1,1)||'.','') " +
				"FROM documents d, internaloutbill i, storageplaces s, expedition e, outer organizations o, outer organizations ow, " +
				" outer (workers w, people p), outer (storageplaces s1, positions pp), outer (workers w1, people p1) " +
				"WHERE i.document = d.document AND s.storageplace = d.from AND " +
				" e.expedition = d.to AND o.organization = e.organization AND " +
				" e.expeditor = w.worker AND p.man = w.man AND s1.storageplace = i.position AND " +
				" d.storagemanager = w1.worker AND p1.man = w1.man AND " +
				" pp.storageplace = s1.storageplace AND "+
				" ow.organization = d.owner AND "+
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
			s = "INSERT INTO t_internrd (docposition, document, iorder, name,  " +
				" countpolicy, qty, serno, price, suma) " +
				"SELECT dp.docposition, dp.document, dp.order, TRIM(r.name) || ' ' || TRIM(r.model) || ' ' || NVL(dp.configuration,''), " +
				" r.countpolicy, dp.qty,  " +
				" serial_for_docpos(dp.docposition), " +
				" dp.price, dp.qty*dp.price " +
				"FROM docpositions dp, resources r  " +
				"WHERE r.resource = dp.resource  AND " +
				" dp.document = " + docId;
			System.out.println("SQL=" + s);
			stmt.execute(s);

			
			// Select result
			s = "SELECT *  " +
			" FROM t_internrh h, t_internrd d " +
			" WHERE d.document = h.document " +
			" ORDER BY d.iorder ASC ";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);

	        
			System.out.println("Returning data");
			data = new java.util.ArrayList();
			while (rs.next()) {
		        {
	        		String supplname = rs.getString("ocustoner");
	        		String inuname = rs.getString("inuser");
	        		if (supplname == null) {
	        			supplname = rs.getString("fullname");
	        			inuname = rs.getString("fullname");
	        		}
	        		
			        data.add(new Object[]{new Integer(rs.getInt("document")),
				        rs.getString("ownername"),
				        rs.getString("blanknumber"),
				        rs.getDate("blankdate"), supplname, rs.getString("position"),
				        rs.getString("custoner"), rs.getString("docs"), rs.getString("describe"),
				        rs.getString("outuser"), inuname,
				        new Integer(rs.getInt("iorder")), rs.getString("name"), 
				        rs.getBigDecimal("qty"), rs.getString("serno"),
				        rs.getBigDecimal("price"),  rs.getBigDecimal("suma")
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
