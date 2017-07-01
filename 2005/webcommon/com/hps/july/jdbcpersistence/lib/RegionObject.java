package com.hps.july.jdbcpersistence.lib;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
  
/**
 * Объект для работы с регионами.
 * Creation date: (17.02.2003 22:56:26)
 * @author: Alexander Shrago
 */
public class RegionObject extends JdbcObject{

private int id;
private String name; 
//public static final String QUERY_SELECT="SELECT regionid, regname, supregid FROM Regions";

private String supregName;
    //public static final String QUERY_SELECT="SELECT regionid, regname, supregid FROM Regions";
private Integer supregId;    	

    public static final int ORDER_BY_CODE_ASC = 1;
    public static final int ORDER_BY_CODE_DESC = 2;
    public static final int ORDER_BY_SUPREGNAME_ASC = 3;
     public static final int ORDER_BY_SUPREGNAME_DESC = 4;
    public static final int ORDER_BY_REGNAME_ASC = 5;
    public static final int ORDER_BY_REGNAME_DESC = 6;	

public static final String QUERY_SELECT_EditPlan=

"SELECT DISTINCT r.regionid, r.regname, r.supregid"
+" FROM Regions r, RegionsAccess ra, operators o"
+" WHERE o.operator=ra.operatorid"
+" AND"
+" ("
+" (r.supregid=ra.supregionid AND ra.editplan='Y'  )"
+" OR"
+" (r.regionid=ra.regionid AND ra.editplan='Y' )"
+" )";
//public static final String QUERY_SELECT="SELECT regionid, regname, supregid FROM Regions";	

public static final String QUERY_SELECT_EditFact=

"SELECT DISTINCT r.regionid, r.regname, r.supregid"
+" FROM Regions r, RegionsAccess ra, operators o"
+" WHERE o.operator=ra.operatorid"
+" AND"
+" ("
+" (r.supregid=ra.supregionid AND ra.editfact='Y'  )"
+" OR"
+" (r.regionid=ra.regionid AND ra.editfact='Y' )"
+" ) ";
//public static final String QUERY_SELECT="SELECT regionid, regname, supregid FROM Regions";	

public static final String QUERY_SELECT_Edit=

"SELECT DISTINCT r.regionid, r.regname, r.supregid"
+" FROM Regions r, RegionsAccess ra, operators o"
+" WHERE o.operator=ra.operatorid"
+" AND"
+" ("
+" (r.supregid=ra.supregionid AND (ra.editfact='Y' OR ra.editplan='Y') )"
+" OR"
+" (r.regionid=ra.regionid AND (ra.editfact='Y' OR ra.editplan='Y') )"
+" ) ";
//public static final String QUERY_SELECT="SELECT regionid, regname, supregid FROM Regions";	

public static final String QUERY_SELECT_View=

"SELECT DISTINCT r.regionid, r.regname, r.supregid"
+" FROM Regions r, RegionsAccess ra, operators o"
+" WHERE o.operator=ra.operatorid"
+" AND"
+" ("
+" (r.supregid=ra.supregionid AND ( ra.viewfact='Y'  OR ra.viewplan='Y' )  )"
+" OR"
+" (r.regionid=ra.regionid AND (ra.viewfact='Y'  OR ra.viewplan='Y' ) )"
+" ) ";
//public static final String QUERY_SELECT="SELECT regionid, regname, supregid FROM Regions";	

public static final String QUERY_SELECT_ViewFact=

"SELECT DISTINCT r.regionid, r.regname, r.supregid"
+" FROM Regions r, RegionsAccess ra, operators o"
+" WHERE o.operator=ra.operatorid"
+" AND"
+" ("
+" (r.supregid=ra.supregionid AND  ra.viewfact='Y')"
+" OR"
+" (r.regionid=ra.regionid AND  ra.viewfact='Y' )"
+" ) ";
//public static final String QUERY_SELECT="SELECT regionid, regname, supregid FROM Regions";	

public static final String QUERY_SELECT_ViewPlan=

"SELECT DISTINCT r.regionid, r.regname, r.supregid"
+" FROM Regions r, RegionsAccess ra, operators o"
+" WHERE o.operator=ra.operatorid"
+" AND"
+" ("
+" (r.supregid=ra.supregionid AND  ra.viewplan='Y')"
+" OR"
+" (r.regionid=ra.regionid AND  ra.viewplan='Y' )"
+" ) ";

//AND o.operator=82
//AND r.supregid=1

public static final String QUERY_SELECT_Admin=

 " SELECT DISTINCT r.regionid, r.regname, r.supregid" 
+" FROM Regions r"
+" WHERE 1=1 ";


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
    name = getString(rs, "regname");
    supregName = getString(rs, "supregname");
    supregId = getInteger(rs, "supregid");

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
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:09:13)
 * @return java.util.Enumeration
 * @param supregid java.lang.Integer
 
 */
public Vector findAllEdit(
    Integer supregid/*not used!?*/,
    String login,
    Boolean isAdmin,
    String planstate)
    throws Exception {
    Query query = null;

    if (!isAdmin.booleanValue()) {

        if (planstate.equals(Checks.POSITION_PLANSTATE_Fact)) {
            query = new Query(QUERY_SELECT_EditFact, RESULT_JdbcObjectVector);

        } else
            if (planstate.equals(Checks.POSITION_PLANSTATE_Plan)) {
                query = new Query(QUERY_SELECT_EditPlan, RESULT_JdbcObjectVector);
            }else{
	            query = new Query(QUERY_SELECT_Edit, RESULT_JdbcObjectVector);
	            }
        query.append("AND o.loiginid=?", login);
    } else {
        query = new Query(QUERY_SELECT_Admin, DataUtil.RESULT_JdbcObjectVector);
    }
    
    query.append("ORDER BY regname");

    return findVector(query);
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:09:13)
 * @return java.util.Enumeration
 * @param supregid java.lang.Integer
 */
