package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class DocumentPositionBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject  implements DocumentPositionBeanFinderHelper{
	private static int orderIdx;
	private static int agregateIdx;
	private static java.util.Map aliasMap;
/**
 * findBadAgregatesByDocument method comment.
 */
public java.sql.PreparedStatement findBadAgregatesByDocument(java.lang.Integer argDocument) throws java.lang.Exception {
	StringBuffer sb = new StringBuffer( 
	"select d.* from docpositions d where d.document = ? and "+
	"d.agregate is not null and not exists ( "+
	"select s.serialnumber from storagecards s, docpositions d1, "+
	"agregatecontents a, storagecards s1 where "+
	"d1.docposition = d.agregate and "+
	"s.serialnumber = d1.serialnumber and s.closed = \"N\" and "+
	"a.agregate = s.storagecard and "+
	"s1.storagecard = a.agregatepart  and ( "+
	"s1.serialnumber = d.serialnumber and   "+
	"s1.policy = \"S\" and s1.closed = \"N\" or  "+
	"s1.party = d.party and s1.policy = \"P\" and d.qty = a.qty or "+
	"s1.resource = d.resource and s1.policy = \"B\" and d.qty = a.qty "+
	") "+
	") "+
	"  "+
	"union all "+
	" "+
	"select d.* from docpositions d where d.document = ? and "+
	"agregate is null and exists "+
	"(select s.* from storagecards s, "+
	"agregatecontents a where  s.policy = \"S\" and "+
	"s.serialnumber = d.serialnumber and s.closed = \"N\" and "+
	"a.agregatepart  = s.storagecard )                      "
	);
    		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	ps.setInt( 1, argDocument.intValue() );
	ps.setInt( 2, argDocument.intValue() );
	
	return ps;
}
/**
 * findByAgregateAfterDate method comment.
 */
public java.sql.PreparedStatement findByAgregateAfterDate(String argAgregatSerial, java.sql.Date argDate) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer(
		"( "+alias+".agregateserial = ? or "+alias+".oldagregateserial = ? ) and "+
		alias+".document in (select d.document from documents d where d.blankdate > ? and  d.state=\"2\" )" );
    
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setString( j++, argAgregatSerial );
		ps.setString( j++, argAgregatSerial );
		ps.setDate( j++, argDate );
	}   

	return ps;
}
/**
 * findByDocOrderByAgregateAsc method comment.
 */
public java.sql.PreparedStatement findByDocOrderByAgregateAsc(java.lang.Integer argDocument) throws java.lang.Exception {
	return findByParent( argDocument, 3, Boolean.FALSE, null );
}
/**
 * findByDocOrderByAgregateDesc method comment.
 */
public java.sql.PreparedStatement findByDocOrderByAgregateDesc(java.lang.Integer argDocument) throws java.lang.Exception {
	return findByParent( argDocument, 4, Boolean.FALSE, null );
}
/**
 * findByDocumentSerialnum method comment.
 */
public java.sql.PreparedStatement findByDocumentQBE(
	    Integer argDocument,
	    String argPolicy, String argNumber,
	    Boolean isResource, Integer argResource,
	    Integer order) throws java.lang.Exception {
		    
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias+".document = ? ");

	if ("S".equals(argPolicy))
		whereClause = whereClause.append(" AND " + alias + ".serialnumber = ? ");
	else if ("P".equals(argPolicy))
		whereClause = whereClause.append(" AND " + alias + ".party = ? ");
    
	if (isResource.booleanValue())
		whereClause = whereClause.append(" AND " + alias + ".resource = ? ");
		
		
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argDocument.intValue() );
		if ("S".equals(argPolicy) || "P".equals(argPolicy))
			ps.setString( j++, argNumber );
		if (isResource.booleanValue())
			ps.setInt( j++, argResource.intValue() );
	}   

	return ps;
}
/**
 * findByDocumentSerialnum method comment.
 */
