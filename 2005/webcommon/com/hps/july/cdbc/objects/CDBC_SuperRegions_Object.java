package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.SuperRegion_VO;

import java.util.*;
/**
* CDBC_Object.
* Creation date: (18.08.2005 12:25:04)
* @author: Shafigullin Ildar
*/
public class CDBC_SuperRegions_Object {
	private static final String FIND_SQL = "SELECT supregid, supregname, supregcode FROM superregions ";
	private static final String GET_INDEX_FROM_POSITION_SQL =
		"SELECT sreg.supregcode FROM superregions sreg, regions reg, positions pos "
			+ "WHERE sreg.supregid=reg.supregid AND reg.regionid=pos.regionid "
			+ "AND pos.storageplace = ? ";
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 12:52:37)
	 */
	public static Integer getIndexFromPosition(Integer positionID) {
		Integer ret = null;
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { positionID };
		res.executeQuery(GET_INDEX_FROM_POSITION_SQL, params);
		ListIterator iter = res.listIterator();
		if (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			ret = (Integer) ro.getColumn("supregcode").asObject();
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 14:29:42)
	 */
	public static List getList(
		Boolean isSupRegName,
		String supRegName,
		Boolean isSupRegID,
		Integer supRegID,
		Boolean isSupRegCode,
		Integer supRegCode,		
		String sortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(FIND_SQL);
		sb.append(" WHERE 1=1 ");
		//calculate where clause:			
		if (isSupRegName.booleanValue()) {
			sb.append(" AND upper(supRegName) matches upper(?) ");
			params.add(supRegName);
		}
		if (isSupRegID.booleanValue()) {
			//sb.append(" AND regionID IN(SELECT regionID FROM kzlRegionsHierarhy kre WHERE kre.parent_regionID = ? AND kre.recordStatus='A') ");
			sb.append(" AND supRegID = ? ");
			params.add(isSupRegID);
		}
		if (isSupRegCode.booleanValue()) {
			//sb.append(" AND regionID IN(SELECT regionID FROM kzlRegionsHierarhy kre WHERE kre.parent_regionID = ? AND kre.recordStatus='A') ");
			sb.append(" AND supRegCode = ? ");
			params.add(isSupRegCode);
		}		
		//append order by clause:
		if (sortBy != null && !sortBy.trim().equals("")) {
			sb.append(" order by " + sortBy);
		}
		//System.err.println(sb.toString()); //temp
		res.executeQuery(sb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			SuperRegion_VO vo = CDBC_MapFactory.createSuperRegion(ro);
			//SuperRegion_TO to = new SuperRegion_TO(vo);
			//vo.setCountChild(((Integer)ro.getColumn("countChild").asObject()).intValue());
			ret.add(vo);
		}
		return ret;
	}	
}
