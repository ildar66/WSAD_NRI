package com.hps.july.persistence;

import java.sql.*;
public class SiteDocBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements SiteDocBeanFinderHelper{
	
	private static java.util.HashMap aliasMap;
	private static int blankdate;
	private static int blanknumber;
	private static int sitedoctype;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByEquipment(Integer position, Integer order)	throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("SITEDOCS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer(alias1+".sitedoc in( "
    +"select sitedoc from sitedocs2splace  where storageplace = ?) ");
	
   
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getBlankdate(sb.toString(), alias1+".BLANKDATE")+" asc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" asc ";
			break;
	  case 2:
			orderBy = getBlankdate(sb.toString(), alias1+".BLANKDATE")+" desc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" desc ";
			break;
		case 3:
			orderBy = getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" asc ";
			break;
		case 4:
			orderBy = getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" desc ";
			break;
		case 5:
			orderBy = getSitedoctype(sb.toString(), alias1+".SITEDOCTYPE")+" asc, "+
				getBlankdate(sb.toString(), alias1+".BLANKDATE")+" asc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" asc ";
			break;
		case 6:
			orderBy = getSitedoctype(sb.toString(), alias1+".SITEDOCTYPE")+" desc, "+
				getBlankdate(sb.toString(), alias1+".BLANKDATE")+" desc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" desc ";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, position.intValue() );
	}

	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByHop(Integer hopid, Integer order)	throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("SITEDOCS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer(alias1+".sitedoc in( "
    +"select sitedoc from sitedocs2hops  where hopsid = ?) ");
	
   
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getBlankdate(sb.toString(), alias1+".BLANKDATE")+" asc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" asc ";
			break;
	  case 2:
			orderBy = getBlankdate(sb.toString(), alias1+".BLANKDATE")+" desc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" desc ";
			break;
		case 3:
			orderBy = getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" asc ";
			break;
		case 4:
			orderBy = getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" desc ";
			break;
		case 5:
			orderBy = getSitedoctype(sb.toString(), alias1+".SITEDOCTYPE")+" asc, "+
				getBlankdate(sb.toString(), alias1+".BLANKDATE")+" asc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" asc ";
			break;
		case 6:
			orderBy = getSitedoctype(sb.toString(), alias1+".SITEDOCTYPE")+" desc, "+
				getBlankdate(sb.toString(), alias1+".BLANKDATE")+" desc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" desc ";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, hopid.intValue() );
	}

	return ps;
}
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByPosition(Integer position, Integer order)	throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	//getting aliases
	String alias1 = (String)(getAliasMap( sb.toString() ).get("SITEDOCS"));

	//calculate where clause
	StringBuffer whereClause = new StringBuffer(alias1+".sitedoc in "
    +" (select s.sitedoc from sitedocs2splace s where s.storageplace = ?) "
    +" or "+alias1+".sitedoc in "
    +" (select s.sitedoc from sitedocs2splace s, equipment e "
		+" where e.position=? AND s.storageplace = e.equipment)");
	
   
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getBlankdate(sb.toString(), alias1+".BLANKDATE")+" asc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" asc ";
			break;
	  case 2:
			orderBy = getBlankdate(sb.toString(), alias1+".BLANKDATE")+" desc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" desc ";
			break;
		case 3:
			orderBy = getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" asc ";
			break;
		case 4:
			orderBy = getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" desc ";
			break;
		case 5:
			orderBy = getSitedoctype(sb.toString(), alias1+".SITEDOCTYPE")+" asc, "+
				getBlankdate(sb.toString(), alias1+".BLANKDATE")+" asc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" asc ";
			break;
		case 6:
			orderBy = getSitedoctype(sb.toString(), alias1+".SITEDOCTYPE")+" desc, "+
				getBlankdate(sb.toString(), alias1+".BLANKDATE")+" desc, "+
				getBlanknumber(sb.toString(), alias1+".BLANKNUMBER")+" desc ";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, position.intValue() );
		ps.setInt( j++, position.intValue() );
	}

	return ps;
}
public java.util.HashMap getAliasMap() {
	return aliasMap;
}
public java.util.Map getAliasMap( String statement ) {
	if( aliasMap == null ) {
		aliasMap = PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
public int getBlankdate( String statement, String field ) {
	if( blankdate == 0 ) {
		blankdate = PersistenceUtil.getFieldIndex( statement, field );
	}
	return blankdate;
}
public int getBlanknumber( String statement, String field ) {
	if( blanknumber == 0 ) {
		blanknumber = PersistenceUtil.getFieldIndex( statement, field );
	}
	return blanknumber;
}
public int getSitedoctype( String statement, String field ) {
	if( sitedoctype == 0 ) {
		sitedoctype = PersistenceUtil.getFieldIndex( statement, field );
	}
	return sitedoctype;
}
}
