package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
import java.sql.Date;
import com.hps.july.dictionary.valueobject.Person_VO;
/**
* Insert the type's description here.
* Creation date: (04.10.2005 11:42:12)
* @author: Shafigullin Ildar
*/
public class CDBC_Person_Object {
    private final static java.lang.String FIND_SQL =
        "SELECT organization, name, lastname, firstname, middlename, passportser, passportnum, passportdate, passportwhom "
            + "FROM organizations  WHERE typeOrg='P' ";
    private final static java.lang.String EDIT_SQL =
        "UPDATE organizations SET name=?, lastname=?, firstname=?, middlename=?, passportser=?, passportnum=?, passportdate=?, passportwhom=? "
            + "WHERE organization=? AND typeOrg='P' ";
    private final static java.lang.String ADD_SQL =
        "INSERT INTO organizations (organization, name, lastname, firstname, middlename, passportser, passportnum, passportdate, passportwhom, typeOrg, issupplier, isprovider, isrenter, isbank) "
            + "VALUES (?,?,?,?,?,?,?,?,?,'P','N','N','N','N') ";
    private final static java.lang.String DELETE_SQL = "DELETE FROM organizations WHERE organization = ? AND typeOrg='P' ";            

/**
 * CDBC_Person_Object constructor comment.
 */
public CDBC_Person_Object() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 14:06:19)
 */
public static boolean add(Person_VO vo) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params =
        {
            vo.getOrganization(),
            vo.getName(),
            vo.getLastname(),
            vo.getFirstname(),
            vo.getMiddlename(),
            vo.getPassportser(),
            vo.getPassportnum(),
            vo.getPassportdate(),
            vo.getPassportwhom()
            };
    return res.executeUpdate(ADD_SQL, params);
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 14:17:12)
 */
public static boolean delete(Person_VO vo) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = {vo.getOrganization()};
    return res.executeUpdate(DELETE_SQL, params);
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 14:14:22)
 */
public static boolean edit(Person_VO vo) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { vo.getName(), vo.getLastname(), vo.getFirstname(), vo.getMiddlename(), vo.getPassportser(), vo.getPassportnum(), vo.getPassportdate(), vo.getPassportwhom(), vo.getOrganization()};
    return res.executeUpdate(EDIT_SQL, params);
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 14:18:30)
 */
public static Person_VO find(int personID) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(personID)};
    String sql = FIND_SQL + "AND organization = ? ";
    res.executeQuery(sql, params);
    ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    Person_VO vo = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        vo = new Person_VO(ro);
    }
    return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2005 11:56:46)
 */
public static CDBCResultSet findListPerson(Boolean isName, String argName, String aSortBy) {
    StringBuffer sqlb = new StringBuffer();
    CDBCResultSet res = new CDBCResultSet();
    //add query string: 
    sqlb.append(FIND_SQL);
    //calculate filter clause
    if (isName.booleanValue())
        sqlb.append(" AND upper(name) matches upper('" + argName + "') ");
        //sqlb.append(" AND upper(lastname) matches upper('" + argName + "') ");

    //append order by clause:
    sqlb.append(" order by " + aSortBy);
    //System.out.println("from CDBC_Person_Object sql=" + sqlb);//temp
    res.executeQuery(sqlb.toString(), null);

    return res;
}
}
