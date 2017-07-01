package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import java.util.*;
import java.sql.Date;
import com.hps.july.basestation.valueobject.*;
/**
* JDBC - Объект для работы с "Сектора базовых станций на позиции".
* Creation date: (07.08.2005 15:05:42)
* @author: Shafigullin Ildar
*/
public class CDBC_Sector_Object {
    private static final String FIND_LIST_SQL =
        "SELECT s.id_sect, TRIM(s.num_sect) num_sect, TRIM(s.name_sect) name_sect, s.band, s.trx_num, "
            + "s.trx_num2, s.trx_num, s.trx_ovr_num, TRIM(s.bts_number) bts_number, bs.type, "
            + "CASE bs.type "
            + "WHEN 'D' THEN NVL(s.trx_num2 || 'A','') || NVL('/' || s.trx_num || 'D','') || NVL('/' || s.trx_ovr_num || 'O','') "
            + "ELSE NVL(s.trx_num, '') "
            + "END trxstring, "
            + "s.lac, s.cellname "
            + "FROM sectors s, basestations bs "
            + "WHERE s.equipment = bs.equipment "
            + "AND s.equipment = ? AND s.planfacttype = 1 ";
    private static final String FIND_SQL =
        "SELECT id_sect, equipment, name_sect, band, num_sect, azimut, power, bts_number, con_abis, "
            + "port_abis, num_po, ddk, trx_num, tx_pwr, trx_num2, tx_pwr2, tx_set_pwr, trx_ovr_num, tx_ovr_set_pwr, "
            + "has_flt, has_lna, has_buster, conf, is_hr, cap_gprs, operator, byhand, lac, rac, cellname, datasource "
            + "FROM sectors ";
    private final static java.lang.String EDIT_SQL =
        "UPDATE sectors SET equipment=?, name_sect=?, band=?, num_sect=?, azimut=?, power=?, bts_number=?, con_abis=?, "
            + "port_abis=?, num_po=?, ddk=?, trx_num=?, tx_pwr=?, trx_num2=?, tx_pwr2=?, tx_set_pwr=?, trx_ovr_num=?, tx_ovr_set_pwr=?, "
            + "has_flt=?, has_lna=?, has_buster=?, conf=?, is_hr=?, cap_gprs=?, operator=?, byhand=?, lac=?, rac=?, cellname=?, datasource=? "
            + "WHERE id_sect=? ";
    private final static java.lang.String ADD_SQL =
        "INSERT INTO sectors (id_sect, equipment, name_sect, band, num_sect, azimut, power, bts_number, con_abis,port_abis, num_po, ddk, trx_num, tx_pwr, trx_num2, tx_pwr2, tx_set_pwr, trx_ovr_num, tx_ovr_set_pwr,has_flt, has_lna, has_buster, conf, is_hr, cap_gprs, operator, byhand, lac, rac, cellname, datasource) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    private final static java.lang.String DELETE_SQL = "DELETE FROM sectors WHERE id_sect = ?";
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 12:14:11)
 */
public static boolean add(Sector_VO vo) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params =
        {
            vo.getId_sect(),
            vo.getEquipment(),
            vo.getName_sect(),
            vo.getBand(),
            vo.getNum_sect(),
            vo.getAzimut(),
            vo.getPower(),
            vo.getBts_number(),
            vo.getCon_abis(),
            vo.getPort_abis(),
            vo.getNum_po(),
            vo.getDdk() == true ? "Y" : "N",
            vo.getTrx_num(),
            vo.getTx_pwr(),
            vo.getTrx_num2(),
            vo.getTx_pwr2(),
            vo.getTx_set_pwr(),
            vo.getTrx_ovr_num(),
            vo.getTx_ovr_set_pwr(),
            vo.getHas_flt() == true ? "Y" : "N",
            vo.getHas_lna() == true ? "Y" : "N",
            vo.getHas_buster() == true ? "Y" : "N",
            vo.getConf(),
            vo.getIs_hr() == true ? "Y" : "N",
            vo.getCap_gprs() == true ? "Y" : "N",
            vo.getOperator(),
            vo.getByhand(),
            vo.getLac(),
            vo.getRac(),
            vo.getCellname(),
            vo.getDatasource(),
            };
    return res.executeUpdate(ADD_SQL, params);
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 12:14:11)
 */
public static boolean delete(Sector_VO vo) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = {vo.getId_sect()};
    return res.executeUpdate(DELETE_SQL, params);
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 12:14:11)
 */
