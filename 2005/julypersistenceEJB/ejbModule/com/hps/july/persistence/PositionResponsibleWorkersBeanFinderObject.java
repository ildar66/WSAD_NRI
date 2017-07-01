package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Maksim Gerasimov
 */
public class PositionResponsibleWorkersBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements PositionResponsibleWorkersBeanFinderHelper{
		private static java.util.HashMap aliasMap;
public java.sql.PreparedStatement findByQBE(
	Boolean isStorageplace, Integer storageplace,
	Boolean isType, Integer type, 
	Integer order) throws Exception{
		    //get generic query string 
	    int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	    //getting aliases
	    String alias = (String) (getAliasMap(sb.toString()).get("WORKRESPONSIBILITY"));

	    //calculate where clause
	    StringBuffer whereClause = new StringBuffer("1=1 ");
	    if( isType.booleanValue()){
		    if(type.intValue() == 1)
					whereClause.append(" and "+alias+".worker is not null " );
				else if(type.intValue() == 2)
					whereClause.append(" and "+alias+".organization is not null " );
	    }
	    if(isStorageplace.booleanValue()){
		    whereClause.append(" and "+alias+".storageplace = ?" );
	    }
	    	
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
	        sb.insert(genericFindInsertPoints[i], whereClause.toString());
	    }

	    if(order.intValue() == 1)
		    sb.append(" order by "+alias+".worker asc");
		  else if(order.intValue() == 2)
		    sb.append(" order by "+alias+".worker desc");

	    //System.out.println("PositionResponsibleWorkers.findByQBE SQL clause=" + sb);

	    //fill prepared statement
	    PreparedStatement ps = getPreparedStatement(sb.toString());
			int j = 1;
			for( i = 0; i < getMergedWhereCount(); i++) {
				if(isStorageplace.booleanValue() )
					ps.setInt( j++, storageplace.intValue());
			}
	    return ps;
}
public static java.util.HashMap getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
}
