package com.hps.july.trailcom.beans;

import java.sql.*;
import com.ibm.vap.finders.*;
/**
 * Insert the type's description here.
 * Creation date: (26.09.2003 13:55:55)
 * @author: Maxim Gerasimov
 */
public class HopBeanFinderObject extends VapEJSJDBCFinderObject implements HopBeanFinderHelper{
/**
 * findByPositions method comment.
 */
public java.sql.PreparedStatement findByPositions(
	java.lang.Boolean isTypeR, 
	java.lang.Boolean isTypeO, 
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

  //calculate subwhere clause
	StringBuffer subWhereClause = new StringBuffer( "(select p.storageplace from positions p where  1=1 " );
	if( isNetZone.booleanValue() )
		subWhereClause.append( "and p.netzone = ? " );
	if( isDAMPS.booleanValue() || isGSM900.booleanValue() || isDCS1800.booleanValue() || isControllers.booleanValue() ) {
		subWhereClause.append( "and ( 0=1 " );		
		if( isDAMPS.booleanValue() )
			subWhereClause.append( "or exists "+
				"(select b.* from basestations b, equipment e where e.position = p"+
				".storageplace and e.equipment = b.equipment and b.type in (\"D\") )" );
		if( isGSM900.booleanValue() )
			subWhereClause.append( "or exists "+
				"(select b.* from basestations b, equipment e where e.position = p"+
				".storageplace and e.equipment = b.equipment and b.type in (\"S\", \"G\") )" );
		if( isDCS1800.booleanValue() )
			subWhereClause.append( "or exists "+
				"(select b.* from basestations b, equipment e where e.position = p"+
				".storageplace and e.equipment = b.equipment and b.type in (\"C\", \"G\") )" );
		if( isControllers.booleanValue() )
			subWhereClause.append( "or exists "+
				"(select c.* from controllers c, equipment e where e.position = p"+
				".storageplace and e.equipment = c.equipment )" );
		subWhereClause.append( " ) " );		
		}
	if( isWorker.booleanValue() )
		subWhereClause.append( "and exists (select w.* from WorkResponsibility w where p.storageplace=w.storageplace and w.worker = ? ) " );
	subWhereClause.append( " )" );		
  

	
  //calculate where clause
  String s = "1=1 ";
  if( isTypeR.booleanValue() && isTypeO.booleanValue() ) {
	  s = "(t1.hopstype in (\"R\", \"O\") ) ";
  } else if( isTypeR.booleanValue() ) {
	  s = "t1.hopstype = \"R\" ";
  } else if( isTypeO.booleanValue() ) {
	  s = "t1.hopstype = \"O\" ";
  }
	StringBuffer whereClause = new StringBuffer( s );
	whereClause.append( "and t1.equipmentid_enda in "+subWhereClause.toString()+
		" and t1.equipmentid_endb in "+subWhereClause.toString() );
	
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
	
	//System.out.println( "HopsBeanFinderObject.findByPositions SQL clause="+sb );
		
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
		if( isNetZone.booleanValue() ) {
			ps.setInt( j++, argNetZone.intValue() );
		}
		if( isWorker.booleanValue() ) {
			ps.setInt( j++, argWorker.intValue() );
		}
	}   

	return ps;
}
public java.sql.PreparedStatement findHopsByPosition(
		Integer position
	) throws java.lang.Exception {
	
	//get generic query string 
	int i;
  int[] genericFindInsertPoints = getGenericFindInsertPoints();
  StringBuffer sb = new StringBuffer(getGenericFindSqlString());

  StringBuffer whereClause = new StringBuffer(
	  " equipmentid_enda in (select equipment from equipment where position = ?) or "
		+" equipmentid_endb in (select equipment from equipment where position = ?) ");
    
  //and fill it by where clause
  for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
  }
	
	//System.out.println( "HopsBeanFinderObject.findByPositions SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() ); 
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt(j++, position.intValue());
		ps.setInt(j++, position.intValue());
	}   

	return ps;
}

// Фаиндер ищет, с использованием типа линии связи, все линии присоединённые к данной позиции
// текущая линия связи (Integer hop) должна исключаться

public java.sql.PreparedStatement findNestedLines(Boolean useType, String type, Integer hop, Integer position) throws java.lang.Exception {
	
	//get generic query string 
	int i;
	int[] genericFindInsertPoints = getGenericFindInsertPoints();
	StringBuffer sb = new StringBuffer(getGenericFindSqlString());

	StringBuffer whereClause = new StringBuffer(
		" (equipmentid_enda in (select equipment from equipment where position = ?) or "
		+" equipmentid_endb in (select equipment from equipment where position = ?)) ");

	if (useType.booleanValue())
		whereClause = whereClause.append(" AND hopstype = ? ");
		
	whereClause = whereClause.append(" AND hopsid <> ? ");
	
	//and fill it by where clause
	for (i = 0; i < genericFindInsertPoints.length; i++) {
		sb.insert(genericFindInsertPoints[i], whereClause.toString() );
	}
	
	//System.out.println( "HopsBeanFinderObject.findByPositions SQL clause="+sb );
		
	//fill prepared statement
	PreparedStatement ps = getPreparedStatement( sb.toString() ); 
	
	int j = 1;
	for( i = 0; i < getMergedWhereCount(); i++) {
		ps.setInt(j++, position.intValue());
		ps.setInt(j++, position.intValue());
		if (useType.booleanValue())
			ps.setString(j++, type);
		ps.setInt(j++, hop.intValue());
	}   

	return ps;
}
}
