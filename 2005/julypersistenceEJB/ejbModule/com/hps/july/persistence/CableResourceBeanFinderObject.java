package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class CableResourceBeanFinderObject extends ResourceBeanFinderObject 
implements CableResourceBeanFinderHelper{
	private static java.util.HashMap aliasMap;
	private static java.lang.String modelOrder;
	private static java.lang.String nameOrder;

	public static void setNameOrder(java.lang.String newNameOrder) {
		nameOrder = newNameOrder;
	}		
/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE4 (Boolean isType, Integer typeId,
                        Boolean isSubType, Integer subTypeId,
                        Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "active='Y' " );
	if( isType.booleanValue() )
		whereClause.append( "AND " + alias + ".resourcesubtype IN " +
			" (SELECT r.resourcesubtype FROM resourcesubtypes r WHERE r.resourcetype = ?) " );
	if( isSubType.booleanValue() )
		whereClause.append( "AND " + alias + ".resourcesubtype = ? " );
    
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
		case 3:
			orderBy = getNameOrder(sb.toString(), alias) + " asc";
			break;
		case 4:
			orderBy = getNameOrder(sb.toString(), alias) + " desc";
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
			ps.setInt( j++, typeId.intValue() );
		if( isSubType.booleanValue() )
			ps.setInt( j++, subTypeId.intValue() );
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
public static void setAliasMap(java.util.HashMap newAliasMap) {
	aliasMap = newAliasMap;
}

	public static java.lang.String getNameOrder(String statement, String alias ) {
		if( nameOrder == null ) {
			nameOrder = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".name" ) );
		}
		return nameOrder;
	}

	public static void setModelOrder(java.lang.String newModelOrder) {
		modelOrder = newModelOrder;
	}

/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findResourcesByQBE4(Boolean isSubtypekey, ResourceSubTypeKey subtypeKey, Boolean isModel, String model, Boolean isName, String name, Integer active, Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if (active.intValue() == 1)
		whereClause.append(" AND active='Y' ");
	if (active.intValue() == 2)
		whereClause.append(" AND active='N' ");
	if( isSubtypekey.booleanValue() )
		whereClause.append( "and " +alias + ".resourcesubtype = ? " );
	if( isModel.booleanValue() )
		whereClause.append( "and upper(" + alias + ".model) matches upper(?) " );
	if( isName.booleanValue() )
		whereClause.append( "and upper(" + alias + ".name) matches upper(?) " );
    
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
		case 3:
			orderBy = getNameOrder(sb.toString(), alias) + " asc";
			break;
		case 4:
			orderBy = getNameOrder(sb.toString(), alias) + " desc";
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
		if( isSubtypekey.booleanValue() )
			ps.setInt( j++, subtypeKey.resourcesubtype );
		if( isModel.booleanValue() )
			ps.setString( j++, model );
		if( isName.booleanValue() )
			ps.setString( j++, name );
	}   

	return ps;
}

public java.sql.PreparedStatement findResourcesForBrowse(
        Boolean isResourcetype, Integer resourcetype,
        Boolean isResourcesubtype, Integer resourcesubtype,
        Boolean isModel, String model,
        Boolean isName, String name,
        Boolean isManufacturer, Integer manufacturer,
        Boolean isManucode, String manucode,
        String active, /// '*' - все - 'Y' - только активные, 'N' - только устаревшие
        Integer order
	) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
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
	
	//System.out.println( "CableResourceBeanFinderObject.findResourcesForBrowse SQL clause="+sb );
		
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
	}   

	return ps;
}
}
