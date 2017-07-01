package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import java.util.*;
import java.math.BigDecimal;
import java.sql.Date;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.inventory.formbean.ConfigEqEditForm;
import com.hps.july.inventory.valueobject.AntennVO;
import com.hps.july.inventory.valueobject.BSEquipCommonVO;
import com.hps.july.inventory.valueobject.StandVO;
/**
 * Объект для работы с БС.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Shafigullin Ildar
 */
public class CDBCBaseStationObject {
    private final static java.lang.String POSITION_DOP_INFO_SQL =
        "SELECT p.storageplace, p.gsmid, p.dampsid, p.longitude, p.latitude, s.address, s.name, "
            + "applacetypes.name applacetypeName,    apparattypes.name  apparattypename, "
            + "apparatplaces.name apparatplacename,   oporaplaces.name oporaplacename, "
            + "antennplaces.name antennplacename,    antennplaces.isvc,   p.oporaour, getNameOtv2Pos(3, p.storageplace)  nameOtvPos, getNameOtv2Pos(7, p.storageplace)  nameOtvBS "
            + "FROM positions p,   storagePlaces s,   outer applacetypes,  outer apparattypes,   outer apparatplaces,  outer oporaplaces,  outer antennplaces "
            + "WHERE  p.storagePlace = s.storagePlace "
            + "AND apparattypes.aptypeid = p.aptypeid "
            + "AND applacetypes.applacetypeid = p.applacetypeid "
            + "AND apparatplaces.applaceid = p.applaceid "
            + "AND oporaplaces.oplaceid = p.oporplaceid "
            + "AND antennplaces.antplaceid = p.antplaceid ";
    private final static java.lang.String REPITER_LIST_SQL =
        "SELECT er.equipment, er.position, er.state, er.pwr_val, er.pwr_cat, er.pwr_reserve, er.pwr_res_cat, er.date_bldbeg, er.date_assemb, er.date_test, er.date_pr, er.equipcomment, "
            + "rp.donor_sect, rp.donor_ant, rp.donor_type, rp.repiter_class, rp.resource, rp.reppower, rp.bandwidth, rp.numchanals, rp.number, "
            + "'D' || bs.number || ' ' || bs.name donorBS,  "
            + "bs.equipment bsequ, "
            + "getNameAntennaBs(rp.donor_ant, 0) donorAntenn, "
            + "CASE sec.band "
            + "	WHEN 800 THEN DECODE(SUBSTR(num_sect,LENGTH(TRIM(num_sect)),1), '0','O', '1','A', '2','B', '3','C', '4','D', '5','E', '6','F', '7','G', num_sect) "
            + "	WHEN 900 THEN DECODE(SUBSTR(num_sect,LENGTH(TRIM(num_sect)),1), '5','E', '6','F', '7','G', '8','H', '9','O', num_sect)  "
            + "	WHEN 1800 THEN DECODE(SUBSTR(num_sect,LENGTH(TRIM(num_sect)),1), '0','O', '1','A', '2','B', '3','C', '4','D', num_sect)  "
            + "END donorSector  "
            + "FROM repiters rp, equipment er, sectors sec, basestations bs "
            + "WHERE rp.equipment = er.equipment "
            + "AND sec.id_sect = rp.donor_sect "
            + "AND sec.equipment = bs.equipment "
            + "AND er.position = ?";
    private final static java.lang.String BS_LIST_SQL =
        " SELECT  e.equipment, e.position, e.state, e.pwr_val, e.pwr_cat, e.pwr_reserve, e.pwr_res_cat, e.date_bldbeg, e.date_assemb, e.date_test, e.date_pr, e.equipcomment, "
            + "bs.equipment, bs.controller, bs.switch, DECODE(bs.type,'D','DAMPS','S','GSM 900','C','DCS 1800','G','GSM 900/1800','?') type , bs.repeater, bs.number, TRIM(bs.name) name, bs.n_stoek, bs.st_transp, bs.time_backup, bs.date_assemb_afs, bs.date_assemb_afs2, "
            + "bs.date_connect, bs.date_connect2, bs.date_onair, bs.date_onair2, bs.net_stage, bs.con_type, bs.e1_qty, bs.on_air, bs.date_bldbeg2, bs.date_assemb2, bs.date_test2, bs.date_pr2, bs.prefixcellid "
            + "FROM basestations bs,equipment e "
            + "WHERE e.equipment = bs.equipment "
            + "AND e.position = ?";
    private final static java.lang.String CONTROLLER_LIST_SQL =
        "SELECT e.equipment, e.position, e.state, e.pwr_val, e.pwr_cat, e.pwr_reserve, e.pwr_res_cat, e.date_bldbeg, e.date_assemb, e.date_test, e.date_pr, e.equipcomment, "
            + "ctr.switch, ctr.resource, ctr.number, stp.name, ctr.con_type, ctr.ver_po, ctr.qty_shell, ctr.mfs_num, ctr.omcr_num, ctr.lac_numbers, "
            + "ctr.trxfr_qty_max, ctr.trxfr_qty, ctr.trx_use_percent, ctr.atr_qty_max, ctr.trxhr_qty, ctr.atr_qty, ctr.aint_qty, ctr.hway_qty_voice, ctr.hway_qty_gprs "
            + "FROM controllers ctr, equipment e, storageplaces stp "
            + "WHERE ctr.equipment = e.equipment AND e.equipment = stp.storageplace "
            + "AND e.position = ?";
    private final static java.lang.String EQUIPDET_LIST_FROM_POSITION_SQL =
        "SELECT stc.storagecard, res.name, res.manucode, stc.serialnumber, res.model, stc.qty, stc.comment, stc.place "
            + "FROM storagecards stc, resources res, equipment eq, storageplaces stp "
            + "WHERE stc.closed= 'N' AND stc.resource =  res.resource AND stc.storageplace = stp.storageplace "
            + "AND eq.equipment = stp.storageplace AND not exists (select 1 from agregatecontents where agregatepart = stc.storagecard) AND stp.type in ('B', 'O', 'R') AND eq.position = ? ";
    //Список оборудования по Equipment на входе Equipment:            
    private final static java.lang.String EQUIPDET_LIST_SQL =
        "SELECT stc.storagecard, res.name, res.manucode, stc.serialnumber, "
            + "res.model, stc.qty, stc.comment, stc.place, isStorageCardAgregate(stc.storagecard) isAgregate "
            + "FROM storagecards stc, resources res "
            + "WHERE stc.closed= 'N' AND stc.resource =  res.resource AND stc.storageplace =? "
            + "AND not exists (select 1 from agregatecontents where agregatepart = stc.storagecard)";
    //Встроенное оборудование на входе StorageCard
    private final static java.lang.String EQUIPDET_LIST_CONTENT_SQL =
        "SELECT stc.storagecard, res.name, res.manucode, stc.serialnumber, "
            + "res.model, stc.qty, stc.comment, stc.place "
            + "FROM storagecards stc, resources res, agregatecontents agr "
            + "WHERE stc.closed= 'N' AND stc.resource = res.resource "
            + "AND stc.storagecard = agr.agregatepart AND agr.agregate = ?";
    // производители шкафов
	private final static java.lang.String STAND_PRODUCERS_LIST_SQL = 
	"SELECT DISTINCT organizations.organization,  organizations.shortname "+
	"FROM (resources LEFT JOIN organizations ON "+ 
	"resources.manufacturer = organizations.organization) "+ 
	"INNER JOIN basestationres ON resources.resource = basestationres.resource "+
	"WHERE (((basestationres.standard)='G') AND ((resources.active)='Y') AND "+ 
	"((resources.manufacturer) Is Not Null) AND ((resources.resourceclass)='B')) "+
	"ORDER BY organizations.shortname ";
	// производители фидеров
	private final static java.lang.String FIDER_PRODUCERS_LIST_SQL = 
	"SELECT DISTINCT organizations.organization, organizations.shortname "+
	"FROM resources LEFT JOIN organizations ON resources.manufacturer = organizations.organization "+
	"WHERE (((resources.active)='Y') AND ((resources.manufacturer) Is Not Null) AND "+ 
	"((resources.resourceclass)='K')) "+
	"ORDER BY organizations.shortname ";
	// список шкафов для сохраненной конфигурации + базовой станции
	private final static java.lang.String STANDS_ARRAY_FOR_CONFIG_SQL = 
	"SELECT st.standid, st.equipment, st.resource, st.stnomer, st.StorageCard, st.ObjectStatus, st.SavConfigID, st.equipment from CfgBsstands st where st.SavConfigID = ? AND st.equipment = ? order by st.stnomer";
	// список моделей шкафов для известного производителя + текущая модель для шкафа
	private final static java.lang.String STANDS_MODELS_ARRAY_SQL =
	"SELECT DISTINCT resources.resource, resources.model "+
	"FROM (resources INNER JOIN organizations ON resources.manufacturer = "+ 
	"organizations.organization) INNER JOIN basestationres ON "+ 
	"resources.resource = basestationres.resource "+
	"WHERE ((organizations.organization = ?) AND ((basestationres.standard)='G') AND "+ 
	"((resources.active)='Y') AND ((resources.resourceclass)='B')) OR (resources.resource= ?) "+
	"ORDER BY resources.model ";
	// список антенн для сохраненной конфигурации + базовой станции
	private final static java.lang.String ANTENNS_ARRAY_FOR_CONFIG_SQL =
	"SELECT an.id_anten, an.resource, an.num_ant, an.kind_ant, an.nakl, an.az_ant, an.kswn, an.h_set1, an.len_cable, an.cableres, an.az_variation, an.nakl_variation, an.input_power, an.operator, an.byhand, an.groundresource, an.groundcnt, an.locationtype, an.electricaltilt, an.storagecard, an.qty, an.datasource, an.objectstatus, " +
	" res.model, " + 
	" sec900.name_sect as name_sect900 , sec1800.name_sect  as name_sect1800 " +
	" , " +
	" cab900.id_cable as id_cable_900, cab900.cableres as cableres_900, cabres900.model as cab_model_900,  cab900.len_cable as len_cable_900, " + 
	" cab1800.id_cable as id_cable_1800, cab1800.cableres as cableres_1800, cabres1800.model as cab_model_1800,  cab1800.len_cable as len_cable_1800, " + 
	" cabpar900.ksvn as ksvn_900, " +
	" cabpar1800.ksvn as ksvn_1800 " +
	" , " +
	" an.savconfigid, an.equipment " +
	//
	" FROM cfgantennes an, resources res, " + 
	" outer(CfgAnten2sectors a2s900, CfgSectors sec900), outer(CfgAnten2sectors a2s1800, CfgSectors sec1800) " +
	" , " +
	" outer(CfgAntennaCables cab900, CfgCableWorkParams cabpar900, resources cabres900) , " + 
	" outer(CfgAntennaCables cab1800, CfgCableWorkParams cabpar1800, resources cabres1800) " + 
	//
	"WHERE an.savconfigid = ? AND an.equipment = ? " +	" AND (an.resource=res.resource) " +
	" AND (an.id_anten = a2s900.id_anten AND an.SavConfigID = a2s900.SavConfigID AND a2s900.id_sect = sec900.id_sect AND sec900.SavConfigID = a2s900.SavConfigID AND sec900.band = 900 ) " +
	" AND (an.id_anten = a2s1800.id_anten AND an.SavConfigID = a2s1800.SavConfigID AND a2s1800.id_sect = sec1800.id_sect AND sec1800.SavConfigID = a2s1800.SavConfigID  AND sec1800.band = 1800) " +
	" AND (an.id_anten = cab900.id_anten AND an.SavConfigID = cab900.SavConfigID AND an.id_anten = cabpar900.id_anten AND an.SavConfigID = cabpar900.SavConfigID AND cab900.id_cable = cabpar900.id_cable AND cabpar900.band = 900 AND cab900.cableres = cabres900.resource) " +
	" AND (an.id_anten = cab1800.id_anten AND an.SavConfigID = cab1800.SavConfigID AND an.id_anten = cabpar1800.id_anten AND an.SavConfigID = cabpar1800.SavConfigID AND cab1800.id_cable = cabpar1800.id_cable AND cabpar1800.band = 1800 AND cab1800.cableres = cabres1800.resource) " +
	//
	"ORDER BY an.id_anten"; // num_ant ";
	// список фидеров для конкретного производителя (+ текущий)
	private final static java.lang.String FIDER_MODELS_ARRAY_SQL =
	" SELECT DISTINCT resources.resource, resources.model " +
	" FROM resources LEFT JOIN organizations ON resources.manufacturer = organizations.organization " +
	" WHERE ((organizations.organization= ?) AND ((resources.active)='Y') AND " + 
	" ((resources.resourceclass)='K')) OR (resources.resource = ?) " +
	" ORDER BY resources.model ";
	
/**
 * CDBCPositionObject constructor comment.
 */
public CDBCBaseStationObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 14:55:59)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 * @param argPosition java.lang.Integer
 */
