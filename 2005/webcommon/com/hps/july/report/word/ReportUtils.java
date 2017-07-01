package com.hps.july.report.word;

import java.sql.*;
import java.util.Calendar;

/**
 * Служебный класс, содержит методы для нахождения контрактов и поставок
 * а так же методы для определния наименований хранилищ.
 */
public class ReportUtils {
	private static Calendar cal = Calendar.getInstance();
public static String findContractNameByParty(Statement stmt, String party) {
	String result = "";
	if(party == null) {
		return result;
	}
	party = party.trim();
	try {
		String s;
		ResultSet rs = null;
		try {
			s = "SELECT FIRST 1 d.type type, d.document document, d.blankdate FROM documents d WHERE d.type IN ('S','W') AND EXISTS "+
				"(SELECT dd.docposition FROM docpositions dd WHERE dd.document = d.document "+
				"AND dd.storagecardto IN "+
				"(SELECT storagecard FROM storagecards WHERE party ='"+party+"')) "+
				"ORDER BY blankdate";
//			System.out.println("RUP SQL="+s);
			rs = stmt.executeQuery(s);
			if( !rs.next() ) {
				throw new IllegalArgumentException();
			}
			char docType = rs.getString("type").charAt(0);
			int doc = rs.getInt( "document" );
			rs.close(); rs = null;
			
			switch( docType ) {
			case 'S': //surplusact - get contruct from i13n act
				s = "SELECT (TRIM(c.name) || ' ' || TRIM(d.blanknumber)) name "+
					"FROM i13actpos i, contracts c, documents d "+
					"WHERE i.contract = c.document AND "+
					"c.document = d.document AND i.docposition = "+
					"(SELECT dp.docposition FROM docpositions dp WHERE dp.document = "+doc+
					" AND storagecardto IN "+
					"(SELECT crd.storagecard FROM storagecards crd WHERE crd.party='"+party+"' AND crd.storageplace = d.from))";
//				System.out.println("RUP SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				result = rs.getString("name");
				if(result != null) { result = result.trim(); }
				rs.close(); rs = null;
				break;
			case 'W':
				s = "SELECT TRIM(c.name) || ' ' || TRIM(d.blanknumber) name "+
					"FROM contracts c, documents d "+
					"WHERE c.document = d.document AND c.document = "+
					"(SELECT documentfrom FROM docdependencies WHERE documentto = "+doc+")";
//				System.out.println("RUP SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				result = rs.getString("name");
				if(result != null) { result = result.trim(); }
				rs.close(); rs = null;
				break;
			default:
				throw new IllegalArgumentException();
			}
		} finally {
			if(rs != null) rs.close();
		}
	} catch(IllegalArgumentException iae) {
		// Nothing to do. Indicates that we cannot find documents by given serial
	} catch(Exception e) {
//		System.out.println("RUP Exception");
		e.printStackTrace(System.out);
	}
//	System.out.println("RU VP:'"+result+"'");
	return result;
}
public static String findContractNameBySerial(Statement stmt, String serial) {
	String result = "";
	if(serial == null) {
		return result;
	}
	serial = serial.trim();
	try {
		String s;
		ResultSet rs = null;
		try {
			s = "SELECT type, document FROM documents WHERE document = "+
				"(SELECT document FROM cardtracks WHERE trackid = "+
				"(SELECT MIN(trackid) FROM cardtracks WHERE storagecard IN "+
				"(SELECT storagecard FROM "+
				"storagecards WHERE closed='N' AND serialnumber='"+serial+"')))";
			//System.out.println("RU SQL="+s);
			rs = stmt.executeQuery(s);
			if( !rs.next() ) {
				throw new IllegalArgumentException();
			}
			String dt = rs.getString("type");
			//System.out.println("RU DOCTYPE:"+dt);
			char docType = rs.getString("type").charAt(0);
			int doc = rs.getInt( "document" );
			rs.close(); rs = null;
			
			switch( docType ) {
			case 'H': //change act
				s = "SELECT oldserial FROM changeactpos WHERE document="+doc+" AND newserial='"+serial+"' AND oldserial <> newserial ";
				//System.out.println("RU SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				String oSerial = rs.getString( "oldserial" );
				if(oSerial != null) oSerial = oSerial.trim();
				rs.close(); rs = null;
				return findContractNameBySerial( stmt, oSerial );
			case 'S': //surplusact - get contract from i13n act
				s = "SELECT (TRIM(c.name) || ' ' || TRIM(d.blanknumber)) name "+
					"FROM i13actpos i, contracts c, documents d "+
					"WHERE i.contract = c.document AND "+
					"c.document = d.document AND i.docposition = "+
					"(SELECT docposition FROM docpositions WHERE document = "+doc+" AND storagecardto = "+
					"(SELECT storagecard FROM storagecards WHERE closed='N' AND serialnumber='"+serial+"')) ";
				//System.out.println("RU SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				result = rs.getString("name");
				if(result != null) { result = result.trim(); }
				rs.close(); rs = null;
				break;
			case 'W':
				s = "SELECT TRIM(c.name) || ' ' || TRIM(d.blanknumber) name "+
					"FROM contracts c, documents d "+
					"WHERE c.document = d.document AND c.document = "+
					"(SELECT documentfrom FROM docdependencies WHERE documentto = "+doc+")";
				//System.out.println("RU SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				result = rs.getString("name");
				if(result != null) { result = result.trim(); }
				rs.close(); rs = null;
				break;
			default:
				throw new IllegalArgumentException();
			}
		} finally {
			if(rs != null) rs.close();
		}
	} catch(IllegalArgumentException iae) {
		// Nothing to do. Indicates that we cannot find documents by given serial
	} catch(Exception e) {
//		System.out.println("ReportUtil Exception");
		e.printStackTrace(System.out);
	}
//	System.out.println("RU VS:'"+result+"'");
	return result;
}
public static String findPostavkaByParty(Statement stmt, String party) {
	String result = "";
	if(party == null) {
		return result;
	}
	party = party.trim();
	try {
		String s;
		ResultSet rs = null;
		try {
			s = "SELECT FIRST 1 d.type type, d.document document, d.blankdate FROM documents d WHERE d.type IN ('S','W') AND EXISTS "+
				"(SELECT dd.docposition FROM docpositions dd WHERE dd.document = d.document "+
				"AND dd.storagecardto IN "+
				"(SELECT storagecard FROM storagecards WHERE party ='"+party+"')) "+
				"ORDER BY blankdate";
//			System.out.println("RPP SQL="+s);
			rs = stmt.executeQuery(s);
			if( !rs.next() ) {
				throw new IllegalArgumentException();
			}
			char docType = rs.getString("type").charAt(0);
			int doc = rs.getInt( "document" );
			rs.close(); rs = null;
			
			switch( docType ) {
			case 'S': //surplusact - get contruct from i13n act
				s = "SELECT TRIM(i.cordocnum) postavka "+
					"FROM i13actpos i, documents d "+
					"WHERE i.contract = d.document AND i.docposition = "+
					"(SELECT dp.docposition FROM docpositions dp WHERE dp.document = "+doc+
					" AND storagecardto IN "+
					"(SELECT crd.storagecard FROM storagecards crd WHERE crd.party='"+party+"' AND crd.storageplace = d.from))";
				//System.out.println("RPP SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				result = rs.getString("postavka");
				if(result != null) { result = result.trim(); }
				rs.close(); rs = null;
				break;
			case 'W':
				s = "SELECT TRIM(iw.cordocnum) postavka "+
					"FROM inwaybills iw "+
					"WHERE iw.document = "+doc;
				//System.out.println("RPP SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				result = rs.getString("postavka");
				if(result != null) { result = result.trim(); }
				rs.close(); rs = null;
				break;
			default:
				throw new IllegalArgumentException();
			}
		} finally {
			if(rs != null) rs.close();
		}
	} catch(IllegalArgumentException iae) {
		// Nothing to do. Indicates that we cannot find documents by given serial
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return result;
}
public static String findPostavkaBySerial(Statement stmt, String serial) {
	String result = "";
	if(serial == null) {
		return result;
	}
	serial = serial.trim();
	try {
		String s;
		ResultSet rs = null;
		try {
			s = "SELECT type, document FROM documents WHERE document = "+
				"(SELECT document FROM cardtracks WHERE trackid = "+
				"(SELECT MIN(trackid) FROM cardtracks WHERE storagecard IN "+
				"(SELECT storagecard FROM "+
				"storagecards WHERE closed='N' AND serialnumber='"+serial+"')))";
			////System.out.println("RP SQL="+s);
			rs = stmt.executeQuery(s);
			if( !rs.next() ) {
				throw new IllegalArgumentException();
			}
			String dt = rs.getString("type");
			//System.out.println("RP DOCTYPE:"+dt);
			char docType = rs.getString("type").charAt(0);
			int doc = rs.getInt( "document" );
			rs.close(); rs = null;
			
			switch( docType ) {
			case 'H': //change act
				s = "SELECT oldserial FROM changeactpos WHERE document="+doc+" AND newserial='"+serial+"'";
				//System.out.println("RP SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				String oSerial = rs.getString( "oldserial" );
				if(oSerial != null) oSerial = oSerial.trim();
				rs.close(); rs = null;
				return findPostavkaBySerial( stmt, oSerial );
			case 'S': //surplusact - get contract from i13n act
				s = "SELECT TRIM(i.cordocnum) postavka "+
					"FROM i13actpos i, documents d "+
					"WHERE i.contract = d.document AND i.docposition = "+
					"(SELECT docposition FROM docpositions WHERE document = "+doc+" AND storagecardto = "+
					"(SELECT storagecard FROM storagecards WHERE closed='N' AND serialnumber='"+serial+"')) ";
				//System.out.println("RP SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				result = rs.getString("postavka");
				if(result != null) { result = result.trim(); }
				rs.close(); rs = null;
				break;
			case 'W':
				s = "SELECT TRIM(iw.cordocnum) postavka "+
					"FROM inwaybills iw "+
					"WHERE iw.document = "+doc;
				//System.out.println("RP SQL="+s);
				rs = stmt.executeQuery(s);
				if( !rs.next() ) {
					throw new IllegalArgumentException();
				}
				result = rs.getString("postavka");
				if(result != null) { result = result.trim(); }
				rs.close(); rs = null;
				break;
			default:
				throw new IllegalArgumentException();
			}
		} finally {
			if(rs != null) rs.close();
		}
	} catch(IllegalArgumentException iae) {
		// Nothing to do. Indicates that we cannot find documents by given serial
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return result;
}
public static String getFullStorageName(Statement stmt, int storageplace) {
	String s;
	ResultSet rs = null;
	String storageplacename = "";
	s = "SELECT sp.type, " +
		"CASE sp.type WHEN 'P' THEN ''  WHEN 'X' THEN '' WHEN 'S' THEN '' ELSE "+
			"NVL((SELECT NVL('D'||pm.gsmid||' ','') || NVL('A'||pm.dampsid||' ', '') || TRIM(sm.name) || ' / ' FROM equipment em, positions pm, storageplaces sm WHERE em.position = pm.storageplace AND pm.storageplace = sm.storageplace AND em.equipment = sp.storageplace),'') "+
			"END || "+
		" CASE sp.type "+
		"WHEN 'P' THEN "+
		"    (SELECT NVL('A'||p.dampsid||' ','') || NVL('D' || p.gsmid || ' ', '') || TRIM(s.name) FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = sp.storageplace) "+
		"WHEN 'S' THEN "+
		"    sp.name "+
		"WHEN 'X' THEN "+
		"    (SELECT NVL(trim(o.name),trim(p.lastname) || ' ' || trim(p.firstname) || ' ' || trim(p.middlename)) FROM expedition e, outer organizations o, outer (workers w, people p) WHERE o.organization = e.organization AND e.expeditor = w.worker AND p.man = w.man AND e.expedition = sp.storageplace) "+
		"WHEN 'E' THEN "+
		"    sp.name "+
		"WHEN 'B' THEN "+
		"    (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = sp.storageplace) "+
		"WHEN 'C' THEN "+
		"    (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM(sp.name) FROM comequipment ce WHERE ce.equipment = sp.storageplace) "+
		"WHEN 'O' THEN "+
		"    (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = sp.storageplace) "+
		"WHEN 'W' THEN "+
		"    (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || TRIM(sp.name) FROM switches s WHERE s.equipment = sp.storageplace) "+
		"WHEN 'T' THEN "+
		"    (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = sp.storageplace) "+
		"WHEN 'R' THEN "+
		"    (SELECT 'Репитер ' || TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = sp.storageplace AND rp.resource = r.resource) "+
		"WHEN 'L' THEN "+
		"    (SELECT 'WLAN ' || TRIM(sp.name) || NVL(' '||w.number,'') FROM wlan w  WHERE w.equipment = sp.storageplace) "+
		"END storagename "+
		"FROM storageplaces sp "+
		"WHERE sp.storageplace = "+storageplace;
	
	try {
//		System.out.println("SQL=" + s);
		rs = stmt.executeQuery(s);
		if(rs.next()) {
			storageplacename = rs.getString("storagename");
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	try { rs.close(); } catch(Exception se) {}

	return storageplacename;
}
public static String getFullStorageNameSQL() {
	return	"CASE sp.type WHEN 'P' THEN ''  WHEN 'X' THEN '' WHEN 'S' THEN '' ELSE "+
			"NVL((SELECT NVL('D'||pm.gsmid||' ','') || NVL('A'||pm.dampsid||' ', '') || TRIM(sm.name) || ' / ' FROM equipment em, positions pm, storageplaces sm WHERE em.position = pm.storageplace AND pm.storageplace = sm.storageplace AND em.equipment = sp.storageplace),'') "+
			"END || "+
			"CASE sp.type "+
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
			"END fullstoragename ";
}
public static String getFullStorageNameSQL(String tablepref, String fieldname) {
	return	"CASE "+tablepref+".type WHEN 'P' THEN ''  WHEN 'X' THEN '' WHEN 'S' THEN '' ELSE "+
			"NVL((SELECT NVL('D'||pm.gsmid||' ','') || NVL('A'||pm.dampsid||' ', '') || TRIM(sm.name) || ' / ' FROM equipment em, positions pm, storageplaces sm WHERE em.position = pm.storageplace AND pm.storageplace = sm.storageplace AND em.equipment = "+tablepref+".storageplace),'') "+
			"END || "+
			"CASE "+tablepref+".type "+
			"WHEN 'P' THEN (SELECT NVL('A'||p.dampsid||' ','') || NVL('D' || p.gsmid || ' ', '') || TRIM(s.name) FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = "+tablepref+".storageplace) "+
			"WHEN 'S' THEN "+tablepref+".name "+
			"WHEN 'X' THEN (SELECT NVL(trim(o.name),trim(p.lastname) || ' ' || trim(p.firstname) || ' ' || trim(p.middlename)) FROM expedition e, outer organizations o, outer (workers w, people p) WHERE o.organization = e.organization AND e.expeditor = w.worker AND p.man = w.man AND e.expedition = "+tablepref+".storageplace) "+
			"WHEN 'E' THEN "+tablepref+".name "+
			"WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = "+tablepref+".storageplace) "+
			"WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM("+tablepref+".name) FROM comequipment ce WHERE ce.equipment = "+tablepref+".storageplace) "+
			"WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = "+tablepref+".storageplace) "+
			"WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || TRIM("+tablepref+".name) FROM switches s WHERE s.equipment = "+tablepref+".storageplace) "+
			"WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = "+tablepref+".storageplace) "+
			"WHEN 'R' THEN (SELECT 'Репитер ' || TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = "+tablepref+".storageplace AND rp.resource = r.resource) "+
			"WHEN 'L' THEN (SELECT 'WLAN ' || TRIM("+tablepref+".name) || NVL(' '||w.number,'') FROM wlan w  WHERE w.equipment = "+tablepref+".storageplace) "+
			"END "+fieldname+" ";
}
public static String getSQLDate(java.util.Date dat) {
	if(dat == null) {
		dat = new java.util.Date();
	}
	cal.setTime(dat);
	return "{d '"+(cal.get(Calendar.YEAR))+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+"'}";
}
public static String getStorageName(Statement stmt, int storagecode) {
	String s =
		"SELECT CASE sp.type "+
		"WHEN 'P' THEN (SELECT NVL('D'||p.gsmid||' ', '') || NVL('A'||p.dampsid||' ','') || TRIM(s.name) FROM positions p, storageplaces s WHERE p.storageplace = s.storageplace AND s.storageplace = sp.storageplace) "+
		"WHEN 'S' THEN (SELECT TRIM(s1.name) name FROM storageplaces s1 WHERE s1.storageplace = sp.storageplace) "+
		"WHEN 'X' THEN (SELECT NVL(trim(o.name),trim(p.lastname) || ' ' || trim(p.firstname) || ' ' || trim(p.middlename)) name "+
		"FROM expedition e, outer organizations o, outer (workers w, people p) "+
		"WHERE o.organization = e.organization AND "+
		"e.expeditor = w.worker AND p.man = w.man AND e.expedition = sp.storageplace) "+
		"ELSE (SELECT NVL('D'||p.gsmid||' ', '') || NVL('A'||p.dampsid||' ','') || TRIM(s.name) FROM equipment e, positions p, storageplaces s WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"END storagename "+
		"FROM storageplaces sp WHERE sp.storageplace = "+storagecode;

	String result = "?";
	try {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(s);
			if(rs.next()) {
				result = rs.getString("storagename");
			}
		} finally {
			if(rs != null) rs.close();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	
	return result;
}
public static String getStorageNameSQL() {
	return 
		"CASE sp.type "+
		"WHEN 'P' THEN (SELECT TRIM(s.name) || NVL(' D' || p.gsmid, '') || NVL(' A'||p.dampsid,'') name FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = sp.storageplace) "+
		"WHEN 'S' THEN (SELECT TRIM(s1.name) name FROM storageplaces s1 WHERE s1.storageplace = sp.storageplace) "+
		"WHEN 'X' THEN (SELECT NVL(trim(o.name),trim(p.lastname) || ' ' || trim(p.firstname) || ' ' || trim(p.middlename)) name "+
		"FROM expedition e, outer organizations o, outer (workers w, people p) "+
		"WHERE o.organization = e.organization AND "+
		"e.expeditor = w.worker AND p.man = w.man AND e.expedition = sp.storageplace) "+
		"WHEN 'E' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"FROM equipment e, positions p, storageplaces s "+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'B' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"FROM equipment e, positions p, storageplaces s "+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'C' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"FROM equipment e, positions p, storageplaces s "+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'O' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"FROM equipment e, positions p, storageplaces s "+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'W' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"FROM equipment e, positions p, storageplaces s "+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+
		"WHEN 'T' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"FROM equipment e, positions p, storageplaces s "+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+

		"WHEN 'R' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"FROM equipment e, positions p, storageplaces s "+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+

		"WHEN 'L' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name "+
		"FROM equipment e, positions p, storageplaces s "+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = sp.storageplace) "+

		"END storagename ";
}
public static String getStorageNameSQL(String tablepref, String fieldname) {
	return 
		"CASE "+tablepref+".type \n"+
		"WHEN 'P' THEN (SELECT TRIM(s.name) || NVL(' D' || p.gsmid, '') || NVL(' A'||p.dampsid,'') name FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = "+tablepref+".storageplace) \n"+
		"WHEN 'S' THEN (SELECT TRIM(s1.name) name FROM storageplaces s1 WHERE s1.storageplace = "+tablepref+".storageplace) \n"+
		"WHEN 'X' THEN (SELECT NVL(trim(o.name),trim(p.lastname) || ' ' || trim(p.firstname) || ' ' || trim(p.middlename)) name \n"+
		"FROM expedition e, outer organizations o, outer (workers w, people p) \n"+
		"WHERE o.organization = e.organization AND \n"+
		"e.expeditor = w.worker AND p.man = w.man AND e.expedition = "+tablepref+".storageplace) \n"+
		"WHEN 'E' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name \n"+
		"FROM equipment e, positions p, storageplaces s \n"+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = "+tablepref+".storageplace) \n"+
		"WHEN 'B' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name \n"+
		"FROM equipment e, positions p, storageplaces s \n"+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = "+tablepref+".storageplace) \n"+
		"WHEN 'C' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name \n"+
		"FROM equipment e, positions p, storageplaces s \n"+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = "+tablepref+".storageplace) \n"+
		"WHEN 'O' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name \n"+
		"FROM equipment e, positions p, storageplaces s \n"+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = "+tablepref+".storageplace) \n"+
		"WHEN 'W' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name \n"+
		"FROM equipment e, positions p, storageplaces s \n"+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = "+tablepref+".storageplace) \n"+
		"WHEN 'T' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name \n"+
		"FROM equipment e, positions p, storageplaces s \n"+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = "+tablepref+".storageplace) \n"+

		"WHEN 'R' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name \n"+
		"FROM equipment e, positions p, storageplaces s \n"+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = "+tablepref+".storageplace) \n"+

		"WHEN 'L' THEN (SELECT TRIM(s.name) || NVL(' D'||p.gsmid,'') || NVL(' A' || p.dampsid, '') name \n"+
		"FROM equipment e, positions p, storageplaces s \n"+
		"WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = "+tablepref+".storageplace) \n"+

		"END "+fieldname;
}
public static String quoteForSQL(String source) {
	int i = 0;
	int ip = 0;
	if(source == null) return "";
	if(source.indexOf("'") > 0) {
		StringBuffer result = new StringBuffer();
		while( (i = source.indexOf("'", ip)) > 0 ) {
			result.append(source.substring(ip,i));
			result.append("''");
			ip = i+1;
		}
		return result.toString();
	} else {
		return source;
	}
}
public static void updateContractsAndSupplies(Connection con, String tablename) {
	try {
		Statement stmt = con.createStatement();
		Statement stmtUpd = con.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
		ResultSet rsUpd = null;
		String s;
		try {
			s = "SELECT recid, policy, contract, postavka, serno, partno FROM "+tablename;
			rsUpd = stmtUpd.executeQuery(s);
			while(rsUpd.next()) {
				if("S".equals(rsUpd.getString("policy"))) {
					rsUpd.updateString("contract", findContractNameBySerial(stmt,rsUpd.getString("serno")));
					rsUpd.updateString("postavka", findPostavkaBySerial(stmt,rsUpd.getString("serno")));
					rsUpd.updateRow();
				} else if("P".equals(rsUpd.getString("policy"))) {
					rsUpd.updateString("contract", findContractNameByParty(stmt,rsUpd.getString("partno")));
					rsUpd.updateString("postavka", findPostavkaByParty(stmt,rsUpd.getString("partno")));
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
