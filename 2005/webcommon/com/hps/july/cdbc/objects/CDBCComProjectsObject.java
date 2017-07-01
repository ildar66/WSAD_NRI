package com.hps.july.cdbc.objects;

import java.util.LinkedList;
import java.util.ListIterator;

import com.hps.july.cdbc.lib.*;
import com.hps.july.persistence.BaseStationAccessBean;
import com.hps.july.persistence.PositionAccessBean;
import com.hps.july.persistence.RegionAccessBean;

/**
 * Объект для работы с проектами строительства БС.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCComProjectsObject {

	private java.lang.Integer projectid;
	private java.lang.String projectname;
	private boolean needapprove;

	/**
	 * CDBCPositionObject constructor comment.
	 */
	public CDBCComProjectsObject() {
		super();
	}

	/**
	 * Возвращает список проектов на строительство БС
	 *   в состоянии "исполняется" по указанному gsmid
	 */
	public CDBCResultSet findBSComProjects(Integer gsmid) {
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(
			"SELECT c.projectid, c.type, c.name "
				+ "FROM comprojects c, bsprojects b "
				+ "WHERE b.projectid = c.projectid AND b.gsmid = ? AND c.state = 1 "
				+ "ORDER BY c.projectid ",
			new Object[] { gsmid });
		return res;
	}

	/**
	 * Возвращает список проектов на строительство БС
	 *   в состоянии "исполняется" по указанному gsmid
	 */
	public static CDBCRowObject findByPrimaryKey(Integer projectId) {
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(
			"SELECT c.projectid, c.type, c.name "
				+ "FROM comprojects c, bsprojects b "
				+ "WHERE b.projectid = c.projectid AND b.projectid = ? ",
			new Object[] { projectId });
		java.util.ListIterator it = res.listIterator();
		if (it.hasNext()) {
			ro = (CDBCRowObject)it.next();
		}
		return ro;
	}

	/**
	 * Форматирование названия проекта на строительство БС
	 * Creation date: (15.12.2005 11:39:49)
	 * @return java.lang.String
	 */
	public static String formatProjectName(
		int argType,
		int argGsmId,
		String argName) {
		String typeStr = "<неизвестно>";
		if (argType == 0)
			typeStr = "строительство";
		else if (argType == 1)
			typeStr = "модернизацию";
		return typeStr + " БС № " + argGsmId + " " + argName;
	}

	/**
	 * Форматирование состояния документа по согласованию в проектах на строительство БС
	 * Creation date: (15.12.2005 11:39:49)
	 * @return java.lang.String
	 */
	public static String formatProjectState(String argPrjStatus) {
		String resStr = "<неизвестно>";
		if ("A".equals(argPrjStatus))
			resStr = "вводится";
		else if ("B".equals(argPrjStatus))
			resStr = "требует доработки";
		else if ("C".equals(argPrjStatus))
			resStr = "ждет согласования";
		else if ("D".equals(argPrjStatus))
			resStr = "согласован";
		return resStr;
	}

	/**
	 * ID проекта на строительство БС.
	 * Creation date: (15.12.2005 16:54:28)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getProjectid() {
		return projectid;
	}
	/**
	 * Наименование проекта на строительство БС.
	 * Creation date: (15.12.2005 16:54:54)
	 * @return java.lang.String
	 */
	public java.lang.String getProjectname() {
		return projectname;
	}

	/**
	 * Признак необходимости согласования документа.
	 * Creation date: (15.12.2005 16:56:04)
	 * @return boolean
	 */
	public boolean isNeedapprove() {
		return needapprove;
	}

	/**
	 * Проверим нужно ли требовать согласование документа и есть ли проект.
	 * Creation date: (15.12.2005 17:04:14)
	 * @return boolean
	 */

	public boolean checkProject(Integer complectCode) {
		// Find region
		boolean result = false;
		needapprove = false;
		projectid = null;
		projectname = "";
		boolean napr = false;
		int bsnum = 0;
		if (complectCode != null) {
			try {
				BaseStationAccessBean bsab = new BaseStationAccessBean();
				bsab.setInitKey_storageplace(complectCode.intValue());
				bsab.refreshCopyHelper();
				bsnum = bsab.getNumber();
				PositionAccessBean pab = bsab.getPosition();
				pab.refreshCopyHelper();
				RegionAccessBean rab = pab.getRegion();
				rab.refreshCopyHelper();
				CDBCRegionsObject ro = new CDBCRegionsObject();
				napr = ro.checkNeedApprove(new Integer(rab.getRegionid()));
			} catch (Exception e) {
				// Ignore error
			}
			if (napr) {
				needapprove = true;
				// Determine project
				CDBCResultSet rs = findBSComProjects(new Integer(bsnum));
				if (rs.getRowsCount() == 1) {
					ListIterator it = rs.listIterator();
					CDBCRowObject ro = (CDBCRowObject) it.next();
					Integer prjid =
						(Integer) ro.getColumn("projectid").asObject();
					Integer type = (Integer) ro.getColumn("type").asObject();
					String name = ro.getColumn("name").asString();
					projectname =
						formatProjectName(type.intValue(), bsnum, name);
					projectid = prjid;
					result = true;
				}
			} else
				result = true;
		} else
			result = true;
		return result;
	}

	public static String getDocumentNameSQL() {
		return "CASE d.type \n"
			+ "WHEN 'W' THEN 's.external.waybill' \n"
			+ "WHEN 'T' THEN \n"
			+ "	CASE spt.type \n"
			+ "	WHEN 'S' THEN 's.internal.waybill' \n"
			+ "	ELSE 'p.assembling' \n"
			+ "	END \n"
			+ "WHEN 'N' THEN \n"
			+ "	CASE spf.type \n"
			+ "	WHEN 'S' THEN 's.internal.outbill' \n"
			+ "	ELSE 'p.dismantling' \n"
			+ "	END \n"
			+ "WHEN 'O' THEN 's.external.outbill' \n"
			+ "WHEN 'P' THEN \n"
			+ "CASE spf.type \n"
			+ "	WHEN 'S' THEN 's.payoff' \n"
			+ "	WHEN 'X' THEN 'e.payoff' \n"
			+ "	ELSE 'p.payoff' \n"
			+ "	END \n"
			+ "WHEN 'C' THEN 'contract' \n"
			+ "WHEN 'S' THEN \n"
			+ "	CASE spt.type \n"
			+ "	WHEN 'S' THEN 's.surplus' \n"
			+ "	WHEN 'X' THEN 'e.surplus' \n"
			+ "	ELSE 'p.surplus' \n"
			+ "	END \n"
			+ "WHEN 'I' THEN \n"
			+ "	CASE spt.type \n"
			+ "	WHEN 'S' THEN 's.inventarization' \n"
			+ "	ELSE 'p.inventarization' \n"
			+ "	END \n"
			+ "WHEN 'A' THEN \n"
			+ "	CASE aa.operationtype \n"
			+ "	WHEN 'A' THEN \n"
			+ "		CASE spt.type \n"
			+ "		WHEN 'S' THEN 's.assembling.block' \n"
			+ "		ELSE 'p.assembling.block' \n"
			+ "		END \n"
			+ "	WHEN 'D' THEN \n"
			+ "		CASE spf.type \n"
			+ "		WHEN 'S' THEN 's.dismantling.block' \n"
			+ "		ELSE 'p.dismantling.block' \n"
			+ "		END \n"
			+ "	END \n"
			+ "WHEN 'H' THEN \n"
			+ "	CASE spf.type \n"
			+ "	WHEN 'S' THEN 's.change' \n"
			+ "	WHEN 'X' THEN 'e.change' \n"
			+ "	ELSE 'p.change' \n"
			+ "	END \n"
			+ "WHEN 'R' THEN 's.request' \n"
			+ "WHEN 'F' THEN 'fault' \n"
			+ "WHEN 'B' THEN 'p.afsmount' \n"
			+ "ELSE '-' \n"
			+ "END docname\n";
	}
	
	public static String getPositionNameSQL() {
		return "CASE spt.type "
			+ "WHEN 'P' THEN (SELECT TRIM(s.name) || NVL(' D' || p.gsmid, '') || NVL(' A'||p.dampsid,'') name FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = spt.storageplace) "
			+ "WHEN 'S' THEN '' "
			+ "WHEN 'X' THEN '' "
			+ "ELSE (SELECT NVL('D'||p.gsmid||' ','') || NVL('A' || p.dampsid || ' ', '') || TRIM(s.name) FROM equipment e, positions p, storageplaces s WHERE e.position = p.storageplace AND p.storageplace = s.storageplace AND e.equipment = spt.storageplace) "
			+ "END positionname ";
	}

	public static CDBCResultSet listDocsByProject(
		Integer argProjectid,
		Integer order) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT d.document, d.type, d.blankdate, \n");
		sqlb.append(getDocumentNameSQL()+",  \n");
		sqlb.append(getPositionNameSQL()+",  \n");
		sqlb.append("CASE d.type \n");
		sqlb.append("WHEN 'W' THEN \n");
		sqlb.append("	d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') || NVL(' (Счёт ' || TRIM(iwb.cordocnum) || ')','') \n");
		sqlb.append("ELSE \n");
		sqlb.append("	d.blankindex || NVL(' ' || TRIM(d.blanknumber),'') \n");
		sqlb.append("END docnum, \n");
		sqlb.append("TRIM(agr.model) || NVL(' ' || TRIM(agsc.configuration),'') || NVL(' (' || TRIM(agsc.serialnumber) || ')','') headname \n");
		sqlb.append("FROM documents d,  \n");
		sqlb.append("outer storageplaces spf, outer storageplaces spt, \n");
		sqlb.append("outer (asemblingacts aa, storagecards agsc, resources agr), \n");
		sqlb.append("outer inwaybills iwb \n");
		sqlb.append("WHERE \n");
		sqlb.append("d.projectid = ? AND d.state = '2' AND spf.storageplace = d.from \n");
		sqlb.append("AND spt.storageplace = d.to AND aa.document = d.document \n");
		sqlb.append("AND iwb.document = d.document \n");
		sqlb.append("AND aa.agregat = agsc.storagecard \n");
		sqlb.append("AND agsc.resource = agr.resource \n");

		params.add(argProjectid);

		// ORDER BY
		if (order != null) {
			switch (order.intValue()) {
				case 1 :
					sqlb.append("ORDER BY d.blankdate ASC ");
					break;
				case 2 :
					sqlb.append("ORDER BY d.blankdate DESC ");
					break;
			}
		}
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), new Object[] {argProjectid});
		return res;
	}

	/**
	 * Тест.
	 * Creation date: (10.03.2004 16:03:42)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) {
		CDBCWorkerObject o = new CDBCWorkerObject();
		CDBCResultSet rs = o.findWorkerByLastName("d*");
		java.util.ListIterator it = rs.listIterator();
		System.out.println("start");
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			CDBCColumnObject co1 = (CDBCColumnObject) ro.getColumn("worker");
			CDBCColumnObject co2 = (CDBCColumnObject) ro.getColumn("fullname");
			System.out.println(
				"" + co1.asObject() + "  '" + co2.asString() + "'");
		}
	}
}
