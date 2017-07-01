package com.hps.july.cdbc.objects;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import com.hps.july.persistence.ResourceSubTypeKey;
import com.hps.july.cdbc.lib.*;
import org.apache.struts.util.ResponseUtils;

/**
 * Объект для работы с различными документами.
 */
public class CDBCSitedocsObject {
public CDBCSitedocsObject() {
	super();
}
public static void appendIN(StringBuffer sb, String param, Integer[] array)
{
	if(array == null) {
		return;
	} else if(array.length == 0)  {
		sb.append(param);
		sb.append(" IS NULL ");
	} else {
		sb.append(param);
		sb.append(" IN (");
		for(int i = 0; i < array.length; i++) {
			if(i > 0) sb.append(",");
			if(array[i] != null) {
				sb.append(array[i]);
			} else {
				sb.append(array[i]);
			}
		}
		sb.append(") ");
	}
}
public static void appendNOTIN(StringBuffer sb, String param, Integer[] array)
{
	if(array == null) {
		return;
	} else if(array.length == 0)  {
		return;
	} else {
		sb.append(param);
		sb.append(" NOT IN (");
		for(int i = 0; i < array.length; i++) {
			if(i > 0) sb.append(",");
			if(array[i] != null) {
				sb.append(array[i]);
			} else {
				sb.append(array[i]);
			}
		}
		sb.append(") ");
	}
}
public void deleteFL2HopsComlines(Integer fpid, Integer hopsid)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	CDBCResultSet res = new CDBCResultSet();

	sqlb.append("DELETE FROM sitedocs2hops WHERE ");
	if(hopsid != null) {
		sqlb.append("hopsid = ? ");
		params.add(hopsid);
	} else {
		sqlb.append("hopsid IS NULL ");
	}
	if(fpid != null) {
		sqlb.append("AND sitedoc IN (SELECT sitedoc FROM etapdocs WHERE freqpermid <> ?) ");
		params.add(fpid);
	} else {
		sqlb.append("AND sitedoc IN (SELECT sitedoc FROM etapdocs WHERE freqpermid IS NULL) ");
	}
	
	res.executeUpdate(sqlb.toString(), params.toArray());
/*
	sqlb = new StringBuffer();
	params = new LinkedList();
	res = new CDBCResultSet();

	sqlb.append("UPDATE rrl_hops2 SET file_number = NULL, number_in_file = NULL WHERE ");
	if(fpid != null) {
		sqlb.append(" hopsid = ? ");
		params.add(hopsid);
	} else {
		sqlb.append(" hopsid IS NULL ");
	}

	res.executeUpdate(sqlb.toString(), params.toArray());
*/
	sqlb = new StringBuffer();
	params = new LinkedList();
	res = new CDBCResultSet();
	
	sqlb.append("DELETE FROM perm2hops WHERE ");
	if(hopsid != null) {
		sqlb.append("hopsid = ? ");
		params.add(hopsid);
	} else {
		sqlb.append("hopsid IS NULL ");
	}
	if(fpid != null) {
		sqlb.append("AND freqpermid <> ? ");
		params.add(fpid);
	} else {
		sqlb.append("AND freqpermid IS NULL ");
	}

