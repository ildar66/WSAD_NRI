package com.hps.july.cdbc.objects;

import java.util.ListIterator;

import com.hps.july.cdbc.lib.*;

/**
 * Объект для работы с оборудованием из систем OSS.
 * Creation date: (25.08.2005 17:25:25)
 * @author: Dmitry Dneprov
 */
public class CDBCOSSEquipmentObject {
/**
 * CDBCPositionObject constructor comment.
 */
public CDBCOSSEquipmentObject() {
	super();
}
/**
 * Преобразование номера GSM ID. Если номер содержит менее 5 цифр
 * слева добавляется код суперрегиона
 */
public Integer convertGSMID(Integer argGSMID) {
	return argGSMID;
	/*
	if (argGSMID != null) {
		int gsmid = argGSMID.intValue();
		if (gsmid < 1000)
			gsmid = gsmid + 1000;
		return new Integer(gsmid);
	}
	return null;
	*/
}

/**
 * Нахождение префикса региона, в который грузятся данные
 * @param conn
 * @param argPLMN
 * @return
 */
protected String findRegionPrefix(Integer argStorageplace) {
	String result = null;
	CDBCResultSet rs = new CDBCResultSet();
	rs.executeQuery("SELECT s.supregcode FROM superregions s, regions r, positions p " +		"WHERE p.storageplace = ? AND s.supregid = r.supregid AND r.regionid = p.regionid", 
		new Object[] {argStorageplace}, 1);
	ListIterator it = rs.listIterator();
	if (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		result = ro.getColumn("supregcode").asString();
	}
	return result;
}


/**
 * Возвращает данные о последней загрузке данных от систем OSS для данного GSM ID
 */
public CDBCResultSet findDataLoadHeader(Integer argGSMID) {
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery("SELECT *,  NVL((SELECT s.name FROM storageplaces s WHERE s.storageplace =( " +
		"SELECT min(p.storageplace) FROM positions p WHERE   p.gsmid = g.gsmid    ) ), 'Неизвестно') posname " +
		"FROM equipmentdataloads e, gsmid2networks g, networks n " +
		"WHERE g.gsmid = ? AND g.plmn = n.plmn AND n.plmn = e.plmn AND " +
		"   e.dataloadid = (SELECT MAX(edl.dataloadid) FROM equipmentdataloads edl WHERE edl.plmn = n.plmn) ",
		new Object[] {argGSMID}, 1);
	return res;
}
/**
 * Возвращает данные оборудования Alcatel от систем OSS для данного заголовка
 */
public CDBCResultSet getAlcatelData(Integer argHeadID) {
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery("SELECT * FROM alcatelequipdata WHERE dataheadid = ? ORDER BY dataid", 
		new Object[] {argHeadID}, 0);
	return res;
}
/**
 * Возвращает заголовки данных оборудования Alcatel от систем OSS для данного GSM ID
 */
public CDBCResultSet getAlcatelDataHeaders(Integer argGSMID) {
	CDBCResultSet res = new CDBCResultSet();
	CDBCResultSet headRS = findDataLoadHeader(argGSMID);
	java.util.ListIterator it = headRS.listIterator();
	if (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Integer loadID = (Integer)ro.getColumn("dataloadid").asObject();
		res.executeQuery("SELECT UNIQUE b.bsclabel, b.btslabel, b.btsgeneration, e.* " +
			"FROM alcatelbts b, alcatelsector s, OUTER alcatelequipdataheader e " +
			"WHERE b.omcr=s.omcr AND b.bsmid = s.bsmid " +
			"AND e.bscuserlabel = b.bscuserlabel AND e.btsuserlabel = b.btslabel " +
			"AND b.dataloadid = ? " +
			"AND e.dataloadid = b.dataloadid AND s.dataloadid = b.dataloadid " +
			"AND s.gsmid=?",
			new Object[] {loadID, argGSMID}, 0);
	}
	return res;
}
/**
 * Возвращает данные 1-ого уровня оборудования Ericsson от систем OSS для данного GSM ID
 */
public CDBCResultSet getEricssonRU1(Integer argDataLoadID, Integer argBPSet, Integer argParent) {
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery("SELECT * " +
			"FROM ericssonru1 " +
			"WHERE  dataloadid = ? AND bpset = ? AND parent = ? ",
			new Object[] {argDataLoadID, argBPSet, argParent}, 0);
	return res;
}
/**
 * Возвращает данные 2-ого уровня оборудования Ericsson от систем OSS для данного GSM ID
 */
public CDBCResultSet getEricssonRU2(Integer argDataLoadID, Integer argBPSet, Integer argParent) {
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery("SELECT * " +
			"FROM ericssonru2 " +
			"WHERE  dataloadid = ? AND bpset = ? AND parent = ? ",
			new Object[] {argDataLoadID, argBPSet, argParent}, 0);
	return res;
}
/**
 * Возвращает заголовки данных оборудования Ericsson от систем OSS для данного GSM ID
 */
public CDBCResultSet getEricssonSites(Integer argGSMID) {
	CDBCResultSet res = new CDBCResultSet();
	CDBCResultSet headRS = findDataLoadHeader(argGSMID);
	java.util.ListIterator it = headRS.listIterator();
	if (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Integer loadID = (Integer)ro.getColumn("dataloadid").asObject();
		res.executeQuery("SELECT * " +
			"FROM ericssonsites s " +
			"WHERE  s.dataloadid = ? AND s.bpkey IN (SELECT g.parent FROM ericssontg12 g, ericssontrx12 x " +
			"   WHERE x.dataloadid = g.dataloadid AND x.bpset = g.bpset AND x.parent = g.bpkey AND " +
			"   x.gsmid=? AND g.dataloadid = s.dataloadid AND g.bpset = s.bpset)",
			new Object[] {loadID, argGSMID}, 0);
	}
	return res;
}
/**
 * Возвращает данные оборудования (серийные номера) Nokia от систем OSS для данного GSM ID
 */
public CDBCResultSet getNokiaHardware(Integer argGSMID) {
	CDBCResultSet res = new CDBCResultSet();
	CDBCResultSet headRS = findDataLoadHeader(argGSMID);
	java.util.ListIterator it = headRS.listIterator();
	if (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Integer loadID = (Integer)ro.getColumn("dataloadid").asObject();
		res.executeQuery("SELECT h.*  " +
			"FROM nokiahardwareunits h " +
			"WHERE  h.dataloadid = ? AND h.bcf_id IN (SELECT f.object_id FROM nokiabts b, nokiabcf f " +
			"WHERE b.gsmid=? AND f.dataloadid = b.dataloadid AND " +
			"f.object_id = b.bcf_id AND  f.dataloadid = ?) " +
			"ORDER BY unit_name, unit_nro",
			new Object[] {loadID, argGSMID, loadID}, 0);
	}
	return res;
}
/**
 * Возвращает сектора данных оборудования Nokia от систем OSS для данного GSM ID
 */
public CDBCResultSet getNokiaSectors(Integer argGSMID) {
	CDBCResultSet res = new CDBCResultSet();
	CDBCResultSet headRS = findDataLoadHeader(argGSMID);
	java.util.ListIterator it = headRS.listIterator();
	if (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Integer loadID = (Integer)ro.getColumn("dataloadid").asObject();
		res.executeQuery("SELECT *  " +
			"FROM nokiabts b " +
			"WHERE  b.dataloadid = ? AND b.gsmid=? " +
			"ORDER BY cellid",
			new Object[] {loadID, argGSMID}, 0);
	}
	return res;
}
/**
 * Возвращает тип оборудования OSS:
 *    0 - нет данных
 *    1 - Alcatel
 *    2 - Nokia
 *    3 - Ericsson
 */
public int getOSSNetType(Integer argGSMID) {
	int result = 0;
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery("SELECT * FROM equipmentdataloads e, gsmid2networks g, networks n " +
		"WHERE g.gsmid = ? AND g.plmn = n.plmn AND n.plmn = e.plmn AND " +
		"   e.dataloadid = (SELECT MAX(edl.dataloadid) FROM equipmentdataloads edl WHERE edl.plmn = n.plmn) ",
		new Object[] {argGSMID}, 1);
	java.util.ListIterator it = res.listIterator();
	if (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Integer nettype = (Integer)ro.getColumn("nettype").asObject();
		if (nettype != null) {
			result = nettype.intValue();
		}
	}
	return result;
}
/**
 * Main метод для тестирования функциональности.
 * @param args java.lang.String[]
 */
public static void main(String[] args) {
	/*
	CDBCWorkerObject o = new CDBCWorkerObject();
	CDBCResultSet rs = o.findWorkerByLastName("d*");
	java.util.ListIterator it = rs.listIterator();
	System.out.println("start");
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		CDBCColumnObject co1 = (CDBCColumnObject)ro.getColumn("worker");
		CDBCColumnObject co2 = (CDBCColumnObject)ro.getColumn("fullname");
		System.out.println("" + co1.asObject() + "  '" + co2.asString() + "'");
	}
	*/
}
}
