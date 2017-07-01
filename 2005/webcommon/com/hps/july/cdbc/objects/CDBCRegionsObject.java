package com.hps.july.cdbc.objects;

import java.util.*;
import com.hps.july.cdbc.lib.*;

/**
 * ќбъект дл€ получени€ списков по регионам
 */
public class CDBCRegionsObject {
public CDBCRegionsObject() {
	super();
}
public static void appendIN(StringBuffer sb, String param, Integer[] array)
{
	if(array == null) {
		return;
	} else if(array.length == 0)  {
		sb.append(param);
		sb.append(" IS NULL ");
	} else {
		sb.append(param);
		sb.append(" IN (");
		for(int i = 0; i < array.length; i++) {
			if(i > 0) sb.append(",");
			if(array[i] != null) {
				sb.append(array[i]);
			} else {
				sb.append(array[i]);
			}
		}
		sb.append(") ");
	}
}
/**
 * ѕровер€ет требуетс€ ли согласование актов монтажа дл€ указанного региона
 */
public boolean checkNeedApprove(Integer argRegionId)
{
	boolean result = false;
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery("SELECT needapprove FROM regions WHERE regionid = ?", new Object[] {argRegionId});
	ListIterator it = res.listIterator();
	if (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		String needapprove = ro.getColumn("needapprove").asString();
		result = "Y".equals(needapprove);
	}
	return result;
}
/**
 * ¬озвращает список всех регионов доступных оператору на просмотр (EditFact = TRUE)
 */
public CDBCResultSet findAllEditRegions(String username, boolean admin)
	throws java.lang.Exception
{
	return findAllViewEditRegions(username, admin, true);
}
/**
 * ¬озвращает список всех регионов доступных оператору на просмотр (ViewFact = TRUE)
 */
public CDBCResultSet findAllRegions(String username, boolean admin)
	throws java.lang.Exception
{
	return findAllViewEditRegions(username, admin, false);
}
/**
 * ¬озвращает список всех регионов доступных оператору на просмотр (ViewFact = TRUE) или изменение (EditFact = TRUE)
 */
public CDBCResultSet findAllViewEditRegions(String username, boolean admin, boolean canEdit)
	throws java.lang.Exception
{
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();
	
	if(!admin) {
		sb.append("SELECT r.regionid, r.supregid, r.regname, r.hasmap, r.fullarendainfo FROM regions r, operators o WHERE ");
		sb.append("(r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.operatorid = o.operator AND ");
		if (canEdit)
			sb.append("ra.editfact = 'Y' ");
		else
			sb.append("ra.viewfact = 'Y' ");
		sb.append(") ");
		sb.append("OR r.supregid IN (SELECT ra.supregionid FROM regionsaccess ra WHERE ra.accesstype = 'S' AND ra.operatorid = o.operator AND ");
		if (canEdit)
			sb.append("ra.editfact = 'Y' ");
		else
			sb.append("ra.viewfact = 'Y' ");
		sb.append(")) ");
		sb.append("AND o.loiginid = ? ");
		
		if(username == null) {
			params.add("");
		} else {
			params.add(username);
		}
	} else {
		sb.append("SELECT r.regionid, r.supregid, r.regname, r.hasmap, r.fullarendainfo FROM regions r ");
	}
	sb.append("ORDER BY r.regname ASC ");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
public int findDefaultRegion(String username, boolean admin, Integer supregid, boolean canEdit)
	throws java.lang.Exception
{
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();
	
	if(!admin) {
		sb.append("SELECT r.regionid, r.supregid, r.regname FROM regions r, operators o WHERE ");
		sb.append("(regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.operatorid = o.operator AND ");
		if (canEdit)
			sb.append("ra.editfact = 'Y' ");
		else
			sb.append("ra.viewfact = 'Y' ");
		sb.append(") ");
		sb.append("OR supregid IN (SELECT ra.supregionid FROM regionsaccess ra WHERE ra.accesstype = 'S' AND ra.operatorid = o.operator AND ");
		if (canEdit)
			sb.append("ra.editfact = 'Y' ");
		else
			sb.append("ra.viewfact = 'Y' ");
		sb.append(")) ");
		sb.append("AND o.loiginid = ? ");
		
		if(username == null) {
			params.add("");
		} else {
			params.add(username);
		}
	} else {
		sb.append("SELECT r.regionid, r.supregid, r.regname FROM regions r ");
	}
	if(supregid != null) {
		sb.append("WHERE r.supregid = ? ");
		params.add(supregid);
	}
	sb.append("ORDER BY r.regname ASC ");

	CDBCResultSet rs = new CDBCResultSet();
	rs.executeQuery(sb.toString(), params.toArray());
	int res = 0;
	Iterator it = rs.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Object o = ro.getColumn("regionid").asObject();
		if(o != null && o instanceof Integer) {
			res = ((Integer)o).intValue();
		}
	}
	return res;
}
public int findDefaultSuperregions(String username, boolean admin)
	throws java.lang.Exception
{
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();
	
	if(!admin) {
		sb.append("SELECT FIRST 1 DISTINCT r.supregid, sr.supregname ");
		sb.append("FROM regions r, superregions sr, regionsaccess ra, operators o ");
		sb.append("WHERE ra.operatorid=o.operator "); 
		sb.append("AND sr.supregid=r.supregid ");
		sb.append("AND (r.supregid=ra.supregionid OR r.regionid=ra.regionid) ");
		sb.append("AND o.loiginid = ? ");
		sb.append("AND (ra.viewfact = 'Y' OR ra.editfact= 'Y') ");
		sb.append("ORDER BY sr.supregname ");
		
		if(username == null) {
			params.add("");
		} else {
			params.add(username);
		}
	} else {
		sb.append("SELECT sr.supregid, sr.supregname FROM superregions sr ");
		sb.append("ORDER BY sr.supregname ");
	}

	CDBCResultSet rs = new CDBCResultSet();
	rs.executeQuery(sb.toString(), params.toArray());
	Iterator it = rs.listIterator();
	int res = 0;
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Object o = ro.getColumn("spregid").asObject();
		if(o != null && o instanceof Integer) {
			res = ((Integer)o).intValue();
		}
	}
	return res;
}
/**
 * ¬озвращает список всех типов аппаратной
 */
