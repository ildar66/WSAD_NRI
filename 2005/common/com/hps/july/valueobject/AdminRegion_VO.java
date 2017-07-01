package com.hps.july.valueobject;

/**
 * Административное деление субъектов федерации VO.
 * Creation date: (18.08.2005 11:43:08)
 * @author: Shafigullin Ildar
 */
public class AdminRegion_VO {
	private Integer regionid;//ID региона
	private Integer kzlregionid;//ссылка на kzlregions
	private String regionname;//Наименование региона
	private String regioncomment;//Комментарий к региону
	private Integer regiontype;//Тип региона
	private Integer regionpopulation;//Население региона
	private Integer ruralpopulation;//Сельское население
	private java.math.BigDecimal regionarea;//Площадь региона
	private java.math.BigDecimal regionlon;//Долгота
	private java.math.BigDecimal regionlat;//Широта
	private String regionkind;//Тип населенного пункта
	private Integer filialnri;//Филиал NRI
	private Integer parent_regionid;//ID родительского региона
	//privagte String RecordStatus://Признак активности записи
	private String kladrCode;//Код KLADR
/**
 * KzlRegions_VO constructor comment.
 */
public AdminRegion_VO(Integer regionID) {
    super();
    regionid = regionID;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:59)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRegionarea() {
	return regionarea;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:34)
 * @return java.lang.String
 */
public java.lang.String getRegioncomment() {
	return regioncomment;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:01)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionid() {
	return regionid;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:18)
 * @return java.lang.String
 */
public java.lang.String getRegionname() {
	return regionname;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:11)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionpopulation() {
	return regionpopulation;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:54)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegiontype() {
	return regiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getRuralpopulation() {
	return ruralpopulation;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:59)
 * @param newRegionarea java.math.BigDecimal
 */
public void setRegionarea(java.math.BigDecimal newRegionarea) {
	regionarea = newRegionarea;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:34)
 * @param newRegioncomment java.lang.String
 */
public void setRegioncomment(java.lang.String newRegioncomment) {
	regioncomment = newRegioncomment;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:01)
 * @param newRegionid java.lang.Integer
 */
public void setRegionid(java.lang.Integer newRegionid) {
	regionid = newRegionid;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:18)
 * @param newRegionname java.lang.String
 */
public void setRegionname(java.lang.String newRegionname) {
	regionname = newRegionname;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:11)
 * @param newRegionpopulation java.lang.Integer
 */
public void setRegionpopulation(java.lang.Integer newRegionpopulation) {
	regionpopulation = newRegionpopulation;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:54)
 * @param newRegiontype java.lang.Integer
 */
public void setRegiontype(java.lang.Integer newRegiontype) {
	regiontype = newRegiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:36)
 * @param newRuralpopulation java.lang.Integer
 */
public void setRuralpopulation(java.lang.Integer newRuralpopulation) {
	ruralpopulation = newRuralpopulation;
}
	/**
	 * @return
	 */
	public Integer getFilialnri() {
		return filialnri;
	}

	/**
	 * @return
	 */
	public Integer getKzlregionid() {
		return kzlregionid;
	}

	/**
	 * @return
	 */
	public Integer getParent_regionid() {
		return parent_regionid;
	}

	/**
	 * @return
	 */
	public String getRegionkind() {
		return regionkind;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getRegionlat() {
		return regionlat;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getRegionlon() {
		return regionlon;
	}

	/**
	 * @param integer
	 */
	public void setFilialnri(Integer integer) {
		filialnri = integer;
	}

	/**
	 * @param integer
	 */
	public void setKzlregionid(Integer integer) {
		kzlregionid = integer;
	}

	/**
	 * @param integer
	 */
	public void setParent_regionid(Integer integer) {
		parent_regionid = integer;
	}

	/**
	 * @param string
	 */
	public void setRegionkind(String string) {
		regionkind = string;
	}

	/**
	 * @param decimal
	 */
	public void setRegionlat(java.math.BigDecimal decimal) {
		regionlat = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setRegionlon(java.math.BigDecimal decimal) {
		regionlon = decimal;
	}

	/**
	 * @return
	 */
	public String getKladrCode() {
		return kladrCode;
	}

	/**
	 * @param string
	 */
	public void setKladrCode(String aKladrCode) {
		if(aKladrCode != null && aKladrCode.trim().equals("")){
			kladrCode = null;
		}else{
			kladrCode = aKladrCode;
		}
	}

}
