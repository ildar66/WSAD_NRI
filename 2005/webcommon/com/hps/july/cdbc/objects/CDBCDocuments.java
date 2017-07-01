package com.hps.july.cdbc.objects;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.hps.july.persistence.ResourceSubTypeKey;
import com.hps.july.cdbc.lib.*;

/**
 * Объект для работы с документами модуля Inventory.
 * Creation date: (12.03.2004)
 * @author: Anthon Stefanov
 */
public class CDBCDocuments {
	/**
	 * CDBCPositionObject constructor comment.
	 */
	public CDBCDocuments() {
		super();
	}
	
	/**
	 * Возвращает набор данных для списка актов демонтажа на позиции.
	 * @TODO: Написать описание параметров
	 */
	public int checkChangeActPositionPresent(
		Integer argDocument,
		Integer argResource,
		String argSerial,
		Integer argChangeposcode) {
		//System.out.println("argDocument:"+argDocument+", argResource:"+argResource+", argSerial:"+argSerial+", argChpos:"+argChangeposcode);
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT count(cap.changeactpos) npos FROM changeactpos cap ");
		sqlb.append("WHERE ");
		if (argDocument != null) {
			sqlb.append("cap.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("cap.document IS NULL ");
		}
		if (argResource != null) {
			sqlb.append("AND cap.oldresource = ? ");
			params.add(argResource);
		} else {
			sqlb.append("AND cap.oldresource IS NULL ");
		}
		if (argSerial != null) {
			sqlb.append("AND cap.oldserial = ? ");
			params.add(argSerial);
		} else {
			sqlb.append("AND cap.oldserial IS NULL ");
		}
		if (argChangeposcode != null) {
			sqlb.append("AND cap.changeactpos <> ? ");
			params.add(argChangeposcode);
		}
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		int r = 0;
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			System.out.println(
				"ChPos Count:[" + ro.getColumn("npos").asString() + "]");
			BigDecimal i = (BigDecimal) ro.getColumn("npos").asObject();
			if (i != null) {
				r = i.intValue();
			}
		}

		return r;
	}
	/**
	 * Возвращает набор данных для списка актов демонтажа на позиции.
	 * @TODO: Написать описание параметров
	 */
	public Integer[] getAfsMountPosChildrenIds(Integer parentId) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		if (parentId == null)
			return null;

