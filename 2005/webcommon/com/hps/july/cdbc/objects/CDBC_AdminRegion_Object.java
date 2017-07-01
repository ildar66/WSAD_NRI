package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import com.hps.july.valueobject.*;

import java.util.*;
import java.sql.Date;
/**
* "Административно-территориальное деление".
* Creation date: (18.08.2005 14:23:56)
* @author: Shafigullin Ildar
*/
public class CDBC_AdminRegion_Object {
	private static final String FIND_SQL =
		"SELECT regionid, kzlregionid, regionname, regioncomment, regiontype, regionpopulation, ruralpopulation, regionarea, regionlon, regionlat, regionkind, filialnri, PARENT_REGIONID, RecordStatus, kladrCode FROM adminregions WHERE recordstatus='A' AND regionid = ? ";
	private static final String FIND_LIST_SQL =
		"SELECT r.regionid, r.kzlregionid, r.regionname, r.regioncomment, r.regiontype, r.regionpopulation, r.ruralpopulation, r.regionarea, r.regionlon, r.regionlat, r.regionkind, r.filialnri, r.PARENT_REGIONID, r.RecordStatus, r.kladrCode, getCountChildAdminRegion(regionid) countChild, getNameRegion(filialnri) nameRegionNRI, t.nameType FROM adminregions r, adminRegionTypes t WHERE r.regiontype = t.regiontype AND recordstatus='A' ";
	private final static java.lang.String EDIT_SQL =
		"UPDATE adminregions SET kzlregionid=?, regionname=?, regioncomment=?, regiontype =?, regionpopulation =?, ruralpopulation =?, regionarea =?, regionlon=?, regionlat=?, regionkind=?, filialnri=?, PARENT_REGIONID =?, RecordStatus=?, kladrCode=? "
			+ "WHERE regionid =? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO adminregions(regionid, kzlregionid, regionname, regioncomment, regiontype, regionpopulation, ruralpopulation, regionarea, regionlon, regionlat, regionkind, filialnri, PARENT_REGIONID, RecordStatus, kladrCode) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL = "DELETE FROM adminregions WHERE regionid= ?";
	private final static java.lang.String SET_PARENT_REGIONID_SQL = "UPDATE adminregions SET PARENT_REGIONID = ? ";

	public final static Integer NULL_PARENT_ID = new Integer(-1);

	private static final String FIND_KladrCode_SQL = "SELECT * FROM KL_KLADR WHERE CODE = ? ";
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 14:29:42)
	 */
	public static List getList(Boolean isRegName, String regName, Boolean isParentRegID, Integer parentRegID, String sortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(FIND_LIST_SQL);
		//calculate where clause:			
		if (isRegName.booleanValue()) {
			sb.append(" AND upper(regionname) matches upper(?) ");
			params.add(regName);
		}
		if (isParentRegID.booleanValue()) {
			//sb.append(" AND regionID IN(SELECT regionID FROM kzlRegionsHierarhy kre WHERE kre.parent_regionID = ? AND kre.recordStatus='A') ");
			sb.append(" AND PARENT_REGIONID = ? ");
			params.add(parentRegID);
		} else {
			sb.append(" AND PARENT_REGIONID IS NULL ");
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
			AdminRegion_VO vo = CDBC_MapFactory.createAdminRegion(ro);
			AdminRegion_TO to = new AdminRegion_TO(vo);
			to.setCountChild(((Integer) ro.getColumn("countChild").asObject()).intValue());
			to.setNameRegionNRI(ro.getColumn("nameRegionNRI").asString());
			to.setRegionTypeName(ro.getColumn("nameType").asString());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static AdminRegion_VO find(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_SQL;
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		AdminRegion_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = CDBC_MapFactory.createAdminRegion(ro);
		}
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:04:50)
	 */
	public static final boolean add(AdminRegion_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getRegionid(),
				vo.getKzlregionid(),
				vo.getRegionname(),
				vo.getRegioncomment(),
				vo.getRegiontype(),
				vo.getRegionpopulation(),
				vo.getRuralpopulation(),
				vo.getRegionarea(),
				vo.getRegionlon(),
				vo.getRegionlat(),
				vo.getRegionkind(),
				vo.getFilialnri(),
				vo.getParent_regionid(),
				"A",
				vo.getKladrCode()};
		return res.executeUpdate(ADD_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final boolean delete(AdminRegion_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getRegionid()};
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean edit(AdminRegion_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getKzlregionid(),
				vo.getRegionname(),
				vo.getRegioncomment(),
				vo.getRegiontype(),
				vo.getRegionpopulation(),
				vo.getRuralpopulation(),
				vo.getRegionarea(),
				vo.getRegionlon(),
				vo.getRegionlat(),
				vo.getRegionkind(),
				vo.getFilialnri(),
				vo.getParent_regionid(),
				"A",
				vo.getKladrCode(),
				vo.getRegionid()};
		return res.executeUpdate(EDIT_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean setParentRegionID(Integer aParentRegionID, String aRegIDsStr) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aParentRegionID };
		return res.executeUpdate(SET_PARENT_REGIONID_SQL + " WHERE regionid IN (" + aRegIDsStr + ")", params);
	}

	/**
	 * Принадлежность региону ADMINREGION_RUSSIA? 
	 * @param aID
	 * @return
	 */
	public final static boolean isRussiaRegion(int aID) {
		int ADMINREGION_RUSSIA = AppUtils.getNamedValueInt("ADMINREGION_RUSSIA");
		if (aID == ADMINREGION_RUSSIA) {
			return true;
		} else {
			AdminRegion_VO vo = find(aID);
			if (vo == null || vo.getParent_regionid() == null) {
				return false;
			} else {
				return isRussiaRegion(vo.getParent_regionid().intValue());
			}
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static boolean hasKladrCode(String aKladrCode) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aKladrCode };
		String sql = FIND_KladrCode_SQL;
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		if (list.hasNext()) {
			return true;
		}
		return false;
	}
}