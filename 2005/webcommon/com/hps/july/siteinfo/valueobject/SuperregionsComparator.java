package com.hps.july.siteinfo.valueobject;

/**
 * Компаратор суперрегионов
 * Используется классом Regions для сортировки списка суперрегионов
 * При создании класса ему передаётся массив выбранных элементов которые будут отсортированы
 * с большим приоритетом.
 */
public class SuperregionsComparator
	implements java.util.Comparator
{
	private Integer[] sel;
public SuperregionsComparator(Integer[] s) {
	super();
	sel = s;
}
public int compare(Object o1, Object o2) {
	boolean o1selected = false;
	boolean o2selected = false;

	// check selected
	SuperregionVO so1 = (SuperregionVO)o1;
	SuperregionVO so2 = (SuperregionVO)o2;

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
