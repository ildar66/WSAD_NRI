/*
 * Created on 24.11.2006
 * Ключевой объект для прочего оборудования для быстрого извлечения
 * списков в таблицах
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * TRX value object
 * @author dima
 *
 */
public class EquipObjectKeyVO implements Serializable, Cloneable {
	
	private int idequipcategory;
	private Integer parentObject;
	
	public EquipObjectKeyVO() {
		super();
	}

	public EquipObjectKeyVO(int aidequipcategory, Integer aparentObject) {
		super();
		idequipcategory = aidequipcategory;
		parentObject = aparentObject;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		EquipObjectKeyVO other = (EquipObjectKeyVO)otherObject;
		
		if ( (parentObject == null) && (other.parentObject == null))
			return (idequipcategory == other.idequipcategory);
			
		if ( (parentObject != null) && (other.parentObject != null))
			return ( (idequipcategory == other.idequipcategory) && parentObject.equals(other.parentObject) ); 
		
		return false;
	}
	
	public int hashCode() {
		if (parentObject != null)
			return new Integer(idequipcategory).hashCode() + 11 * parentObject.hashCode();
		else
			return new Integer(idequipcategory).hashCode();
	}
	
	public int compareTo(Object other) {
		int result = 1;
		if (other != null) {
			result = new Integer(idequipcategory).compareTo(new Integer(((EquipObjectKeyVO)other).idequipcategory));
			if ( (parentObject != null) && (result == 0) ) {
				result = parentObject.compareTo(((EquipObjectKeyVO)other).parentObject);  
			}
		}
		return result;
	}
	
	public static ArrayList getEquipList(HashMap map, int category, Integer parentObject) {
		EquipObjectKeyVO key = new EquipObjectKeyVO(category, parentObject);
		ArrayList equipcateg = (ArrayList)map.get(key);
		if (equipcateg == null) {
			equipcateg = new ArrayList();
			map.put(key, equipcateg);
		}
		return equipcateg;
	}
	
	public static void deleteChilds(HashMap map, Integer parentObject) {
		if (parentObject != null) {
			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				EquipObjectKeyVO key = (EquipObjectKeyVO)it.next();
				if (parentObject.equals(key.getParentObject()))
					it.remove();
			}
		}
	}

	public static void deleteChildsMark(HashMap map, Integer parentObject) {
		if (parentObject != null) {
			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				EquipObjectKeyVO key = (EquipObjectKeyVO)it.next();
				if (parentObject.equals(key.getParentObject())) {
					ArrayList equips = (ArrayList)map.get(key);
					if (equips != null) {
						Iterator it2 = equips.iterator();
						while (it2.hasNext()) {
							EquipObjectVO vo = (EquipObjectVO)it2.next();
							vo.setPreviousRecordStatus(vo.getRecordStatus());
							vo.setRecordStatus("D");
						}
					}
				}
			}
		}
	}

	public static void restoreChildsMark(HashMap map, Integer parentObject) {
		if (parentObject != null) {
			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				EquipObjectKeyVO key = (EquipObjectKeyVO)it.next();
				if (parentObject.equals(key.getParentObject())) {
					ArrayList equips = (ArrayList)map.get(key);
					if (equips != null) {
						Iterator it2 = equips.iterator();
						while (it2.hasNext()) {
							EquipObjectVO vo = (EquipObjectVO)it2.next();
							vo.setRecordStatus(vo.getPreviousRecordStatus());
						}
					}
				}
			}
		}
	}

	/**
	 * @return
	 */
	public int getIdequipcategory() {
		return idequipcategory;
	}

	/**
	 * @return
	 */
	public Integer getParentObject() {
		return parentObject;
	}

	/**
	 * @param i
	 */
	public void setIdequipcategory(int i) {
		idequipcategory = i;
	}

	/**
	 * @param integer
	 */
	public void setParentObject(Integer integer) {
		parentObject = integer;
	}

}
