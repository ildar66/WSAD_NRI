package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseTaskJournalBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements LeaseTaskJournalBeanFinderHelper{
		private static java.util.HashMap aliasMap;
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 15:35:56)
 */
public java.sql.PreparedStatement findByQBE(java.lang.Integer taskStart, 
	Boolean isError, Boolean isWarning, Boolean isSuccess, Integer order) throws java.lang.Exception {
		//get generic query string 
		int i;
    	int[] genericFindInsertPoints = getGenericFindInsertPoints();
    	StringBuffer sb = new StringBuffer(getGenericFindSqlString());

		//getting aliases
		String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASETASKJOURNAL"));
    
    	//calculate where clause
		StringBuffer whereClause = new StringBuffer( alias1 + ".taskstart = ? " );

		String inClause = "";
		if (isError.booleanValue()) {
			if (inClause.length() > 0)
				inClause = inClause + ",";
			inClause = inClause + "'E'";
		}
		if (isWarning.booleanValue()) {
			if (inClause.length() > 0)
				inClause = inClause + ",";
			inClause = inClause + "'W'";
		}
		if (isSuccess.booleanValue()) {
			if (inClause.length() > 0)
				inClause = inClause + ",";
			inClause = inClause + "'S'";
		}
		if (inClause.length() > 0) 
			whereClause.append(" AND " + alias1 + ".jrntype IN (" + inClause + ") ");
		 
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
			  sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	    }
    
		//append order by clause
		String orderBy = null;
		if(order.intValue() == 1)
			orderBy = alias1 + ".taskjournal asc";
		else
			orderBy = alias1 + ".taskjournal desc";
		sb.append( " order by "+orderBy );
		
		//System.out.println( "SQL clause="+sb );
			
		//fill prepared statement
		PreparedStatement ps = getPreparedStatement( sb.toString() );
	
		int j = 1;
		for( i = 0; i < getMergedWhereCount(); i++) {
			ps.setInt(j++, taskStart.intValue());
		}   

		return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 15:35:56)
 */
public java.sql.PreparedStatement findByTaskStartOrderByJrnDate(java.lang.Integer taskStart, java.lang.Integer order) throws java.lang.Exception {
		//get generic query string 
		int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

		//getting aliases
		String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASETASKJOURNAL"));
    
    //calculate where clause
		StringBuffer whereClause = new StringBuffer( alias1 + ".taskstart = ? " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		  sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
		//append order by clause
		String orderBy = null;
		switch( order.intValue() ) {
			case 1:
				orderBy = alias1 + ".jrndate asc";
				break;
			case 2:
				orderBy = alias1 + ".jrndate desc";
		}
		sb.append( " order by "+orderBy );
		
		//System.out.println( "SQL clause="+sb );
			
		//fill prepared statement
		PreparedStatement ps = getPreparedStatement( sb.toString() );
	
		int j = 1;
		for( i = 0; i < getMergedWhereCount(); i++) {
			ps.setInt(j++, taskStart.intValue());
		}   

		return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 15:35:56)
 */
public java.sql.PreparedStatement findByTaskStartOrderByJrndateAscAndTaskjournalAsc(java.lang.Integer taskStart, 
	Boolean isError, Boolean isWarning, Boolean isSuccess) throws java.lang.Exception {
		//get generic query string 
		int i;
    	int[] genericFindInsertPoints = getGenericFindInsertPoints();
    	StringBuffer sb = new StringBuffer(getGenericFindSqlString());

		//getting aliases
		String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASETASKJOURNAL"));
    
    	//calculate where clause
		StringBuffer whereClause = new StringBuffer( alias1 + ".taskstart = ? " );

		String inClause = "";
		if (isError.booleanValue()) {
			if (inClause.length() > 0)
				inClause = inClause + ",";
			inClause = inClause + "'E'";
		}
		if (isWarning.booleanValue()) {
			if (inClause.length() > 0)
				inClause = inClause + ",";
			inClause = inClause + "'W'";
		}
		if (isSuccess.booleanValue()) {
			if (inClause.length() > 0)
				inClause = inClause + ",";
			inClause = inClause + "'S'";
		}
		if (inClause.length() > 0) 
			whereClause.append(" AND " + alias1 + ".jrntype IN (" + inClause + ") ");
		 
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
			  sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	    }
    
		//append order by clause
		String orderBy = alias1 + ".jrndate asc, " + alias1 + ".taskjournal asc";
		sb.append( " order by "+orderBy );
		
		//System.out.println( "SQL clause="+sb );
			
		//fill prepared statement
		PreparedStatement ps = getPreparedStatement( sb.toString() );
	
		int j = 1;
		for( i = 0; i < getMergedWhereCount(); i++) {
			ps.setInt(j++, taskStart.intValue());
		}   

		return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 15:35:56)
 */
public java.sql.PreparedStatement findByTaskStartType(java.lang.Integer taskStart,
	Boolean isJrnType, String jrnType,
	java.lang.Integer order) throws java.lang.Exception {
		
		//get generic query string 
		int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());

		//getting aliases
		String alias1 = (String)(getAliasMap( sb.toString() ).get("LEASETASKJOURNAL"));
    
    	//calculate where clause
		StringBuffer whereClause = new StringBuffer( alias1 + ".taskstart = ? " );

		if (isJrnType.booleanValue())
			whereClause = whereClause.append(" AND " + alias1 + ".jrntype = ?");
    
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
			  sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	    }
    
		//append order by clause
		String orderBy = null;
		switch( order.intValue() ) {
			case 1:
				orderBy = alias1 + ".jrndate asc";
				break;
			case 2:
				orderBy = alias1 + ".jrndate desc";
				break;
			case 3:
				orderBy = alias1 + ".TaskJournal asc";
				break;
			case 4:
				orderBy = alias1 + ".TaskJournal desc";
		}
		sb.append( " order by "+orderBy );
		
		//System.out.println( "SQL clause="+sb );
			
		//fill prepared statement
		PreparedStatement ps = getPreparedStatement( sb.toString() );
	
		int j = 1;
		for( i = 0; i < getMergedWhereCount(); i++) {
			ps.setInt(j++, taskStart.intValue());
			if (isJrnType.booleanValue())
				ps.setString(j++, jrnType);
		}   

		return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 9:49:30)
 * @return java.util.HashMap
 */
public java.util.HashMap getAliasMap() {
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 9:49:30)
 * @return java.util.HashMap
 */
public java.util.Map getAliasMap( String statement ) {
	if( aliasMap == null ) {
		aliasMap = PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
}