public static CDBCResultSet findPositionsDopInfo(boolean isPositionID, int positionID, boolean isGsmId, Integer gsmID, boolean isDampsid, Integer dampsID) {
    CDBCResultSet res = new CDBCResultSet();
    StringBuffer sqlb = new StringBuffer(POSITION_DOP_INFO_SQL);
    if (isPositionID)
        sqlb.append(" AND p.storagePlace = " + positionID);
      if(isGsmId)
      sqlb.append(" AND p.gsmid= " + gsmID);
    if (isDampsid)
        sqlb.append(" AND p.dampsid = " + dampsID);       
    res.executeQuery(sqlb.toString(), null);
    //System.out.println("from CDBCBaseStationObject.findPositionDopInfo sql="+ sqlb.toString());//temp
    return res;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:54:13)
 */
public static List getBSListFromPosition(int positionID, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = BS_LIST_SQL;
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        BaseStation_VO vo = new BaseStation_VO(ro);
        ret.add(vo);
    }
    return ret;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:54:13)
 */
public static CDBCResultSet getBSResSetFromPosition(int positionID, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = BS_LIST_SQL;
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    
    return res;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:54:13)
 */
public static List getControllerListFromPosition(int positionID, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = CONTROLLER_LIST_SQL;
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        Controller_VO vo = new Controller_VO(ro);
        ret.add(vo);
    }
    return ret;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:54:13)
 */
