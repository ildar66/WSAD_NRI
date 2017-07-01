package com.hps.july.siteinfo.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования региона
 */
public class RegionForm extends com.hps.july.web.util.EditForm {
	private int regionid; // Идентификатор региона
	private String regname=""; // Наименование региона
	private StringAndIntegerProperty superRegionCode=new StringAndIntegerProperty(); // Наименование суперрегиона
	private StringAndBigDecimalProperty sectorprefix=new StringAndBigDecimalProperty(); // Префикс номера сектора
	private String sectorprefixFrm=""; // Префикс номера сектора для отображения на странице
	
/**
 * Метод создания экземпляра сессионного компоненты EJB
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    regionid = keyGen.getNextKey(TablesRef.REGIONS);
    RegionAccessBean bean = new RegionAccessBean(
    /*int argRegionid,*/ regionid,
    /*int argSupregid,*/ superRegionCode.getInteger().intValue(),
    /*String argRegName,*/ regname,
    /*java.math.BigDecimal*/ sectorprefix.getBigDecimal());
    return bean;
}
/**
 * Метод, возвращающий идентификатор web-модуля
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * Метод, возвращающий экземпляр компонента EJB, содержащий данные о регионе
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {
    RegionAccessBean bean = new RegionAccessBean();
    bean.setInitKey_regionid(regionid);
    return bean;
}
/**
 * Метод возвращает идентификатор региона
 */
public int getRegionid() {
	return regionid;
}
/**
 * Метод возвращает имя региона
 */
public java.lang.String getRegname() {
	return regname;
}
/**
 * Метод возвращает префикс номера сектора региона
 */
public java.math.BigDecimal getSectorprefix() {
    return sectorprefix.getBigDecimal();
}
/**
 * Метод возвращает префикс номера сектора региона для отображения на странице
 */
public java.lang.String getSectorprefixFrm() {
	return sectorprefixFrm;
}
/**
 * Метод возвращает состояние модуля "Базовое описание позиции" для справочника регионов"
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.REGIONEDIT;
}
/**
 * Возвращеает ссылку на компонент EJB, содержащий информацию о суперрегионе.
 */
public SuperRegion getSuperregion() throws Exception {
    SuperRegionAccessBean bean = new SuperRegionAccessBean();
    bean.setInitKey_supregid(superRegionCode.getInteger().intValue());
    bean.refreshCopyHelper();

    return (SuperRegion) bean.getEJBRef();
}
/**
 * Метод вовращает наименование суперрегиона
 */
public String getSuperRegionCode() {
	return superRegionCode.getString();
}
/**
 * Метод возвращает ссылку на компонент EJB, представляющий собой
 * таблицу суперрегионов
 */
public java.util.Enumeration getSuperRegions() throws Exception {
    SuperRegionAccessBeanTable table = new SuperRegionAccessBeanTable();
    table.setSuperRegionAccessBean(
        new SuperRegionAccessBean().findAllOrderByCodeAsc());

    if (superRegionCode.isEmpty()) {
        superRegionCode.setInteger(
            new Integer(table.getSuperRegionAccessBean(0).getSupregid()));
    }

    return table.rows();
}
/**
 * Метод устанавливает значение идентификатора региона
 */
public void setRegionid(int newRegionid) {
	regionid = newRegionid;
}
/**
 * Метод устанавливает значение наименования региона
 */
public void setRegname(java.lang.String newRegname) {
	regname = newRegname;
}
/**
 * Метод устанавливает значение префикса номера сектора
 */
public void setSectorprefix(java.math.BigDecimal newSectorprefix) {
	sectorprefix.setBigDecimal(newSectorprefix);
	sectorprefixFrm=sectorprefix.getString();
}
/**
 * Метод устанавливает значение префикса номера сектора для отображения
 * на странице
 */
public void setSectorprefixFrm(java.lang.String newSectorprefixFrm) {
	sectorprefixFrm = newSectorprefixFrm;
}
/**
 * Метод устанавливает значение кода суперрегиона у ссылки на компонент EJB, 
 * содержащий информацию о суперрегионе.
 */
public void setSuperregion(SuperRegionAccessBean bean) throws Exception {
    superRegionCode.setInteger(new Integer(bean.getSupregid()));
return;
}
/**
 * Устанавливает значение наименования суперрегиона
 */
public void setSuperRegionCode(String newSuperRegionCode) {
	superRegionCode.setString(newSuperRegionCode);
}
/**
 * Метод проверки введенных пользователем данных
 */
public void validateValues(ActionErrors errors) throws Exception {

     if ((regname == null) || (regname.length() == 0))
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.empty.regionList.name"));

    try {
        sectorprefix.setString(sectorprefixFrm.trim());
        if (sectorprefix.getBigDecimal().scale() != 0||sectorprefixFrm.trim().length()>4)
            throw new NumberFormatException();
    } catch (Exception e) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.invalid.region.prefix"));
    }

    if (!errors.empty())
        throw new ValidationException();
}
}