	res.executeUpdate(sqlb.toString(), params.toArray());
}
public void deleteFL2HopsLink(Integer fpid, Integer hopsid)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	CDBCResultSet res = new CDBCResultSet();

	sqlb.append("DELETE FROM sitedocs2hops WHERE ");
	if(hopsid != null) {
		sqlb.append("hopsid = ? ");
		params.add(hopsid);
	} else {
		sqlb.append("hopsid IS NULL ");
	}
	if(fpid != null) {
		sqlb.append("AND sitedoc IN (SELECT sitedoc FROM etapdocs WHERE freqpermid <> ?) ");
		params.add(fpid);
	} else {
		sqlb.append("AND sitedoc IN (SELECT sitedoc FROM etapdocs WHERE freqpermid IS NULL) ");
	}

	System.out.println("DELETE_FL2LINK.1:SQL:"+sqlb.toString());
	res.executeUpdate(sqlb.toString(), params.toArray());

	sqlb = new StringBuffer();
	params = new LinkedList();
	res = new CDBCResultSet();

	sqlb.append("UPDATE rrl_hops2 SET file_number = NULL, number_in_file = NULL WHERE ");
	if(fpid != null) {
		sqlb.append(" hopsid = ? ");
		params.add(hopsid);
	} else {
		sqlb.append(" hopsid IS NULL ");
	}

	System.out.println("DELETE_FL2LINK.2:SQL:"+sqlb.toString());
	res.executeUpdate(sqlb.toString(), params.toArray());

	sqlb = new StringBuffer();
	params = new LinkedList();
	res = new CDBCResultSet();
	
	sqlb.append("DELETE FROM perm2hops WHERE ");
	if(hopsid != null) {
		sqlb.append("hopsid = ? ");
		params.add(hopsid);
	} else {
		sqlb.append("hopsid IS NULL ");
	}
	if(fpid != null) {
		sqlb.append("AND freqpermid = ? ");
		params.add(fpid);
	} else {
		sqlb.append("AND freqpermid IS NULL ");
	}

	System.out.println("DELETE_FL2LINK.3:SQL:"+sqlb.toString());
	res.executeUpdate(sqlb.toString(), params.toArray());
}
public void deleteFL2HopsUnusedLinks(Integer fpid, Integer[] cl)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	CDBCResultSet res = new CDBCResultSet();

	sqlb.append("DELETE FROM sitedocs2hops WHERE ");
	appendNOTIN(sqlb, "hopsid ", cl);
	if(fpid != null) {
		sqlb.append("AND sitedoc IN (SELECT sitedoc FROM etapdocs WHERE freqpermid = ?) ");
		params.add(fpid);
	} else {
		sqlb.append("AND sitedoc IN (SELECT sitedoc FROM etapdocs WHERE freqpermid IS NULL) ");
	}

	System.out.println("DELETE_FL2HOPS.1:SQL:"+sqlb.toString());
	res.executeUpdate(sqlb.toString(), params.toArray());

	sqlb = new StringBuffer();
	params = new LinkedList();
	res = new CDBCResultSet();

	sqlb.append("UPDATE rrl_hops2 SET file_number = NULL, number_in_file = NULL WHERE hopsid IN (SELECT p2h.hopsid FROM perm2hops p2h WHERE ");
	if(fpid != null) {
		sqlb.append(" p2h.freqpermid = ?) ");
		params.add(fpid);
	} else {
		sqlb.append(" p2h.freqpermid IS NULL) ");
	}

	System.out.println("DELETE_FL2HOPS.2:SQL:"+sqlb.toString());
	res.executeUpdate(sqlb.toString(), params.toArray());

	sqlb = new StringBuffer();
	params = new LinkedList();
	res = new CDBCResultSet();

	sqlb.append("DELETE FROM perm2hops WHERE ");
	appendNOTIN(sqlb, "hopsid ", cl);
	if(fpid != null) {
		sqlb.append("AND freqpermid = ? ");
		params.add(fpid);
	} else {
		sqlb.append("AND freqpermid IS NULL ");
	}

	System.out.println("DELETE_FL2HOPS.3:SQL:"+sqlb.toString());
	res.executeUpdate(sqlb.toString(), params.toArray());
		
}
public CDBCResultSet findComlineDocuments(Integer hopsid, Boolean activeOnly)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT sd.sitedoc, sd.blankdate, sd.blanknumber, sd.blankdate, NVL(TRIM(et.ettypename),TRIM(sdt.sitedoctypename)) sitedoctypename, sd.expiredate, sd.comment ");
	sqlb.append("FROM sitedocs sd, sitedocs2hops s2h, sitedoctypes sdt, outer (etapdocs ed, etaptype et) ");
	sqlb.append("WHERE sd.sitedoc = s2h.sitedoc AND s2h.hopsid = ? AND sdt.sitedoctype = sd.sitedoctype AND ed.sitedoc = sd.sitedoc AND ed.etaptypeid = et.etaptypeid ");
	if(hopsid != null) {
		params.add(hopsid);
	} else {
		params.add(new Integer(0));
	}
	if(activeOnly != null && activeOnly.booleanValue()) {
		sqlb.append("AND (sd.expiredate >= TODAY OR sd.expiredate IS NULL) ");
	}

	sqlb.append("ORDER BY sd.blankdate DESC, sd.blanknumber ASC ");
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findDocFiles(Integer sitedoc)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT sf.sitedocfile, sf.sitedocfiledate, sitedocfilename, sf.note FROM sitedocfiles sf WHERE");
	if(sitedoc != null) {
		sqlb.append(" sf.sitedoc = ? ");
		params.add(sitedoc);
	} else {
		sqlb.append(" sf.sitedoc IS NULL ");
	}
	sqlb.append("ORDER BY sf.sitedocfilename ASC");
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public String findDocsResfrequencyString(Integer sitedoc, boolean addbr)
{
	String result = "";
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT DISTINCT sdr.freqrange FROM sitedocs2resources sdr WHERE ");
	if(sitedoc != null) {
		sqlb.append("sdr.sitedoc = ? ");
		params.add(sitedoc);
	} else {
		sqlb.append("sdr.sitedoc IS NULL ");
	}
	sqlb.append("ORDER BY sdr.freqrange ASC");
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());

	ListIterator li = res.listIterator();

	while(li.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)li.next();
		if(ro.getColumn("freqrange").asObject() != null) {
			result += ResponseUtils.filter(ro.getColumn("freqrange").asString());
			if(li.hasNext()) {
				result += ", ";
				if(addbr) result += "<BR>";
			}
		}
	}
	return result;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findDocsResources(Integer sitedoc)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource, r.name, r.model, sdr.freqrange freq FROM sitedocs2resources sdr, resources r WHERE r.resource = sdr.resource ");
	if(sitedoc != null) {
		sqlb.append("AND sdr.sitedoc = ? ");
		params.add(sitedoc);
	} else {
		sqlb.append("AND sdr.sitedoc IS NULL ");
	}
	sqlb.append("ORDER BY r.name ASC, r.model ASC");
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public String findDocsResourcesString(Integer sitedoc, boolean addbr)
{
	String result = "";
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT DISTINCT r.model FROM sitedocs2resources sdr, resources r WHERE r.resource = sdr.resource ");
	if(sitedoc != null) {
		sqlb.append("AND sdr.sitedoc = ? ");
		params.add(sitedoc);
	} else {
		sqlb.append("AND sdr.sitedoc IS NULL ");
	}
	sqlb.append("ORDER BY r.model ASC");
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());

	ListIterator li = res.listIterator();

	while(li.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)li.next();
		result += ResponseUtils.filter(ro.getColumn("model").asString());
		if(li.hasNext()) {
			result += ", ";
			if(addbr) result += "<BR>";
		}
	}
	return result;
}
public CDBCResultSet findEtap2ComlineTriggers(Integer etapdoc, Integer freqpermid) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT ed.sitedoc, ed.etaptypeid, ed.freqpermid, h.hopsid, h.permstatus, e2ht.resultstate ");
	sqlb.append("FROM etapdocs ed, etaptype et, sitedocs2hops e2h, hops h, etap2hoptrigger e2ht ");
	sqlb.append("WHERE ed.etaptypeid = et.etaptypeid AND ed.sitedoc = e2h.sitedoc AND e2h.hopsid = h.hopsid ");
	sqlb.append("AND e2ht.etaptypeid = ed.etaptypeid AND h.permstatus = e2ht.sourcestate AND et.havehopslink = 'Y' ");
	
	if(etapdoc != null) {
		sqlb.append("ed.sitedoc = ? ");
		params.add(etapdoc);
	} else {
		sqlb.append("ed.sitedoc IS NULL ");
	}
	if(freqpermid != null) {
		sqlb.append("AND ed.freqpermid = ? ");
		params.add(freqpermid);
	} else {
		sqlb.append("AND ed.freqpermid IS NULL ");
	}
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public Integer findEtapDocByType(Integer etapdoctype, Integer freqpermid) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT ed.sitedoc FROM etapdocs ed WHERE ");
	if(etapdoctype != null) {
		sqlb.append("ed.etaptypeid = ? ");
		params.add(etapdoctype);
	} else {
		sqlb.append("ed.etaptypeid IS NULL ");
	}
	if(freqpermid != null) {
		sqlb.append("AND ed.freqpermid = ? ");
		params.add(freqpermid);
	} else {
		sqlb.append("AND ed.freqpermid IS NULL ");
	}
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	Integer r = null;
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Object o = ro.getColumn("sitedoc").asObject();
		if(o != null && o instanceof Integer) {
			r = (Integer)o;
		}
	}
	return r;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findEtapTypes(
	Boolean useName, String name,
	Integer order
) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT et.etaptypeid, et.ettypename, et.haveendtime, et.havehopslink, et.havepaycheck ");
	sqlb.append("FROM etaptype et ");

	if(useName != null && useName.booleanValue()) {
		sqlb.append("WHERE LOWER(et.ettypename) MATCHES LOWER(?)");
		params.add(name);
	}

	sqlb.append("ORDER BY et.etaptypeid ASC ");

	/*
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY et.etaptypeid ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY et.ettypename DESC ");
			break;
		}
	}
	*/

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public Iterator findFL2HopsLink(Integer freqpermid, Integer hopsid) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT freqpermid, hopsid, numberinfile FROM perm2hops WHERE ");
	if(freqpermid != null) {
		sqlb.append("freqpermid = ? ");
		params.add(freqpermid);
	} else {
		sqlb.append("freqpermid IS NULL ");
	}
	if(hopsid != null) {
		sqlb.append("AND hopsid = ? ");
		params.add(hopsid);
	} else {
		sqlb.append("AND hopsid IS NULL ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res.listIterator();
}
public CDBCResultSet findFL2HopsLinks(Integer freqpermid) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT freqpermid, hopsid, numberinfile FROM perm2hops WHERE ");
	if(freqpermid != null) {
		sqlb.append("freqpermid = ? ");
		params.add(freqpermid);
	} else {
		sqlb.append("freqpermid IS NULL ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findFrequencyLicenceByFN(Integer filenumber) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT freqpermid, filenumber, etap, comment FROM freqpermissions WHERE ");
	
	if(filenumber != null) {
		sqlb.append("filenumber = ? ");
		params.add(filenumber);
	} else {
		sqlb.append("filenumber IS NULL ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findFrequencyLicenceByFN(Integer filenumber, Integer excludefpid) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT freqpermid, filenumber, etap, comment FROM freqpermissions WHERE ");
	
	if(filenumber != null) {
		sqlb.append("filenumber = ? ");
		params.add(filenumber);
	} else {
		sqlb.append("filenumber IS NULL ");
	}

	if(excludefpid != null) {
		sqlb.append("AND freqpermid <> ? ");
		params.add(excludefpid);
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findFrequencyLicenceComlines(Integer freqpermid) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT h.hopsid, h.hopstate, p2h.numberinfile, TRIM(hl.hopsname) comlinecode, ");
	sqlb.append("NVL('D' || p1.gsmid || ' ','') ||  NVL('A' || p1.dampsid || ' ','') || TRIM(sp1.name) positiona, ");
	sqlb.append("NVL('D' || p2.gsmid || ' ','') ||  NVL('A' || p2.dampsid || ' ','') || TRIM(sp2.name) positionb, ");
	sqlb.append("'label.comline.type'||NVL(LOWER(h.hopstype),'null') comlinetype, ");
	sqlb.append("TRIM(spe1.name) resourcea, ");
	sqlb.append("TRIM(spe2.name) resourceb, ");
	sqlb.append("(SELECT sfonumber FROM rrl_hops2 WHERE hopsid = h.hopsid) sfonumber ");
	sqlb.append("FROM perm2hops p2h, hops h, hopslabel hl, equipment e1, equipment e2, positions p1, positions p2, storageplaces sp1, storageplaces sp2, storageplaces spe1, storageplaces spe2 ");
	sqlb.append("WHERE p2h.hopsid = h.hopsid ");
	sqlb.append("AND e1.equipment = h.equipmentid_enda AND e2.equipment = h.equipmentid_endb ");
	sqlb.append("AND e1.position = p1.storageplace AND e2.position = p2.storageplace ");
	sqlb.append("AND sp1.storageplace = p1.storageplace AND sp2.storageplace = p2.storageplace ");
	sqlb.append("AND hl.hopslabelid = (SELECT max(hopslabelid) FROM hopslabel hll WHERE hll.hopsid = h.hopsid) AND hl.hopsid = h.hopsid ");
	sqlb.append("AND spe1.storageplace = e1.equipment AND spe2.storageplace = e2.equipment ");

	if(freqpermid != null) {
		sqlb.append(" AND p2h.freqpermid = ? ");
		params.add(freqpermid);
	} else {
		sqlb.append(" AND p2h.freqpermid IS NULL ");
	}
	sqlb.append("ORDER BY p2h.numberinfile ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Выдайт список частотных разрешений
 *
 * useSuperregions - TRUE - использовать фильтр по суперрегионам
 * superregions - Список кодов суперрегионов
 * useRegions - TRUE - использовать фильтр по регионам
 * regions - Список кодов регионов
 * useFileNumber - TRUE - в фильтре используется параметр fileNumber
 * fineNumber - Match значение фильтрации по полю filenumber
 * reqFilter - Фильтр по заявкам BeeLine. Значения: 'S' - подана, 'O' - не подана, иначе все
 * licenceFilter - Фильтр по полученным частотным разрешениям. Значения: 'Y' - получено, 'N' - не получено, иначе все
 * expFilter - Фильтр по наличию разрешения на эксплуатацию объекта. Значения: 'Y' - есть, 'N' - нет, иначе все
 * isAdmin - Является ли пользователь администратором
 * username - Имя логина пользователя
 * order - Сортировка:
 *		1 - № разрешения (ASC)
 *		2 - № разрешения (DESC)
 *		3 - № заявки (ASC)
 *		4 - № заявки (DESC)
 *		5 - Дата + № завки (ASC) 
 *		6 - Дата + № завки (DESC) 
 *		7 - № Частотного разрешения (ASC)
 *		8 - № Частотного разрешения (DESC)
 *		9 - Дата + № Частотного разрешения (ASC)
 *	   10 - Дата + № Частотного разрешения (DESC)
 */
public CDBCResultSet findFrequencyLicenceDocuments(
	Boolean useSuperregions, Integer[] superregions,
	Boolean useRegions, Integer[] regions,
	Boolean useFileNumber, String fileNumber,
	String reqFilter, String licenceFilter, String expFilter,
	Boolean isAdmin, String username,
	Integer order
) {
	com.hps.july.jdbcpersistence.lib.TimeCounter tc = new com.hps.july.jdbcpersistence.lib.TimeCounter("FreqList");
	tc.start();
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	Integer userid = null;
	
	if(isAdmin == null || !isAdmin.booleanValue()) {
		userid = com.hps.july.persistence.OperatorObject.getOperatorCode(username);
	}

	sqlb.append("SELECT fp.freqpermid, fp.filenumber, fp.etap, fp.comment, ");
	sqlb.append(" TRIM(getFreqRes(fp.freqpermid)) reslist, ");
	sqlb.append(" (SELECT blanknumber FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv WHERE sd.sitedoc = ed.sitedoc AND ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceStart' AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.etaptypeid = nv.intvalue AND edd.freqpermid = fp.freqpermid) )) beereqnumber, ");
	sqlb.append(" (SELECT blankdate FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv WHERE sd.sitedoc = ed.sitedoc AND ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceStart' AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.etaptypeid = nv.intvalue AND edd.freqpermid = fp.freqpermid) )) beereqdate, ");
	sqlb.append(" (SELECT blanknumber FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv WHERE sd.sitedoc = ed.sitedoc AND ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceEnd' AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.etaptypeid = nv.intvalue AND edd.freqpermid = fp.freqpermid) )) freqnumber, ");
	sqlb.append(" (SELECT blankdate FROM sitedocs WHERE sitedoc = (SELECT MAX(sd.sitedoc) FROM sitedocs sd, etapdocs ed, namedvalues nv WHERE sd.sitedoc = ed.sitedoc AND ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceEnd' AND sd.blankdate = (SELECT MAX(sdd.blankdate) FROM sitedocs sdd,etapdocs edd WHERE sdd.sitedoc = edd.sitedoc AND edd.etaptypeid = nv.intvalue AND edd.freqpermid = fp.freqpermid) )) freqdate ");
	sqlb.append("FROM freqpermissions fp ");
	sqlb.append("WHERE 1=1 ");

	if(useFileNumber != null && useFileNumber.booleanValue()) {
		if(fileNumber != null) {
			sqlb.append("AND CAST(fp.filenumber AS VARCHAR(100)) MATCHES LOWER(?) ");
//			sqlb.append("AND fp.filenumber = ? ");
			params.add(fileNumber);
		} else {
			sqlb.append("AND sd.filenumber IS NULL ");
		}
	}

	if(reqFilter != null && !"".equals(reqFilter)) {
		if("S".equals(reqFilter)) {
			sqlb.append("AND EXISTS (SELECT ed.sitedoc FROM etapdocs ed, namedvalues nv WHERE ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceStart')	");
		} else
		if("O".equals(reqFilter)) {
			sqlb.append("AND NOT EXISTS (SELECT ed.sitedoc FROM etapdocs ed, namedvalues nv WHERE ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceStart')	");
		}
	}

	if(licenceFilter != null && !"".equals(licenceFilter)) {
		if("Y".equals(licenceFilter)) {
			sqlb.append("AND EXISTS (SELECT ed.sitedoc FROM etapdocs ed, namedvalues nv WHERE ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceEnd') ");
		} else
		if("N".equals(licenceFilter)) {
			sqlb.append("AND NOT EXISTS (SELECT ed.sitedoc FROM etapdocs ed, namedvalues nv WHERE ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceEnd') ");
		}
	}

	if(expFilter != null && !"".equals(expFilter)) {
		if("Y".equals(expFilter)) {
			sqlb.append("AND EXISTS (SELECT ed.sitedoc FROM etapdocs ed, namedvalues nv WHERE ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceExp') ");
		} else
		if("N".equals(expFilter)) {
			sqlb.append("AND NOT EXISTS (SELECT ed.sitedoc FROM etapdocs ed, namedvalues nv WHERE ed.etaptypeid = nv.intvalue AND ed.freqpermid = fp.freqpermid AND nv.id = 'FreqLicenceExp') ");
		}
	}

	if(isAdmin != null && isAdmin.booleanValue()) {
		if(useRegions != null && useRegions.booleanValue()) {
			sqlb.append("AND (fp.freqpermid IN (SELECT p2h.freqpermid ");
			sqlb.append("FROM positions p, hops h, perm2hops p2h, equipment e ");
			sqlb.append("WHERE p2h.hopsid = h.hopsid AND h.equipmentid_enda = e.equipment AND e.position = p.storageplace ");
			appendIN(sqlb, "AND p.regionid ", regions);
			sqlb.append(") OR fp.freqpermid IN (SELECT p2h.freqpermid ");
			sqlb.append("FROM positions p, hops h, perm2hops p2h, equipment e ");
			sqlb.append("WHERE p2h.hopsid = h.hopsid AND h.equipmentid_endb = e.equipment AND e.position = p.storageplace ");
			appendIN(sqlb, "AND p.regionid ", regions);
			sqlb.append(") ) ");
		} else if(useSuperregions != null && useSuperregions.booleanValue()) {
			sqlb.append("AND (fp.freqpermid IN (SELECT p2h.freqpermid ");
			sqlb.append("FROM regions reg, positions p, hops h, perm2hops p2h, equipment e ");
			sqlb.append("WHERE p2h.hopsid = h.hopsid AND h.equipmentid_enda = e.equipment AND e.position = p.storageplace AND reg.regionid = p.regionid ");
			appendIN(sqlb, "AND reg.supregid ", superregions);
			sqlb.append(") OR fp.freqpermid IN (SELECT p2h.freqpermid ");
			sqlb.append("FROM regions reg, positions p, hops h, perm2hops p2h, equipment e ");
			sqlb.append("WHERE p2h.hopsid = h.hopsid AND h.equipmentid_endb = e.equipment AND e.position = p.storageplace AND reg.regionid = p.regionid ");
			appendIN(sqlb, "AND reg.supregid ", superregions);
			sqlb.append(") ) ");
		}
	} else {
		sqlb.append("AND (fp.freqpermid IN ");
		sqlb.append("(SELECT p2h.freqpermid FROM regions reg, positions p, hops h, perm2hops p2h, equipment e ");
		sqlb.append("WHERE p2h.hopsid = h.hopsid AND h.equipmentid_enda = e.equipment AND e.position = p.storageplace AND reg.regionid = p.regionid ");
		sqlb.append("AND (reg.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewfact = 'Y' AND ra.operatorid = ?) ");
		sqlb.append("OR reg.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewfact = 'Y' AND sra.operatorid = ?)) ");
		params.add(userid);
		params.add(userid);

		if(useRegions != null && useRegions.booleanValue()) {
			appendIN(sqlb, "AND reg.regionid ", regions);
		} else if(useSuperregions != null && useSuperregions.booleanValue()) {
			appendIN(sqlb, "AND reg.supregid ", superregions);
		}
		
		sqlb.append(") ");

		sqlb.append("OR fp.freqpermid IN ");
		sqlb.append("(SELECT p2h.freqpermid FROM regions reg, positions p, hops h, perm2hops p2h, equipment e ");
		sqlb.append("WHERE p2h.hopsid = h.hopsid AND h.equipmentid_endb = e.equipment AND e.position = p.storageplace AND reg.regionid = p.regionid ");
		sqlb.append("AND (reg.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewfact = 'Y' AND ra.operatorid = ?) ");
		sqlb.append("OR reg.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewfact = 'Y' AND sra.operatorid = ?)) ");
		params.add(userid);
		params.add(userid);
		if(useRegions != null && useRegions.booleanValue()) {
			appendIN(sqlb, "AND reg.regionid ", regions);
		} else if(useSuperregions != null && useSuperregions.booleanValue()) {
			appendIN(sqlb, "AND reg.supregid ", superregions);
		}
		sqlb.append(") ");
		sqlb.append(") ");
	}
/*	
	if((useSuperregions != null && useSuperregions.booleanValue()) || (useRegions != null && useRegions.booleanValue())) {
		sqlb.append("AND fp.freqpermid IN ( ");
		sqlb.append("SELECT UNIQUE p2h.freqpermid ");
		sqlb.append("FROM perm2hops p2h, hops h, equipment e, positions p, regions reg ");
		if(isAdmin != null && !isAdmin.booleanValue()) {
			sqlb.append(", outer regionsaccess sra, outer regionsaccess ra, operators o ");
		}
		sqlb.append("WHERE p2h.hopsid = h.hopsid AND (h.equipmentid_enda = e.equipment OR h.equipmentid_endb = e.equipment) AND e.position = p.storageplace AND reg.regionid = p.regionid ");
		if(isAdmin != null && !isAdmin.booleanValue()) {
			sqlb.append("AND sra.accesstype = 'S' AND sra.supregionid = reg.supregid AND sra.operatorid = o.operator ");
			sqlb.append("AND ra.accesstype = 'R' AND ra.regionid = reg.regionid AND ra.operatorid = o.operator ");
			sqlb.append("AND p.regionid IN (SELECT r.regionid FROM regions r WHERE r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewfact = 'Y' AND ra.operatorid = o.operator) OR r.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewfact = 'Y' AND sra.operatorid = o.operator)) ");
			sqlb.append("AND o.loiginid = ? ");
			if(username != null) {
				params.add(username);
			} else {
				params.add("");
			}
		}
		if (useRegions != null && useRegions.booleanValue()) {
			appendIN(sqlb, "AND p.regionid ", regions);
		} else if (useSuperregions.booleanValue() && useSuperregions.booleanValue()) {
			appendIN(sqlb, "AND reg.supregid ", superregions);
		}
		sqlb.append(") ");
	}
*/

	if(order != null) {
		switch( order.intValue() ) {
		case  1: sqlb.append("ORDER BY freqnumber ASC "); break;
		case  2: sqlb.append("ORDER BY freqnumber DESC "); break;
		case  3: sqlb.append("ORDER BY beereqnumber ASC "); break;
		case  4: sqlb.append("ORDER BY beereqnumber DESC "); break;
		case  5: sqlb.append("ORDER BY beereqdate ASC, beereqnumber ASC "); break;
		case  6: sqlb.append("ORDER BY beereqdate DESC, beereqnumber ASC "); break;
		case  7: sqlb.append("ORDER BY freqnumber ASC "); break;
		case  8: sqlb.append("ORDER BY freqnumber DESC "); break;
		case  9: sqlb.append("ORDER BY freqdate ASC, freqnumber ASC "); break;
		case 10: sqlb.append("ORDER BY freqdate DESC, freqnumber ASC "); break;
		case 11: sqlb.append("ORDER BY filenumber ASC "); break;
		case 12: sqlb.append("ORDER BY filenumber DESC "); break;
		}
	}

System.out.println("Freq Params[isAdmin:"+isAdmin+", User:"+username+", Id:"+userid);
System.out.println("Freq SQL:\n"+sqlb.toString()+"\n");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	tc.finish(" CDBC Files List ");
	return res;
}
public CDBCResultSet findFrequencyLicenceEquipment(Integer freqpermid) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE r.model FROM resources r WHERE r.resource IN ");
	sqlb.append("(SELECT ce.resource FROM comequipment ce, hops h ");
	sqlb.append("WHERE ce.equipment = h.equipmentid_enda AND r.resource = ce.resource AND h.hopsid IN (SELECT p2h.hopsid FROM perm2hops p2h WHERE ");
/*	
	sqlb.append("SELECT DISTINCT r.model ");
	sqlb.append("FROM perm2hops p2h, hops h, equipment e, storageplaces sp, comequipment ce, resources r ");
	sqlb.append("WHERE p2h.hopsid = h.hopsid ");
	sqlb.append("    AND (e.equipment = h.equipmentid_enda OR e.equipment = h.equipmentid_endb) ");
	sqlb.append("    AND e.equipment = sp.storageplace ");
	sqlb.append("    AND ce.equipment = e.equipment ");
	sqlb.append("    AND ce.resource = r.resource ");
*/
	if(freqpermid != null) {
		sqlb.append(" freqpermid = ? ");
		params.add(freqpermid);
	} else {
		sqlb.append(" freqpermid IS NULL ");
	}
	sqlb.append(" )) ");
	sqlb.append("ORDER BY r.model ");	

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findFrequencyLicenceHistory(Integer freqpermid, Integer order) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT ed.sitedoc, et.ettypename, sd.blanknumber, sd.blankdate, sd.expiredate, sd.comment ");
	sqlb.append("FROM etapdocs ed, sitedocs sd, etaptype et ");
	sqlb.append("WHERE ed.sitedoc = sd.sitedoc AND et.etaptypeid = ed.etaptypeid ");

	if(freqpermid != null) {
		sqlb.append(" AND ed.freqpermid = ? ");
		params.add(freqpermid);
	} else {
		sqlb.append(" AND ed.freqpermid IS NULL ");
	}

	sqlb.append("ORDER BY sd.blankdate ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findGKRCHDocuments(
	Boolean useSuperregions, Integer[] superregions,
	Boolean useRegions, Integer[] regions,
	Boolean active,
	Boolean useNumber, String number,
	Boolean useResource, Integer resource,
	Boolean useDate, java.sql.Date date,
	Boolean isAdmin, String username,
	Integer order
) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	if(isAdmin != null && isAdmin.booleanValue()) {
		sqlb.append("SELECT sd.sitedoc, sd.blanknumber, sd.blankdate, sd.expiredate ");
		sqlb.append("FROM gkrchdocs gd, sitedocs sd ");
		sqlb.append("WHERE gd.sitedoc = sd.sitedoc ");
	} else {
		sqlb.append("SELECT sd.sitedoc, sd.blanknumber, sd.blankdate, sd.expiredate ");
		sqlb.append("FROM gkrchdocs gd, sitedocs sd, sitedocs2regions s2r, regions r, outer regionsaccess sra, outer regionsaccess ra, operators o ");
		sqlb.append("WHERE gd.sitedoc = sd.sitedoc AND s2r.sitedoc = sd.sitedoc AND s2r.region = r.regionid AND sra.accesstype = 'S' AND sra.supregionid = r.supregid AND sra.operatorid = o.operator ");
		sqlb.append("AND ra.accesstype = 'R' AND ra.regionid = r.regionid AND ra.operatorid = o.operator ");
		sqlb.append("AND s2r.region IN (SELECT r.regionid FROM regions r WHERE r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.viewfact = 'Y' AND ra.operatorid = o.operator) OR r.supregid IN (SELECT sra.supregionid FROM regionsaccess sra WHERE sra.accesstype = 'S' AND sra.viewfact = 'Y' AND sra.operatorid = o.operator)) ");
		sqlb.append("AND o.loiginid = ? ");
		if(username != null) {
			params.add(username);
		} else {
			params.add("");
		}
	}

	if(active != null && active.booleanValue()) {
		sqlb.append("AND sd.expiredate >= ? ");
		params.add(new java.sql.Date(System.currentTimeMillis()));
	}

	if(useNumber != null && useNumber.booleanValue()) {
		if(number != null) {
			sqlb.append("AND LOWER(sd.blanknumber) MATCHES LOWER(?) ");
			params.add(number);
		} else {
			sqlb.append("AND sd.blanknumber IS NULL ");
		}
	}

	if(useResource != null && useResource.booleanValue()) {
		if(resource != null) {
			sqlb.append("AND gd.sitedoc IN (SELECT sitedoc FROM sitedocs2resources WHERE resource = ?) ");
			params.add(resource);
		} else {
			sqlb.append("AND gd.sitedoc IN (SELECT sitedoc FROM sitedocs2resources WHERE resource IS NULL) ");
		}
		
	}

	if(useDate != null && useDate.booleanValue()) {
		if(date != null) {
			sqlb.append("AND sd.blankdate = ? ");
			params.add(date);
		} else {
			sqlb.append("AND sd.blankdate IS NULL ");
		}
	}

	if((useSuperregions != null && useSuperregions.booleanValue()) || (useRegions != null && useRegions.booleanValue())) {
		sqlb.append("AND EXISTS (SELECT sdr.sitedoc FROM sitedocs2regions sdr, regions reg WHERE sdr.region = reg.regionid AND sdr.sitedoc = sd.sitedoc ");
		if (useRegions != null && useRegions.booleanValue()) {
			System.out.println("CDBC GKRCH: append regions");
			appendIN(sqlb, "AND sdr.region ", regions);
		} else if (useSuperregions.booleanValue() && useSuperregions.booleanValue()) {
			System.out.println("CDBC GKRCH: append superregions");
			appendIN(sqlb, "AND reg.supregid ", superregions);
		}
		sqlb.append(") ");
	}

	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY sd.blanknumber ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY sd.blanknumber DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY sd.blankdate ASC, sd.blanknumber ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY sd.blankdate DESC, sd.blanknumber ASC ");
			break;
		}
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findGKRCHFiles(Integer sitedoc)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT sf.sitedocfile, sf.sitedocfiledate, sitedocfilename, sf.note FROM sitedocfiles sf WHERE");
	if(sitedoc != null) {
		sqlb.append(" sf.sitedoc = ? ");
		params.add(sitedoc);
	} else {
		sqlb.append(" sf.sitedoc IS NULL ");
	}
	sqlb.append("ORDER BY sf.sitedocfilename ASC");
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findGKRCHRegions(Integer sitedoc)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.regionid, r.regname, r.supregid, sr.supregname ");
	sqlb.append("FROM regions r, superregions sr, sitedocs2regions sdr ");
	sqlb.append("WHERE r.regionid = sdr.region AND r.supregid = sr.supregid AND ");
	if(sitedoc != null) {
		sqlb.append("sdr.sitedoc = ? ");
		params.add(sitedoc);
	} else {
		sqlb.append("sdr.sitedoc IS NULL ");
	}
	sqlb.append("ORDER BY r.regname ASC");
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public Integer findNewFrequencyLicenceComlineNumber(Integer permid) {
	Integer result = new Integer(1);
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT max(numberinfile)+1 newnumberinfile FROM perm2hops p2h WHERE ");
	if(permid != null) {
		sqlb.append("p2h.freqpermid = ? ");
		params.add(permid);
	} else {
		sqlb.append("p2h.freqpermid IS NULL ");
	}
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());

	ListIterator li = res.listIterator();

	if(li.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)li.next();
		if(ro.getColumn("newnumberinfile").asObject() != null) {
			result = new Integer(((Number)ro.getColumn("newnumberinfile").asObject()).intValue());
		}
	}

	return result;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findRRLDocuments(
	Boolean active,
	Boolean useNumber, String number,
	Boolean useResource, Integer resource,
	Boolean useDate, java.sql.Date date,
	Boolean useOrg, Integer org,
	Integer order
) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT sd.sitedoc, sd.blanknumber, sd.blankdate, sd.expiredate, rd.organization, o.shortname orgname ");
	sqlb.append("FROM rrldocs rd, sitedocs sd, organizations o ");
	sqlb.append("WHERE rd.sitedoc = sd.sitedoc AND o.organization = rd.organization ");

	if(active != null && active.booleanValue()) {
		sqlb.append("AND sd.expiredate >= ? ");
		params.add(new java.sql.Date(System.currentTimeMillis()));
	}

	if(useNumber != null && useNumber.booleanValue()) {
		if(number != null) {
			sqlb.append("AND LOWER(sd.blanknumber) MATCHES LOWER(?) ");
			params.add(number);
		} else {
			sqlb.append("AND sd.blanknumber IS NULL ");
		}
	}

	if(useResource != null && useResource.booleanValue()) {
		if(resource != null) {
			sqlb.append("AND sd.sitedoc IN (SELECT sitedoc FROM sitedocs2resources WHERE resource = ?) ");
			params.add(resource);
		} else {
			sqlb.append("AND sd.sitedoc IN (SELECT sitedoc FROM sitedocs2resources WHERE resource IS NULL) ");
		}
		
	}

	if(useDate != null && useDate.booleanValue()) {
		if(date != null) {
			sqlb.append("AND sd.blankdate = ? ");
			params.add(date);
		} else {
			sqlb.append("AND sd.blankdate IS NULL ");
		}
	}

	if(useOrg != null && useOrg.booleanValue()) {
		if(org != null) {
			sqlb.append("AND rd.organization = ? ");
			params.add(org);
		} else {
			sqlb.append("AND rd.organization IS NULL ");
		}
	}

	
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY sd.blanknumber ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY sd.blanknumber DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY sd.blankdate ASC, sd.blanknumber ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY sd.blankdate DESC, sd.blanknumber ASC ");
			break;
		}
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findSitedocByObject(String fn, Integer objid, Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT sd.sitedoc, sd.blankdate, TRIM(sd.blanknumber) blanknumber, NVL(TRIM(et.ettypename),TRIM(st.sitedoctypename)) sitedoctypename, sd.expiredate, TRIM(sd.comment) comment, ed.sitedoc etapdocid ");
	sqlb.append("FROM sitedocs sd, sitedoctypes st, outer (etapdocs ed, etaptype et) ");
	sqlb.append("WHERE sd.sitedoctype = st.sitedoctype AND sd.sitedoc = ed.sitedoc AND ed.etaptypeid = et.etaptypeid ");

	if(fn == null) { fn = "E"; }
	if(objid == null) { objid = new Integer(0); }
	
	if("E".equals(fn)) { // Equipment
		sqlb.append("AND sd.sitedoc IN (SELECT sitedoc FROM sitedocs2splace WHERE storageplace = ?) ");
		params.add(objid);
	} else if("P".equals(fn)) { // Position
		sqlb.append("AND (sd.sitedoc IN (SELECT s.sitedoc FROM sitedocs2splace s WHERE s.storageplace = ?) ");
		sqlb.append("OR sd.sitedoc IN (SELECT s.sitedoc FROM sitedocs2splace s, equipment e WHERE e.position=? AND s.storageplace = e.equipment)) ");
		params.add(objid);
		params.add(objid);
	} else if("R".equals(fn)) { // Project
		sqlb.append("AND sd.projectaction IN (SELECT projectaction FROM projectactions WHERE project = ?) ");
		params.add(objid);
	} else if("A".equals(fn)) { // Project Action
		sqlb.append("AND sd.projectaction = ? ");
		params.add(objid);
	} else if("H".equals(fn)) { // Hops
		sqlb.append("AND sd.sitedoc IN (SELECT sitedoc FROM sitedocs2hops WHERE hopsid = ?) ");
		params.add(objid);
	}

	if(order != null) {
		switch(order.intValue()) {
		case 1:
			sqlb.append("ORDER BY sd.blankdate ASC, blanknumber ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY sd.blankdate DESC, blanknumber DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY blanknumber ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY blanknumber DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY sitedoctypename ASC, sd.blankdate ASC, blanknumber ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY sitedoctypename DESC, sd.blankdate DESC, blanknumber DESC ");
			break;
		}
	}
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}

public static void appendIN(StringBuffer sb, String param, int[] array)
{
	if(array == null) {
		return;
	} else if(array.length == 0)  {
		sb.append(param);
		sb.append(" IS NULL ");
	} else {
		sb.append(param);
		sb.append(" IN (");
		for(int i = 0; i < array.length; i++) {
			if(i > 0) sb.append(",");
			sb.append(array[i]);
		}
		sb.append(") ");
	}
}

public CDBCResultSet findFrequencyLicencePositions(
	int[] positions
) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT p.gsmid, TRIM(sp.name) || NVL(', ' || TRIM(p.dampsname),'') posname, TRIM(sp.address) addr, TRIM(p.docaddress) docaddr ");
	sqlb.append("FROM positions p, storageplaces sp ");
	sqlb.append("WHERE sp.storageplace = p.storageplace ");
	if(positions != null && positions.length > 0) {
		appendIN(sqlb," AND p.storageplace ",positions);
	} else {
		sqlb.append("AND p.storageplace IS NULL ");
	}
	sqlb.append("ORDER BY p.gsmid ");

System.out.println("SQL:\n"+sqlb.toString()+"\n");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}

public CDBCResultSet findFrequencyLicencePositions(
	Integer freqpermid,
	String filter,
	Integer order
) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT p.storageplace, p.gsmid, p.dampsid, ");
	sqlb.append("TRIM(sp.name) || NVL(', ' || TRIM(p.dampsname),'') posname, ");
	sqlb.append("TRIM(sp.address) posaddress, p.inaction, p.posstate, ");
	sqlb.append("p.haveplan, p.orderno, ");
	sqlb.append("getSiteDoc(p.storageplace, ?) waymap, ");
	sqlb.append("getSiteDoc(p.storageplace, ?) passlist ");
	sqlb.append("FROM positions p, storageplaces sp ");
	sqlb.append("WHERE p.storageplace = sp.storageplace "); 
	sqlb.append("AND p.storageplace ");
	sqlb.append("IN ( ");
	sqlb.append("SELECT e.position FROM perm2hops p2h, hops h, equipment e WHERE p2h.hopsid = h.hopsid AND h.hopstype = 'R' ");
	sqlb.append("AND (e.equipment = h.equipmentid_enda OR e.equipment = h.equipmentid_endb) ");

	params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("WayMapDocType")));
	params.add(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("PassListDocType")));

	if(freqpermid != null) {
		sqlb.append(" AND freqpermid = ? ");
		params.add(freqpermid);
	} else {
		sqlb.append(" AND freqpermid IS NULL ");
	}
	sqlb.append(" ) ");

	if(filter != null && !"*".equals(filter)) {
		if("1".equals(filter)) {
		sqlb.append(" AND p.haveplan IS NULL ");
		} else
		if("2".equals(filter)) {
		sqlb.append(" AND p.haveplan IS NULL ");
		sqlb.append(" AND p.orderno IS NULL ");
		}
	}

	switch (order.intValue()) {
	case 1 : sqlb.append("ORDER BY p.storageplace ASC "); break;
	case 2 : sqlb.append("ORDER BY p.storageplace DESC "); break;
	case 3 : sqlb.append("ORDER BY posname ASC "); break;
	case 4 : sqlb.append("ORDER BY posname DESC "); break;
	case 5 : sqlb.append("ORDER BY p.gsmid ASC "); break;
	case 6 : sqlb.append("ORDER BY p.gsmid DESC "); break;
	case 7 : sqlb.append("ORDER BY p.dampsid ASC "); break;
	case 8 : sqlb.append("ORDER BY p.dampsid DESC "); break;
	}