		sqlb.append(
			"SELECT docposition FROM afsmountpos WHERE parentdocpos = ? ");
		params.add(parentId);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Integer[] result = new Integer[res.getRowsCount()];
		Iterator it = res.listIterator();
		int i = 0;
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			Object o = ro.getColumn("docposition").asObject();
			if (o != null) {
				result[i] = new Integer(((Number) o).intValue());
				i++;
			} else {
				result[i] = null;
				i++;
			}
		}
		return result;
	}
	public static String getDocumentTypeLetter(int document) {
		String result = null;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT type dtype FROM documents WHERE document = ? ");
		params.add(new Integer(document));
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			result = ro.getColumn("dtype").asString();
		}
		return result;
	}
	public static String getDocumentTypeName(Integer document) {
		String result = "";
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		if (document == null) {
			return result;
		}

		sqlb.append(
			"SELECT getDocRusType(document) dtn FROM documents WHERE document = ? ");
		params.add(document);
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			result = ro.getColumn("dtn").asString();
		}
		return result;
	}
	public String getFullStorageName(Integer storageplace) {
		String result = "?";
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT TRIM(CASE sp.type WHEN 'P' THEN ''  WHEN 'X' THEN '' WHEN 'S' THEN '' ELSE  ");
		sqlb.append(
			"NVL((SELECT NVL('D'||pm.gsmid||' ','') || NVL('A' || pm.dampsid || ' ', '') || TRIM(sm.name) || ' / ' FROM equipment em, positions pm, storageplaces sm WHERE em.position = pm.storageplace AND pm.storageplace = sm.storageplace AND em.equipment = sp.storageplace),'')  ");
		sqlb.append("END || CASE sp.type  ");
		sqlb.append(
			"WHEN 'P' THEN (SELECT NVL('A'||p.dampsid||' ','') || NVL('D' || p.gsmid || ' ', '') || TRIM(s.name) FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = sp.storageplace)  ");
		sqlb.append("WHEN 'S' THEN sp.name  ");
		sqlb.append(
			"WHEN 'X' THEN (SELECT NVL(trim(o.name),trim(p.lastname) || ' ' || trim(p.firstname) || ' ' || trim(p.middlename)) FROM expedition e, outer organizations o, outer (workers w, people p) WHERE o.organization = e.organization AND e.expeditor = w.worker AND p.man = w.man AND e.expedition = sp.storageplace)  ");
		sqlb.append("WHEN 'E' THEN sp.name  ");
		sqlb.append(
			"WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || NVL(' ' || bs.number || ', ','') || NVL(TRIM(bs.name),'') FROM basestations bs WHERE bs.equipment = sp.storageplace)  ");
		sqlb.append(
			"WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM(sp.name) FROM comequipment ce WHERE ce.equipment = sp.storageplace)  ");
		sqlb.append(
			"WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = sp.storageplace)  ");
		sqlb.append(
			"WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || TRIM(sp.name) FROM switches s WHERE s.equipment = sp.storageplace)  ");
		sqlb.append(
			"WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = sp.storageplace)  ");
		sqlb.append(
			"WHEN 'R' THEN (SELECT 'Репитер ' || TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = sp.storageplace AND rp.resource = r.resource)  ");
		sqlb.append(
			"WHEN 'L' THEN (SELECT 'WLAN ' || TRIM(sp.name) || NVL(' '||w.number,'') FROM wlan w  WHERE w.equipment = sp.storageplace)  ");
		sqlb.append("END) fullstoragename ");
		sqlb.append("FROM storageplaces sp ");

		if (storageplace != null) {
			sqlb.append("WHERE sp.storageplace = ? ");
			params.add(storageplace);
		} else {
			sqlb.append("WHERE sp.storageplace IS NULL ");
		}

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			result = ro.getColumn("fullstoragename").asString();
		}
		return result;
	}
	public static CDBCResultSet getMountItemsAgregatedOnly(
		Integer argDocument,
		Integer argAgregatedocpos,
		Integer orderonly) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.notes,dp.comment, dp.type, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.resource, r.countpolicy, dp.serialnumber serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append("WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} /*else {
				sqlb.append("AND dp.document IS NULL ");
			}*/

		if (argAgregatedocpos != null) {
			sqlb.append("AND dp.agregate = ? ");
			params.add(argAgregatedocpos);
		} else {
			sqlb.append("AND dp.agregate IS NULL ");
		}

		if (orderonly != null) {
			sqlb.append("AND dp.order = ? ");
			params.add(orderonly);
		}

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public int getNextDocumentOrder(Integer documentId) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		if (documentId == null)
			return -1;

		sqlb.append(
			"SELECT max(dp.order)+1 neworder FROM docpositions dp WHERE dp.document = ? AND dp.agregate IS NULL ");
		params.add(documentId);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			Object o = ro.getColumn("neworder").asObject();
			if (o != null) {
				return ((Number) o).intValue();
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
	public static Integer getSameBulk(
		Integer resource,
		Integer owner,
		Integer document) {
		// new Integer(res.getResource()),ownercode,doc.getInteger(),null)
		Integer result = null;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		if (resource == null) {
			return null;
		}
		if (owner == null) {
			return null;
		}
		if (document == null) {
			return null;
		}

		sqlb.append(
			"SELECT dp.docposition FROM docpositions dp WHERE dp.document = ? AND dp.resource = ? AND dp.owner = ? ");
		params.add(document);
		params.add(resource);
		params.add(owner);
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			Number n = (Number) ro.getColumn("docposition").asObject();
			if (n != null) {
				result = new Integer(n.intValue());
			}
		}
		return result;
	}
	public static Integer getSameParty(
		String party,
		Integer owner,
		Integer document) {
		Integer result = null;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		if (party == null || "".equals(party.trim())) {
			return null;
		}
		if (owner == null) {
			return null;
		}
		if (document == null) {
			return null;
		}

		sqlb.append(
			"SELECT dp.docposition FROM docpositions dp WHERE dp.document = ? AND dp.owner = ? AND dp.party = ? ");
		params.add(document);
		params.add(owner);
		params.add(party);
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			Number n = (Number) ro.getColumn("docposition").asObject();
			if (n != null) {
				result = new Integer(n.intValue());
			}
		}
		return result;
	}
	public boolean hasDocumentWarnings(Integer document) {
		boolean result = false;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT count(errorid) warncount FROM documenterrors de WHERE errorlevel = 2 ");

		if (document != null) {
			sqlb.append("AND document = ? ");
			params.add(document);
		} else {
			sqlb.append("AND document IS NULL ");
		}

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			Number n = (Number) ro.getColumn("warncount").asObject();
			if (n != null && n.intValue() > 0) {
				result = true;
			}
		}
		return result;
	}
	public static boolean hasSameSerial(
		String serial,
		Integer document,
		Integer docpos) {
		boolean result = false;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		if (document == null) {
			return false;
		}
		if (serial == null || "".equals(serial.trim())) {
			return false;
		}

		sqlb.append(
			"SELECT count(dp.docposition) sn FROM docpositions dp WHERE dp.document = ? ");
		sqlb.append("AND dp.serialnumber = ? ");
		params.add(document);
		params.add(serial);
		if (docpos != null) {
			sqlb.append("AND dp.docposition <> ? ");
			params.add(docpos);
		}

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			Number n = (Number) ro.getColumn("sn").asObject();
			if (n != null && n.intValue() > 0) {
				result = true;
			}
		}
		return result;
	}
	public static boolean hasSameSerialAndResource(
		String serial,
		String resource,
		Integer document,
		Integer docpos) {
		boolean result = false;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		if (document == null) {
			return false;
		}
		if (serial == null || "".equals(serial.trim())) {
			return false;
		}
		if (resource == null || "".equals(resource.trim())) {
			return false;
		}

		sqlb.append(
			"SELECT count(dp.docposition) sn FROM docpositions dp WHERE dp.document = ? ");
		sqlb.append("AND dp.serialnumber = ? AND dp.resource = ? ");
		params.add(document);
		params.add(serial);
		params.add(resource);
		if (docpos != null) {
			sqlb.append("AND dp.docposition <> ? ");
			params.add(docpos);
		}

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			Number n = (Number) ro.getColumn("sn").asObject();
			if (n != null && n.intValue() > 0) {
				result = true;
			}
		}
		return result;
	}
	public CDBCResultSet listAfsMountCableItems(Integer argParent) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT amp.docposition, dp.resource, TRIM(r.name) || ' ' || TRIM(r.model) cablename, dp.qty, TRIM(u.shortname) uname ");
		sqlb.append(
			"FROM afsmountpos amp, docpositions dp, resources r, outer units u ");
		sqlb.append(
			"WHERE amp.docposition = dp.docposition AND dp.resource = r.resource AND r.unit = u.unit ");

		if (argParent != null) {
			sqlb.append("AND amp.parentdocpos = ? ");
			params.add(argParent);
		} else {
			sqlb.append("AND amp.parentdocpos IS NULL ");
		}

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	public CDBCResultSet listAfsMountDocuments(
		Boolean useDate,
		java.sql.Date dateFrom,
		java.sql.Date dateTo,
		Boolean useOwner,
		Integer owner,
		Boolean usePosition,
		Integer position,
		Boolean useExporg,
		Integer exporg,
		Boolean useExpworker,
		Integer worker,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			// "SELECT d.document, d.isautodoc, d.visualtype, d.prjstatus, d.blankdate docdate, TRIM(d.blankindex || NVL(' ' || TRIM(d.blanknumber),'')) docnumber, o.name ownername, ");
			"SELECT d.document, d.isautodoc, d.visualtype, d.prjstatus, d.blankdate docdate, TRIM(d.blanknumber) docnumber, o.name ownername, ");
		sqlb.append(
			"NVL('D'||p.gsmid|| ' ','') || NVL('A'||p.dampsid|| ' ','') || TRIM(spp.name) posname, ");
		sqlb.append("CASE spe.type ");
		sqlb.append(
			"  WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = equ.equipment) ");
		sqlb.append(
			"  WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' || ' ' || TRIM(spe.name) WHEN 'O' THEN 'ВО ' || ' ' || TRIM(spe.name) || NVL(' (' || TRIM(ce.osinvname) || ')','') ELSE ' ' || TRIM(spe.name) END FROM comequipment ce WHERE ce.equipment = equ.equipment) ");
		sqlb.append("  WHEN 'E' THEN TRIM(spe.name) ");
		sqlb.append(
			"  WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = equ.equipment) ");
		sqlb.append(
			"  WHEN 'R' THEN (SELECT TRIM(r.model) || ' ' || rp.number FROM repiters rp, resources r WHERE rp.equipment = equ.equipment AND rp.resource = r.resource) ");
		sqlb.append(
			"  WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = equ.equipment) ");
		sqlb.append(
			"  WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || spe.name FROM switches s WHERE s.equipment = equ.equipment) ");
		sqlb.append("  WHEN 'L' THEN 'WLAN ' ");
		sqlb.append("  ELSE '?' ");
		sqlb.append("END equname, ");
		sqlb.append(
			"NVL((SELECT TRIM(TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)) FROM workers w, people p WHERE p.man = w.man AND w.worker = ex.expeditor), ");
		sqlb.append(
			" (SELECT TRIM(org.name) FROM organizations org WHERE org.organization = ex.organization)) expeditor, ");
		sqlb.append("d.state ");
		sqlb.append(
			"FROM afsmountact afm, documents d, equipment equ, positions p, storageplaces spp, storageplaces spe, organizations o, expedition ex ");
		sqlb.append(
			"WHERE d.document = afm.document AND o.organization = d.owner AND d.showtouser = 'Y' ");
		sqlb.append(
			"AND d.to = equ.equipment AND equ.position = p.storageplace AND p.storageplace = spp.storageplace AND equ.equipment = spe.storageplace ");
		sqlb.append("AND ex.expedition = d.from ");

		if (useDate != null && useDate.booleanValue()) {
			if (dateFrom != null && dateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(dateFrom);
				params.add(dateTo);
			}
		}

		if (useOwner != null && useOwner.booleanValue()) {
			if (owner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(owner);
			} else {
				sqlb.append("AND d.owner IS NULL ");
			}
		}

		if (usePosition != null && usePosition.booleanValue()) {
			if (position != null) {
				sqlb.append("AND equ.position = ? ");
				params.add(position);
			} else {
				sqlb.append("AND equ.position IS NULL ");
			}
		}

		if (useExporg != null && useExporg.booleanValue()) {
			if (exporg != null) {
				sqlb.append("AND ex.organization = ? ");
				params.add(exporg);
			} else {
				sqlb.append("AND ex.organization IS NULL ");
			}
		}

		if (useExpworker != null && useExpworker.booleanValue()) {
			if (worker != null) {
				sqlb.append("AND ex.expeditor = ? ");
				params.add(worker);
			} else {
				sqlb.append("AND ex.expeditor IS NULL ");
			}
		}

		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY docnumber ASC, docdate ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY docnumber DESC, docdate DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY docdate ASC, docnumber ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY docdate DESC, docnumber DESC ");
					break;
			}
		}
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	public CDBCResultSet listAfsMountItems(Integer argDocument) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT amp.docposition, dp.order, amp.docpostype, amp.num_ant, TRIM(r.name) || ' ' || TRIM(r.model) antname, dp.qty, TRIM(u.shortname) uname, ");
		sqlb.append(
			"CASE amp.kind_ant WHEN 'T' THEN 'T' WHEN 'D' THEN 'TR' WHEN 'R' THEN 'R' ELSE '' END kindant, amp.az_ant, amp.nakl, dp.serialnumber, dp.inventserial manufserial, serial_for_docpos(dp.docposition) invnum,");
		sqlb.append("CASE amp.sectora WHEN 'Y' THEN 'A' ELSE NULL END s_a, ");
		sqlb.append("CASE amp.sectorb WHEN 'Y' THEN 'B' ELSE NULL END s_b, ");
		sqlb.append("CASE amp.sectorc WHEN 'Y' THEN 'C' ELSE NULL END s_c, ");
		sqlb.append("CASE amp.sectord WHEN 'Y' THEN 'D' ELSE NULL END s_d, ");
		sqlb.append("CASE amp.sectore WHEN 'Y' THEN 'E' ELSE NULL END s_e, ");
		sqlb.append("CASE amp.sectorf WHEN 'Y' THEN 'F' ELSE NULL END s_f, ");
		sqlb.append("CASE amp.sectorg WHEN 'Y' THEN 'G' ELSE NULL END s_g, ");
		sqlb.append("CASE amp.sectorh WHEN 'Y' THEN 'H' ELSE NULL END s_h, ");
		sqlb.append(
			"CASE amp.sectoro1800 WHEN 'Y' THEN 'O' ELSE NULL END s_od, ");
		sqlb.append("CASE amp.sectoro WHEN 'Y' THEN 'O' ELSE NULL END s_o ");
		sqlb.append(
			"FROM afsmountpos amp, docpositions dp, resources r, outer units u ");
		sqlb.append(
			"WHERE amp.docposition = dp.docposition AND dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		sqlb.append("AND amp.parentdocpos IS NULL ");
		sqlb.append("ORDER BY dp.order ");

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	public static CDBCResultSet listAllAfsMountItemParents(Integer argDocument) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.visualtagid, dp.resource, amp.docposition, dp.order, amp.docpostype, amp.num_ant, TRIM(r.name) || ' ' || TRIM(r.model) antname, dp.qty, TRIM(u.shortname) uname, ");
		sqlb.append(
			"amp.h_set1, CASE amp.kind_ant WHEN 'T' THEN 'T' WHEN 'D' THEN 'TR' WHEN 'R' THEN 'R' ELSE '' END kindant, amp.az_ant, amp.nakl, dp.serialnumber, dp.inventserial manufserial, serial_for_docpos(dp.docposition) invnum,");
		sqlb.append("amp.sectora, ");
		sqlb.append("amp.sectorb, ");
		sqlb.append("amp.sectorc, ");
		sqlb.append("amp.sectord, ");
		sqlb.append("amp.sectore, ");
		sqlb.append("amp.sectorf, ");
		sqlb.append("amp.sectorg, ");
		sqlb.append("amp.sectorh, ");
		sqlb.append("amp.sectoro1800, ");
		sqlb.append("amp.sectoro ");
		sqlb.append(
			"FROM afsmountpos amp, docpositions dp, resources r, outer units u ");
		sqlb.append(
			"WHERE amp.docposition = dp.docposition AND dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}
		sqlb.append("AND amp.parentdocpos IS NULL ");

		sqlb.append("ORDER BY dp.visualtagid ");

		CDBCResultSet res = new CDBCResultSet();
		System.out.println("SQL=" + sqlb.toString());
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	public static CDBCResultSet listAllAfsMountItemsByParent(Integer argDocument, Integer argParent) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.visualtagid, dp.resource, amp.docposition, dp.order, amp.docpostype, amp.num_ant, TRIM(r.name) || ' ' || TRIM(r.model) antname, dp.qty, TRIM(u.shortname) uname, ");
		sqlb.append(
			"amp.groundcnt, amp.ksvn1800, amp.ksvn900, amp.h_set1, CASE amp.kind_ant WHEN 'T' THEN 'T' WHEN 'D' THEN 'TR' WHEN 'R' THEN 'R' ELSE '' END kindant, amp.az_ant, amp.nakl, dp.serialnumber, dp.inventserial manufserial, serial_for_docpos(dp.docposition) invnum,");
		sqlb.append("amp.sectora, ");
		sqlb.append("amp.sectorb, ");
		sqlb.append("amp.sectorc, ");
		sqlb.append("amp.sectord, ");
		sqlb.append("amp.sectore, ");
		sqlb.append("amp.sectorf, ");
		sqlb.append("amp.sectorg, ");
		sqlb.append("amp.sectorh, ");
		sqlb.append("amp.sectoro1800, ");
		sqlb.append("amp.sectoro ");
		sqlb.append(
			"FROM afsmountpos amp, docpositions dp, resources r, outer units u ");
		sqlb.append(
			"WHERE amp.docposition = dp.docposition AND dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}
		sqlb.append("AND amp.parentdocpos = ? ");
		params.add(argParent);

		sqlb.append("ORDER BY dp.visualtagid ");

		CDBCResultSet res = new CDBCResultSet();
		System.out.println("SQL=" + sqlb.toString());
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	
	/**
	 * Возвращает набор строк для актов монтажа блоков на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listChangeActItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT cap.changeactpos, ");
		sqlb.append(
			"cap.oldserial, cap.inventserial manufserial, cap.oldresource, TRIM(olr.name) || NVL(', ' || TRIM(olr.model),'') oresname, ");
		sqlb.append(
			"cap.newserial, cap.oldinventserial oldmanufserial, cap.newresource, TRIM(nlr.name) || NVL(', ' || TRIM(nlr.model),'') nresname ");
		sqlb.append(
			"FROM changeactpos cap, outer resources olr, outer resources nlr ");
		sqlb.append(
			"WHERE cap.oldresource = olr.resource AND cap.newresource = nlr.resource ");

		if (argDocument != null) {
			sqlb.append("AND cap.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND cap.document IS NULL ");
		}

		// ORDER BY
		sqlb.append(
			"ORDER BY oresname ASC, oldserial ASC, oldinventserial ASC, nresname ASC, newserial ASC, inventserial ASC ");
		/*
			if(order != null) {
				switch( order.intValue() ) {
				case 1:
					sqlb.append("ORDER BY cap.order ASC ");
					break;
				case 2:
					sqlb.append("ORDER BY cap.order DESC ");
					break;
				case 3:
					sqlb.append("ORDER BY oresname ASC, nresname ASC");
					break;
				case 4:
					sqlb.append("ORDER BY oresname DESC, nresname DESC ");
					break;
				}
			}
		*/
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка актов замены/модернизации на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listChangeActOnExpeditionDocuments(
		Boolean isDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		Boolean isOwner,
		Integer owner,
		String exptype,
		Integer exporg,
		Integer expworker,
		Character acttype,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT ca.document, d.blankdate, d.blankindex, d.blanknumber, ca.acttype, ");
		sqlb.append(
			"TRIM(eo.name) exporg, (SELECT TRIM(TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)) FROM people p WHERE p.man = ew.man) expman, d.state, ");
		sqlb.append("d.prjstatus, d.isautodoc ");
		sqlb.append(
			"FROM changeact ca, documents d, expedition ex, outer organizations eo, outer workers ew ");
		sqlb.append("WHERE ca.document = d.document ");
		sqlb.append(
			"AND d.from = ex.expedition AND ex.expeditor = ew.worker AND ex.organization = eo.organization ");

		if (isOwner != null && isOwner.booleanValue()) {
			if (owner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(owner);
			}
		}
		if (isDate != null && isDate.booleanValue()) {
			if (datefrom != null && dateto != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(datefrom);
				params.add(dateto);
			}
		}
		if (exptype != null) {
			if ("O".equals(exptype)) {
				if (exporg != null) {
					sqlb.append("AND ex.organization = ? ");
					params.add(exporg);
				} else {
					sqlb.append(
						"AND ex.organization IS NULL AND ex.expeditor IS NULL ");
				}
			} else if ("W".equals(exptype)) {
				if (expworker != null) {
					sqlb.append("AND ex.expeditor = ? ");
					params.add(expworker);
				} else {
					sqlb.append(
						"AND ex.expeditor IS NULL AND ex.organization IS NULL ");
				}
			}

		}
		if (acttype != null) {
			if ('C' == acttype.charValue()) {
				sqlb.append("AND ca.acttype = 'C' ");
			} else if ('U' == acttype.charValue()) {
				sqlb.append("AND ca.acttype = 'U' ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY d.blankdate DESC, d.blankindex ASC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	public CDBCResultSet listChangeActOnExpeditionItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT cap.changeactpos, ");
		sqlb.append(
			"cap.oldserial, cap.inventserial manufserial, cap.oldresource, TRIM(olr.name) || NVL(', ' || TRIM(olr.model),'') oresname, ");
		sqlb.append(
			"cap.newserial, cap.oldinventserial oldmanufserial, cap.newresource, TRIM(nlr.name) || NVL(', ' || TRIM(nlr.model),'') nresname ");
		sqlb.append(
			"FROM changeactpos cap, outer resources olr, outer resources nlr ");
		sqlb.append(
			"WHERE cap.oldresource = olr.resource AND cap.newresource = nlr.resource ");

		if (argDocument != null) {
			sqlb.append("AND cap.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND cap.document IS NULL ");
		}

		// ORDER BY
		sqlb.append(
			"ORDER BY oresname ASC, oldserial ASC, oldinventserial ASC, nresname ASC, newserial ASC, inventserial ASC ");
		/*
			if(order != null) {
				switch( order.intValue() ) {
				case 1:
					sqlb.append("ORDER BY cap.order ASC ");
					break;
				case 2:
					sqlb.append("ORDER BY cap.order DESC ");
					break;
				case 3:
					sqlb.append("ORDER BY oresname ASC, nresname ASC");
					break;
				case 4:
					sqlb.append("ORDER BY oresname DESC, nresname DESC ");
					break;
				}
			}
		*/
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка актов замены/модернизации на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listChangeActOnPositionDocuments(
		Boolean isDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		Boolean isOwner,
		Integer owner,
		Boolean isPosition,
		Integer position,
		Character acttype,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT ca.document, d.blankdate, d.blankindex, d.blanknumber, ca.acttype, ");
		sqlb.append(
			"NVL('D'||p.gsmid|| ' ','') || NVL('A'||p.dampsid|| ' ','') || TRIM(spp.name) posname, d.state, ");
		sqlb.append("d.prjstatus, d.isautodoc ");
		sqlb.append(
			"FROM changeact ca, documents d, equipment e, positions p, storageplaces spp ");
		sqlb.append(
			"WHERE ca.document = d.document AND d.from = e.equipment AND e.position = p.storageplace AND p.storageplace = spp.storageplace ");

		if (isOwner != null && isOwner.booleanValue()) {
			if (owner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(owner);
			}
		}
		if (isDate != null && isDate.booleanValue()) {
			if (datefrom != null && dateto != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(datefrom);
				params.add(dateto);
			}
		}
		if (isPosition != null && isPosition.booleanValue()) {
			if (position != null) {
				sqlb.append("AND p.storageplace = ? ");
				params.add(position);
			} else {
				sqlb.append("AND p.storageplace IS NULL ");
			}
		}
		if (acttype != null) {
			if ('C' == acttype.charValue()) {
				sqlb.append("AND ca.acttype = 'C' ");
			} else if ('U' == acttype.charValue()) {
				sqlb.append("AND ca.acttype = 'U' ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY d.blankdate DESC, d.blankindex ASC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор строк для актов монтажа блоков на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listChangeActOnPositionItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT cap.changeactpos, ");
		sqlb.append(
			"cap.oldserial, cap.inventserial manufserial, cap.oldresource, TRIM(olr.name) || NVL(', ' || TRIM(olr.model),'') oresname, ");
		sqlb.append(
			"cap.newserial, cap.oldinventserial oldmanufserial, cap.newresource, TRIM(nlr.name) || NVL(', ' || TRIM(nlr.model),'') nresname ");
		sqlb.append(
			"FROM changeactpos cap, outer resources olr, outer resources nlr ");
		sqlb.append(
			"WHERE cap.oldresource = olr.resource AND cap.newresource = nlr.resource ");

		if (argDocument != null) {
			sqlb.append("AND cap.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND cap.document IS NULL ");
		}

		// ORDER BY
		sqlb.append(
			"ORDER BY oresname ASC, oldserial ASC, oldinventserial ASC, nresname ASC, newserial ASC, inventserial ASC ");
		/*
			if(order != null) {
				switch( order.intValue() ) {
				case 1:
					sqlb.append("ORDER BY cap.order ASC ");
					break;
				case 2:
					sqlb.append("ORDER BY cap.order DESC ");
					break;
				case 3:
					sqlb.append("ORDER BY oresname ASC, nresname ASC");
					break;
				case 4:
					sqlb.append("ORDER BY oresname DESC, nresname DESC ");
					break;
				}
			}
		*/
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listChangeActOnStorageDocuments(
		Boolean isDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		Boolean isOwner,
		Integer owner,
		Boolean isStorage,
		Integer storage,
		Character acttype,
		Boolean isAdmin,
		String username,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT ca.document, d.blankdate, d.blankindex, d.blanknumber, ca.acttype, TRIM(sp.name) storagename, d.state, ");
		sqlb.append("d.prjstatus, d.isautodoc ");
		sqlb.append("FROM changeact ca, documents d, storageplaces sp ");
		sqlb.append("WHERE ca.document = d.document ");
		sqlb.append("AND d.from = sp.storageplace AND sp.type = 'S' ");

		if (isAdmin == null || !isAdmin.booleanValue()) {
			sqlb.append("AND sp.storageplace IN ");
			sqlb.append(
				"(SELECT s.storageplace FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? AND ra.viewfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}

		if (isOwner != null && isOwner.booleanValue()) {
			if (owner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(owner);
			}
		}
		if (isDate != null && isDate.booleanValue()) {
			if (datefrom != null && dateto != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(datefrom);
				params.add(dateto);
			}
		}
		if (isStorage != null && isStorage.booleanValue()) {
			if (storage != null) {
				sqlb.append("AND sp.storageplace = ? ");
				params.add(storage);
			} else {
				sqlb.append("AND sp.storageplace IS NULL ");
			}
		}
		if (acttype != null) {
			if ('C' == acttype.charValue()) {
				sqlb.append("AND ca.acttype = 'C' ");
			} else if ('U' == acttype.charValue()) {
				sqlb.append("AND ca.acttype = 'U' ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY d.blankdate DESC, d.blankindex ASC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка актов замены/модернизации на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listChangeActOnStorageDocuments(
		Boolean isDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		Boolean isOwner,
		Integer owner,
		Boolean isStorage,
		Integer storage,
		Character acttype,
		Integer order) {
		return listChangeActOnStorageDocuments(
			isDate,
			datefrom,
			dateto,
			isOwner,
			owner,
			isStorage,
			storage,
			acttype,
			Boolean.TRUE,
			"",
			order);
	}
	public CDBCResultSet listChangeActOnStorageItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT cap.changeactpos, ");
		sqlb.append(
			"cap.oldserial, cap.inventserial manufserial, cap.oldresource, TRIM(olr.name) || NVL(', ' || TRIM(olr.model),'') oresname, ");
		sqlb.append(
			"cap.newserial, cap.oldinventserial oldmanufserial, cap.newresource, TRIM(nlr.name) || NVL(', ' || TRIM(nlr.model),'') nresname ");
		sqlb.append(
			"FROM changeactpos cap, outer resources olr, outer resources nlr ");
		sqlb.append(
			"WHERE cap.oldresource = olr.resource AND cap.newresource = nlr.resource ");

		if (argDocument != null) {
			sqlb.append("AND cap.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND cap.document IS NULL ");
		}

		// ORDER BY
		sqlb.append(
			"ORDER BY oresname ASC, oldserial ASC, oldinventserial ASC, nresname ASC, newserial ASC, inventserial ASC ");
		/*
			if(order != null) {
				switch( order.intValue() ) {
				case 1:
					sqlb.append("ORDER BY cap.order ASC ");
					break;
				case 2:
					sqlb.append("ORDER BY cap.order DESC ");
					break;
				case 3:
					sqlb.append("ORDER BY oresname ASC, nresname ASC");
					break;
				case 4:
					sqlb.append("ORDER BY oresname DESC, nresname DESC ");
					break;
				}
			}
		*/
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка актов монтажа блоков на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listContractorDocuments(
		Boolean isDate,
		java.sql.Date startDate,
		java.sql.Date endDate,
		Boolean isOwner,
		Integer argOwner,
		Boolean isPosition,
		Integer argPosition,
		Boolean isContractor,
		Integer contractor,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT ic.id act,ic.orderindex orderindex, ic.ordernumber ordernumber, ic.date date,");
		sqlb.append("FormatPositionName(ic.position) posname,");
		sqlb.append("TRIM(o.name) contractorname, ic.state docstate ");
		sqlb.append("FROM invcontracts ic, organizations o ");
		sqlb.append("WHERE o.organization = ic.contractor ");

		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND ic.organization = ? ");
				params.add(argOwner);
			}
		}
		if (isDate != null && isDate.booleanValue()) {
			if (startDate != null && endDate != null) {
				sqlb.append("AND ic.date BETWEEN ? AND ? ");
				params.add(startDate);
				params.add(endDate);
			}
		}
		if (isContractor != null && isContractor.booleanValue()) {
			if (contractor != null) {
				sqlb.append("AND ic.contractor = ? ");
				params.add(contractor);
			} else {
				sqlb.append("AND ic.contractor IS NULL ");
			}
		}

		if (isPosition != null && isPosition.booleanValue()) {
			if (argPosition != null) {
				sqlb.append("AND ic.position = ? ");
				params.add(argPosition);
			} else {
				sqlb.append("AND ic.position IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY ic.ordernumber ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY ic.ordernumber DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY ic.date ASC, ic.ordernumber ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY ic.date DESC, ic.ordernumber DESC ");
					break;
			}
		}
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка актов монтажа блоков на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listDemountBlocksDocuments(
		Boolean isDate,
		java.sql.Date startDate,
		java.sql.Date endDate,
		Boolean isOwner,
		Integer argOwner,
		Boolean isPosition,
		Integer argPosition,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, TRIM(d.blanknumber) blanknumber, TRIM(o.name) ownername, ");
		sqlb.append(
			"NVL('D'||p.gsmid|| ' ','') || NVL('A'||p.dampsid|| ' ','') || TRIM(spp.name) posname, ");
		sqlb.append("CASE spe.type ");
		sqlb.append(
			"    WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || TRIM(bs.name) FROM basestations bs WHERE bs.equipment = e.equipment) ");
		sqlb.append(
			"    WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM(spe.name) FROM comequipment ce WHERE ce.equipment = e.equipment) ");
		sqlb.append("    WHEN 'E' THEN TRIM(spe.name) ");
		sqlb.append(
			"    WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = e.equipment) ");
		sqlb.append(
			"    WHEN 'R' THEN (SELECT TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = e.equipment AND rp.resource = r.resource) ");
		sqlb.append(
			"    WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = e.equipment) ");
		sqlb.append(
			"    WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || TRIM(spe.name) FROM switches s WHERE s.equipment = e.equipment) ");
		sqlb.append("    WHEN 'L' THEN 'WLAN ' ");
		sqlb.append("ELSE '?' ");
		sqlb.append("END equname, ");
		sqlb.append("d.state docstate, d.isautodoc ");
		sqlb.append(
			"FROM asemblingacts aa, documents d, equipment e, storageplaces spe, positions p, storageplaces spp, outer organizations o ");
		sqlb.append(
			"WHERE aa.document = d.document AND aa.operationtype = 'D' ");
		sqlb.append("AND o.organization = d.owner ");
		sqlb.append("AND d.to = e.equipment AND p.storageplace = e.position ");
		sqlb.append(
			"AND spe.storageplace = e.equipment AND p.storageplace = spp.storageplace ");

		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isDate != null && isDate.booleanValue()) {
			if (startDate != null && endDate != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(startDate);
				params.add(endDate);
			}
		}
		if (isPosition != null && isPosition.booleanValue()) {
			if (argPosition != null) {
				sqlb.append("AND p.storageplace = ? ");
				params.add(argPosition);
			} else {
				sqlb.append("AND p.storageplace IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listDemountBlocksItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append("WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка актов демонтажа на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listDemountDocuments(
		Boolean isOwner,
		Integer argOwner,
		Boolean isDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean isPosition,
		Integer argPosition,
		String actType,
		Integer argOrg,
		Integer argWorker,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, TRIM(d.blanknumber) blanknumber, TRIM(o.name) ownername, ");
		sqlb.append(
			"NVL('D'||p.gsmid|| ' ','') || NVL('A'||p.dampsid|| ' ','') || TRIM(spp.name) posname, ");
		sqlb.append("CASE spe.type ");
		sqlb.append(
			"    WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = equ.equipment) ");
		sqlb.append(
			"    WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM(spe.name) FROM comequipment ce WHERE ce.equipment = equ.equipment) ");
		sqlb.append("    WHEN 'E' THEN TRIM(spe.name) ");
		sqlb.append(
			"    WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = equ.equipment) ");
		sqlb.append(
			"    WHEN 'R' THEN (SELECT TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = equ.equipment AND rp.resource = r.resource) ");
		sqlb.append(
			"    WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = equ.equipment) ");
		sqlb.append(
			"    WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || spe.name FROM switches s WHERE s.equipment = equ.equipment) ");
		sqlb.append("    WHEN 'L' THEN 'WLAN ' ");
		sqlb.append("    ELSE '?' ");
		sqlb.append("END equname, ");
		sqlb.append(
			"(SELECT TRIM(name) FROM organizations WHERE organization = exp.organization) orgto, ");
		sqlb.append(
			"(SELECT TRIM(TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)) FROM workers w, people p WHERE p.man = w.man AND w.worker = exp.expeditor) workerto, ");
		sqlb.append("d.state docstate, d.isautodoc ");
		sqlb.append(
			"FROM internaloutbill io, documents d, organizations o, storageplaces spe, equipment equ, positions p, storageplaces spp, expedition exp ");
		sqlb.append(
			"WHERE io.document = d.document AND d.showtouser = 'Y' AND d.from = equ.equipment AND equ.equipment = spe.storageplace AND equ.position = p.storageplace AND o.organization = d.owner ");
		sqlb.append(
			"AND spp.storageplace = p.storageplace AND d.to = exp.expedition AND d.type = 'N' ");

		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isDate != null && isDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (isPosition != null && isPosition.booleanValue()) {
			if (argPosition != null) {
				sqlb.append("AND p.storageplace = ? ");
				params.add(argPosition);
			} else {
				sqlb.append("AND p.storageplace IS NULL ");
			}
		}

		if (actType != null && "P".equals(actType)) {
			if (argOrg != null) {
				sqlb.append("AND exp.organization = ? ");
				params.add(argOrg);
			} else {
				sqlb.append("AND exp.organization IS NULL ");
			}
		}
		if (actType != null && "W".equals(actType)) {
			if (argWorker != null) {
				sqlb.append("AND exp.expeditor = ? ");
				params.add(argWorker);
			} else {
				sqlb.append("AND exp.expeditor IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listDemountItems(Integer argDocument, Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append("WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Поиск актов инвентаризации для подрядчика/сотрудника
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listExpeditionInventoryDocuments(
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean isOwner,
		Integer argOwner,
		Boolean isWorkers,
		Integer argWorker,
		Boolean isOrg,
		Integer argOrg,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			// "SELECT d.document, d.blankdate, d.blankindex, d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') docnumber,  ");
			"SELECT d.document, d.blankdate, d.blankindex, TRIM(d.blanknumber) docnumber,  ");
		sqlb.append(
			"(SELECT TRIM(TRIM(p.lastname) || ' ' || SUBSTR(p.firstname,1,1) || '. ' || SUBSTR(p.middlename,1,1) || '.') FROM workers w, people p WHERE p.man = w.man AND w.worker = d.storagemanager) smanname, ");
		sqlb.append("sps.name spsname, i13.type, d.state, d.isautodoc ");
		sqlb.append(
			"FROM i13nact i13, documents d, storageplaces sps, expedition ex ");
		sqlb.append(
			"WHERE i13.document = d.document AND d.showtouser = 'Y' AND d.from = sps.storageplace AND sps.type = 'X' ");
		sqlb.append(" AND d.from = ex.expedition ");

		if (argDateFrom != null && argDateTo != null) {
			sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
			params.add(argDateFrom);
			params.add(argDateTo);
		}
		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isWorkers != null && isWorkers.booleanValue()) {
			if (argWorker != null) {
				sqlb.append("AND ex.expeditor = ? ");
				params.add(argWorker);
			} else {
				sqlb.append("AND ex.expeditor IS NULL ");
			}
		}
		if (isOrg != null && isOrg.booleanValue()) {
			if (argOrg != null) {
				sqlb.append("AND ex.organization = ? ");
				params.add(argOrg);
			} else {
				sqlb.append("AND ex.organization IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка внутренних расходных накладных на складе.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listExternalStorageInDocuments(
		Boolean useStorage,
		Integer argStorage,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean useCordocnum,
		String argCordocnum,
		Boolean useOwner,
		Integer argOwner,
		Boolean useSupplier,
		Integer argSupplier,
		Boolean dacts,
		Boolean isAdmin,
		String username,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, d.blanknumber, ");
		sqlb.append("iwb.cordocdate, iwb.cordocnum, ");
		sqlb.append("co.name contragentname, TRIM(sps.name) toname, ");
		sqlb.append("d.state, iwb.dactnumber ");
		if (dacts != null && dacts.booleanValue()) {
			sqlb.append(", iwb.dactdate, ");
			sqlb.append(
				"(SELECT 'Y' FROM inwaybills WHERE dacttext IS NOT NULL AND document = d.document) fileflag ");
		}
		sqlb.append(
			"FROM inwaybills iwb, documents d, outer organizations co, storageplaces sps ");
		sqlb.append(
			"WHERE iwb.document = d.document AND d.contragent = co.organization AND sps.storageplace = d.to ");

		if (isAdmin == null || !isAdmin.booleanValue()) {
			sqlb.append("AND sps.storageplace IN ");
			sqlb.append(
				"(SELECT s.storageplace FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? AND ra.viewfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}

		if (useCordocnum != null && useCordocnum.booleanValue()) {
			if (argCordocnum != null) {
				sqlb.append("AND iwb.cordocnum = ? ");
				params.add(argCordocnum);
			}
		}

		if (useOwner != null && useOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}

		if (argDateFrom != null && argDateTo != null) {
			sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
			params.add(argDateFrom);
			params.add(argDateTo);
		}

		if (useStorage != null && useStorage.booleanValue()) {
			if (argStorage != null) {
				sqlb.append("AND sps.storageplace = ? ");
				params.add(argStorage);
			} else {
				sqlb.append("AND sps.storageplace IS NULL ");
			}
		}

		if (useSupplier.booleanValue()) {
			sqlb.append("AND co.organization = ? ");
			params.add(argSupplier);
		}

		if (dacts != null && dacts.booleanValue()) {
			sqlb.append("AND iwb.dactnumber IS NOT NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
				case 5 :
					sqlb.append("ORDER BY iwb.cordocnum ASC ");
					break;
				case 6 :
					sqlb.append("ORDER BY iwb.cordocnum DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listExternalStorageInItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT odp.outerdocposition odpid, odp.order, r.name, r.model, odp.configuration, odp.outerqty docqty, u.shortname, odp.outerprice docprice, ");
		sqlb.append("r.countpolicy policy, ");
		sqlb.append("CASE r.countpolicy ");
		sqlb.append(
			"WHEN 'S' THEN (SELECT count(docposition) FROM inwaybillspos WHERE outerdocposition = odp.outerdocposition) ");
		sqlb.append(
			"ELSE (SELECT sum(dp1.qty) FROM docpositions dp1, inwaybillspos iwp1 WHERE iwp1.outerdocposition = odp.outerdocposition AND dp1.docposition = iwp1.docposition) ");
		sqlb.append("END factqty, ");
		sqlb.append(
			"(SELECT max(dp.price) FROM inwaybillspos iwp, docpositions dp WHERE iwp.outerdocposition = odp.outerdocposition AND iwp.docposition = dp.docposition) factprice, ");
		sqlb.append(
			"(SELECT max(sourceprice) FROM inwaybillspos WHERE outerdocposition = odp.outerdocposition) factsrcprice ");
		sqlb.append("FROM outerdocpositions odp, resources r, units u ");
		sqlb.append("WHERE odp.resource = r.resource AND u.unit = r.unit ");

		if (argDocument != null) {
			sqlb.append("AND odp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND odp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY odp.order ASC ");
					break;
			}
		}

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка внутренних расходных накладных на складе.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listExternalStorageOutDocuments(
		Boolean useDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean useOwner,
		Integer argOwner,
		Boolean useStorage,
		Integer argStorage,
		Boolean useOrganization,
		Integer argOrganization,
		Boolean isAdmin,
		String username,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, d.blanknumber, TRIM(o.name) ownername, d.isautodoc, ");
		sqlb.append("d.from, TRIM(sp.name) fromname, ");
		sqlb.append(
			"d.to, NVL(TRIM(oe.name), TRIM(pe.lastname) || ' ' || TRIM(pe.firstname) || ' ' || TRIM(pe.middlename)) toname, ");
		sqlb.append("d.state docstate, ");
		sqlb.append(
			"(SELECT count(docposition) FROM docpositions WHERE document = d.document) poscount ");
		sqlb.append(
			"FROM documents d, outwaybills owb, outer organizations o, storageplaces sp, ");
		sqlb.append(
			"expedition e, outer organizations oe, outer (workers we, people pe)  ");
		sqlb.append(
			"WHERE d.type = 'O' AND owb.document = d.document AND d.owner = o.organization ");
		sqlb.append(
			"AND d.to = e.expedition AND e.organization = oe.organization AND e.expeditor = we.worker AND we.man = pe.man ");
		sqlb.append("AND d.from = sp.storageplace ");

		if (isAdmin == null || !isAdmin.booleanValue()) {
			sqlb.append("AND sp.storageplace IN ");
			sqlb.append(
				"(SELECT s.storageplace FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? AND ra.viewfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}

		if (useOwner != null && useOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (useDate != null && useDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (useStorage != null && useStorage.booleanValue()) {
			if (argStorage != null) {
				sqlb.append("AND sp.storageplace = ? ");
				params.add(argStorage);
			} else {
				sqlb.append("AND sps.storageplace IS NULL ");
			}
		}
		if (useOrganization.booleanValue()) {
			sqlb.append("AND e.organization = ? ");
			params.add(argOrganization);
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка внутренних расходных накладных на складе.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listExternalStorageOutDocuments(
		Boolean useDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean useOwner,
		Integer argOwner,
		Boolean useStorage,
		Integer argStorage,
		Boolean useOrganization,
		Integer argOrganization,
		Integer order) {
		return listExternalStorageOutDocuments(
			useDate,
			argDateFrom,
			argDateTo,
			useOwner,
			argOwner,
			useStorage,
			argStorage,
			useOrganization,
			argOrganization,
			Boolean.TRUE,
			"",
			order);
	}
	public CDBCResultSet listExternalStorageOutItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, dp.qty, u.shortname uname, dp.price, dp.qty*dp.price summ, dp.resource, r.name, r.model, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, dp.inventserial manufserial, dp.configuration, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append(
			"FROM docpositions dp, documents d, resources r, outer units u ");
		sqlb.append(
			"WHERE dp.document = d.document AND d.type = 'O' AND r.resource = dp.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
			}
		}

		//System.out.println("SQL:\n"+sqlb.toString()+"\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка внутренних приходных накладных на складе.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listInternalStorageInDocuments(
		Boolean useDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean useOwner,
		Integer argOwner,
		Boolean useStorage,
		Integer argStorage,
		Boolean useOrganization,
		Integer argOrganization,
		Boolean useWorker,
		Integer argWorker,
		Boolean isAdmin,
		String username,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, TRIM(d.blanknumber) blanknumber, d.state docstate, d.isautodoc, ");
		sqlb.append(
			"NVL(o1.shortname, o1.name) ownername, FormatPositionName(ib.position) posname, ");
		sqlb.append(
			"TRIM(sps.name) storagename, NVL(TRIM(o.name), TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)) fromname ");
		sqlb.append(
			"FROM internalwaybills ib, documents d, storageplaces sps, expedition e, organizations o1, outer organizations o, outer (workers w, people p) ");
		sqlb.append(
			"WHERE ib.document = d.document AND d.showtouser = 'Y' AND d.to = sps.storageplace AND e.expedition = d.from AND o1.organization = d.owner AND ");
		sqlb.append(
			"o.organization = e.organization AND p.man = w.man AND w.worker = e.expeditor AND sps.type='S' ");

		if (isAdmin == null || !isAdmin.booleanValue()) {
			sqlb.append("AND sps.storageplace IN ");
			sqlb.append(
				"(SELECT s.storageplace FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? AND ra.viewfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}

		if (useOwner != null && useOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (useDate != null && useDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (useStorage != null && useStorage.booleanValue()) {
			if (argStorage != null) {
				sqlb.append("AND sps.storageplace = ? ");
				params.add(argStorage);
			} else {
				sqlb.append("AND sps.storageplace IS NULL ");
			}
		}
		if (useOrganization.booleanValue()) {
			sqlb.append("AND e.organization = ? ");
			params.add(argOrganization);
		}
		if (useWorker.booleanValue()) {
			sqlb.append("AND e.expeditor = ? ");
			params.add(argWorker);
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка внутренних приходных накладных на складе.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listInternalStorageInDocuments(
		Boolean useDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean useOwner,
		Integer argOwner,
		Boolean useStorage,
		Integer argStorage,
		Boolean useOrganization,
		Integer argOrganization,
		Boolean useWorker,
		Integer argWorker,
		Integer order) {
		return listInternalStorageInDocuments(
			useDate,
			argDateFrom,
			argDateTo,
			useOwner,
			argOwner,
			useStorage,
			argStorage,
			useOrganization,
			argOrganization,
			useWorker,
			argWorker,
			Boolean.TRUE,
			"",
			order);
	}
	/**
	 * Возвращает набор данных для списка строк внутренний приходной накладной на складе.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listInternalStorageInItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, iwp.docqty, dp.qty, u.shortname uname, dp.price, dp.qty*dp.price summ, dp.resource, r.name, r.model, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, dp.inventserial manufserial, dp.configuration, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append(
			"FROM docpositions dp, inlwbillspos iwp, resources r, outer units u ");
		sqlb.append(
			"WHERE dp.docposition = iwp.docposition AND r.resource = dp.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
			}
		}

		//System.out.println("SQL:\n"+sqlb.toString()+"\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка внутренних расходных накладных на складе.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listInternalStorageOutDocuments(
		Boolean useDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean useOwner,
		Integer argOwner,
		Boolean useStorage,
		Integer argStorage,
		Boolean useOrganization,
		Integer argOrganization,
		Boolean useWorker,
		Integer argWorker,
		Boolean isAdmin,
		String username,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, TRIM(d.blanknumber) blanknumber, d.state docstate, d.isautodoc, ");
		sqlb.append(
			"NVL(o1.shortname, o1.name) ownername, FormatPositionName(ib.position) posname, ");
		sqlb.append(
			"TRIM(sps.name) storagename, NVL(TRIM(o.name), TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)) toname ");
		sqlb.append(
			"FROM internaloutbill ib, documents d, storageplaces sps, expedition e, organizations o1, outer organizations o, outer (workers w, people p) ");
		sqlb.append(
			"WHERE ib.document = d.document AND d.showtouser = 'Y' AND d.from = sps.storageplace AND e.expedition = d.to AND o1.organization = d.owner AND ");
		sqlb.append(
			"o.organization = e.organization AND p.man = w.man AND w.worker = e.expeditor AND sps.type='S' ");

		if (isAdmin == null || !isAdmin.booleanValue()) {
			sqlb.append("AND sps.storageplace IN ");
			sqlb.append(
				"(SELECT s.storageplace FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? AND ra.viewfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}

		if (useOwner != null && useOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (useDate != null && useDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (useStorage != null && useStorage.booleanValue()) {
			if (argStorage != null) {
				sqlb.append("AND sps.storageplace = ? ");
				params.add(argStorage);
			} else {
				sqlb.append("AND sps.storageplace IS NULL ");
			}
		}
		if (useOrganization.booleanValue()) {
			sqlb.append("AND e.organization = ? ");
			params.add(argOrganization);
		}
		if (useWorker.booleanValue()) {
			sqlb.append("AND e.expeditor = ? ");
			params.add(argWorker);
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка внутренних расходных накладных на складе.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listInternalStorageOutDocuments(
		Boolean useDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean useOwner,
		Integer argOwner,
		Boolean useStorage,
		Integer argStorage,
		Boolean useOrganization,
		Integer argOrganization,
		Boolean useWorker,
		Integer argWorker,
		Integer order) {
		return listInternalStorageOutDocuments(
			useDate,
			argDateFrom,
			argDateTo,
			useOwner,
			argOwner,
			useStorage,
			argStorage,
			useOrganization,
			argOrganization,
			useWorker,
			argWorker,
			Boolean.TRUE,
			"",
			order);
	}
	/**
	 * Возвращает набор данных для списка строк внутренний приходной накладной на складе.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listInternalStorageOutItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, dp.qty, u.shortname uname, dp.price, dp.qty*dp.price summ, dp.resource, r.name, r.model, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, dp.inventserial manufserial, dp.configuration, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append(
			"FROM docpositions dp, documents d, resources r, outer units u ");
		sqlb.append(
			"WHERE dp.document = d.document AND d.type = 'N' AND r.resource = dp.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
			}
		}

		//System.out.println("SQL:\n"+sqlb.toString()+"\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка актов монтажа блоков на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listMountBlocksDocuments(
		Boolean isDate,
		java.sql.Date startDate,
		java.sql.Date endDate,
		Boolean isOwner,
		Integer argOwner,
		Boolean isPosition,
		Integer argPosition,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, TRIM(d.blanknumber) blanknumber, TRIM(o.name) ownername, ");
		sqlb.append(
			"NVL('D'||p.gsmid|| ' ','') || NVL('A'||p.dampsid|| ' ','') || TRIM(spp.name) posname, ");
		sqlb.append("CASE spe.type ");
		sqlb.append(
			"    WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || TRIM(bs.name) FROM basestations bs WHERE bs.equipment = e.equipment) ");
		sqlb.append(
			"    WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM(spe.name) FROM comequipment ce WHERE ce.equipment = e.equipment) ");
		sqlb.append("    WHEN 'E' THEN TRIM(spe.name) ");
		sqlb.append(
			"    WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = e.equipment) ");
		sqlb.append(
			"    WHEN 'R' THEN (SELECT TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = e.equipment AND rp.resource = r.resource) ");
		sqlb.append(
			"    WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = e.equipment) ");
		sqlb.append(
			"    WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || TRIM(spe.name) FROM switches s WHERE s.equipment = e.equipment) ");
		sqlb.append("    WHEN 'L' THEN 'WLAN ' ");
		sqlb.append("ELSE '?' ");
		sqlb.append("END equname, ");
		sqlb.append("d.state docstate, d.isautodoc ");
		sqlb.append(
			"FROM asemblingacts aa, documents d, equipment e, storageplaces spe, positions p, storageplaces spp, outer organizations o ");
		sqlb.append(
			"WHERE aa.document = d.document AND aa.operationtype = 'A' ");
		sqlb.append("AND o.organization = d.owner ");
		sqlb.append("AND d.to = e.equipment AND p.storageplace = e.position ");
		sqlb.append(
			"AND spe.storageplace = e.equipment AND p.storageplace = spp.storageplace ");

		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isDate != null && isDate.booleanValue()) {
			if (startDate != null && endDate != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(startDate);
				params.add(endDate);
			}
		}
		if (isPosition != null && isPosition.booleanValue()) {
			if (argPosition != null) {
				sqlb.append("AND p.storageplace = ? ");
				params.add(argPosition);
			} else {
				sqlb.append("AND p.storageplace IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listConfigEqDocuments() {
		CDBCResultSet res = new CDBCResultSet();
		return res;
	}
	
	/**
	 * Возвращает набор строк для актов монтажа блоков на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listMountBlocksItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append("WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка актов монтажа на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listMountDocuments(
		Boolean isOwner,
		Integer argOwner,
		Boolean isDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean isPosition,
		Integer argPosition,
		String actType,
		Integer argOrg,
		Integer argWorker,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.visualtype, d.prjstatus, d.blankdate, d.blankindex, TRIM(d.blanknumber) blanknumber, TRIM(o.name) ownername, ");
		sqlb.append(
			"NVL('D'||p.gsmid|| ' ','') || NVL('A'||p.dampsid|| ' ','') || TRIM(spp.name) posname, ");
		sqlb.append("CASE spe.type ");
		sqlb.append(
			"    WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = equ.equipment) ");
		sqlb.append(
			"    WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM(spe.name) FROM comequipment ce WHERE ce.equipment = equ.equipment) ");
		sqlb.append("    WHEN 'E' THEN TRIM(spe.name) ");
		sqlb.append(
			"    WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = equ.equipment) ");
		sqlb.append(
			"    WHEN 'R' THEN (SELECT TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = equ.equipment AND rp.resource = r.resource) ");
		sqlb.append(
			"    WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = equ.equipment) ");
		sqlb.append(
			"    WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || spe.name FROM switches s WHERE s.equipment = equ.equipment) ");
		sqlb.append("    WHEN 'L' THEN 'WLAN ' ");
		sqlb.append("    ELSE '?' ");
		sqlb.append("END equname, ");
		sqlb.append(
			"(SELECT TRIM(name) FROM organizations WHERE organization = exp.organization) orgto, ");
		sqlb.append(
			"(SELECT TRIM(TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)) FROM workers w, people p WHERE p.man = w.man AND w.worker = exp.expeditor) workerto, ");
		sqlb.append("d.state docstate, d.isautodoc ");
		sqlb.append(
			"FROM internalwaybills iw, documents d, organizations o, storageplaces spe, equipment equ, positions p, storageplaces spp, expedition exp ");
		sqlb.append(
			"WHERE iw.document = d.document AND d.showtouser = 'Y' AND d.to = equ.equipment AND equ.equipment = spe.storageplace AND equ.position = p.storageplace AND o.organization = d.owner ");
		sqlb.append(
			"AND spp.storageplace = p.storageplace AND d.from = exp.expedition AND d.type = 'T' ");

		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isDate != null && isDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (isPosition != null && isPosition.booleanValue()) {
			if (argPosition != null) {
				sqlb.append("AND p.storageplace = ? ");
				params.add(argPosition);
			} else {
				sqlb.append("AND p.storageplace IS NULL ");
			}
		}

		if (actType != null && "P".equals(actType)) {
			if (argOrg != null) {
				sqlb.append("AND exp.organization = ? ");
				params.add(argOrg);
			} else {
				sqlb.append("AND exp.organization IS NULL ");
			}
		}
		if (actType != null && "W".equals(actType)) {
			if (argWorker != null) {
				sqlb.append("AND exp.expeditor = ? ");
				params.add(argWorker);
			} else {
				sqlb.append("AND exp.expeditor IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	public CDBCResultSet listMountItems(Integer argDocument, Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.resource, dp.comment, dp.serialnumber, dp.type, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append(
			"WHERE dp.resource = r.resource AND r.unit = u.unit AND dp.agregate IS NULL ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	
	public CDBCResultSet listAllMountItems(Integer argDocument, Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.visualtagid, dp.resource, dp.comment, dp.serialnumber, dp.type, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append(
			"WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	
	public static CDBCResultSet listMountItemsAgregated(
		Integer argDocument,
		Integer argAgregatedocpos,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.type, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.resource, r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append("WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		if (argAgregatedocpos != null) {
			sqlb.append("AND dp.agregate = ? ");
			params.add(argAgregatedocpos);
		} else {
			sqlb.append("AND dp.agregate IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listPayoffItems(Integer argDocument, Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append("WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает набор данных для списка актов демонтажа на позиции.
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listPositionDisasmDocuments(
		Boolean useOwner,
		Integer argOwner,
		Boolean usePosition,
		Integer argPosition,
		Boolean useDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, TRIM(d.blanknumber) blanknumber, TRIM(o.name) ownername, ");
		sqlb.append(
			"NVL('D'||p.gsmid|| ' ','') || NVL('A'||p.dampsid|| ' ','') || TRIM(spp.name) posname, ");
		sqlb.append("CASE spe.type ");
		sqlb.append(
			"WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = equ.equipment) ");
		sqlb.append(
			"WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM(spe.name) FROM comequipment ce WHERE ce.equipment = equ.equipment) ");
		sqlb.append("WHEN 'E' THEN TRIM(spe.name) ");
		sqlb.append(
			"WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = equ.equipment) ");
		sqlb.append(
			"WHEN 'R' THEN (SELECT 'Репитер ' || TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = equ.equipment AND rp.resource = r.resource) ");
		sqlb.append(
			"WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = equ.equipment) ");
		sqlb.append(
			"WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || spe.name FROM switches s WHERE s.equipment = equ.equipment) ");
		sqlb.append("WHEN 'L' THEN 'WLAN ' ");
		sqlb.append("ELSE '?' ");
		sqlb.append("END equname, ");
		//	sqlb.append("(SELECT TRIM(name) FROM organizations WHERE organization = exp.organization) orgto, ");
		//	sqlb.append("(SELECT TRIM(TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)) FROM workers w, people p WHERE p.man = w.man AND w.worker = exp.expeditor) workerto, ");
		sqlb.append("d.state docstate, d.isautodoc ");
		sqlb.append(
			"FROM asemblingacts aa, documents d, organizations o, storageplaces spe, equipment equ, positions p, storageplaces spp, expedition exp ");
		sqlb.append(
			"WHERE aa.document = d.document AND aa.operationtype = 'D' AND d.showtouser = 'Y' AND d.from = equ.equipment AND equ.equipment = spe.storageplace AND equ.position = p.storageplace AND o.organization = d.owner ");
		sqlb.append(
			"AND spp.storageplace = p.storageplace AND d.to = exp.expedition ");

		if (useOwner != null && useOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (useDate != null && useDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (usePosition != null && usePosition.booleanValue()) {
			if (argPosition != null) {
				sqlb.append("AND p.storageplace = ? ");
				params.add(argPosition);
			} else {
				sqlb.append("AND p.storageplace IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listPositionInventoryDocuments(
		Boolean isDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean isOwner,
		Integer argOwner,
		Boolean isPosition,
		Integer argPosition,
		Boolean isEquipment,
		Integer argEquipment,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			// "SELECT d.document, d.blankdate docdate, d.blankindex, d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') docnumber, ");
			"SELECT d.document, d.blankdate docdate, d.blankindex, TRIM(d.blanknumber) docnumber, ");
		sqlb.append(
			"d.storagemanager sman, (SELECT TRIM(TRIM(p.lastname) || ' ' || SUBSTR(p.firstname,1,1) || '. ' || SUBSTR(p.middlename,1,1) || '.') FROM workers w, people p WHERE p.man = w.man AND w.worker = d.storagemanager) smanname, ");
		//		(SELECT TRIM(TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)) FROM workers w, people p WHERE p.man = w.man AND w.worker = d.storagemanager) smanname, 
		sqlb.append(
			"i13.techstuff tech, (SELECT TRIM(TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename)) FROM workers w, people p WHERE p.man = w.man AND w.worker = i13.techstuff) techname, ");
		sqlb.append(
			"i13.type, d.state, d.isautodoc, p.storageplace pos, NVL('D'||p.gsmid|| ' ','') || NVL('A'||p.dampsid|| ' ','') || TRIM(spp.name) posname, ");
		sqlb.append("d.from equ, spe.type equtype, ");
		sqlb.append("CASE spe.type ");
		sqlb.append(
			"WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = equ.equipment) ");
		sqlb.append(
			"WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' || ' ' || TRIM(spe.name) WHEN 'O' THEN 'ВО ' || ' ' || TRIM(spe.name) || NVL(' (' || TRIM(ce.osinvname) || ')','') ELSE ' ' || TRIM(spe.name) END FROM comequipment ce WHERE ce.equipment = equ.equipment) ");
		sqlb.append("WHEN 'E' THEN TRIM(spe.name) ");
		sqlb.append(
			"WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = equ.equipment) ");
		sqlb.append(
			"WHEN 'R' THEN (SELECT TRIM(r.model) || ' ' || rp.number FROM repiters rp, resources r WHERE rp.equipment = equ.equipment AND rp.resource = r.resource) ");
		sqlb.append(
			"WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = equ.equipment) ");
		sqlb.append(
			"WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || spe.name FROM switches s WHERE s.equipment = equ.equipment) ");
		sqlb.append("WHEN 'L' THEN 'WLAN ' ");
		sqlb.append("ELSE '?' ");
		sqlb.append("END equname ");
		sqlb.append(
			"FROM i13nact i13, documents d, equipment equ, positions p, storageplaces spp, storageplaces spe ");
		sqlb.append(
			"WHERE i13.document = d.document AND d.showtouser = 'Y' AND d.from = equ.equipment AND equ.position = p.storageplace AND p.storageplace = spp.storageplace AND equ.equipment = spe.storageplace ");

		if (isDate != null && isDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isPosition != null && isPosition.booleanValue()) {
			if (isEquipment != null && isEquipment.booleanValue()) {
				if (argEquipment != null) {
					sqlb.append("AND d.from = ? ");
					params.add(argEquipment);
				} else {
					sqlb.append("AND d.from IS NULL ");
				}
			} else {
				if (argPosition != null) {
					sqlb.append("AND p.storageplace = ? ");
					params.add(argPosition);
				} else {
					sqlb.append("AND p.storageplace IS NULL ");
				}
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listPositionInventoryItems(
		Integer document,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.owner, dp.order, r.resource res, r.countpolicy, ");
		sqlb.append(
			"TRIM(r.name) resname, TRIM(r.model) resmodel, TRIM(dp.configuration) resconfig, ");
		sqlb.append(
			"'show invnum' serialnumber, TRIM(dp.party) party, TRIM(dp.inventserial) manufserial, serial_for_docpos(dp.docposition) invnum, ");
		sqlb.append(
			"dp.qty, dp.price, dp.qty * dp.price sum, TRIM(u.shortname) usn, TRIM(dp.newplace) place ");
		sqlb.append(
			"FROM i13actpos i13p, docpositions dp, resources r, outer units u ");
		sqlb.append(
			"WHERE i13p.docposition = dp.docposition AND dp.resource = r.resource AND r.unit = u.unit ");
		if (document != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(document);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}
		sqlb.append("ORDER BY order ASC ");

		/*
		if(order != null && !"".equals(order.trim())) {
			sqlb.append("ORDER BY ");
			sqlb.append(order.trim());
		}
		*/
		//System.out.println("SQL:\n"+sqlb.toString()+"\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listRequestDocuments(
		Boolean useDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
	// Период
	Boolean useDivision, Integer division, // Подразделение
	Boolean usePosition, Integer position, // Позиция position
	String requestType,
	// Тип требования, A - все требования, P - дляподрядчика, W - для сотрудника
	Boolean useOrganization, Integer organization, // Если выбран тип P и
	Boolean useWorker, Integer worker, Boolean hasNoLink, Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT req.document, d.blankdate, d.blankindex, d.blanknumber, ");
		sqlb.append(
			"NVL(TRIM(eo.name),(SELECT TRIM(TRIM(p.lastname) || ' ' || NVL(SUBSTR(p.firstname,1,1) || '. ','') || NVL(SUBSTR(p.middlename,1,1)||'.','')) FROM people p WHERE p.man = ew.man)) expedition, ");
		sqlb.append(
			"NVL('D'||p.gsmid|| ' ','') || NVL('A'||p.dampsid|| ' ','') || TRIM(sp.name) posname, ");
		sqlb.append("req.requeststate, d.state docstate, d.isautodoc ");
		sqlb.append(
			"FROM requests req, documents d, outer (positions p, storageplaces sp), ");
		sqlb.append("expedition ex, outer organizations eo, outer workers ew ");
		sqlb.append("WHERE req.document = d.document ");
		sqlb.append(
			"AND ex.expedition = d.from AND ex.expeditor = ew.worker AND ex.organization = eo.organization ");
		sqlb.append(
			"AND p.storageplace = req.position AND sp.storageplace = p.storageplace ");

		if (useDate != null && useDate.booleanValue()) {
			if (datefrom != null && dateto != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(datefrom);
				params.add(dateto);
			}
		}
		if (useDivision != null && useDivision.booleanValue()) {
			if (division != null) {
				sqlb.append("AND req.divisionrequester = ? ");
				params.add(division);
			} else {
				sqlb.append("AND req.divisionrequester IS NULL ");
			}
		}
		if (usePosition != null && usePosition.booleanValue()) {
			if (position != null) {
				sqlb.append("AND req.position = ? ");
				params.add(position);
			} else {
				sqlb.append("AND req.position IS NULL ");
			}
		}

		if (requestType != null && "P".equals(requestType)) {
			if (useOrganization.booleanValue()) {
				sqlb.append("AND ex.organization = ? ");
				params.add(organization);
			} else {
				sqlb.append("AND ex.organization IS NOT NULL ");
			}
		} else if (requestType != null && "P".equals(requestType)) {
			if (useWorker.booleanValue()) {
				sqlb.append("AND ex.expeditor = ? ");
				params.add(worker);
			} else {
				sqlb.append("AND ex.expeditor IS NOT NULL ");
			}
		}

		if (hasNoLink.booleanValue()) {
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listRequestItems(Integer argDocument, Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname,  ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.notes, serial_for_docpos(dp.docposition) invnum, ");
		sqlb.append(
			"(SELECT NVL(SUM(dpq.qty),0.0) FROM docpositions dpq, docdependencies ddp, documents dq WHERE dpq.document = ddp.documentto AND dpq.document = dq.document AND dq.state = '2' AND ddp.type = 'O' AND ddp.documentfrom = dp.document AND dpq.resource = dp.resource) sendqty ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append("WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listStorageDemountDocuments(
		Boolean isDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean isOwner,
		Integer argOwner,
		Boolean isStorage,
		Integer argStorage,
		Boolean isAdmin,
		String username,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, d.blanknumber, o.name ownername, sps.name spsname, d.state docstate, d.isautodoc ");
		sqlb.append(
			"FROM asemblingacts asa, documents d, storageplaces sps, organizations o ");
		sqlb.append(
			"WHERE d.document = asa.document AND sps.storageplace = d.from AND sps.type = 'S' ");
		sqlb.append("AND o.organization = d.owner ");
		sqlb.append("AND asa.operationtype = 'D' ");

		if (isAdmin == null || !isAdmin.booleanValue()) {
			sqlb.append("AND sps.storageplace IN ");
			sqlb.append(
				"(SELECT s.storageplace FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? AND ra.viewfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}

		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isDate != null && isDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (isStorage != null && isStorage.booleanValue()) {
			if (argStorage != null) {
				sqlb.append("AND sps.storageplace = ? ");
				params.add(argStorage);
			} else {
				sqlb.append("AND sps.storageplace IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listStorageDemountItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append("WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * @TODO: Написать описание параметров
	 */
	public CDBCResultSet listStorageInventoryDocuments(
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean isOwner,
		Integer argOwner,
		Boolean isStorage,
		Integer argStorage,
		Boolean isAdmin,
		String username,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			// "SELECT d.document, d.blankdate, d.blankindex, d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') docnumber,  ");
			"SELECT d.document, d.blankdate, d.blankindex, TRIM(d.blanknumber) docnumber,  ");
		sqlb.append(
			"(SELECT TRIM(TRIM(p.lastname) || ' ' || SUBSTR(p.firstname,1,1) || '. ' || SUBSTR(p.middlename,1,1) || '.') FROM workers w, people p WHERE p.man = w.man AND w.worker = d.storagemanager) smanname, ");
		sqlb.append("sps.name spsname, i13.type, d.state, d.isautodoc ");
		sqlb.append("FROM i13nact i13, documents d, storageplaces sps ");
		sqlb.append(
			"WHERE i13.document = d.document AND d.showtouser = 'Y' AND d.from = sps.storageplace AND sps.type = 'S' ");

		if (argDateFrom != null && argDateTo != null) {
			sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
			params.add(argDateFrom);
			params.add(argDateTo);
		}
		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isStorage != null && isStorage.booleanValue()) {
			if (argStorage != null) {
				sqlb.append("AND d.from = ? ");
				params.add(argStorage);
			} else {
				sqlb.append("AND d.from IS NULL ");
			}
		}
		if (isAdmin != null && !isAdmin.booleanValue()) {
			sqlb.append("AND sps.storageplace IN ");
			sqlb.append(
				"(SELECT s.storageplace FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? AND ra.viewfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listStorageInventoryItems(
		Integer document,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.owner, dp.order, r.resource res, r.countpolicy, ");
		sqlb.append(
			"TRIM(r.name) resname, TRIM(r.model) resmodel, TRIM(dp.configuration) resconfig, ");
		sqlb.append(
			"'show invnum' serialnumber, TRIM(dp.party) party, TRIM(dp.inventserial) manufserial, serial_for_docpos(dp.docposition) invnum, ");
		sqlb.append(
			"dp.qty, dp.price, dp.qty * dp.price sum, TRIM(u.shortname) usn, TRIM(dp.newplace) place ");
		sqlb.append(
			"FROM i13actpos i13p, docpositions dp, resources r, outer units u ");
		sqlb.append(
			"WHERE i13p.docposition = dp.docposition AND dp.resource = r.resource AND r.unit = u.unit ");
		if (document != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(document);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}
		sqlb.append("ORDER BY order ASC ");

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listStorageMountDocuments(
		Boolean isDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean isOwner,
		Integer argOwner,
		Boolean isStorage,
		Integer argStorage,
		Boolean isAdmin,
		String username,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, d.blanknumber, o.name ownername, sps.name spsname, d.state docstate, d.isautodoc ");
		sqlb.append(
			"FROM asemblingacts asa, documents d, storageplaces sps, organizations o ");
		sqlb.append(
			"WHERE d.document = asa.document AND sps.storageplace = d.from AND sps.type = 'S' ");
		sqlb.append("AND o.organization = d.owner ");
		sqlb.append("AND asa.operationtype = 'A' ");

		if (isAdmin == null || !isAdmin.booleanValue()) {
			sqlb.append("AND sps.storageplace IN ");
			sqlb.append(
				"(SELECT s.storageplace FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? AND ra.viewfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}

		if (isDate != null && isDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isStorage != null && isStorage.booleanValue()) {
			if (argStorage != null) {
				sqlb.append("AND sps.storageplace = ? ");
				params.add(argStorage);
			} else {
				sqlb.append("AND sps.storageplace IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listStorageMountItems(
		Integer argDocument,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT dp.docposition, dp.order, TRIM(r.name) name, TRIM(r.model) model, TRIM(dp.configuration) configuration, dp.qty, dp.price, dp.price * dp.qty summ, TRIM(u.shortname) unitname, ");
		sqlb.append(
			"r.countpolicy, 'show invnum' serial, TRIM(dp.inventserial) manufserial, dp.party, dp.agregate, serial_for_docpos(dp.docposition) invnum ");
		sqlb.append("FROM docpositions dp, resources r, outer units u ");
		sqlb.append("WHERE dp.resource = r.resource AND r.unit = u.unit ");

		if (argDocument != null) {
			sqlb.append("AND dp.document = ? ");
			params.add(argDocument);
		} else {
			sqlb.append("AND dp.document IS NULL ");
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY dp.order ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY dp.order DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY name ASC, model ASC ");
					break;
				case 4 :
					sqlb.append("ORDER BY name DESC, model DESC ");
					break;
			}
		}
		System.out.println("SQL:\n" + sqlb.toString() + "\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listStoragePayoffDocuments(
		Boolean isDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		Boolean isOwner,
		Integer argOwner,
		Boolean isStorage,
		Integer argStorage,
		Boolean isAdmin,
		String username,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(
			"SELECT d.document, d.blankdate, d.blankindex, d.blanknumber, o.name ownername, sps.name spsname, d.state docstate, d.isautodoc ");
		sqlb.append(
			"FROM documents d, payoffacts po, organizations o, storageplaces sps ");
		sqlb.append(
			"WHERE d.document = po.document AND d.showtouser = 'Y' AND d.owner = o.organization AND d.from = sps.storageplace AND sps.type = 'S' ");

		if (isAdmin == null || !isAdmin.booleanValue()) {
			sqlb.append("AND sps.storageplace IN ");
			sqlb.append(
				"(SELECT s.storageplace FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? AND ra.viewfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}

		if (isDate != null && isDate.booleanValue()) {
			if (argDateFrom != null && argDateTo != null) {
				sqlb.append("AND d.blankdate BETWEEN ? AND ? ");
				params.add(argDateFrom);
				params.add(argDateTo);
			}
		}
		if (isOwner != null && isOwner.booleanValue()) {
			if (argOwner != null) {
				sqlb.append("AND d.owner = ? ");
				params.add(argOwner);
			}
		}
		if (isStorage != null && isStorage.booleanValue()) {
			if (argStorage != null) {
				sqlb.append("AND sps.storageplace = ? ");
				params.add(argStorage);
			} else {
				sqlb.append("AND sps.storageplace IS NULL ");
			}
		}

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankindex ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankindex DESC ");
					break;
				case 3 :
					sqlb.append("ORDER BY d.blankdate ASC, d.blankindex ASC ");
					break;
				case 4 :
					sqlb.append(
						"ORDER BY d.blankdate DESC, d.blankindex DESC ");
					break;
			}
		}
		//System.out.println("SQL:\n"+sqlb.toString()+"\n");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public CDBCResultSet listStoragesFor(Boolean isadmin, String username) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT sp.storageplace, TRIM(sp.name) spname, r.regname ");
		sqlb.append("FROM storageplaces sp, storages s, regions r ");
		sqlb.append(
			"WHERE sp.type = 'S' AND s.storageplace = sp.storageplace AND s.regionid = r.regionid ");
		if (isadmin == null || !isadmin.booleanValue()) {
			sqlb.append("AND sp.storageplace IN ");
			sqlb.append("(SELECT s.storageplace ");
			sqlb.append(
				"FROM regionsaccess ra, operators op, regions r, storages s ");
			sqlb.append(
				"WHERE ra.operatorid = op.operator AND op.loiginid = ? ");
			sqlb.append("AND ra.viewfact = 'Y' AND ra.editfact ='Y' ");
			sqlb.append(
				"AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid) ");
			sqlb.append("AND r.regionid = s.regionid) ");
			if (username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}
		sqlb.append("ORDER BY spname ASC ");
		//System.out.println("SQL:\n"+sqlb.toString());
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	public static boolean updateDocumentBulk(
		BigDecimal qty,
		Integer resource,
		Integer owner,
		Integer document) {
		boolean result = false;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		if (qty == null) {
			return result;
		}
		if (resource == null) {
			return result;
		}
		if (owner == null) {
			return result;
		}
		if (document == null) {
			return result;
		}

		sqlb.append(
			"UPDATE docpositions SET qty = qty + ? WHERE document = ? AND resource = ? AND owner = ? ");
		params.add(qty);
		params.add(document);
		params.add(resource);
		params.add(owner);
		CDBCResultSet res = new CDBCResultSet();
		result = res.executeUpdate(sqlb.toString(), params.toArray());
		return result;
	}
	public static boolean updateDocumentParty(
		BigDecimal qty,
		String party,
		Integer owner,
		Integer document) {
		boolean result = false;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		if (qty == null) {
			return result;
		}
		if (party == null || "".equals(party.trim())) {
			return result;
		}
		if (owner == null) {
			return result;
		}
		if (document == null) {
			return result;
		}

		sqlb.append(
			"UPDATE docpositions SET qty = qty + ? WHERE document = ? AND owner = ? AND party = ? ");
		params.add(qty);
		params.add(document);
		params.add(owner);
		params.add(party);
		CDBCResultSet res = new CDBCResultSet();
		result = res.executeUpdate(sqlb.toString(), params.toArray());
		return result;
	}
	
	private static final String FAULT_REPORT_LIST_SQL = 	" SELECT " + 
	" T1.blankdate as sql_so_blankdate, " + 
	" T1.blanknumber as sql_so_blanknumber, " + 
	" T1.state as sql_so_documentState, " + 
	" T1.document as sql_so_document, " + 
	" T1.owner as sql_so_owner, " + 
	" org.name as sql_so_owner_name, " +
	" T1.from as sql_position_from, " + 
	" stpl.name as sql_positionname_from, " +
	" T2.oldserial as sql_spnum, " + 
	" T2.oldresource as sql_resource_old, " + 
	" res.model as sql_resourcename_old, " +
	" T2.techstuff as sql_worker_id, " + 
	" wor.man as sql_man_id, " +
	" TRIM(ppl.lastname) || ' ' || TRIM(ppl.firstname) || ' ' || TRIM(ppl.middlename) as sql_workername, " +

	" ddep_d.documentto as sql_dassdoc, " +
	" int_doc_d.type as sql_dassacttype, " +
	" ddep_a.documentto as sql_assdoc, " +
	" int_doc_a.type as sql_assacttype " +

	" FROM documents  T1, faultreport  T2, " +
	" organizations org, " +
	" storageplaces stpl, " +
	" resources res, " +
	" workers wor, " +
	" people ppl " +
	
	" , OUTER (docdependencies ddep_d, documents int_doc_d) " +
	" , OUTER  (docdependencies ddep_a, documents int_doc_a) " +

	" WHERE T1.type = 'F' AND T1.document = T2.document " + 
	" 	AND T1.owner = org.organization " +
	" 	AND T1.from=stpl.storageplace " +
	" 	AND T2.oldresource=res.resource " +
	" 	AND T2.techstuff=wor.worker " +
	" 	AND wor.man=ppl.man " + // ;

	" 	AND (ddep_d.documentfrom = T1.document AND ddep_d.type = 'D') " + 
	" 	AND (ddep_d.documentto = int_doc_d.document) " + 
	" 	AND (ddep_a.documentfrom = T1.document AND ddep_a.type = 'M') " + 
	" 	AND (ddep_a.documentto = int_doc_a.document) " ; 
	
	public CDBCResultSet findByQBE(
		java.lang.Boolean useDate,
		java.sql.Date datefrom, 
		java.sql.Date dateto, 
		java.lang.Boolean useOwner,
		java.lang.Integer owner,
		java.lang.Boolean useDivision,
		java.lang.Integer division,
		java.lang.Boolean useWorker,
		java.lang.Integer worker,
		java.lang.Boolean usePosition,
		java.lang.Integer position, 
		java.lang.Boolean useResource,
		java.lang.Integer resource, 
		java.lang.Integer order	) {

          System.out.println("### CDBCDocument findByQBE Begin ");
	
		  StringBuffer sb = new StringBuffer(FAULT_REPORT_LIST_SQL);
		  LinkedList params = new LinkedList();
		  //get documents alias
		  String alias1 = "T1"; 
		  String alias2 = "T2"; 
    
			//calculate where clause
			StringBuffer whereClause = new StringBuffer( " " );
			if( useDate.booleanValue() ) {
				whereClause.append( " and "+alias1+".blankdate >= ? and "+alias1+".blankdate <= ? " );
				params.add(datefrom);
				params.add(dateto);
			}
			if( useOwner.booleanValue() ) {
				whereClause.append( " and "+alias1+".owner = ? " );
				params.add(owner);
			}
			if( useDivision.booleanValue() ) {
				whereClause.append( " and "+alias2+".vivision = ? " );
				params.add(division);
			}
			if( useWorker.booleanValue() ) {
				// BEE00000315
				// whereClause.append( " and exists (select e.* from expedition e where e.expedition="+alias1+".from and e.expeditor=?) " );
				whereClause.append( " and T2.techstuff =? " );
				params.add(worker);
			}
			if( usePosition.booleanValue() ) {
				whereClause.append( " and "+alias1+".to in (select e.equipment from equipment e where position = ?) " );
				params.add(position);
			}
			if( useResource.booleanValue() ) {
				whereClause.append( " and exists (select d.* from docpositions d where d.document="+alias1+".document and d.resource=?) " );
				params.add(resource);
			}

			sb.append(whereClause);
    
			//append order by clause
			String orderBy = null;
			switch( order.intValue() ) {
				case 1:
					orderBy = " T1.blanknumber " + " asc ";
					break;
				case 2:
					orderBy = " T1.blanknumber " + " desc ";
					break;
				case 3:
					orderBy = " T1.blankdate " + " asc " + " , " + " T1.blanknumber " + " asc ";
					break;
				case 4:
					orderBy = " T1.blankdate " + " desc " + " , " + " T1.blanknumber " + " asc ";
					break;
			}
			if (orderBy != null) {
				sb.append( " order by "+orderBy );
			}
	
			System.out.println( "### CDBCDocument findByQBE SQL clause = "+sb );
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sb.toString(), params.toArray());
		return res;
	}
	public static char getStoragePlaceType(Integer idComplect){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		
		sqlb.append("SELECT storageplaces.type FROM storageplaces WHERE storageplace = ?");
		params.add(idComplect);
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		
		ListIterator it = res.listIterator();
		char type = ' ';
		if (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			type = row.getColumn("type").asString().charAt(0);
		}

		return type;
	}
	public static char getBaseStationType(Integer idBS){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT basestations.type FROM basestations WHERE equipment = ?");
		params.add(idBS);
	
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
	
		ListIterator it = res.listIterator();
		char type = ' ';
		if (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			type = row.getColumn("type").asString().charAt(0);
		}
		return type;
	}
}


/*

SELECT 
-- T1.insuranceact, 
T1.blankdate as sql_so_blankdate, 
T1.blanknumber as sql_so_blanknumber, 
-- T1.parentdocument, 
-- T1.operator, 
-- T1.isautodoc, 
-- T1.blankindex, 
-- T1.processsource, 
-- T1.showtouser, 
T1.state as sql_so_documentState, 
-- T1.processdestination, 
-- T1.insurancedate, 
-- T1.insuranceman, 
-- T1.to2, 
T1.document as sql_so_document, 
-- T1.needapprove, 
-- T1.projectid, 
-- T1.prjstatus, 
-- T1.visualtype, 
T1.owner as sql_so_owner, 
org.name as sql_so_owner_name,
-- T1.to, 
-- T1.contragent, 
T1.from as sql_position_from, 
stpl.name as sql_positionname_from,
-- T1.storagemanager, 
-- T1.type, 
-- T2.agregateserial, 
-- T2.newserial, 
-- T2.eqplace, 
T2.oldserial as sql_spnum, 
-- T2.comment, 
-- T2.agregateresource, 
T2.oldresource as sql_resource_old, 
res.model as sql_resourcename_old,
-- T2.newresource, 
T2.techstuff as sql_worker_id, 
wor.man as sql_man_id,
TRIM(ppl.lastname) || ' ' || TRIM(ppl.firstname) || ' ' || TRIM(ppl.middlename) as sql_workername,
-- T2.oldagregate, 
-- T2.vivision, 
-- T2.storagecardfrom, 
-- T2.equipment 
ddep_d.documentto as sql_dassdoc,
int_doc_d.document as sql_dassacttype,
-- 'DB' as sql_dassacttype,
ddep_a.documentto as sql_assdoc,
int_doc_a.document as sql_assacttype
-- 'AB' as sql_assacttype

FROM documents  T1, faultreport  T2,
organizations org,
storageplaces stpl,
resources res,
workers wor,
people ppl
, OUTER docdependencies ddep_d 
, documents int_doc_d
-- , OUTER documents int_doc_d
, OUTER  docdependencies ddep_a 
, documents int_doc_a
-- , OUTER documents ind_doc_a

WHERE T1.type = 'F' AND T1.document = T2.document 
	AND T1.owner = org.organization
        AND T1.from=stpl.storageplace
	AND T2.oldresource=res.resource
        AND T2.techstuff=wor.worker
        AND wor.man=ppl.man
        AND ((ddep_d.documentfrom = T1.document AND ddep_d.type = 'D') AND (ddep_d.documentto = int_doc_d.document AND int_doc_d.type = 'N'))
        AND ((ddep_a.documentfrom = T1.document AND ddep_a.type = 'M') AND (ddep_a.documentto = int_doc_a.document AND int_doc_a.type = 'T'))

        
       
	
-- AND 1=1 and T1.blankdate >= mdy(9, 1, 2006)  and T1.blankdate <=  mdy(10, 1, 2006) 

-- order by 7 asc

-----------------------------------------

ddep_d.documentto as sql_dassdoc,
int_doc_d.type as sql_dassacttype,
-- 'DB' as sql_dassacttype,
ddep_a.documentto as sql_assdoc,
int_doc_a.type as sql_assacttype
-- 'AB' as sql_assacttype

FROM documents  T1, faultreport  T2,
organizations org,
storageplaces stpl,
resources res,
workers wor,
people ppl
, OUTER (docdependencies ddep_d, documents int_doc_d)
--, OUTER documents int_doc_d
, OUTER  (docdependencies ddep_a, documents int_doc_a)
--, OUTER documents ind_doc_a

WHERE T1.type = 'F' AND T1.document = T2.document 
	AND T1.owner = org.organization
        AND T1.from=stpl.storageplace
	AND T2.oldresource=res.resource
        AND T2.techstuff=wor.worker
        AND wor.man=ppl.man
--        AND ((ddep_d.documentfrom = T1.document AND ddep_d.type = 'D') AND (ddep_d.documentto = int_doc_d.document AND int_doc_d.type = 'N'))
--        AND ((ddep_a.documentfrom = T1.document AND ddep_a.type = 'M') AND (ddep_a.documentto = int_doc_a.document AND int_doc_a.type = 'T'))
        
        AND (ddep_d.documentfrom = T1.document AND ddep_d.type = 'D') 
        AND (ddep_d.documentto = int_doc_d.document) -- AND int_doc_d.type = 'N')
        AND (ddep_a.documentfrom = T1.document AND ddep_a.type = 'M') 
        AND (ddep_a.documentto = int_doc_a.document) -- AND int_doc_a.type = 'T')
	
  and T1.document = 411

*/
