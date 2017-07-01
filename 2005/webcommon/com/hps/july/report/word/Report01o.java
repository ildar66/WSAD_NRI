package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import java.math.*;

/**
 * Печать отчёта "Наличие оборудования"
 */
public class Report01o extends AbstractReport {
	private int docId;
	private int pos;
	private int storageplace;
	private String code;
	private Boolean incAll;
	private Boolean incBSDAMPS;
	private Boolean incBSGSM900;
	private Boolean incBSDCS1800;
	private Boolean incControllers;
	private Boolean incConLine;
	private Boolean selViews;
	private Boolean selTypes;
	private String selViewsAr;
	private String selTypesAr;
	private Boolean stateDate;
	private java.util.Date stateDateVal;
	private Boolean showIntDev;
	private Boolean showBySets;
	private Boolean includeInfContr;
public Report01o() {
	super();
}
public String getOrganizationSQL(boolean agregate) {
	String result = 
	"INSERT INTO t_contents ( type1, type2, type3, name, conf, notes, boxed, policy, serno, "+
	"partno, inc, broken, unitname, price, qty, qty_broken ) "+
	"SELECT rt.name, rst.name, r.name, r.model, s.configuration, s.notes, s.boxed, "+
	"r.countpolicy, serial_for_sc(s.storagecard), s.party, "+(agregate?"'Y'":"'N'")+", s.broken, u.shortname, "+
	"s.price, ";
	if(agregate) {
		result += "(SELECT ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard) qty";
	} else {
		result += "NVL((SELECT s.qty - ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard),s.qty) qty";
	}
	result += ", s.qty_broken FROM resources r, storagecards s, resourcesubtypes rst, resourcetypes rt, units u, storageplaces p, expedition x "+
	"WHERE  "+
	"r.resource = s.resource AND u.unit = r.unit AND r.resourcesubtype = rst.resourcesubtype  "+
	"AND rst.resourcetype = rt.resourcetype AND s.closed = 'N' "+
	"AND s.storageplace = p.storageplace "+
	"AND x.expedition = p.storageplace "+
	"AND ";

	if(agregate) {
		result += "EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard) ";
	} else {
		result += " NOT EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard AND a1.qty >= s.qty) ";
	}

	if(getResourceTypesSelection() != null) {
		result += " AND ("+getResourceTypesSelection()+") ";
	}

	result += "AND x.organization = "+storageplace;
	return result;
}
public String getPositionSQL(boolean agregate) {
	boolean d = incBSDAMPS.booleanValue();
	boolean g = incBSGSM900.booleanValue();
	boolean c = incBSDCS1800.booleanValue();
	boolean bs = d || g || c;
	String result =
	"INSERT INTO t_contents ( type1, type2, type3, name, conf, notes, document, boxed, policy, serno, "+
	"partno, inc, broken, unitname, price, qty, qty_broken ) "+
	"SELECT rt.name, rst.name, r.name, r.model, s.configuration, s.notes, s.document, s.boxed, "+
	"r.countpolicy, serial_for_sc(s.storagecard), s.party, "+((agregate)?"'Y'":"'N'")+", s.broken, u.shortname, "+
	"s.price, ";
	if(agregate) {
		result += "(SELECT ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard) qty";
	} else {
		result += "NVL((SELECT s.qty - ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard),s.qty) qty";
	}
	result += ", s.qty_broken "+
	"FROM resources r, storagecards s, resourcesubtypes rst, resourcetypes rt, outer units u, "+
	"equipment e, "+
	"storageplaces p ";
	if(bs) result += ", basestations b ";
	result +=
	"WHERE "+
	"r.resource = s.resource AND u.unit = r.unit AND r.resourcesubtype = rst.resourcesubtype "+
	"AND rst.resourcetype = rt.resourcetype AND s.closed = 'N' "+
	"AND e.equipment = p.storageplace ";

	if(getResourceTypesSelection() != null) {
		result += " AND ("+getResourceTypesSelection()+") ";
	}
	result += "AND s.storageplace = p.storageplace AND ";

	if(agregate) {
		result += "EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard) ";
	} else {
		result += " NOT EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard AND a1.qty >= s.qty) ";
	}
	result += " AND e.position = "+storageplace;
	if(!incAll.booleanValue()) {
		if(bs) {
			if(d && !g && !c) {
				result += " AND e.equipment = b.equipment AND b.type = 'D' ";
			} else if(d && g && !c) {
				result += " AND e.equipment = b.equipment AND b.type in ('D','S','G') ";
			} else if(d && !g && c) {
				result += " AND e.equipment = b.equipment AND b.type in ('D','C','G') ";
			} else if(d && g && c) {
				result += " AND e.equipment = b.equipment ";
			} else if(!d && !g && !c) {
				// -
			} else if(!d && g && !c) {
				result += " AND e.equipment = b.equipment AND b.type in ('S','G') ";
			} else if(!d && !g && c) {
				result += " AND e.equipment = b.equipment AND b.type in ('C','G') ";
			} else if(!d && g && c) {
				result += " AND e.equipment = b.equipment AND b.type in ('S','C','G') ";
			}
			if(!incControllers.booleanValue() && incConLine.booleanValue()) {
				result += " AND p.type in ('B','C')";
			} else
			if(incControllers.booleanValue() && !incConLine.booleanValue()) {
				result += " AND p.type in ('B','O')";
			} else
			if(incControllers.booleanValue() && incConLine.booleanValue()) {
				result += " AND p.type in ('B','C','O')";
			}
		} else {
			if(!incControllers.booleanValue() && incConLine.booleanValue()) {
				result += " AND p.type = 'C'";
			} else
			if(!bs && incControllers.booleanValue() && !incConLine.booleanValue()) {
				result += " AND p.type = 'O'";
			} else
			if(!bs && incControllers.booleanValue() && incConLine.booleanValue()) {
				result += " AND p.type in ('C','O')";
			}
		}
	}

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
	    // doc, pos, code, all, BSDAMPS, BSGSM900, BSDCS1800, Controller, ConLine,
	    // SelViews, SelTypes, SelViewsAr, SelTypesAr, StateDate, Date, ShowIntDev,
	    // ShowBySets, IncludeInfContr
	    // Determine arguments
	    try {
			docId = ((java.lang.Long)engine.getPrompt(0)).intValue();
			pos = ((java.lang.Long)engine.getPrompt(1)).intValue();
			storageplace = ((java.lang.Long)engine.getPrompt(2)).intValue();
			incAll = (java.lang.Boolean)engine.getPrompt(3);  // for position only
			incBSDAMPS = (java.lang.Boolean)engine.getPrompt(4); // for position only
			incBSGSM900 = (java.lang.Boolean)engine.getPrompt(5); // for position only
			incBSDCS1800 = (java.lang.Boolean)engine.getPrompt(6); // for position only
			incControllers = (java.lang.Boolean)engine.getPrompt(7); // for position only
			incConLine = (java.lang.Boolean)engine.getPrompt(8); // for position only
			selViews = (java.lang.Boolean)engine.getPrompt(9);
			selTypes = (java.lang.Boolean)engine.getPrompt(10);
			Object o = engine.getPrompt(11);
			if(o != null) {
				System.out.println("CLASS 11="+o.getClass().getName());
				Object[] a = (Object[])o;
				boolean first = true;
				int v;
				for(int i = 0; i < a.length; i++) {
					v = ((java.lang.Long)a[i]).intValue();
					try {
				System.out.println("VAL 11["+i+"]="+v);
						if(first) { selViewsAr = String.valueOf(v); first = false;}
						else { selViewsAr += "," + String.valueOf(v); }
					} catch(Exception e) {
					}
				}
			} else {
				selViewsAr = null;
			}
			o = engine.getPrompt(12);
			if(o != null) {
				System.out.println("CLASS 12="+o.getClass().getName());
				Object[] a = (Object[])o;
				boolean first = true;
				int v;
				for(int i = 0; i < a.length; i++) {
					v = ((java.lang.Long)a[i]).intValue();
					try {
				System.out.println("VAL 12["+i+"]="+v);
						if(first) { selTypesAr = String.valueOf(v); first = false;}
						else { selTypesAr += "," + String.valueOf(v); }
					} catch(Exception e) {
					}
				}
			} else {
				selTypesAr = null;
			}
			stateDate = (java.lang.Boolean)engine.getPrompt(13); // ???
			//stateDateVal = (java.util.Date)engine.getPrompt(14); // ???
			showIntDev = (java.lang.Boolean)engine.getPrompt(15); // processed by report
			showBySets = (java.lang.Boolean)engine.getPrompt(16);
			includeInfContr = (java.lang.Boolean)engine.getPrompt(17);
	    } catch (Exception e) {
			e.printStackTrace(System.out);
	    }
	    try {
		    con = getConnection();
		    columns = new String[] {
			    "document", "posname", "curname",
			    "iorder", "type1", "type2",
			    "type3", "name", "serno",
			    "inc", "break", "unitname",
			    "price", "suma",
			    "contract", "postavka", "qty"
			};

	        String s;
	        ResultSet rs;
	        Statement stmt = con.createStatement();

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

	        s = "DROP TABLE t_contents";
			try {
				System.out.println("SQL=" + s);
				stmt.execute(s);
			} catch (Exception e) {
				// Nothing to do - suppress
			}

			s =
			"CREATE TEMP TABLE t_contents ( "+
			"recid SERIAL, "+
			"curname char(40), "+
			"type1 CHAR(100), "+
			"type2 CHAR(100), "+
			"type3 CHAR(100), "+
			"name CHAR(120), "+
			"conf CHAR(100), "+
			"document INTEGER, "+
			"notes CHAR(100), "+
			"boxed CHAR(1), "+
			"policy CHAR(1), "+
			"serno CHAR(20), "+
			"partno CHAR(20), "+
			"inc CHAR(1), "+
			"broken CHAR(1), "+
			"unitname CHAR(20), "+
			"price DECIMAL(15,2), "+
			"qty DECIMAL(15,3), "+
			"qty_broken DECIMAL(15,3), "+
			"contract CHAR(40), "+
			"postavka CHAR(40), "+
			"PRIMARY KEY(recid) "+
			")";
			System.out.println("SQL=" + s);
			stmt.execute(s);

			// Execute details sql
			String posname = "";
			switch(pos) {
			case 1: // positions
				s = "SELECT s.name, p.dampsid, p.gsmid "+
				"FROM positions p, storageplaces s WHERE p.storageplace = s.storageplace AND s.storageplace = "+storageplace;
				System.out.println("SQL=" + s);
				try {
					rs = stmt.executeQuery(s);
					rs.next();
					posname = rs.getString("name").trim();
					int a = rs.getInt("dampsid");
					if(!rs.wasNull()) {
						posname += " A"+a;
					}
					int d = rs.getInt("gsmid");
					if(!rs.wasNull()) {
						posname += " D"+d;
					}
					System.out.println("POSNAME:"+posname);
				} catch(Exception e) {
					e.printStackTrace(System.out);
					posname = "";
				} finally {
					rs.close();
				}
				
				s = getPositionSQL(false);
				System.out.println("SQL=" + s);
				stmt.execute(s);
				if(showIntDev.booleanValue()) {
					s = getPositionSQL(true);
					System.out.println("SQL=" + s);
					stmt.execute(s);
				}
				break;
			case 2: // storage
				s = "SELECT name FROM storageplaces WHERE storageplace = "+storageplace;
				System.out.println("SQL=" + s);
				try {
					rs = stmt.executeQuery(s);
					rs.next();
					posname = rs.getString("name");
					System.out.println("POSNAME:"+posname);
					posname = posname.trim();
					System.out.println("POSNAME:"+posname);
				} catch(Exception e) {
					e.printStackTrace(System.out);
					posname = "";
				} finally {
					rs.close();
				}
				
				s = getStorageSQL(false);
				System.out.println("SQL=" + s);
				stmt.execute(s);
				if(showIntDev.booleanValue()) {
					s = getStorageSQL(true);
					System.out.println("SQL=" + s);
					stmt.execute(s);
				}
				break;
			case 3: // worker
				s = "SELECT p.lastname, p.firstname, p.middlename "+
					"FROM workers w, storageplaces s, expedition e, people p "+
					"WHERE s.storageplace = e.expedition AND e.expeditor = w.worker "+
					"AND w.man = p.man AND w.worker = "+storageplace;
				try {
					String temp;
					System.out.println("SQL=" + s);
					rs = stmt.executeQuery(s);
					rs.next();
					posname = rs.getString("lastname").trim();
					temp = rs.getString("firstname");
					if(temp != null && !"".equals(temp.trim())) {
						posname += " "+temp.trim();
					}
					temp = rs.getString("middlename");
					if(temp != null && !"".equals(temp.trim())) {
						posname += " "+temp.trim();
					}
					System.out.println("POSNAME:"+posname);
				} catch(Exception e) {
					e.printStackTrace(System.out);
					posname = "";
				} finally {
					rs.close();
				}
				
				s = getWorkerSQL(false);
				System.out.println("SQL=" + s);
				stmt.execute(s);
				if(showIntDev.booleanValue()) {
					s = getWorkerSQL(true);
					System.out.println("SQL=" + s);
					stmt.execute(s);
				}
				break;
			case 4: // organization
				s = "SELECT o.name FROM expedition e, storageplaces s, organizations o "+
					"WHERE e.expedition = s.storageplace AND e.organization = o.organization "+
					"AND o.organization = "+storageplace;
				System.out.println("SQL=" + s);
				try {
					rs = stmt.executeQuery(s);
					rs.next();
					posname = rs.getString("name").trim();
					System.out.println("POSNAME:"+posname);
				} catch(Exception e) {
					e.printStackTrace(System.out);
					posname = "";
				} finally {
					rs.close();
				}
				s = getOrganizationSQL(false);
				System.out.println("SQL=" + s);
				stmt.execute(s);
				if(showIntDev.booleanValue()) {
					s = getOrganizationSQL(true);
					System.out.println("SQL=" + s);
					stmt.execute(s);
				}
				break;
			}
			
			if(Boolean.TRUE.equals(includeInfContr)) {
				ReportUtils.updateContractsAndSupplies(con,"t_contents");
/*
				s = "UPDATE t_contents "+
					"SET postavka = (SELECT UNIQUE iw.cordocnum "+
					"FROM inwaybills iw "+
					"WHERE iw.document = t_contents.document)";
				System.out.println("R1 SQL="+s);
				try {
					stmt.execute(s);
				} catch(Exception e) {
					e.printStackTrace(System.out);
				}
*/
			}

			s =
			"SELECT curname, type1, type2, type3, name, conf, notes, boxed, "+
			"policy, serno, partno, inc, broken, unitname, "+
			"price, qty, qty_broken, contract, postavka "+
			"FROM t_contents ORDER BY type1, type2, type3, name";
			System.out.println("SQL=" + s);
			rs = stmt.executeQuery(s);
			
			System.out.println("Returning data");
			data = new java.util.ArrayList();
			int iorder = 1;
			BigDecimal zero = new BigDecimal("0");
			while (rs.next())
			{
//			    "document", "curname",
//			    "document",
//			    "iorder", "type1", "type2", "type3", "name",
//				"serno", "inc", "break", "unitname", "price", "suma", "contract", "postavka", "qty"
				String name = rs.getString("name");
				String conf = rs.getString("conf");
				if(name != null) {
					name = name.trim();
				}
				if(conf != null && !"".equals(conf.trim())) {
					name = name + "; "+conf.trim();
				}
//				boolean boxed = rs.getBoolean("boxed");
				String spnum = "";
//System.out.println("BoXeD:"+boxed+" ("+rs.getString("boxed")+")");
				if("Y".equals(rs.getString("boxed"))) {
					spnum = "Ящик: " + rs.getString("notes");
//System.out.println("NoTeS:"+rs.getString("notes"));
				} else {
					String policy = rs.getString("policy");
					if("S".equals(policy)) {
						spnum = rs.getString("serno");
					} else if("P".equals(policy)) {
						spnum = rs.getString("partno");
					}
				}
				if(spnum != null) {
					spnum = spnum.trim();
				}
				BigDecimal qty = rs.getBigDecimal("qty");
				BigDecimal q = qty;
				BigDecimal qtyBroken = rs.getBigDecimal("qty_broken");
				Boolean broken = new Boolean(rs.getBoolean("broken"));
				if(broken != null && broken.booleanValue() && qty != null) {
					q = qty.subtract(qtyBroken);
				}
				boolean agr = false;
				if("Y".equals(rs.getString("inc"))) {
System.out.println("%%%# Agregated:"+agr);
					agr = true;
				}
				BigDecimal suma = new BigDecimal("0");
				if(q != null && q.compareTo(zero) > 0) {
					suma = q.multiply(rs.getBigDecimal("price"));
			        data.add(new Object[] {
					    new Integer(0), posname, baseCurrency, new Integer(iorder++), 
					    rs.getString("type1"), rs.getString("type2"), rs.getString("type3"),
						name, spnum, new Boolean(agr), broken, rs.getString("unitname"), 
					    rs.getBigDecimal("price"), suma, rs.getString("contract"), rs.getString("postavka"), q
			        });
				}
				if(qtyBroken != null && qtyBroken.compareTo(zero) > 0) {
					suma = qtyBroken.multiply(rs.getBigDecimal("price"));
			        data.add(new Object[] {
					    new Integer(0), posname, baseCurrency, new Integer(iorder++), 
					    rs.getString("type1"), rs.getString("type2"), rs.getString("type3"),
						name, spnum, new Boolean(agr), broken, rs.getString("unitname"), 
					    rs.getBigDecimal("price"), suma, rs.getString("contract"), rs.getString("postavka"), qtyBroken
			        });
				}
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
public String getResourceTypesSelection() {
	String r1 = null;
	String r2 = null;
	if(selViews != null && selViews.booleanValue() && selViewsAr != null && !"".equals(selViewsAr)) {
		r1 = "rt.resourcetype in ("+selViewsAr+")";
	}
	if(selTypes != null && selTypes.booleanValue() && selTypesAr != null && !"".equals(selTypesAr)) {
		r2 = "rst.resourcesubtype in ("+selTypesAr+")";
	}
	String r = null;
	if(r1 != null) {
		if(r2 != null) {
			r = r1 + " OR " + r2;
		} else {
			r = r1;
		}
	} else {
		r = r2;
	}
	return r;
}
public String getStorageSQL(boolean agregate) {
	String result =
	"INSERT INTO t_contents ( type1, type2, type3, name, conf, document, notes, boxed, policy, serno, "+
	"partno, inc, broken, unitname, price, qty, qty_broken ) "+
	"SELECT rt.name, rst.name, r.name, r.model, s.configuration, s.document, s.notes, s.boxed,"+
	"r.countpolicy, serial_for_sc(s.storagecard), s.party, "+(agregate?"'Y'":"'N'")+", s.broken, u.shortname, "+
	"s.price, ";
	if(agregate) {
		result += "(SELECT ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard) qty";
	} else {
		result += "NVL((SELECT s.qty - ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard),s.qty) qty";
	}
	result += ", s.qty_broken "+
	"FROM "+
	"resources r, storagecards s, resourcesubtypes rst, resourcetypes rt, outer units u "+
	"WHERE "+
	"r.resource = s.resource AND u.unit = r.unit AND r.resourcesubtype = rst.resourcesubtype AND ";
	if(agregate) {
		result += "EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard) ";
	} else {
		result += " NOT EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard AND a1.qty >= s.qty) ";
	}
//	+(agregate?"":"NOT ")+"EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard) ";

	if(getResourceTypesSelection() != null) {
		result += " AND ("+getResourceTypesSelection()+") ";
	}
	
	result += "AND rst.resourcetype = rt.resourcetype AND s.closed = 'N' AND s.storageplace = "+storageplace;
	
	return result;
}
public String getWorkerSQL(boolean agregate) {
	String result =
	"INSERT INTO t_contents ( type1, type2, type3, name, conf, document, notes, boxed, policy, serno, "+
	"partno, inc, broken, unitname, price, qty, qty_broken ) "+
	"SELECT rt.name, rst.name, r.name, r.model, s.configuration, s.document, s.notes, s.boxed, "+
	"r.countpolicy, serial_for_sc(s.storagecard), s.party, "+(agregate?"'Y'":"'N'")+", s.broken, u.shortname, "+
	"s.price, ";
	if(agregate) {
		result += "(SELECT ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard) qty";
	} else {
		result += "NVL((SELECT s.qty - ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard),s.qty) qty";
	}
	result += ", s.qty_broken "+
	"FROM "+
	"resources r, storagecards s, resourcesubtypes rst, resourcetypes rt, outer units u, "+
	"storageplaces p, expedition x "+
	"WHERE  "+
	"r.resource = s.resource AND u.unit = r.unit AND r.resourcesubtype = rst.resourcesubtype  ";
	
	if(getResourceTypesSelection() != null) {
		result += " AND ("+getResourceTypesSelection()+") ";
	}

	result += "AND rst.resourcetype = rt.resourcetype AND s.closed = 'N' "+
	"AND s.storageplace = p.storageplace "+
	"AND x.expedition = p.storageplace "+
	"AND ";
	if(agregate) {
		result += "EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard) ";
	} else {
		result += " NOT EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard AND a1.qty >= s.qty) ";
	}
//	(agregate?"":"NOT ")+"EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard) "+
	result += "AND x.expeditor = "+storageplace;
	
	return result;
}
}