public static CDBCResultSet getControllerResSetFromPosition(int positionID, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = CONTROLLER_LIST_SQL;
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    
    return res;
}
public static final int documentType = 1; 
public static final int jobType = 2; 
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:54:13)
 */
public static List getDocAndWorkListFromPosition(int positionID, int docType) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID), new Integer(docType)};
    String sql = "execute procedure listDocAndWorkForGSM(?,?)";
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        String type = ro.getColumn("col1").asString();
		String docTypeCode = ro.getColumn("col2").asString();
		Integer visualType = (Integer) ro.getColumn("col3").asObject();
		String state = ro.getColumn("col4").asString();
		String isautodoc = ro.getColumn("col5").asString();
        Integer idDoc = (Integer) ro.getColumn("col6").asObject();
        String numberDoc = ro.getColumn("col7").asString();
        java.sql.Date dateDoc = (java.sql.Date) ro.getColumn("col8").asObject();
        String fio = ro.getColumn("col9").asString();
        String typeDoc = ro.getColumn("col10").asString();
        String noteWork = ro.getColumn("col11").asString();
        String nameEquipment = ro.getColumn("col12").asString();
        DocAndWorkForGSM_VO vo =
            new DocAndWorkForGSM_VO(type, docTypeCode, visualType, state, isautodoc, idDoc, numberDoc, dateDoc, fio, typeDoc, noteWork, nameEquipment);
        ret.add(vo);
    }
    return ret;
}
public static Integer getCardCount(Integer equipment) {
	Integer outInt = new Integer(0);
	CDBCRowObject ro = null;
	CDBCResultSet res = new CDBCResultSet();
	Object[] params = { equipment };
	String sql = "execute procedure getCardCount(?)";
	res.executeQuery(sql, params);
	ListIterator iter = res.listIterator();
	if (iter.hasNext()) {
		ro = (CDBCRowObject) iter.next();
		outInt = (Integer) ro.getColumn("col1").asObject();
		System.out.println("getCardCount outInt = "+outInt);
	}
	return outInt;
}

