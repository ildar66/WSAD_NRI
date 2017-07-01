package com.hps.july.persistence;

import java.sql.*;

public class LeaseResBil2NRIBeanFinderObject extends com.ibm.vap.finders.VapEJSJDBCFinderObject 
implements LeaseResBil2NRIBeanFinderHelper{
	private static java.util.HashMap aliasMap;
public java.sql.PreparedStatement findByQBE(
		Boolean isSubtype, Integer subtype,
    Boolean isModel, String model,
    Boolean isName, String name,
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer connected,
    Integer order
	) throws Exception{
	    //get generic query string 
	    int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	    //getting aliases
	    String alias = (String) (getAliasMap(sb.toString()).get("LEASERESBIL2NRI"));

	    StringBuffer connect = new StringBuffer("(select resource from resources where 1=1 ");
	    if(isSubtype.booleanValue())
	    	connect.append(" and resourcesubtype = "+subtype.intValue());
	    if(isModel.booleanValue())
	    	connect.append(" and model = '"+model+"'");
	    if(isName.booleanValue())
	    	connect.append(" and name = '"+name+"'"); 
	    if(isManufacturer.booleanValue())
	    	connect.append(" and manufacturer = "+manufacturer.intValue());
	    if(isManucode.booleanValue())
	    	connect.append(" and manucode = '"+manucode+"'");
	    connect.append(")");
	    
	    //calculate where clause
	    StringBuffer whereClause = new StringBuffer("1=1 ");
	    if (connected.intValue() == 1)
	    	whereClause.append(" AND " + alias + ".resource is null or "+alias+".resource in "+connect.toString());
	    else if (connected.intValue() == 2)
	    	whereClause.append(" AND " + alias + ".resource in"+connect.toString());
			else if (connected.intValue() == 3)
	    	whereClause.append(" AND " + alias + ".resource is null ");
	    	
	    	
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
	        sb.insert(genericFindInsertPoints[i], whereClause.toString());
	    }

	    if(order.intValue() == 1)
		    sb.append(" order by "+alias+".idresbilling asc");
		  else if(order.intValue() == 2)
		    sb.append(" order by "+alias+".idresbilling desc");
		  else if(order.intValue() == 3)
		    sb.append(" order by "+alias+".billresname asc");
		  else if(order.intValue() == 4)
		    sb.append(" order by "+alias+".billresname desc");

	    //System.out.println("SQL clause=" + sb);

	    //fill prepared statement
	    PreparedStatement ps = getPreparedStatement(sb.toString());

	    return ps;
	}
public java.sql.PreparedStatement findByQBE2(
		Boolean isIdresbilling, String idresbilling, /* должен поддерживаться поиск по маске, т.е. "*" */
    Boolean isBillresname, String billresname, /* должен поддерживаться поиск по маске, т.е. "*" */
    Integer connected,
    Integer order
	) throws Exception{
	    //get generic query string 
	    int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	    //getting aliases
	    String alias = (String) (getAliasMap(sb.toString()).get("LEASERESBIL2NRI"));

	    //calculate where clause
	    StringBuffer whereClause = new StringBuffer("1=1 ");
	    if( isIdresbilling.booleanValue() )
				whereClause.append( " and upper("+alias+".idresbilling) matches upper(?) " );
			if( isBillresname.booleanValue() )
				whereClause.append( " and upper("+alias+".billresname) matches upper(?) " );
	    if (connected.intValue() == 1);
	    else if (connected.intValue() == 2)
	    	whereClause.append(" AND " + alias + ".resource is not null "); 
			else if (connected.intValue() == 3)
	    	whereClause.append(" AND " + alias + ".resource is null ");
	    	
	    	
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
	        sb.insert(genericFindInsertPoints[i], whereClause.toString());
	    }

	    if(order.intValue() == 1)
		    sb.append(" order by "+alias+".idresbilling asc");
		  else if(order.intValue() == 2)
		    sb.append(" order by "+alias+".idresbilling desc");
		  else if(order.intValue() == 3)
		    sb.append(" order by "+alias+".billresname asc");
		  else if(order.intValue() == 4)
		    sb.append(" order by "+alias+".billresname desc");

	    //System.out.println("LeaseResBill2Nri.findByQBE2 SQL clause=" + sb);

	    //fill prepared statement
	    PreparedStatement ps = getPreparedStatement(sb.toString());

	    int j = 1;
			for( i = 0; i < getMergedWhereCount(); i++) {
				if(isIdresbilling.booleanValue() )
					ps.setString( j++, idresbilling );
				if(isBillresname.booleanValue() )
					ps.setString( j++, billresname );
			}
			
	    return ps;
}
public java.util.Map getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
}