public java.sql.PreparedStatement findByDocumentQBE2(
	    Integer argDocument,
	    String argPolicy, String argNumber,
	    Boolean isOwner, Integer owner,
	    Boolean isResource, Integer argResource,
	    Integer order) throws java.lang.Exception {
		    
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias+".document = ? ");

	if ("S".equals(argPolicy))
		whereClause = whereClause.append(" AND " + alias + ".serialnumber = ? ");
	else if ("P".equals(argPolicy))
		whereClause = whereClause.append(" AND " + alias + ".party = ? ");
    
	if (isResource.booleanValue())
		whereClause = whereClause.append(" AND " + alias + ".resource = ? ");
		
	if (isOwner.booleanValue())
		whereClause = whereClause.append(" AND " + alias + ".owner= ? ");
		
		
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argDocument.intValue() );
		if ("S".equals(argPolicy) || "P".equals(argPolicy))
			ps.setString( j++, argNumber );
		if (isResource.booleanValue())
			ps.setInt( j++, argResource.intValue() );
		if (isOwner.booleanValue())
			ps.setInt( j++, owner.intValue() );
	}   

	return ps;
}
/**
 * findByDocumentSerialnum method comment.
 */
public java.sql.PreparedStatement findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias+".document = ? and "+alias+".serialnumber = ?" );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argDocument.intValue() );
		ps.setString( j++, argSerial );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2002 14:13:39)
 * @return java.sql.PreparedStatement
 */
public PreparedStatement findByParent( Integer argEncloser, int order, Boolean argIsPolicy, String argPolicy ) throws Exception {

	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());
  //get documents alias
  java.util.Map m = getAliasMap(sb.toString());
  String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias+".document = ? " );
	if( argIsPolicy.booleanValue() )
		whereClause.append( 
			"and exists (select r.resource from resources r where r.resource = "+alias+".resource and r.countpolicy = ?) " );
    
    
    //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
    
	//append order by clause
	String orderBy = null;
	switch( order ) {
		case 1:
			orderBy = getOrderIdx(sb.toString(),alias)+" asc";
			break;
		case 2:
			orderBy = getOrderIdx(sb.toString(),alias)+" desc";
			break;
		case 3:
			orderBy = "7 asc";
			break;
		case 4:
			orderBy = "7 desc";
			break;
	}
	sb.append( " order by "+orderBy );
	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argEncloser.intValue() );
		if( argIsPolicy.booleanValue() )
			ps.setString( j++, argPolicy );
	}   

	return ps;
}
/**
 * findByDocumentSerialnum method comment.
 */
