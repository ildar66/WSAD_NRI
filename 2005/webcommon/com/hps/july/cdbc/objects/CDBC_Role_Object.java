package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.*;
/**
 * Роли оператора CDBC_Object.
 * Creation date: (03.11.2005 11:51:17)
 * @author: Shafigullin Ildar
 */
public class CDBC_Role_Object {
	private static final String _createString = "INSERT INTO roles (role, rolename, comment, sortOrder, taskComment) VALUES (?, ?, ?, ?, ?) ";
	private static final String _removeString = "DELETE FROM roles  WHERE role = ?";
	private static final String _storeString = "UPDATE roles  SET comment = ?, sortOrder = ?, taskComment = ? WHERE role = ?";
	private static final String _loadString = "SELECT role, rolename, comment, sortOrder, taskComment FROM roles ";
	//private static final String _loadForUpdateString = _loadString + " FOR UPDATE";

	/**
	 * Доступные роли оператора.
	 * Creation date: (03.11.2005 12:11:20)
	 */
	public final static java.util.List findListAnoveRoleForOperator(String operatorID, String orderBy) {
		CDBCResultSet res = new CDBCResultSet();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(_loadString);
		sb.append(" WHERE role NOT IN (SELECT role FROM operators2roles WHERE operator = ?)");

		//append order by clause:
		if (orderBy != null && !orderBy.equals(""))
			sb.append(" order by " + orderBy);
		res.executeQuery(sb.toString(), new Object[] { operatorID });
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Role_VO vo = CDBC_MapFactory.createRole(ro);
			ret.add(vo);
		}
		return ret;
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static boolean edit(Role_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getComment(), vo.getSortOrder(), vo.getTaskComment(), vo.getRole()};
		return res.executeUpdate(_storeString, params);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static boolean add(Role_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getRole(), vo.getRolename(), vo.getComment(), vo.getSortOrder(), vo.getTaskComment()};
		return res.executeUpdate(_createString, params);
	}

	/**
	 * 
	 * @param aID
	 * @return
	 */
	public final static Role_VO find(String aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		String sql = _loadString + " WHERE role = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		Role_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = CDBC_MapFactory.createRole(ro);
		}
		return vo;
	}

	/**
	 * Текущие роли оператора.
	 * Creation date: (27.03.2007 12:11:20)
	 */
	public final static java.util.List findList(String operatorID, String orderBy) {
		CDBCResultSet res = new CDBCResultSet();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(_loadString);
		sb.append(" WHERE role IN (SELECT role FROM operators2roles WHERE operator = ?)");

		//append order by clause:
		if (orderBy != null && !orderBy.equals(""))
			sb.append(" order by " + orderBy);
		res.executeQuery(sb.toString(), new Object[] { operatorID });
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Role_VO vo = CDBC_MapFactory.createRole(ro);
			ret.add(vo);
		}
		return ret;
	}

	/**
	 * Все роли для пользователя NRI.
	 * Creation date: (27.03.2007 12:11:20)
	 */
	public final static java.util.List findList(String orderBy) {
		CDBCResultSet res = new CDBCResultSet();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(_loadString);
		//append order by clause:
		if (orderBy != null && !orderBy.equals(""))
			sb.append(" order by " + orderBy);
		res.executeQuery(sb.toString(), null);
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Role_VO vo = CDBC_MapFactory.createRole(ro);
			ret.add(vo);
		}
		return ret;
	}

	/**
	 * Все роли для пользователя NRI.
	 * Creation date: (27.03.2007 12:11:20)
	 */
	public final static java.util.List findListRoles(String searchStr, String orderBy) {
		CDBCResultSet res = new CDBCResultSet();
		List ret = new ArrayList();
		StringBuffer sb = new StringBuffer(_loadString);
		sb.append(" WHERE LOWER(roleName) MATCHES LOWER(?) ");
		//append order by clause:
		if (orderBy != null && !orderBy.equals(""))
			sb.append(" order by " + orderBy);
		res.executeQuery(sb.toString(), new Object[] { searchStr });
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Role_VO vo = CDBC_MapFactory.createRole(ro);
			ret.add(vo);
		}
		return ret;
	}
	
	/**
	 * Insert the method's description here.
	 * Creation date: (05.06.2007 12:14:11)
	 */
	public static boolean delete(Role_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = {vo.getRole()};
		return res.executeUpdate(_removeString, params);
	}	
}