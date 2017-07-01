package com.hps.july.persistence;

import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (18.05.2002 14:11:44)
 * @author: Oleg Gashnikov
 */
public class LeaseMutualReglamentBeanFinderObject extends LeaseDocumentBeanFinderObject 
implements LeaseMutualReglamentBeanFinderHelper{
	private static java.util.HashMap aliasMap;
	private static int docnumberIdx;
	public java.sql.PreparedStatement findByLeaseDocumentOrderByDocumentNumberAsc(Integer leaseDocument)
	throws Exception {
    //get generic query string 
    int i;
    int[] genericFindInsertPoints = getGenericFindInsertPoints();
    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
    //getting aliases
    String alias1 = (String) (getAliasMap(sb.toString()).get("LEASEDOCUMENTS"));
    String alias2 = (String) (getAliasMap(sb.toString()).get("LEASEMUTUALRGLMNT"));

    //calculate where clause
    StringBuffer whereClause = new StringBuffer();
    whereClause.append(alias2 + ".leasedocument in " + 
	    "(select LeaseMutualRglmnt.leasedocument from LeaseMutualRglmnt , LeaseMutContracts mc where "+
	    "LeaseMutualRglmnt.leasedocument=mc.mainleasedocument and  mc.leasedocument=?)");

    //and fill it by where clause
    for (i = 0; i < genericFindInsertPoints.length; i++) {
        sb.insert(genericFindInsertPoints[i], whereClause.toString());
    }

    sb.append(" order by "+alias1+".docnumber asc");

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
    PreparedStatement ps = getPreparedStatement(sb.toString());

    int j = 1;
    for (i = 0; i < getMergedWhereCount(); i++) {
            ps.setInt(j++, leaseDocument.intValue());
    }

    return ps;
}
	public java.sql.PreparedStatement findByQBE(
		java.lang.Boolean isDocDate, 			java.sql.Date docDate, 
		java.lang.Boolean isBlank, 				String blank, 
	    java.lang.Boolean isLeaseContract, 		Integer leaseContract, 
	    java.lang.Boolean isMutStateEdit, 
	    java.lang.Boolean isMutStateRun, 
	    java.lang.Boolean isMutStateClose, 
	    java.lang.Boolean isActType, 			String actType, 
	    java.lang.Integer order) 
			throws Exception 
	{
	    //get generic query string 
	    int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	    //getting aliases
	    String alias1 = (String) (getAliasMap(sb.toString()).get("LEASEDOCUMENTS"));
	    String alias2 = (String) (getAliasMap(sb.toString()).get("LEASEMUTUALRGLMNT"));

	    //calculate where clause
	    StringBuffer whereClause = new StringBuffer("1=1 ");
	    if (isDocDate.booleanValue())
	    	whereClause.append(" AND " + alias1 + ".docdate = ? ");
	    if (isBlank.booleanValue())
	    	whereClause.append(" AND UPPER(" + alias1 + ".docnumber) matches UPPER(?) ");

	    if (isLeaseContract.booleanValue())
	    	whereClause.append(" AND " + alias1 + ".leasedocument IN (SELECT mc.reglament FROM leasemutcontracts mc " +
		    	" WHERE mc.contract = ?) ");
	    	
	    boolean mutstate = false;
	    int mutcount = 0;
	    
	    if (isMutStateEdit.booleanValue() || isMutStateRun.booleanValue() || isMutStateClose.booleanValue())
	    	mutstate = true;

	    if (mutstate)
	    	whereClause.append(" AND (");

	    if (isMutStateEdit.booleanValue()) {
		    if (mutcount > 0)
	    		whereClause.append(" OR ");
	    	mutcount++;
	    	whereClause.append(" (" + alias2 + ".mutstate = 'A') ");
	    }

	    if (isMutStateRun.booleanValue()) {
		    if (mutcount > 0)
	    		whereClause.append(" OR ");
	    	mutcount++;
	    	whereClause.append(" (" + alias2 + ".mutstate = 'B') ");
	    }
	    
	    if (isMutStateClose.booleanValue()) {
		    if (mutcount > 0)
	    		whereClause.append(" OR ");
	    	mutcount++;
	    	whereClause.append(" (" + alias2 + ".mutstate = 'C') ");
	    }
	    
	    if (mutstate)
	    	whereClause.append(" ) ");
	    	
	    if (isActType.booleanValue())
	    	whereClause.append(" AND " + alias2 + ".acttype = ? ");
	    	
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
	        sb.insert(genericFindInsertPoints[i], whereClause.toString());
	    }

	    sb.append(" order by "+alias1+".docnumber asc");

	    //System.out.println("SQL clause=" + sb);

	    //fill prepared statement
	    PreparedStatement ps = getPreparedStatement(sb.toString());

	    int j = 1;
	    for (i = 0; i < getMergedWhereCount(); i++) {
		    if (isDocDate.booleanValue())
		    	ps.setDate(j++, docDate);
		    if (isBlank.booleanValue())
		    	ps.setString(j++, blank);
	    	if (isLeaseContract.booleanValue())
	    		ps.setInt(j++, leaseContract.intValue());
	    	if (isActType.booleanValue())
		    	ps.setString(j++, actType);
	    }

	    return ps;
	}
	public java.sql.PreparedStatement findByResourceContractDates(Integer resource, Integer contract, 
	java.sql.Date startDate, java.sql.Date finishDate) 
			throws Exception 
	{
	    //get generic query string 
	    int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	    //getting aliases
	    String alias1 = (String) (getAliasMap(sb.toString()).get("LEASEDOCUMENTS"));
	    String alias2 = (String) (getAliasMap(sb.toString()).get("LEASEMUTUALRGLMNT"));

	    //calculate where clause
	    StringBuffer whereClause = new StringBuffer(alias2 + ".mutstate = 'B' AND " +
		    alias2 + ".startdate <= ? AND " + alias2 + ".enddate >= ? AND " +
		    alias2 + ".startdate <= ? AND " + alias2 + ".enddate >= ? AND " +
		    alias2 + ".leasedocument IN (SELECT lmc.reglament FROM leasemutcontracts lmc WHERE " +
		    " lmc.resource = ? AND lmc.contract = ?) AND " + alias2 + ".startdate = " +
		    " (SELECT max(r.startdate) FROM leasemutualrglmnt r, leasemutcontracts c WHERE " +
		    " r.leasedocument = c.reglament AND c.resource = ? AND c.contract = ? AND r.mutstate = 'B' AND " +
		    " r.startdate <= ? AND r.enddate >= ? AND r.startdate <= ? AND r.enddate >= ?)"
		    );
	    	
	    	
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
	        sb.insert(genericFindInsertPoints[i], whereClause.toString());
	    }

	    //sb.append(" order by "+alias1+".docnumber asc");

	    //System.out.println("SQL clause=" + sb);

	    //fill prepared statement
	    PreparedStatement ps = getPreparedStatement(sb.toString());

	    int j = 1;
	    for (i = 0; i < getMergedWhereCount(); i++) {
		    ps.setDate(j++, startDate);
		    ps.setDate(j++, startDate);
		    ps.setDate(j++, finishDate);
		    ps.setDate(j++, finishDate);
		    ps.setInt(j++, resource.intValue());
		    ps.setInt(j++, contract.intValue());
		    ps.setInt(j++, resource.intValue());
		    ps.setInt(j++, contract.intValue());
		    ps.setDate(j++, startDate);
		    ps.setDate(j++, startDate);
		    ps.setDate(j++, finishDate);
		    ps.setDate(j++, finishDate);
	    }

	    return ps;
	}
