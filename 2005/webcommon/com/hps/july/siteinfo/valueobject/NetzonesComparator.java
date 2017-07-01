package com.hps.july.siteinfo.valueobject;

/**
 * Компаратор Зон сети.
 * Используется классом Regions для сортировки списка зон сети
 * При создании класса ему передаётся массив выбранных элементов которые будут отсортированы
 * с большим приоритетом.
 */
public class NetzonesComparator
	implements java.util.Comparator
{
	private Integer[] sel;
public NetzonesComparator(Integer[] s) {
	super();
	sel = s;
}
public int compare(Object o1, Object o2) {
	boolean o1selected = false;
	boolean o2selected = false;

	// check selected
	NetzoneVO so1 = (NetzoneVO)o1;
	NetzoneVO so2 = (NetzoneVO)o2;

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
