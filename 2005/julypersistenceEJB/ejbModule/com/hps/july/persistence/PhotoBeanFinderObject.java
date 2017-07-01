package com.hps.july.persistence;

import java.sql.PreparedStatement;
/**
 * Insert the type's description here.
 * Creation date: (28.10.2002 20:37:24)
 * @author: Maksim Gerasimov
 */
public class PhotoBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject
implements PhotoBeanFinderHelper {
	
/**
 * PhotoBeanFinderObject constructor comment.
 */
public PhotoBeanFinderObject() {
	super();
}
public java.sql.PreparedStatement findPhoto(
	Integer storageplace,
	Boolean isDate, java.sql.Date startDate, java.sql.Date stopDate, 
	Boolean isPhotographer, Integer photographerId
) throws Exception {
	
 	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

    //calculate where clause
    StringBuffer whereClause = new StringBuffer();
    whereClause.append(" storageplace = ? ");
    if (isDate.booleanValue())
        whereClause.append(" and (date between ? and ?) ");
    if (isPhotographer.booleanValue())
        whereClause.append(" and photographer = ? ");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    //append order by clause
    String orderBy = null;
    if(isDate.booleanValue())
    	orderBy = " order by date asc ";
    if(isDate.booleanValue() && isPhotographer.booleanValue())
    	orderBy += ", photographer asc ";
    else if(isPhotographer.booleanValue())
    	orderBy = " order by photographer asc ";
    if(!isDate.booleanValue() && !isPhotographer.booleanValue())
    	orderBy = " order by storageplace asc ";
    sb.append(orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
	    
        ps.setInt(j++, storageplace.intValue());
        if (isDate.booleanValue()){
            ps.setDate(j++, startDate);
            ps.setDate(j++, stopDate);
        }
        if (isPhotographer.booleanValue())
            ps.setInt(j++, photographerId.intValue());
    }

    return ps;	
}
}