public java.sql.PreparedStatement findByResourceContractMaxDateStart(Integer resource, Integer contract) throws Exception
	{
	    //get generic query string 
	    int i;
	    int[] genericFindInsertPoints = getGenericFindInsertPoints();
	    StringBuffer sb = new StringBuffer(getGenericFindSqlString());
	    //getting aliases
	    String alias1 = (String) (getAliasMap(sb.toString()).get("LEASEDOCUMENTS"));
	    String alias2 = (String) (getAliasMap(sb.toString()).get("LEASEMUTUALRGLMNT"));

	    //calculate where clause
	    StringBuffer whereClause = new StringBuffer(
	    alias1+".doctype = 'Q' AND "+alias1+".leasedocument = "+alias2+".leasedocument AND "
	    +alias2+".mutstate = 'B' AND "+alias2+".leasedocument IN (SELECT lmc.reglament FROM leasemutcontracts lmc "
			+"WHERE  lmc.resource = ? AND lmc.contract = ?) AND "+alias2+".startdate =  (SELECT max(r.startdate) "
			+"FROM leasemutualrglmnt r, leasemutcontracts c WHERE  r.leasedocument = c.reglament "
			+"AND c.resource = ? AND c.contract = ? AND r.mutstate = 'B') ");	    	
	    	
	    //and fill it by where clause
	    for (i = 0; i < genericFindInsertPoints.length; i++) {
	        sb.insert(genericFindInsertPoints[i], whereClause.toString());
	    }

	    String orderBy = null;
			orderBy =  getDocnumberIdx(sb.toString(), alias1)+" desc";
			sb.append( " order by "+orderBy );

	    //System.out.println("SQL clause=" + sb);

	    //fill prepared statement
	    PreparedStatement ps = getPreparedStatement(sb.toString());

	    int j = 1;
	    for (i = 0; i < getMergedWhereCount(); i++) {
		    ps.setInt(j++, resource.intValue());
		    ps.setInt(j++, contract.intValue());
		    ps.setInt(j++, resource.intValue());
		    ps.setInt(j++, contract.intValue());
	    }

	    return ps;
	}
public java.util.Map getAliasMap(String statement) {
	if( aliasMap == null ) {
		aliasMap=PersistenceUtil.getAliasesMap(statement);
	}
	return aliasMap;
}
public int getDocnumberIdx( String statement,String alias ) {
	if( docnumberIdx <= 0 ) {
		docnumberIdx = PersistenceUtil.getFieldIndex( statement, alias+".docnumber" );
	}
	return docnumberIdx;
}
}
