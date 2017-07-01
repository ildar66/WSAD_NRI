/*
 * Created on 23.01.2006
 *
 * Справочник регионов (филиалов)VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * Справочник регионов (филиалов)VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Region_VO {
	private Integer regionID;//Идентификатор региона
	private Integer supRegID;//ссылка на суперрегион
	private String regName;//Наименование региона
	//private BigDeccimal sectorprefix Префикс номера сектора
	//private String hasmap Признак наличия карты
	//private fullarendainfo String Признак ведения полной информации по аренде
	//private needapprove String Признак согласования актов монтажа
	//private modified Дата и время последней модификации
	//private created Дата и время создания

	/**
	 * 
	 */
	public Region_VO(Integer aRegionId, Integer aSupRegId, String aRegName) {
		super();
		regionID = aRegionId;
		supRegID = aSupRegId;
		regName = aRegName;
	}

	/**
	 * @return
	 */
	public Integer getRegionID() {
		return regionID;
	}

	/**
	 * @return
	 */
	public String getRegName() {
		return regName;
	}

	/**
	 * @return
	 */
	public Integer getSupRegID() {
		return supRegID;
	}

	/**
	 * @param integer
	 */
	public void setRegionID(Integer integer) {
		regionID = integer;
	}

	/**
	 * @param string
	 */
	public void setRegName(String string) {
		regName = string;
	}

	/**
	 * @param integer
	 */
	public void setSupRegID(Integer integer) {
		supRegID = integer;
	}

}
