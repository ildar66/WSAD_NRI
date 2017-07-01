package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class AntennaResourceBeanFinderObject extends 
ResourceBeanFinderObject  implements AntennaResourceBeanFinderHelper{
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
	private static java.util.HashMap aliasMap;
	private static java.lang.String modelOrder;
	private static java.lang.String nameOrder;
public java.sql.PreparedStatement findAntennaResourceForBrowse(
        Boolean isResourcetype, Integer resourcetype,
        Boolean isResourcesubtype, Integer resourcesubtype,
        Boolean isModel, String model,
        Boolean isName, String name,
        Boolean isManufacturer, Integer manufacturer,
        Boolean isManucode, String manucode,
        String active, /// '*' - все - 'Y' - только активные, 'N' - только устаревшие
        String polarization, /// '*' - все типы, 'C' - кросс, 'V' - вертикальная (если там 1 и 2 то можно и на них заменить)
        Boolean isRange, Integer[] ranges,
        Integer order
) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    String alias1 = getAlias(sb.toString(), "ANTENNARES");
    
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
	if(polarization.equalsIgnoreCase("C")){
		whereClause.append(" and " + alias1 + ".polarization = 'C' ");
	} else if (polarization.equalsIgnoreCase("V")){
		whereClause.append(" and " + alias1 + ".polarization = 'V' ");
	}
	String sRanges = "";
	if (isRange.booleanValue()) {
		for (i = 0; i < ranges.length; i++) {
			if (sRanges.length() > 0)
				sRanges = sRanges + ", ";
			sRanges = sRanges + ranges [i];
		}
		if (sRanges.length() > 0)
			whereClause.append( " AND " + alias1 + ".resource IN (SELECT a.resource FROM antennaresband a WHERE " +
				"a.band IN (" + sRanges + ")) " );
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
	
	//System.out.println( "AntennaResourceBeanFinderObject.findAntennaResourceForBrowse SQL clause="+sb );
		
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
/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findResourceByBrowse1 (
		Boolean isType,	Integer type,
		Boolean isSubtype, Integer subtype,
		Integer ranges[], String polar,	String active,
		Boolean isModel, String model,
		Boolean isManu,	String manu,
		Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    String alias1 = getAlias(sb.toString(), "ANTENNARES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isType.booleanValue() )
		whereClause.append( "AND " + alias + ".resourcesubtype IN (SELECT r.resourcesubtype FROM resourcesubtypes r " +
			"WHERE r.resourcetype = ?) " );
	if( isSubtype.booleanValue() )
		whereClause.append( "AND " + alias + ".resourcesubtype = ? " );
	if( isModel.booleanValue() )
		whereClause.append( "and upper(" + alias + ".model) matches upper(?) " );
	if( isManu.booleanValue() )
		//whereClause.append( "and " + alias + ".manufacturer IN (SELECT o.organization FROM organizations o " +
		//	"WHERE upper(o.name) matches upper(?) )" );
		whereClause.append( "and " + alias + ".manufid IN (SELECT e.manufid FROM equipmanufacturers e " +
			"WHERE upper(e.name) matches upper(?) )" );
		
	whereClause.append( "and upper(" + alias1 + ".polarization) matches upper(?) " );
	whereClause.append( "and upper(" + alias + ".active) matches upper(?) " );

	String sRanges = "";
	if (ranges != null) {
		for (i = 0; i < ranges.length; i++) {
			if (sRanges.length() > 0)
				sRanges = sRanges + ", ";
			sRanges = sRanges + ranges [i];
		}
		if (sRanges.length() > 0)
			whereClause.append( "AND " + alias1 + ".resource IN (SELECT a.resource FROM antennaresband a WHERE " +
				"a.band IN (" + sRanges + ")) " );
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
	
	//System.out.println( "SQL clause="+sb );
		
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
			
		ps.setString( j++, polar );
		ps.setString( j++, active );
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
