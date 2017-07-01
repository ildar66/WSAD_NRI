package com.hps.july.siteinfo.valueobject;

/**
 * Класс для работы со списками суперрегионов
 * Совсем стар! Суперстар!
 * @author: Alexander Shrago
 */
/**
 * @deprecated 
 * use com.hps.july.jdbcpersistence.lib.SuperRegionObject
 */
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
  
public class SuperRegionObject
	extends JdbcObject
{
	private int id;
	private String name;
	private Vector regions;

	public static final String QUERY_SELECT_Admin = "SELECT sr.supregid, sr.supregname FROM SuperRegions sr";
	public static final String QUERY_SELECT = "SELECT sr.supregid, sr.supregname FROM SuperRegions sr, RegionsAccess ra, operators o";
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
public static String createSelectData(String javascriptArrayName, Enumeration supercollection, String login, Boolean isAdmin)
	throws Exception
{
	int j=0;
	int k=0;

	String array = "var " + javascriptArrayName + "=new Array(";

	while (supercollection.hasMoreElements()) {
		j++;
        SuperRegionObject superRegion = (SuperRegionObject) supercollection.nextElement();
        Enumeration regionsCollection = superRegion.getRegions(login, isAdmin).elements();
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
	if (j>0) {
		array = array.substring(0, array.lastIndexOf(","));
	}

	array = array + "); ";
    return array;
}
public Enumeration findAll(String login, Boolean isAdmin)
	throws Exception
{
	return findAll_Vector(login,isAdmin).elements();
}
public Vector findAll_Vector(String login, Boolean isAdmin)
	throws Exception
{
	Query query = new Query(DataUtil.RESULT_JdbcObjectVector);

	if (!isAdmin.booleanValue()) {
		query.append("SELECT DISTINCT r.supregid, sr.supregname");
		query.append("FROM regions r, SuperRegions sr, RegionsAccess ra, operators o");
		query.append("WHERE ra.operatorid=o.operator");
		query.append(" AND sr.supregid=r.supregid");
		query.append(" AND (r.supregid=ra.supregionid OR r.regionid=ra.regionid)");
		query.append(" AND o.loiginid=? ", login);
		query.append(" AND (ra.viewfact = 'Y' OR ra.editfact= 'Y')");
	} else {
		query.append("SELECT sr.supregid, sr.supregname");
		query.append("FROM SuperRegions sr");
	}
	query.append("ORDER BY supregname ASC");
	return findVector(query);
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
public java.util.Vector getRegions(String login, Boolean isAdmin)
	throws Exception
{
	if (regions == null) {
		regions = new RegionObject().findBySuperRegion(new Integer(id),login,isAdmin);
    }
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
