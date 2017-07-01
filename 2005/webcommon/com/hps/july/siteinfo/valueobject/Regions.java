package com.hps.july.siteinfo.valueobject;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBCRegionsObject;
import com.hps.july.persistence.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.util.*;

/**
 * Служебный класс обрабатывающий списки регионов, суперрегионов и зон сети.
 * Содержит методы загружающее списки из базы данных в request
 * для последующего использования их в JSP
 */
public class Regions {
	public static final String SUPERREGIONS_LIST = "com.hps.july.regions.SUPERREGIONS";
	public static final String REGIONS_LIST = "com.hps.july.regions.REGIONS";
	public static final String NETZONES_LIST = "com.hps.july.regions.NETZONES";

	public static final String REGIONS_JS_DATA = "com.hps.july.regions.REGIONS_JS_DATA";
	public static final String NETZONES_JS_DATA = "com.hps.july.regions.NETZONES_JS_DATA";
protected ArrayList directFormRegionsList(RegionsSelector s, String username, boolean admin)
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findRegions(new Boolean(!s.isAllSuperregions()),s.getSuperregioncodes(),username,admin);
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			RegionVO rob = new RegionVO(getInt(ro.getColumn("regionid")), getInt(ro.getColumn("supregid")), ro.getColumn("regname").asString());
			r.add(rob);
		}
	} catch (Exception e) {
		log(e);
	}
	Collections.sort(r,new RegionsComparator(s.getRegioncodes()));
	return r;
}
protected ArrayList directNetzonesList()
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findNetzones();
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			NetzoneVO nvo = new NetzoneVO(getInt(ro.getColumn("netzone")), ro.getColumn("name").asString());
			r.add(nvo);
		}
	} catch (Exception e) {
		log(e);
	}
	return r;
}
protected ArrayList directNetzonesList(Integer[] sel)
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findNetzones();
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			NetzoneVO nvo = new NetzoneVO(getInt(ro.getColumn("netzone")),getInt(ro.getColumn("regionid")), ro.getColumn("name").asString());
			r.add(nvo);
		}
	} catch (Exception e) {
		log(e);
	}
	Collections.sort(r,new NetzonesComparator(sel));
	return r;
}
protected ArrayList directRegionsList(String username, boolean admin)
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findAllRegions(username,admin);
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			RegionVO rob = new RegionVO(getInt(ro.getColumn("regionid")), getInt(ro.getColumn("supregid")), ro.getColumn("regname").asString());
			r.add(rob);
		}
	} catch (Exception e) {
		log(e);
	}
	return r;
}
protected ArrayList directSuperregionsList(Integer[] sel, String username, boolean admin)
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findSuperregions(username,admin);
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			SuperregionVO rob = new SuperregionVO(getInt(ro.getColumn("supregid")), ro.getColumn("supregname").asString());
			r.add(rob);
		}
	} catch (Exception e) {
		log(e);
	}
	Collections.sort(r,new SuperregionsComparator(sel));
	return r;
}
protected ArrayList directSuperregionsList(String username, boolean admin)
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findSuperregions(username,admin);
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			SuperregionVO rob = new SuperregionVO(getInt(ro.getColumn("supregid")), ro.getColumn("supregname").asString());
			r.add(rob);
		}
	} catch (Exception e) {
		log(e);
	}
	return r;
}
private static Integer[] getArr(String s) {
	if(s != null) {
		ArrayList al = new ArrayList();
		StringTokenizer st = new StringTokenizer(s,",.-");
		while(st.hasMoreTokens()) {
			al.add(st.nextToken());
		}
		Integer r[] = new Integer[al.size()];
		try {
			for(int i = 0; i < al.size(); i++) {
				r[i] = new Integer(Integer.parseInt((String)al.get(i)));
			}
		} catch(Exception e) {
			r = (new Integer[] {});
		}
		return r;
	} else {
		return (new Integer[] {});
	}
}
private static int getInt(CDBCColumnObject col) {
	if(col.asObject() != null) {
		if(col.asObject() instanceof Number) {
			return ((Number)col.asObject()).intValue();
		} else {
			throw new ClassCastException("Column class:"+col.asObject().getClass().getName());
		}
	} else {
		return 0;
	}
}
private Iterator getNetzones(Integer[] sel)
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findNetzones();
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			NetzoneVO nvo = new NetzoneVO(getInt(ro.getColumn("netzone")), ro.getColumn("name").asString());
			r.add(nvo);
		}
		Collections.sort(r,new NetzonesComparator(sel));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return r.iterator();
}
public static Iterator getNetzones(String username, boolean admin, RegionsSelector rsl)
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findNetzonesByRegions(new Boolean(!rsl.isAllSuperregions()),rsl.getSuperregioncodes(),new Boolean(!rsl.isAllRegions()),rsl.getRegioncodes(),username,new Boolean(admin));
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			NetzoneVO nvo = new NetzoneVO(getInt(ro.getColumn("netzone")), ro.getColumn("name").asString());
			r.add(nvo);
		}