public java.sql.PreparedStatement findByQBE(Integer argResource, Integer argOwner, 
		Boolean isSerial, String argSerial,
		Boolean isParty, String argParty,
		Boolean isTo, Integer argTo,
		Boolean isFrom, Integer argFrom,
		String argDocType,
		Boolean isAddDoc, Integer argAddDoc
	) throws java.lang.Exception {

		try {
			System.out.println("DocPosition.FindByQBE called: resource=" + argResource + ", owner=" + argOwner +
				", isSerial=" + isSerial + ", serial=" + argSerial + ", isParty=" + argParty +
				", isTo=" + isTo + ", to=" + argTo + ", isFrom=" + isFrom +
				", from=" + argFrom + ", doctype=" + argDocType +
				", isadddoc=" + isAddDoc + ", adddoc=" + argAddDoc);
		} catch (Exception e) {
			System.out.println("DocPosition.FindByQBE log exception:" + e.getMessage());
		}
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias+".resource = ? AND "+alias+".owner = ? ");

	if (isSerial.booleanValue())
		whereClause = whereClause.append(" AND " + alias + ".serialnumber = ? ");
    
	if (isParty.booleanValue())
		whereClause = whereClause.append(" AND " + alias + ".party = ? ");
		
	if (isTo.booleanValue()) {
		whereClause = whereClause.append(" AND ( (" + alias + ".qty > (SELECT sum(plp.qty) " +
			" FROM pie_linkprihrash plp WHERE plp.docposprihod = " + alias + ".docposition) ) OR " +
			" (NOT EXISTS (SELECT plp.qty FROM pie_linkprihrash plp " +
			" WHERE plp.docposprihod = " + alias + ".docposition) ) ) "
			);
		
		whereClause = whereClause.append(" AND (" + alias + ".document IN (SELECT d.document FROM documents d " +
			" WHERE d.to = ? AND d.type = ? AND ( (d.state = '2') ");

		if (isAddDoc.booleanValue())
			whereClause = whereClause.append(" OR (d.document = ?) ");
			
		whereClause = whereClause.append(") ) )");
		
		if ("S".equals(argDocType))
			whereClause = whereClause.append(" AND " + alias + ".document IN (SELECT dp.documentto FROM " +
				"docdependencies dp, documents dc WHERE dp.type = 'S' AND " +
				"dp.documentfrom = dc.document AND dc.type = 'H') ");
			
		if ("A".equals(argDocType))
			whereClause = whereClause.append(" AND 'D' = (SELECT a.operationtype FROM " +
				"asemblingacts a WHERE a.document = " + alias + ".document) " );
			
	}
		
	if (isFrom.booleanValue()) {
		whereClause = whereClause.append(" AND ( (" + alias + ".qty > (SELECT sum(plp.qty) " +
			" FROM pie_linkprihrash plp WHERE plp.docposrashod = " + alias + ".docposition) ) OR " +
			" (NOT EXISTS (SELECT plp.qty FROM pie_linkprihrash plp " +
			" WHERE plp.docposrashod = " + alias + ".docposition) ) ) "
			);
		
		whereClause = whereClause.append(" AND (" + alias + ".document IN (SELECT d.document FROM documents d " +
			" WHERE d.from = ? AND d.type = ? AND ( (d.state = '2') ");
		
		if (isAddDoc.booleanValue())
			whereClause = whereClause.append(" OR (d.document = ?) ");
			
		whereClause = whereClause.append(") ) )");
		
		if ("P".equals(argDocType))
			whereClause = whereClause.append(" AND " + alias + ".document IN (SELECT dp.documentto FROM " +
				"docdependencies dp, documents dc WHERE dp.type = 'P' AND " +
				"dp.documentfrom = dc.document AND dc.type = 'H') ");
			
		if ("A".equals(argDocType))
			whereClause = whereClause.append(" AND 'A' = (SELECT a.operationtype FROM " +
				"asemblingacts a WHERE a.document = " + alias + ".document) " );
			
	}
		
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argResource.intValue() );
		ps.setInt( j++, argOwner.intValue() );
		if (isSerial.booleanValue())
			ps.setString( j++, argSerial );
		if (isParty.booleanValue())
			ps.setString( j++, argParty );
		if (isTo.booleanValue()) {
			ps.setInt( j++, argTo.intValue() );
			ps.setString( j++, argDocType );
			if (isAddDoc.booleanValue())
				ps.setInt( j++, argAddDoc.intValue() );
		}
		if (isFrom.booleanValue()) {
			ps.setInt( j++, argFrom.intValue() );
			ps.setString( j++, argDocType );
			if (isAddDoc.booleanValue())
				ps.setInt( j++, argAddDoc.intValue() );
		}
	}   

	return ps;
}
public java.sql.PreparedStatement findByRequestResource(Integer requestId, Integer resourceId) 
	throws java.lang.Exception {
	
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias+".document IN"
		+"(SELECT documentto FROM docdependencies WHERE type = 'O' AND documentfrom = ?) AND "+alias+".resource = ?");
							
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
			sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    	
	//System.out.println( "SQL clause DocumentPositionBean.findByRequestResource="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, requestId.intValue() );
		ps.setInt( j++, resourceId.intValue() );
	}   

	return ps;
}
/**
 * findByResourceSetAndStorageAfterDate method comment.
 */
