package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class StorageCardBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements StorageCardBeanFinderHelper{

	private static java.util.HashMap aliasMap;
/**
 * findByResourceQBE method comment.
 */
public java.sql.PreparedStatement findByResourceQBE(java.lang.Integer argResourceSubType, java.lang.Integer argStorage, 
	java.lang.String argPolicy, java.lang.String argSerial, java.lang.String argParty, java.lang.Integer order) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( 
		"exists (select resource from resources where resource=t1.resource and resourcesubtype=?) and "+
		"t1.storageplace = ? and t1.policy=? " );
	if( argPolicy.equals( "S" ) )
		whereClause.append( "and upper(t1.serialnumber) matches upper(?) " );
	else if( argPolicy.equals( "P" ) )
		whereClause.append( "and upper(t1.party) matches upper(?) " );
	
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "t1.resource asc";
			break;
		case 2:
			orderBy = "t1.resource desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argResourceSubType.intValue() );
		ps.setInt( j++, argStorage.intValue() );
		ps.setString( j++, argPolicy );
		if( argPolicy.equals( "S" ) )
			ps.setString( j++, argSerial );			
		else if( argPolicy.equals( "P" ) )
			ps.setString( j++, argParty );			
	}   

	return ps;
}
public java.sql.PreparedStatement findByStorageNotInDoc(
    Integer storageplace,
    Boolean useAgregate, Integer agregate,
    Integer document,
    Integer order ) throws java.lang.Exception {
	    
		//get generic query string 
		int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "STORAGECARDS");
    
    //calculate where clause
		StringBuffer whereClause = new StringBuffer( alias + ".closed = 'N' AND " + alias + ".storageplace = ? ");

		if (useAgregate.booleanValue())
			whereClause.append( "AND " + alias + ".storagecard IN (SELECT agregatepart FROM agregatecontents WHERE agregate=?) " );
	
		whereClause.append( "AND ( (" + alias + ".policy = 'S' AND " + alias + ".serialnumber NOT IN " +
			"(SELECT dp.serialnumber FROM docpositions.dp WHERE dp.document = ?) " +
		  ") OR ( " + alias + ".policy = 'P' AND " + alias + ".party NOT IN " +
			"(SELECT dp.party FROM docpositions.dp WHERE dp.document = ?) " +
		  ") OR ( " + alias + ".policy = 'B' AND " + alias + ".resource NOT IN " +
			"(SELECT dp.resource FROM docpositions.dp WHERE dp.document = ?) " +
			") ) "
		);
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = alias + ".storagecard asc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, storageplace.intValue() );
		if (useAgregate.booleanValue())
			ps.setInt( j++, agregate.intValue() );
		ps.setInt( j++, document.intValue() );
		ps.setInt( j++, document.intValue() );
		ps.setInt( j++, document.intValue() );
	}   

	return ps;
}
/**
 * findByResourceQBE method comment.
 */
public java.sql.PreparedStatement findStorageCardByQBE(
    Integer storageplace,
    Boolean isOwner, Integer owner,
    Boolean isResourceset, Integer resourceset,
    Boolean isResource, Integer resource,
    Boolean isSubType, Integer resourceSubType,
    Boolean isModel, String model, /* match строчка */
    Boolean isName, String name, /* match строчка */
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer order
) throws java.lang.Exception {
		//get generic query string 
		int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    String alias = getAlias(sb.toString(), "STORAGECARDS");
    
    //calculate where clause
		StringBuffer whereClause = new StringBuffer( alias + ".closed = 'N' AND " + alias + ".storageplace = ? ");

	
		if (isOwner.booleanValue())	
			whereClause.append( "and " + alias + ".owner = ? " );

		if (isResourceset.booleanValue())
			whereClause.append( "and " + alias + ".storagecard IN (SELECT agregatepart FROM agregatecontents WHERE agregate=?) " );

		if (isResource.booleanValue()) {
			whereClause.append( "and " + alias + ".resource = ? " );
		} else {
			if (isSubType.booleanValue())
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and resourcesubtype=?) ");
			if (isModel.booleanValue())
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and upper(model) matches upper(?)) ");
			if (isName.booleanValue())
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and upper(name) matches upper(?)) ");
			if (isManufacturer.booleanValue()) 
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and manufacturer=?) ");
			if (isManucode.booleanValue())
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and upper(manucode) matches upper(?)) ");
		}
		
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    
	//append order by clause
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = alias + ".serialnumber asc";
			break;
		case 2:
			orderBy = alias + ".serialnumber desc";
			break;
		case 3:
			orderBy = alias + ".party asc";
			break;
		case 4:
			orderBy = alias + ".party desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, storageplace.intValue() );
		if (isOwner.booleanValue())	
			ps.setInt( j++, owner.intValue() );

		if (isResourceset.booleanValue())
			ps.setInt( j++, resourceset.intValue() );

		if (isResource.booleanValue()) {
			ps.setInt( j++, resource.intValue() );
		} else {
			if (isSubType.booleanValue())
				ps.setInt( j++, resourceSubType.intValue() );
			if (isModel.booleanValue())
				ps.setString( j++, model );
			if (isName.booleanValue())
				ps.setString( j++, name );
			if (isManufacturer.booleanValue()) 
				ps.setInt( j++, manufacturer.intValue() );
			if (isManucode.booleanValue())
				ps.setString( j++, manucode );
		}
	}   

	return ps;
}
/**
 * findByResourceQBE method comment.
 */