//		System.out.println("Netzones:"+r.size());
		Collections.sort(r,new NetzonesComparator(rsl.getNetzonecodes()));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return r.iterator();
}

protected String escapeJSQuotes(String astring) {
	return astring.replace('"', '\'');
}

protected String getNetZonesJSData(ArrayList netzones, Integer[] selectedNetZones)
{
	try {
		Iterator it = netzones.iterator();

		StringBuffer body = new StringBuffer();
		body.append("var nzs = new Array(\r\n");
		while (it.hasNext()) {
			try {
				NetzoneVO nz = (NetzoneVO)it.next();
				body.append("new Array(");
				body.append(nz.getNetzone());
				body.append(", ");
				body.append(nz.getRegionid());
				body.append(", \"");
				body.append(escapeJSQuotes(nz.getName()));
				if(it.hasNext()) {
					body.append("\"), \r\n");
				} else {
					body.append("\") \r\n");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		body.append("); \r\n");

		// Append selectedRegions text
		body.append("var selectedNetzones = new Array();\r\n");
		if(selectedNetZones != null) {
			for(int i = 0; i < selectedNetZones.length; i++) {
				body.append("selectedNetZones[");
				body.append(i);
				body.append("] = ");
				body.append(selectedNetZones[i]);
				body.append(";\r\n");
			}
		}
		return body.toString();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return "";
}
public static String getOptionsList(String type, RegionsSelector rs, String username, boolean admin)
{
	if(rs == null) {
		return "";
	}

	Integer[] srcodes = rs.getSuperregioncodes();
	Integer[] rgcodes = rs.getRegioncodes();
	Integer[] nzcodes = rs.getNetzonecodes();
/*
	if(srcodes == null && rgcodes == null && nzcodes == null) {
		CDBCRegionsObject ro = new CDBCRegionsObject();
		try {
			int[] r = ro.getDefaults(username,admin,false);
			srcodes = new Integer[] { new Integer(r[0]) };
			rs.setSuperregioncodes(srcodes);
			rgcodes = new Integer[] { new Integer(r[1]) };
			rs.setRegioncodes(rgcodes);
			nzcodes = new Integer[] { new Integer(r[2]) };
			rs.setNetzonecodes(nzcodes);
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
*/
	String options = "";
	String firstoption = "";

	boolean first = true;
	boolean hasselected = false;
	if("S".equals(type)) {
		Iterator it = getSuperRegions(username,admin,srcodes);
		while(it.hasNext()) {
			SuperregionVO ro = (SuperregionVO)it.next();
			String selected = "";
			if(rs.isAllSuperregions()) {
				selected = "selected"; hasselected = true;
			} else
			if(isMatched(srcodes,ro.getSupregid())) {
				selected = "selected"; hasselected = true;
			}
			if(first) {
				firstoption = selected+" value=\""+ro.getSupregid()+"\">"+ResponseUtils.filter(ro.getSupregname())+"</option>";
			} else {
				options += "<option "+selected+" value=\""+ro.getSupregid()+"\">"+ResponseUtils.filter(ro.getSupregname())+"</option>";
			}
			first = false;
		}	
	} else if("R".equals(type)) {
		Iterator it = getRegions(username,admin,rgcodes,rs.isAllSuperregions(),srcodes);
		while(it.hasNext()) {
			RegionVO ro = (RegionVO)it.next();
			String selected = "";
			if(rs.isAllRegions()) {
				selected = "selected"; hasselected = true;
			} else 
			if(isMatched(rgcodes,ro.getRegionid())) {
				selected = "selected"; hasselected = true;
			}
			if(first) {
				firstoption = selected+" value=\""+ro.getRegionid()+"\">"+ResponseUtils.filter(ro.getRegname())+"</option>";
			} else {
				options += "<option "+selected+" value=\""+ro.getRegionid()+"\">"+ResponseUtils.filter(ro.getRegname())+"</option>";
			}
			first = false;
		}
	} else if("N".equals(type)) {
		Iterator it = getNetzones(username,admin,rs);
		while(it.hasNext()) {
			NetzoneVO ro = (NetzoneVO)it.next();
			String selected = "";
			if(rs.isAllNetzones()) {
				selected = "selected"; hasselected = true;
			} else 
			if(isMatched(nzcodes,ro.getNetzone())) {
				selected = "selected"; hasselected = true;
			}
			if(first) {
				firstoption = selected+" value=\""+ro.getNetzone()+"\">"+ResponseUtils.filter(ro.getName())+"</option>";
			} else {
				options += "<option "+selected+" value=\""+ro.getNetzone()+"\">"+ResponseUtils.filter(ro.getName())+"</option>";
			}
			first = false;
		}
	}
	options = firstoption + options;
	if(options == null || "".equals(options.trim())) {
		options = "<option value=\"\"></option>";
	} else {
		if(hasselected) {
			options = "<option "+options;
		} else {
			options = "<option selected "+options;
		}
	}
	return options;
}
public static String getOptionsList(String type, Integer sr, Integer rg, Integer nz, String username, boolean admin)
{
	RegionsSelector rs = new RegionsSelector();
	rs.setAllSuperregions(false);
	rs.setAllRegions(false);
	rs.setAllNetzones(false);

	rs.setSuperregioncodes(null);
	if(sr != null) {
		rs.setSuperregioncodes(new Integer[] {sr});
	}
	rs.setRegioncodes(null);
	if(rg != null) {
		rs.setRegioncodes(new Integer[] {rg});
	}
	rs.setNetzonecodes(null);
	if(nz != null) {
		rs.setNetzonecodes(new Integer[] {nz});
	}
	return getOptionsList(type,rs,username,admin);
}
public static String getOptionsList(String type, String sr, String rg, String nz, String username, boolean admin)
{
	RegionsSelector rs = new RegionsSelector();
	rs.setAllSuperregions(sr != null && "*".equals(sr));
	rs.setAllRegions(rg != null && "*".equals(rg));
	rs.setAllNetzones(nz != null && "*".equals(nz));
	rs.setSuperregioncodes(getArr(sr));
	rs.setRegioncodes(getArr(rg));
	rs.setNetzonecodes(getArr(nz));

	return getOptionsList(type,rs,username,admin);
}
public static Iterator getRegions(String username, boolean admin, Integer[] sel, boolean isAllParanet, Integer[] par)
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findRegions(new Boolean(!isAllParanet),par,username,admin);
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			RegionVO rob = new RegionVO(getInt(ro.getColumn("regionid")), getInt(ro.getColumn("supregid")), ro.getColumn("regname").asString());
			r.add(rob);
		}
//		System.out.println("Regions:"+r.size());
		Collections.sort(r,new RegionsComparator(sel));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return r.iterator();
}
protected String getRegionsJSData(ArrayList regions, Integer[] selectedRegions)
{
	try {
		Iterator it = regions.iterator();

		StringBuffer body = new StringBuffer();
		body.append("var regs = new Array(\r\n");
		while (it.hasNext()) {
			try {
				RegionVO reg = (RegionVO)it.next();
				body.append("new Array(");
				body.append(reg.getRegionid());
				body.append(", ");
				body.append(reg.getSupregid());
				body.append(", \"");
				body.append(escapeJSQuotes(reg.getRegname()));
				if(it.hasNext()) {
					body.append("\"), \r\n");
				} else {
					body.append("\") \r\n");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		body.append("); \r\n");

		// Append selectedRegions text
		body.append("var selectedRegions = new Array();\r\n");
		if(selectedRegions != null) {
			for(int i = 0; i < selectedRegions.length; i++) {
				body.append("selectedRegions[");
				body.append(i);
				body.append("] = ");
				body.append(selectedRegions[i]);
				body.append(";\r\n");
			}
		}
		return body.toString();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return "";
}
public static Iterator getSuperRegions(String username, boolean admin, Integer[] sel)
{
	ArrayList r = new ArrayList();
	try {
		CDBCResultSet rs = (new CDBCRegionsObject()).findSuperregions(username,admin);
		ListIterator li = rs.listIterator();
		while(li.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)li.next();
			SuperregionVO rob = new SuperregionVO(getInt(ro.getColumn("supregid")), ro.getColumn("supregname").asString());
			r.add(rob);
		}
//		System.out.println("Superregions:"+r.size());
		Collections.sort(r,new SuperregionsComparator(sel));
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return r.iterator();
}
private static boolean isMatched(Integer[] arr, int val) {
	if(arr == null) return false;
        for (int i = 0; i < arr.length; i++) {
		if(arr[i] != null && arr[i].intValue() == val) return true;
	}
	return false;
}
protected static void log(Exception e)
{
	e.printStackTrace(System.out);
}
protected static void log(String s)
{
	System.out.println("REGIONS_MODEL:"+s);
}
public static void updateRegionsList(HttpServletRequest request, RegionsSelector s)
{
	boolean admin = request.isUserInRole("administrator");
	Regions reg = new Regions();
	ArrayList sr = reg.directSuperregionsList(s.getSuperregioncodes(),request.getRemoteUser(),admin);
	request.setAttribute(SUPERREGIONS_LIST,sr);
	ArrayList r = reg.directRegionsList(request.getRemoteUser(),admin);
	request.setAttribute(REGIONS_JS_DATA,reg.getRegionsJSData(r,s.getRegioncodes()));
	ArrayList rf = reg.directFormRegionsList(s,request.getRemoteUser(),admin);
	request.setAttribute(REGIONS_LIST,rf);
	ArrayList nz = reg.directNetzonesList(s.getNetzonecodes());
	request.setAttribute(NETZONES_LIST,nz);
	request.setAttribute(NETZONES_JS_DATA,reg.getNetZonesJSData(nz,s.getNetzonecodes()));
}
}
