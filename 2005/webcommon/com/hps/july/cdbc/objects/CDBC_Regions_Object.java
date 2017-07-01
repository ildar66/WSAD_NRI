/*
 * Created on 23.01.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.valueobject.Region_VO;

/**
 * @author IShaffigulin
 *
 * CDBC_Object(Справочник регионов (филиалов)).
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_Regions_Object {
	private static final String FIND_SQL = "SELECT regionid, supregid, regname, sectorprefix, hasmap, fullarendainfo, needapprove, modified, created FROM regions ";
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 14:29:42)
	 */
	public static List getList(
		Boolean isRegName,
		String regName,
		Boolean isSupRegID,
		Integer supRegID,		
		String sortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(FIND_SQL);
		sb.append(" WHERE 1=1 ");
		//calculate where clause:			
		if (isRegName.booleanValue()) {
			sb.append(" AND upper(regName) matches upper(?) ");
			params.add(regName);
		}
		if (isSupRegID.booleanValue()) {
			//sb.append(" AND regionID IN(SELECT regionID FROM kzlRegionsHierarhy kre WHERE kre.parent_regionID = ? AND kre.recordStatus='A') ");
			sb.append(" AND supRegID = ? ");
			params.add(supRegID);
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
			Region_VO vo = CDBC_MapFactory.createRegion(ro);
			//Region_TO to = new Region_TO(vo);
			//vo.setCountChild(((Integer)ro.getColumn("countChild").asObject()).intValue());
			ret.add(vo);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static Region_VO find(Integer aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		String sql = FIND_SQL + " WHERE regionid = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		Region_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = CDBC_MapFactory.createRegion(ro);
		}
		return vo;
	}
}
