package com.hps.july.persistence;

import java.sql.PreparedStatement;
/**
 * Insert the type's description here.
 * Creation date: (19.08.2003 18:00:20)
 * @author: Maksim Gerasimov
 */
public class RepiterResBeanFinderObject extends ResourceBeanFinderObject implements RepiterResBeanFinderHelper {
	private static java.util.HashMap aliasMap;
	private static java.lang.String modelOrder;
	private static java.lang.String nameOrder;
public java.sql.PreparedStatement findResourceByBrowse1 (
	 Boolean isType, Integer type,
	 Boolean isSubtype, Integer subtype,
	 Boolean isModel, String model,
	 Boolean isManu, String manu,
	 Integer order) throws Exception{

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isType.booleanValue() )
		whereClause.append( " AND " + alias + ".resourcesubtype IN (SELECT r.resourcesubtype FROM resourcesubtypes r " +
			"WHERE r.resourcetype = ?) " );
	if( isSubtype.booleanValue() )
		whereClause.append( " AND " + alias + ".resourcesubtype = ? " );
	if( isModel.booleanValue() )
		whereClause.append( " and upper(" + alias + ".model) matches upper(?) " );
	if( isManu.booleanValue() )
		whereClause.append( " and " + alias + ".manufid IN (SELECT e.manufid FROM equipmanufacturers e " +
			"WHERE upper(e.name) matches upper(?) ) " );
		
	whereClause.append( " and " + alias + ".active = 'Y' " );
	
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
	
	//System.out.println( "RepiterResBeanFinderObject SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isType.booleanValue() )
			ps.setInt( j++, type.intValue() );
		if( isSubtype.booleanValue() )
			ps.setInt( j++, subtype.intValue() );
		if( isModel.booleanValue() )
			ps.setString( j++, model );
		if( isManu.booleanValue() )
			ps.setString( j++, manu );
	}   

	return ps;
}
public java.sql.PreparedStatement findResourcesByQBE4(
	Boolean isSubtypekey,		ResourceSubTypeKey subtypeKey, 
	Boolean isModel,			String model, 
	Boolean isName,				String name, 
	Boolean isManufacturer,		Integer manufacturer, 
	Boolean isManucode,			String manucode,
	Boolean IsIslinear,			Boolean islinear,
	Integer order
	) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias1 = getAlias(sb.toString(), "RESOURCES");
    String alias2 = getAlias(sb.toString(), "REPITERRES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias1 + ".active='Y' " );
	if( isSubtypekey.booleanValue() )
		whereClause.append( " and " + alias1 + ".resourcesubtype = ? " );
	if( isModel.booleanValue() )
		whereClause.append( "and upper(" + alias1 + ".model) matches upper(?) " );
	if( isName.booleanValue() )
		whereClause.append( "and upper(" + alias1 + ".name) matches upper(?) " );
	if( isManufacturer.booleanValue() )
		whereClause.append( "and " + alias1 + ".manufid = ? " );
	if( isManucode.booleanValue() )
		whereClause.append( "and upper(" + alias1 + ".manucode) matches upper(?) " );
	if( IsIslinear.booleanValue() ){
		String linear = islinear.booleanValue() ? "Y" : "N";
		whereClause.append( "and " + alias2 + ".islinear = '"+linear+"'" );
	}
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = getModelOrder(sb.toString(), alias1) + " asc";
			break;
		case 2:
			orderBy = getModelOrder(sb.toString(), alias1) + " desc";
			break;
		case 3:
			orderBy = getNameOrder(sb.toString(), alias1) + " asc";
			break;
		case 4:
			orderBy = getNameOrder(sb.toString(), alias1) + " desc";
			break;
	}
	if(orderBy != null){
		sb.append( " order by "+orderBy );
	}
	
	//System.out.println( "RepiterResBeanFinderObject.findByQBE   SQL clause="+sb );
		
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
		if( isManufacturer.booleanValue() )
			ps.setInt( j++, manufacturer.intValue() );
		if( isManucode.booleanValue() )
			ps.setString( j++, manucode );
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
	
	//System.out.println( "ResourceBeanFinderObject.findResourcesForBrowse SQL clause="+sb );
		
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
}
