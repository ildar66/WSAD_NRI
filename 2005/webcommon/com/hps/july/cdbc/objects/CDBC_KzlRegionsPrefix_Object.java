package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import java.util.*;
import java.sql.Date;
import com.hps.july.basestation.valueobject.*;
/**
* Insert the type's description here.
* Creation date: (18.08.2005 16:12:17)
* @author: Shafigullin Ildar
*/
public class CDBC_KzlRegionsPrefix_Object {
    private static final String FIND_LIST_FROM_POSITION_SQL =
        "SELECT kzlregpref.regionid, kzlregpref.cellid_prefix, kzlregpref.cellname_prefix, kzlregpref.group_prefix, kzlregpref.super_prefix "
            + "FROM kzlregionsprefix kzlregpref, kzlregion kzlreg WHERE kzlregpref.recordstatus ='A' "
            + "AND kzlreg.regionnri = (SELECT sreg.supregid FROM superregions sreg, regions reg, positions pos WHERE sreg.supregid=reg.supregid AND reg.regionid=pos.regionid AND pos.storageplace = ?) "
            + "AND kzlregpref.regionid = kzlreg.regionid ";
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 16:35:27)
 */
public static List getKzlRegionPrefixList(Integer positionID, Integer regionID, String sortBy) {
    List ret = new ArrayList();
    CDBCRowObject ro = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { positionID, regionID };
    String sql = FIND_LIST_FROM_POSITION_SQL + " AND kzlregpref.regionid = ? ";
    if (sortBy != null)
        sql += " order by " + sortBy;
    res.executeQuery(sql, params);
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        ro = (CDBCRowObject) iter.next();
        KzlRegionsPrefix_VO vo = new KzlRegionsPrefix_VO((Integer) ro.getColumn("regionid").asObject());
        vo.setCellid_prefix((Integer)ro.getColumn("cellid_prefix").asObject());
        vo.setCellname_prefix((Integer)ro.getColumn("cellname_prefix").asObject());
        vo.setGroup_prefix((Integer)ro.getColumn("group_prefix").asObject());
        vo.setSuper_prefix((Integer)ro.getColumn("super_prefix").asObject());

        ret.add(vo);
    }
    return ret;
}
}
