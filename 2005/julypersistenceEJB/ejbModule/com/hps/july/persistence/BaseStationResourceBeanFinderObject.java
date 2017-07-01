package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class BaseStationResourceBeanFinderObject extends 
ResourceBeanFinderObject  implements BaseStationResourceBeanFinderHelper{
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
	private static java.util.HashMap aliasMap;
	private static java.lang.String modelOrder;
	private static java.lang.String nameOrder;
/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findBasestationByQBE(
		    Boolean isType, Integer type,
		    Boolean isSubtype, Integer subtype,
		    Boolean isGeneration, String generation,
		    String active,
		    Boolean isModel, String model,
		    Boolean isManufacturer, String manufacturer,
		    Integer order
		) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    String alias1 = getAlias(sb.toString(), "BASESTATIONRES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isType.booleanValue() )
		whereClause.append( "AND " + alias + ".resourcesubtype IN (SELECT r.resourcesubtype FROM resourcesubtypes r " +
			"WHERE r.resourcetype = ?) " );
	if( isSubtype.booleanValue() )
		whereClause.append( "AND " + alias + ".resourcesubtype = ? " );
		
	if( isGeneration.booleanValue() )
		whereClause.append( "and upper(" + alias1 + ".generation) matches upper(?) " );
		
	whereClause.append( "and upper(" + alias + ".active) matches upper(?) " );
		
	if( isModel.booleanValue() )
		whereClause.append( "and upper(" + alias + ".model) matches upper(?) " );
		
	if( isManufacturer.booleanValue() )
		whereClause.append( "and " + alias + ".manufid IN (SELECT e.manufid FROM equipmanufacturers e " +
			"WHERE upper(e.name) matches upper(?) )" );
		
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getModelOrder(sb.toString(), alias) + " asc";
			break;
		case 2:
			orderBy = getModelOrder(sb.toString(), alias) + " desc";
			break;
	}
	if(orderBy != null){
		sb.append( " order by "+orderBy );
	}
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isType.booleanValue() )
			ps.setInt( j++, type.intValue() );
		if( isSubtype.booleanValue() )
			ps.setInt( j++, subtype.intValue() );
		if( isGeneration.booleanValue() )
			ps.setString( j++, generation );
			
		ps.setString( j++, active );
		
		if( isModel.booleanValue() )
			ps.setString( j++, model );
			
		if( isManufacturer.booleanValue() )
			ps.setString( j++, manufacturer );
	}   

	return ps;
}
/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findBasestationResourceForBowse(
        Boolean isResourcetype, Integer resourcetype,
        Boolean isResourcesubtype, Integer resourcesubtype,
        Boolean isModel, String model,
        Boolean isName, String name,
        Boolean isManufacturer, Integer manufacturer,
        Boolean isManucode, String manucode,
        String active, /// '*' - все - 'Y' - только активные, 'N' - только устаревшие
        Boolean isGeneration, String generation,
        Integer order
) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    String alias1 = getAlias(sb.toString(), "BASESTATIONRES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer(" 1=1 ");
	if( isResourcetype.booleanValue() ){
		whereClause.append( " AND " + alias + ".resourcesubtype IN (SELECT r.resourcesubtype FROM resourcesubtypes r " +
			"WHERE r.resourcetype = ?) " );
	}
	if( isResourcesubtype.booleanValue() ){
		whereClause.append( " and " + alias + ".resourcesubtype = ? " );
	}
	if( isModel.booleanValue() ){
		whereClause.append( "and upper(" + alias + ".model) matches upper(?) " );
	}
	if( isName.booleanValue() ){
		whereClause.append( "and upper(" + alias + ".name) matches upper(?) " );
	}
	if( isManufacturer.booleanValue() ){
		whereClause.append( "and " + alias + ".manufid = ? " );
	}
	if( isManucode.booleanValue() ){
		whereClause.append( "and upper(" + alias + ".manucode) matches upper(?) " );
	}
	if(active.equalsIgnoreCase("Y")){
		whereClause.append(" and " + alias + ".active = 'Y' ");
	} else if(active.equalsIgnoreCase("N")) {
		whereClause.append(" and " + alias + ".active = 'N' ");
	}
	if(isGeneration.booleanValue()){
		whereClause.append(" and upper(" + alias1 + ".generation) matches upper(?) ");
	}
		
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getModelOrder(sb.toString(), alias) + " asc, "
			+ getNameOrder(sb.toString(), alias) + " asc";
			break;
		case 2:
			orderBy = getModelOrder(sb.toString(), alias) + " desc, "
			+ getNameOrder(sb.toString(), alias) + " desc";
			break;
	}
	if(orderBy != null){
		sb.append( " order by "+orderBy );
	}
	
	//System.out.println( "BaseStationResourceBeanFinderObject.findBasestationResourceForBowse SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isResourcetype.booleanValue() )
			ps.setInt( j++, resourcetype.intValue() );
		if( isResourcesubtype.booleanValue() )
			ps.setInt( j++, resourcesubtype.intValue() );
		if( isModel.booleanValue() )
			ps.setString( j++, model );
		if( isName.booleanValue() )
			ps.setString( j++, name );
		if( isManufacturer.booleanValue() )
			ps.setInt( j++, manufacturer.intValue() );
		if( isManucode.booleanValue() )
			ps.setString( j++, manucode );
		if(isGeneration.booleanValue())
			ps.setString( j++, generation );
	}   

	return ps;
}
public String getAlias(String statement, String alias) {
	return (String)(getAliasMap(statement).get(alias.toUpperCase())); 
}
public static java.util.HashMap getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap; 
}
	public static java.lang.String getModelOrder(String statement, String alias ) {
		if( modelOrder == null ) {
			modelOrder = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".model" ) );
		} 
		return modelOrder;
	}
public static java.lang.String getNameOrder(String statement, String alias ) {
		if( nameOrder == null ) {
			nameOrder = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".name" ) );
		}
		return nameOrder;
}
public static void setAliasMap(java.util.HashMap newAliasMap) {
	aliasMap = newAliasMap; 
}
}