public java.sql.PreparedStatement findByResourceSetAndStorageAfterDate(java.lang.Integer argDocument, java.lang.Integer argStorage, java.sql.Date argDate) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( 
		alias+".document in (select d.document from documents d where d.blankdate > ? and "+
		"(d.from = ? and d.processsource=\"Y\" or d.to = ? and d.processdestination = \"Y\") and d.state=\"2\" ) and "+
		alias+".resource in (select i.resource from i13nactresourceset i where i.document = ?)" );
    
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setDate( j++, argDate );
		ps.setInt( j++, argStorage.intValue() );
		ps.setInt( j++, argStorage.intValue() );
		ps.setInt( j++, argDocument.intValue() );
	}   

	return ps;
}
/**
 * findByStorageAfterDate method comment.
 */
public java.sql.PreparedStatement findByStorageAfterDate(java.lang.Integer argStorage, java.sql.Date argDate) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( 
		alias+".document in (select d.document from documents d where d.blankdate > ? and "+
		"(d.from = ? and d.processsource=\"Y\" or d.to = ? and d.processdestination = \"Y\") and d.state=\"2\" )" );
    
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setDate( j++, argDate );
		ps.setInt( j++, argStorage.intValue() );
		ps.setInt( j++, argStorage.intValue() );
	}   

	return ps;
}
/**
 * findDocPositionsByDocAndPolicyOrderByOrderAsc method comment.
 */
public java.sql.PreparedStatement findDocPositionsByDocAndPolicyOrderByOrderAsc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.lang.Exception {
	return findByParent( argDocument, 1, Boolean.TRUE, argPolicy );
}
/**
 * findDocPositionsByDocAndPolicyOrderByOrderDesc method comment.
 */
public java.sql.PreparedStatement findDocPositionsByDocAndPolicyOrderByOrderDesc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.lang.Exception {
	return findByParent( argDocument, 2, Boolean.TRUE, argPolicy );
}
/**
 * findDocPositionsByDocOrderByOrderAsc method comment.
 */
public java.sql.PreparedStatement findDocPositionsByDocOrderByOrderAsc(java.lang.Integer argDocument) throws java.lang.Exception {
	return findByParent( argDocument, 1, Boolean.FALSE, null );
}
/**
 * findDocPositionsByDocOrderByOrderAsc method comment.
 */
public java.sql.PreparedStatement findDocPositionsByDocOrderByOrderDesc(java.lang.Integer argDocument) throws java.lang.Exception {
	return findByParent( argDocument, 2, Boolean.FALSE, null );
}
/**
 * findMaxOrderPosition method comment.
 */
public java.sql.PreparedStatement findMaxOrderPosition(java.lang.Integer argDocument) throws java.lang.Exception {
	//get generic query string 
	int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //get documents alias
    java.util.Map m = getAliasMap(sb.toString());
    String alias = (String)(m.get("DOCPOSITIONS"));
    
    //calculate where clause
	StringBuffer whereClause = new StringBuffer( alias+".document = ? and "+alias+
		".order = ( select max(dp.order) from docpositions dp where dp.document = ? )" );
    
    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
    }
    	
	//System.out.println( "SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() );
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt( j++, argDocument.intValue() );
		ps.setInt( j++, argDocument.intValue() );
	}   

	return ps;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 10:39:22)
 * @return int
 */
public static int getAgregateIdx( String statement,String alias ) {
	if( agregateIdx <= 0 ) {
		agregateIdx = PersistenceUtil.getFieldIndex( statement, alias+".agregate" );
	}
	return agregateIdx;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:06:36)
 * @return java.util.Map
 */
public java.util.Map getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 10:39:05)
 * @return int
 */
public int getOrderIdx(String statement, String alias) {
	if( orderIdx <= 0 ) {
		orderIdx = PersistenceUtil.getFieldIndex( statement, alias+".order" );
	}
	return orderIdx;
}
}
