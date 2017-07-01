package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;

/**
 * Печать акта инвентаризации
 */
public class InventorySReport extends AbstractReport {
	/**
	 * ContractSupply constructor comment.
	 */
	public InventorySReport() {
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
	        columns = new String[]{"document", "blanknumber", "blankdate", "storagenum", "storagename",   
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
	        s = "DROP TABLE t_inventsh";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_inventsh ( " +
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

	        s = "DROP TABLE t_inventsd";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}
	        
	        s = "CREATE TEMP TABLE t_inventsd ( " +
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

			// Insert from doc header
			s = "INSERT INTO t_inventsh (document, blanknumber, blankdate, storagenum, storagename,  " +
				" posnum, posname, itemtype, iserno, iuser1, iuser2) " +
				// "SELECT d.document, NVL(d.blankindex || ' ' || d.blanknumber,d.blankindex), d.blankdate, s.storageplace, s.name, " +
				"SELECT d.document, TRIM(d.blanknumber), d.blankdate, s.storageplace, s.name, " +
				" 'A' || p.gsmid || ' ' || 'D' || p.dampsid, s1.name, " +
				" TRIM(r.name) || ' ' || TRIM(r.model) || ' ' || NVL(c.configuration,'')," +
				" serial_for_sc(c.storagecard), " +
				" TRIM(p1.lastname) || ' ' || NVL(SUBSTR(TRIM(p1.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p1.middlename),1,1)||'.',''), "+
				" TRIM(p2.lastname) || ' ' || NVL(SUBSTR(TRIM(p2.firstname),1,1)||'.','') || ' ' || NVL(SUBSTR(TRIM(p2.middlename),1,1)||'.','') "+
				"FROM documents d, i13nact i, storageplaces s, outer (storagecards c, resources r), " +
				" outer (positions p, equipment e, storageplaces s1), " +
				" outer(workers w1, people p1), outer(workers w2, people p2) "+
				"WHERE i.document = d.document AND s.storageplace = d.to AND " +
				" c.storagecard = i.agregate AND r.resource = c.resource AND " +
				" e.equipment = s.storageplace AND p.storageplace = e.position AND " +
				" s1.storageplace = p.storageplace AND " +
				" w1.worker = d.storagemanager AND p1.man = w1.man AND "+
				" w2.worker = i.techstuff AND p2.man = w2.man AND "+
				" d.document = " + docId;
			System.out.println("SQL=" + s);
			stmt.execute(s);
			
			// Find bsname
			s = "SELECT sp.type, CASE sp.type WHEN 'B' THEN b.name WHEN 'C' THEN l.type WHEN 'O' THEN c.name " +
				"WHEN 'W' THEN '' || s.number WHEN 'T' THEN o.type END bsname " +
				"FROM documents d, storageplaces sp, equipment e, outer basestations b, outer comequipment l, " +
				" outer controllers c, outer switches s, outer otherequipment o " +
				"WHERE sp.storageplace = d.to AND e.equipment = sp.storageplace AND " +
				"b.equipment = e.equipment AND l.equipment = e.equipment AND " +
				"c.equipment = e.equipment AND s.equipment = e.equipment AND " +
				"o.equipment = e.equipment AND " +
				"d.document = " + docId;
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);
			if (rs.next()) {
				s = "SELECT * FROM t_inventsh ";
				System.out.println("SQL=" + s);
				rsUpd = stmtUpd.executeQuery(s);
				if (rsUpd.next()) {
					rsUpd.updateString("bsname", rs.getString("bsname"));
					if ("C".equals(rs.getString("type"))) {
						if ("R".equals(rs.getString("bsname")))
							rsUpd.updateString("bsname", "Радиорелейное оборудование");
						if ("O".equals(rs.getString("bsname")))
							rsUpd.updateString("bsname", "Волоконно-оптическое оборудование");
						if ("O".equals(rs.getString("bsname")))
							rsUpd.updateString("bsname", "Прочее");
					}
					if ("W".equals(rs.getString("type"))) {
						rsUpd.updateString("bsname", "Коммутатор " + rs.getString("bsname"));
					}
					if ("T".equals(rs.getString("type"))) {
						if ("A".equals(rs.getString("bsname")))
							rsUpd.updateString("bsname", "Сооружения (контейнеры, мачты, опоры)");
						if ("B".equals(rs.getString("bsname")))
							rsUpd.updateString("bsname", "Оборудование техническое (электропитания, охлаждение, сигнализация, пожаротушение, огни ВОЗ)");
						if ("C".equals(rs.getString("bsname")))
							rsUpd.updateString("bsname", "Хозяйственное оборудование");
						if ("D".equals(rs.getString("bsname")))
							rsUpd.updateString("bsname", "Прочее оборудование");
					}
					rsUpd.updateRow();
				}
				rsUpd.close();
			}
			rs.close();

			// Insert from docpositions
			s = "INSERT INTO t_inventsd (docposition, document, iorder, name, countpolicy,  " +
				" qty, price, summa, serno, describe) " +
				"SELECT dp.docposition, dp.document, dp.order, TRIM(r.name) || ' ' || TRIM(r.model) || ' ' || NVL(dp.configuration,''), " +
				" r.countpolicy, dp.qty, dp.price, dp.qty * dp.price, " +
				" serial_for_docpos(dp.docposition), " +
				" ip.note " +
				"FROM docpositions dp, resources r, i13actpos ip " +
				"WHERE r.resource = dp.resource AND ip.docposition = dp.docposition AND " +
				" dp.document = " + docId;
			System.out.println("SQL=" + s);
			stmt.execute(s);

			
			// Select result
			s = "SELECT *  " +
			" FROM t_inventsh h, t_inventsd d " +
			" WHERE d.document = h.document " +
			" ORDER BY d.iorder ASC ";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);

	        
			System.out.println("Returning data");
			data = new java.util.ArrayList();
			while (rs.next()) {
		        data.add(new Object[]{new Integer(rs.getInt("document")), rs.getString("blanknumber"),
				        rs.getDate("blankdate"), rs.getString("storagenum"), rs.getString("storagename"),
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
		        System.out.println("IU1:"+rs.getString("iuser1")+", IU2:"+rs.getString("iuser2"));
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
