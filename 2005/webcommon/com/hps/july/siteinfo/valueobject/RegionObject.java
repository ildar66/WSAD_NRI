package com.hps.july.siteinfo.valueobject;

/**
 * Класс для обработки списка регионов
 * @author: Alexander Shrago
 */
/** 
 * @deprecated 
 * В настоящее время вся функциональность перенесена в класс Regions
 */
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
  
public class RegionObject
	extends JdbcObject
{
	private int id;
	private String name; 
	public static final String QUERY_SELECT_Edit=
		"SELECT DISTINCT r.regionid, r.regname, r.supregid"+
		" FROM Regions r, RegionsAccess ra, operators o"+
		" WHERE o.operator=ra.operatorid"+
		" AND"+
		" ("+
		" (r.supregid=ra.supregionid AND ra.editfact='Y')"+
		" OR"+
		" (r.regionid=ra.regionid AND ra.editfact='Y' )"+
		" ) ";
	//public static final String QUERY_SELECT="SELECT regionid, regname, supregid FROM Regions";	

	public static final String QUERY_SELECT_View=
		"SELECT DISTINCT r.regionid, r.regname, r.supregid"+
		" FROM Regions r, RegionsAccess ra, operators o"+
		" WHERE o.operator=ra.operatorid"+
		" AND ((r.supregid=ra.supregionid AND (ra.editfact='Y' OR ra.viewfact='Y' )  ) OR (r.regionid=ra.regionid AND (ra.editfact='Y' OR ra.viewfact='Y') ) ) ";
//		" AND"+
//		" ("+
//		" (r.supregid=ra.supregionid AND (ra.editfact='Y' OR ra.viewfact='Y' OR ra.editplan='Y' OR ra.viewplan='Y' )  )"+
//		" OR"+
//		" (r.regionid=ra.regionid AND (ra.editfact='Y' OR ra.viewfact='Y' OR ra.editplan='Y' OR ra.viewplan='Y' ) )"+
//		" ) ";
		//AND o.operator=82
		//AND r.supregid=1

	public static final String QUERY_SELECT_Admin=
		" SELECT DISTINCT r.regionid, r.regname, r.supregid"+
		" FROM Regions r"+
		" WHERE 1=1 ";
/**
 * SuperRegion constructor comment.
 */
public RegionObject() throws Exception {
	super();
}
/**
 * SuperRegion constructor comment.
 */
public RegionObject(java.sql.ResultSet rs) throws Exception {
    id = rs.getInt("regionid");
    name = getString(rs,"regname");

    
    
    //"SELECT regionid, regname FROM Regions"

    }
public static String createSelectItems(String varItemsName, Integer[] items)
    throws Exception {

    if (items == null)
        return "var " + varItemsName + "=null; ";

    StringBuffer buf = new StringBuffer("var " + varItemsName + "=new Array();");

    for (int i = 0; i < items.length; i++) {

        buf.append("var "+varItemsName+"="+varItemsName + ".concat(" + items[i] + ");");
         //buf.append(varItemsName+".sort();");
    }
    return buf.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:09:13)
 * @return java.util.Enumeration
 * @param supregid java.lang.Integer
 */
public Vector findAll(String login, Boolean isAdmin) throws Exception {
	DebugSupport.printlnTest("RegionObject findAll started");
//System.out.println("siteinfo.RegionObject.findAll("+login+","+isAdmin+")");
	Query query;
	if (!isAdmin.booleanValue()) {
		query = new Query(QUERY_SELECT_View, DataUtil.RESULT_JdbcObjectVector);
		query.append("AND o.loiginid=?", login);
	} else {
		query = new Query(QUERY_SELECT_Admin, DataUtil.RESULT_JdbcObjectVector);
    }

    query.append("ORDER BY regname");

    Vector vec= findVector(query);
    return vec;
}
public Vector findBySuperRegion(Integer supregid, String login, Boolean isAdmin)
	throws Exception
{
	return findBySuperRegion(supregid,login,isAdmin,true);
}
public Vector findBySuperRegion(Integer supregid, String login, Boolean isAdmin, boolean view)
	throws Exception
{
	Query query = null;

	if (!isAdmin.booleanValue()) {
		if(view) {
			query = new Query(QUERY_SELECT_View, DataUtil.RESULT_JdbcObjectVector);
		} else {
			query = new Query(QUERY_SELECT_Edit, DataUtil.RESULT_JdbcObjectVector);
		}
		query.append("AND o.loiginid=?", login);
	} else {
		query = new Query(QUERY_SELECT_Admin, DataUtil.RESULT_JdbcObjectVector);
	}
	query.append("AND r.supregid=?", supregid);
	query.append("ORDER BY regname");

    return findVector(query);
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:39:10)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:39:10)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:39:10)
 * @param newId int
 */
public void setId(int newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:39:10)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
}
