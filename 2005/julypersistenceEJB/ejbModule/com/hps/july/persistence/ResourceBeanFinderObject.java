package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class ResourceBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements ResourceBeanFinderHelper{
	private static java.util.HashMap aliasMap;
	private static java.lang.String resourceOrder;
	private static java.lang.String modelOrder;
	private static java.lang.String nameOrder;

	public static void setNameOrder(java.lang.String newNameOrder) {
		nameOrder = newNameOrder;
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

	public static void setModelOrder(java.lang.String newModelOrder) {
		modelOrder = newModelOrder;
	}
	
public java.sql.PreparedStatement findResourcesByLeaseChargeRules( java.util.Vector listContracts ) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
    //calculate where clause
    String contrlist = "";
    java.util.Enumeration en = listContracts.elements();
    while (en.hasMoreElements()) {
	    Integer k = (Integer)en.nextElement();
	    if (contrlist.length() > 0)
	    	contrlist = contrlist + ",";
	    contrlist = contrlist + k;
    }
	StringBuffer whereClause = new StringBuffer( alias + ".resource IN (SELECT c.resource FROM leasechargerules c, leaserules r " +
		" WHERE c.leaserule = r.leaserule AND r.leasedocument IN (" + contrlist + " ) ) " );
    
	  //and fill it by where clause
	  for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	  }
    
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	return ps;
}
public java.sql.PreparedStatement findResourcesByLeasePayRules( java.util.Vector listContracts ) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
    //calculate where clause
    String contrlist = "";
    java.util.Enumeration en = listContracts.elements();
    while (en.hasMoreElements()) {
	    Integer k = (Integer)en.nextElement();
	    if (contrlist.length() > 0)
	    	contrlist = contrlist + ",";
	    contrlist = contrlist + k;
    }
	StringBuffer whereClause = new StringBuffer( alias + ".resource IN (SELECT c.resource FROM leasepayrules c, leaserules r " +
		" WHERE c.leaserule = r.leaserule AND r.leasedocument IN (" + contrlist + " ) ) " );
    
	  //and fill it by where clause
	  for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	  }
    
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	return ps;
}
/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findResourcesByQBE( 
	java.lang.Boolean isSubtypekey, 	ResourceSubTypeKey subtypeKey, 
	java.lang.Boolean isModel, 			java.lang.String model, 
	java.lang.Boolean isName, 			java.lang.String name, 
	Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "active='Y' " );
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
/**
 * findResourcesByQBE2 method comment.
 */
public java.sql.PreparedStatement findResourcesByQBE2(
	java.lang.Boolean isSubtypekey, 							ResourceSubTypeKey subtypeKey, 
	java.lang.Boolean isModel, 										java.lang.String model, 
	java.lang.Boolean isName, 										java.lang.String name, 
	java.lang.Boolean isManufacturer, 						java.lang.Integer manufacturer, 
	java.lang.Boolean isManucode, 								java.lang.String manucode, 
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias + ".active='Y' " );
	if( isSubtypekey.booleanValue() )
		whereClause.append( "and " + alias + ".resourcesubtype = ? " );
	if( isModel.booleanValue() )
		whereClause.append( "and upper(" + alias + ".model) matches upper(?) " );
	if( isName.booleanValue() )
		whereClause.append( "and upper(" + alias + ".name) matches upper(?) " );
	if( isManufacturer.booleanValue() )
		whereClause.append( "and " + alias + ".manufid = ? " );
	if( isManucode.booleanValue() )
		whereClause.append( "and upper(" + alias + ".manucode) matches upper(?) " );
    
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
		if( isManufacturer.booleanValue() )
			ps.setInt( j++, manufacturer.intValue() );
		if( isManucode.booleanValue() )
			ps.setString( j++, manucode );
	}   

	return ps;
}
/**
 * findResourcesByQBE2 method comment.
 */
public java.sql.PreparedStatement findResourcesByQBE3(Boolean isSubtypekey, ResourceSubTypeKey subtypeKey,
	    Boolean isModel, String model,
	    Boolean isName, String name,
	    Boolean isManufacturer, Integer manufacturer,
	    Boolean isManucode, String manucode,
	    Integer connected, Integer owner,
	    Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "active='Y' " );
	if( isSubtypekey.booleanValue() )
		whereClause.append( "and " + alias + ".resourcesubtype = ? " );
	if( isModel.booleanValue() )
		whereClause.append( "and upper(" + alias + ".model) matches upper(?) " );
	if( isName.booleanValue() )
		whereClause.append( "and upper(" + alias + ".name) matches upper(?) " );
	if( isManufacturer.booleanValue() )
		whereClause.append( "and manufid = ? " );
	if( isManucode.booleanValue() )
		whereClause.append( "and upper(" + alias + ".manucode) matches upper(?) " );
	if (connected.intValue() == 2)
		whereClause.append( "and EXISTS (SELECT * FROM pie_reslink pl WHERE " +
			" pl.idresnri = " + alias + ".resource AND pl.owner = ?) " );
	if (connected.intValue() == 3)
		whereClause.append( "and NOT EXISTS (SELECT * FROM pie_reslink pl WHERE " +
			" pl.idresnri = " + alias + ".resource AND pl.owner = ?) " );
    
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
		if( isManufacturer.booleanValue() )
			ps.setInt( j++, manufacturer.intValue() );
		if( isManucode.booleanValue() )
			ps.setString( j++, manucode );
		if (connected.intValue() == 2)
			ps.setInt( j++, owner.intValue() );
		if (connected.intValue() == 3)
			ps.setInt( j++, owner.intValue() );
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
public static void setAliasMap(java.util.HashMap newAliasMap) {
	aliasMap = newAliasMap;
}

/**
 * findResourcesByQBE method comment.
 */
public java.sql.PreparedStatement findResourceByReglamentOrderByCodeAsc(java.lang.Integer argReglament)
		throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "RESOURCES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias + ".resource IN (SELECT lmc.resource " +
		" FROM leasemutcontracts lmc WHERE lmc.reglament = ?) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = getResourceOrder(sb.toString(), alias) + " asc";;
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argReglament.intValue() );
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

	public static java.lang.String getResourceOrder(String statement, String alias ) {
		if( resourceOrder == null ) {
			resourceOrder = String.valueOf( PersistenceUtil.getFieldIndex( statement, alias+".resource" ) );
		}
		return resourceOrder;
	}

	public static void setResourceOrder(java.lang.String newResourceOrder) {
		resourceOrder = newResourceOrder;
	}
}