/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:54:13)
 */
public static List getDonorRepiterListFromPosition(int positionID) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = "execute procedure getDonorRepiterFromPosition(?)";
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        String numberGSM = ro.getColumn("col1").asString();
        String namePos = ro.getColumn("col2").asString();
        DonorRepiterVO vo = new DonorRepiterVO(numberGSM, namePos);
        ret.add(vo);
    }
    return ret;
}
/**
 * Список оборудования по Equipment на входе Equipment.
 * Creation date: (29.07.2005 16:33:41)
 */
public static List getEquipDetList(int equipmentID, String sortBy, boolean isContent) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(equipmentID)};
    String sql = EQUIPDET_LIST_SQL;
    if (isContent)
        sql = EQUIPDET_LIST_CONTENT_SQL;
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        StorageCard_VO vo = new StorageCard_VO((Integer) ro.getColumn("storagecard").asObject());
        vo.setSerialnumber(ro.getColumn("serialnumber").asString());
        vo.setQty((java.math.BigDecimal) ro.getColumn("qty").asObject());
        vo.setComment(ro.getColumn("comment").asString());
        vo.setPlace(ro.getColumn("place").asString());
        Equipdet_TO to = new Equipdet_TO(vo);
        to.setManucode(ro.getColumn("manucode").asString());
        to.setModel(ro.getColumn("model").asString());
        to.setName(ro.getColumn("name").asString());
        if (!isContent)
            to.setIsAgregate(ro.getColumn("isagregate").asString());
        ret.add(to);
    }
    return ret;
}

