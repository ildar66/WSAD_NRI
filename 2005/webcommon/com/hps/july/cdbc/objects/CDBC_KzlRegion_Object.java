package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import java.util.*;
import java.sql.Date;
import com.hps.july.basestation.valueobject.*;
/**
* Insert the type's description here.
* Creation date: (18.08.2005 14:23:56)
* @author: Shafigullin Ildar
*/
public class CDBC_KzlRegion_Object {
	private static final String FIND_SQL =
		"SELECT regionid, regionname, regioncomment, regiontype, regionpopulation, ruralpopulation, regionarea, regionnri "
			+ "FROM kzlregion WHERE recordstatus='A' ";
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 14:29:42)
 */
public static List getKzlRegionList(Integer positionID, Integer regionType, String sortBy) {
	List ret = new ArrayList();
	CDBCRowObject ro = null;
	CDBCResultSet res = new CDBCResultSet();
	Object[] params = { positionID, regionType };
	String sql =
		FIND_SQL
			+ " AND regionnri = (SELECT sreg.supregid FROM superregions sreg, regions reg, positions pos WHERE sreg.supregid=reg.supregid AND reg.regionid=pos.regionid AND pos.storageplace = ?) AND regiontype=? ";
	if (sortBy != null)
		sql += " order by " + sortBy;
	res.executeQuery(sql, params);
	ListIterator iter = res.listIterator();
	while (iter.hasNext()) {
		ro = (CDBCRowObject) iter.next();
		KzlRegion_VO vo = new KzlRegion_VO((Integer) ro.getColumn("regionid").asObject());
		vo.setRegionname(ro.getColumn("regionname").asString());
		//vo.setRegioncomment(ro.getColumn("regioncomment").asString());
		//vo.setRegiontype((Integer)ro.getColumn("regiontype").asObject());
		//vo.setRegionpopulation((Integer)ro.getColumn("regionpopulation").asObject());
		//vo.setRuralpopulation((Integer)ro.getColumn("ruralpopulation").asObject());
		//vo.setRegionarea((java.math.BigDecimal)ro.getColumn("regionarea").asObject());
		//vo.setRegionnri((Integer)ro.getColumn("regionnri").asObject());
		ret.add(vo);
	}
	return ret;
}
}
