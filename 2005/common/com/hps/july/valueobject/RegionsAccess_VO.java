package com.hps.july.valueobject;

/**
 * Права доступа по регионам(филиалам).
 * Creation date: (21.11.2005 14:44:04)
 * @author: Shafigullin Ildar
 */
public class RegionsAccess_VO {
	private java.lang.Integer accessid;//Идентификатор записи доступа
	private java.lang.Integer operatorid;//Ссылка на оператора
	private java.lang.String accesstype;//Тип записи доступа("S" - регион,"R"-филиал)
	private java.lang.Integer supregionid;//Ссылка на суперрегион
	private java.lang.Integer regionid;//Ссылка на регион
	private java.lang.String viewplan;//Просмотр плана
	private java.lang.String viewfact;//Просмотр факта
	private java.lang.String editplan;//Редактир_ плана
	private java.lang.String editfact;//Редактир_ факта
	private java.lang.String viewarenda;//Просмотр для модуля "Аренды"
	private java.lang.String editarenda;//Редакция для модуля "Аренды"
	private java.lang.String hasArendaPurchaser;//Наличие Закупщика в филиале
/**
 * Insert the method's description here.
 * Creation date: (09.12.2005 17:42:27)
 */
public RegionsAccess_VO(java.lang.Integer accessID) {
    super();
    accessid = accessID;
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2005 17:52:32)
 */
public RegionsAccess_VO(
    java.lang.Integer iAccessid,
    java.lang.Integer iOperatorid,
    java.lang.String iAccesstype,
    java.lang.Integer iSupregionid,
    java.lang.Integer iRegionid,
    java.lang.String iViewplan,
    java.lang.String iViewfact,
    java.lang.String iEditplan,
    java.lang.String iEditfact,
    java.lang.String iViewarenda,
    java.lang.String iEditarenda) {
	    
    setAccessid(iAccessid);
    setOperatorid(iOperatorid);
    setAccesstype(iAccesstype);
    setSupregionid(iSupregionid);
    setRegionid(iRegionid);
    setViewplan(iViewplan);
    setViewfact(iViewfact);
    setEditplan(iEditplan);
    setEditfact(iEditfact);
    setViewarenda(iViewarenda);
    setEditarenda(iEditarenda);
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:47:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getAccessid() {
	return accessid;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:48:59)
 * @return java.lang.String
 */
public java.lang.String getAccesstype() {
	return accesstype;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2005 11:50:51)
 * @return java.lang.String
 */
public java.lang.String getEditarenda() {
	return editarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:55:23)
 * @return java.lang.String
 */
public java.lang.String getEditfact() {
	return editfact;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:54:59)
 * @return java.lang.String
 */
public java.lang.String getEditplan() {
	return editplan;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:48:32)
 * @return java.lang.Integer
 */
public java.lang.Integer getOperatorid() {
	return operatorid;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:52:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionid() {
	return regionid;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:51:16)
 * @return java.lang.Integer
 */
public java.lang.Integer getSupregionid() {
	return supregionid;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2005 11:50:34)
 * @return java.lang.String
 */
public java.lang.String getViewarenda() {
	return viewarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:54:44)
 * @return java.lang.String
 */
public java.lang.String getViewfact() {
	return viewfact;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:52:34)
 * @return java.lang.String
 */
public java.lang.String getViewplan() {
	return viewplan;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:47:59)
 * @param newAccessid java.lang.Integer
 */
public void setAccessid(java.lang.Integer newAccessid) {
	accessid = newAccessid;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:48:59)
 * @param newAccesstype java.lang.String
 */
public void setAccesstype(java.lang.String newAccesstype) {
	accesstype = newAccesstype;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2005 11:50:51)
 * @param newEditarenda java.lang.String
 */
public void setEditarenda(java.lang.String newEditarenda) {
	editarenda = newEditarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:55:23)
 * @param newEditfact java.lang.String
 */
public void setEditfact(java.lang.String newEditfact) {
	editfact = newEditfact;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:54:59)
 * @param newEditplan java.lang.String
 */
public void setEditplan(java.lang.String newEditplan) {
	editplan = newEditplan;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:48:32)
 * @param newOperatorid java.lang.Integer
 */
public void setOperatorid(java.lang.Integer newOperatorid) {
	operatorid = newOperatorid;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:52:08)
 * @param newRegionid java.lang.Integer
 */
public void setRegionid(java.lang.Integer newRegionid) {
	regionid = newRegionid;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:51:16)
 * @param newSupregionid java.lang.Integer
 */
public void setSupregionid(java.lang.Integer newSupregionid) {
	supregionid = newSupregionid;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2005 11:50:34)
 * @param newViewarenda java.lang.String
 */
public void setViewarenda(java.lang.String newViewarenda) {
	viewarenda = newViewarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:54:44)
 * @param newViewfact java.lang.String
 */
public void setViewfact(java.lang.String newViewfact) {
	viewfact = newViewfact;
}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 14:52:34)
 * @param newViewplan java.lang.String
 */
public void setViewplan(java.lang.String newViewplan) {
	viewplan = newViewplan;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2005 12:14:53)
 * @return java.lang.String
 */
public String toString() {
    return "accessid="        + accessid
        + ", operatorid="        + operatorid
        + ", accesstype="        + accesstype
        + ", supregionid="        + supregionid
        + ", regionid="        + regionid
        + ", viewplan="        + viewplan
        + ", viewfact="        + viewfact
        + ", editplan="        + editplan
        + ", editfact="        + editfact
        + ", viewarenda="        + viewarenda
        + ", editarenda="        + editarenda
        + ";\n";
}
	/**
	 * @return
	 */
	public java.lang.String getHasArendaPurchaser() {
		return hasArendaPurchaser;
	}

	/**
	 * @param string
	 */
	public void setHasArendaPurchaser(java.lang.String string) {
		hasArendaPurchaser = string;
	}

}