public static boolean edit(Sector_VO vo) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params =
        {
            vo.getEquipment(),
            vo.getName_sect(),
            vo.getBand(),
            vo.getNum_sect(),
            vo.getAzimut(),
            vo.getPower(),
            vo.getBts_number(),
            vo.getCon_abis(),
            vo.getPort_abis(),
            vo.getNum_po(),
            vo.getDdk() == true ? "Y" : "N",
            vo.getTrx_num(),
            vo.getTx_pwr(),
            vo.getTrx_num2(),
            vo.getTx_pwr2(),
            vo.getTx_set_pwr(),
            vo.getTrx_ovr_num(),
            vo.getTx_ovr_set_pwr(),
            vo.getHas_flt() == true ? "Y" : "N",
            vo.getHas_lna() == true ? "Y" : "N",
            vo.getHas_buster() == true ? "Y" : "N",
            vo.getConf(),
            vo.getIs_hr() == true ? "Y" : "N",
            vo.getCap_gprs() == true ? "Y" : "N",
            vo.getOperator(),
            vo.getByhand(),
            vo.getLac(),
            vo.getRac(),
            vo.getCellname(),
            vo.getDatasource(),
            vo.getId_sect()
            };
    return res.executeUpdate(EDIT_SQL, params);
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:59:06)
 * @return com.hps.july.basestation.valueobject.Sector_VO
 * @param sectID int
 */
public static Sector_VO find(int sectID) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(sectID)};
    String sql = FIND_SQL + "WHERE id_sect = ? ";
    res.executeQuery(sql, params);
    ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    Sector_VO vo = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        vo = new Sector_VO((Integer) ro.getColumn("id_sect").asObject());
        vo.setEquipment((Integer) ro.getColumn("equipment").asObject());
        vo.setName_sect(ro.getColumn("name_sect").asString());
        vo.setBand((Short) ro.getColumn("band").asObject());
        vo.setNum_sect(ro.getColumn("num_sect").asString());
        vo.setAzimut((java.math.BigDecimal) ro.getColumn("azimut").asObject());
        vo.setPower((java.math.BigDecimal) ro.getColumn("power").asObject());
        vo.setBts_number(ro.getColumn("bts_number").asString());
        vo.setCon_abis(ro.getColumn("con_abis").asString());
        vo.setPort_abis((Integer) ro.getColumn("port_abis").asObject());
        vo.setNum_po(ro.getColumn("num_po").asString());
        vo.setDdk("Y".equals(ro.getColumn("ddk").asString())? true: false);
        vo.setTrx_num((Integer) ro.getColumn("trx_num").asObject());
        vo.setTx_pwr((java.math.BigDecimal) ro.getColumn("tx_pwr").asObject());
        vo.setTrx_num2((Integer) ro.getColumn("trx_num2").asObject());
        vo.setTx_pwr2((java.math.BigDecimal) ro.getColumn("tx_pwr2").asObject());
        vo.setTx_set_pwr((java.math.BigDecimal) ro.getColumn("tx_set_pwr").asObject());
        vo.setTrx_ovr_num((Integer) ro.getColumn("trx_ovr_num").asObject());
        vo.setTx_ovr_set_pwr((java.math.BigDecimal) ro.getColumn("tx_ovr_set_pwr").asObject());
        vo.setHas_flt("Y".equals(ro.getColumn("has_flt").asString())? true: false);
        vo.setHas_lna("Y".equals(ro.getColumn("has_lna").asString())? true: false);
        vo.setHas_buster("Y".equals(ro.getColumn("has_buster").asString())? true: false);
        vo.setConf(ro.getColumn("conf").asString());
        vo.setIs_hr("Y".equals(ro.getColumn("is_hr").asString())? true: false);
        vo.setCap_gprs("Y".equals(ro.getColumn("cap_gprs").asString())? true: false);
        vo.setOperator((Integer) ro.getColumn("operator").asObject());
        vo.setByhand(ro.getColumn("byhand").asString());
        vo.setLac((Integer) ro.getColumn("lac").asObject());
        vo.setRac((Integer) ro.getColumn("rac").asObject());
        vo.setCellname((Integer) ro.getColumn("cellname").asObject());
        vo.setDatasource((Integer) ro.getColumn("datasource").asObject());
    }
    return vo;
}
/**
 * Сектора базовых станций на позиции по Equipment.
 * Creation date: (29.07.2005 16:33:41)
 */
public static List getList(int equipmentID, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(equipmentID)};
    String sql = FIND_LIST_SQL;
    //append order by clause:
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        Sector_VO vo = new Sector_VO((Integer) ro.getColumn("id_sect").asObject());
        vo.setNum_sect(ro.getColumn("num_sect").asString());
        vo.setName_sect(ro.getColumn("name_sect").asString());
        vo.setBand((Short) ro.getColumn("band").asObject());
        vo.setTrx_num((Integer) ro.getColumn("trx_num").asObject());
        vo.setTrx_ovr_num((Integer) ro.getColumn("trx_ovr_num").asObject());
        vo.setBts_number(ro.getColumn("bts_number").asString());
        vo.setLac((Integer) ro.getColumn("lac").asObject());
        vo.setCellname((Integer) ro.getColumn("cellname").asObject());
        Sector_TO to = new Sector_TO(vo);
        to.setTrxstring(ro.getColumn("trxstring").asString());
        ret.add(to);
    }
    return ret;
}
}
