package com.hps.july.siteinfo.valueobject;

/**
 * Компаратор регионов
 * Используется классом Regions для сортировки списка регионов
 * При создании класса ему передаётся массив выбранных элементов которые будут отсортированы
 * с большим приоритетом.
 */
public class RegionsComparator
	implements java.util.Comparator
{
	private Integer[] sel;
public RegionsComparator(Integer[] s) {
	super();
	sel = s;
}
public int compare(Object o1, Object o2) {
	boolean o1selected = false;
	boolean o2selected = false;

	// check selected
	RegionVO so1 = (RegionVO)o1;
	RegionVO so2 = (RegionVO)o2;

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
