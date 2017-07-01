package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ProjectActionDocumentBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
	implements ProjectActionDocumentBeanFinderHelper{

/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(Integer argProject, Boolean isProjectAction, Integer argProjectaction,
		Integer order) throws java.lang.Exception {

    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

    //calculate where clause
    StringBuffer whereClause = new StringBuffer(" 1=1 ");
    if (isProjectAction.booleanValue())
        whereClause.append(" AND projectaction = ? ");
    else
        whereClause.append(" AND projectaction IN (SELECT p.projectaction FROM projectactions p WHERE p.project = ?) ");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "projectaction asc, docdate asc";
            break;
        case 2 :
            orderBy = "projectaction desc, docdate desc";
            break;
        case 3 :
            orderBy = "docname asc, docdate asc";
            break;
        case 4 :
            orderBy = "docname desc, docdate desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
        if (isProjectAction.booleanValue())
            ps.setInt(j++, argProjectaction.intValue());
        else
            ps.setInt(j++, argProject.intValue());
    }

    return ps;
}
}
