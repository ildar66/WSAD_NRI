package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeasePayOrderBeanFinderObject extends LeasePaymentBeanFinderObject  
	implements LeasePayOrderBeanFinderHelper{
	private static int dateIdx;
	private static java.util.Map aliasMap;		
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
 * Creation date: (01.07.2002 10:39:22)
 * @return int
 */
public int getDateIdx( String statement,String alias ) {
	if( dateIdx <= 0 ) {
		dateIdx = PersistenceUtil.getFieldIndex( statement, alias+".date" );
	}
	return dateIdx;
}
}
