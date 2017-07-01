package com.hps.july.basestation.valueobject;

import com.hps.july.persistence.*;
import java.util.*;

/**
 * Модель региона
 * @deprecated Заменена на com.hps.july.siteinfo.valueobject.Regions
 */ 
public class RegionsModel {
	public static final String REGIONS_ATTRIBUTE = "com.hps.july.REGIONS";
	
	private ArrayList superregions;
	private ArrayList regions;
	private ArrayList netzones;

	/**
	 * Реализация компаратора для сортировки списков суперрегионов
	 */
	public static class SuperregionsComparator implements Comparator
	{
		private Integer[] sel;

		public SuperregionsComparator(Integer[] s) {
			sel = s;
		}
		
		public int compare(Object o1, Object o2) {
			boolean o1selected = false;
			boolean o2selected = false;

			// check selected
			SuperregionObject so1 = (SuperregionObject)o1;
			SuperregionObject so2 = (SuperregionObject)o2;

			if(sel != null) {
				int so1id = so1.getSupregid();
				int so2id = so2.getSupregid();
				for(int i = 0; i < sel.length; i++) {
					if(sel[i] != null && sel[i].intValue() == so1id) {
						o1selected = true;
					}
					if(sel[i] != null && sel[i].intValue() == so2id) {
						o2selected = true;
					}
				}
			}
			
			if(o1selected && !o2selected) {
				return -1; // o1 greater than o2
			} 
			if(!o1selected && o2selected) {
				return 1; // o1 less than o2
			}
			if(so1.getSupregname() != null && so2.getSupregname() != null) {
				return so1.getSupregname().compareToIgnoreCase(so2.getSupregname());
			} else {
				return 0;
			}
		}
	}

	/**
	 * Реализация компаратора для сортировки списков регионов
	 */
	public static class RegionsComparator implements Comparator
	{
		private Integer[] sel;

		public RegionsComparator(Integer[] s) {
			sel = s;
		}
		
		public int compare(Object o1, Object o2) {
			boolean o1selected = false;
			boolean o2selected = false;

			// check selected
			RegionObject so1 = (RegionObject)o1;
			RegionObject so2 = (RegionObject)o2;

			if(sel != null) {
				int so1id = so1.getRegionid();
				int so2id = so2.getRegionid();
				for(int i = 0; i < sel.length; i++) {
					if(sel[i] != null && sel[i].intValue() == so1id) {
						o1selected = true;
					}
					if(sel[i] != null && sel[i].intValue() == so2id) {
						o2selected = true;
					}
				}
			}
			
			if(o1selected && !o2selected) {
				return -1; // o1 greater than o2
			} 
			if(!o1selected && o2selected) {
				return 1; // o1 less than o2
			}
			if(so1.getRegname() != null && so2.getRegname() != null) {
				return so1.getRegname().compareToIgnoreCase(so2.getRegname());
			} else {
				return 0;
			}
		}
	}

	/**
	 * Реализация компаратора для сортировки списков сетевых зон
	 */
	public static class NetzonesComparator implements Comparator
	{
		private Integer[] sel;

		public NetzonesComparator(Integer[] s) {
			sel = s;
		}
		