public CDBCResultSet findNetzones()
	throws java.lang.Exception
{
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery("SELECT netzone, regionid, name FROM netzones", null);
	return res;
}
/**
 * ¬озвращает список всех типов аппаратной
 */
public CDBCResultSet findNetzonesByRegions(Boolean useRegions, Integer[] regions)
	throws java.lang.Exception
{
	CDBCResultSet res = new CDBCResultSet();
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT nz.netzone, nz.regionid, nz.name, nz.zonecode, r.regname ");
	sb.append("FROM netzones nz, regions r ");
	sb.append("WHERE nz.regionid = r.regionid ");
	if(useRegions != null && useRegions.booleanValue()) {
		appendIN(sb," AND nz.regionid ",regions);
	}
	res.executeQuery(sb.toString(), null);
	return res;
}
/**
 * ¬озвращает список всех типов аппаратной
 */
public CDBCResultSet findNetzonesByRegions(Boolean useSuperregions, Integer[] superregions, Boolean useRegions, Integer[] regions)
	throws java.lang.Exception
{
	CDBCResultSet res = new CDBCResultSet();
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT nz.netzone, nz.regionid, nz.name, nz.zonecode, r.regname ");
	sb.append("FROM netzones nz, regions r ");
	sb.append("WHERE nz.regionid = r.regionid ");
	if(useRegions != null && useRegions.booleanValue()) {
		appendIN(sb," AND nz.regionid ",regions);
	}
	res.executeQuery(sb.toString(), null);
	return res;
}
/**
 * ¬озвращает список всех типов аппаратной
 */
