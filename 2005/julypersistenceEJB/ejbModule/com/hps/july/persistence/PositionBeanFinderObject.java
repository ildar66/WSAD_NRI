package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class PositionBeanFinderObject extends StoragePlaceBeanFinderObject 
implements PositionBeanFinderHelper{

	private static java.util.HashMap aliasMap;
/**
 * findByQBE method comment.
 */
public java.sql.PreparedStatement findByQBE(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, 
	java.lang.Boolean isGsmId, java.lang.String argGsmId, 
	java.lang.Boolean isDampsId, java.lang.String argDampsId, 
	java.lang.Boolean isName, java.lang.String argName, 
	Boolean isAddr, java.lang.String argAddr, 
	Integer order) throws java.lang.Exception {

	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isNetZone.booleanValue() )
		whereClause.append( "and t1.netzone = ? " );
	if( isGsmId.booleanValue() )
		whereClause.append( "and t1.gsmid = ? " );
	if( isDampsId.booleanValue() )
		whereClause.append( "and t1.dampsid = ? " );
	if( isName.booleanValue() )
		whereClause.append( "and (upper(t2.name) matches upper(?) or upper(t1.dampsname) matches upper(?))" );
	if( isAddr.booleanValue() )
		whereClause.append( "and upper(t2.address) matches upper(?) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }

    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "t2.storageplace asc";
			break;
		case 2:
			orderBy = "t2.storageplace desc";
			break;
		case 3:
			orderBy = "t2.name asc";
			break;
		case 4:
			orderBy = "t2.name desc";
			break;
		case 5:
			orderBy = "t1.gsmid asc";
			break;
		case 6:
			orderBy = "t1.gsmid desc";
			break;
		case 7:
			orderBy = "T1.dampsid asc";
			break;
		case 8:
			orderBy = "T1.dampsid desc";
			break;
	}
	sb.append( " order by "+orderBy ); 
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isNetZone.booleanValue() )
			ps.setInt( j++, argNetZone.intValue() );
		if( isGsmId.booleanValue() )
			ps.setInt( j++, Integer.valueOf( argGsmId ).intValue() );
		if( isDampsId.booleanValue() )
			ps.setInt( j++, Integer.valueOf( argDampsId ).intValue() );
		if( isName.booleanValue() ) {
			ps.setString( j++, argName );
			ps.setString( j++, argName );
		}
		if( isAddr.booleanValue() )
			ps.setString( j++, argAddr );
	}   

	return ps;
}
/**
 * findByQBE2 method comment.
 */
public java.sql.PreparedStatement findByQBE2(
	java.lang.Boolean isNetZone, 				java.lang.Integer argNetZone, 
	java.lang.Boolean isGsmId, 					java.lang.String argGsmId, 
	java.lang.Boolean isDampsId, 				java.lang.String argDampsId, 
	java.lang.Boolean isName, 					java.lang.String argName, 
	java.lang.Boolean isAddr, 					java.lang.String argAddr, 
	java.lang.Boolean isRenter, 				java.lang.Integer argRenter,
	Boolean isResponsableWorker, 				Integer argResponsableWorker, 
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "POSITIONS");
    String spAlias = getAlias(sb.toString(), "STORAGEPLACES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isNetZone.booleanValue() )
		whereClause.append( "and "+alias+".netzone = ? " );
	if( isGsmId.booleanValue() )
		whereClause.append( "and "+alias+".gsmid = ? " );
	if( isDampsId.booleanValue() )
		whereClause.append( "and "+alias+".dampsid = ? " );
	if( isName.booleanValue() )
		whereClause.append( "and (upper("+spAlias+".name) matches upper(?) or upper(t1.dampsname) matches upper(?))" );
	if( isAddr.booleanValue() )
		whereClause.append( "and upper("+spAlias+".address) matches upper(?) " );
	if( isRenter.booleanValue() )
		whereClause.append( "and renter = ? " );
	if( isResponsableWorker.booleanValue() )
		whereClause.append( "and exists (select w.* from WorkResponsibility w where "+spAlias+".storageplace=w.storageplace and w.worker = ? ) " );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }

    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = spAlias+".storageplace asc";
			break;
		case 2:
			orderBy = spAlias+".storageplace desc";
			break;
		case 3:
			orderBy = spAlias+".name asc";
			break;
		case 4:
			orderBy = spAlias+".name desc";
			break;
		case 5:
			orderBy = alias+".gsmid asc";
			break;
		case 6:
			orderBy = alias+".gsmid desc";
			break;
		case 7:
			orderBy = alias+".dampsid asc";
			break;
		case 8:
			orderBy = alias+".dampsid desc";
			break;
	}
	sb.append( " order by "+orderBy ); 
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isNetZone.booleanValue() )
			ps.setInt( j++, argNetZone.intValue() );
		if( isGsmId.booleanValue() )
			ps.setInt( j++, Integer.valueOf( argGsmId ).intValue() );
		if( isDampsId.booleanValue() )
			ps.setInt( j++, Integer.valueOf( argDampsId ).intValue() );
		if( isName.booleanValue() ) {
			ps.setString( j++, argName );
			ps.setString( j++, argName );
		}
		if( isAddr.booleanValue() )
			ps.setString( j++, argAddr );
		if( isRenter.booleanValue() )
			ps.setInt( j++, argRenter.intValue() );
		if( isResponsableWorker.booleanValue() )
			ps.setInt( j++, argResponsableWorker.intValue() );
	}   

	return ps;
}
/**
 * findByQBE3 method comment.
 */