System.out.println("FREQPOSLIST SQL:\n"+sqlb.toString()+"\n");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}

public int findFrequencyLicencePositionsCnt(String filenumber)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE e.position ");
	sqlb.append("FROM freqpermissions f, perm2hops p2h, hops h, equipment e ");
	sqlb.append("WHERE f.freqpermid = p2h.freqpermid AND p2h.hopsid = h.hopsid ");
	sqlb.append("AND (e.equipment = h.equipmentid_enda OR e.equipment = h.equipmentid_endb) ");

	if(filenumber != null) {
		sqlb.append(" AND f.filenumber = ? ");
		params.add(filenumber);
	} else {
		sqlb.append(" AND f.filenumber IS NULL ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res.getRowsCount();
}

public int findFrequencyLicencePositionsCount(
	Integer freqpermid,
	String filter
) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE p.storageplace ");
	sqlb.append("FROM perm2hops p2h, hops h, equipment e, positions p ");
	sqlb.append("WHERE p.storageplace = e.position AND p2h.hopsid = h.hopsid AND h.hopstype = 'R' ");
	sqlb.append("AND (e.equipment = h.equipmentid_enda OR e.equipment = h.equipmentid_endb) ");

	if(freqpermid != null) {
		sqlb.append(" AND freqpermid = ? ");
		params.add(freqpermid);
	} else {
		sqlb.append(" AND freqpermid IS NULL ");
	}

	if(filter != null && !"*".equals(filter)) {
		if("1".equals(filter)) {
		sqlb.append(" AND p.haveplan IS NULL ");
		} else
		if("2".equals(filter)) {
		sqlb.append(" AND p.haveplan IS NULL ");
		sqlb.append(" AND p.orderno IS NULL ");
		}
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res.getRowsCount();
}

public void updateFrequencyLicencePositionsHaveplan(String haveplan, int[] positions)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	CDBCResultSet res = new CDBCResultSet();

	if(positions != null) {
		sqlb.append("UPDATE positions ");
		if(haveplan != null) {
			sqlb.append("SET haveplan = ? WHERE ");
			params.add(haveplan);
		} else {
			sqlb.append("SET haveplan = NULL WHERE ");
		}
		appendIN(sqlb," storageplace ",positions);

		System.out.println("UPDATE POSITIONS:SQL:"+sqlb.toString());
		res.executeUpdate(sqlb.toString(), params.toArray());
	}
}

public void updateFrequencyLicencePositionsOrderno(String orderno, int[] positions)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	CDBCResultSet res = new CDBCResultSet();

	if(positions != null) {
		sqlb.append("UPDATE positions ");
		if(orderno != null) {
			sqlb.append("SET orderno = ? WHERE ");
			params.add(orderno);
		} else {
			sqlb.append("SET ordrno = NULL WHERE ");
		}
		appendIN(sqlb," storageplace ",positions);

		System.out.println("UPDATE POSITIONS:SQL:"+sqlb.toString());
		res.executeUpdate(sqlb.toString(), params.toArray());
	}
}
}
