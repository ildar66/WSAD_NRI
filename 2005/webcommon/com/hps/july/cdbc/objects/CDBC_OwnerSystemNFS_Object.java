/*
 * Created on 05.04.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.valueobject.OwnerSystemNfs_VO;

/**
 * @author IShaffigulin
 *
 * "владельцы" CDBC_Object.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_OwnerSystemNFS_Object {

	private static final String FIND_SQL =
		"SELECT os.idownernfs, os.nameownernfs FROM ownersystemnfs os , ownersystemnfs2filialnri o2f WHERE os.idownernfs = o2f.idownernfs AND o2f.regionid = ? ";
	private static final String FIND_ALL_SQL =
		"SELECT distinct os.idownernfs, os.nameownernfs FROM ownersystemnfs os , ownersystemnfs2filialnri o2f WHERE os.idownernfs = o2f.idownernfs ";
		
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 14:29:42)
	 */
	public static List getList(Integer regID, String sortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(FIND_SQL);
		params.add(regID);
		//append order by clause:
		if (sortBy != null && !sortBy.trim().equals("")) {
			sb.append(" order by " + sortBy);
		}
		//System.err.println(sb.toString()); //temp
		res.executeQuery(sb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			OwnerSystemNfs_VO vo = new OwnerSystemNfs_VO((Integer)ro.getColumn("idownernfs").asObject(), ro.getColumn("nameownernfs").asString());
			ret.add(vo);
		}
		return ret;
	}	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 14:29:42)
	 */
	public static List getList(Boolean isRegionID, Integer regID, String sortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(FIND_ALL_SQL);
		if(isRegionID.booleanValue()){
			sb.append(" AND o2f.regionid = ? ");
			params.add(regID);
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
			OwnerSystemNfs_VO vo = new OwnerSystemNfs_VO((Integer)ro.getColumn("idownernfs").asObject(), ro.getColumn("nameownernfs").asString());
			ret.add(vo);
		}
		return ret;
	}

}
