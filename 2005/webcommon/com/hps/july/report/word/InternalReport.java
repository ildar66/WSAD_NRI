package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;

/**
 * Печать внутреннего приходного ордера
 */
public class InternalReport extends AbstractReport {

	/**
	 * ContractSupply constructor comment.
	 */
	public InternalReport() {
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
	        columns = new String[]{"document", "blanknumber", "blankdate", "storagename", "soprdoc", 
		        "currname", "platinumnum", "supplname",  "outuser", "inuser", // header fields
		        "iorder", "name", "unitname", "docqty", "factqty", "cprice", "sum", "serno"}; // need to be the same column name(s) as in the report


	        String s;
	        ResultSet rs;
	        Statement stmt = con.createStatement();
			Statement stmtUpd = con.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			ResultSet rsUpd;

	        // Create temp tables
	        s = "DROP TABLE t_internh";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_internh ( " +
	            " recid SERIAL, " +
	            " document INTEGER, " +
	        	" blanknumber CHAR(20), " +
			    " blankdate    DATE, " +
			    " storagename  CHAR(80), " +
			    " soprdoc      CHAR(200), " +
			    " currname     CHAR(10), " +
			    " platinumnum  CHAR(20), " +
			    " supplname    CHAR(80), " +
			    " fullname     CHAR(80), " +
			    " outuser      CHAR(80), " +
			    " inuser       CHAR(80), " +
			    " PRIMARY KEY(recid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

	        s = "DROP TABLE t_internd";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_internd ( " +
	        	" posid SERIAL, " +
	        	" docposition INTEGER NOT NULL, " +
	            " document INTEGER, " +
			    " iorder       INTEGER, " +
			    " name         CHAR(120), " +
			    " unitname     CHAR(20), " +
			    " docqty       DEC(15,3), " +
			    " factqty      DEC(15,3), " +
			    " price        DEC(15,2), " +
			    " sum          DEC(15,2), " +
			    " serno        CHAR(200), " +
			    " countpolicy  CHAR(1), " +
			    " PRIMARY KEY (posid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Insert from doc header
			s = "INSERT INTO t_internh (document, blanknumber, blankdate, storagename,  " +
				" currname, platinumnum, supplname, fullname, outuser, inuser) " +
			    // "SELECT d.document, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), d.blankdate, s.name,  " +
				"SELECT d.document, TRIM(d.blanknumber), d.blankdate, s.name,  " +
				" c.shortname, '', TRIM(o.name) || NVL(' / ' || NVL('A'||pp.dampsid||' ','') || NVL('D'||pp.gsmid||' ','') || TRIM(s1.name),''), "+
				" d.insuranceman, TRIM(p.lastname) || ' ' || NVL(SUBSTR(TRIM(p.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p.middlename),1,1)||'.',''), "+
//				" p.lastname || ' ' || p.firstname || ' ' || p.middlename, " +
				" TRIM(p1.lastname) || ' ' || NVL(SUBSTR(TRIM(p1.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p1.middlename),1,1)||'.','') "+
//				"p1.lastname || ' ' || p1.firstname || ' ' || p1.middlename " +
				"FROM documents d, internalwaybills iw, currencies c, storageplaces s, expedition e, outer organizations o, " +
				" outer (workers w, people p), namedvalues n, outer (workers w1, people p1), " +
				" outer (storageplaces s1,positions pp) "+
				"WHERE c.currency = n.intvalue AND s.storageplace = d.to AND " +
				" e.expedition = d.from AND o.organization = e.organization AND " +
				" e.expeditor = w.worker AND p.man = w.man AND n.id = 'BASE_CURRENCY' AND " +
				" d.storagemanager = w1.worker AND p1.man = w1.man AND " +
				" pp.storageplace = s1.storageplace AND s1.storageplace = iw.position AND "+
				" iw.document = d.document AND "+
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
			s = "INSERT INTO t_internd (docposition, document, iorder, name, countpolicy, unitname, " +
				" docqty, factqty, price, sum, serno) "+
				"SELECT dp.docposition, dp.document, dp.order, TRIM(r.name) || ' ' || TRIM(r.model) || ' ' || NVL(dp.configuration,''), " +
				" r.countpolicy, u.shortname, ip.docqty, dp.qty, dp.price, dp.qty*dp.price, " +
				" serial_for_docpos(dp.docposition) "+
				"FROM docpositions dp, resources r, outer units u, inlwbillspos ip " +
				"WHERE r.resource = dp.resource AND u.unit = r.unit AND " +
				"ip.docposition = dp.docposition AND "+
				" dp.document = " + docId;
			System.out.println("SQL=" + s);
			stmt.execute(s);

			
			// Select result
			s = "SELECT *  " +
			" FROM t_internh h, t_internd d " +
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
				        rs.getDate("blankdate"), rs.getString("storagename"), rs.getString("soprdoc"),
				        rs.getString("currname"), rs.getString("platinumnum"), supplname,
				        rs.getString("outuser"), rs.getString("inuser"),
				        new Integer(rs.getInt("iorder")), rs.getString("name"), rs.getString("unitname"),
				        rs.getBigDecimal("docqty"), rs.getBigDecimal("factqty"), 
				        rs.getBigDecimal("price"),  rs.getBigDecimal("sum"), 
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
