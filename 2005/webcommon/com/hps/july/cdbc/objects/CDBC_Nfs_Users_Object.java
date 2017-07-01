package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.cdbc.lib.*;
import com.hps.july.valueobject.*;
/**
 * Insert the type's description here.
 * Creation date: (01.11.2005 14:42:24)
 * @author: Shafigullin Ildar
 */
public class CDBC_Nfs_Users_Object {
    private static final String FIND_SQL = "SELECT T1.personID, T1.idUserNFS, T1.login, T1.fullName, T1.flagWorkNRI, T1.recordStatus FROM nfs_users T1 ";
/**
 * Insert the method's description here.
 * Creation date: (01.11.2005 14:54:07)
 * @return java.util.List
 */
public final static java.util.List findList(Boolean isLastName, String lastName, Boolean isIsActive, String isActive, String orderBy) {
    CDBCResultSet res = new CDBCResultSet();
    ArrayList params = new ArrayList();
    List ret = new ArrayList();
    StringBuffer sb = new StringBuffer(FIND_SQL);
    sb.append(" WHERE 1=1 ");
    //calculate where clause:
    if (isLastName.booleanValue()) {
        sb.append(" and upper(fullName) matches upper(?) ");
        params.add(lastName);
    }
    if (isIsActive.booleanValue()) {
        sb.append(" and recordStatus = ? ");
        params.add(isActive);
    }
    //append order by clause:
    if (orderBy != null)
        sb.append(" order by " + orderBy);
	System.out.println(sb.toString()); //temp
    res.executeQuery(sb.toString(), params.toArray());
    ListIterator iter = res.listIterator();
    while (iter.hasNext()) {
        CDBCRowObject ro = (CDBCRowObject) iter.next();
		Nfs_Users_VO vo = CDBC_MapFactory.createNfs_Users(ro);
        ret.add(vo);
    }
    return ret;
}
}
