package com.hps.july.jdbcpersistence.lib;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
  
/**
 * Объект для работы с суперрегионами.
 * Creation date: (17.02.2003 22:56:26)
 * @author: Alexander Shrago
 */
public class SuperRegionObject extends JdbcObject{
private int id;
private String name;
private Vector regions;
public static final int ORDER_BY_CODE_ASC=1;
public static final int ORDER_BY_CODE_DESC=2;
public static final int ORDER_BY_NAME_ASC=3;
public static final int ORDER_BY_NAME_DESC=4;   

public static final String QUERY_SELECT_Admin=
 " SELECT sr.supregid, sr.supregname"
+" FROM SuperRegions sr";

public static final String QUERY_SELECT=
 " SELECT sr.supregid, sr.supregname"
+" FROM SuperRegions sr, RegionsAccess ra, operators o";	
/**
 * SuperRegion constructor comment.
 */
public SuperRegionObject() throws Exception {
	super();
}
/**
 * SuperRegion constructor comment.
 */
public SuperRegionObject(java.sql.ResultSet rs) throws Exception{
 id=rs.getInt("supregid");
 name=getString(rs,"supregname");
 
  
}
public static String createEditSelectData(
    String javascriptArrayName,
    Enumeration supercollection,
    String login,
    Boolean isAdmin)
    throws Exception {

	int j=0;
	int k=0;

    String array = "var " + javascriptArrayName + "=new Array(";

    while (supercollection.hasMoreElements()) {
j++;
        SuperRegionObject superRegion =
            (SuperRegionObject) supercollection.nextElement();
        Enumeration regionsCollection =
            superRegion.getEditRegions(login, isAdmin,SearchConstants.SEARCH_ALL).elements();
        array = array + "new Array(";
k=0;
        while (regionsCollection.hasMoreElements()) {
k++;
            RegionObject region = (RegionObject) regionsCollection.nextElement();

            array = array + "new Array(" + region.getId() + ",'" + region.getName() + "'),";
        }

        // We get rid of last comma
        if (k>0)
            array = array.substring(0, array.lastIndexOf(","));

        array = array + "),";
    }

    // We get rid of last comma
    if (j>0)
        array = array.substring(0, array.lastIndexOf(","));

    array = array + "); ";

    //DebugSupport.printlnTest(array);

    return array;
}
public static String createEditSelectData(
    String javascriptArrayName,
    Enumeration supercollection,
    String login,
    Boolean isAdmin,
    String planstate)
    throws Exception {

return createSelectData(javascriptArrayName,supercollection,login,isAdmin,planstate,true);
	    
}
public static String createSelectData(
    String javascriptArrayName,
    Enumeration supercollection,
    String login,
    Boolean isAdmin,
    String planstate,
    boolean canEdit)
    throws Exception {

    int j = 0;
    int k = 0;

    String array = "var " + javascriptArrayName + "=new Array(";

    while (supercollection.hasMoreElements()) {
        j++;
        SuperRegionObject superRegion =
            (SuperRegionObject) supercollection.nextElement();

        Enumeration regionsCollection;

        if (canEdit) {

            regionsCollection =
                superRegion.getEditRegions(login, isAdmin, planstate).elements();
        } else {
            regionsCollection =
                superRegion.getViewRegions(login, isAdmin, planstate).elements();
        }

        array = array + "new Array(";
        k = 0;
        while (regionsCollection.hasMoreElements()) {
            k++;
            RegionObject region = (RegionObject) regionsCollection.nextElement();

            array = array + "new Array(" + region.getId() + ",'" + region.getName() + "'),";
        }

        // We get rid of last comma
        if (k > 0)
            array = array.substring(0, array.lastIndexOf(","));

        array = array + "),";
    }

    // We get rid of last comma
    if (j > 0)
        array = array.substring(0, array.lastIndexOf(","));

    array = array + "); ";

    //DebugSupport.printlnTest(array);

    return array;
}
public static String createViewSelectData(
    String javascriptArrayName,
    Enumeration supercollection,
    String login,
    Boolean isAdmin)
    throws Exception {

	int j=0;
	int k=0;
DebugSupport.printlnTest("createViewSelectData started");
	
    String array = "var " + javascriptArrayName + "=new Array(";

    while (supercollection.hasMoreElements()) {
j++;
        SuperRegionObject superRegion =
            (SuperRegionObject) supercollection.nextElement();
        Enumeration regionsCollection =
            superRegion.getViewRegions(login, isAdmin,SearchConstants.SEARCH_ALL).elements();
        array = array + "new Array(";
k=0;
        while (regionsCollection.hasMoreElements()) {
k++;
            RegionObject region = (RegionObject) regionsCollection.nextElement();

            array = array + "new Array(" + region.getId() + ",'" + region.getName() + "'),";
        }

        // We get rid of last comma
        if (k>0)
            array = array.substring(0, array.lastIndexOf(","));

        array = array + "),";
    }

    // We get rid of last comma
    if (j>0)
        array = array.substring(0, array.lastIndexOf(","));

    array = array + "); ";

    //DebugSupport.printlnTest(array);

    return array;
}
public static String createViewSelectData(
    String javascriptArrayName,
    Enumeration supercollection,
    String login,
    Boolean isAdmin,
    String planstate)
    throws Exception {

return createSelectData(javascriptArrayName,supercollection,login,isAdmin,planstate,false);
	    
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Enumeration findEditEnum(javax.servlet.http.HttpServletRequest request) throws Exception {
    return findEditVector(request.getRemoteUser(), isAdmin(request), SearchConstants.SEARCH_ALL).elements();
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Enumeration findEditEnum(
    javax.servlet.http.HttpServletRequest request,
    String planstateEdit)
    throws Exception {

	    return findEditVector(request.getRemoteUser(),isAdmin(request),planstateEdit).elements();
	    
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Vector findEditVector(String login, Boolean isAdmin) throws Exception {
    return findEditVector(login, isAdmin, SearchConstants.SEARCH_ALL);
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Vector findEditVector(
    String login,
    Boolean isAdmin,
    String planstateEdit)
    throws Exception {

    Query query = new Query(DataUtil.RESULT_JdbcObjectVector);

    if (!isAdmin.booleanValue()) {

        query.append("SELECT DISTINCT r.supregid, sr.supregname");
        query.append("FROM regions r, SuperRegions sr, RegionsAccess ra, operators o");
        query.append("WHERE ra.operatorid=o.operator");
        query.append(" AND sr.supregid=r.supregid");
        query.append(" AND (r.supregid=ra.supregionid OR r.regionid=ra.regionid)");
        query.append(" AND o.loiginid=?", login);
        if (planstateEdit.equals(Checks.POSITION_PLANSTATE_Fact)) {
            query.append("AND ra.editfact='Y'");
        } else if (planstateEdit.equals(Checks.POSITION_PLANSTATE_Plan)) {
            query.append("AND ra.editplan='Y'");
        } else {
            query.append("AND (ra.editplan='Y' OR ra.editfact='Y')");
        }

    } else {
        query.append("SELECT sr.supregid, sr.supregname");
        query.append("FROM SuperRegions sr");

    }
    query.append("ORDER BY supregname ASC");
    return findVector(query);
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Vector findEditVector(javax.servlet.http.HttpServletRequest request) throws Exception {
    return findEditVector(request.getRemoteUser(), isAdmin(request), SearchConstants.SEARCH_ALL);
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Vector findEditVector(
    javax.servlet.http.HttpServletRequest request,
    String planstateEdit)
    throws Exception {

	    return findEditVector(request.getRemoteUser(),isAdmin(request),planstateEdit);
	    
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Vector
 */
public Vector findSuperRegionList(Integer order) throws Exception {

    Query query = new Query();

    query.append("SELECT  supregid , supregname");
    query.append("FROM SuperRegions sr");

    switch (order.intValue()) {
        case ORDER_BY_CODE_ASC :
            query.append("ORDER BY 1");
            break;
        case ORDER_BY_CODE_DESC :
            query.append("ORDER BY 1 DESC");
            break;
        case ORDER_BY_NAME_ASC :
            query.append("ORDER BY 2");
            break;
        case ORDER_BY_NAME_DESC :
            query.append("ORDER BY 2 DESC");
    }

    return findVector(query);
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Enumeration findViewEnum(javax.servlet.http.HttpServletRequest request) throws Exception {
    return findViewVector(request.getRemoteUser(), isAdmin(request), SearchConstants.SEARCH_ALL).elements();
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Enumeration findViewEnum(
    javax.servlet.http.HttpServletRequest request,
    String planstateEdit)
    throws Exception {

	    return findViewVector(request.getRemoteUser(),isAdmin(request),planstateEdit).elements();
	    
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Vector findViewVector(String login, Boolean isAdmin) throws Exception {
    return findViewVector(login, isAdmin, SearchConstants.SEARCH_ALL);
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Vector findViewVector(
    String login,
    Boolean isAdmin,
    String planstateEdit)
    throws Exception {

    Query query = new Query(DataUtil.RESULT_JdbcObjectVector);

    if (!isAdmin.booleanValue()) {

        query.append("SELECT DISTINCT r.supregid, sr.supregname");
        query.append("FROM regions r, SuperRegions sr, RegionsAccess ra, operators o");
        query.append("WHERE ra.operatorid=o.operator");
        query.append(" AND sr.supregid=r.supregid");
        query.append(" AND (r.supregid=ra.supregionid OR r.regionid=ra.regionid)");
        query.append(" AND o.loiginid=?", login);
        if (planstateEdit.equals(Checks.POSITION_PLANSTATE_Fact)) {
            query.append("AND ra.viewfact='Y'");
        } else if (planstateEdit.equals(Checks.POSITION_PLANSTATE_Plan)) {
            query.append("AND ra.viewplan='Y'");
        } else {
            query.append("AND (ra.viewfact='Y' OR ra.viewplan='Y')");
        }

    } else {
        query.append("SELECT sr.supregid, sr.supregname");
        query.append("FROM SuperRegions sr");

    }
    query.append("ORDER BY supregname ASC");
    return findVector(query);
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:40:10)
 * @return java.util.Enumeration
 */
public Vector findViewVector(
    javax.servlet.http.HttpServletRequest request,
    String planstateEdit)
    throws Exception {

	 Boolean isAdmin=isAdmin(request);
	 String login=request.getRemoteUser(); 

    Query query = new Query(DataUtil.RESULT_JdbcObjectVector);

    if (!isAdmin.booleanValue()) {

        query.append("SELECT DISTINCT r.supregid, sr.supregname");
        query.append("FROM regions r, SuperRegions sr, RegionsAccess ra, operators o");
        query.append("WHERE ra.operatorid=o.operator");
        query.append(" AND sr.supregid=r.supregid");
        query.append(" AND (r.supregid=ra.supregionid OR r.regionid=ra.regionid)");
        query.append(" AND o.loiginid=?", login);
        if (planstateEdit.equals(Checks.POSITION_PLANSTATE_Fact)) {
            query.append("AND ra.viewfact='Y'");
        } else if (planstateEdit.equals(Checks.POSITION_PLANSTATE_Plan)) {
            query.append("AND ra.viewplan='Y'");
        } else {
            query.append("AND (ra.viewfact='Y' OR ra.viewplan='Y')");
        }

    } else {
        query.append("SELECT sr.supregid, sr.supregname");
        query.append("FROM SuperRegions sr");

    }
    query.append("ORDER BY supregname ASC");
    return findVector(query);
}
/*
+" WHERE sr.supregid=ra.supregionid"
+"   AND ra.operatorid=o.operator";
OR sr.supregid IN"
+"      (SELECT r.supregid FROM regions. 
*/
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 22:59:45)
 * @return java.util.Vector
 */
public java.util.Vector getEditRegions(String login, Boolean isAdmin,String planstate) throws Exception{
    if (regions == null)
        regions = new RegionObject().findEditBySuperRegion(new Integer(id),login,isAdmin,planstate);
    return regions;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:46:37)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 22:59:45)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 22:59:45)
 * @return java.util.Vector
 */
public java.util.Vector getViewRegions(String login, Boolean isAdmin,String planstate) throws Exception{
    if (regions == null)
        regions = new RegionObject().findViewBySuperRegion(new Integer(id),login,isAdmin,planstate);
    return regions;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 18:46:37)
 * @param newId int
 */
public void setId(int newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 22:59:45)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 22:59:45)
 * @param newRegions java.util.Vector
 */
public void setRegions(java.util.Vector newRegions) {
	regions = newRegions;
}
}
