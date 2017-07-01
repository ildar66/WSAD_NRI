package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
/**
 * Insert the type's description here.
 * Creation date: (18.03.2005 14:43:39)
 * @author: Shafigullin Ildar
 */
public class CDBC_BankObject {
    private final static java.lang.String findBank_SQL =
        "SELECT zip, contactlist, directorfio, isrenter, koraccount, isprovider, phone, organizationtype, phisicaladdress, shortname, organization, inn, accountmanagerfio, okpo, isbank, legaladdress, bik, name, kpp, swift, bossposition, okonh, fax, issupplier, company "
            + "FROM organizations "
            + "WHERE isbank='Y' ";
/**
 * CDBC_WorkerObject constructor comment.
 */
public CDBC_BankObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 15:06:12)
 */
public static CDBCResultSet findListBanks(
    Boolean isName,    String argName,
    Boolean isBic,    String argBic,
    String aSortBy) {
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    //add query string: 
    sqlb.append(findBank_SQL);
    //calculate filter clause
    if (isName.booleanValue())
        sqlb.append("and upper(name) matches upper('"+argName+"') ");
    if (isBic.booleanValue())
        sqlb.append("and upper(bik) matches upper('"+argBic+"') ");
    //append order by clause:
    sqlb.append("order by " + aSortBy);

    res.executeQuery(sqlb.toString(), null);

    return res;
}
}
