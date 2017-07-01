package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.*;
/**
 * "Справочник должностей".
 * Creation date: (02.11.2005 11:04:21)
 * @author: Shafigullin Ildar
 */
public class CDBC_WorkPosition_Object {
    private static final String _createString = "INSERT INTO workpositions (workposition, name, isactive) VALUES (?, ?, ?)";
    private static final String _removeString = "DELETE FROM workpositions  WHERE workposition = ?";
    private static final String _storeString = "UPDATE workpositions  SET name = ?, isactive = ? WHERE workposition = ?";
    private static final String _loadString = "SELECT T1.name, T1.workposition, T1.isactive FROM workpositions  T1 ";
    private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:18:24)
 */
public final static java.util.List findList(Boolean isName, String name, Boolean isIsActive, String isActive, String orderBy) {
    CDBCResultSet res = new CDBCResultSet();
    ArrayList params = new ArrayList();
    List ret = new ArrayList();
    StringBuffer sb = new StringBuffer(_loadString);
    sb.append(" WHERE 1=1");
    //calculate where clause:
    if (isName.booleanValue()) {
        sb.append(" and upper(name) matches upper(?) ");
        params.add(name);
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
        WorkPosition_VO vo = CDBC_MapFactory.createWorkPosition(ro);
        ret.add(vo);
    }
    return ret;
}
}