public CDBCResultSet findNetzonesByRegions(
	Boolean useSuperregions, Integer[] superregions, 
	Boolean useRegions, Integer[] regions, 
	String username, Boolean isAdmin
)
	throws java.lang.Exception
{
	CDBCResultSet res = new CDBCResultSet();
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();
	if(isAdmin != null && isAdmin.booleanValue()) {
		sb.append("SELECT nz.netzone, nz.regionid, nz.name, nz.zonecode, r.regname, sr.supregname ");
		sb.append("FROM netzones nz, regions r, superregions sr ");
		sb.append("WHERE nz.regionid = r.regionid AND r.supregid = sr.supregid ");
		if(useRegions != null && useRegions.booleanValue()) {
			appendIN(sb,"AND nz.regionid ",regions);
		} else if(useSuperregions != null && useSuperregions.booleanValue()) {
			appendIN(sb,"AND r.supregid ",superregions);
		}
	} else {
		sb.append("SELECT nz.netzone, nz.regionid, r.supregid, nz.name, nz.zonecode, r.regname, sr.supregname ");
		sb.append("FROM netzones nz, regions r, superregions sr, operators o ");
		sb.append("WHERE nz.regionid = r.regionid AND r.supregid = sr.supregid AND ");
		sb.append("(r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.operatorid = o.operator AND ra.viewfact = 'Y' ) OR ");
		sb.append(" r.supregid IN (SELECT ra.supregionid FROM regionsaccess ra WHERE ra.accesstype = 'S' AND ra.operatorid = o.operator AND ra.viewfact = 'Y')) ");
		if(username != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(username);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
		if(useRegions != null && useRegions.booleanValue()) {
			appendIN(sb,"AND nz.regionid ",regions);
		} else if(useSuperregions != null && useSuperregions.booleanValue()) {
			appendIN(sb,"AND r.supregid ",superregions);
		}
	}
/*
System.out.println("SR["+useSuperregions+"|");
if(superregions != null) {
	for(int i = 0; i < superregions.length; i++) {
		System.out.println(String.valueOf(superregions[i])+",");
	}
}
System.out.println("]");
System.out.println("RG["+useRegions+"|");
if(regions != null) {
	for(int i = 0; i < regions.length; i++) {
		System.out.println(String.valueOf(regions[i])+",");
	}
}
System.out.println("]");
System.out.println("USER:"+username+", ADMIN"+isAdmin);
System.out.println("SQL:\n"+sb.toString()+"\n");
*/
//System.out.println("SQL:\n"+sb.toString());
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * ¬озвращает список всех типов аппаратной
 */
public CDBCResultSet findNetzonesByRegions(
	Boolean useSuperregions, Integer[] superregions, 
	Boolean useRegions, Integer[] regions,
	String searchBy, String searchVal,
	String username, Boolean isAdmin,
	Integer order
)
	throws java.lang.Exception
{
	CDBCResultSet res = new CDBCResultSet();
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();
	if(isAdmin != null && isAdmin.booleanValue()) {
		sb.append("SELECT nz.netzone, nz.regionid, nz.name, nz.zonecode, r.regname, sr.supregname ");
		sb.append("FROM netzones nz, regions r, superregions sr ");
		sb.append("WHERE nz.regionid = r.regionid AND r.supregid = sr.supregid ");
		if(useRegions != null && useRegions.booleanValue()) {
			appendIN(sb,"AND nz.regionid ",regions);
		} else if(useSuperregions != null && useSuperregions.booleanValue()) {
			appendIN(sb,"AND r.supregid ",superregions);
		}
		if(searchBy != null && "name".equals(searchBy)) {
			if(searchVal != null) {
				sb.append("AND UPPER(nz.name) MATCHES UPPER(?) ");
				params.add(searchVal);
			} else {
				sb.append("AND nz.name IS NULL ");
			}
		}
	} else {
		sb.append("SELECT nz.netzone, nz.regionid, r.supregid, nz.name, nz.zonecode, r.regname, sr.supregname ");
		sb.append("FROM netzones nz, regions r, superregions sr, operators o ");
		sb.append("WHERE nz.regionid = r.regionid AND r.supregid = sr.supregid AND ");
		sb.append("(r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.operatorid = o.operator AND ra.viewfact = 'Y' ) OR ");
		sb.append(" r.supregid IN (SELECT ra.supregionid FROM regionsaccess ra WHERE ra.accesstype = 'S' AND ra.operatorid = o.operator AND ra.viewfact = 'Y')) ");
		if(username != null) {
			sb.append("AND o.loiginid = ? ");
			params.add(username);
		} else {
			sb.append("AND o.loiginid IS NULL ");
		}
		if(useRegions != null && useRegions.booleanValue()) {
			appendIN(sb,"AND nz.regionid ",regions);
		} else if(useSuperregions != null && useSuperregions.booleanValue()) {
			appendIN(sb,"AND r.supregid ",superregions);
		}
		if(searchBy != null && "name".equals(searchBy)) {
			if(searchVal != null) {
				sb.append("AND UPPER(nz.name) MATCHES UPPER(?) ");
				params.add(searchVal);
			} else {
				sb.append("AND nz.name IS NULL ");
			}
		}
	}
	if(order != null) {
		switch(order.intValue()) {
		case 1:
			sb.append("ORDER BY nz.name ASC ");
			break;
		case 2:
			sb.append("ORDER BY nz.name DESC ");
			break;
		}
	}
System.out.println("SQL:\n"+sb.toString());
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * ¬озвращает список всех регионов доступных оператору на просмотр (ViewFact = TRUE)
 */
public CDBCResultSet findRegionList(
    String searchBy,
    String name,
    Boolean isAllSupregs,
    Integer supregid,
    Integer order
    )
//findRegions(Boolean useSuperregions, Integer[] superregions, String username, boolean admin)
{
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();

	sb.append("SELECT r.regionid regionid, r.regname regname, r.supregid supregid, sr.supregname supregname ");
	sb.append("FROM regions r, superregions sr ");
	sb.append("WHERE r.supregid = sr.supregid ");

	if (searchBy.equals("name")) {
		if(name != null) {
			sb.append("AND UPPER(r.regname) MATCHES UPPER(?)");
			params.add(name);
		} else {
			sb.append("AND r.regname IS NULL ");
		}
			
    }
	if (!isAllSupregs.booleanValue()) {
		if(supregid != null) {
			sb.append("AND r.supregid = ? ");
			params.add(supregid);
		} else {
			sb.append("AND r.supregid IS NULL ");
		}
	}
	if(order != null) {
		switch(order.intValue()) {
		case 1:
			sb.append("ORDER BY regionid ASC ");
			break;
		case 2:
			sb.append("ORDER BY regionid DESC ");
			break;
		case 3:
			sb.append("ORDER BY supregname ASC, regname ASC ");
			break;
		case 4:
			sb.append("ORDER BY supregname DESC, regname DESC ");
			break;
		case 5:
			sb.append("ORDER BY regname ASC ");
			break;
		case 6:
			sb.append("ORDER BY regname DESC ");
			break;
		}
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * ¬озвращает список всех регионов доступных оператору на просмотр (ViewFact = TRUE)
 */
public CDBCResultSet findRegions(Boolean useSuperregions, Integer[] superregions, String username, boolean admin)
	throws java.lang.Exception
{
	return findViewEditRegions(useSuperregions, superregions, username, admin, false);
}
/**
 * ¬озвращает список всех регионов доступных оператору на просмотр (ViewFact = TRUE)
 */
public CDBCResultSet findRegionsLookup(Boolean useSuperregions, Integer superregion, String username, Boolean admin)
	throws java.lang.Exception
{
// SELECT r.regionid, r.regname, r.supregid, sr.supregname
// FROM regions r, superregions sr
// WHERE r.supregid = sr.supregid AND r.supregid = 1
// ORDER BY r.regname ASC, sr.supregname ASC

	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();
	
	if(admin != null && admin.booleanValue()) {
		sb.append("SELECT r.regionid, r.supregid, r.regname, sr.supregname FROM regions r, superregions sr WHERE r.supregid = sr.supregid ");
		if(useSuperregions != null && useSuperregions.booleanValue()) {
			if(superregion != null) {
				sb.append("AND r.supregid = ? ");
				params.add(superregion);
			}
		}
	} else {
		sb.append("SELECT r.regionid, r.supregid, r.regname, sr.supregname FROM regions r, superregions sr, operators o WHERE ");
		sb.append("r.supregid = sr.supregid AND ((r.regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.operatorid = o.operator AND ");
		sb.append("ra.editfact = 'Y' ");
		sb.append(") ");
		sb.append("OR r.supregid IN (SELECT ra.supregionid FROM regionsaccess ra WHERE ra.accesstype = 'S' AND ra.operatorid = o.operator AND ");
		sb.append("ra.editfact = 'Y' ");
		sb.append(")) ");
		sb.append("AND o.loiginid = ?) ");
		if(username == null) {
			params.add("");
		} else {
			params.add(username);
		}
		if(useSuperregions != null && useSuperregions.booleanValue()) {
			if(superregion != null) {
				sb.append("AND r.supregid = ? ");
				params.add(superregion);
			}
		}
	}
	sb.append("ORDER BY r.regname ASC, sr.supregname ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * ¬озвращает список всех суперрегионов
 */
public CDBCResultSet findSuperregions(String username, boolean admin)
	throws java.lang.Exception
{
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();
	
	if(!admin) {
		sb.append("SELECT DISTINCT r.supregid, sr.supregname ");
		sb.append("FROM regions r, superregions sr, regionsaccess ra, operators o ");
		sb.append("WHERE ra.operatorid=o.operator ");
		sb.append("AND sr.supregid=r.supregid ");
		sb.append("AND (r.supregid=ra.supregionid OR r.regionid=ra.regionid) ");
		sb.append("AND o.loiginid = ? ");
		sb.append("AND (ra.viewfact = 'Y' OR ra.editfact= 'Y') ");
		sb.append("ORDER BY sr.supregname ");

		if(username == null) {
			params.add("");
		} else {
			params.add(username);
		}
	} else {
		sb.append("SELECT sr.supregid, sr.supregname FROM superregions sr ");
		sb.append("ORDER BY sr.supregname ");
	}
//System.out.println("SQL:\n"+sb.toString());
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * ¬озвращает список всех суперрегионов
 */
public CDBCResultSet findSuperregionsList(Integer order)
	throws java.lang.Exception
{
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT sr.supregid, sr.supregname, sr.supregcode FROM superregions sr ");
	if(order != null) {
		switch(order.intValue()) {
		case 1:
			sb.append("ORDER BY sr.supregid ASC ");
			break;
		case 2:
			sb.append("ORDER BY sr.supregid DESC ");
			break;
		case 3:
			sb.append("ORDER BY sr.supregname ASC ");
			break;
		case 4:
			sb.append("ORDER BY sr.supregname DESC ");
			break;
		case 5:
			sb.append("ORDER BY sr.supregcode ASC ");
			break;
		case 6:
			sb.append("ORDER BY sr.supregcode DESC ");
			break;
		}
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), new Object[] {} );
	return res;
}
/**
 * ¬озвращает список всех регионов доступных оператору на просмотр (ViewFact = TRUE) или изменение (EditFact = TRUE)
 */
public CDBCResultSet findViewEditRegions(Boolean useSuperregions, Integer[] superregions, String username, boolean admin, boolean canEdit)
	throws java.lang.Exception
{
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();
	
	if(!admin) {
		sb.append("SELECT r.regionid, r.supregid, r.regname, r.hasmap, r.fullarendainfo FROM regions r, operators o WHERE ");
		sb.append("(regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.operatorid = o.operator AND ");
		if (canEdit)
			sb.append("ra.editfact = 'Y' ");
		else
			sb.append("ra.viewfact = 'Y' ");
		sb.append(") ");
		sb.append("OR supregid IN (SELECT ra.supregionid FROM regionsaccess ra WHERE ra.accesstype = 'S' AND ra.operatorid = o.operator AND ");
		if (canEdit)
			sb.append("ra.editfact = 'Y' ");
		else
			sb.append("ra.viewfact = 'Y' ");
		sb.append(")) ");
		sb.append("AND o.loiginid = ? ");
		if(username == null) {
			params.add("");
		} else {
			params.add(username);
		}
		if(useSuperregions != null && useSuperregions.booleanValue()) {
			appendIN(sb,"AND r.supregid ",superregions);
		}
	} else {
		sb.append("SELECT r.regionid, r.supregid, r.regname, r.hasmap, r.fullarendainfo FROM regions r ");
		if(useSuperregions != null && useSuperregions.booleanValue()) {
			appendIN(sb,"WHERE r.supregid ",superregions);
		}
	}
	sb.append("ORDER BY r.regname ASC ");
//System.out.println("SQL:\n"+sb.toString());
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(), params.toArray());
	return res;
}
/**
 * ¬озвращает доступные коды суперрегиона, региона и зоны сети по умолчанию
 * [0] - суперрегион
 * [1] - регион
 * [2] - зона сети
 */
public int[] getDefaults(String username, boolean admin, boolean canEdit)
	throws java.lang.Exception
{
	int[] result = new int[] { -1, -1, -1 };
	StringBuffer sb = new StringBuffer();
	ArrayList params = new ArrayList();
	
	if(!admin) {
		sb.append("SELECT r.regionid, r.supregid FROM regions r, operators o WHERE ");
		sb.append("(regionid IN (SELECT ra.regionid FROM regionsaccess ra WHERE ra.accesstype = 'R' AND ra.operatorid = o.operator AND ");
		if (canEdit)
			sb.append("ra.editfact = 'Y' ");
		else
			sb.append("ra.viewfact = 'Y' ");
		sb.append(") ");
		sb.append("OR supregid IN (SELECT ra.supregionid FROM regionsaccess ra WHERE ra.accesstype = 'S' AND ra.operatorid = o.operator AND ");
		if (canEdit)
			sb.append("ra.editfact = 'Y' ");
		else
			sb.append("ra.viewfact = 'Y' ");
		sb.append(")) ");
		sb.append("AND o.loiginid = ? ");
		
		if(username == null) {
			params.add("");
		} else {
			params.add(username);
		}
	} else {
		sb.append("SELECT r.regionid, r.supregid, r.regname FROM regions r ");
	}
	sb.append("ORDER BY r.regname ASC ");

	CDBCResultSet rs = new CDBCResultSet();
	rs.executeQuery(sb.toString(), params.toArray());
	Iterator it = rs.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Object o = ro.getColumn("supregid").asObject();
		if(o != null && o instanceof Number) {
			result[0] = ((Integer)o).intValue();
		}
		o = ro.getColumn("regionid").asObject();
		if(o != null && o instanceof Number) {
			result[1] = ((Integer)o).intValue();
		}
	}

	sb = new StringBuffer();
	params = new ArrayList();
	sb.append("SELECT nz.netzone FROM netzones nz WHERE nz.regionid = ? ORDER BY nz.netzone ASC ");
	params.add(new Integer(result[1]));
	rs = new CDBCResultSet();
	rs.executeQuery(sb.toString(),params.toArray());
	it = rs.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Object o = ro.getColumn("netzone").asObject();
		if(o != null && o instanceof Number) {
			result[2] = ((Integer)o).intValue();
		}
	}

	return result;
}
}