public java.sql.PreparedStatement findStorageCardByQBE2(
    Boolean isSubType, Integer resourceSubType,
    Boolean isModel, String model, /* match строчка */
    Boolean isName, String name, /* match строчка */
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer connected, Integer owner,
    Integer order
		) throws java.lang.Exception {
			
		//get generic query string 
		int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	    String alias = getAlias(sb.toString(), "STORAGECARDS");
	    
	    //calculate where clause
		StringBuffer whereClause = new StringBuffer( alias + ".policy='S' " );
	
		if (isSubType.booleanValue())
	  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and resourcesubtype=?) ");
		if (isModel.booleanValue())
	  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and upper(model) matches upper(?)) ");
		if (isName.booleanValue())
	  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and upper(name) matches upper(?)) ");
		if (isManufacturer.booleanValue()) 
	  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and manufacturer=?) ");
		if (isManucode.booleanValue())
	  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and upper(manucode) matches upper(?)) ");

	  	if (connected.intValue() == 2)	
			whereClause.append( " and EXISTS (SELECT ps.storagecard FROM pie_serialreslink ps " +
				" WHERE ps.storagecard = " + alias + ".storagecard AND ps.owner = ? )" );
	  	if (connected.intValue() == 3)	
			whereClause.append( " and NOT EXISTS (SELECT ps.storagecard FROM pie_serialreslink ps " +
				" WHERE ps.storagecard = " + alias + ".storagecard AND ps.owner = ? )" );
    
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
				sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	    }
    
		//append order by clause
		String orderBy = null;
		switch( order.intValue() ) {
		case 1:
			orderBy = alias + ".serialnumber asc";
			break;
		case 2:
			orderBy = alias + ".serialnumber desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {

		if (isSubType.booleanValue())
			ps.setInt( j++, resourceSubType.intValue() );
		if (isModel.booleanValue())
			ps.setString( j++, model );
		if (isName.booleanValue())
			ps.setString( j++, name );
		if (isManufacturer.booleanValue()) 
			ps.setInt( j++, manufacturer.intValue() );
		if (isManucode.booleanValue())
			ps.setString( j++, manucode );
	  	if (connected.intValue() == 2)	
			ps.setInt( j++, owner.intValue() );
	  	if (connected.intValue() == 3)	
			ps.setInt( j++, owner.intValue() );
	}   

	return ps;
}
/**
 * findByResourceQBE method comment.
 */
