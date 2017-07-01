package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;

/**
 * Печать акта недостачи при инвентаризации
 */
public class MissReport
	extends AbstractReport
{
	/**
	 * ContractSupply constructor comment.
	 */
	public MissReport() {
		super();
	}
/**
 * Insert the method's description here.
 * Creation date: (10.10.2002 10:38:55)
 * @return java.lang.String
 */
public String getLinkType() {
	return "P";
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
	        columns = new String[]{
		        "document", "blanknumber", "blankdate", "storagenum", "storagename",   
		        "bsnum", "bsname", "posnum", "posname", "itemtype", "iserno", 
		        "iuser1", "iuser2", // header fields
		        "iorder", "name", "serno", "qty", "price", "summa", "describe"}; // need to be the same column name(s) as in the report


	        String s;
	        ResultSet rs;
	        Statement stmt = con.createStatement();
			Statement stmtUpd = con.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			ResultSet rsUpd;

	        // Create temp tables
	        s = "DROP TABLE t_missh";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_missh ( " +
	            " recid SERIAL, " +
	            " document INTEGER, " +
				// " blanknumber CHAR(20), " +
				" blanknumber CHAR(80), " +
			    " blankdate    DATE, " +
				// " storagenum   CHAR(20), " +
				" storagenum   CHAR(80), " +
			    " storagename  CHAR(80), " +
			    " bsnum        CHAR(20), " +
			    " bsname       CHAR(80), " +
			    // " posnum       CHAR(20), " +
				" posnum       CHAR(80), " +
			    " posname      CHAR(80), " +
			    " itemtype     CHAR(80), " +
			    // " iserno       CHAR(20), " +
				" iserno       CHAR(80), " +
			    " iuser1       CHAR(80), " +
			    " iuser2       CHAR(80), " +
			    " PRIMARY KEY(recid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

	        s = "DROP TABLE t_missd";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_missd ( " +
	        	" posid        SERIAL, " +
	        	" docposition  INTEGER NOT NULL, " +
	            " document     INTEGER, " +
			    " iorder       INTEGER, " +
			    " name         CHAR(120), " +
			    // " serno        CHAR(20), " +
				" serno        CHAR(80), " +
			    " qty          DEC(15,3), " +
			    " price        DEC(15,2), " +
			    " summa        DEC(15,2), " +
			    " describe     CHAR(80), " +
			    " countpolicy  CHAR(1), " +
			    " PRIMARY KEY (posid) " +
	        	" )";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			int uRes;
			// Insert from doc header
			/*  Old algorithm 
			s = "INSERT INTO t_missh (document, blanknumber, blankdate, iuser1, iuser2) " +
				"SELECT d.document, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), d.blankdate, "+
				" TRIM(p1.lastname) || ' ' || NVL(SUBSTR(TRIM(p1.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p1.middlename),1,1)||'.',''), "+
				" TRIM(p2.lastname) || ' ' || NVL(SUBSTR(TRIM(p2.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p2.middlename),1,1)||'.','') "+
				"FROM documents d, docdependencies dp, i13nact i, "+
				" outer(workers w1, people p1), outer(workers w2, people p2), documents dd "+
				"WHERE dp.documentto = d.document AND "+
				" dp.type = '" + getLinkType() + "' AND "+
				" dp.documentfrom = " + docId + " AND i.document = dd.document AND dd.document = dp.documentfrom AND "+
				" w1.worker = dd.storagemanager AND p1.man = w1.man AND "+
				" w2.worker = i.techstuff AND p2.man = w2.man ";
			*/
			// New Algorithm
			s = "INSERT INTO t_missh (document, blanknumber, blankdate, iuser1, iuser2) " +
				// "SELECT d.document, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), d.blankdate, "+
				"SELECT d.document, TRIM(d.blanknumber), d.blankdate, "+
				" TRIM(p1.lastname) || ' ' || NVL(SUBSTR(TRIM(p1.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p1.middlename),1,1)||'.',''), "+
				" TRIM(p2.lastname) || ' ' || NVL(SUBSTR(TRIM(p2.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p2.middlename),1,1)||'.','') "+
				"FROM documents d, i13nact i, "+
				" outer(workers w1, people p1), outer(workers w2, people p2), documents dd "+
				"WHERE d.parentdocument = " + docId + " AND d.type = '" + getLinkType() + "' AND "+
				" i.document = dd.document AND dd.document = d.parentdocument AND "+
				" w1.worker = dd.storagemanager AND p1.man = w1.man AND "+
				" w2.worker = i.techstuff AND p2.man = w2.man ";
			System.out.println("SQL=" + s);
			uRes = stmt.executeUpdate(s);
			System.out.println("EXECUTE = " + uRes);

			// Insert from docpositions
			s = "INSERT INTO t_missd (docposition, document, iorder, name, countpolicy,  " +
				" qty, price, summa, serno) " +
				"SELECT dp.docposition, dp.document, dp.order, TRIM(r.name) || ' ' || TRIM(r.model) || ' ' || NVL(dp.configuration,''), " +
				" r.countpolicy, dp.qty, dp.price, dp.qty * dp.price, " +
				" serial_for_docpos(dp.docposition) " +
				"FROM docpositions dp, resources r, t_missh t " +
				"WHERE r.resource = dp.resource AND " +
				" dp.document = t.document";
			System.out.println("SQL=" + s);
			uRes = stmt.executeUpdate(s);
			System.out.println("EXECUTE = " + uRes);
	
			// Select result
			s = "SELECT * " +
			" FROM t_missh h, outer t_missd d " +
			" WHERE d.document = h.document " +
			" ORDER BY d.iorder ASC ";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);

			System.out.println("Returning data");
			data = new java.util.ArrayList();
			Integer zero = new Integer(docId);
			int rn = 1;
			while (rs.next()) {
/*
				System.out.println("Row #"+(rn++));
				System.out.println(" doc="+rs.getInt("document"));
				System.out.println(" bn ="+rs.getString("blanknumber"));
				System.out.println(" bd ="+rs.getDate("blankdate"));
				System.out.println(" s  ="+rs.getString("storagenum"));
				System.out.println(" sn ="+rs.getString("storagename"));
				System.out.println(" b  ="+rs.getString("bsnum"));
				System.out.println(" bn ="+rs.getString("bsname"));
				System.out.println(" p  ="+rs.getString("posnum"));
				System.out.println(" pn ="+rs.getString("posname"));
				System.out.println(" it ="+rs.getString("itemtype"));
				System.out.println(" ser="+rs.getString("iserno"));
				System.out.println(" iu1="+rs.getString("iuser1"));
				System.out.println(" iu2="+rs.getString("iuser2"));

				System.out.println(" io ="+rs.getInt("iorder"));
				System.out.println(" n  ="+rs.getString("name"));
				System.out.println(" sno="+rs.getString("serno"));
				System.out.println(" q  ="+rs.getBigDecimal("qty"));
				System.out.println(" pr ="+rs.getBigDecimal("price"));
				System.out.println(" sum="+rs.getBigDecimal("summa"));
				System.out.println(" des="+rs.getString("describe"));
*/				
		        data.add(new Object[]{
					zero, rs.getString("blanknumber"),
			        rs.getDate("blankdate"), rs.getString("storagenum"),
			        rs.getString("storagename"),
			        rs.getString("bsnum"), rs.getString("bsname"),
			        rs.getString("posnum"), rs.getString("posname"), 
			        rs.getString("itemtype"), rs.getString("iserno"), 
			        rs.getString("iuser1"), rs.getString("iuser2"), 
			        new Integer(rs.getInt("iorder")), rs.getString("name"), rs.getString("serno"),
			        rs.getBigDecimal("qty"), 
			        rs.getBigDecimal("price"), 
			        rs.getBigDecimal("summa"), 
			        rs.getString("describe")
		        });
			}
			System.out.println("Close RS");
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