private static final int optionItemNameLength = 30; 

/**
 * Список производителей для шкафов.
 */
public static List getStandsProcucersList() {
	return getOptionItemsList(STAND_PRODUCERS_LIST_SQL, optionItemNameLength);
}

/**
 * Список производителей для фидеров.
 */
public static List getFidersProcucersList() {
	return getOptionItemsList(FIDER_PRODUCERS_LIST_SQL, optionItemNameLength);
}	

private static List getOptionItemsList(String sqlQueryString, int maxNameLength) {
	System.out.println("CDBCBaseStationObject getOptionItemsList begin");
	List ret = new ArrayList();
	OptionItem firstItem = new OptionItem();
	firstItem.setCode("0");
	firstItem.setName("---");
	ret.add(firstItem);
	CDBCRowObject ro = null;
	CDBCResultSet res = new CDBCResultSet();
	String sql = sqlQueryString;
	res.executeQuery(sql);
	System.out.println("CDBCBaseStationObject getOptionItemsList res.executeQuery(sql)");
	ListIterator iter = res.listIterator();
	while (iter.hasNext()) {
		System.out.println("CDBCBaseStationObject getOptionItemsList iter.hasNext()");
		ro = (CDBCRowObject) iter.next();
		String organization = ro.getColumn("organization").asString();
		String shortname = ro.getColumn("shortname").asString();
		OptionItem optionItem = new OptionItem();
		optionItem.setCode(organization);
		if (shortname.length() <= maxNameLength) {
			optionItem.setName(shortname);
		} else {
			optionItem.setName(shortname.substring(0, maxNameLength));
		}
		ret.add(optionItem);
	}
	System.out.println("CDBCBaseStationObject getOptionItemsList end");
	return ret;
}