public java.sql.PreparedStatement findStorageCardByQBE3(
    Integer storageplace,
    Boolean isOwner, Integer owner,
    Boolean isResourceset, Integer resourceset,
    Boolean isResource, Integer resource,
    Boolean isSubType, Integer resourceSubType,
    Boolean isModel, String model, /* match строчка */
    Boolean isName, String name, /* match строчка */
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Boolean onlyWithoutParts,
    Integer brokenType,
    Integer documentKey,
    Boolean useExcludeFilter, Integer storageCard,
    Boolean usePolicy, String policy,
    Integer order
) throws java.lang.Exception {
	
		//get generic query string 
		int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	    String alias = getAlias(sb.toString(), "STORAGECARDS");
    
    	//calculate where clause
		StringBuffer whereClause = new StringBuffer( alias + ".closed = 'N' AND " + alias + ".storageplace = ? ");

	
		if (isOwner.booleanValue())	
			whereClause.append( "and " + alias + ".owner = ? " );

		if (isResourceset.booleanValue())
			whereClause.append( "and " + alias + ".storagecard IN (SELECT agregatepart FROM agregatecontents WHERE agregate=?) " );

		if (isResource.booleanValue()) {
			whereClause.append( "and " + alias + ".resource = ? " );
		} else {
			if (isSubType.booleanValue())
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and resourcesubtype=?) ");
			if (isModel.booleanValue())
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and upper(model) matches upper(?)) ");
			if (isName.booleanValue())
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and upper(name) matches upper(?)) ");
			if (isManufacturer.booleanValue()) 
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and manufacturer=?) ");
			if (isManucode.booleanValue())
		  	whereClause.append("and exists (select resource from resources where resource=" + alias + ".resource and upper(manucode) matches upper(?)) ");
		}
		
		if (onlyWithoutParts.booleanValue()) 
		  	whereClause.append(" and " + alias + ".qty > NVL((SELECT sum(a.qty) FROM agregatecontents a WHERE a.agregatepart = " + alias + ".storagecard),0) ");

		if (brokenType.intValue() == 1) 
		  	whereClause.append(" and " + alias + ".broken = 'N' ");
		if (brokenType.intValue() == 2) 
		  	whereClause.append(" and " + alias + ".broken = 'Y' ");


		if (documentKey.intValue() >= 1) {
		  	whereClause.append(" AND ( " +
			  	" ( " + alias + ".policy = 'S' AND " + alias + ".serialnumber NOT in (SELECT NVL(d.serialnumber,'') FROM docpositions d " +
			  	"WHERE d.document = ?) " +
			  	" ) OR ( " +
			  	alias + ".policy = 'P' AND ( (" + alias + ".party NOT IN (SELECT NVL(d.party,'') FROM docpositions d " +
			  	"WHERE d.document = ? AND d.owner = " + alias + ".owner) ) OR (" + alias + ".qty > (SELECT sum(d.qty) " +
			  	"FROM docpositions d WHERE d.party = " + alias + ".party AND d.owner = " + alias + ".owner AND d.document=?) ) )" +
			  	" ) OR ( " +
			  	alias + ".policy = 'B' AND ( (" + alias + ".resource NOT IN (SELECT d.resource FROM docpositions d " +
			  	"WHERE d.document = ? AND d.owner = " + alias + ".owner) ) OR (" + alias + ".qty > (SELECT sum(d.qty) " +
			  	"FROM docpositions d WHERE d.resource = " + alias + ".resource AND d.owner = " + alias + ".owner AND d.document=?) ) )" +
			  	" ) )" );
		}

		if (useExcludeFilter.booleanValue()) 
		  	whereClause.append(" and " + alias + ".storagecard <> ? ");

		if (usePolicy.booleanValue()) 
		  	whereClause.append(" and " + alias + ".policy = ? ");
		  		
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
				sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	    }
    
		//append order by clause
		String orderBy = null;
		switch( order.intValue() ) {
			case 1:
				orderBy = alias + ".serialnumber asc";
				break;
			case 2:
				orderBy = alias + ".serialnumber desc";
				break;
			case 3:
				orderBy = alias + ".party asc";
				break;
			case 4:
				orderBy = alias + ".party desc";
				break;
		}
		sb.append( " order by "+orderBy );
		
		//System.out.println( "SQL clause="+sb );
		
		//fill prepared statement
		PreparedStatement ps = getPreparedStatement( sb.toString() );
		
		int j = 1;
		for( i = 0; i < getMergedWhereCount(); i++) {
			ps.setInt( j++, storageplace.intValue() );
			if (isOwner.booleanValue())	
				ps.setInt( j++, owner.intValue() );

			if (isResourceset.booleanValue())
				ps.setInt( j++, resourceset.intValue() );

			if (isResource.booleanValue()) {
				ps.setInt( j++, resource.intValue() );
			} else {
				if (isSubType.booleanValue())
					ps.setInt( j++, resourceSubType.intValue() );
				if (isModel.booleanValue())
					ps.setString( j++, model );
				if (isName.booleanValue())
					ps.setString( j++, name );
				if (isManufacturer.booleanValue()) 
					ps.setInt( j++, manufacturer.intValue() );
				if (isManucode.booleanValue())
					ps.setString( j++, manucode );
			}
			if (documentKey.intValue() >= 1) {
				ps.setInt( j++, documentKey.intValue() );
				ps.setInt( j++, documentKey.intValue() );
				ps.setInt( j++, documentKey.intValue() );
				ps.setInt( j++, documentKey.intValue() );
				ps.setInt( j++, documentKey.intValue() );
			}
			if (useExcludeFilter.booleanValue()) 
				ps.setInt( j++, storageCard.intValue() );
			if (usePolicy.booleanValue()) 
				ps.setString( j++, policy );
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
