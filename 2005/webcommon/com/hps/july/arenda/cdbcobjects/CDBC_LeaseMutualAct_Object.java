package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
/**
 * Insert the type's description here.
 * Creation date: (18.03.2005 14:43:39)
 * @author: Shafigullin Ildar
 */
public class CDBC_LeaseMutualAct_Object {
    private final static java.lang.String findLeaseMutualAct_SQL =
        "SELECT T1.docdate, T1.leasedocument, T1.docnumber, T1.operator, T1.doctype, T1.flagOldSystem, T1.regionid, T2.actstate, T2.actenddate, T2.actstartdate, T2.isSchetFakt, T2.header, T2.footer, T2.istemp, T2.actfilename, T2.mutualreglament "
            + "FROM leasedocuments  T1, leasemutualacts  T2 "
            + "WHERE T1.doctype = \'M\' AND T1.leasedocument = T2.leasedocument ";
/**
 * CDBC_WorkerObject constructor comment.
 */
public CDBC_LeaseMutualAct_Object() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 15:06:12)
 */
public static CDBCResultSet findListLeaseMutualAct(
 	java.lang.Boolean isMutualReglament, 			java.lang.Integer mutualReglament, 
	java.lang.Boolean isDate, 						java.sql.Date fromDate, 
	java.sql.Date toDate, 
	java.lang.Integer order) {
	    
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    Object[] args = null;
    //add query string: 
    sqlb.append(findLeaseMutualAct_SQL);
    //calculate filter clause
	if( isMutualReglament.booleanValue() )
		 sqlb.append( "and T2.mutualreglament= " + mutualReglament);
	if( isDate.booleanValue() ){
		sqlb.append( "and T1.docdate >= ? and T1.docdate <= ?" );
        args = new Object[] { fromDate, toDate };
    }
    //append order by clause:
	String orderBy = null;
	switch( order.intValue() ) {
		case 1:
			orderBy = "T1.docdate asc";
			break;
		case 2:
			orderBy = "T1.docdate desc";
			break;
		case 3:
			orderBy = "T2.actstartdate asc";
			break;
		case 4:
			orderBy = "T2.actstartdate desc";
			break;
	}
	sqlb.append( " order by "+orderBy );
	//System.out.println("findListLeaseMutualAct sql="+ sqlb);//temp
    res.executeQuery(sqlb.toString(), args);

    return res;
}
}
