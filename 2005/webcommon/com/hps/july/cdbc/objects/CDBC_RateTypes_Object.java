/*
 * Created on 29.07.2006
 *
 * Тип курса валют
 */
package com.hps.july.cdbc.objects;

import java.util.*;

import com.hps.july.dictionary.valueobject.RateType_VO;
import com.hps.july.persistence.RateTypeAccessBean;

/**
 * @author IShaffigulin
 *
 * Тип курса валют
 */
public class CDBC_RateTypes_Object {
	private static ArrayList listRateTypes = null;
	/**
	 * Insert the method's description here.
	 * Creation date: (05.04.2005 14:11:53)
	 */
	private final static void initListRateTypes() {
		try {
			listRateTypes = new ArrayList();
			RateTypeAccessBean bean = new RateTypeAccessBean();
			Enumeration enum = bean.findAllOrderByNameAsc();
			while (enum.hasMoreElements()) {
				RateTypeAccessBean ab = (RateTypeAccessBean) enum.nextElement();
				RateType_VO vo = new RateType_VO(new Integer(ab.getRatetype()));
				vo.setName(ab.getName());
				listRateTypes.add(vo);
			}
		} catch (Exception e) {
			System.out.println("CDBC_RateTypes_Object.initRateTypes(): Ошибка формирования листа курсов!!!");
			e.printStackTrace(System.out);
		}
	}
	/**
	 * @return
	 */
	public final static ArrayList getListRateTypes() {
		if (listRateTypes == null) {
			initListRateTypes();
		}
		return new ArrayList(listRateTypes);
	}

}