/**
 * Список оборудования по позиции:.
 * Creation date: (29.07.2005 16:29:20)
 */
public static List getEquipDetListFromPosition(int positionID, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = EQUIPDET_LIST_FROM_POSITION_SQL;
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        StorageCard_VO vo = new StorageCard_VO((Integer)ro.getColumn("storagecard").asObject());
        vo.setSerialnumber(ro.getColumn("serialnumber").asString());
        vo.setQty((java.math.BigDecimal)ro.getColumn("qty").asObject());
        vo.setComment(ro.getColumn("comment").asString());
        vo.setPlace(ro.getColumn("place").asString());
        Equipdet_TO to = new Equipdet_TO(vo);
        to.setManucode(ro.getColumn("manucode").asString());
        to.setModel(ro.getColumn("model").asString());
        to.setName(ro.getColumn("name").asString());
        ret.add(to);
    }
    return ret;
}
/**
 * Список оборудования по позиции:.
 * Creation date: (29.07.2005 16:29:20)
 */
public static CDBCResultSet getEquipResSetFromPosition(int positionID, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = 
        "SELECT stc.storagecard, res.resource,res.name, res.manucode, stc.serialnumber, res.model, stc.qty, stc.comment, stc.place "
            + "FROM storagecards stc, resources res, equipment eq, storageplaces stp "
            + "WHERE stc.closed= 'N' AND stc.resource =  res.resource AND stc.storageplace = stp.storageplace "
            + "AND eq.equipment = stp.storageplace AND not exists (select 1 from agregatecontents where agregatepart = stc.storagecard) AND stp.type in ('B', 'O', 'R') AND eq.position = ? ";
    
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    
    return res;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:54:13)
 */
public static InfoBsGsmOnPosition_VO getInfoBsGsmOnPosition(int positionID) {
    InfoBsGsmOnPosition_VO vo = null;
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = "execute procedure getInfoBsGsmOnPosition(?)";
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    if (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        vo = new InfoBsGsmOnPosition_VO();
        boolean isGSM = ((Integer)ro.getColumn("col1").asObject()).intValue()==1 ? true: false;
        vo.setIsGSM(isGSM);
        boolean isDCS = ((Integer)ro.getColumn("col2").asObject()).intValue()==1 ? true:false;
        vo.setIsDCS(isDCS);
		vo.setNameController(ro.getColumn("col3").asString());
		vo.setCountControllers((Integer)ro.getColumn("col4").asObject());
		vo.setNameOtv(ro.getColumn("col5").asString());
		vo.setMin_date_bldbegGSM((Date)ro.getColumn("col6").asObject());
		vo.setMin_date_bldbegDCS((Date)ro.getColumn("col7").asObject());
		vo.setMin_date_assemb_afsGSM((Date)ro.getColumn("col8").asObject());
		vo.setMin_date_assemb_afsDCS((Date)ro.getColumn("col9").asObject());
		vo.setMin_date_assembGSM((Date)ro.getColumn("col10").asObject());
		vo.setMin_date_assembDCS((Date)ro.getColumn("col11").asObject());
		vo.setMin_date_testGSM((Date)ro.getColumn("col12").asObject());
		vo.setMin_date_testDCS((Date)ro.getColumn("col13").asObject());
		vo.setMin_date_connectGSM((Date)ro.getColumn("col14").asObject());
		vo.setMin_date_connectDCS((Date)ro.getColumn("col15").asObject());
		vo.setMin_date_onairGSM((Date)ro.getColumn("col16").asObject());
		vo.setMin_date_onairDCS((Date)ro.getColumn("col17").asObject());
		vo.setMin_date_prGSM((Date)ro.getColumn("col18").asObject());
		vo.setMin_date_prDCS((Date)ro.getColumn("col19").asObject());
		vo.setTrx_num1800_A((Integer)ro.getColumn("col20").asObject());
		vo.setTrx_num1800_B((Integer)ro.getColumn("col21").asObject());
		vo.setTrx_num1800_C((Integer)ro.getColumn("col22").asObject());
		vo.setTrx_num1800_D((Integer)ro.getColumn("col23").asObject());
		vo.setTrx_num1800_O((Integer)ro.getColumn("col24").asObject());
		vo.setTrx_num900_E((Integer)ro.getColumn("col25").asObject());
		vo.setTrx_num900_F((Integer)ro.getColumn("col26").asObject());
		vo.setTrx_num900_G((Integer)ro.getColumn("col27").asObject());
		vo.setTrx_num900_H((Integer)ro.getColumn("col28").asObject());
		vo.setTrx_num900_O((Integer)ro.getColumn("col29").asObject());
		vo.setState900(ro.getColumn("col30").asString());
		vo.setState1800(ro.getColumn("col31").asString());
		vo.setControllerState(ro.getColumn("col32").asString());
     }
    return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:54:13)
 */