public java.sql.PreparedStatement findByQBE3(	
	java.lang.Boolean isNetZone, 				java.lang.Integer argNetZone, 
	java.lang.Boolean isGsmId, 					java.lang.String argGsmId, 
	java.lang.Boolean isDampsId, 				java.lang.String argDampsId, 
	java.lang.Boolean isName, 					java.lang.String argName, 
	java.lang.Boolean isAddr, 					java.lang.String argAddr, 
	java.lang.Boolean isRenter, 				java.lang.Integer argRenter,
	Boolean isResponsableWorker, 				Integer argResponsableWorker,
	Boolean isInAction, 								String inAction,
	java.lang.Integer order) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "POSITIONS");
    String spAlias = getAlias(sb.toString(), "STORAGEPLACES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isNetZone.booleanValue() )
		whereClause.append( "and "+alias+".netzone = ? " );
		
	if( isGsmId.booleanValue() && isDampsId.booleanValue() ) {
		// Special case - find positions without base stations
		whereClause.append( "AND "+alias+".gsmid IS NULL AND "+alias+".dampsid IS NULL " );
	} else {
		if( isGsmId.booleanValue() )
			if ( (argGsmId == null) || ("".equals(argGsmId)) )
				whereClause.append( "and "+alias+".gsmid IS NOT NULL " );
			else
				whereClause.append( "and "+alias+".gsmid = ? " );
		if( isDampsId.booleanValue() )
			if ( (argDampsId == null) || ("".equals(argDampsId)) )
				whereClause.append( "and "+alias+".dampsid IS NOT NULL " );
			else
				whereClause.append( "and "+alias+".dampsid = ? " );
	}
		
	if( isName.booleanValue() )
		whereClause.append( "and (upper("+spAlias+".name) matches upper(?) or upper(t1.dampsname) matches upper(?))" );
	if( isAddr.booleanValue() )
		whereClause.append( "and upper("+spAlias+".address) matches upper(?) " );
	if( isRenter.booleanValue() )
		whereClause.append( "and renter = ? " );
	if( isResponsableWorker.booleanValue() )
		whereClause.append( "and exists (select w.* from WorkResponsibility w where "+spAlias+".storageplace=w.storageplace and w.worker = ? ) " );
	if( isInAction.booleanValue() ) {
		whereClause.append( "and "+alias+".inaction = ? " );
	}
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }

    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = spAlias+".storageplace asc";
			break;
		case 2:
			orderBy = spAlias+".storageplace desc";
			break;
		case 3:
			orderBy = spAlias+".name asc";
			break;
		case 4:
			orderBy = spAlias+".name desc";
			break;
		case 5:
			orderBy = alias+".gsmid asc";
			break;
		case 6:
			orderBy = alias+".gsmid desc";
			break;
		case 7:
			orderBy = alias+".dampsid asc";
			break;
		case 8:
			orderBy = alias+".dampsid desc";
			break;
	}
	sb.append( " order by "+orderBy ); 
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isNetZone.booleanValue() )
			ps.setInt( j++, argNetZone.intValue() );
		// Special case
		if( isGsmId.booleanValue() ^ isDampsId.booleanValue() ) {
			if( isGsmId.booleanValue() )
				if ( !( (argGsmId == null) || ("".equals(argGsmId)) ) )
					ps.setInt( j++, Integer.valueOf( argGsmId ).intValue() );
			if( isDampsId.booleanValue() )
				if ( !((argDampsId == null) || ("".equals(argDampsId)) ) )
					ps.setInt( j++, Integer.valueOf( argDampsId ).intValue() );
		}
		if( isName.booleanValue() ) {
			ps.setString( j++, argName );
			ps.setString( j++, argName );
		}
		if( isAddr.booleanValue() )
			ps.setString( j++, argAddr );
		if( isRenter.booleanValue() )
			ps.setInt( j++, argRenter.intValue() );
		if( isResponsableWorker.booleanValue() )
			ps.setInt( j++, argResponsableWorker.intValue() );
		if( isInAction.booleanValue() ) {
			ps.setString( j++, inAction );
		}
	}   

	return ps;
}
/**
 * findByQBE4 method comment.
 */
