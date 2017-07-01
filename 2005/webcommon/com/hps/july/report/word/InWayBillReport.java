package com.hps.july.report.word;

import java.text.SimpleDateFormat;
import java.sql.*;
import javax.sql.*;

/**
 * Печать внешнего приходного ордера
 */
public class InWayBillReport extends AbstractReport {
	private static int docId;
	/**
	 * ContractSupply constructor comment.
	 */
	public InWayBillReport() {
		super();
	}
    public void getReportData( Engine engine, String configs ) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
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

	    // Determine arguments
	    try {
	    	docId = ((java.lang.Long)engine.getPrompt(0)).intValue();
	    	System.out.println("REPORT for docId=" + docId);
	    } catch (Exception e) {
		    e.printStackTrace(System.out);
	    }
	    try {
		    con = getConnection();
	        columns = new String[]{"document", "organizationname",
		        "blanknumber", "blankdate", "storagename", "cordocnum", "cordocdate", 
		        "gtdnumber", "currname", "platinumnum", "supplname", "contrname", "contrdate", 
		        "iuser", "ouser", // header fields
		        "iorder", "name", "unitname", "docqty", "factqty", "docprice", "factprice", "docsum", "factsum", "serno"}; // need to be the same column name(s) as in the report


	        String s;
	        ResultSet rs;
	        Statement stmt = con.createStatement();
			Statement stmtUpd = con.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			ResultSet rsUpd;

	        // Create temp tables
	        s = "DROP TABLE t_inwaybillh";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_inwaybillh ( " +
	            " recid SERIAL, " +
	            " document INTEGER, " +
	        	" ownername CHAR(80), "+
	        	" blanknumber CHAR(20), " +
			    " blankdate    DATE, " +
			    " storagename  CHAR(80), " +
			    " cordocnum    CHAR(20), " +
			    " cordocdate   DATE, " +
			    " gtdnumber    CHAR(20), " +
			    " currname     CHAR(10), " +
			    " platinumnum  CHAR(20), " +
			    " supplname    CHAR(80), " +
			    " contrname    CHAR(20), " +
			    " contrdate    DATE, " +
			    " iuser        CHAR(80), " +
			    " ouser        CHAR(80), " +
			    " PRIMARY KEY(recid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

	        s = "DROP TABLE t_inwaybilld";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_inwaybilld ( " +
	        	" posid SERIAL, " +
	        	" outerdocposition INTEGER NOT NULL, " +
	            " document INTEGER, " +
			    " iorder       INTEGER, " +
			    " name         CHAR(120), " +
			    " unitname     CHAR(20), " +
			    " docqty       DEC(15,3), " +
			    " factqty      DEC(15,3), " +
			    " docprice     DEC(15,2), " +
			    " factprice    DEC(15,2), " +
			    " docsum       DEC(15,2), " +
			    " factsum      DEC(15,2), " +
			    " serno        CHAR(500), " +
			    " countpolicy  CHAR(1), " +
			    " PRIMARY KEY (posid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Insert from doc header
			s = "INSERT INTO t_inwaybillh (ownername, document, blanknumber, blankdate, storagename, cordocnum, cordocdate, " +
				" gtdnumber, currname, platinumnum, supplname, iuser, ouser) " +
				// "SELECT ow.name, d.document, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), d.blankdate, s.name, i.cordocnum, i.cordocdate, "+
				"SELECT ow.name, d.document, TRIM(d.blanknumber), d.blankdate, s.name, i.cordocnum, i.cordocdate, "+
				" i.gtdnumber, c.shortname, '',  o.name, "+
				"(SELECT TRIM(w1p.lastname) || ' ' || NVL(SUBSTR(TRIM(w1p.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(w1p.middlename),1,1)||'.','') FROM expedition w1e, workers w1w, people w1p WHERE "+
//				"(SELECT w1p.lastname FROM expedition w1e, workers w1w, people w1p WHERE "+
				"w1e.expeditor = w1w.worker AND w1p.man = w1w.man AND w1e.expedition = d.from), "+
				"(SELECT TRIM(w2p.lastname) || ' ' || NVL(SUBSTR(TRIM(w2p.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(w2p.middlename),1,1)||'.','') FROM workers w2w, people w2p WHERE "+
//				"(SELECT w2p.lastname FROM workers w2w, people w2p WHERE "+
				"w2p.man = w2w.man AND w2w.worker = d.storagemanager) "+
				"FROM documents d, inwaybills i, currencies c, outer organizations o, outer organizations ow, storageplaces s "+
				"WHERE i.document = d.document AND c.currency = i.currency AND s.storageplace = d.to AND "+
				" o.organization = d.contragent AND "+
				" ow.organization = d.owner AND "+
				"d.document = "+docId;
/*
				"SELECT d.document, d.blanknumber, d.blankdate, s.name, i.cordocnum, i.cordocdate, " +
				" i.gtdnumber, c.shortname, '', " +
				" TRIM(p.lastname)  " + // || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)
				"FROM documents d, inwaybills i, currencies c, organizations o, storageplaces s, " +
				" outer (workers w, people p) " +
				"WHERE i.document = d.document AND c.currency = i.currency AND s.storageplace = d.to AND " +
				" o.organization = d.contragent AND w.worker=d.storagemanager AND p.man = w.man AND " +
				" d.document = " + docId;
*/
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Find contract info
			s = "SELECT TRIM(c.name) || ' ' || TRIM(d.blanknumber) blanknumber, d.blankdate " +
				"FROM docdependencies dp, documents d, contracts c " +
				"WHERE d.document = dp.documentfrom AND dp.type='I' AND " +
				"c.document = d.document AND " +
				"dp.documentto = " + docId;
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

			// Insert from docpositions
			s = "INSERT INTO t_inwaybilld (outerdocposition, document, iorder, name, countpolicy, unitname, " +
				" docqty, docprice, docsum, factqty, factprice, factsum) " +
				"SELECT dp.outerdocposition, dp.document, dp.order, TRIM(r.name) || ' ' || TRIM(r.model) || ' ' || NVL(dp.configuration,''), " +
				" r.countpolicy, u.shortname, dp.outerqty, dp.outerprice, dp.outerqty * dp.outerprice, " +
				" sum(p.qty), avg(ip.sourceprice), sum(p.qty*ip.sourceprice) " +
				"FROM outerdocpositions dp, resources r, outer units u, docpositions p, inwaybillspos ip " +
				"WHERE r.resource = dp.resource AND u.unit = r.unit AND " +
				"ip.outerdocposition = dp.outerdocposition AND p.docposition = ip.docposition AND " +
				" dp.document = " + docId + " " +
				"GROUP BY 1,2,3,4,5,6,7,8,9";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Insert serials\
			int odp;
			s = "SELECT * FROM t_inwaybilld ";
			System.out.println("SQL=" + s);
			rsUpd = stmtUpd.executeQuery(s);

			while (rsUpd.next()) {
				odp = rsUpd.getInt("outerdocposition");
				s = "SELECT serial_for_docpos(d.docposition) serialnumber, d.party, d.notes  " +
				" FROM docpositions d, inwaybillspos p " +
				" WHERE  " +
				"   p.docposition = d.docposition AND p.outerdocposition = " + odp;
				System.out.println("SQL=" + s);
				rs = stmt.executeQuery(s);
				String serials = "";
				System.out.println("CountPolicy=" + rsUpd.getString("countpolicy"));

				while (rs.next()) {
					if (serials.length() > 0)
						serials = serials + ", ";
					if ("S".equals(rsUpd.getString("countpolicy")) || "P".equals(rsUpd.getString("countpolicy"))) {
						serials = serials + rs.getString("serialnumber").trim();
					}
					System.out.println("serials=" + serials);
				}
				rs.close();
				rsUpd.updateString("serno", serials);
				rsUpd.updateRow();
			}
			rsUpd.close();
			
			// Select result
			s = "SELECT *  " +
			" FROM t_inwaybillh h, t_inwaybilld d " +
			" WHERE d.document = h.document " +
			" ORDER BY d.iorder ASC ";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);

	        
			System.out.println("Returning data");
			data = new java.util.ArrayList();
			String contrname = "";
			while (rs.next()) {
		        {
					contrname = rs.getString("contrname");
					if(contrname != null && !"".equals(contrname.trim())) {
						contrname = contrname.trim() + " от " + sdf.format(rs.getDate("contrdate"));
					}
			        data.add(new Object[]{new Integer(rs.getInt("document")), rs.getString("ownername"),
				        rs.getString("blanknumber"),
				        rs.getDate("blankdate"), rs.getString("storagename"), rs.getString("cordocnum"),
				        rs.getDate("cordocdate"), rs.getString("gtdnumber"), rs.getString("currname"),
				        rs.getString("platinumnum"), rs.getString("supplname"), contrname,
				        rs.getString("contrdate"), rs.getString("iuser"), rs.getString("ouser"),
				        new Integer(rs.getInt("iorder")), rs.getString("name"), rs.getString("unitname"),
				        rs.getBigDecimal("docqty"), rs.getBigDecimal("factqty"), 
				        rs.getBigDecimal("docprice"), rs.getBigDecimal("factprice"), 
				        rs.getBigDecimal("docsum"), rs.getBigDecimal("factsum"),
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