public static List getRepiterListFromPosition(int positionID, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(positionID)};
    String sql = REPITER_LIST_SQL;
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        Repiter_TO vo = new Repiter_TO(new Repiter_VO(ro));
        vo.setDonorBS(ro.getColumn("donorbs").asString());
        vo.setDonorSector(ro.getColumn("donorsector").asString());
        vo.setDonorAntenn(ro.getColumn("donorantenn").asString());
        ret.add(vo);
    }
    return ret;
}
/**
 * @param TEST_CONFIG_NUM
 * @return
 */
public static StandVO[] getStandsArrayForConfiguration(int configId, int baseStationId, int curStandProdId) {
	List ret = new ArrayList();
	CDBCRowObject ro = null;
	CDBCResultSet res = new CDBCResultSet();
	Object[] params = { new Integer(configId), new Integer(baseStationId)};
	String sql = STANDS_ARRAY_FOR_CONFIG_SQL;
	res.executeQuery(sql, params);
	ListIterator iter = res.listIterator();
	while (iter.hasNext()) {
		ro = (CDBCRowObject) iter.next();
		StandVO vo = new StandVO();
		vo.setCurState(ro.getColumn("objectstatus").asString()); 
		vo.setConfigId((Integer)ro.getColumn("SavConfigID").asObject());
		vo.setBaseStationId((Integer)ro.getColumn("equipment").asObject());
		vo.setPartId((Integer)ro.getColumn("standid").asObject());
		vo.setNumber(ro.getColumn("stnomer").asString());
		vo.setCurTypeId(ro.getColumn("resource").asString());
		List curStandModelsList = getStandModelsList(curStandProdId, vo.getCurTypeId());
		vo.setTypes(curStandModelsList);
		ret.add(vo);
	}
	// перелив в обычный массив
	StandVO [] standVoArray = new StandVO[ret.size()];
	for (int i = 0; i < ret.size(); i++) {
		StandVO curStand = (StandVO)ret.get(i);
		standVoArray[i] = curStand;
	}
	return standVoArray;
}

