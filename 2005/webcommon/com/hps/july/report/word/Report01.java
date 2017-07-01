package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;
import java.math.*;
import java.util.*;

/**
 * Печать отчёта "Наличие оборудования"
 */
public class Report01
	extends AbstractReport
{
	private int stcode;
	private String sttype;
	private String complects;
	private String reptype;
	private boolean showinternal; // Показывать встроенное оборудование
	private boolean showcontracts; // Показывать информацию о контракте и поставке
	private boolean showseltypes; // Показывать только выбранные виды и типы
	private String selarrstr;
	private String selarrtstr; 
//	private int[] selarr;

	private static String[] columns = new String[] {
	    "document",
	    "storagetype",
	    "storagename",
	    "reportdate",
	    "reporttype",
	    "currency",

		"iorder",
		"name",
		"sn",
		"agr",
		"broken",
		"qty",
		"unit",
		"price",
		"summ",
		"type1",
		"type2",
		"contract",
		"supply"
	};
public Report01() {
	super();
}
private String addLetter(String src, String letter) {
	if(src != null && !"".equals(src)) {
		return src + "," + letter;
	} else {
		return letter;
	}
}
private void createTemporaryTables(Statement stmt)
	throws java.lang.Exception
{
	String s = "DROP TABLE report1_details";
	try {
//System.out.println("SQL=" + s);
		stmt.execute(s);
	} catch (Exception e) {
		// Nothing to do - suppress
	}

	s = "CREATE TEMP TABLE report1_details( "+
		"recid SERIAL, "+
		"document INTEGER, "+
		"iorder INTEGER, "+
		"name VARCHAR(255), "+
		"policy CHAR(1), "+
		"sn VARCHAR(255), "+
		"agr INTEGER, "+
		"broken DECIMAL(15,4), "+
		"agrqty DECIMAL(15,4), "+
		"qty DECIMAL(15,4), "+
		"unit VARCHAR(63), "+
		"price DECIMAL(15,2), "+
		"type1 VARCHAR(255), "+
		"type2 VARCHAR(255), "+
		"contract VARCHAR(255), "+
		"supply VARCHAR(255), "+
		"PRIMARY KEY(recid) "+
		")";	
//	System.out.println("SQL=" + s);
	stmt.execute(s);
}
private void fillOrganizationData(Statement stmt)
	throws Exception
{
	String s =
	"INSERT INTO report1_details(document, iorder, name, policy, sn, agr, broken, agrqty, qty, unit, price, type1, type2, contract, supply) "+
	"SELECT s.document, 0, TRIM(r.name) || NVL(' ' || TRIM(r.model),'') || NVL(' (' || TRIM(s.configuration)|| ')',''), "+
	"s.policy, serial_for_sc(s.storagecard), "+
	"(SELECT agregate FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard), "+
	"s.qty_broken, "+
	"(SELECT ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard) agrqty, "+
	"NVL((SELECT s.qty - ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard),s.qty) qty, "+
	"TRIM(u.shortname) unit, s.price, "+
	"TRIM(rt.name) type1, TRIM(rst.name) type2, CAST(NULL AS VARCHAR), CAST(NULL AS VARCHAR) "+
	"FROM resources r, storagecards s, resourcesubtypes rst, resourcetypes rt, expedition ex, outer units u "+
	"WHERE r.resource = s.resource AND u.unit = r.unit AND r.resourcesubtype = rst.resourcesubtype AND ex.expedition = s.storageplace ";
	if(!showinternal) {
		s += "AND NOT EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard AND a1.qty >= s.qty) ";
	}
	if(getResourceTypesSelection() != null) {
		s += " AND ("+getResourceTypesSelection()+") ";
	}
	s += "AND rst.resourcetype = rt.resourcetype AND s.closed = 'N' AND ex.organization = "+stcode;
	System.out.println("@REPORT1:SQL=\n"+s);
	stmt.execute(s);
}
private void fillPositionData(Statement stmt)
	throws Exception
{
	String s = 
		"INSERT INTO report1_details(document, iorder, name, policy, sn, agr, broken, agrqty, qty, unit, price, type1, type2, contract, supply) "+
		"SELECT s.document document, 0, TRIM(r.name) || NVL(' ' || TRIM(r.model),'') || NVL(' (' || TRIM(s.configuration)|| ')','') name, "+
		"s.policy, serial_for_sc(s.storagecard) sn, "+
		"(SELECT agregate FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard) agr, s.qty_broken broken, "+
		"(SELECT ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard) agrqty, "+
		"NVL((SELECT s.qty - ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard),s.qty) qty, "+
		"TRIM(u.shortname) unit, s.price price, ";
	if("T".equals(reptype)) {
		s += "TRIM(rt.name) type1, TRIM(rst.name) type2, ";
	} else {
		s += "CASE sp.type "+
			"WHEN 'P' THEN (SELECT NVL('A'||p.dampsid||' ','') || NVL('D' || p.gsmid || ' ', '') || TRIM(s.name) FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = sp.storageplace) "+
			"WHEN 'S' THEN sp.name "+
			"WHEN 'X' THEN (SELECT NVL(trim(o.name),trim(p.lastname) || ' ' || trim(p.firstname) || ' ' || trim(p.middlename)) FROM expedition e, outer organizations o, outer (workers w, people p) WHERE o.organization = e.organization AND e.expeditor = w.worker AND p.man = w.man AND e.expedition = sp.storageplace) "+
			"WHEN 'E' THEN sp.name "+
			"WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = sp.storageplace) "+
			"WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM(sp.name) FROM comequipment ce WHERE ce.equipment = sp.storageplace) "+
			"WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = sp.storageplace) "+
			"WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || TRIM(sp.name) FROM switches s WHERE s.equipment = sp.storageplace) "+
			"WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = sp.storageplace) "+
			"WHEN 'R' THEN (SELECT 'Репитер ' || TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = sp.storageplace AND rp.resource = r.resource) "+
			"WHEN 'L' THEN (SELECT 'WLAN ' || TRIM(sp.name) || NVL(' '||w.number,'') FROM wlan w  WHERE w.equipment = sp.storageplace) "+
    		"END type1, "+
			"CAST(NULL AS VARCHAR) type2, ";
	}
	s +="CAST(NULL AS VARCHAR), CAST(NULL AS VARCHAR) "+
		"FROM resources r, storagecards s, resourcesubtypes rst, resourcetypes rt, equipment eq, storageplaces sp, outer units u, outer basestations bs "+
		"WHERE r.resource = s.resource AND u.unit = r.unit AND r.resourcesubtype = rst.resourcesubtype AND s.storageplace = sp.storageplace AND sp.storageplace = eq.equipment AND bs.equipment = eq.equipment ";
	if(!showinternal) {
		s += "AND NOT EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard AND a1.qty >= s.qty) ";
	}
	if(getResourceTypesSelection() != null) {
		s += " AND ("+getResourceTypesSelection()+") ";
	}
	String sptype = "";
	String bstype = "";
	if(complects != null && !"*".equals(complects) && !"".equals(complects)) {
		if(complects.indexOf("A") >= 0 || complects.indexOf("G") >= 0 || complects.indexOf("D") >= 0) {
			sptype = addLetter(sptype,"'B'");
			// Add Damps filter
			if(complects.indexOf("A") >= 0) {
				bstype = addLetter(bstype,"'D'");
			}
			// Add Gsm filter
			if(complects.indexOf("G") >= 0) {
				bstype = addLetter(bstype,"'S'");
			}
			// Add Dcs filter
			if(complects.indexOf("D") >= 0) {
				bstype = addLetter(bstype,"'C'");
			}
			// Add Gsm/Dcs bs
			if(complects.indexOf("D") >= 0 && complects.indexOf("G") >= 0) {
				bstype = addLetter(bstype,"'G'");
			}
		}
		if(complects.indexOf("C") >= 0) {
			// Add Controllers filter
			sptype = addLetter(sptype,"'O'");
		}
		if(complects.indexOf("S") >= 0) {
			// Add Switches filter
			sptype = addLetter(sptype,"'W'");
		}
		if(complects.indexOf("R") >= 0) {
			// Add Repeaters filter
			sptype = addLetter(sptype,"'R'");
		}
		if(complects.indexOf("M") >= 0) {
			// Add Complines filter
			sptype = addLetter(sptype,"'C'");
		}
		if(complects.indexOf("O") >= 0) {
			// Add Otherequipment filter
			sptype = addLetter(sptype,"'T'");
		}
		if(complects.indexOf("W") >= 0) {
			// Add Complines filter
			sptype = addLetter(sptype,"'W'");
		}
	}
	s += "AND rst.resourcetype = rt.resourcetype AND s.closed = 'N' AND eq.equipment = s.storageplace AND eq.position = "+stcode;

	stmt.execute(s);
}
private void fillStorageData(Statement stmt)
	throws Exception
{
	String s =
	"INSERT INTO report1_details(document, iorder, name, policy, sn, agr, broken, agrqty, qty, unit, price, type1, type2, contract, supply) "+
	"SELECT s.document, 0, TRIM(r.name) || NVL(' ' || TRIM(r.model),'') || NVL(' (' || TRIM(s.configuration)|| ')',''), "+
	"s.policy, serial_for_sc(s.storagecard), "+
	"(SELECT agregate FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard), "+
	"s.qty_broken, "+
	"(SELECT ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard) agrqty, "+
	"NVL((SELECT s.qty - ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard),s.qty) qty, "+
	"TRIM(u.shortname) unit, s.price, "+
	"TRIM(rt.name) type1, TRIM(rst.name) type2, CAST(NULL AS VARCHAR), CAST(NULL AS VARCHAR) "+
	"FROM resources r, storagecards s, resourcesubtypes rst, resourcetypes rt, outer units u "+
	"WHERE r.resource = s.resource AND u.unit = r.unit AND r.resourcesubtype = rst.resourcesubtype ";
	if(!showinternal) {
		s += "AND NOT EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard AND a1.qty >= s.qty) ";
	}
	if(getResourceTypesSelection() != null) {
		s += " AND ("+getResourceTypesSelection()+") ";
	}
	s += "AND rst.resourcetype = rt.resourcetype AND s.closed = 'N' AND s.storageplace = "+stcode;
	System.out.println("@REPORT1:SQL=\n"+s);
	stmt.execute(s);
}
private void fillWorkerData(Statement stmt)
	throws Exception
{
	String s =
	"INSERT INTO report1_details(document, iorder, name, policy, sn, agr, broken, agrqty, qty, unit, price, type1, type2, contract, supply) "+
	"SELECT s.document, 0, TRIM(r.name) || NVL(' ' || TRIM(r.model),'') || NVL(' (' || TRIM(s.configuration)|| ')',''), "+
	"s.policy, serial_for_sc(s.storagecard), "+
	"(SELECT agregate FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard), "+
	"s.qty_broken, "+
	"(SELECT ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard) agrqty, "+
	"NVL((SELECT s.qty - ac.qty FROM agregatecontents ac WHERE ac.agregatepart = s.storagecard),s.qty) qty, "+
	"TRIM(u.shortname) unit, s.price, "+
	"TRIM(rt.name) type1, TRIM(rst.name) type2, CAST(NULL AS VARCHAR), CAST(NULL AS VARCHAR) "+
	"FROM resources r, storagecards s, resourcesubtypes rst, resourcetypes rt, expedition ex, outer units u "+
	"WHERE r.resource = s.resource AND u.unit = r.unit AND r.resourcesubtype = rst.resourcesubtype AND ex.expedition = s.storageplace ";
	if(!showinternal) {
		s += "AND NOT EXISTS (SELECT agregate FROM agregatecontents a1 WHERE a1.agregatepart = s.storagecard AND a1.qty >= s.qty) ";
	}
	if(getResourceTypesSelection() != null) {
		s += " AND ("+getResourceTypesSelection()+") ";
	}
	s += "AND rst.resourcetype = rt.resourcetype AND s.closed = 'N' AND ex.expeditor = "+stcode;
	System.out.println("@REPORT1:SQL=\n"+s);
	stmt.execute(s);
}
private String getArrayString(Engine engine, int promptId) {
	String result = null;
	try {
		Object o = engine.getPrompt(7);
		if(o != null) {
			System.out.println("R01:CLASS:"+o.getClass().getName());
			Object[] a = (Object[])o;
			boolean first = true;
			int v;
			for(int i = 0; i < a.length; i++) {
				v = ((java.lang.Long)a[i]).intValue();
			System.out.println("R01:VAL["+i+"]="+v);
				if(first) { result = String.valueOf(v); first = false;}
				else { result += "," + String.valueOf(v); }
			}
		}
	} catch(Exception e) {
		result = null;
	}
	return result;
}
private String getBaseCurrency(Statement stmt) {
	String baseCurrency = "";
	try {
		String s = 	"SELECT c.shortname FROM namedvalues n, currencies c "+
					"WHERE n.id = 'BASE_CURRENCY' AND c.currency = n.intvalue";
//		System.out.println("SQL=" + s);
		ResultSet rs = stmt.executeQuery(s);
		if(rs.next()) {
			baseCurrency = rs.getString("shortname");
//			System.out.println("BASE CURRENCY=" + baseCurrency);
		}
		rs.close();
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return baseCurrency;
}
public void getReportData( Engine engine, String configs ) {
	System.out.println("In Report01.getReportData");
	String title = "no title";
	ArrayList data = null;

	String r_reporttype = "";
	String r_storagetype = "_!_";
	String r_storagename = "?";
	java.sql.Date r_reportdate = new java.sql.Date(System.currentTimeMillis());
	String r_currency = "?";
	try {
	   	System.out.println("Report Title = " + engine.getReportTitle());
	   	title = engine.getReportTitle();
	} catch (ReportException e) {
		System.out.println("Cannot get report title");
	}
	Connection con = null;
	try {
		stcode = ((Long)engine.getPrompt(0)).intValue();
		sttype = (String)engine.getPrompt(1);
		complects = (String)engine.getPrompt(2);
		reptype = (String)engine.getPrompt(3);
		showinternal = ((Boolean)engine.getPrompt(4)).booleanValue();
		showcontracts = ((Boolean)engine.getPrompt(5)).booleanValue();
		showseltypes = ((Boolean)engine.getPrompt(6)).booleanValue();
		selarrstr = getArrayString(engine,7);
		selarrtstr = getArrayString(engine,8);
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	
	if("E".equals(reptype)) {
		r_reporttype = "Оборудование по комплектам";
	} else
	if("T".equals(reptype)) {
		r_reporttype = "Оборудование по видам и типам";
	}

	if("S".equals(sttype)) {
		r_storagetype = "на складе";
	} else
	if("P".equals(sttype)) {
		r_storagetype = "на позиции";
	} else
	if("E".equals(sttype)) {
		r_storagetype = "у сотрудника";
	} else
	if("O".equals(sttype)) {
		r_storagetype = "у подрядчика";
	}

	try {
		con = getConnection();
		String s;
		Statement stmt = con.createStatement();

		r_currency = getBaseCurrency(stmt);
		r_storagename = ReportUtils.getStorageName(stmt,stcode);
System.out.println("@REPORT1:StorageName:"+r_storagename);
		createTemporaryTables(stmt);

		if(sttype != null) {
			if("S".equals(sttype)) {
				fillStorageData(stmt);
			} else
			if("P".equals(sttype)) {
				fillPositionData(stmt);
			} else
			if("E".equals(sttype)) {
				fillWorkerData(stmt);
			} else
			if("O".equals(sttype)) {
				fillOrganizationData(stmt);
			}
		}
		if(showcontracts) {
			this.updateContractsAndSupplies(con,"report1_details");
		}

//	    "document", "storagetype", "storagename", "reportdate", "reporttype", "currency",
//		"iorder", "name", "sn", "agr", "broken", "qty", "unit", "price", "summ", "type1", "type2", "contract", "supply"
		
		s =	"SELECT iorder, name, sn, agr, broken, agrqty, qty, unit, price, type1, type2, contract, supply "+
			"FROM report1_details "+
			"ORDER BY type1 ASC, type2 ASC, name ASC, sn ASC";
//		System.out.println("SQL=" + s);
		ResultSet rs = stmt.executeQuery(s);

//		System.out.println("Returning data");
		data = new java.util.ArrayList();
		int iorder = 1;
		BigDecimal zero = new BigDecimal("0");
		while (rs.next())
		{
			Integer agr = null; int a = rs.getInt("agr"); if(!rs.wasNull()) { agr = new Integer(a); }
			BigDecimal qty = zero;
			if(agr != null) {
				qty = rs.getBigDecimal("agrqty");
			} else {
				qty = rs.getBigDecimal("qty");
			}
			BigDecimal summ;
			if(qty != null && rs.getBigDecimal("price") != null) {
				summ = qty.multiply(rs.getBigDecimal("price"));
				summ = summ.setScale(2,BigDecimal.ROUND_HALF_UP);
			} else {
				summ = new BigDecimal("0.00");
			}
			data.add(new Object[] {
				new Integer(0), r_storagetype, r_storagename, r_reportdate, r_reporttype, r_currency,
				new Integer(iorder++), rs.getString("name"), rs.getString("sn"), agr, 
				rs.getBigDecimal("broken"), qty, rs.getString("unit"),
				rs.getBigDecimal("price"), summ,
				rs.getString("type1"), rs.getString("type2"), rs.getString("contract"), rs.getString("supply")
			});
		}
		rs.close();
/*
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
*/		
/*
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
*/    
	} catch (Exception e) {
		System.out.println("ERROR: details FAILED. Stack trace:");
		e.printStackTrace(System.out);
	} finally {
	    try { con.close(); } catch (Exception e) { e.printStackTrace(System.out); }
	}

	try {
		Object [][] objData;
		if(data != null) {
			objData = new Object[data.size()][];
			int i = 0;
			java.util.Iterator it = data.iterator();
			while (it.hasNext()) {
				Object [] row = (Object [])it.next();
				objData [i] = row;
				i++;
			}
			System.out.println("Returning rows:" + i);
		} else {
			objData = new Object[1][];
			objData[0] = new Object[] {
				new Integer(0), r_storagetype, r_storagename, r_reportdate, r_reporttype, r_currency,
				null, null, null, null, null, null, null, null, null,
				null, null, null, null
			};
		}
		engine.setData( columns, objData );
	} catch (java.lang.Throwable ex) {
		System.out.println("ERROR: setData FAILED. Stack trace:");
		ex.printStackTrace(System.out);
	}
}
private String getResourceTypesSelection() {
	String r1 = null;
	String r2 = null;
	if(showseltypes && selarrstr != null && !"".equals(selarrstr)) {
		r1 = "rt.resourcetype in ("+selarrstr+")";
	}
	if(showseltypes && selarrtstr != null && !"".equals(selarrtstr)) {
		r2 = "rst.resourcesubtype in ("+selarrtstr+")";
	}
	String r = null;
	if(r1 != null) {
		if(r2 != null) {
			r = "(" + r1 + " OR " + r2 + ")";
		} else {
			r = r1;
		}
	} else {
		r = r2;
	}
	return r;
}
private void updateContractsAndSupplies(Connection con, String tablename) {
	try {
		Statement stmt = con.createStatement();
		Statement stmtUpd = con.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
		ResultSet rsUpd = null;
		String s;
		try {
			s = "SELECT recid, policy, contract, sn FROM "+tablename;
			rsUpd = stmtUpd.executeQuery(s);
			String contract = "";
			String supply = "";
			while(rsUpd.next()) {
				if("S".equals(rsUpd.getString("policy"))) {
					contract = ReportUtils.findContractNameBySerial(stmt,rsUpd.getString("sn"));
					supply = ReportUtils.findPostavkaBySerial(stmt,rsUpd.getString("sn"));
					if(supply != null && !"".equals(supply)) {
						contract += "/"+supply;
					}
					rsUpd.updateString("contract",contract);
					rsUpd.updateRow();
				} else if("P".equals(rsUpd.getString("policy"))) {
					contract = ReportUtils.findContractNameByParty(stmt,rsUpd.getString("sn"));
					supply = ReportUtils.findPostavkaByParty(stmt,rsUpd.getString("sn"));
					if(supply != null && !"".equals(supply)) {
						contract += "/"+supply;
					}
					rsUpd.updateString("contract",contract);
					rsUpd.updateRow();
				}
			}
		} finally {
			if(rsUpd != null) rsUpd.close();
			stmtUpd.close();
			if(stmt != null) stmt.close();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
}
