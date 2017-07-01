package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.*;
/**
 * Insert the type's description here.
 * Creation date: (01.11.2005 14:42:24)
 * @author: Shafigullin Ildar
 */
public class CDBC_People_Object {
    private static final String _createString = "INSERT INTO people (man, firstname, lastname, passportser, middlename, passportdate, passportwhom, isActive) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String _removeString = "DELETE FROM people  WHERE man = ?";
    private static final String _storeString = "UPDATE people  SET firstname = ?, lastname = ?, passportser = ?, middlename = ?, passportdate = ?, passportwhom = ?, isActive = ? WHERE man = ?";
    private static final String _loadString = "SELECT T1.firstname, T1.lastname, T1.passportser, T1.middlename, T1.man, T1.passportdate, T1.passportwhom, T1.isActive, T1.tabnum FROM people T1 ";
    private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
/**
 * Insert the method's description here.
 * Creation date: (01.11.2005 14:54:07)
 * @return java.util.List
 */
public final static java.util.List findList(Boolean isLastName, String lastName, Boolean isIsActive, String isActive, String orderBy) {
    CDBCResultSet res = new CDBCResultSet();
    ArrayList params = new ArrayList();
    List ret = new ArrayList();
    StringBuffer sb = new StringBuffer(_loadString);
    sb.append(" WHERE 1=1");
    //calculate where clause:
    if (isLastName.booleanValue()) {
        sb.append(" and upper(lastname) matches upper(?) ");
        params.add(lastName);
    }
    if (isIsActive.booleanValue()) {
        sb.append(" and isactive = ? ");
        params.add(isActive);
    }
    //append order by clause:
    if (orderBy != null)
        sb.append(" order by " + orderBy);
    res.executeQuery(sb.toString(), params.toArray());
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        CDBCRowObject ro = (CDBCRowObject) iter.next();
        People_VO vo = CDBC_MapFactory.createPeople(ro);
        ret.add(vo);
    }
    return ret;
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2005 16:54:13)
 * @param id int
 */
public final static People_VO find(int aID) {
	CDBCResultSet res = new CDBCResultSet();
	Object[] params = { new Integer(aID)};
	String sql = _loadString + " WHERE man = ? ";
	res.executeQuery(sql, params);
	ListIterator list = res.listIterator();
	CDBCRowObject ro = null;
	People_VO vo = null;
	if (list.hasNext()) {
		ro = (CDBCRowObject) list.next();
		vo = CDBC_MapFactory.createPeople(ro);
	}
	return vo;
}
}