public Vector findAllEdit(String login, Boolean isAdmin, String planstate)
    throws Exception {
    Query query = null;

    if (!isAdmin.booleanValue()) {

        if (planstate.equals(Checks.POSITION_PLANSTATE_Fact)) {
            query = new Query(QUERY_SELECT_EditFact, RESULT_JdbcObjectVector);

        } else if (planstate.equals(Checks.POSITION_PLANSTATE_Plan)) {
            query = new Query(QUERY_SELECT_EditPlan, RESULT_JdbcObjectVector);
        } else {
            query = new Query(QUERY_SELECT_Edit, RESULT_JdbcObjectVector);
        }
        query.append("AND o.loiginid=?", login);
    } else {
        query = new Query(QUERY_SELECT_Admin, DataUtil.RESULT_JdbcObjectVector);
    }

    query.append("ORDER BY regname");

    return findVector(query);
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:09:13)
 * @return java.util.Enumeration
 * @param supregid java.lang.Integer
 */
public Vector findEditBySuperRegion(
    Integer supregid,
    String login,
    Boolean isAdmin)
    throws Exception {
    return findEditBySuperRegion(
        supregid,
        login,
        isAdmin,
        SearchConstants.SEARCH_ALL);
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:09:13)
 * @return java.util.Enumeration
 * @param supregid java.lang.Integer
 */
public Vector findEditBySuperRegion(
    Integer supregid,
    String login,
    Boolean isAdmin,
    String planstate)
    throws Exception {
    Query query = null;

    if (!isAdmin.booleanValue()) {

        if (planstate.equals(Checks.POSITION_PLANSTATE_Fact)) {
            query = new Query(QUERY_SELECT_EditFact, RESULT_JdbcObjectVector);

        } else
            if (planstate.equals(Checks.POSITION_PLANSTATE_Plan)) {
                query = new Query(QUERY_SELECT_EditPlan, RESULT_JdbcObjectVector);
            }else{
	            query = new Query(QUERY_SELECT_Edit, RESULT_JdbcObjectVector);
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
 * Creation date: (18.02.2003 19:09:13)
 * @return java.util.Enumeration
 * @param supregid java.lang.Integer
 */
public Vector findRegionList(
    String searchBy,
    String name,
    Boolean isAllSupregs,
    Integer supregid,
    Integer order)
    throws Exception {

    DebugSupport.printlnTest("!!RegionObject findRegionList name="+name);	
    Query query = new Query();
    query.append(
        "SELECT r.regionid regionid, r.regname regname, r.supregid supregid, sr.supregname supregname");
    query.append("FROM Regions r, Superregions sr");
    query.append("WHERE r.supregid=sr.supregid");

    if (searchBy.equals(SearchConstants.SEARCHBY_NAME)) {
        query.append("AND r.regname matches upper(?)", name);
    }
    if (!isAllSupregs.booleanValue()) {
        query.append("AND r.supregid=?", supregid);
    }
    query.append("ORDER BY");
    if (order.intValue() == ORDER_BY_CODE_ASC) {
        query.append("1");
    }else if (order.intValue() == ORDER_BY_CODE_DESC) {
        query.append("1 DESC");
    }else if (order.intValue() == ORDER_BY_SUPREGNAME_ASC) {
        query.append("4,2");
    }else if (order.intValue() == ORDER_BY_SUPREGNAME_DESC) {
        query.append("4 DESC,2 DESC");
    }else if (order.intValue() == ORDER_BY_REGNAME_ASC) {
        query.append("2");
    }else if (order.intValue() == ORDER_BY_REGNAME_DESC) {
        query.append("2 DESC");
    }
    return findVector(query);
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:09:13)
 * @return java.util.Enumeration
 * @param supregid java.lang.Integer
 */
public Vector findViewBySuperRegion(
    Integer supregid,
    String login,
    Boolean isAdmin)
    throws Exception {
    return findViewBySuperRegion(
        supregid,
        login,
        isAdmin,
        SearchConstants.SEARCH_ALL);
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 19:09:13)
 * @return java.util.Enumeration
 * @param supregid java.lang.Integer
 */
public Vector findViewBySuperRegion(
    Integer supregid,
    String login,
    Boolean isAdmin,
    String planstate)
    throws Exception {
    Query query = null;

    if (!isAdmin.booleanValue()) {

        if (planstate.equals(Checks.POSITION_PLANSTATE_Fact)) {
            query = new Query(QUERY_SELECT_ViewFact, RESULT_JdbcObjectVector);

        } else
            if (planstate.equals(Checks.POSITION_PLANSTATE_Plan)) {
                query = new Query(QUERY_SELECT_ViewPlan, RESULT_JdbcObjectVector);
            }else{
	            query = new Query(QUERY_SELECT_View, RESULT_JdbcObjectVector);
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
 * Creation date: (29.08.2003 20:25:27)
 * @return java.lang.Integer
 */
public java.lang.Integer getSupregId() {
	return supregId;
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2003 18:20:37)
 * @return java.lang.String
 */
public java.lang.String getSupregName() {
	return supregName;
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
/**
 * Insert the method's description here.
 * Creation date: (29.08.2003 20:25:27)
 * @param newSupregId java.lang.Integer
 */
public void setSupregId(java.lang.Integer newSupregId) {
	supregId = newSupregId;
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2003 18:20:37)
 * @param newSupregName java.lang.String
 */
public void setSupregName(java.lang.String newSupregName) {
	supregName = newSupregName;
}
}