		public int compare(Object o1, Object o2) {
			boolean o1selected = false;
			boolean o2selected = false;

			// check selected
			NetzoneObject so1 = (NetzoneObject)o1;
			NetzoneObject so2 = (NetzoneObject)o2;

			if(sel != null) {
				int so1id = so1.getNetzone();
				int so2id = so2.getNetzone();
				for(int i = 0; i < sel.length; i++) {
					if(sel[i] != null && sel[i].intValue() == so1id) {
						o1selected = true;
					}
					if(sel[i] != null && sel[i].intValue() == so2id) {
						o2selected = true;
					}
				}
			}
			
			if(o1selected && !o2selected) {
				return -1; // o1 greater than o2
			} 
			if(!o1selected && o2selected) {
				return 1; // o1 less than o2
			}
			if(so1.getName() != null && so2.getName() != null) {
				return so1.getName().compareToIgnoreCase(so2.getName());
			} else {
				return 0;
			}
		}
	}
protected RegionsModel() {
	super();
	superregions = new ArrayList();
	regions = new ArrayList();
	netzones = new ArrayList();
	refresh();
}
public Integer[] checkNetzones(Integer[] selectedarr, boolean all)
{
	if(selectedarr != null) {
		if (selectedarr.length == 0) {
			selectedarr = new Integer[1];
			selectedarr[0] =
				new Integer(((NetzoneObject)netzones.get(0)).getNetzone());
		} 
		if (all) {
			selectedarr = new Integer[netzones.size()];
			for (int i=0; i < netzones.size(); i++) {
				selectedarr[i] = new Integer(((NetzoneObject)netzones.get(i)).getNetzone());
			}
		}
	}

	return selectedarr;
}
public Integer[] checkRegions(Integer[] selectedarr, boolean all)
{
	if(selectedarr != null) {
		if (selectedarr.length == 0) {
			selectedarr = new Integer[1];
			selectedarr[0] =
				new Integer(((RegionObject)regions.get(0)).getRegionid());
		}
		if (all) {
			selectedarr = new Integer[regions.size()];
			for (int i=0; i < regions.size(); i++) {
				selectedarr[i] = new Integer(((RegionObject)regions.get(i)).getRegionid());
			}
		}
	}

	return selectedarr;
}
public Integer[] checkSuperregions(Integer[] selectedarr, boolean all)
{
	if(selectedarr != null) {
		if (selectedarr.length == 0) {
			selectedarr = new Integer[1];
			selectedarr[0] =
				new Integer(((SuperregionObject)superregions.get(0)).getSupregid());
		}
		if(all) {
			selectedarr = new Integer[superregions.size()];
			for (int i=0; i < superregions.size(); i++) {
				selectedarr[i] = new Integer(((SuperregionObject)superregions.get(i)).getSupregid());
			}
		}
	}

	return selectedarr;
}
public static RegionsModel getModel(javax.servlet.ServletContext app) {
	Object model = app.getAttribute(REGIONS_ATTRIBUTE);
	if(model != null) {
		log("Model is not null");
		return (RegionsModel)model;
	} else {
		log("Model is null");
		RegionsModel m = new RegionsModel();
		app.setAttribute(REGIONS_ATTRIBUTE,m);
		return m;
	}
}
public ArrayList getNetzones(Integer[] sel) {
	ArrayList result = (ArrayList)netzones.clone();
	if(sel != null) {
		Collections.sort(result,new NetzonesComparator(sel));
	}
	return result;
}
public ArrayList getRegions(Integer[] sel) {
	ArrayList result = (ArrayList)regions.clone();
	if(sel != null) {
		Collections.sort(result,new RegionsComparator(sel));
	}
	return result;
}
public ArrayList getSuperregions(Integer[] sel) {
	ArrayList result = (ArrayList)superregions.clone();
	if(sel != null) {
		Collections.sort(result,new SuperregionsComparator(sel));
	}
	return result;
}
protected void initNetzones()
{
	try {
		netzones.clear();
		Enumeration en = new NetZoneAccessBean().findAllOrderByNameAsc();
		
		// Convert to ArrayList
		while (en.hasMoreElements()) {
			NetZoneAccessBean rab = (NetZoneAccessBean)en.nextElement();
			NetzoneObject rob = new NetzoneObject(rab.getNetzone(), rab.getName());
			netzones.add(rob);
		}
	} catch (Exception e) {
		log(e);
	}
}
protected void initRegions()
{
	try {
		regions.clear();
		Enumeration en = new RegionAccessBean().findByQBE(Boolean.FALSE, null, Boolean.FALSE, "", new Integer(1));
			
		// Convert to ArrayList
		while (en.hasMoreElements()) {
			RegionAccessBean rab = (RegionAccessBean)en.nextElement();
			RegionObject rob = new RegionObject(rab.getRegionid(),rab.getSuperregionKey().supregid, rab.getRegname());
			regions.add(rob);
		}
	} catch (Exception e) {
		log(e);
	}
}
protected void initSuperregions()
{
	try {
		superregions.clear();
		Enumeration en = new SuperRegionAccessBean().findAllOrderByCodeAsc();
			
		// Convert to ArrayList
		while (en.hasMoreElements()) {
			SuperRegionAccessBean rab = (SuperRegionAccessBean)en.nextElement();
			SuperregionObject rob = new SuperregionObject(rab.getSupregid(), rab.getSupregname());
			superregions.add(rob);
		}
	} catch (Exception e) {
		log(e);
	}
}
public static void log(Exception e)
{
	e.printStackTrace(System.out);
}
public static void log(String s)
{
	System.out.println("REGIONS_MODEL:"+s);
}
public void refresh() {
	initSuperregions();
	initRegions();
	initNetzones();
}
public static void removeModel(javax.servlet.ServletContext app) {
	app.removeAttribute(REGIONS_ATTRIBUTE);
}
}