public java.sql.PreparedStatement findByQBE4(
	java.lang.Boolean isNetZone, 				java.lang.Integer argNetZone, 
	java.lang.Boolean isAllType, 
	java.lang.Boolean isDAMPS, 
	java.lang.Boolean isGSM900, 
	java.lang.Boolean isDCS1800, 
	java.lang.Boolean isControllers, 
	java.lang.Boolean isWorker, 				java.lang.Integer argWorker) throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "POSITIONS");
    String spAlias = getAlias(sb.toString(), "STORAGEPLACES");
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( "1=1 " );
	if( isNetZone.booleanValue() )
		whereClause.append( "and "+alias+".netzone = ? " );
	if( isDAMPS.booleanValue() || isGSM900.booleanValue() || isDCS1800.booleanValue() || isControllers.booleanValue() ) {
		whereClause.append( "and ( 0=1 " );		
		if( isDAMPS.booleanValue() )
			whereClause.append( "or exists "+
				"(select b.* from basestations b, equipment e where e.position = "+alias+
				".storageplace and e.equipment = b.equipment and b.type in (\"D\") )" );
		if( isGSM900.booleanValue() )
			whereClause.append( "or exists "+
				"(select b.* from basestations b, equipment e where e.position = "+alias+
				".storageplace and e.equipment = b.equipment and b.type in (\"S\", \"G\") )" );
		if( isDCS1800.booleanValue() )
			whereClause.append( "or exists "+
				"(select b.* from basestations b, equipment e where e.position = "+alias+
				".storageplace and e.equipment = b.equipment and b.type in (\"C\", \"G\") )" );
		if( isControllers.booleanValue() )
			whereClause.append( "or exists "+
				"(select c.* from controllers c, equipment e where e.position = "+alias+
				".storageplace and e.equipment = c.equipment )" );
		whereClause.append( " ) " );		
		}
	if( isWorker.booleanValue() )
		whereClause.append( "and exists (select w.* from WorkResponsibility w where "+spAlias+".storageplace=w.storageplace and w.worker = ? ) " );
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		if( isNetZone.booleanValue() ) {
			ps.setInt( j++, argNetZone.intValue() );
		}
		if( isWorker.booleanValue() ) {
			ps.setInt( j++, argWorker.intValue() );
		}
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 13:57:29)
 * @return java.lang.String
 * @param statement java.lang.String
 * @param alias java.lang.String
 */
public String getAlias(String statement, String alias) {
	return (String)(getAliasMap(statement).get(alias.toUpperCase()));
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 14:31:31)
 * @return java.util.HashMap
 */
public static java.util.HashMap getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 14:31:31)
 * @param newAliasMap java.util.HashMap
 */
public static void setAliasMap(java.util.HashMap newAliasMap) {
	aliasMap = newAliasMap;
}
}