public static AntennVO[] getAntennsArrayForConfiguration(int configId, int baseStationId, int curFiderProdId) {
	List ret = new ArrayList();
	CDBCRowObject ro = null;
	CDBCResultSet res = new CDBCResultSet();
	Object[] params = { new Integer(configId), new Integer(baseStationId)};
	String sql = ANTENNS_ARRAY_FOR_CONFIG_SQL;
	res.executeQuery(sql, params);
	ListIterator iter = res.listIterator();
	while (iter.hasNext()) {
		ro = (CDBCRowObject) iter.next();
		AntennVO vo = new AntennVO();
		vo.setCurState(ro.getColumn("objectstatus").asString()); 
		vo.setConfigId((Integer)ro.getColumn("SavConfigID").asObject());
		vo.setBaseStationId((Integer)ro.getColumn("equipment").asObject());
		vo.setPartId((Integer)ro.getColumn("id_anten").asObject());
		vo.setTypeId((Integer)ro.getColumn("resource").asObject());
		vo.setTypeName(ro.getColumn("model").asString());
		vo.setAzimut((BigDecimal)ro.getColumn("az_ant").asObject());
		vo.setHeight((BigDecimal)ro.getColumn("h_set1").asObject());
		vo.setMaxPitch((BigDecimal)ro.getColumn("nakl").asObject());
		vo.setTr900(ro.getColumn("kind_ant").asString());
		// private String tr1800;
		vo.setImplementation(ro.getColumn("locationtype").asString());
		vo.setSectors900(ro.getColumn("name_sect900").asString());
		vo.setSectors1800(ro.getColumn("name_sect1800").asString());
		// фидеры
		vo.setFider900Id((Integer)ro.getColumn("id_cable_900").asObject());
		vo.setFiderType900Id(ro.getColumn("cableres_900").asString());
		vo.setFiderType900List(getFiderModelsList(new Integer(curFiderProdId), new Integer(getIntegerString(vo.getFiderType900Id()))));
		vo.setFiderType900Name(ro.getColumn("cab_model_900").asString());
		vo.setFider900Length((BigDecimal)ro.getColumn("len_cable_900").asObject());
		//
		vo.setFider1800Id((Integer)ro.getColumn("id_cable_1800").asObject());
		vo.setFiderType1800Id(ro.getColumn("cableres_1800").asString());
		vo.setFiderType1800List(getFiderModelsList(new Integer(curFiderProdId), new Integer(getIntegerString(vo.getFiderType1800Id()))));
		vo.setFiderType1800Name(ro.getColumn("cab_model_1800").asString());
		vo.setFider1800Length((BigDecimal)ro.getColumn("len_cable_1800").asObject());
		// 
		vo.setFiderKSVN900((BigDecimal)ro.getColumn("ksvn_900").asObject());
		vo.setFiderKSVN1800((BigDecimal)ro.getColumn("ksvn_1800").asObject());
		//		
		ret.add(vo);
	}
	// перелив в обычный массив
	AntennVO [] antennVoArray = new AntennVO[ret.size()];
	for (int i = 0; i < ret.size(); i++) {
		AntennVO curAntennVO = (AntennVO)ret.get(i);
		antennVoArray[i] = curAntennVO;
	}
	System.out.println("antennVoArray.length = "+antennVoArray.length);
	return antennVoArray;
}

public static String getIntegerString(String inStr) {
	return (inStr!=null)&&(!"null".equals(inStr))&&(!"".equals(inStr))?inStr:"0";
}

/**
 * @param curStandProdId
 * @param string
 * @return
 */
public static List getStandModelsList(int curStandProdId, String curStandTypeId) {
	return getCommonModelsList(new Integer(curStandProdId), new Integer(getIntegerString(curStandTypeId)), STANDS_MODELS_ARRAY_SQL);
}

public static List getFiderModelsList(Integer curFiderProdId, Integer curFiderTypeId) {
	return getCommonModelsList(curFiderProdId, curFiderTypeId, FIDER_MODELS_ARRAY_SQL);
}

public static List getCommonModelsList(Integer curCommonProdId, Integer curCommonTypeId, String sqlName) {
	List ret = new ArrayList();
	OptionItem firstItem = new OptionItem();
	firstItem.setCode("0");
	firstItem.setName("---");
	ret.add(firstItem);
	if ((curCommonProdId != null) && (curCommonTypeId != null)) {
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { curCommonProdId, curCommonTypeId};
		String sql = sqlName;
		res.executeQuery(sql, params);
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			OptionItem optionItem = new OptionItem();
			optionItem.setCode(ro.getColumn("resource").asString());
			optionItem.setName(ro.getColumn("model").asString());
			ret.add(optionItem);
		}
	}
	return ret;
}

}
