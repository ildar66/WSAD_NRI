package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class IBPMountPosBeanFinderObject 
extends DocumentPositionBeanFinderObject
implements InWayBillPositionBeanFinderHelper{
	private static int orderIdx;
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
